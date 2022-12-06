package controller;


import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class PerfilController {
	
	public Scene render() throws Exception {
        final GridPane gp = new GridPane();
        Scene scn = new Scene(gp, 900, 600);

        Button btnLogin = new Button("Aplicar");
        
        Button btnRedefinir = new Button("Redefinir Senha");
        
        Label lblNome = new Label("Nome: ");

        Label lblEmail = new Label("Email: ");
        
        Label lblEndereco = new Label("Endereco: ");

        Label lblTel = new Label("Telefone: ");
        
        Label lblSenha = new Label("Senha: ");
        TextField txtSenha = new TextField();
                      
        Image image = new Image(new FileInputStream("C:\\Users\\yan\\Desktop\\17004.png"));  
        
        ImageView imageView = new ImageView(image); 
        
        imageView.setX(50); 
        imageView.setY(25); 
        
        imageView.setFitHeight(150); 
        imageView.setFitWidth(150); 
        
        imageView.setPreserveRatio(true);          
 
        Group root = new Group(imageView);
   
        
        gp.add(root, 0, 0);
        
        gp.add(lblNome, 0,1);

        gp.add(lblEmail, 0,2);

        gp.add(lblEndereco, 0,3);

        gp.add(lblTel, 0,4);

        gp.add(lblSenha, 0,5);
        gp.add(txtSenha, 1,5);      
               
        gp.add(btnRedefinir, 1, 7);
        
        gp.add(btnLogin, 0, 12);


        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col1.setPercentWidth(15);
        col2.setPercentWidth(25);

        gp.getColumnConstraints().addAll(col1, col2);
        gp.setVgap(10);
        gp.setPadding(new Insets(15));
        
        btnRedefinir.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
        	
        	Label lblSenhaNova = new Label("Senha Nova: ");
        	TextField txtSenhaNova = new TextField();
            
            gp.add(lblSenhaNova, 0, 6);
            gp.add(txtSenhaNova, 1, 6);
                            	        	        	
        	}	   
        });
		return scn;   
    }
}
