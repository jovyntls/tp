package seedu.address.ui;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import seedu.address.model.cca.Cca;

/**
 * An UI component that displays information of a {@code Cca}.
 */
public class CcaCard extends UiPart<Region> {

    private static final String FXML = "CcaListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Cca cca;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label numPeople;
    @FXML
    private FlowPane tags;

    /**
     * Creates a {@code CcaCode} with the given {@code Cca} and index to display.
     */
    public CcaCard(Cca cca, int displayedIndex) {
        super(FXML);
        this.cca = cca;
        id.setText(displayedIndex + ". ");
        this.name.setText(cca.getName().fullName);
        this.numPeople.setText("number of ppl: 2000");

        // can consider having tags for CCAs
        Label tempLabel = new Label("music");
        tempLabel.backgroundProperty().bind(Bindings.createObjectBinding(() -> {
            BackgroundFill fill = new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY);
            return new Background(fill);
        }));
        tags.getChildren().add(tempLabel);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CcaCard)) {
            return false;
        }

        // state check
        CcaCard card = (CcaCard) other;
        return id.getText().equals(card.id.getText())
                && cca.equals(card.cca);
    }
}
