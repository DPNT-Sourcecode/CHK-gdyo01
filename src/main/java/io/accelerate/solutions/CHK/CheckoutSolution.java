package io.accelerate.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {

    private static final Map<Character, Integer> PRICE_MAP = new HashMap<>() {{
        put('A', 50);
        put('B', 30);
        put('C', 20);
        put('D', 15);
        put('E', 40);
    }};

    public Integer checkout(String skus) {
        if (skus == null) {
            return -1;
        }

        Map<Character, Integer> itemCounts = new HashMap<>();

        for (char sku : skus.toCharArray()) {
            if(!PRICE_MAP.containsKey(sku)) {
                return -1;
            }
            itemCounts.put(sku, itemCounts.getOrDefault(sku, 0) + 1);
        }

        int totalPrice = 0;
        
        for (Map.Entry<Character, Integer> entry : itemCounts.entrySet()) {
            char sku = entry.getKey();
            int count = entry.getValue();
            int price = PRICE_MAP.get(sku);

            if (sku == 'A') {
                totalPrice += (count / 3) * 130 + (count % 3) * price;
            } else if (sku == 'B') {
                totalPrice += (count / 2) * 45 + (count % 2) * price;
            } else {
                totalPrice += count * price;
            }
        }

        return totalPrice;

    }
}


