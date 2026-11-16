package com.sgc.principal;

import com.sgc.dao.OrganizacionDAO;
import com.sgc.modelo.Organizacion;

public class PruebaOrganizacionDAO {
    public static void main(String[] args) {

        OrganizacionDAO dao = new OrganizacionDAO();

        Organizacion organizacion = new Organizacion(
            "Organizacion de prueba SGC",
            "PRUEBA001",
            "Bogota",
            "3001234567",
            "prueba@sgc.com"
        );

        // Prueba 1: validar que el nombre sea obligatorio
organizacion.setNombre("Organizacion de prueba SGC");
organizacion.setIdentificacion("PRUEBA002");
organizacion.setCorreo("prueba002@sgc.com");

boolean registrado = dao.registrar(organizacion);

if (registrado) {
    System.out.println("Organizacion registrada correctamente.");
} else {
    System.out.println("No fue posible registrar la organizacion.");
}

        System.out.println("\nListado de organizaciones:");

        for (Organizacion o : dao.listar()) {
            System.out.println(o);
        }
    System.out.println("\nBuscar organización por ID:");

Organizacion encontrada = dao.buscarPorId(1);
if (encontrada != null) {
    encontrada.setNombre("Organizacion SGC Actualizada");
    encontrada.setDireccion("Medellin");

    boolean actualizado = dao.actualizar(encontrada);

    if (actualizado) {
        System.out.println("Organizacion actualizada correctamente.");
    } else {
        System.out.println("No fue posible actualizar la organizacion.");
    }

    boolean eliminado = dao.eliminar(1);

    if (eliminado) {
        System.out.println("Organizacion eliminada correctamente.");
    } else {
        System.out.println("No fue posible eliminar la organizacion.");
    }

} else {
    System.out.println("No se encontro la organizacion.");
}
    }
    }