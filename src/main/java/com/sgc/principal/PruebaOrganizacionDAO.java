
package com.sgc.principal;

import com.sgc.dao.OrganizacionDAO;
import com.sgc.modelo.Organizacion;

public class PruebaOrganizacionDAO {

    public static void main(String[] args) {

        OrganizacionDAO dao = new OrganizacionDAO();

        System.out.println("==================================");
        System.out.println(" PRUEBAS DEL MODULO ORGANIZACIONES");
        System.out.println("==================================");

        // PRUEBA 1: Rechazar nombre vacío
        System.out.println("\nPRUEBA 1: Nombre obligatorio");

        Organizacion sinNombre = new Organizacion(
                "", "TEST001", "Bogota", "3001234567",
                "test@sgc.com"
        );

        boolean resultadoNombre = dao.registrar(sinNombre);
        System.out.println("Resultado esperado: registro rechazado");
        System.out.println("Resultado obtenido: "
                + (resultadoNombre ? "No esperado" : "Registro rechazado"));

        // PRUEBA 2: Rechazar correo inválido
        System.out.println("\nPRUEBA 2: Correo inválido");

        Organizacion correoInvalido = new Organizacion(
                "Organizacion prueba correo",
                "TEST002",
                "Bogota",
                "3001234567",
                "correo-invalido"
        );

        boolean resultadoCorreo = dao.registrar(correoInvalido);
        System.out.println("Resultado esperado: registro rechazado");
        System.out.println("Resultado obtenido: "
                + (resultadoCorreo ? "No esperado" : "Registro rechazado"));
// PRUEBA 3: Rechazar identificación duplicada
System.out.println("\nPRUEBA 3: Identificación duplicada");

Organizacion duplicada = new Organizacion(
        "Organizacion duplicada",
        "PRUEBA002",
        "Bogota",
        "3001234567",
        "duplicada@sgc.com"
);

boolean resultadoDuplicado = dao.registrar(duplicada);

System.out.println("Resultado esperado: registro rechazado");
System.out.println("Resultado obtenido: "
        + (resultadoDuplicado ? "No esperado" : "Registro rechazado"));
        // PRUEBA 4: Registrar organización válida
        System.out.println("\nPRUEBA 4: Registro válido");

        Organizacion nueva = new Organizacion(
                "Organizacion de prueba EV02",
                "EV02TEST001",
                "Bogota",
                "3001234567",
                "ev02@sgc.com"
        );

        boolean registrado = dao.registrar(nueva);

        if (!registrado) {
            System.out.println("No fue posible registrar la organización.");
            return;
        }

        System.out.println("Organización registrada correctamente.");

        // PRUEBA 5: Consultar organizaciones
        System.out.println("\nPRUEBA 5: Listar organizaciones");

        for (Organizacion o : dao.listar()) {
            System.out.println(o);
        }

        // PRUEBA 6: Buscar el registro por identificación
        System.out.println("\nPRUEBA 6: Buscar organización");

        int idPrueba = -1;

        for (Organizacion o : dao.listar()) {
            if ("EV02TEST001".equals(o.getIdentificacion())) {
                idPrueba = o.getIdOrganizacion();
                break;
            }
        }

        if (idPrueba == -1) {
            System.out.println("No se encontró el registro de prueba.");
            return;
        }

        Organizacion encontrada = dao.buscarPorId(idPrueba);

        if (encontrada == null) {
            System.out.println("La búsqueda no devolvió resultados.");
            return;
        }

        System.out.println("Organización encontrada: " + encontrada);

        // PRUEBA 7: Actualizar el registro
        System.out.println("\nPRUEBA 7: Actualizar organización");

        encontrada.setNombre("Organizacion EV02 Actualizada");
        encontrada.setDireccion("Medellin");

        boolean actualizado = dao.actualizar(encontrada);

        System.out.println("Resultado: "
                + (actualizado ? "Actualización exitosa"
                : "No fue posible actualizar"));

        // PRUEBA 8: Eliminar el registro de prueba
        System.out.println("\nPRUEBA 8: Eliminar organización");

        boolean eliminado = dao.eliminar(idPrueba);

        System.out.println("Resultado: "
                + (eliminado ? "Eliminación exitosa"
                : "No fue posible eliminar"));

        System.out.println("\n==================================");
        System.out.println(" FIN DE LAS PRUEBAS");
        System.out.println("==================================");
    }
}
