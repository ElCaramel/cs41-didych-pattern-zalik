package org.example.compression;

import org.example.compression.services.FileCompressor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Основной класс приложения Spring Boot.
 * Демонстрирует использование сервиса сжатия.
 */
@SpringBootApplication
public class CompressionApplication implements CommandLineRunner {

    private final FileCompressor fileCompressor;

    /**
     * Инжектирование FileCompressor через конструктор.
     * @param fileCompressor сервис сжатия файлов.
     */
    @Autowired
    public CompressionApplication(FileCompressor fileCompressor) {
        this.fileCompressor = fileCompressor;
    }

    public static void main(String[] args) {
        SpringApplication.run(CompressionApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Пример сжатия файлов различных форматов.
        fileCompressor.compressFile("example.txt");
        fileCompressor.compressFile("image.jpeg");
        fileCompressor.compressFile("data.json");
    }
}
