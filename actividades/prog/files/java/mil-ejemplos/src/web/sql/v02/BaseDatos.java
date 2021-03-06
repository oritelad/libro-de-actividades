package web.sql.v02;

import java.sql.*;

public class BaseDatos {

	private String url;

	private Connection con;

	public BaseDatos() {
	}

	public void abrir() {
		try {
			// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println(" [INFO] Cargando el driver...");
			Class.forName("org.postgresql.Driver");

			System.out.println(" [INFO] Conectando...");
			con = DriverManager.getConnection(url, "david", "david");

			SQLWarning warn = con.getWarnings();
			while (warn != null) {
				System.out.println("SQLState : " + warn.getSQLState());
				System.out.println("Message  : " + warn.getMessage());
				System.out.println("Vendor   : " + warn.getErrorCode());
				System.out.println("");
				warn = warn.getNextWarning();
			}
		} catch (ClassNotFoundException e) {
			System.out.println(" [ERROR] Carga del Driver: " + e);
		} catch (SQLException e) {
			System.out.println(" [ERROR] Base de datos: " + e);
		}
	}

	public void cerrar() {
		try {
			System.out.println(" [INFO] Cerrando conexión...");
			con.close();
		} catch (Exception e) {
			System.out.println(" [ERROR] Cerrando BD: " + e);
		}
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static void main(String[] args) {
		BaseDatos bd = new BaseDatos();
		// String url="jdbc:odbc:Companies";
		bd.setUrl("jdbc:postgresql:pruebas");
		bd.abrir();
		bd.cerrar();
	}
}
