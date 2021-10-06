package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.cca.Cca;
import seedu.address.model.person.Person;
import seedu.address.model.reminder.Reminder;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;
    Predicate<Cca> PREDICATE_SHOW_ALL_CCAS = unused -> true;
    Predicate<Reminder> PREDICATE_SHOW_ALL_REMINDERS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addPerson(Person person);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    void setPerson(Person target, Person editedPerson);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Returns true if a cca with the same identity as {@code cca} exists in the address book.
     */
    boolean hasCca(Cca cca);

    /**
     * Deletes the given cca.
     * The cca must exist in the address book.
     */
    void deleteCca(Cca target);

    /**
     * Adds the given cca.
     * {@code cca} must not already exist in the address book.
     */
    void addCca(Cca cca);

    /**
     * Replaces the given cca {@code target} with {@code editedCca}.
     * {@code target} must exist in the address book.
     * The cca identity of {@code editedCca} must not be the same as another existing cca in the address book.
     */
    void setCca(Cca target, Cca editedCca);

    /** Returns an unmodifiable view of the filtered cca list */
    ObservableList<Cca> getFilteredCcaList();

    /**
     * Returns true if a reminder with the same identity as {@code reminder} exists in the address book.
     */
    boolean hasReminder(Reminder reminder);

    /**
     * Deletes the given reminder.
     * The reminder must exist in the address book.
     */
    void deleteReminder(Reminder target);

    /**
     * Adds the given reminder.
     * {@code reminder} must not already exist in the address book.
     */
    void addReminder(Reminder reminder);

    /**
     * Replaces the given reminder {@code target} with {@code editedReminder}.
     * {@code target} must exist in the address book.
     * The reminder identity of {@code editedReminder} must not be the same as another existing reminder in the address book.
     */
    void setReminder(Reminder target, Reminder editedReminder);

    /** Returns an unmodifiable view of the filtered reminder list */
    ObservableList<Reminder> getFilteredReminderList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);

    /**
     * Updates the filter of the filtered cca list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredCcaList(Predicate<Cca> predicate);

    /**
     * Updates the filter of the filtered reminder list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredReminderList(Predicate<Reminder> predicate);
}
