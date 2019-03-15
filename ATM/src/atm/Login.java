package atm;

import java.awt.Desktop.Action;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login {
    
    Stage stage;
    ATM atmLogic;
    Menu menu;
    Scene scene;
    
    public Login(Stage stage){
        this.stage = stage;
    }

    public void prepareScene() {
        atmLogic = new ATM();
        PasswordField pass = new PasswordField();
        Label label = new Label("User's ID");
        Button login = new Button("Login");
        Label valid2 = new Label();
        GridPane grid = new GridPane();
        grid.add(label,0,0);
        grid.add(pass,1,0);
        grid.add(valid2,1,2);
        grid.add(login,1,1);
        
        login.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String value = pass.getText();
                if(atmLogic.valid(value)){
                    stage.setScene(menu.getScene());
                }
                else
                    valid2.setText("Please enter the correct ID");
                     
            }
        });
        
        
        scene = new Scene(grid,500,250);
                }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return scene;
    }
    
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    

    public void setAtmLogic(ATM atmLogic) {
        this.atmLogic = atmLogic;
    }

}
                