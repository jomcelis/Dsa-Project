
package com.example.dsa_final;

//import Database.conn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HelloController {
    @FXML
    public TextField SignIn_Username;

    @FXML
    public TextField SignIn_Password;

    @FXML
    public Button SignIn_Button;




    public void SignInBtn_Click(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("UserHomepage.fxml");
    }
/*
    public void validateLogin(){
        Main m = new Main();
        conn con = new conn();
        Connection connectDB = con.getConnection();

        String username = SignIn_Username.getText();
        String password = SignIn_Password.getText();

        String sql = "select * from dentalapp.clients where Username='"+username+"' and Password='"+password+"'";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Success!");
                m.changeScene("UserHomepage.fxml");
            }else{
                JOptionPane.showMessageDialog(null, "Wrong username/password!");
                SignIn_Button.setText("");
                SignIn_Password.setText("");
            }
            connectDB.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

 */
}
