/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Controller.StoreController;
import java.util.Scanner;
 

/**
 *
 * @author Juan Felipe Rubio
 */
public class StoreView {
     public static void main(String[] args) {
       StoreController controller = new StoreController ();
       Scanner scanner = new Scanner(System.in);
      
           System.out.println("Ingrese los detalles de la tienda:");
            String name;
       boolean validName = false;
       while (!validName) {
           System.out.println("Nombre de la tienda: ");
           name = scanner.nextLine();


           if (controller.isStoreNameExists(name)) {
               System.out.println("Ya existe una tienda con este nombre. Por favor, ingrese un nombre diferente.");
           } else {
               validName = true;
           }
       }
        System.out.println("Manager: ");
         String String = scanner.nextLine();
   }

}
