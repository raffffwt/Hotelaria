package boundary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import control.QuartoControl;
import control.ReservaControl;
import entity.Produto;
import entity.Quarto;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ReservarBoundary {
	Quarto currentQuarto = new Quarto();
	private String dir = System.getProperty("user.dir");

	public ReservarBoundary(int quartoId) {
		QuartoControl quartoRepo = new QuartoControl();
		
		currentQuarto = quartoRepo.findQuartoById(quartoId);
	}
	
	public Scene render(Stage menuPrincipal, Scene cenaPrincipal) throws FileNotFoundException {
		GridPane gp = new GridPane();

		Scene scn = new Scene(gp, 900, 450);
        HBox buttonsBox = new HBox();
        Button btnVoltar = new Button("Voltar");

        Button btnReservar = new Button("Reservar");
        
        Label lblNome = new Label("Hotel");
        Image image = new Image(new FileInputStream(dir + "/resources/quartos/quarto" + currentQuarto.getId() + ".jpg"));  
        
        ImageView imageView = new ImageView(image); 
        
        imageView.setX(50); 
        imageView.setY(25); 
        
        imageView.setFitHeight(375); 
        imageView.setFitWidth(225); 
        
        imageView.setPreserveRatio(true);  

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
        
        gp.add(btnVoltar, 12, 0);
       
        buttonsBox.getChildren().addAll(btnReservar);

        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col1.setPercentWidth(15);
        col2.setPercentWidth(50);

        gp.getColumnConstraints().addAll(col1, col2);
        gp.setVgap(10);
        gp.setPadding(new Insets(15));
        
        // BOTAO PARA RESERVAR O QUARTO
        btnReservar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	ReservaControl reserva = new ReservaControl();
            	reserva.ReservarQuarto(currentQuarto.getId());
            	menuPrincipal.setScene(cenaPrincipal);
            }
        });
        
        // BOTAO PRA VOLTAR AO MENU PRINCIPAL
        btnVoltar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent event) {
	        	QuartosDispoBoundary quartos = new QuartosDispoBoundary();
        		try {
					menuPrincipal.setScene(quartos.render(menuPrincipal, cenaPrincipal));
				} catch (Exception e) {
					e.printStackTrace();
				}
	        }	   
        });
        
		return scn;
        
	}
}
