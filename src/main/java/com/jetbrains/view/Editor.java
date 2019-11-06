package com.jetbrains.view;

import com.jetbrains.common.ErrorInfo;
import com.jetbrains.common.Position;
import com.jetbrains.common.ProgramResult;
import com.jetbrains.controller.Controller;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

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
            document.setCharacterAttributes(0, document.getLength() + 1, BLACK_FONT, false);
            document.addDocumentListener(listener);
            resultArea.setForeground(Color.GRAY);
        });

        controller.onInputChange();
    }

    public String getInputText() {
        return inputPane.getText();
    }

    public void applyInterpreterResults(ProgramResult result) {
        if (result.getErrors().isEmpty()) {
            SwingUtilities.invokeLater(() -> {
                resultArea.setForeground(Color.BLACK);
                resultArea.setText(result.getOutput());
            });
        } else {
            SwingUtilities.invokeLater(() -> {
                resultArea.setForeground(Color.RED);
                boolean isFirst = true;
                for (ErrorInfo errorInfo : result.getErrors()) {
                    if (isFirst) {
                        resultArea.setText("");
                        isFirst = false;
                    } else {
                        resultArea.append("\n");
                    }

                    if (errorInfo.getPosition().isPresent()) {
                        Position position = errorInfo.getPosition().get();
                        String text = inputPane.getText();
                        int startIndex = position.getStartIndex(text);
                        resultArea.append("line " + position.getLine(text) + ":" +
                                startIndex + " " + errorInfo.getMsg());

                        StyledDocument document = (StyledDocument) inputPane.getDocument();
                        document.removeDocumentListener(listener);
                        document.setCharacterAttributes(startIndex, position.getLength(), RED_FONT, false);
                        document.addDocumentListener(listener);
                    } else {
                        resultArea.append(errorInfo.getMsg());
                    }
                }
            });
        }
    }


}
