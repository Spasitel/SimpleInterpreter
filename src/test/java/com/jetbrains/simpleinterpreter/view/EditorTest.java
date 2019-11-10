package com.jetbrains.simpleinterpreter.view;

import com.jetbrains.simpleinterpreter.common.ErrorInfo;
import com.jetbrains.simpleinterpreter.common.ProgramResult;
import com.jetbrains.simpleinterpreter.controller.Controller;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EditorTest {
    private Editor frame;
    private Controller controller;
    private FrameFixture window;

    @BeforeClass
    public static void setUpOnce() {
        FailOnThreadViolationRepaintManager.install();
    }

    @Before
    public void setUp() {
        frame = GuiActionRunner.execute(() -> {
            controller = mock(Controller.class);
            return new Editor(controller);
        });
        window = new FrameFixture(frame);
    }

    @Test
    public void editorCallControllerOnChangeSuccess() {
        window.textBox("input").enterText("out 54");
        verify(controller, times(6)).onInputChange(any());
        verify(controller).onInputChange("out 54");
    }

    @Test
    public void editorShowErrorSuccess() {
        ProgramResult result = new ProgramResult();
        result.addToOutput("not show");
        result.getErrors().add(new ErrorInfo("Error to show"));
        frame.applyInterpreterResults(result);
        window.textBox("output").requireText("Error to show");
    }

    @Test
    public void editorShowOutputSuccess() {
        ProgramResult result = new ProgramResult();
        result.addToOutput("Output to show");
        frame.applyInterpreterResults(result);
        window.textBox("output").requireText("Output to show");
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }
}