package anime.expo;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
import connection.MySQLDataSource;

public class ExportVisitors {

    public static void showMenu() {
        MySQLDataSource dataSource = new MySQLDataSource();
        Connection conn = dataSource.conectarMySQL();

        if (conn != null) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Hola, ¿cómo estás usuario?");
            System.out.println("¿Deseas visualizar el archivo Excel de los clientes?");
            System.out.println("1. Sí");
            System.out.println("2. No");

            int userChoice = -1;
            boolean validChoice = false;

            while (!validChoice) {
                try {
                    System.out.print("Selecciona una opción (1 o 2): ");
                    userChoice = scanner.nextInt();
                    
                    if (userChoice == 1) {
                        validChoice = true;
                        String filePath = "CRM.csv";
                        exportDataToCSV(conn, filePath);
                        openCSVFile(filePath);
                    } else if (userChoice == 2) {
                        validChoice = true;
                        System.out.println("No se visualizará el archivo.");
                    } else {
                        System.out.println("Opción inválida. Por favor, selecciona 1 o 2.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, ingresa un número.");
                    scanner.next(); 
                }
            }

            scanner.close();
        } else {
            System.err.println("Conexión a la base de datos no establecida.");
        }
    }

    private static void exportDataToCSV(Connection conn, String filePath) {
        File file = new File(filePath);
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Visitors");
             PrintWriter writer = new PrintWriter(new FileWriter(file))) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            StringBuilder header = new StringBuilder();
            for (int i = 1; i <= columnCount; i++) {
                header.append("\"").append(metaData.getColumnName(i)).append("\"");
                if (i < columnCount) header.append(",");
            }
            writer.println(header.toString());

            while (rs.next()) {
                StringBuilder row = new StringBuilder();
                for (int i = 1; i <= columnCount; i++) {
                    String value = rs.getString(i);
                    if (value != null && (value.contains(",") || value.contains("\""))) {
                        value = "\"" + value.replace("\"", "\"\"") + "\"";
                    }
                    row.append(value);
                    if (i < columnCount) row.append(",");
                }
                writer.println(row.toString());
            }

            System.out.println("Datos exportados exitosamente a " + filePath);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void openCSVFile(String filePath) {
        try {
            File file = new File(filePath);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("La apertura del archivo no es soportada en este entorno.");
            }
        } catch (IOException e) {
            System.out.println("Error al intentar abrir el archivo: " + e.getMessage());
        }
    }
}
