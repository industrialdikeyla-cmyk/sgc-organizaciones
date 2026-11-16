
package com.sgc.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
            "jdbc:mariadb://127.0.0.1:3306/sgc_organizaciones";

    private static final String USUARIO = "root";

    private static final String PASSWORD = System.getenv("SGC_DB_PASSWORD");

    public static Connection conectar() throws SQLException {

    if (PASSWORD == null || PASSWORD.isBlank()) {
        throw new SQLException("No se ha configurado la contraseña de la base de datos.");
    }

    return DriverManager.getConnection(URL, USUARIO, PASSWORD);
}
}
