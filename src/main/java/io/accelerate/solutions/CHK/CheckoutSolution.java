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
        put('G', 20);
        put('H', 10);
        put('I', 35);
        put('J', 60);
        put('K', 80);
        put('L', 90);
        put('M', 15);
        put('N', 40);
        put('O', 10);
        put('P', 50);
        put('Q', 30);
        put('R', 50);
        put('S', 30);
        put('T', 20);
        put('U', 40);
        put('V', 50);
        put('W', 20);
        put('X', 90);
        put('Y', 10);
        put('Z', 50);   
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
        int countG = itemCounts.getOrDefault('G', 0);
        int countH = itemCounts.getOrDefault('H', 0);
        int countI = itemCounts.getOrDefault('I', 0);
        int countJ = itemCounts.getOrDefault('J', 0);
        int countK = itemCounts.getOrDefault('K', 0);
        int countL = itemCounts.getOrDefault('L', 0);
        int countM = itemCounts.getOrDefault('M', 0);
        int countN = itemCounts.getOrDefault('N', 0);
        int countO = itemCounts.getOrDefault('O', 0);
        int countP = itemCounts.getOrDefault('P', 0);
        int countQ = itemCounts.getOrDefault('Q', 0);
        int countR = itemCounts.getOrDefault('R', 0);
        int countS = itemCounts.getOrDefault('S', 0);
        int countT = itemCounts.getOrDefault('T', 0);
        int countU = itemCounts.getOrDefault('U', 0);
        int countV = itemCounts.getOrDefault('V', 0);
        int countW = itemCounts.getOrDefault('W', 0);
        int countX = itemCounts.getOrDefault('X', 0);
        int countY = itemCounts.getOrDefault('Y', 0);
        int countZ = itemCounts.getOrDefault('Z', 0);

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
