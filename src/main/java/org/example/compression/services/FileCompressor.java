package org.example.compression.services;

import org.example.compression.formats.DefaultFileFormatResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.compression.exception.CompressionException ;

/**
 * Сервіс для керування процесом стиснення.
 */
@Service
public class FileCompressor {
    private final CompressionContext compressionContext;
    private final DefaultFileFormatResolver fileFormatResolver;

    /**
     * Конструктор із впровадженням залежностей.
     * @param compressionContext Контекст для вибору стратегії.
     * @param fileFormatResolver Резолвер для визначення стратегії за форматом.
     */
    @Autowired
    public FileCompressor(CompressionContext compressionContext, DefaultFileFormatResolver fileFormatResolver) {
        this.compressionContext = compressionContext;
        this.fileFormatResolver = fileFormatResolver;
    }

    /**
     * Стискає файл, визначаючи відповідну стратегію на основі його формату.
     * @param fileName ім'я файлу для стиснення.
     */
    public void compressFile(String fileName) {
        try {
            System.out.println("Початок стиснення файлу: " + fileName);

            // Визначення стратегії на основі розширення файлу
            String strategyType = fileFormatResolver.resolve(fileName);

            // Виконання стиснення з обраною стратегією
            compressionContext.compress(strategyType, fileName);

            System.out.println("Файл успішно стиснуто з використанням стратегії: " + strategyType);
        } catch (CompressionException e) {
            System.out.println("Помилка стиснення файлу: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Невідома помилка: " + e.getMessage());
        }
    }
}


