package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DbConfig;

public class ReservaControl {
	public Boolean ReservarQuarto(int id) {
		PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = DbConfig.getConnection();

        try {
            ps = con.prepareStatement("UPDATE quarto " +
                    "SET isReservado = ? " +
                    "WHERE id = ?");
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeResources(ps, rs);
        }
        return true;
	}
	
	private void closeResources(PreparedStatement ps, ResultSet rs) {
        DbConfig.closeResultSet(rs);
        DbConfig.closeStatement(ps);
    }
}
