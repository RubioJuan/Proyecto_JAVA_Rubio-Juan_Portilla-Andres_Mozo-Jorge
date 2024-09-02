/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package anime.expo;

import Dao.*;
import Controller.*;
import View.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Juan Felipe Rubio & Andres felipe Portilla (Autor Principal)
 */

public class Main {
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int errores = 0;   

    System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════╗");
    System.out.println("║                  .----------------.  .----------------.                     ║");
    System.out.println("║                 | .--------------. || .--------------. |                    ║");
    System.out.println("║                 | |      __      | || |  ____  ____  | |                    ║");
    System.out.println("║                 | |     /  \\     | || | |_  _||_  _| | |                    ║");
    System.out.println("║                 | |    / /\\ \\    | || |   \\ \\  / /   | |                    ║");
    System.out.println("║                 | |   / ____ \\   | || |    > `' <    | |                    ║");
    System.out.println("║                 | | _/ /    \\ \\_ | || |  _/ /'`\\ \\_  | |                    ║");
    System.out.println("║                 | ||____|  |____|| || | |____||____| | |                    ║");
    System.out.println("║                 | |              | || |              | |                    ║");
    System.out.println("║                 | '--------------' || '--------------' |                    ║");
    System.out.println("║                  '----------------'  '----------------'                     ║");
    System.out.println("║      ____  ____   ____  ___ ___    ___        ___  __ __  ____    ___       ║");
    System.out.println("║     /    ||    \\ |    ||   |   |  /  _]      /  _]|  |  ||    \\  /   \\      ║");
    System.out.println("║    |  o  ||  _  | |  | | _   _ | /  [_      /  [_ |  |  ||  o  )|     |     ║");
    System.out.println("║    |     ||  |  | |  | |  \\_/  ||    _]    |    _]|_   _||   _/ |  O  |     ║");
    System.out.println("║    |  _  ||  |  | |  | |   |   ||   [_     |   [_ |     ||  |   |     |     ║");
    System.out.println("║    |  |  ||  |  | |  | |   |   ||     |    |     ||  |  ||  |   |     |     ║");
    System.out.println("║    |__|__||__|__||____||___|___||_____|    |_____||__|__||__|    \\___/      ║");
    System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════╝");

            while (true) {
                System.out.print("\033[H\033[2J");
                System.out.flush();

                System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════╗");
                System.out.println("║                              Panel de Control                               ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════╝");
                System.out.println("║Hola usuario, bienvenido a nuestro software de gestión de eventos.           ║");
                System.out.println("║¿Con qué rol te identificas en nuestra compañía?                             ║");
                System.out.println("║                                                                             ║"  );
                System.out.println("║1. Administrador de evento                                                   ║");
                System.out.println("║2. Encargado de Actividades                                                  ║");
                System.out.println("║3. Administrador de restaurante                                              ║");
                System.out.println("║4. Administrador de tiendas                                                  ║");
                System.out.println("║5. Encargado de taquilla                                                     ║");
                System.out.println("║6. Salir del sistema                                                         ║");
                System.out.println("║══════════════════════════════════════════════════════════════════════════════════════════║");
                System.out.print("Por favor, selecciona una opción: ");

                int opcion = 0;

                try {
                    opcion = scanner.nextInt(); 
                    errores = 0; 

                    switch (opcion) {
                        case 1:
                            administrarEvento(scanner);
                            break;
                        case 2:
                            CoordinadorDeActividades(scanner);
                            break;
                        case 3:
                            GerenteDeRestaurante(scanner);
                            break;
                        case 4:
                            GerenteDeTienda(scanner);
                            break;
                        case 5:
                            SupervisorDeTaquilla(scanner);  
                            break;
                        case 6:
                        System.out.println("Saliendo del sistema.");
                        return; 
                        default:
                            errores++;
                            if (errores < 3) {
                                System.out.println("Opción no válida. Por favor selecciona una opción entre 1 y 5.");
                            } else {
                                System.out.println("Has cometido varios errores. Por favor, selecciona una opción válida.");
                            }
                            scanner.nextLine(); 
                            break;
                    }
                } catch (InputMismatchException e) {

                    System.out.println("Entrada no válida. Por favor ingresa un número entero.");
                    errores++;
                    scanner.nextLine(); 
                    if (errores >= 3) {
                        System.out.println("Has cometido varios errores. Por favor, selecciona una opción válida.");
                    }
                }

                if (opcion >= 1 && opcion <= 6) {
                    break;
                }
            }

