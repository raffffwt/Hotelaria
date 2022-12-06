package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DbConfig;
import entity.Produto;
import entity.Quarto;

public class QuartoControl {
	private Connection con;
	public QuartoControl() {
		con = DbConfig.getConnection();
	}
	public List<Quarto> findAllQuartos() {
		PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement("SELECT * FROM QUARTO ORDER BY tipo");
            rs = ps.executeQuery();
            List<Quarto> list = new ArrayList();
            while(rs.next()){
                list.add(getQuartoFromResultSet(rs));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeResources(ps, rs);
        }
	}
	
	private void closeResources(PreparedStatement ps, ResultSet rs) {
        DbConfig.closeResultSet(rs);
        DbConfig.closeStatement(ps);
    }
	
	public Quarto findQuartoById(int id) {
		PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement("SELECT * FROM QUARTO WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            return getQuartoFromResultSet(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeResources(ps, rs);
        }
	}
	
	private Quarto getQuartoFromResultSet(ResultSet rs) throws SQLException {
		Quarto quarto = new Quarto();
		quarto.setId(rs.getInt(1));
		quarto.setTipo(rs.getString(2));	
		quarto.setDescricao(rs.getString(3));
		quarto.setValor(rs.getDouble(4));
	    quarto.setIsReservado(rs.getBoolean(5));
	    return quarto;
    }
}
