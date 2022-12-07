package boundary;

import java.io.File;
import java.io.FileInputStream;

import entity.Usuario;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HomePageBoundary extends Application {
	private Boolean isLogado = false;
	public Usuario currentUser = new Usuario();
	private String dir = System.getProperty("user.dir");
	
	public void setIsLogado(Boolean isLogado) {
		this.isLogado = isLogado;
	}
	@Override
	public void start(Stage stg) throws Exception {
		GridPane gp = new GridPane();
		Scene scn = new Scene(gp, 920, 400); 	
		
		Label lblHotel = new Label ("HOTELARIA");
		
		Button btnQuartos = new Button("Quartos disponiveis");
		
		Button btnCardapio = new Button ("Cardapio");
		
		Button btnPerfil = new Button ("Perfil");
		
		Button btnHome = new Button("Home");
		
		Label lblServi = new Label("Servicos oferecidos: ");
		
		Label lblWifi = new Label ("Wifi nos quartos");
		
		Label lblAr = new Label("Quartos com ar condicionado");
		
		Label lblCafe = new Label("Cafe da manha incluso");
		
		Label lblAlmoco = new Label("Almoco opcional");			
		
		gp.add(btnCardapio, 3, 1);
		gp.add(btnPerfil, 5, 1);
		gp.add(btnHome, 1, 1);
		gp.add(lblHotel, 0, 0);
		gp.add(btnQuartos, 7, 1);
		gp.add(lblServi, 5, 8);
		gp.add(lblWifi, 3 , 20);
		gp.add(lblAr, 7, 20);
		gp.add(lblCafe, 3, 22);
		gp.add(lblAlmoco, 7, 22);

		Image image = new Image(new FileInputStream(new File(dir + "/resources/hotel/hotel.jpg")));  
        
        ImageView imageView = new ImageView(image); 
        
        imageView.setX(100); 
        imageView.setY(50); 
        
        imageView.setFitHeight(300); 
        imageView.setFitWidth(300); 
        
        imageView.setPreserveRatio(true);  
            
        gp.add(imageView, 7, 25);

 		Image image2 = new Image(new FileInputStream(new File(dir + "/resources/hotel/hotel2.jpg")));  
        
        ImageView imageView2 = new ImageView(image2); 
        
        imageView2.setX(100); 
        imageView2.setY(50); 
        
        imageView2.setFitHeight(300); 
        imageView2.setFitWidth(300); 
        
        imageView2.setPreserveRatio(true);  
        
        Group root2 = new Group(imageView2);  
   
        gp.add(root2, 3, 25);	
        
        btnCardapio.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	CardapioBoundary cardapio = new CardapioBoundary();
            	try {
					stg.setScene(cardapio.render(stg, scn));
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });
        
        btnQuartos.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	QuartosDispoBoundary quartos = new QuartosDispoBoundary();
            	try {
					stg.setScene(quartos.render(stg, scn));
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });
        
        btnPerfil.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	PerfilBoundary perfil = new PerfilBoundary();
            	try {
					stg.setScene(perfil.render(currentUser, stg, scn, HomePageBoundary.this));
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });
		
	 	stg.setResizable(false);
        stg.setScene(scn);
        if(!isLogado) {
			LoginBoundary login = new LoginBoundary();
			stg.setScene(login.render(stg, scn, this));
		}
        stg.setTitle("Pagina inical");
        stg.show();
             
        
	}
	
	 public static void main(String[] args) {
			Application.launch(HomePageBoundary.class, args);
	}
}
