package boundary;

import java.io.FileNotFoundException;
import java.util.List;

import control.QuartoControl;
import entity.Quarto;
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

public class QuartosDispoBoundary {
	public List<Quarto> listaQuartos;
	
	public QuartosDispoBoundary() {
        QuartoControl quartoRepo = new QuartoControl();
        
        listaQuartos = quartoRepo.findAllQuartos();
	}
	
	public Scene render(Stage stag) throws Exception {
        GridPane gp = new GridPane();
        HBox buttonsBox = new HBox();
        Scene scn = new Scene(gp, 900, 400);
       
 //DECLARAÇÃO DAS LABELS E BOTÕES                                                  
        
        Button btnCadastrar = new Button("Reservar");
        Label lblSuite1 = new Label(listaQuartos.get(0).getTipo());
        Label lblSuitedesc1 = new Label(listaQuartos.get(0).getDescricao());
        Label lblSuiteprc1 = new Label("Valor: R$" + listaQuartos.get(0).getValor().toString().replace('.', ',') + "0");
        Label lblOcupado1 = new Label("Ocupado: " + (listaQuartos.get(0).isReservado ? "Sim" : "Nao"));
       
        Button btnCadastrar2 = new Button("Reservar");
        Label lblSuite2 = new Label(listaQuartos.get(1).getTipo());
        Label lblSuitedesc2 = new Label(listaQuartos.get(1).getDescricao());
        Label lblSuiteprc2 = new Label("Valor: R$" + listaQuartos.get(1).getValor().toString().replace('.', ',') + "0");
        Label lblOcupado2 = new Label("Ocupado: " + (listaQuartos.get(1).isReservado ? "Sim" : "Nao"));
            
        Button btnCadastrar3 = new Button("Reservar");
        Label lblSuite3 = new Label(listaQuartos.get(2).getTipo());
        Label lblSuitedesc3 = new Label(listaQuartos.get(2).getDescricao());
        Label lblSuiteprc3 = new Label("Valor: R$" + listaQuartos.get(2).getValor().toString().replace('.', ',') + "0");
        Label lblOcupado3 = new Label("Ocupado: " + (listaQuartos.get(2).isReservado ? "Sim" : "Nao"));
        
        
        Button btnCadastrar4 = new Button("Reservar");
        Label lblSuite4 = new Label(listaQuartos.get(3).getTipo());
        Label lblSuitedesc4 = new Label(listaQuartos.get(3).descricao);
        Label lblSuiteprc4 = new Label("Valor: R$" + listaQuartos.get(3).getValor().toString().replace('.', ',') + "0");
        Label lblOcupado4 = new Label("Ocupado: " + (listaQuartos.get(3).isReservado ? "Sim" : "Nao"));

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
            	ReservarBoundary reservarController = new ReservarBoundary(listaQuartos.get(0).getId());
            	lblOcupado1.setText("Ocupado: Sim");
            	btnCadastrar.setDisable(true);
            	try {
					stag.setScene(reservarController.render(stag, scn));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
            }
        });
        
        btnCadastrar2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	ReservarBoundary reservarController = new ReservarBoundary(listaQuartos.get(1).getId());
            	btnCadastrar2.setDisable(true);
            	lblOcupado2.setText("Ocupado: Sim");
            	try {
					stag.setScene(reservarController.render(stag, scn));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
            }
        });
        
        btnCadastrar3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	ReservarBoundary reservarController = new ReservarBoundary(listaQuartos.get(2).getId());
            	btnCadastrar3.setDisable(true);
            	lblOcupado3.setText("Ocupado: Sim");
            	try {
					stag.setScene(reservarController.render(stag, scn));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
            }
        });
        
        btnCadastrar4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	ReservarBoundary reservarController = new ReservarBoundary(listaQuartos.get(3).getId());
            	btnCadastrar4.setDisable(true);
            	lblOcupado4.setText("Ocupado: Sim");
            	try {
					stag.setScene(reservarController.render(stag, scn));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
            }
        });
        
        btnCadastrar.setDisable(listaQuartos.get(0).isReservado);
        btnCadastrar2.setDisable(listaQuartos.get(1).isReservado);
        btnCadastrar3.setDisable(listaQuartos.get(2).isReservado);
        btnCadastrar4.setDisable(listaQuartos.get(3).isReservado);
		return scn;        
    }
}