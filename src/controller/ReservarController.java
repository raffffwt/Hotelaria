package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
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
import model.Quarto;
import repository.QuartoRepository;
import repository.ReservaRepository;

public class ReservarController {
	Quarto currentQuarto = new Quarto();

	public ReservarController(int quartoId) {
		QuartoRepository quartoRepo = new QuartoRepository();
		
		currentQuarto = quartoRepo.findQuartoById(quartoId);
	}
	
	public Scene render(Stage stagePrincipal, Scene cenaPrincipal) throws FileNotFoundException {
		GridPane gp = new GridPane();
        HBox buttonsBox = new HBox();
        Scene scn = new Scene(gp, 900, 400);

        Button btnReservar = new Button("Reservar");
        
        Label lblNome = new Label("Hotel");
        Image image = new Image(new FileInputStream("C:\\Users\\DESKTOP\\Code\\Hotelaria\\src\\source\\carlospilotto3.jpg"));  
        
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
        
        Label lblSuite = new Label(currentQuarto.getTipo());
        gp.add(lblSuite, 1,5);
        
        Label lblDescricao = new Label(currentQuarto.descricao);
        gp.add(lblDescricao, 1,6);
        
        Label lblData = new Label("Data inicio: 8/10/22 | Data de entrega: 25/10/22");
        gp.add(lblData, 1,7);
        
        Label lblValor = new Label("Valor: R$" + currentQuarto.getValor().toString().replace('.', ',') + "0");
        gp.add(lblValor, 1,8);
        gp.add(buttonsBox, 0, 11);
       
        buttonsBox.getChildren().addAll(btnReservar);

        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col1.setPercentWidth(15);
        col2.setPercentWidth(50);

        gp.getColumnConstraints().addAll(col1, col2);
        gp.setVgap(10);
        gp.setPadding(new Insets(15));
        
        btnReservar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	ReservaRepository reserva = new ReservaRepository();
            	reserva.ReservarQuarto(currentQuarto.getId());
            	stagePrincipal.close();
            	stagePrincipal.setScene(cenaPrincipal);
            	
            	stagePrincipal.show();
            }
        });
        
		return scn;
        
	}
}
