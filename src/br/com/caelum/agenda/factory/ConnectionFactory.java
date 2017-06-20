/**
 * 
 */
package br.com.caelum.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author matao01
 *
 */
public class ConnectionFactory {

	public Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", USER, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
