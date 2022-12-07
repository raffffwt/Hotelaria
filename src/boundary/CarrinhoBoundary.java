package boundary;

import java.util.List;

import entity.Produto;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class CarrinhoBoundary {
	private List<Produto> carrinho;
	
	public CarrinhoBoundary(List<Produto> carrinho) {
		this.carrinho = carrinho;
	}
	
	private TableView<Produto> table = new TableView<>();

	public Scene render() throws Exception {
		GridPane gp = new GridPane();

		Scene scn = new Scene(gp, 900, 400);
        HBox buttonsBox = new HBox();
        
        TableColumn<Produto, String> nome = new TableColumn("Nome do produto");
        nome.setMinWidth(100);
        nome.setCellValueFactory(
                new PropertyValueFactory<Produto, String>("Nome"));
 
        TableColumn<Produto, String> descricao = new TableColumn("Descricao");
        descricao.setMinWidth(100);
        descricao.setCellValueFactory(
                new PropertyValueFactory<Produto, String>("descricao"));
 
        TableColumn<Produto, Double> valor = new TableColumn("Valor");
        valor.setMinWidth(200);
        valor.setCellValueFactory(
            new PropertyValueFactory<Produto, Double>("valor")
        );
        
        table.setItems(FXCollections.observableList(carrinho));
        table.getColumns().addAll(nome, valor, descricao);
        
		gp.add(table, 0, 2, 7, 7);
		//declarar labels e botão
		
		Button btnPagar = new Button("Realizar Pagamento"); //botao pagamento
		
		Label lblHotel = new Label ("           						HOTELARIA");
		
		Double total = 0.0;
		
		for(Produto produto: carrinho) {
			total += produto.getValor();
		}
		
		Label valorTotal = new Label(("Valor total: R$" + total + "0").replace('.', ','));

		final ToggleGroup group = new ToggleGroup();

		RadioButton rb1 = new RadioButton("Boleto");
		rb1.setToggleGroup(group);
		rb1.setSelected(true);

		RadioButton rb2 = new RadioButton("Cartao de crédito");
		rb2.setToggleGroup(group);
		
		gp.add(lblHotel, 1, 1);
		gp.add(valorTotal, 0, 15);
		
		gp.add(rb1, 30, 18); //boleto
		
		gp.add(rb2, 0, 18); //cartão de crédito
		
		gp.add(btnPagar, 0, 24);  //pagamento
	
		ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col1.setPercentWidth(15);
        col2.setPercentWidth(35);

        gp.getColumnConstraints().addAll(col1, col2);
        gp.setVgap(10);
        gp.setPadding(new Insets(15));
        
        Label lblNumcard = new Label("Numero do cartão: ");
        TextField txtNumcard = new TextField(); 
        
        Label lblCvv = new Label("Código de segurança: ");
        TextField txtCvv = new TextField();
        
        Label lblData = new Label("Data de validade: ");
        TextField txtData = new TextField();
                      
        gp.add(lblNumcard, 0, 20); 
        gp.add(lblCvv, 0, 21);
        gp.add(lblData, 0, 22);
        gp.add(txtNumcard, 1, 20);
        gp.add(txtCvv, 1, 21);
        gp.add(txtData, 1, 22);
        
        lblNumcard.setVisible(false);
    	lblCvv.setVisible(false);
    	lblData.setVisible(false);
    	txtNumcard.setVisible(false);
    	txtCvv.setVisible(false);
    	txtData.setVisible(false);
    	
    	Button btnImpboleto = new Button("imprimir boleto");
    	
    	gp.add(btnImpboleto, 30, 20);
    	
    	btnImpboleto.setVisible(false);
        
        rb1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {    
            	// deixa os campos de cartao invisiveis
            	lblNumcard.setVisible(false);
            	lblCvv.setVisible(false);
            	lblData.setVisible(false);
            	txtNumcard.setVisible(false);
            	txtCvv.setVisible(false);
            	txtData.setVisible(false);
            	
            	btnImpboleto.setVisible(true);// deixa o botao visivel
            } //aparecer mensagem sobre a função de pagamento escolhida        
	});
      
        rb2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	btnImpboleto.setVisible(false); // deixa o botao invisivel
            	
            	// deixa os campos de cartao visiveis
            	lblNumcard.setVisible(true);
            	lblCvv.setVisible(true);
            	lblData.setVisible(true);
            	txtNumcard.setVisible(true);
            	txtCvv.setVisible(true);
            	txtData.setVisible(true);
                        	
            } //aparecer mensagem sobre a função de pagamento escolhida
        
	});
         
        btnPagar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	
            } //mensagem de pagamento realizado ao clicar 
	});
		return scn;
	}
}
