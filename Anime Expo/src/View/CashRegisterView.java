/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Controller.CashRegisterController;
import Model.CashRegister;
import java.util.Scanner;
import java.math.BigDecimal;


/**
 *
 * @author Juan Felipe Rubio
 */
public class CashRegisterView {
    public static void main(String[] args) {
        CashRegisterController controller = new CashRegisterController ();
         Scanner scanner = new Scanner(System.in);
         
          System.out.println("Ingrese los detalles de la registradora:"); {
                 System.out.print("ID de la caja Registradora:  ");
                 int register_id = scanner.nextInt();
            }
               System.out.print("Status ('active'/ 'inactive'): ");{
                 String status = scanner.nextLine();
            } 
               System.out.print("Ingrese la cantidad de importe: ");{
                 int opening_amount = scanner.nextInt(); 
               }
        }   
               
}