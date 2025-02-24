

-- CREAR LA TRANSACCION REVENTA
DELIMITER //
CREATE PROCEDURE crearTransaccionReventa(
    IN PRECIO DECIMAL(10,2),
    IN PORC DECIMAL(5,2),
    OUT IDTRANSACCION INT
)
BEGIN 
    -- Inserta en la tabla de transacciones
    INSERT INTO TRANSACCIONES (FECHAHORA, TIPOCOMPRA, MONTO)
    VALUES (NOW(), 'Reventa', PRECIO * (PORC / 100));

    --  ID de la transacción recién creada
    SET IDTRANSACCION = LAST_INSERT_ID();
END //
DELIMITER ;

