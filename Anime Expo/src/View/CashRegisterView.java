/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package View;

import Controller.CashRegisterController;
import Model.CashRegister;
import java.math.BigDecimal;
import java.util.Scanner;

public class CashRegisterView {
    private CashRegisterController controller;
    private Scanner scanner = new Scanner(System.in);

    public CashRegisterView(CashRegisterController controller) {
        this.controller = controller;
    }

    public void showMenu() {
        System.out.println("Ingrese los detalles de la registradora:");
        
        System.out.print("ID de la caja Registradora: ");
        int register_id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Status ('active'/ 'inactive'): ");
        String status = scanner.nextLine();

        System.out.print("Ingrese la cantidad de importe: ");
        BigDecimal opening_amount = scanner.nextBigDecimal();
        scanner.nextLine(); // Limpiar el buffer

        // Suponiendo que closing_amount es 0 al inicio
        BigDecimal closing_amount = BigDecimal.ZERO;

        // Crear un objeto CashRegister
        CashRegister cashRegister = new CashRegister(register_id, status, 1, opening_amount, closing_amount);
        
        // Usar el controlador para crear la caja registradora
        controller.createCashRegister(cashRegister);
        
        // Mostrar mensaje de éxito
        System.out.println("Caja Registradora creada exitosamente.");
    }
}
