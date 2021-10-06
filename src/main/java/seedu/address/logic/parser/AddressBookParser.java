package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.GreetCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.cca.CcaAddCommand;
import seedu.address.logic.commands.person.PersonAddCommand;
import seedu.address.logic.commands.person.PersonDeleteCommand;
import seedu.address.logic.commands.person.PersonEditCommand;
import seedu.address.logic.commands.person.PersonFindCommand;
import seedu.address.logic.commands.reminder.ReminderAddCommand;
import seedu.address.logic.parser.cca.CcaAddCommandParser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.person.PersonAddCommandParser;
import seedu.address.logic.parser.person.PersonDeleteCommandParser;
import seedu.address.logic.parser.person.PersonEditCommandParser;
import seedu.address.logic.parser.person.PersonFindCommandParser;
import seedu.address.logic.parser.reminder.ReminderAddCommandParser;


/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case PersonAddCommand.COMMAND_WORD:
            return new PersonAddCommandParser().parse(arguments);

        case PersonEditCommand.COMMAND_WORD:
            return new PersonEditCommandParser().parse(arguments);

        case PersonDeleteCommand.COMMAND_WORD:
            return new PersonDeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case PersonFindCommand.COMMAND_WORD:
            return new PersonFindCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case GreetCommand.COMMAND_WORD:
            return new GreetCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case CcaAddCommand.COMMAND_WORD:
            return new CcaAddCommandParser().parse(arguments);

        case ReminderAddCommand.COMMAND_WORD:
            return new ReminderAddCommandParser().parse(arguments);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
