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

public class Menu {
    
    Stage stage;
    ATM atmLogic;
    Scene scene;
    Login login;
    Transaction trans;
    
    public Menu(Stage stage){
        this.stage = stage;
    }

    public void prepareScene() {
        atmLogic = new ATM();
        Button trans1 = new Button("Transaction");
        Button next = new Button("Next");
        Button prev = new Button("Previous");
        Button current = new Button("Current balance");
        Label label = new Label();
        GridPane grid = new GridPane();
        
        grid.add(label,1,1);
        grid.add(trans1,0,0);
        grid.add(current,1,0);
        grid.add(next,3,0);
        grid.add(prev,2,0);
        
        
        current.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                int y = atmLogic.CurrentBalance;
                label.setText(""+y);
            }
        });
        
        prev.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) 
            {
                if(atmLogic.p==0||atmLogic.c-atmLogic.p>5)
                {
                    label.setText("Sorry can't do that command");
                }
                else
                {
                    label.setText(atmLogic.prev());
                }
            }
        });
        
        next.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) 
            {
                if(atmLogic.p>atmLogic.c||atmLogic.c-atmLogic.p>6)
                {
                    label.setText("Sorry can't do that command");
                }
                else
                {
                    label.setText(atmLogic.next());
                }
            }
        });
        
                
        trans1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(trans.getScene());
            }
        });
         
        
                        
        
        
        
        scene = new Scene(grid,500,250);
    
}

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void setTrans(Transaction trans) {
        this.trans = trans;
    }
    

    public void setAtmLogic(ATM atmLogic) {
        this.atmLogic = atmLogic;
    }
    
    
}
   
