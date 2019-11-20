package com.jetbrains.simpleinterpreter;

import com.jetbrains.simpleinterpreter.controller.Controller;
import com.jetbrains.simpleinterpreter.view.Editor;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.*;

import java.util.regex.Pattern;

public class SystemTest {
    private Controller controller;
    private FrameFixture window;

    @BeforeClass
    public static void setUpOnce() {
        FailOnThreadViolationRepaintManager.install();
    }

    public static boolean isUIControlDisable() {
        return System.getProperty("os.name").toLowerCase().contains("mac") &&
                System.getProperty("runAllGuiTests") == null;
    }

    @Before
    public void setUp() {
        Editor frame = GuiActionRunner.execute(() -> {
            controller = new Controller();
            Editor editor = new Editor(controller);
            controller.setView(editor);
            return editor;
        });
        window = new FrameFixture(frame);
    }

    @Test
    public void editorShowOutputSuccess() throws InterruptedException {
        Assume.assumeFalse(isUIControlDisable());
        window.textBox("input").enterText("var x=42 out x");
        Thread.sleep(3000);
        window.textBox("output").requireText("42.0");
    }

    @Test
    public void editorShowErrorSuccess() throws InterruptedException {
        Assume.assumeFalse(isUIControlDisable());
        window.textBox("input").enterText("incorrect input");
        Thread.sleep(3000);
        window.textBox("output").requireText(Pattern.compile("Error at line 1:1 .*"));
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }
}
