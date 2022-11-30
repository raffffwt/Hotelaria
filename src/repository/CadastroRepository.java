package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import config.DbConfig;

public class CadastroRepository {
	public Boolean CadastraUsuario(String nome, String email, String endereco, String senha, String telefone) throws SQLException {
		PreparedStatement ps = null;
		Connection con = DbConfig.getConnection();

        try {
            ps = con.prepareStatement("INSERT INTO USUARIO (nome, email, endereco, senha, telefone) VALUES (?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, endereco);
            ps.setString(4, senha);
            ps.setString(5, telefone);
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return true;
	}
}
