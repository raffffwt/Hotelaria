package boundary;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class CarrinhoBoundary {

	public Scene render(Stage stg) throws Exception {
		GridPane gp = new GridPane();
		HBox buttonsBox = new HBox();
		Scene scn = new Scene(gp, 920, 400);
		
		//declarar labels e botão
		
		Button btnPagar = new Button("Realizar Pagamento"); //botao pagamento
		
		Label lblHotel = new Label ("           						HOTELARIA");
		

		
		final ToggleGroup group = new ToggleGroup();

		RadioButton rb1 = new RadioButton("Boleto");
		rb1.setToggleGroup(group);
		rb1.setSelected(true);

		RadioButton rb2 = new RadioButton("Cartao de crédito");
		rb2.setToggleGroup(group);
		

		
		gp.add(lblHotel, 1, 1);
		
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
		
	 	stg.setResizable(false);
        stg.setScene(scn);
        stg.setTitle("Carrinho Pagamento");
        stg.show();
        
        
        rb1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	stg.setTitle("  Pagamento com boleto selecionado");
            	
            	
        	Button btnImpboleto = new Button("imprimir boleto");
    	
        	gp.add(btnImpboleto, 30, 20);
        	
            	
            } //aparecer mensagem sobre a função de pagamento escolhida
        
	});
        
        
        
        rb2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	stg.setTitle("  Função crédito selecionada");
            	
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
               
            	
            	
            	
            } //aparecer mensagem sobre a função de pagamento escolhida
        
	});
        
        
        
        btnPagar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	stg.setTitle(" Pagamento realizado");
            } //mensagem de pagamento realizado ao clicar
           
        
	});
		return scn;
	}

}
