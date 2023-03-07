package mycelium.mycelium.ui.project;

import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import mycelium.mycelium.ui.common.UiPart;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class ProjectListCard extends UiPart<Region> {

    private static final String FXML = "ProjectListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Project project;

    @FXML
    private Label id;
    @FXML
    private Label name;
    @FXML
    private Label status;
    @FXML
    private Label email;
    @FXML
    private Label source;
    @FXML
    private Label description;
    @FXML
    private Label acceptedOn;
    @FXML
    private Label deadline;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public ProjectListCard(Project p, int displayedIndex) {
        super(FXML);
        project = p;
        id.setText(displayedIndex + ". ");
        name.setText(p.name);
        status.setText(p.status.toString());
        email.setText(p.clientEmail.toString());
        source.setText(p.source);
        description.setText(p.description);
        acceptedOn.setText(p.acceptedOn.toString());
        deadline.setText(p.deadline.map(Date::toString).orElse("No Deadline"));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ProjectListCard)) {
            return false;
        }

        // state check
        ProjectListCard card = (ProjectListCard) other;
        return id.getText().equals(card.id.getText())
            && project.equals(card.project);
    }
}