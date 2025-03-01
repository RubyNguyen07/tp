package mycelium.mycelium.logic.commands;

import static mycelium.mycelium.logic.commands.CommandTestUtil.assertCommandSuccess;
import static mycelium.mycelium.logic.commands.ExitCommand.MESSAGE_EXIT_ACKNOWLEDGEMENT;

import org.junit.jupiter.api.Test;

import mycelium.mycelium.logic.uiaction.ExitAction;
import mycelium.mycelium.model.Model;
import mycelium.mycelium.model.ModelManager;

public class ExitCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_exit_success() {
        CommandResult expectedCommandResult = new CommandResult(MESSAGE_EXIT_ACKNOWLEDGEMENT, new ExitAction());
        assertCommandSuccess(new ExitCommand(), model, expectedCommandResult, expectedModel);
    }
}
