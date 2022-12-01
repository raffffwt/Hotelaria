package controller;

import java.io.FileNotFoundException;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Quarto;
import repository.QuartoRepository;

public class QuartosDispo extends Application {
	public List<Quarto> listaQuartos;
	private BorderPane bp;
	
	public QuartosDispo() {
        QuartoRepository quartoRepo = new QuartoRepository();
        
        listaQuartos = quartoRepo.findAllQuartos();
	}
	@Override
	public void start(final Stage stag) throws Exception {
		bp = new BorderPane();
        GridPane gp = new GridPane();
        HBox buttonsBox = new HBox();
        Scene scn = new Scene(gp, 900, 400);
       
 //DECLARAÇÃO DAS LABELS E BOTÕES                                                  
        
        Button btnCadastrar = new Button("Reservar");
        Label lblSuite1 = new Label(listaQuartos.get(0).getTipo());
        Label lblSuitedesc1 = new Label(listaQuartos.get(0).getDescricao());
        Label lblSuiteprc1 = new Label(listaQuartos.get(0).getValor().toString());
        Label lblOcupado1 = new Label(listaQuartos.get(0).isReservado ? "Sim" : "Nao");
       
        
        Button btnCadastrar2 = new Button("Reservar");
        Label lblSuite2 = new Label(listaQuartos.get(1).getTipo());
        Label lblSuitedesc2 = new Label(listaQuartos.get(1).getDescricao());
        Label lblSuiteprc2 = new Label(listaQuartos.get(1).getValor().toString());
        Label lblOcupado2 = new Label(listaQuartos.get(1).isReservado ? "Sim" : "Nao");
        
        
        Button btnCadastrar3 = new Button("Reservar");
        Label lblSuite3 = new Label(listaQuartos.get(2).getTipo());
        Label lblSuitedesc3 = new Label(listaQuartos.get(2).getDescricao());
        Label lblSuiteprc3 = new Label(listaQuartos.get(2).getValor().toString());
        Label lblOcupado3 = new Label(listaQuartos.get(2).isReservado ? "Sim" : "Nao");
        
        
        Button btnCadastrar4 = new Button("Reservar");
        Label lblSuite4 = new Label(listaQuartos.get(3).getTipo());
        Label lblSuitedesc4 = new Label(listaQuartos.get(3).descricao);
        Label lblSuiteprc4 = new Label(listaQuartos.get(3).valor.toString());
        Label lblOcupado4 = new Label(listaQuartos.get(3).isReservado ? "Sim" : "Nao");

        

//COLOCANDO OS TEXTOS E BOTÕES NA TELA
        //LABELS E BOTÕES 
        gp.add(lblSuite1, 2,1);
        gp.add(lblSuitedesc1, 2,3);
        gp.add(lblSuiteprc1, 2,4);
        gp.add(lblOcupado1, 2,5);
        gp.add(buttonsBox, 2, 6);
        
        //LABELS E BOTÕES 
        gp.add(lblSuite2,  1,1);
        gp.add(lblSuitedesc2,  1,3);
        gp.add(lblSuiteprc2,  1,4);
        gp.add(lblOcupado2, 1,5);
        gp.add(btnCadastrar2, 1, 6);
        
        //LABELS E BOTÕES 
        gp.add(lblSuite3, 1,11);
        gp.add(lblSuitedesc3, 1,13);
        gp.add(lblSuiteprc3, 1,14);
        gp.add(lblOcupado3, 1,15);
        gp.add(btnCadastrar3,  1, 16);
        
        //LABELS E BOTÕES 
        gp.add(lblSuite4, 2,11);
        gp.add(lblSuitedesc4, 2,13);                   
        gp.add(lblSuiteprc4, 2,14);
        gp.add(lblOcupado4, 2,15);
        gp.add(btnCadastrar4, 2, 16);

        buttonsBox.getChildren().addAll(btnCadastrar);

        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col1.setPercentWidth(15);
        col2.setPercentWidth(50);

        gp.getColumnConstraints().addAll(col1, col2);
        gp.setVgap(10);
        gp.setPadding(new Insets(15));
        
        btnCadastrar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	ReservarController reservarController = new ReservarController(listaQuartos.get(0).id);
            	
            	try {
					stag.setScene(reservarController.render());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        
        btnCadastrar2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	ReservarController reservarController = new ReservarController(listaQuartos.get(1).id);
            	
            	try {
					stag.setScene(reservarController.render());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        
        btnCadastrar3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	ReservarController reservarController = new ReservarController(listaQuartos.get(2).id);
            	
            	try {
					stag.setScene(reservarController.render());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        btnCadastrar4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	ReservarController reservarController = new ReservarController(listaQuartos.get(3).id);
            	
            	try {
					stag.setScene(reservarController.render());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        
        btnCadastrar.setDisable(listaQuartos.get(0).isReservado ? true : false);
        btnCadastrar2.setDisable(listaQuartos.get(1).isReservado ? true : false);
        btnCadastrar3.setDisable(listaQuartos.get(2).isReservado ? true : false);
        btnCadastrar4.setDisable(listaQuartos.get(3).isReservado ? true : false);        

        stag.setResizable(false);
        stag.setScene(scn);
        stag.setTitle("Quartos Hotelaria");
        stag.show();
    }
	
    public static void main(String[] args) {
		Application.launch(QuartosDispo.class, args);
	}
}