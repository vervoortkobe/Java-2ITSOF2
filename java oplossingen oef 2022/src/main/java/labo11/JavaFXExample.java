package labo11;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFXExample extends Application {

    @Override
    public void init() {
        // By default this does nothing, but it
        // can carry out code to set up your app.
        // It runs once before the start method,
        // and after the constructor.
        System.out.println("Booting World!");
    }
    @Override
    public void start(Stage primaryStage) throws Exception {


        drawForm(primaryStage);

    }

    public void drawForm(Stage stage) {
        // Label for name
        Text nameLabel = new Text("Lastname");

        Text firstNameLabel = new Text("Firstname");
        Text tierLabel = new Text("Subscription tier");
        // Text field for name
        TextField nameText = new TextField();
        TextField firstName = new TextField();
        TextField dobField = new TextField();
        // Label for date of birth
        Text dobLabel = new Text("Date of birth");

        // date picker to choose date
        DatePicker datePicker = new DatePicker();

        // Label for gender
        Text genderLabel = new Text("gender");

        Text averagePagesText = new Text("Average pages a day");
        // Toggle group of radio buttons
        ToggleGroup groupGender = new ToggleGroup();
        RadioButton maleRadio = new RadioButton("male");
        maleRadio.setToggleGroup(groupGender);
        RadioButton femaleRadio = new RadioButton("female");
        femaleRadio.setToggleGroup(groupGender);

        ToggleGroup groupTier = new ToggleGroup();
        RadioButton bronzeRadioButton = new RadioButton("bronze");
        RadioButton silveRadioButton = new RadioButton("silver");
        RadioButton goldRadioButton = new RadioButton("gold");
        bronzeRadioButton.setToggleGroup(groupTier);
        silveRadioButton.setToggleGroup(groupTier);
        goldRadioButton.setToggleGroup(groupTier);

        // list View for educational qualification
        ChoiceBox preferencesChoiceBox = new ChoiceBox();
        preferencesChoiceBox .getItems().addAll("Thriller", "Romance","Horror");
        // Creating a Grid Pane
        GridPane gridPane = new GridPane();
        // Setting size for the pane
        gridPane.setMinSize(500, 500);
        // Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        // Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        // Setting the Grid alignment
        gridPane.setAlignment(Pos.CENTER);
        // Arranging all the nodes in the grid
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(firstNameLabel, 0, 1);
        gridPane.add(nameText, 1, 0);
        gridPane.add(genderLabel, 0, 2);
        gridPane.add(maleRadio, 1, 2);
        gridPane.add(femaleRadio, 2, 2);
        gridPane.add(averagePagesText, 0, 3);
        gridPane.add(dobLabel, 0, 4);
        gridPane.add(datePicker, 1, 4);
        gridPane.add(firstName, 1, 1);
        gridPane.add(dobField, 1, 3);
        gridPane.add(tierLabel, 0, 5);
        gridPane.add(bronzeRadioButton, 1, 5);
        gridPane.add(silveRadioButton, 2, 5);
        gridPane.add(goldRadioButton, 3, 5);
        gridPane.add(preferencesChoiceBox, 0, 6);


        tierLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        averagePagesText.setStyle("-fx-font: normal bold 15px 'serif' ");
        nameLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        firstNameLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        dobLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        genderLabel.setStyle("-fx-font: normal bold 15px 'serif' ");

        // Setting the back ground color
        gridPane.setStyle("-fx-background-color: BEIGE;");

        // Creating a scene object
        Scene scene = new Scene(gridPane);



        // Adding scene to the stage
        stage.setScene(scene);

        // Displaying the contents of the stage
        stage.show();
    }
    public static void main(String args[])
    {
        launch(args);
    }
}
