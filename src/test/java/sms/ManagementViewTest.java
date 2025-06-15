package sms;

import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.testing.FestSwingTestCaseTemplate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class ManagementViewTest {
    private FrameFixture managementFrame;

    @BeforeEach
    public void setUp() {
        // Create GUI in EDT
        SwingUtilities.invokeLater(() -> {
            ManagementView view = new ManagementView();
            managementFrame = new FrameFixture(view);
            managementFrame.show(); // show() is necessary
        });
    }

    @AfterEach
    public void tearDown() {
        managementFrame.cleanUp();
    }

    @Test
    public void testWindowOpensSuccessfully() {
        managementFrame.requireVisible();
    }

    // Add more interaction tests here
}
