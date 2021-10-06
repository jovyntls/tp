package seedu.address.logic.commands.reminder;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.reminder.Reminder;

/**
 * Adds a reminder to the address book.
 */
public class ReminderAddCommand extends Command {

    public static final String COMMAND_WORD = "addr";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a reminder to the address book. "
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "EXCO meeting ";

    public static final String MESSAGE_SUCCESS = "New reminder added: %1$s";
    public static final String reminder = "This reminder already exists in the address book";

    private final Reminder toAdd;

    /**
     * Creates an ReminderAddCommand to add the specified {@code Reminder}
     */
    public ReminderAddCommand(Reminder reminder) {
        requireNonNull(reminder);
        toAdd = reminder;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasReminder(toAdd)) {
            throw new CommandException(reminder);
        }

        model.addReminder(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ReminderAddCommand // instanceof handles nulls
                && toAdd.equals(((ReminderAddCommand) other).toAdd));
    }
}
