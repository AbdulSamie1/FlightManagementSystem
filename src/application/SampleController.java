package application;

import java.sql.SQLException;

import bussinesslogic.user;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SampleController {

    @FXML
    private Button btnCSignUp;

    @FXML
    private Button btnForgetPassword;

    @FXML
    private Button btnLogIn;

    @FXML
    private TextField getLogInEmail;

    @FXML
    private TextField getLogInPassword;

    @FXML
    void checkLogIn(ActionEvent event) throws ClassNotFoundException, SQLException {
    	String email =  getLogInEmail.getText();
    	String password = getLogInPassword.getText();
    	user u = new user(email,password);
    	boolean chk = u.checkUser();
    	if(chk == true) {
    		
    		
    	}
    	else {
    		System.out.println("False");
    	}
    }

    @FXML
    void resetPassword(ActionEvent event) {
    	System.out.println("Output");
    }

    @FXML
    void signUpScreen(ActionEvent event) {
    	
    }

}