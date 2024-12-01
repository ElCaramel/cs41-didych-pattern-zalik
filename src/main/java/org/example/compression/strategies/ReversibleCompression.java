package org.example.compression.strategies;

import org.springframework.stereotype.Component;

/**
 * Реалізація стратегії оборотного стиснення.
 * Використовується для текстових файлів, де важлива повна відновлюваність даних.
 */
@Component("Reversible")
public class ReversibleCompression implements CompressionStrategy {
    @Override
    public void compress(String fileName) {
        System.out.println("Вмикаємо оборотне стиснення: " + fileName);
    }
}


