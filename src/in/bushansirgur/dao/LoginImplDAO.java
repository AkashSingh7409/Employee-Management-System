package in.bushansirgur.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.bushansirgur.entity.Login;
import in.bushansirgur.util.DBConnectionUtil;

public class LoginImplDAO implements LoginDAO {

	@Override
	public String authenticate(Login login) {
		String sql = "select * from tbl_login where email=? and password=?";
		
		try {
			Connection connection = DBConnectionUtil.openConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, login.getEmail());
			ps.setString(2, login.getPassword());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return "true";
			}
			else {
				return "false";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

}
