package Org.seguimiento.Application;

import Org.seguimiento.Application.Service.PacienteServiceImpl;
import Org.seguimiento.domain.Paciente;
import Org.seguimiento.infraestructure.repository.CitasRepositoryImpl;
import Org.seguimiento.infraestructure.repository.PacienteRepositoryImpl;
import Org.seguimiento.interfaces.CitasRepository;
import Org.seguimiento.interfaces.PacienteRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CitasRepositoryImpl citasService;
    private static final PacienteServiceImpl pacienteService;

    static {

        PacienteRepository pacienteRepository = new PacienteRepositoryImpl();
        pacienteService = new PacienteServiceImpl(pacienteRepository);

        CitasRepository citasRepository= new CitasRepositoryImpl();
        citasService = new CitasRepositoryImpl();
    }

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("1. Listar pacientes");
            System.out.println("2. Registrar nuevo paciente");
            System.out.println("3. Actualizar datos del paciente");
            System.out.println("4. Registrar nueva cita para un paciente existente");
            System.out.println("5. Eliminar una cita asignada");
            System.out.println("6. Mostrar la lista de citas registradas para un paciente específico");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    listarPacientes();
                    break;
                case 2:
                    registrarPaciente();
                    break;
                case 3:
                    actualizarPaciente();
                    break;
                case 4:
                    registrarCita();
                    break;
                case 5:
                    eliminarPaciente();
                    break;
                case 6:
                    mostrarCitasPaciente();
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private static void eliminarPaciente() {

    }

    private static void mostrarCitasPaciente() {

    }

    private static void listarPacientes() {
        List<Paciente> pacientes = pacienteService.findAll();
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
        } else {
            System.out.println("Listado de pacientes:");
            for (Paciente paciente : pacientes) {
                System.out.println(paciente);
            }
        }
    }

    private static void registrarPaciente() {
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del paciente: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese la edad del paciente: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingrese el género del paciente (Masculino/Femenino/Otro): ");
        String genero = scanner.nextLine();
        System.out.print("Ingrese la dirección del paciente: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese el teléfono del paciente: ");
        String telefono = scanner.nextLine();

        Paciente paciente = new Paciente();
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setEdad(edad);
        paciente.setGenero(genero);
        paciente.setDireccion(direccion);
        paciente.setTelefono(telefono);

        try {
            pacienteService.save(paciente);
            System.out.println("Paciente registrado exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void actualizarPaciente() {
        System.out.print("Ingrese el ID del paciente a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Paciente paciente = pacienteService.findById(id);
        if (paciente == null) {
            System.out.println("No se encontró el paciente con ID " + id);
            return;
        }

        System.out.print("Ingrese el nuevo nombre del paciente (dejar en blanco para no cambiar): ");
        String nombre = scanner.nextLine();
        if (!nombre.isEmpty()) {
            paciente.setNombre(nombre);
        }

        System.out.print("Ingrese el nuevo apellido del paciente (dejar en blanco para no cambiar): ");
        String apellido = scanner.nextLine();
        if (!apellido.isEmpty()) {
            paciente.setApellido(apellido);
        }

        System.out.print("Ingrese la nueva edad del paciente (0 para no cambiar): ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        if (edad > 0) {
            paciente.setEdad(edad);
        }

        System.out.print("Ingrese el nuevo género del paciente (dejar en blanco para no cambiar): ");
        String genero = scanner.nextLine();
        if (!genero.isEmpty()) {
            paciente.setGenero(genero);
        }

        System.out.print("Ingrese la nueva dirección del paciente (dejar en blanco para no cambiar): ");
        String direccion = scanner.nextLine();
        if (!direccion.isEmpty()) {
            paciente.setDireccion(direccion);
        }

        System.out.print("Ingrese el nuevo teléfono del paciente (dejar en blanco para no cambiar): ");
        String telefono = scanner.nextLine();
        if (!telefono.isEmpty()) {
            paciente.setTelefono(telefono);
        }

        try {
            pacienteService.update(paciente);
            System.out.println("Datos del paciente actualizados exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void registrarCita() {
        System.out.print("Ingrese el ID del paciente para registrar la cita: ");
        int idPaciente = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Paciente paciente = pacienteService.findById(idPaciente);
        if (paciente == null) {
            System.out.println("No se encontró el paciente con ID " + idPaciente);
            return;
        }

        System.out.print("Ingrese la fecha de la cita (formato: dd/mm/yyyy): ");
        String fecha = scanner.nextLine();
    }
}

