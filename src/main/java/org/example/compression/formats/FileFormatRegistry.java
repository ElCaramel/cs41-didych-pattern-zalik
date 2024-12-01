package org.example.compression.formats;

import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

/**
 * Реєстр форматів файлів і пов'язаних із ними стратегій.
 * Дозволяє динамічно додавати нові формати та стратегії.
 */
@Component
public class FileFormatRegistry {
    private final Map<String, String> formatStrategies = new HashMap<>();

    public FileFormatRegistry() {
        // Список стандартних форматів
        registerFormat("txt", "Reversible");
        registerFormat("json", "Reversible");
        registerFormat("xml", "Reversible");
        registerFormat("jpeg", "Irreversible");
        registerFormat("png", "Irreversible");
        registerFormat("mp4", "Irreversible");
    }

    /**
     * Реєструє новий формат файлу та його стратегію.
     * @param extension розширення файлу.
     * @param strategyType тип стратегії.
     */
    public void registerFormat(String extension, String strategyType) {
        formatStrategies.put(extension.toLowerCase(), strategyType);
    }

    /**
     * Повертає стратегію для зазначеного формату.
     * @param extension розширення файлу.
     * @return тип стратегії або null, якщо формат не зареєстровано.
     */
    public String getStrategyForFormat(String extension) {
        return formatStrategies.get(extension.toLowerCase());
    }
}

