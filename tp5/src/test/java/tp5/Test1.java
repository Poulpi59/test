package tp5;

import static org.junit.Assert.*;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test1 {
	static Connection conn;
	
	@Test
	public void test1() throws Exception {
		String res = "HelloWorld";
		Freemarker bb = new Freemarker();
		bb.createConfig();
		String tpl = bb.remplir();
		assertTrue(res.equals(tpl));
	}
	
	@Before
	public void init() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing?"
				+ "user=swingUser&password=swingPass&useSSL=false&serverTimezone=GMT");
	}
	
	
	@Test
	public void testConnexion() throws Exception {
		if (conn != null) {
			assertTrue(true);
		} else {
			fail("Serveur non dispo");
		}
	}
	
	@Test
	public void testRequete() throws SQLException
	{
		java.sql.Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM prof where age = 23");
		rs.next();
		String res = rs.getString(2);
		rs.close();
		assertTrue("roberto".equals(res));
	}
	
	@After
	public void fin() throws Exception {
		conn.close();
		
	}
	
}
