package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DbConfig;
import model.Produto;

public class CardapioRepository {
	public List<Produto> findAllProdutos() {
		PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = DbConfig.getConnection();

        try {
            ps = con.prepareStatement("SELECT * FROM PRODUTO ORDER BY nome");
            rs = ps.executeQuery();
            List<Produto> list = new ArrayList();
            while(rs.next()){
                list.add(getProdutoFromResultSet(rs));
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
	
	private Produto getProdutoFromResultSet(ResultSet rs) throws SQLException {
		Produto pers = new Produto();
		pers.setNome(rs.getString(2));	
        pers.setDescricao(rs.getString(3));
        pers.setValor(rs.getDouble(4));
        return pers;
    }
}
