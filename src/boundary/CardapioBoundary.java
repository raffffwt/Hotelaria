package boundary;

import java.util.ArrayList;
import java.util.List;

import control.CardapioControl;
import entity.Produto;
import javafx.collections.ObservableList;
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

public class CardapioBoundary {
	
	public List<Produto> listaProduto;
	public List<Produto> carrinho = new ArrayList<>();
	
	public CardapioBoundary() {
        CardapioControl cardapioRepo = new CardapioControl();
        
        listaProduto = cardapioRepo.findAllProdutos();
	}

	public Scene render(Stage menuPrincipal, Scene cenaPrincipal) throws Exception {
        GridPane gp = new GridPane();
        HBox buttonsBox = new HBox();
        Scene scn = new Scene(gp, 900, 400);
       
 //DECLARAÇÃO DAS LABELS E BOTÕES                                            
        Button btnFinalizar = new Button("Finalizar Compra");
        
        Button btnProduto = new Button("Adicionar");
        Label lblSkol = new Label(listaProduto.get(0).getNome());
        Label lblSkoldesc = new Label(listaProduto.get(0).getDescricao());
        Label lblSkolprc = new Label("R$" + listaProduto.get(0).getValor().toString().replace('.', ',') + "0");
       
        
        Button btnProduto2 = new Button("Adicionar");
        Label lblHei = new Label(listaProduto.get(1).getNome());
        Label lblHeidesc = new Label(listaProduto.get(1).getDescricao());
        Label lblHeiprc = new Label("R$" + listaProduto.get(1).getValor().toString().replace('.', ',') + "0");
        
        
        Button btnProduto3 = new Button("Adicionar");
        Label lblCheet = new Label(listaProduto.get(2).getNome());
        Label lblCheetdesc = new Label(listaProduto.get(2).getDescricao());
        Label lblCheetprc = new Label("R$" + listaProduto.get(2).getValor().toString().replace('.', ',') + "0");
        
        
        Button btnProduto4 = new Button("Adicionar");
        Label lblFandangos = new Label(listaProduto.get(3).nome);
        Label lblFandangosdesc = new Label(listaProduto.get(3).descricao);
        Label lblFandangosprc = new Label("R$" + listaProduto.get(3).getValor().toString().replace('.', ',') + "0");

        

//COLOCANDO OS TEXTOS E BOTÕES NA TELA
        //LABELS E BOTÕES SKOL
        gp.add(lblSkol, 2,1);
        gp.add(lblSkolprc, 2,3);
        gp.add(lblSkoldesc, 2,4);
        gp.add(buttonsBox, 2, 6);
        
        //LABELS E BOTÕES HEINEKEIN
        gp.add(lblHei,  1,1);
        gp.add(lblHeiprc,  1,3);
        gp.add(lblHeidesc,  1,4);
        gp.add(btnProduto2, 1, 6);
        
        //LABELS E BOTÕES CHEETOS
        gp.add(lblCheet, 1,11);
        gp.add(lblCheetprc, 1,13);
        gp.add(lblCheetdesc, 1,14);
        gp.add(btnProduto3,  1, 16);
        
        //LABELS E BOTÕES FANDANGOS
        gp.add(lblFandangos, 2,11);                
        gp.add(lblFandangosprc, 2,13);
        gp.add(lblFandangosdesc, 2,14);   
        gp.add(btnProduto4, 2, 16);
        
                       
        gp.add(btnFinalizar, 6, 20);

        buttonsBox.getChildren().addAll(btnProduto);

        
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col1.setPercentWidth(15);
        col2.setPercentWidth(50);

        gp.getColumnConstraints().addAll(col1, col2);
        gp.setVgap(10);
        gp.setPadding(new Insets(15));
        
        btnProduto.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	carrinho.add(listaProduto.get(0));
            }
        });
        btnProduto2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	carrinho.add(listaProduto.get(1));
            }
        });
        btnProduto3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	carrinho.add(listaProduto.get(2));
            }
        });
        btnProduto4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	carrinho.add(listaProduto.get(3));
            }
        });
        btnFinalizar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	CarrinhoBoundary carrinhoBoundary = new CarrinhoBoundary(carrinho);
            	if (carrinho.size() < 1)
            		return;
            	try {
					menuPrincipal.setScene(carrinhoBoundary.render());
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });
		return scn;
    }
}