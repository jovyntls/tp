package seedu.address.logic.commands.cca;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CCA_ID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PERSON_ID;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.cca.Cca;
import seedu.address.model.cca.Cid;
import seedu.address.model.person.Person;
import seedu.address.model.person.Pid;

public class CcaEnrolCommand extends Command {

    public static final String COMMAND_WORD = "enrol";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Enrols a person into a CCA. "
            + "Parameters: "
            + PREFIX_CCA_ID + "CCA_ID "
            + PREFIX_PERSON_ID + "CCA_ID \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_CCA_ID + "1 "
            + PREFIX_PERSON_ID + "1 ";

    public static final String MESSAGE_SUCCESS = "Successfully enrolled %1$s into %2$s";
    public static final String MESSAGE_MISSING_CCA = "This CCA does not exist in the address book";
    public static final String MESSAGE_MISSING_PERSON = "This person does not exist in the address book";
    public static final String MESSAGE_PRESENT_PERSON = "This person(%1$s) is already part of that CCA(%2$s)";

    private Cca ccaToEnrolInto;
    private final int cid;
    private Person personToEnrol;
    private final int pid;

    /**
     * Creates an CcaAddCommand to add the specified {@code Cca}
     */
    public CcaEnrolCommand(Cid cid, Pid pid) {
        this.cid = Integer.parseInt(cid.toString());
        this.pid = Integer.parseInt(pid.toString());
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        this.ccaToEnrolInto = model.findCcaFromCid(cid);
        this.personToEnrol = model.findPersonFromPid(pid);

        if (ccaToEnrolInto == null) {
            throw new CommandException(MESSAGE_MISSING_CCA);
        }

        if (personToEnrol == null) {
            throw new CommandException(MESSAGE_MISSING_PERSON);
        }

        boolean success = model.enrolPersonIntoCca(ccaToEnrolInto, personToEnrol);
        if (success) {
            return new CommandResult(String.format(MESSAGE_SUCCESS, personToEnrol.getName(), ccaToEnrolInto.getName()));
        } else {
            throw new CommandException(
                    String.format(MESSAGE_PRESENT_PERSON, personToEnrol.getName(), ccaToEnrolInto.getName()));
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CcaEnrolCommand // instanceof handles nulls
                && ccaToEnrolInto.equals(((CcaEnrolCommand) other).ccaToEnrolInto)
                && personToEnrol.equals(((CcaEnrolCommand) other).personToEnrol));
    }
}
