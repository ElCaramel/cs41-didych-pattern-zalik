package org.example.compression.exception;

/**
 * Виняток для непідтримуваних форматів файлів.
 * Використовується, коли система не може знайти відповідну стратегію для файлу.
 */
public class UnsupportedFileFormatException extends CompressionException {

    /**
     * Конструктор винятку з повідомленням.
     * @param message опис помилки.
     */
    public UnsupportedFileFormatException(String message) {
        super(message);
    }
}

