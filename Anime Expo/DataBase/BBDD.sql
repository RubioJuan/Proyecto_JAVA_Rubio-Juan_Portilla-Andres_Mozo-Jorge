# *********************************
# *** DataBase - Anime Expo ***
# *********************************

create database AnimeExpo;

use AnimeExpo;

-- Tabla Eventos
CREATE TABLE Events (
    event_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    country VARCHAR(100),
    city VARCHAR(100),
    address VARCHAR(255),
    max_capacity INT,
    date_time DATETIME,
    organizer VARCHAR(255),
    age_rating  VARCHAR(50),
    status ENUM('activo', 'finalizado', 'pendiente') NOT NULL,
    min_age_with_guardian  INT DEFAULT NULL, -- Edad mínima para ingresar con un adulto
    min_age_without_guardian  INT DEFAULT NULL -- Edad mínima para ingresar solo
);

-- Tabla Personal_Eventos
CREATE TABLE Event_Staff (
    staff_id  INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    id_number VARCHAR(100),
    birth_date DATE,
    role VARCHAR(100),
	status ENUM('assigned', 'no task', 'dismissed', 'incapacitated') NOT NULL,
    event_id INT,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- Table Staff_Roles
CREATE TABLE Staff_Roles (
    role_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    task_1 VARCHAR(255),
    task_2 VARCHAR(255)
);

-- Table Event_Inventory
CREATE TABLE Event_Inventory (
    inventory_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    quantity INT,
    status ENUM('In warehouse', 'On site'),
    event_id INT,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- Table Ticket_Offices
CREATE TABLE Ticket_Offices (
    ticket_office_id INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT,
    location VARCHAR(255),
    contact_number VARCHAR(100),
    manager INT,
    FOREIGN KEY (event_id) REFERENCES Events(event_id),
    FOREIGN KEY (manager) REFERENCES Event_Staff(staff_id)
);

-- Table Ticket_Types
CREATE TABLE Ticket_Types (
    ticket_type_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    price DECIMAL(10, 2),
    age_rating VARCHAR(50),
    additional_costs DECIMAL(10, 2) DEFAULT 0,
    status ENUM('paid', 'reserved') NOT NULL
);

-- Table Tickets
CREATE TABLE Tickets (
    ticket_id INT AUTO_INCREMENT PRIMARY KEY,
    ticket_type_id INT,
    customer VARCHAR(255),
    FOREIGN KEY (ticket_type_id) REFERENCES Ticket_Types(ticket_type_id)
);

-- Table Visitors
CREATE TABLE Visitors (
    visitor_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    id_number VARCHAR(100),
    gender ENUM('male', 'female', 'other'),
    birth_date DATE,
    email VARCHAR(255),
    phone_number VARCHAR(50),
    ticket_office_id INT,
    FOREIGN KEY (ticket_office_id) REFERENCES Ticket_Offices(ticket_office_id)
);

-- Table Activities
CREATE TABLE Activities (
    activity_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    type ENUM('Cosplay', 'Trivia'),
    category VARCHAR(100),
    participant_count INT,
    event_id INT,
    start_time TIME,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- Table Prizes
CREATE TABLE Prizes (
    prize_id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(100),
    description TEXT,
    value DECIMAL(10, 2),
    status ENUM('available', 'delivered'),
    activity_id INT,
    participant_id INT,
    FOREIGN KEY (activity_id) REFERENCES Activities(activity_id),
    FOREIGN KEY (participant_id) REFERENCES Visitors(visitor_id)
);

-- Table Visitor_Feedback
CREATE TABLE Visitor_Feedback (
    feedback_id INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT,
    visitor_id INT,
    comment TEXT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    FOREIGN KEY (event_id) REFERENCES Events(event_id),
    FOREIGN KEY (visitor_id) REFERENCES Visitors(visitor_id)
);

-- Table Ticket_History
CREATE TABLE Ticket_History (
    history_id INT AUTO_INCREMENT PRIMARY KEY,
    ticket_id INT,
    previous_status ENUM('paid', 'reserved'),
    new_status ENUM('paid', 'reserved'),
    change_date DATETIME,
    FOREIGN KEY (ticket_id) REFERENCES Tickets(ticket_id)
);

-- Table Inventory_History
CREATE TABLE Inventory_History (
    history_id INT AUTO_INCREMENT PRIMARY KEY,
    inventory_id INT,
    previous_quantity INT,
    new_quantity INT,
    change_date DATETIME,
    FOREIGN KEY (inventory_id) REFERENCES Event_Inventory(inventory_id)
);

-- Table Users
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    role ENUM('admin', 'manager', 'visitor')
);

-- Table Cash_Registers
CREATE TABLE Cash_Registers (
    register_id INT AUTO_INCREMENT PRIMARY KEY,
    status ENUM('active', 'inactive') DEFAULT 'inactive',
    operator INT,
    opening_amount DECIMAL(10, 2),
    closing_amount DECIMAL(10, 2),
    FOREIGN KEY (operator) REFERENCES Event_Staff(staff_id)
);

-- Table Stores
CREATE TABLE Stores (
    store_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    promotions ENUM("Combos", "2-for-1", "Best price for quantity", "Buy 2 get 1"),
    manager INT,
    FOREIGN KEY (manager) REFERENCES Event_Staff(staff_id)
);

-- Table Orders
CREATE TABLE Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    store_id INT,
    register_id INT,
    cashier INT,
    total_amount DECIMAL(10, 2),
    status ENUM('registered', 'paid', 'delivered'),
    FOREIGN KEY (store_id) REFERENCES Stores(store_id),
    FOREIGN KEY (register_id) REFERENCES Cash_Registers(register_id),
    FOREIGN KEY (cashier) REFERENCES Event_Staff(staff_id)
);

-- Table Order_Details
CREATE TABLE Order_Details (
    detail_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    product VARCHAR(255),
    quantity INT,
    unit_price DECIMAL(10, 2),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id)
);

