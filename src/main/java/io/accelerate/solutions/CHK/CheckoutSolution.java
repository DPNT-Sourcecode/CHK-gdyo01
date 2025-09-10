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
        put('F', 10);
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

        int countA = itemCounts.getOrDefault('A', 0);
        int countB = itemCounts.getOrDefault('B', 0);
        int countC = itemCounts.getOrDefault('C', 0);
        int countD = itemCounts.getOrDefault('D', 0);
        int countE = itemCounts.getOrDefault('E', 0);
        int countF = itemCounts.getOrDefault('F', 0);

        int totalPrice = 0;

        totalPrice += countE * PRICE_MAP.get('E');
        int freeBsFromE = countE / 2;
        int chargeableB = Math.max(0, countB - freeBsFromE);

        totalPrice += priceA(countA);

        totalPrice += priceB(chargeableB);

        totalPrice += countC * PRICE_MAP.get('C');
        totalPrice += countD * PRICE_MAP.get('D');

        totalPrice += priceF(countF);

        return totalPrice;
    }

    private int priceA(int countA) {
        int total = 0;
        int fives = countA / 5;
        total += fives * 200;
        countA %= 5;

        int threes = countA / 3;
        total += threes * 130;
        countA %= 3;

        total += countA * PRICE_MAP.get('A');
        return total;
    }

    private int priceB(int countB) {
        int total = 0;
        int twos = countB / 2;
        total += twos * 45;
        countB %= 2;

        total += countB * PRICE_MAP.get('B');
        return total;
    }

    private int priceF(int countF) {
        int total = 0;
        int chargeableF = countF - (countF / 3);
        total += chargeableF * PRICE_MAP.get('F');
        return total;
    }
}




