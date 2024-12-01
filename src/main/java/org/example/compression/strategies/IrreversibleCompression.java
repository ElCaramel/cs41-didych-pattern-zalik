package org.example.compression.strategies;

import org.springframework.stereotype.Component;

/**
 * Реалізація стратегії необоротного стиснення.
 * Використовується для зображень і відео, де допускається втрата якості заради більш високого стиснення.
 */
@Component("Irreversible")
public class IrreversibleCompression implements CompressionStrategy {
    @Override
    public void compress(String fileName) {
        System.out.println("Вмикаємо необоротне стиснення: " + fileName);
    }
}