-- Table Store_Inventory
CREATE TABLE Store_Inventory (
    inventory_id INT AUTO_INCREMENT PRIMARY KEY,
    store_id INT,
    product_name VARCHAR(255),
    description TEXT,
    manufacturer VARCHAR(255),
    type VARCHAR(100),
    quantity INT,
    price DECIMAL(10, 2),
    FOREIGN KEY (store_id) REFERENCES Stores(store_id)
);

-- Table Restaurants
CREATE TABLE Restaurants (
    restaurant_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    manager INT,
    FOREIGN KEY (manager) REFERENCES Event_Staff(staff_id)
);

-- Table Restaurant_Menu
CREATE TABLE Restaurant_Menu (
    menu_id INT AUTO_INCREMENT PRIMARY KEY,
    restaurant_id INT,
    dish_name VARCHAR(255),
    description TEXT,
    type ENUM('Appetizer', 'Drink', 'Main course', "Dessert", "Special combo", "Meal"),
    prep_time INT,
    FOREIGN KEY (restaurant_id) REFERENCES Restaurants(restaurant_id)
);

-- Table Ingredient_Inventory
CREATE TABLE Ingredient_Inventory (
    ingredient_id INT AUTO_INCREMENT PRIMARY KEY,
    restaurant_id INT,
    ingredient_name VARCHAR(255),
    quantity INT,
    FOREIGN KEY (restaurant_id) REFERENCES Restaurants(restaurant_id)
);

-- Table Activity_Prizes
CREATE TABLE Activity_Prizes (
    activity_prize_id INT AUTO_INCREMENT PRIMARY KEY,
    activity_id INT,
    prize_id INT,
    FOREIGN KEY (activity_id) REFERENCES Activities(activity_id),
    FOREIGN KEY (prize_id) REFERENCES Prizes(prize_id)
);

