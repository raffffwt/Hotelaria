package boundary;

import control.UsuarioControl;
import entity.Usuario;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginBoundary {
    
    public Scene render(Stage menuPrincipal, Scene cenaPrincipal, HomePageBoundary homePage) throws Exception {
        GridPane gp = new GridPane();
        Scene scn = new Scene(gp, 600, 150);

        Button btnLogin = new Button("Fazer Login");
        Button btnCadastro = new Button("Nao tem Login?");

        Label lblNome = new Label("Usuario: ");
        TextField txtNome = new TextField();

        Label lblSenha = new Label("Senha: ");
        PasswordField txtSenha = new PasswordField();
        
        Label lblAviso = new Label("Nome ou senha invalidos!");
        lblAviso.setVisible(false);

        gp.add(lblAviso, 1, 3);
        gp.add(lblNome, 0,1);
        gp.add(txtNome, 1,1);
        gp.add(lblSenha, 0,2);
        gp.add(txtSenha, 1,2);
        gp.add(btnLogin, 0, 4);
        gp.add(btnCadastro, 1, 4);

        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col1.setPercentWidth(15);
        col2.setPercentWidth(50);

        gp.getColumnConstraints().addAll(col1, col2);
        gp.setVgap(10);
        gp.setPadding(new Insets(15));
        
        // Botao para logar no sistema
        btnLogin.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	UsuarioControl login = new UsuarioControl();
            	Usuario refUser = login.findUsuarioByNome(txtNome.getText());
            	if(refUser.getSenha() == null || !refUser.getSenha().equals(txtSenha.getText())) {
            		lblAviso.setVisible(true);
            	} else {
            		menuPrincipal.close();
            		menuPrincipal.setScene(cenaPrincipal);
            		homePage.setIsLogado(true);
            		homePage.currentUser = login.findUsuarioById(refUser.getId());    	
            		
            		menuPrincipal.show();
            	}
            }
        });
        
        // Botao pra acessar o cadastro
        btnCadastro.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	CadastroBoundary cadastro = new CadastroBoundary();
            	try {
					menuPrincipal.setScene(cadastro.render(menuPrincipal, scn));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
		return scn;
    }
}
