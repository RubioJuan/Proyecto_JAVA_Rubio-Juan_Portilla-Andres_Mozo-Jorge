/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Controller.StoreInventoryController;
import Model.StoreInventory;
import java.util.Scanner;


/**
 *
 * @author Juan Felipe Rubio
 */
public class StoreInventoryView {
    public static void main(String[] args) {
       StoreInventoryController controller = new StoreInventoryController ();
       Scanner scanner = new Scanner(System.in);
       
       System.out.println("Ingrese los detalles del producto:");
            String name;
       boolean validName = false;
       while (!validName) {
           System.out.print("Nombre del producto: ");
           name = scanner.nextLine();
           
           if (controller.isStoreNameExists(name)) {
               System.out.println("Ya existe un producto con este nombre. Por favor, ingrese un nombre diferente.");
           } else {
               validName = true;
           }
           System.out.print("Description: ");
         String String = scanner.nextLine();   
    }
       
}
