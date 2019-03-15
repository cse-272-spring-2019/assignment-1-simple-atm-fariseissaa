package atm;

import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Transaction {
    
    Stage stage;
    ATM atmLogic;
    Scene scene;
    Menu menu;
    
    public Transaction(Stage stage){
        this.stage = stage;
    }
    public void prepareScene() {
        atmLogic = new ATM();
        Label label = new Label("Amount :- ");
        Label label2 = new Label();
        Button with = new Button("Withdraw");
        Button dep = new Button("Deposit");
        Button back = new Button("Return");
        TextField text = new TextField();
        GridPane grid = new GridPane();
        
        grid.add(label, 0, 0);
        grid.add(label2, 1, 2);
        grid.add(text, 1, 0);
        grid.add(with, 1, 1);
        grid.add(dep,0,1);
        grid.add(back,0,2);
        
        back.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(menu.getScene());
            }
        });
        
        dep.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String value = text.getText();
                int x = Integer.parseInt(value);
                atmLogic.deposite(x);
                label2.setText("Transaction successful");
            }
        });
        
        with.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String value = text.getText();
                int x = Integer.parseInt(value);
                if(x>atmLogic.CurrentBalance)
                {
                    label2.setText("Transaction failed,Please enter a valid ammount");
                }
                else
                {
                    atmLogic.withdraw(x);
                    label2.setText("Transaction successful");
                }                
                
            }
        });
        
        scene = new Scene(grid,500,250);
    }

    public Scene getScene() {
        return scene;
    }

    public void setAtmLogic(ATM atmLogic) {
        this.atmLogic = atmLogic;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
}

