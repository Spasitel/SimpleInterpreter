package com.jetbrains.view;

import com.jetbrains.common.ErrorInfo;
import com.jetbrains.common.Position;
import com.jetbrains.common.ProgramResult;
import com.jetbrains.controller.Controller;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.awt.*;
import java.util.List;

public class Editor extends JFrame {
    private static final SimpleAttributeSet BLACK_FONT = new SimpleAttributeSet();
    private static final SimpleAttributeSet RED_FONT = new SimpleAttributeSet();

    static {
        StyleConstants.setForeground(BLACK_FONT, Color.BLACK);
        StyleConstants.setForeground(RED_FONT, Color.RED);
    }

    private JTextPane inputPane;
    private JTextArea resultArea;
    private Controller controller;
    private final DocumentListener listener = new DocumentListener() {
        @Override
        public void removeUpdate(DocumentEvent e) {
            onInputChange();
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            onInputChange();
        }

        @Override
        public void changedUpdate(DocumentEvent arg0) {
            onInputChange();
        }
    };

    public Editor(Controller controller) throws HeadlessException {
        super("Simple interpreter");
        this.controller = controller;

        inputPane = new JTextPane();
        JScrollPane editorScrollPane = new JScrollPane(inputPane);

        StyledDocument doc = inputPane.getStyledDocument();

        doc.addDocumentListener(listener);

        resultArea = new JTextArea();
        resultArea.setBackground(Color.LIGHT_GRAY);
        JScrollPane resultScrollPane = new JScrollPane(resultArea);
        resultArea.setEditable(false);


        JSplitPane pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, editorScrollPane, resultScrollPane);

        pane.setOneTouchExpandable(true);
        pane.setDividerLocation(600);

        //Provide minimum sizes for the two components in the split pane
        Dimension minimumSize = new Dimension(100, 50);
        editorScrollPane.setMinimumSize(minimumSize);
        resultScrollPane.setMinimumSize(minimumSize);

        add(pane);

        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void onInputChange() {
        SwingUtilities.invokeLater(() -> {
            StyledDocument document = (StyledDocument) inputPane.getDocument();
            document.removeDocumentListener(listener);
            document.setCharacterAttributes(0, document.getLength() + 1, BLACK_FONT, true);
            document.addDocumentListener(listener);
            resultArea.setForeground(Color.GRAY);
        });
        SwingUtilities.invokeLater(() -> controller.onInputChange(getInputText()));
    }

    private String getInputText() {
        Document document = inputPane.getDocument();
        try {
            return document.getText(0, document.getLength());
        } catch (BadLocationException e) {
            throw new IllegalStateException(e);
        }
    }

    public void applyInterpreterResults(ProgramResult result) {
        if (result.getErrors().isEmpty()) {
            SwingUtilities.invokeLater(() -> {
                resultArea.setForeground(Color.BLACK);
                resultArea.setText(result.getOutput());
            });
        } else {
            SwingUtilities.invokeLater(() -> renderErrors(result.getErrors()));
        }
    }

    private void renderErrors(List<ErrorInfo> errors) {
        resultArea.setForeground(Color.RED);
        boolean isFirst = true;
        for (ErrorInfo errorInfo : errors) {
            if (isFirst) {
                resultArea.setText("");
                isFirst = false;
            } else {
                resultArea.append("\n");
            }

            if (errorInfo.getPosition().isPresent()) {
                renderErrorWithPosition(errorInfo.getMsg(), errorInfo.getPosition().get());
            } else {
                resultArea.append(errorInfo.getMsg());
            }
        }
    }

    private void renderErrorWithPosition(String errorMessage, Position position) {
        String text = getInputText();
        int startIndex = position.getStartIndex(text);
        if (startIndex >= text.length()) {
            resultArea.append("At EOF: " + errorMessage);
        } else {
            resultArea.append("At line " + position.getLineAndPosition(text) + " " + errorMessage);

            StyledDocument document = (StyledDocument) inputPane.getDocument();
            document.removeDocumentListener(listener);
            document.setCharacterAttributes(startIndex, position.getLength(), RED_FONT, true);
            document.addDocumentListener(listener);
        }
    }
}
