package controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class QuartosDispo extends Application {
	@Override
	public void start(final Stage stag) throws Exception {
        GridPane gp = new GridPane();
        HBox buttonsBox = new HBox();
        Scene scn = new Scene(gp, 900, 400);
       
 //DECLARAÇÃO DAS LABELS E BOTÕES                                                  
        
        Button btnReservar = new Button("Reservar");
        Label lblSuite1 = new Label("Suite Luxo ");
        Label lblSuitedesc1 = new Label("Quarto: 000 ");
        Label lblSuiteprc1 = new Label("Diaria: $$$ ");
        
        
        Button btnReservar2 = new Button("Reservar");
        Label lblSuite2 = new Label("Suite Simples ");
        Label lblSuitedesc2 = new Label("Quarto: 000 ");
        Label lblSuiteprc2 = new Label("Diaria: $$$ ");
        
        
        Button btnReservar3 = new Button("Reservar");
        Label lblSuite3 = new Label("Suite Luxo ");
        Label lblSuitedesc3 = new Label("Quarto: 000 ");
        Label lblSuiteprc3 = new Label("Diaria: $$$ ");
        
        
        Button btnReservar4 = new Button("Reservar");
        Label lblSuite4 = new Label("Suite Simples");
        Label lblSuitedesc4 = new Label("Quarto: 000 ");
        Label lblSuiteprc4 = new Label("Diaria: $$$ ");

        

//COLOCANDO OS TEXTOS E BOTÕES NA TELA
        //LABELS E BOTÕES 
        gp.add(lblSuite1, 2,1);
        gp.add(lblSuitedesc1, 2,3);
        gp.add(lblSuiteprc1, 2,4);
        gp.add(buttonsBox, 2, 6);
        
        //LABELS E BOTÕES 
        gp.add(lblSuite2,  1,1);
        gp.add(lblSuitedesc2,  1,3);
        gp.add(lblSuiteprc2,  1,4);
        gp.add(btnReservar2, 1, 6);
        
        //LABELS E BOTÕES 
        gp.add(lblSuite3, 1,11);
        gp.add(lblSuitedesc3, 1,13);
        gp.add(lblSuiteprc3, 1,14);
        gp.add(btnReservar3,  1, 16);
        
        //LABELS E BOTÕES 
        gp.add(lblSuite4, 2,11);
        gp.add(lblSuitedesc4, 2,13);                   
        gp.add(lblSuiteprc4, 2,14);
        gp.add(btnReservar4, 2, 16);

        buttonsBox.getChildren().addAll(btnReservar);

        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col1.setPercentWidth(15);
        col2.setPercentWidth(50);

        gp.getColumnConstraints().addAll(col1, col2);
        gp.setVgap(10);
        gp.setPadding(new Insets(15));

        stag.setResizable(false);
        stag.setScene(scn);
        stag.setTitle("Quartos Hotelaria");
        stag.show();
        
        btnReservar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	stag.setTitle(" Reservar Quarto");
            }
        });
        btnReservar2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	stag.setTitle(" Reservar Quarto");
            }
        });
        btnReservar3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	stag.setTitle(" Reservar Quarto");
            }
        });
        btnReservar4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	stag.setTitle(" Reservar Quarto");
            }
        });
    }
	
    
    
    
    public static void main(String[] args) {
		Application.launch(QuartosDispo.class, args);
	}
}