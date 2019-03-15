package atm;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ATMGui extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ATM");
        
        Login login = new Login(primaryStage);
        Menu menu = new Menu(primaryStage);
        Transaction trans = new Transaction(primaryStage);
        
        login.prepareScene();
        menu.prepareScene();
        trans.prepareScene();
        
        login.setMenu(menu);
        menu.setLogin(login);
        menu.setTrans(trans);
        trans.setMenu(menu);
        
        primaryStage.setScene(login.getScene());
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
