package controller;

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
import javafx.stage.Stage;

public class Logincontroller {
    
    public Scene render() throws Exception {
        GridPane gp = new GridPane();
        Scene scn = new Scene(gp, 600, 150);

        Button btnLogin = new Button("Fazer Login");
        Button btnPesquisa = new Button("N�o tem Login?");

        Label lblNome = new Label("Usuario: ");
        TextField txtNome = new TextField();

        Label lblTel = new Label("Senha: ");
        TextField txtTel = new TextField();

        gp.add(lblNome, 0,1);
        gp.add(txtNome, 1,1);
        gp.add(lblTel, 0,2);
        gp.add(txtTel, 1,2);
        gp.add(btnLogin, 0, 3);
        gp.add(btnPesquisa, 1, 3);

        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col1.setPercentWidth(15);
        col2.setPercentWidth(50);

        gp.getColumnConstraints().addAll(col1, col2);
        gp.setVgap(10);
        gp.setPadding(new Insets(15));
        
        btnLogin.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            }
        });
        
        btnPesquisa.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            }
        });
        
		return scn;
    }
}
