package View;

import Controller.OrderController;
import Model.Order;
import java.util.Scanner;

public class OrderView {
    private OrderController orderController;
    private Scanner scanner = new Scanner(System.in);

    public OrderView(OrderController orderController) {
        this.orderController = orderController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public void showMenu() {
        boolean running = true;
        while (running) {
            System.out.println("1. Crear orden");
            System.out.println("2. Ver todas las ordenes");
            System.out.println("3. Actualizar orden");
            System.out.println("4. Eliminar orden");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (choice) {
                case 1:
                    createOrder();
                    break;
                case 2:
                    viewAllOrders();
                    break;
                case 3:
                    updateOrder();
                    break;
                case 4:
                    deleteOrder();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void createOrder() {
        System.out.print("ID de la orden: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea

        System.out.print("Status ('registered'/ 'paid' / 'delivered'): ");
        String status = scanner.nextLine();

        System.out.print("Ingrese el total: ");
        int total = scanner.nextInt();

        Order order = new Order(id, status, total);
        orderController.createOrder(order);
        System.out.println("Orden creada exitosamente.");
    }

    private void viewAllOrders() {
        System.out.println("Listado de todas las órdenes:");
        var orders = orderController.getAllOrders();
        if (orders != null) {
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    private void updateOrder() {
        System.out.print("ID de la orden a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea

        System.out.print("Nuevo status ('registered'/ 'paid' / 'delivered'): ");
        String status = scanner.nextLine();

        System.out.print("Nuevo total: ");
        int total = scanner.nextInt();

        Order order = new Order(id, status, total);
        orderController.updateOrder(order);
        System.out.println("Orden actualizada exitosamente.");
    }

    private void deleteOrder() {
        System.out.print("ID de la orden a eliminar: ");
        int id = scanner.nextInt();
        orderController.deleteOrder(id);
        System.out.println("Orden eliminada exitosamente.");
    }
}
