package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.*;

import seedu.address.model.Model;

/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all persons, CCAs and reminders";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        model.updateFilteredCcaList(PREDICATE_SHOW_ALL_CCAS);
        model.updateFilteredReminderList(PREDICATE_SHOW_ALL_REMINDERS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
