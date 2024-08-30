/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Controller.OrderController;
import java.util.Scanner;

/**
 *
 * @author Juan Felipe Rubio
 */
public class OrderView {
    public static void main(String[] args) {
        OrderController controller = new OrderController ();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese los detalles de la orden: "); {
                 System.out.print("ID de la orden:  ");
                 int order_id = scanner.nextInt();
            }
        System.out.print("Status ('registered'/ 'paid' / 'delivered'): ");{
                 String status = scanner.nextLine();
            }
        System.out.print("Ingrese el total: ");{
                 int total_amount = scanner.nextInt(); 
               }
    }
}
