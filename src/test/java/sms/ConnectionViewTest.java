package sms;

import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConnectionViewTest {

    private FrameFixture connectionFrame;

    @Before
    public void setUp() {
        ConnectionView frame = GuiActionRunner.execute(new GuiQuery<ConnectionView>() {
            @Override
            protected ConnectionView executeInEDT() {
                return new ConnectionView();
            }
        });
        connectionFrame = new FrameFixture(frame);
        connectionFrame.show();
    }

    @After
    public void tearDown() {
        if (connectionFrame != null) {
            connectionFrame.cleanUp();
        }
    }

    @Test
    public void emptyFieldsTest() {
        connectionFrame.button("connectButton").click();
        connectionFrame.optionPane().requireErrorMessage()
                .requireMessage("Please fill in all the empty fields!");
    }

    @Test
    public void wrongDatabaseUrl() {
        connectionFrame.textBox("loginField").enterText("root");
        connectionFrame.textBox("passwordField").enterText("simplepassword123");
        connectionFrame.textBox("databaseUrlField").setText("dawgfaea");
        connectionFrame.button("connectButton").click();
        connectionFrame.optionPane().requireErrorMessage()
                .requireMessage("Connection with the database hasn't been established!\nPlease check your credentials!");
    }

    @Test
    public void correctCredentials() {
        connectionFrame.textBox("loginField").enterText("root");
        connectionFrame.button("connectButton").click();
        connectionFrame.optionPane()
                .requireMessage("Connection with the database has been successfully established!");
    }
}
