package org.example.compression.formats;


import org.example.compression.exception.UnsupportedFileFormatException;
import org.springframework.stereotype.Component;

/**
 * Визначає стратегію стиснення на основі формату файлу.
 */
@Component
public class DefaultFileFormatResolver {
    private final FileFormatRegistry registry;

    /**
     * Конструктор із передаванням реєстру форматів.
     * @param registry Реєстр форматів файлів.
     */
    public DefaultFileFormatResolver(FileFormatRegistry registry) {
        this.registry = registry;
    }

    /**
     * Повертає тип стратегії на основі розширення файлу.
     * @param fileName ім'я файлу.
     * @return тип стратегії.
     */
    public String resolve(String fileName) {
        String extension = getFileExtension(fileName);
        String strategy = registry.getStrategyForFormat(extension);
        if (strategy == null) {
            System.out.println("Формат файлу не підтримується: " + extension);
            throw new UnsupportedFileFormatException("Unsupported file format: " + extension);
        }
        System.out.println("Визначено стратегію для формату ." + extension + ": " + strategy);
        return strategy;
    }

    /**
     * Витягує розширення з імені файлу.
     * @param fileName ім'я файлу.
     * @return розширення файлу.
     */
    private String getFileExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf('.');
        if (lastIndex == -1 || lastIndex == fileName.length() - 1) {
            System.out.println("Помилка в імені файлу: " + fileName);
            throw new IllegalArgumentException("Invalid file name: " + fileName);
        }
        return fileName.substring(lastIndex + 1);
    }
}
