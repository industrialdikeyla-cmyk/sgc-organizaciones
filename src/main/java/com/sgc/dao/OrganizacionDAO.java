
package com.sgc.dao;

import com.sgc.conexion.Conexion;
import com.sgc.modelo.Organizacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrganizacionDAO {
 
    // Registrar una nueva organización en la base de datos
public boolean registrar(Organizacion organizacion) {

    // Validar que se haya recibido un objeto de organización
    if (organizacion == null) {
        System.out.println("Error: no se recibieron datos de la organización.");
        return false;
    }

    // Validar que el nombre sea obligatorio
    if (organizacion.getNombre() == null
            || organizacion.getNombre().trim().isEmpty()) {
        System.out.println("Error: el nombre de la organización es obligatorio.");
        return false;
    }

    // Validar el formato básico del correo electrónico, si se proporciona
    String correo = organizacion.getCorreo();

    if (correo != null && !correo.trim().isEmpty()
            && !correo.trim().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
        System.out.println("Error: el formato del correo electrónico no es válido.");
        return false;
    }

    // Consulta SQL para insertar los datos de la organización
    String sql = "INSERT INTO organizacion "
               + "(nombre, identificacion, direccion, telefono, correo) "
               + "VALUES (?, ?, ?, ?, ?)";

    try (Connection conexion = Conexion.conectar();
         PreparedStatement statement = conexion.prepareStatement(sql)) {

        statement.setString(1, organizacion.getNombre().trim());
        statement.setString(2, organizacion.getIdentificacion());
        statement.setString(3, organizacion.getDireccion());
        statement.setString(4, organizacion.getTelefono());

        // Guardar el correo como NULL cuando no se proporciona
        if (correo == null || correo.trim().isEmpty()) {
            statement.setNull(5, java.sql.Types.VARCHAR);
        } else {
            statement.setString(5, correo.trim());
        }

        // Ejecutar la inserción y comprobar si se creó el registro
        return statement.executeUpdate() > 0;

    } catch (SQLException e) {
        System.out.println("Error al registrar la organización. "
                + "Verifique los datos y que la identificación no esté duplicada.");
        return false;
    }
}
    // Listar todas las organizaciones
    public List<Organizacion> listar() {

        List<Organizacion> organizaciones = new ArrayList<>();

        String sql = "SELECT * FROM organizacion";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultado = statement.executeQuery()) {

            while (resultado.next()) {

                Organizacion organizacion = new Organizacion();

                organizacion.setIdOrganizacion(
                    resultado.getInt("id_organizacion"));

                organizacion.setNombre(
                    resultado.getString("nombre"));

                organizacion.setIdentificacion(
                    resultado.getString("identificacion"));

                organizacion.setDireccion(
                    resultado.getString("direccion"));

                organizacion.setTelefono(
                    resultado.getString("telefono"));

                organizacion.setCorreo(
                    resultado.getString("correo"));

                organizaciones.add(organizacion);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar organizaciones: "
                    + e.getMessage());
        }

        return organizaciones;
    }
// Buscar una organización por su ID
public Organizacion buscarPorId(int id) {

    String sql = "SELECT * FROM organizacion WHERE id_organizacion = ?";

    try (Connection conexion = Conexion.conectar();
         PreparedStatement statement = conexion.prepareStatement(sql)) {

        statement.setInt(1, id);

        try (ResultSet resultado = statement.executeQuery()) {

            if (resultado.next()) {

                Organizacion organizacion = new Organizacion();

                organizacion.setIdOrganizacion(
                    resultado.getInt("id_organizacion"));

                organizacion.setNombre(
                    resultado.getString("nombre"));

                organizacion.setIdentificacion(
                    resultado.getString("identificacion"));

                organizacion.setDireccion(
                    resultado.getString("direccion"));

                organizacion.setTelefono(
                    resultado.getString("telefono"));

                organizacion.setCorreo(
                    resultado.getString("correo"));

                return organizacion;
            }
        }

    } catch (SQLException e) {
        System.out.println("Error al buscar organización: "
                + e.getMessage());
    }

    return null;
}
// Actualizar los datos de una organización
public boolean actualizar(Organizacion organizacion) {

    String sql = "UPDATE organizacion SET "
            + "nombre = ?, identificacion = ?, direccion = ?, "
            + "telefono = ?, correo = ? "
            + "WHERE id_organizacion = ?";

    try (Connection conexion = Conexion.conectar();
         PreparedStatement statement = conexion.prepareStatement(sql)) {

        statement.setString(1, organizacion.getNombre());
        statement.setString(2, organizacion.getIdentificacion());
        statement.setString(3, organizacion.getDireccion());
        statement.setString(4, organizacion.getTelefono());
        statement.setString(5, organizacion.getCorreo());
        statement.setInt(6, organizacion.getIdOrganizacion());

        return statement.executeUpdate() > 0;

    } catch (SQLException e) {
        System.out.println("Error al actualizar organización: "
                + e.getMessage());
        return false;
    }
}
// Eliminar una organización
public boolean eliminar(int id) {

    String sql = "DELETE FROM organizacion WHERE id_organizacion = ?";

    try (Connection conexion = Conexion.conectar();
         PreparedStatement statement = conexion.prepareStatement(sql)) {

        statement.setInt(1, id);

        return statement.executeUpdate() > 0;

    } catch (SQLException e) {
        System.out.println("Error al eliminar organización: "
                + e.getMessage());
        return false;
    }
}
}
