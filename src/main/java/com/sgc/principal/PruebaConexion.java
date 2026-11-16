
package com.sgc.principal;

import com.sgc.conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;

public class PruebaConexion {

    public static void main(String[] args) {

        try (Connection conexion = Conexion.conectar()) {

            if (conexion != null && !conexion.isClosed()) {
                System.out.println("================================");
                System.out.println("CONEXION EXITOSA");
                System.out.println("Sistema: SGC");
                System.out.println("Base de datos: sgc_organizaciones");
                System.out.println("Servidor: MariaDB");
                System.out.println("================================");
            }

        } catch (SQLException e) {
            System.out.println("ERROR AL CONECTAR CON LA BASE DE DATOS");
            System.out.println("Detalle: " + e.getMessage());
        }
    }
}
