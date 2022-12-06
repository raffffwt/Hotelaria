package controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HomePageController extends Application {

	@Override
	public void start(Stage stg) throws Exception {

		GridPane gp = new GridPane();
		HBox buttonsBox = new HBox();
		Scene scn = new Scene(gp, 920, 400); 	
		
		Label lblHotel = new Label ("        HOTELARIA");
		
		Label lblQuartos = new Label ("             			  Quartos disponívels");
		
		Label lblCardapio = new Label ("                                                		     		        Cardápio//");
		
		Label lblCadastro = new Label ("                                                         											  Cadastro//");
		
		Label lblHome = new Label("Home //");
		
		Label lblServ = new Label("Nossos serviços oferecidos:  ");
				
				
		
		gp.add(lblCardapio, 0, 1);
		gp.add(lblCadastro, 0, 1);
		gp.add(lblHome, 0, 1);
		gp.add(lblHotel, 0, 0);
		gp.add(lblQuartos, 0, 1);
		gp.add(lblServ, 10, 20);
		

   
		
	 	stg.setResizable(false);
        stg.setScene(scn);
        stg.setTitle("Página inical");
        stg.show();
		
	}
	

	 public static void main(String[] args) {
			Application.launch(HomePageController.class, args);
		}

}
