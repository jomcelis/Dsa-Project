package User_Hompage;

import com.example.dsa_final.Main;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReservationBooking {


    private MainQueue mainQueue;
    private static final String filePath = "C:\\Users\\Lenovo\\Desktop\\BST\\Dsa_final\\src\\Customers\\customer_data.txt";


    public ReservationBooking() {
    }

    public ReservationBooking(MainQueue mainQueue) {
        this.mainQueue = mainQueue;
    }
    private final String[] choices ={"General check up","Tooth Extraction","ramen","X-Ray", "Consultation"};

    public String date;

    @FXML
    public Button BookBtn;

    @FXML
    public ChoiceBox<String> DropDownBtn;


    @FXML
    private Button backBtn;

    @FXML
    private RadioButton elevenAm;

    @FXML
    private RadioButton nineAm;

    @FXML
    private RadioButton onePM;

    @FXML
    private RadioButton tenAm;

    @FXML
    private RadioButton threePM;

    @FXML
    private RadioButton twoPM;


    @FXML
    private TextField inputAge;

    @FXML
    private TextField inputLastName;

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputNumber;

    //Action Buttons

    @FXML
    private void initialize() {
        // Initialize the mainQueue here or obtain it from another source.
        mainQueue = new MainQueue(); // Replace this with your actual initialization code.

        // Add a listener to capture the selected date when a radio button is clicked.
        ToggleGroup dateToggleGroup = new ToggleGroup();
        nineAm.setToggleGroup(dateToggleGroup);
        tenAm.setToggleGroup(dateToggleGroup);
        elevenAm.setToggleGroup(dateToggleGroup);

        onePM.setToggleGroup(dateToggleGroup);
        twoPM.setToggleGroup(dateToggleGroup);
        threePM.setToggleGroup(dateToggleGroup);

        dateToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (dateToggleGroup.getSelectedToggle() != null) {
                date = dateToggleGroup.getSelectedToggle().getUserData().toString();
            }
        });

        // Set user data for radio buttons to store the date.
        nineAm.setUserData("9:00 AM");
        tenAm.setUserData("10:00 AM");
        elevenAm.setUserData("11:00 AM");

        onePM.setUserData("1:00 PM");
        twoPM.setUserData("2:00 PM");
        threePM.setUserData("3:00 PM");

        DropDownBtn.setItems(FXCollections.observableArrayList(choices));
    }


    @FXML
    void DropDownBtn_Click(MouseEvent event) {
    }

    @FXML
    void BookBtn_Click(ActionEvent event) {
        createFolder();
        addData(inputName.getText(), inputLastName.getText(), inputAge.getText(), inputNumber.getText(), date , DropDownBtn.getValue());
    }

    @FXML
    void backBtn_Click(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("UserHomepage.fxml");
    }


    @FXML
    private void createReservationBooking() {
        // Create an instance of ReservationBooking and pass the MainQueue instance.
        ReservationBooking reservationBooking = new ReservationBooking(mainQueue);
        // Add it to your UI, e.g., using a layout pane or as needed.
    }

    @FXML
    void inputAgeAction(ActionEvent event) {

    }

    @FXML
    void inputLastNameAction(ActionEvent event) {

    }

    @FXML
    void inputNameAction(ActionEvent event) {

    }

    @FXML
    void inputNumberAction(ActionEvent event) {

    }


    @FXML
    void nineAm_Action(ActionEvent event) {

    }

    @FXML
    void onePM_Action(ActionEvent event) {

    }

    @FXML
    void tenAm_Action(ActionEvent event) {

    }

    @FXML
    void threePM_Action(ActionEvent event) {

    }

    @FXML
    void twoPM_Action(ActionEvent event) {

    }

    @FXML
    void elevenAm_Action(ActionEvent event) {

    }

    void addData(String name, String lastName, String age, String contactNumber, String date , String reason) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(name + ",");
            writer.write(lastName + ",");
            writer.write(contactNumber + ",");
            writer.write(date + ",");
            writer.write(reason + "\r\n");
        } catch (IOException ex) {
            ex.printStackTrace(); // Handle or log the exception properly
        }
    }

    void createFolder() {
        File fileDirectory = new File("C:\\Users\\Lenovo\\Desktop\\BST\\Dsa_final\\src\\Customers");
        if (!fileDirectory.exists()) {
            fileDirectory.mkdirs();
        }
    }


    }