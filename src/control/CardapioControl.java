package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DbConfig;
import entity.Produto;

public class CardapioControl {
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
		Produto produto = new Produto();
		produto.setNome(rs.getString(2));	
		produto.setDescricao(rs.getString(3));
		produto.setValor(rs.getDouble(4));
        return produto;
    }
}
