package org.imaohd.view;

import org.imaohd.model.User;

import java.util.List;
import java.util.Scanner;

public class UserView {

    private Scanner scanner;

    public UserView() {
        this.scanner = new Scanner(System.in);
    }

    public int showMainMenu() {
        System.out.println("\n===== SISTEMA DE GESTIÓN DE USUARIOS =====");
        System.out.println("1. Listar todos los usuarios");
        System.out.println("2. Ver detalles de un usuario");
        System.out.println("3. Crear nuevo usuario");
        System.out.println("4. Actualizar usuario existente");
        System.out.println("5. Eliminar usuario");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");

        return scanner.nextInt();
    }

    public void showUser(List<User> users) {
        System.out.println("\n===== LISTA DE USUARIOS =====");

        if (users.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        System.out.printf("%-5s %-15s %-15s %-25s %-15s\n", "ID", "NOMBRE", "APELLIDO", "EMAIL", "TELÉFONO");
        System.out.println("---------------------------------------------------------------------------------------------");

        for (User user : users) {
            System.out.printf("%-5d %-15s %-15s %-25s %-15s\n",
                    user.getId(),
                    user.getName(),
                    user.getLastname(),
                    user.getEmail(),
                    user.getCellPhone());
        }
    }

    public void showUserDetail(User user) {
        if (user == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.println("\n===== DETALLES DEL USUARIO =====");
        System.out.println(user);

    }

    public User getUserData() {
        scanner.nextLine(); // Consumir el salto de línea pendiente

        System.out.println("\n===== CREAR NUEVO USUARIO =====");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        return new User(nombre, apellido, email, telefono);
    }

    public User updateUserData(User currentUser){
        scanner.nextLine(); // Consumir el salto de línea pendiente

        System.out.println("\n===== ACTUALIZAR USUARIO =====");
        System.out.println("Datos actuales:");
        System.out.println(currentUser);
        System.out.println("\nIntroduzca los nuevos datos (dejar en blanco para mantener el valor actual):");

        System.out.print("Nombre [" + currentUser.getName() + "]: ");
        String nombre = scanner.nextLine();
        if (!nombre.isEmpty()) {
            currentUser.setName(nombre);
        }

        System.out.print("Apellido [" + currentUser.getLastname() + "]: ");
        String apellido = scanner.nextLine();
        if (!apellido.isEmpty()) {
            currentUser.setLastname(apellido);
        }

        System.out.print("Email [" + currentUser.getEmail() + "]: ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) {
            currentUser.setEmail(email);
        }

        System.out.print("Teléfono [" + currentUser.getCellPhone() + "]: ");
        String telefono = scanner.nextLine();
        if (!telefono.isEmpty()) {
            currentUser.setCellPhone(telefono);
        }

        return currentUser;
    }

    public int getUserId(String operacion) {
        System.out.print("\nIntroduzca el ID del usuario para " + operacion + ": ");
        return scanner.nextInt();
    }

    public void showMessage(String message) {
        System.out.println("\n" + message);
    }

    public boolean confirmDelete() {
        System.out.print("¿Está seguro de que desea eliminar este usuario? (S/N): ");
        scanner.nextLine(); // Consumir el salto de línea pendiente
        String response = scanner.nextLine().toUpperCase();
        return response.equals("S");
    }

    public void close() {
        scanner.close();
    }
}
