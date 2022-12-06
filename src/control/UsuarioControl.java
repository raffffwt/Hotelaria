package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DbConfig;
import model.Usuario;

public class UsuarioControl {
	public Usuario findUsuarioByNome(String nome) {
		PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = DbConfig.getConnection();

        try {
            ps = con.prepareStatement("SELECT id, nome, senha FROM USUARIO WHERE nome = ?");
            ps.setString(1, nome);
            rs = ps.executeQuery();
            rs.next();
            return getUsuarioFromResultSet(rs);
        } catch (SQLException e) {
            return new Usuario();
        }finally {
            closeResources(ps, rs);
        }
	}
	
	public Usuario findUsuarioById(int id) {
		PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = DbConfig.getConnection();

        try {
            ps = con.prepareStatement("SELECT * FROM USUARIO WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            return getUsuarioFromResultIdSet(rs);
        } catch (SQLException e) {
            return new Usuario();
        }finally {
            closeResources(ps, rs);
        }
	}
	
	public Boolean AlterarSenha(int id, String novaSenha) {
		PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = DbConfig.getConnection();

        try {
            ps = con.prepareStatement("UPDATE usuario " +
                    "SET senha = ? " +
                    "WHERE id = ?");
            ps.setString(1, novaSenha);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeResources(ps, rs);
        }
        return true;
	}
	
	public Boolean ExcluirUsuario(int id) {
		PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = DbConfig.getConnection();
        
        try {
        	ps = con.prepareStatement("DELETE FROM USUARIO WHERE ID = ?");
        	ps.setInt(1, id);
        	ps.executeUpdate();
        } catch (SQLException e) {
        	return false;
        } finally {
        	closeResources(ps, rs);
        }
        
        return true;
	}
	
	private void closeResources(PreparedStatement ps, ResultSet rs) {
        DbConfig.closeResultSet(rs);
        DbConfig.closeStatement(ps);
    }
	
	private Usuario getUsuarioFromResultSet(ResultSet rs) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setId(rs.getInt(1));
		usuario.setNome(rs.getString(2));	
		usuario.setSenha(rs.getString(3));
	    return usuario;
    }
	
	private Usuario getUsuarioFromResultIdSet(ResultSet rs) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setId(rs.getInt(1));
		usuario.setNome(rs.getString(2));	
		usuario.setEmail(rs.getString(3));
		usuario.setEndereco(rs.getString(4));
		usuario.setTelefone(rs.getString(5));
		usuario.setSenha(rs.getString(6));
	    return usuario;
    }
}
