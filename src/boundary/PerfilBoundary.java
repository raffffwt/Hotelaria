package boundary;


import java.io.FileInputStream;
import control.UsuarioControl;
import entity.Usuario;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class PerfilBoundary {
	private String dir = System.getProperty("user.dir");
	
	public Scene render(Usuario currentUser, Stage menuPrincipal, Scene cenaPrincipal, HomePageBoundary homePage) throws Exception {
        final GridPane gp = new GridPane();
        Scene scn = new Scene(gp, 900, 600);

        Button btnAplicar = new Button("Aplicar");
        
        Button btnRedefinir = new Button("Redefinir Senha");
        Button btnExcluirConta = new Button("Excluir conta");
        Button btnVoltar = new Button("Voltar");
        
        Label lblNome = new Label("Nome: " + currentUser.getNome());

        Label lblEmail = new Label("Email: " + currentUser.getEmail());
        
        Label lblEndereco = new Label("Endereco: " + currentUser.getEndereco());

        Label lblTel = new Label("Telefone: " + currentUser.getTelefone());
        
        Label lblSenha = new Label("Senha: ");
        PasswordField txtSenha = new PasswordField();
        Label lblSenhaNova = new Label("Senha Nova: ");
        PasswordField txtSenhaNova = new PasswordField();
                      
        Image image = new Image(new FileInputStream(dir + "/resources/perfil/perfil.png"));  
        
        ImageView imageView = new ImageView(image); 
        
        imageView.setX(50); 
        imageView.setY(25); 
        
        imageView.setFitHeight(150); 
        imageView.setFitWidth(150); 
        
        imageView.setPreserveRatio(true);          
 
        Group root = new Group(imageView);
   
        
        gp.add(root, 0, 0);
        
        gp.add(lblNome, 0,1);

        gp.add(lblEmail, 0,2);

        gp.add(lblEndereco, 0,3);

        gp.add(lblTel, 0,4);

        gp.add(lblSenha, 0,5);
        gp.add(txtSenha, 1,5);      
               
        gp.add(btnRedefinir, 1, 7);
        
        gp.add(btnAplicar, 0, 12);
        gp.add(btnExcluirConta, 12, 12);
        gp.add(btnVoltar, 12, 0);


        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col1.setPercentWidth(15);
        col2.setPercentWidth(25);

        gp.getColumnConstraints().addAll(col1, col2);
        gp.setVgap(10);
        gp.setPadding(new Insets(15));
        
        // BOTAO PRA REDEFINIR A SENHA
        btnRedefinir.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent event) {
	        	if(txtSenha.getText().equals(currentUser.getSenha())) {
	            	btnRedefinir.setVisible(false);
	                
	                gp.add(lblSenhaNova, 0, 6);
	                gp.add(txtSenhaNova, 1, 6);
	                return;
	        	}        	
	        }	   
        });
        
        // BOTAO PRA CONFIRMAR A NOVA SENHA
        btnAplicar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent event) {
	        	if (!btnRedefinir.isVisible()) {
	        		UsuarioControl userControl = new UsuarioControl();
	        		userControl.AlterarSenha(currentUser.getId(), txtSenhaNova.getText());
	        		homePage.currentUser =  userControl.findUsuarioById(currentUser.getId());
	        		
	        		menuPrincipal.setScene(cenaPrincipal);
	        	}
	        }	   
        });
        
        // BOTAO PARA VOLTAR A TELA PRINCIPAL
        btnVoltar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent event) {
        		menuPrincipal.setScene(cenaPrincipal);
	        }	   
        });
        
        // BOTAO PARA EXCLUIR A CONTA
        btnExcluirConta.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent event) {
	        	UsuarioControl userControl = new UsuarioControl();
	        	
	        	userControl.ExcluirUsuario(currentUser.getId());
	        	
	        	LoginBoundary login = new LoginBoundary();
	        	
	        	try {
					menuPrincipal.setScene(login.render(menuPrincipal, cenaPrincipal, homePage));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }	   
        });
        
		return scn;   
    }
}