            scanner.close();
        }

      // -----------------------------------------------------------------
      //-----------------------ADMINISTRACION EVENTOS---------------------
      //------------------------------------------------------------------

    private static void administrarEvento(Scanner scanner) {
        int errores = 0; 

        while (true) {
            System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                      Panel de Administración de Eventos                     ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("║Hola Administrador, te damos la bienvenida a nuestro panel de administración ║");
            System.out.println("║de eventos, ¿Podrías regalarnos tu nombre para referirnos a ti?              ║");
            System.out.print("Por favor, ingresa tu nombre: ");
            String nombre = scanner.next();
            System.out.println("Listo " + nombre + ", en esta sección podrás entrar a los siguientes módulos:");
            System.out.println("║1. Gestionar eventos                                                         ║");
            System.out.println("║2. Revisar informes                                                          ║");
            System.out.println("║3. Configurar eventos                                                        ║");
            System.out.println("║4. Panel de archivo Excel CRM                                                ║");
            System.out.println("║5. Inventario del evento                                                     ║");
            System.out.println("║6. Volver                                                                    ║");
            System.out.println("║══════════════════════════════════════════════════════════════════════════════════════════║");
            System.out.print("Por favor, selecciona una opción: ");

            int opcion = 0;

            try {
                opcion = scanner.nextInt(); 
                errores = 0; 

                switch (opcion) {
                    case 1:
                        System.out.println("Seleccionaste gestionar eventos.");
                        EventDao eventDao = new EventDao();
                        EventView
                         eventView = new EventView();
                        EventController eventController = new EventController(eventDao, eventView);
                        eventView.setEventController(eventController);
                        eventView.showMenu();
                        break;
                    case 2:
                        System.out.println("Seleccionaste revisar informes.");
                        VisitorFeedbackDao visitorFeedbackDao = new VisitorFeedbackDao();
                        VisitorFeedbackView visitorFeedbackView = new VisitorFeedbackView();
                        VisitorFeedbackController visitorFeedbackController = new VisitorFeedbackController(visitorFeedbackDao);
                        visitorFeedbackView.setVisitorFeedbackController(visitorFeedbackController);
                        visitorFeedbackView.showMenu();
                        break;
                    case 3:
                        System.out.println("Seleccionaste configurar eventos.");
                        EventStaffDao eventStaffDao = new EventStaffDao();
                        EventStaffView eventStaffView = new EventStaffView(); 
                        EventStaffController eventStaffController = new EventStaffController(eventStaffDao);
                        eventStaffView.setEventStaffController(eventStaffController);
                        eventStaffView.showMenu();
                        break;
                    case 4:
                        System.out.println("Seleccionaste el panel de CRM.");
                        ExportVisitors.showMenu();
                        break;
                    case 5:
                        System.out.println("Seleccionaste el inventario de eventos");
                        InventoryDao inventoryDao = new InventoryDao();
                        InventoryController inventoryController = new InventoryController(inventoryDao);
                        InventoryView inventoryView = new InventoryView(inventoryController);
                        inventoryView.showMenu();
                        break;
                    case 6:
                       System.out.println("Volviendo al menu principal.");
                       return; 
                    default:
                        errores++;
                        if (errores < 3) {
                            System.out.println("Opción no válida. Por favor selecciona una opción entre 1 y 4.");
                        } else {
                            System.out.println("Has cometido varios errores. Por favor, selecciona una opción válida.");
                        }
                        scanner.nextLine(); 
                        break;
                }
            } catch (InputMismatchException e) {

                System.out.println("Entrada no válida. Por favor ingresa un número entero.");
                errores++;
                scanner.nextLine(); 
                if (errores >= 3) {
                    System.out.println("Has cometido varios errores. Por favor, selecciona una opción válida.");
                }
            }
        }
    }

      // -----------------------------------------------------------------
      //----------------------Coordinador de Actividades------------------
      //------------------------------------------------------------------

    private static void CoordinadorDeActividades(Scanner scanner) {
        int errores = 0; 

        while (true) {
            System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                    Panel de Coordinación de Actividades                     ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("║Hola Coordinador, te damos la bienvenida a nuestro panel de Cordinación      ║");
            System.out.println("║de actividades, ¿Podrías regalarnos tu nombre para referirnos a ti?          ║");
            System.out.print("Por favor, ingresa tu nombre: ");
            String nombre = scanner.next();
            System.out.println("Listo " + nombre + ", en esta sección podrás entrar a los siguientes módulos:");
            System.out.println("║1. Administración de Actividades                                             ║");
            System.out.println("║2. Manejo de Premios                                                         ║");
            System.out.println("║3. Gestión de Cosplays                                                       ║");
            System.out.println("║4. Programación de Enfrentamientos                                           ║");
            System.out.println("║5. Diseño de Preguntas                                                       ║");
            System.out.println("║6. Clasificación de Preguntas                                                ║");
            System.out.println("║7. Gestión de Rondas                                                         ║");
            System.out.println("║8. Control de Puntuaciones                                                   ║");
            System.out.println("║9. Gestión de Jurados                                                        ║");
            System.out.println("║10.Gestión de Participantes                                                  ║");
            System.out.println("║11.Volver                                                                    ║");
            System.out.println("║══════════════════════════════════════════════════════════════════════════════════════════║");
            System.out.print("Por favor, selecciona una opción: ");

            int opcion = 0;

            try {
                opcion = scanner.nextInt(); 
                errores = 0; 

                switch (opcion) {
                    case 1:
                        System.out.println("Seleccionaste gestionar actividades.");

                        ActivityDao activityDao = new ActivityDao();
                        ActivityView activityView = new ActivityView(null); 
                        ActivityController activityController = new ActivityController(activityDao, activityView);
                        activityView = new ActivityView(activityController);
                        activityController = new ActivityController(activityDao, activityView);
                        activityView.showMenu();
                        break;
                    case 2:
                        System.out.println("Seleccionaste manejo de premios.");

                            ActivityPrizeDao activityPrizeDao = new ActivityPrizeDao();
                            ActivityPrizeView activityPrizeView = new ActivityPrizeView(null);
                            ActivityPrizeController activityPrizeController = new ActivityPrizeController(activityPrizeDao, activityPrizeView);
                            activityPrizeView = new ActivityPrizeView(activityPrizeController);
                            activityPrizeController = new ActivityPrizeController(activityPrizeDao, activityPrizeView);
                            activityPrizeView.showMenu();
                        break;
                    case 3:
                        System.out.println("Seleccionaste gestionar cosplay.");

                            CosplayCategoryDao cosplayCategoryDao = new CosplayCategoryDao();
                            CosplayCategoryView cosplayCategoryView = new CosplayCategoryView(null); 
                            CosplayCategoryController cosplayCategoryController = new CosplayCategoryController(cosplayCategoryDao, cosplayCategoryView);
                            cosplayCategoryView.cosplayCategoryController = cosplayCategoryController;
                            cosplayCategoryView.showMenu();

                        break;
                    case 4:
                        System.out.println("Programación de enfrentamientos.");
                        MatchupDao matchupDao = new MatchupDao();
                        MatchupView matchupView = new MatchupView(null); 
                        MatchupController matchupController = new MatchupController(matchupDao, matchupView);
                        matchupView.matchupController = matchupController;
                        matchupView.showMenu();
                        break;
                    case 5:
                        System.out.println("Diseño de preguntas.");
                        QuestionDao questionDao = new QuestionDao();
                        QuestionView questionView = new QuestionView(null); 
                        QuestionController questionController = new QuestionController(questionDao, questionView);
                        questionView.questionController = questionController;
                        questionView.showMenu();
                        break;
                    case 6:
                        System.out.println("Seleccionaste configurar Categorias preguntas.");
                        QuestionCategoryDao categoryDao = new QuestionCategoryDao();
                        QuestionCategoryView categoryView = new QuestionCategoryView(null); 
                        QuestionCategoryController categoryController = new QuestionCategoryController(categoryDao, categoryView);
                        categoryView.categoryController = categoryController;
                        categoryView.showMenu();

                        break;
                    case 7:
                        System.out.println("Gestión de rondas.");
                        RoundDao roundDao = new RoundDao();
                        RoundView roundView = new RoundView(null); 
                        RoundController roundController = new RoundController(roundDao, roundView);
                        roundView.roundController = roundController;
                        roundView.showMenu();
                        break;
                    case 8:
                        System.out.println("Seleccionaste control de puntaciones");
                        ScoreDao scoreDao = new ScoreDao();
                        ScoreView scoreView = new ScoreView(null); 
                        ScoreController scoreController = new ScoreController(scoreDao, scoreView);
                        scoreView.scoreController = scoreController;
                        scoreView.showMenu();
                        break;
                    case 9:
                        System.out.println("Seleccionaste gestión de jurados.");
                        JudgeDao judgeDao = new JudgeDao();
                        JudgeView judgeView = new JudgeView(null);
                        JudgeController judgeController = new JudgeController(judgeDao, judgeView);
                        judgeView.judgeController = judgeController;
                        judgeView.showMenu();

                        break;
                    case 10:
                        System.out.println("Seleccionaste gestionar participantes.");
                        ParticipantDao participantDao = new ParticipantDao();
                        ParticipantView participantView = new ParticipantView(null); 
                        ParticipantController participantController = new ParticipantController(participantDao, participantView);
                        participantView.participantController = participantController;
                        participantView.showMenu();
                        break;
                    case 11:
                        System.out.println("Saliendo del panel de coordinación de actividades .");
                        return;
                    default:
                        errores++;
                        if (errores < 3) {
                            System.out.println("Opción no válida. Por favor selecciona una opción entre 1 y 11.");
                        } else {
                            System.out.println("Has cometido varios errores. Por favor, selecciona una opción válida.");
                        }
                        scanner.nextLine(); 
                        break;
                }
            } catch (InputMismatchException e) {

                System.out.println("Entrada no válida. Por favor ingresa un número entero.");
                errores++;
                scanner.nextLine(); 
                if (errores >= 3) {
                    System.out.println("Has cometido varios errores. Por favor, selecciona una opción válida.");
                }
            }
        }
    }
      // -----------------------------------------------------------------
      //-----------------------Gerente de Restaurante---------------------
      //------------------------------------------------------------------

    private static void GerenteDeRestaurante(Scanner scanner) {
        int errores = 0; 

        while (true) {
            System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                      Panel de Gerencia de Restaurante                       ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("║Hola Gerente, te damos la bienvenida a nuestro panel de gerencia ║");
            System.out.println("║de restaurantes, ¿Podrías regalarnos tu nombre para referirnos a ti?         ║");
            System.out.print("Por favor, ingresa tu nombre: ");
            String nombre = scanner.next();
            System.out.println("Listo " + nombre + ", en esta sección podrás entrar a los siguientes módulos:");
            System.out.println("║1. Administración de Restaurantes                                            ║");
            System.out.println("║2. Gestión de Menús                                                          ║");
            System.out.println("║3. Inventario de Ingredientes                                                ║");
            System.out.println("║4. Gestión de Pedidos                                                        ║");
            System.out.println("║5. Volver                                                                    ║");
            System.out.println("║══════════════════════════════════════════════════════════════════════════════════════════║");
            System.out.print("Por favor, selecciona una opción: ");

            int opcion = 0;

            try {
                opcion = scanner.nextInt(); 
                errores = 0; 

                switch (opcion) {
                    case 1:
                        System.out.println("Seleccionaste administracción del restaurante.");
                        RestaurantDao restaurantDao = new RestaurantDao();
                        RestaurantController restaurantController = new RestaurantController(restaurantDao);
                        RestaurantView restaurantView = new RestaurantView(restaurantController);
                        restaurantView.displayMenu();
                        break;
                    case 2:
                        System.out.println("Seleccionaste la gestión de menú de restaurantes.");
                        RestaurantMenuDao restaurantMenuDao = new RestaurantMenuDao();
                        RestaurantMenuView restaurantMenuView = new RestaurantMenuView(null); 
                        RestaurantMenuController restaurantMenuController = new RestaurantMenuController(restaurantMenuDao);
                        restaurantMenuView.setMenuController(restaurantMenuController);
                        restaurantMenuView.displayMenu();
                        break;
                    case 3:
                        System.out.println("Seleccionaste menu de ingredientes.");

                        IngredientInventoryDao ingredientInventoryDao = new IngredientInventoryDao();
                        IngredientInventoryController ingredientInventoryController = new IngredientInventoryController(ingredientInventoryDao);
                        IngredientInventoryView ingredientInventoryView = new IngredientInventoryView(null);
                        ingredientInventoryView.setInventoryController(ingredientInventoryController);
                        ingredientInventoryView.displayMenu();
                        break;
                    case 4:
                        System.out.println("Seleccionaste una orden.");
                        OrderDao orderDao = new OrderDao();
                        OrderController orderController = new OrderController(orderDao);
                        OrderView orderView = new OrderView(null);
                        orderView.setOrderController(orderController);
                        orderView.showMenu();
                        break;                    
                    case 5:
                        System.out.println("Volviendo al menu principal.");
                        return; 
                    default:
                        errores++;
                        if (errores < 3) {
                            System.out.println("Opción no válida. Por favor selecciona una opción entre 1 y 5.");
                        } else {
                            System.out.println("Has cometido varios errores. Por favor, selecciona una opción válida.");
                        }
                        scanner.nextLine(); 
                        break;
                }
            } catch (InputMismatchException e) {

                System.out.println("Entrada no válida. Por favor ingresa un número entero.");
                errores++;
                scanner.nextLine(); 
                if (errores >= 3) {
                    System.out.println("Has cometido varios errores. Por favor, selecciona una opción válida.");
                }
            }
        }
    }
      // -----------------------------------------------------------------
      //-----------------------Gerente de Tienda---------------------
      //------------------------------------------------------------------

    private static void GerenteDeTienda(Scanner scanner) {
        int errores = 0; 

        while (true) {
            System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                      Panel de Gerencia de Tiendas                           ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("║Hola Gerente, te damos la bienvenida a nuestro panel de gerencia             ║");
            System.out.println("║de tiendas, ¿Podrías regalarnos tu nombre para referirnos a ti?              ║");
            System.out.print("Por favor, ingresa tu nombre: ");
            String nombre = scanner.next();
            System.out.println("Listo " + nombre + ", en esta sección podrás entrar a los siguientes módulos:");
            System.out.println("║1. Administración de Tiendas                                                 ║");
            System.out.println("║2.  Inventario de Tiendas                                                    ║");
            System.out.println("║3. Gestión de Pedidos                                                        ║");
            System.out.println("║4. Salir                                                                     ║");
            System.out.println("║══════════════════════════════════════════════════════════════════════════════════════════║");
            System.out.print("Por favor, selecciona una opción: ");

            int opcion = 0;

            try {
                opcion = scanner.nextInt(); 
                errores = 0; 

                switch (opcion) {
                    case 1:
                        System.out.println("Seleccionaste admistracición de tiendas.");
                        StoreDao storeDao = new StoreDao();
                        StoreView storeView = new StoreView(null); 
                        StoreController storeController = new StoreController(storeDao, storeView);
                        storeView = new StoreView(storeController); 
                        storeController = new StoreController(storeDao, storeView);
                        storeView.showMenu();
                        break;
                    case 2:
                        System.out.println("Seleccionaste inventario de tiendas.");
                        StoreInventoryDao storeInventoryDao = new StoreInventoryDao();
                        StoreInventoryView storeInventoryView = new StoreInventoryView(null); 
                        StoreInventoryController storeInventoryController = new StoreInventoryController(storeInventoryDao, storeInventoryView);
                        storeInventoryView = new StoreInventoryView(storeInventoryController); 
                        storeInventoryController = new StoreInventoryController(storeInventoryDao, storeInventoryView);
                        storeInventoryView.showMenu();
                        break;
                    case 3:
                      System.out.println("Seleccionaste una orden.");
                        OrderDao orderDao = new OrderDao();
                        OrderController orderController = new OrderController(orderDao);
                        OrderView orderView = new OrderView(null);
                        orderView.setOrderController(orderController);
                        orderView.showMenu();
                        break;      
                    case 4:
                        System.out.println("Saliendo del panel de gerencia de tiendas.");
                        return; 
                    default:
                        errores++;
                        if (errores < 3) {
                            System.out.println("Opción no válida. Por favor selecciona una opción entre 1 y 4.");
                        } else {
                            System.out.println("Has cometido varios errores. Por favor, selecciona una opción válida.");
                        }
                        scanner.nextLine(); 
                        break;
                }
            } catch (InputMismatchException e) {

                System.out.println("Entrada no válida. Por favor ingresa un número entero.");
                errores++;
                scanner.nextLine(); 
                if (errores >= 3) {
                    System.out.println("Has cometido varios errores. Por favor, selecciona una opción válida.");
                }
            }
        }
    }
      // -----------------------------------------------------------------
      //-----------------------Supervisor de Taquilla---------------------
      //------------------------------------------------------------------

    private static void SupervisorDeTaquilla(Scanner scanner) {
        int errores = 0; 

        while (true) {
            System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                      Panel de Supervisión de Taquillas                      ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("║Hola Supervisor, te damos la bienvenida a nuestro panel de supervisión       ║");
            System.out.println("║de taquillas, ¿Podrías regalarnos tu nombre para referirnos a ti?            ║");
            System.out.print("Por favor, ingresa tu nombre: ");
            String nombre = scanner.next();
            System.out.println("Listo " + nombre + ", en esta sección podrás entrar a los siguientes módulos:");
            System.out.println("║1. Gestión de Tickets                                                        ║");
            System.out.println("║2. Administración de Visitantes                                              ║");
            System.out.println("║3. Configuración y Gestión de Cajas Registradoras                            ║");
            System.out.println("║4. Salir                                                                     ║");
            System.out.println("║══════════════════════════════════════════════════════════════════════════════════════════║");
            System.out.print("Por favor, selecciona una opción: ");

            int opcion = 0;

            try {
                opcion = scanner.nextInt(); 
                errores = 0; 

                switch (opcion) {
                    case 1:
                        System.out.println("Seleccionaste la gestión de tickets.");
                        TicketDao ticketDao = new TicketDao();
                        TicketView ticketView = new TicketView(null);
                        TicketController ticketController = new TicketController(ticketDao, ticketView);
                        ticketView.setTicketController(ticketController);
                        ticketView.showMenu();
                        break;
                    case 2:
                        System.out.println("Seleccionaste administración de visitantes.");
                        VisitorDao visitorDao = new VisitorDao();
                        VisitorView visitorView = new VisitorView(null); 
                        VisitorController visitorController = new VisitorController(visitorDao, visitorView);
                        visitorView.setVisitorController(visitorController);
                        visitorView.showMenu();
                        break;
                    case 3:
                        System.out.println("Seleccionaste la configuración y gestión de la caja administradora.");
                        CashRegisterDao cashRegisterDao = new CashRegisterDao();
                        CashRegisterController cashRegisterController = new CashRegisterController(cashRegisterDao);
                        CashRegisterView cashRegisterView = new CashRegisterView(cashRegisterController);
                        cashRegisterView.showMenu();
                        break;
                    case 4:
                        System.out.println("Saliendo del panel de supervisión de taquillas.");
                        return; 
                    default:
                        errores++;
                        if (errores < 3) {
                            System.out.println("Opción no válida. Por favor selecciona una opción entre 1 y 4.");
                        } else {
                            System.out.println("Has cometido varios errores. Por favor, selecciona una opción válida.");
                        }
                        scanner.nextLine(); 
                        break;
                }
            } catch (InputMismatchException e) {

                System.out.println("Entrada no válida. Por favor ingresa un número entero.");
                errores++;
                scanner.nextLine(); 
                if (errores >= 3) {
                    System.out.println("Has cometido varios errores. Por favor, selecciona una opción válida.");
                }
            }
        }
    }
}