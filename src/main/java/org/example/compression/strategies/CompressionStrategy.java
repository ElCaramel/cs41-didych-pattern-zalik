package org.example.compression.strategies;

/**
 * Інтерфейс для різних стратегій стиснення.
 * Кожна стратегія має реалізувати метод compress().
 */
public interface CompressionStrategy {
    /**
     * Метод для виконання стиснення файлу.
     * @param fileName ім'я файлу, який потрібно стиснути.
     */
    void compress(String fileName);
}


