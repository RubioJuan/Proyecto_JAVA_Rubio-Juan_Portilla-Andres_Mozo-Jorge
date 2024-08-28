##################
### TTRIGGERS ###
##################

use AnimeExpo;

# 1. Actualización del Inventario de Eventos
# Cuando se cambia la cantidad de un inventario de evento (Event_Inventory), este trigger registrará el cambio en la tabla Inventory_History.
DELIMITER //
CREATE TRIGGER trg_update_inventory
AFTER UPDATE ON Event_Inventory
FOR EACH ROW
BEGIN
    INSERT INTO Inventory_History (inventory_id, previous_quantity, new_quantity, change_date)
    VALUES (NEW.inventory_id, OLD.quantity, NEW.quantity, NOW());
END//
DELIMITER ;

#  2. Registro de Cambios en el Inventario de Eventos
# Este trigger mantiene el historial de cambios en el inventario de eventos.
DELIMITER //
CREATE TRIGGER trg_event_inventory_update
AFTER UPDATE ON Event_Inventory
FOR EACH ROW
BEGIN
    INSERT INTO Inventory_History (inventory_id, previous_quantity, new_quantity, change_date)
    VALUES (OLD.inventory_id, OLD.quantity, NEW.quantity, NOW());
END//
DELIMITER ;

# 3. Actualizar la Cantidad de Productos al Realizar un Pedido
#Este trigger actualiza la cantidad de productos en el inventario de la tienda cuando se realiza un pedido.
DELIMITER //

CREATE TRIGGER trg_update_store_inventory
AFTER INSERT ON Order_Details
FOR EACH ROW
BEGIN
    UPDATE Store_Inventory
    SET quantity = quantity - NEW.quantity
    WHERE store_id = (SELECT store_id FROM Orders WHERE order_id = NEW.order_id)
      AND product_name = NEW.product;
END//

DELIMITER ;

# 4. Mantenimiento del Historial de Precios de los Productos
# Este trigger mantiene el historial de cambios en el precio de los productos.
DELIMITER //
CREATE TRIGGER trg_price_history_update
AFTER UPDATE ON Store_Inventory
FOR EACH ROW
BEGIN
    IF OLD.price <> NEW.price THEN
        INSERT INTO Price_History (store_id, product_name, old_price, new_price, change_date)
        VALUES (OLD.store_id, OLD.product_name, OLD.price, NEW.price, NOW());
    END IF;
END//
DELIMITER ;
