package controller;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
		
		Label lblHotel = new Label ("HOTELARIA");
		
		Button btnQuartos = new Button(" Quartos disponíveis ");
		
		Button btnCardapio = new Button (" Cardápio //");
		
		Button btnCadastro = new Button (" Cadastro //");
		
		Button btnHome = new Button(" Home // ");
		
		Label lblServi = new Label("Serviços oferecidos: ");
		
		Label lblWifi = new Label ("Wifi nos quartos");
		
		Label lblAr = new Label("Quartos com ar condicionado");
		
		Label lblCafe = new Label("Café da manhã incluso");
		
		Label lblAlmoco = new Label("Almoço opcional");
				
		
		gp.add(btnCardapio, 4, 1);
		gp.add(btnCadastro, 6, 1);
		gp.add(btnHome, 2, 1);
		gp.add(lblHotel, 0, 0);
		gp.add(btnQuartos, 8, 1);
		gp.add(lblServi, 8, 8);
		gp.add(lblWifi, 4 , 20);
		gp.add(lblAr,12, 20);
		gp.add(lblCafe, 4, 22);
		gp.add(lblAlmoco, 12, 22);

   
		
	 	stg.setResizable(false);
        stg.setScene(scn);
        stg.setTitle("Página inical");
        stg.show();
        
        
   Image image = new Image(new FileInputStream("C:\\Users\\olive\\Pictures\\hotelzinho.jpg"));  
        
        ImageView imageView = new ImageView(image); 
        
        imageView.setX(100); 
        imageView.setY(50); 
        
        imageView.setFitHeight(600); 
        imageView.setFitWidth(300); 
        
        //Setting the preserve ratio of the image view 
        imageView.setPreserveRatio(true);  
        
        //Creating a Group object  
        Group root = new Group(imageView);  
        
        
        gp.add(root, 25, 50);
        
        
        
 Image image2 = new Image(new FileInputStream("C:\\Users\\olive\\Pictures\\quarto.jpg"));  
        
        ImageView imageView2 = new ImageView(image2); 
        
        imageView2.setX(100); 
        imageView2.setY(50); 
        
        imageView2.setFitHeight(600); 
        imageView2.setFitWidth(300); 
        
        //Setting the preserve ratio of the image view 
        imageView.setPreserveRatio(true);  
        
        //Creating a Group object  
        Group root2 = new Group(imageView);  
        
        
        gp.add(root2, 10, 30);
        

		
	}
	

	 public static void main(String[] args) {
			Application.launch(HomePageController.class, args);
		}

}
