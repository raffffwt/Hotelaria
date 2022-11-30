package controller;

import java.sql.SQLException;

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
import repository.CadastroRepository;

public class CadastroController extends Application {
	@Override
	public void start(Stage stg) throws Exception {
        GridPane gp = new GridPane();
        HBox buttonsBox = new HBox();
        Scene scn = new Scene(gp, 800, 300);

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
        TextField txtSenha = new TextField();

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

        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col1.setPercentWidth(15);
        col2.setPercentWidth(50);

        gp.getColumnConstraints().addAll(col1, col2);
        gp.setVgap(10);
        gp.setPadding(new Insets(15));

        stg.setResizable(false);
        stg.setScene(scn);
        stg.setTitle("Login Hotelaria");
        stg.show();
        
        btnLogin.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	CadastroRepository cadastroController = new CadastroRepository();
            	try {
					cadastroController.CadastraUsuario(txtNome.getText() , txtEmail.getText(), txtEndereco.getText(), txtSenha.getText(), txtEndereco.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        
    }
    
    public static void main(String[] args) {
		Application.launch(CadastroController.class, args);
	}
}
