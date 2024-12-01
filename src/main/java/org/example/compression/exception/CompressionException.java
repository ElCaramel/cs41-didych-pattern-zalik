package org.example.compression.exception;

/**
 * Базовий клас для всіх винятків, пов'язаних із процесом стиснення.
 * Дозволяє централізувати 😎 обробку помилок у додатку.
 */
public class CompressionException extends RuntimeException {

    /**
     * Конструктор винятку з повідомленням.
     * @param message опис помилки.
     */
    public CompressionException(String message) {
        super(message);
    }

    /**
     * Конструктор винятку з повідомленням і причиною.
     * @param message опис помилки.
     * @param cause вихідна причина помилки.
     */
    public CompressionException(String message, Throwable cause) {
        super(message, cause);
    }
}

