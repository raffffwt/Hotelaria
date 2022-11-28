package controller;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ReservarController extends Application {
	@Override
	public void start(Stage stg) throws Exception {
        GridPane gp = new GridPane();
        HBox buttonsBox = new HBox();
        Scene scn = new Scene(gp, 900, 400);

        Button btnLogin = new Button("Reservar");
        
        Label lblNome = new Label("Hotel");
        Image image = new Image(new FileInputStream("C:\\Users\\DESKTOP\\Desktop\\Area de trabalho\\Imagens foda\\Capturar.png"));  
        
        ImageView imageView = new ImageView(image); 
        
        imageView.setX(50); 
        imageView.setY(25); 
        
        imageView.setFitHeight(300); 
        imageView.setFitWidth(150); 
        
        //Setting the preserve ratio of the image view 
        imageView.setPreserveRatio(true);  
        
        //Creating a Group object  
        Group root = new Group(imageView);  
        
        gp.add(lblNome, 1,1);
        gp.add(root, 1, 3);
        
        Label lblSuite = new Label("Suite | Quarto numero 3");
        gp.add(lblSuite, 1,5);
        
        Label lblDescricao = new Label("Descricao: Quarto com duas camas e um banheiro");
        gp.add(lblDescricao, 1,6);
        
        Label lblData = new Label("Data inicio: 15/10/22 | Data de entrega: 25/11/22");
        gp.add(lblData, 1,7);
        
        Label lblValor = new Label("Valor: R$1500,00");
        gp.add(lblValor, 1,8);
        gp.add(buttonsBox, 0, 13);
       
        buttonsBox.getChildren().addAll(btnLogin);

        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col1.setPercentWidth(15);
        col2.setPercentWidth(50);

        gp.getColumnConstraints().addAll(col1, col2);
        gp.setVgap(10);
        gp.setPadding(new Insets(15));

        stg.setResizable(false);
        stg.setScene(scn);
        stg.setTitle("Hotelaria");
        stg.show();
        
        btnLogin.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	stg.setTitle("Quarto Reservado");
            }
        });
        
    }
    
    public static void main(String[] args) {
		Application.launch(ReservarController.class, args);
	}
}
