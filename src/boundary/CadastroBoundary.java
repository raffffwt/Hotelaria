package boundary;

import java.sql.SQLException;

import control.CadastroControl;
import javafx.application.Application;
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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CadastroBoundary {

	public Scene render(Stage menuPrincipal, Scene cenaPrincipal) throws Exception {
        GridPane gp = new GridPane(); // Instanciando o gridPane
        HBox buttonsBox = new HBox(); // Caixa horizontal para os botoes
        Scene scn = new Scene(gp, 800, 300); //  Criando a cena

        Button btnLogin = new Button("Cadastrar");
        
        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();

        Label lblEmail = new Label("Email: ");
        TextField txtEmail = new TextField();
        
        Label lblEndereco = new Label("Endereco: ");
        TextField txtEndereco = new TextField();

        Label lblTel = new Label("Telefone: ");
        TextField txtTel = new TextField();
        
        Label lblSenha = new Label("Senha: ");
        PasswordField txtSenha = new PasswordField();

      // Colocando os elementos na tela seguindo as colunas do GridPane
        gp.add(lblNome, 0,1);
        gp.add(txtNome, 1,1);
        gp.add(lblEmail, 0,2);
        gp.add(txtEmail, 1,2);
        gp.add(lblEndereco, 0,3);
        gp.add(txtEndereco, 1,3);
        gp.add(lblTel, 0,4);
        gp.add(txtTel, 1,4);
        gp.add(lblSenha, 0,5);
        gp.add(txtSenha, 1,5);
        gp.add(buttonsBox, 0, 12);

        buttonsBox.getChildren().addAll(btnLogin);

        // Setando quanto de espaço cada coluna vai ocupar na tela
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col1.setPercentWidth(15);
        col2.setPercentWidth(50);
        gp.getColumnConstraints().addAll(col1, col2);
        gp.setVgap(10);
        gp.setPadding(new Insets(15));
        
        // EventHandler para quando o usuario clicar no botao de login
        btnLogin.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	// Instancia da classe Control, onde esta a chamada do banco de dados
            	CadastroControl cadastroController = new CadastroControl();
            	try {
            		// Fazendo a chamada do banco de dados
					cadastroController.CadastraUsuario(txtNome.getText() , txtEmail.getText(), txtEndereco.getText(), txtSenha.getText(), txtTel.getText());
				} catch (SQLException e) {
					e.printStackTrace();
				}
            	// Setando a cena como a cena de login
            	menuPrincipal.setScene(cenaPrincipal);
            }
        });
        
        // Retornando a cena para uso na tela de login
		return scn;
        
    }
}
