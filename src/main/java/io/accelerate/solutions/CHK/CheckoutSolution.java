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
                int fivePacks = count / 5;
                totalPrice = fivePacks * 200;
                count %= 5;
                int threePacks = count / 3;
                totalPrice += threePacks * 130;
                count %= 3;
                totalPrice += count * price;
            } else if (sku == 'B') {
                int twoPacks = count / 2;
                totalPrice += twoPacks * 45;
                count %= 2;
                totalPrice += count * price;    
            } else if (sku == 'E') {
                int freeB = count / 2;
                int countB = itemCounts.getOrDefault('B', 0);
                int payableB = Math.max(0, countB - freeB);
                totalPrice += payableB * PRICE_MAP.get('B');
                totalPrice += count * price;
            } 
            else {
                totalPrice += count * price;
            }
        }

        return totalPrice;

    }
}
