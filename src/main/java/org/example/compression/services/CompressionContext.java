package org.example.compression.services;

import org.example.compression.strategies.CompressionStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Контекст, який керує вибором стратегії стиснення.
 */
@Component
public class CompressionContext {
    private final Map<String, CompressionStrategy> strategies;

    /**
     * Інжектування стратегій через Spring.
     * @param strategies Map, де ключ - ім'я стратегії, а значення - її реалізація.
     */
    @Autowired
    public CompressionContext(Map<String, CompressionStrategy> strategies) {
        this.strategies = strategies;
    }

    /**
     * Вибирає та виконує стратегію стиснення.
     * @param strategyType Тип стратегії (Reversible або Irreversible).
     * @param fileName Ім'я файлу для стиснення.
     */
    public void compress(String strategyType, String fileName) {
        CompressionStrategy strategy = strategies.get(strategyType);
        if (strategy == null) {
            System.out.println("Невідома стратегія: " + strategyType);
            throw new IllegalArgumentException("Unknown compression strategy: " + strategyType);
        }
        System.out.println("Використовується стратегія: " + strategyType + " для файлу: " + fileName);
        strategy.compress(fileName);
    }
}


