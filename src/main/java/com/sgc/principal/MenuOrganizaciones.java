package com.sgc.principal;

import com.sgc.dao.OrganizacionDAO;
import com.sgc.modelo.Organizacion;
import java.util.List;
import java.util.Scanner;

public class MenuOrganizaciones {

    private static final Scanner teclado = new Scanner(System.in);
    private static final OrganizacionDAO dao = new OrganizacionDAO();

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n==================================");
            System.out.println(" SISTEMA DE GESTION DE ORGANIZACIONES");
            System.out.println("==================================");
            System.out.println("1. Registrar organizacion");
            System.out.println("2. Listar organizaciones");
            System.out.println("3. Buscar organizacion");
            System.out.println("4. Actualizar organizacion");
            System.out.println("5. Eliminar organizacion");
            System.out.println("0. Salir");
            System.out.println("----------------------------------");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(teclado.nextLine());

                switch (opcion) {
                    case 1:
                        registrar();
                        break;
                    case 2:
                        listar();
                        break;
                    case 3:
                        buscar();
                        break;
                    case 4:
                        actualizar();
                        break;
                    case 5:
                        eliminar();
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }

            } catch (NumberFormatException e) {
                opcion = -1;
                System.out.println("Debe ingresar un numero valido.");
            }

        } while (opcion != 0);

        teclado.close();
    }

    private static void registrar() {
        System.out.println("\n--- REGISTRO DE ORGANIZACION ---");

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Identificacion: ");
        String identificacion = teclado.nextLine();

        System.out.print("Direccion: ");
        String direccion = teclado.nextLine();

        System.out.print("Telefono: ");
        String telefono = teclado.nextLine();

        System.out.print("Correo electronico: ");
        String correo = teclado.nextLine();

        Organizacion organizacion = new Organizacion(
                nombre, identificacion, direccion, telefono, correo
        );

        boolean resultado = dao.registrar(organizacion);

        if (resultado) {
            System.out.println("Organizacion registrada correctamente.");
        } else {
            System.out.println("No fue posible registrar la organizacion.");
        }
    }

    private static void listar() {
        System.out.println("\n--- LISTADO DE ORGANIZACIONES ---");

        List<Organizacion> organizaciones = dao.listar();

        if (organizaciones.isEmpty()) {
            System.out.println("No hay organizaciones registradas.");
        } else {
            for (Organizacion organizacion : organizaciones) {
                System.out.println(organizacion);
            }
        }
    }

    private static void buscar() {
        System.out.println("\n--- BUSCAR ORGANIZACION ---");
        System.out.print("Ingrese el ID de la organizacion: ");

        try {
            int id = Integer.parseInt(teclado.nextLine());
            Organizacion organizacion = dao.buscarPorId(id);

            if (organizacion != null) {
                System.out.println("Organizacion encontrada:");
                System.out.println(organizacion);
            } else {
                System.out.println("No se encontro la organizacion.");
            }

        } catch (NumberFormatException e) {
            System.out.println("El ID debe ser un numero entero.");
        }
    }

    private static void actualizar() {
        System.out.println("\n--- ACTUALIZAR ORGANIZACION ---");
        System.out.print("Ingrese el ID de la organizacion: ");

        try {
            int id = Integer.parseInt(teclado.nextLine());
            Organizacion organizacion = dao.buscarPorId(id);

            if (organizacion == null) {
                System.out.println("No se encontro la organizacion.");
                return;
            }

            System.out.println("Registro actual: " + organizacion);

            System.out.print("Nuevo nombre: ");
            organizacion.setNombre(teclado.nextLine());

            System.out.print("Nueva identificacion: ");
            organizacion.setIdentificacion(teclado.nextLine());

            System.out.print("Nueva direccion: ");
            organizacion.setDireccion(teclado.nextLine());

            System.out.print("Nuevo telefono: ");
            organizacion.setTelefono(teclado.nextLine());

            System.out.print("Nuevo correo electronico: ");
            organizacion.setCorreo(teclado.nextLine());

            boolean resultado = dao.actualizar(organizacion);

            if (resultado) {
                System.out.println("Organizacion actualizada correctamente.");
            } else {
                System.out.println("No fue posible actualizar la organizacion.");
            }

        } catch (NumberFormatException e) {
            System.out.println("El ID debe ser un numero entero.");
        }
    }

    private static void eliminar() {
        System.out.println("\n--- ELIMINAR ORGANIZACION ---");
        System.out.print("Ingrese el ID de la organizacion: ");

        try {
            int id = Integer.parseInt(teclado.nextLine());
            Organizacion organizacion = dao.buscarPorId(id);

            if (organizacion == null) {
                System.out.println("No se encontro la organizacion.");
                return;
            }

            System.out.println("Organizacion seleccionada: " + organizacion);
            System.out.print("Confirme la eliminacion (S/N): ");

            String confirmacion = teclado.nextLine();

            if (confirmacion.equalsIgnoreCase("S")) {
                boolean resultado = dao.eliminar(id);

                if (resultado) {
                    System.out.println("Organizacion eliminada correctamente.");
                } else {
                    System.out.println("No fue posible eliminar la organizacion.");
                }
            } else {
                System.out.println("Eliminacion cancelada.");
            }

        } catch (NumberFormatException e) {
            System.out.println("El ID debe ser un numero entero.");
        }
    }
}