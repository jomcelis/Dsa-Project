package User_Hompage;

import com.example.dsa_final.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javax.swing.*;
import java.io.IOException;


public class UserHomepage {
    @FXML
    public Button UsrHompage_Reservation;
    @FXML
    public Button UsrHompage_ReservationDtls;

    public void UsrHompage_ReservationBtn(ActionEvent event) throws IOException {
        Main m = new Main();
        //JOptionPane.showMessageDialog(null, "Success!");
        m.changeScene("ReservationBooking.fxml");
    }

    public void UsrHompage_ReservationDtlsBtn(ActionEvent event) throws IOException {
        Main m = new Main();
        JOptionPane.showMessageDialog(null,"Success!");
        m.changeScene("MainQueue.fxml");
    }

}