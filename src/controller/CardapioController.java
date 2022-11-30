package controller;

import java.util.List;

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
import model.Produto;
import repository.CardapioRepository;

public class CardapioController extends Application {
	
	public List<Produto> listaProduto;
	
	public CardapioController() {
        CardapioRepository cardapioRepo = new CardapioRepository();
        
        listaProduto = cardapioRepo.findAllProdutos();
	}
	@Override
	public void start(final Stage stag) throws Exception {
        GridPane gp = new GridPane();
        HBox buttonsBox = new HBox();
        Scene scn = new Scene(gp, 900, 400);
       
 //DECLARAÇÃO DAS LABELS E BOTÕES                                            
        Button btnFinalizar = new Button("Finalizar Compra");
        
        Button btnLogin = new Button("Adicionar");
        Label lblSkol = new Label(listaProduto.get(0).getNome());
        Label lblSkoldesc = new Label(listaProduto.get(0).getDescricao());
        Label lblSkolprc = new Label(listaProduto.get(0).getValor().toString());
       
        
        Button btnCadastrar = new Button("Adicionar");
        Label lblHei = new Label(listaProduto.get(1).getNome());
        Label lblHeidesc = new Label(listaProduto.get(1).getDescricao());
        Label lblHeiprc = new Label(listaProduto.get(1).getValor().toString());
        
        
        Button btnCadastrar2 = new Button("Adicionar");
        Label lblCheet = new Label(listaProduto.get(2).getNome());
        Label lblCheetdesc = new Label(listaProduto.get(2).getDescricao());
        Label lblCheetprc = new Label(listaProduto.get(2).getValor().toString());
        
        
        Button btnCadastrar3 = new Button("Adicionar");
        Label lblFandangos = new Label(listaProduto.get(3).nome);
        Label lblFandangosdesc = new Label(listaProduto.get(3).descricao);
        Label lblFandangosprc = new Label(listaProduto.get(3).valor.toString());

        

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
        gp.add(lblCheetprc, 1,13);
        gp.add(lblCheetdesc, 1,14);
        gp.add(btnCadastrar2,  1, 16);
        
        //LABELS E BOTÕES FANDANGOS
        gp.add(lblFandangos, 2,11);                
        gp.add(lblFandangosprc, 2,13);
        gp.add(lblFandangosdesc, 2,14);   
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