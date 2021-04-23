package Controller;

import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ConnexionController {
	@FXML private AnchorPane rootPane;

	public void OnConnexion(ActionEvent actionEvent) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) rootPane.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
}