package controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CardapioController extends Application {
	@Override
	public void start(final Stage stag) throws Exception {
        GridPane gp = new GridPane();
        HBox buttonsBox = new HBox();
        Scene scn = new Scene(gp, 900, 400);
       
 //DECLARAÇÃO DAS LABELS E BOTÕES                                            
        Button btnFinalizar = new Button("Finalizar Compra");
        
        
        Button btnLogin = new Button("Adicionar");
        Label lblSkol = new Label("Skol Long Neck ");
        Label lblSkoldesc = new Label("330ml ");
        Label lblSkolprc = new Label("Valor: $$$ ");
        
        
        Button btnCadastrar = new Button("Adicionar");
        Label lblHei = new Label("Heineken Long Neck ");
        Label lblHeidesc = new Label("330ml ");
        Label lblHeiprc = new Label("Valor: $$$ ");
        
        
        Button btnCadastrar2 = new Button("Adicionar");
        Label lblCheet = new Label("Cheetos ");
        Label lblCheetdesc = new Label("230g ");
        Label lblCheetprc = new Label("R$: $$$ ");
        
        
        Button btnCadastrar3 = new Button("Adicionar");
        Label lblFandangos = new Label("Fandangos ");
        Label lblFandangosdesc = new Label("280g ");
        Label lblFandangosprc = new Label("Valor: $$$ ");

        

//COLOCANDO OS TEXTOS E BOTÕES NA TELA
        //LABELS E BOTÕES SKOL
        gp.add(lblSkol, 2,1);
        gp.add(lblSkolprc, 2,4);
        gp.add(lblSkoldesc, 2,3);
        gp.add(buttonsBox, 2, 6);
        
        //LABELS E BOTÕES HEINEKEIN
        gp.add(lblHei,  1,1);
        gp.add(lblHeiprc,  1,4);
        gp.add(lblHeidesc,  1,3);
        gp.add(btnCadastrar, 1, 6);
        
        //LABELS E BOTÕES CHEETOS
        gp.add(lblCheet, 1,11);
        gp.add(lblCheetdesc, 1,14);
        gp.add(lblCheetprc, 1,13);
        gp.add(btnCadastrar2,  1, 16);
        
        //LABELS E BOTÕES FANDANGOS
        gp.add(lblFandangos, 2,11);
        gp.add(lblFandangosdesc, 2,14);                   
        gp.add(lblFandangosprc, 2,13);
        gp.add(btnCadastrar3, 2, 16);
        
                       
        gp.add(btnFinalizar, 6, 20);

        buttonsBox.getChildren().addAll(btnLogin);

        
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col1.setPercentWidth(15);
        col2.setPercentWidth(50);

        gp.getColumnConstraints().addAll(col1, col2);
        gp.setVgap(10);
        gp.setPadding(new Insets(15));

        stag.setResizable(false);
        stag.setScene(scn);
        stag.setTitle("Login Hotelaria");
        stag.show();
        
        btnLogin.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	stag.setTitle(" Adicionado ao Carrinho");
            }
        });
        btnCadastrar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	stag.setTitle(" Adicionado ao Carrinho");
            }
        });
        btnCadastrar2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	stag.setTitle(" Adicionado ao Carrinho");
            }
        });
        btnCadastrar3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	stag.setTitle(" Adicionado ao Carrinho");
            }
        });
        btnFinalizar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	stag.setTitle(" Compra Finalizada");
            }
        });
    }
	
    
    
    
    public static void main(String[] args) {
		Application.launch(CardapioController.class, args);
	}
}