-- Table Judges
CREATE TABLE Judges (
    judge_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    id_number VARCHAR(100) UNIQUE NOT NULL,
    birth_date DATE,
    email VARCHAR(255),
    phone_number VARCHAR(50),
    specialty VARCHAR(255),
    event_id INT,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- Table Participants
CREATE TABLE Participants (
    participant_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    activity_id INT,
    FOREIGN KEY (activity_id) REFERENCES Activities(activity_id)
);

-- Table Scores
CREATE TABLE Scores (
    score_id INT AUTO_INCREMENT PRIMARY KEY,
    participant_id INT,
    judge_id INT,
    score DECIMAL(3, 1) CHECK (score BETWEEN 0 AND 10),
    FOREIGN KEY (participant_id) REFERENCES Participants(participant_id),
    FOREIGN KEY (judge_id) REFERENCES Judges(judge_id)
);

-- Table Activity_Results
CREATE TABLE Activity_Results (
    result_id INT AUTO_INCREMENT PRIMARY KEY,
    activity_id INT,
    participant_id INT,
    average_score DECIMAL(5, 2),
    FOREIGN KEY (activity_id) REFERENCES Activities(activity_id),
    FOREIGN KEY (participant_id) REFERENCES Participants(participant_id)
);

-- Table Reports
CREATE TABLE Reports (
    report_id INT AUTO_INCREMENT PRIMARY KEY,
    report_name VARCHAR(255),
    report_type ENUM('General', 'Event', 'Store', 'Restaurant', 'Activity'),
    description TEXT,
    generation_date DATE,
    report_data JSON,
    event_id INT,
    store_id INT,
    restaurant_id INT,
    activity_id INT,
    FOREIGN KEY (event_id) REFERENCES Events(event_id),
    FOREIGN KEY (store_id) REFERENCES Stores(store_id),
    FOREIGN KEY (restaurant_id) REFERENCES Restaurants(restaurant_id),
    FOREIGN KEY (activity_id) REFERENCES Activities(activity_id)
);

-- Table for Cosplay Categories
CREATE TABLE Cosplay_Categories (
    id_category INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL
);

CREATE TABLE Cosplay_Participants (
    id_cosplay_participant INT AUTO_INCREMENT PRIMARY KEY,
    id_participant INT,
    id_category INT,
    score DECIMAL(5, 2),
    FOREIGN KEY (id_participant) REFERENCES Participants(participant_id ),
    FOREIGN KEY (id_category) REFERENCES Cosplay_Categories(id_category)
);

CREATE TABLE Questions (
    id_question INT AUTO_INCREMENT PRIMARY KEY,
    question TEXT NOT NULL,
    correct_answer VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    difficulty ENUM('Easy', 'Intermediate', 'Hard') NOT NULL
);

CREATE TABLE Rounds (
    id_round INT AUTO_INCREMENT PRIMARY KEY,
    id_activity INT,
    round_number INT,
    FOREIGN KEY (id_activity) REFERENCES Activities(activity_id )
);

CREATE TABLE Matchups (
    id_matchup INT AUTO_INCREMENT PRIMARY KEY,
    id_round INT,
    id_participant1 INT,
    id_participant2 INT,
    winner INT,
    FOREIGN KEY (id_round) REFERENCES Rounds(id_round),
    FOREIGN KEY (id_participant1) REFERENCES Participants(participant_id ),
    FOREIGN KEY (id_participant2) REFERENCES Participants(participant_id ),
    FOREIGN KEY (winner) REFERENCES Participants(participant_id )
);

CREATE TABLE Question_Categories (
    id_question_category INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL
);

CREATE TABLE Question_Inventory (
    id_question INT AUTO_INCREMENT PRIMARY KEY,
    id_question_category INT,
    question TEXT NOT NULL,
    correct_answer VARCHAR(255) NOT NULL,
    FOREIGN KEY (id_question_category) REFERENCES Question_Categories(id_question_category)
);

show tables;

# Check information from a table
select* from Events; 
# Change the name "Events" to the name of the table you want to view the information from