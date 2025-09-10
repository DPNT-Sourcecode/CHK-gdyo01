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
            if (!PRICE_MAP.containsKey(sku)) return -1;
            itemCounts.put(sku, itemCounts.getOrDefault(sku, 0) + 1);
        }

        if (skus.isEmpty()) {
            return 0;
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

        int freeM = countN / 3;
        int chargeableM = Math.max(0, countM - freeM);

        int freeQ = countR / 3;
        int chargeableQ = Math.max(0, countQ - freeQ);

        totalPrice += priceA(countA);
        totalPrice += priceH(countH);          
        totalPrice += priceK(countK);          
        totalPrice += priceP(countP); 
        totalPrice += priceV(countV);      

        totalPrice += priceB(chargeableB);
        totalPrice += priceQ(chargeableQ);

        totalPrice += countC * PRICE_MAP.get('C');
        totalPrice += countD * PRICE_MAP.get('D');

        totalPrice += priceF(countF);
        totalPrice += priceU(countU);

        totalPrice += countE * PRICE_MAP.get('E');
        totalPrice += countN * PRICE_MAP.get('N');
        totalPrice += countR * PRICE_MAP.get('R');
        totalPrice += chargeableM * PRICE_MAP.get('M');


        totalPrice += countG * PRICE_MAP.get('G');
        totalPrice += countI * PRICE_MAP.get('I');
        totalPrice += countJ * PRICE_MAP.get('J');
        totalPrice += countL * PRICE_MAP.get('L');
        totalPrice += countO * PRICE_MAP.get('O');
        totalPrice += countS * PRICE_MAP.get('S');
        totalPrice += countT * PRICE_MAP.get('T');
        totalPrice += countW * PRICE_MAP.get('W');
        totalPrice += countX * PRICE_MAP.get('X');
        totalPrice += countY * PRICE_MAP.get('Y');
        totalPrice += countZ * PRICE_MAP.get('Z');

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
    private int priceH(int count) {
        int total = 0;
        int tenPacks = count / 10;
        total += tenPacks * 80;
        count %= 10;

        int fivePacks = count / 5;
        total += fivePacks * 45;
        count %= 5;

        total += count * PRICE_MAP.get('H');
        return total;
    }

    private int priceK(int count) {
        int total = 0;
        int packs2 = count / 2;
        total += packs2 * 150;
        count %= 2;

        total += count * PRICE_MAP.get('K');
        return total;
    }

    private int priceP(int count) {
        int total = 0;
        int fivePacks = count / 5;
        total += fivePacks * 200;
        count %= 5;

        total += count * PRICE_MAP.get('P');
        return total;
    }

    private int priceQ(int count) {
        int total = 0;
        int packs3 = count / 3;
        total += packs3 * 80;
        count %= 3;

        total += count * PRICE_MAP.get('Q');
        return total;
    }

    private int priceU(int count) {
        int total = 0;
        int groups4 = count / 4;
        total += groups4 * (3 * PRICE_MAP.get('U'));
        total += (count % 4) * PRICE_MAP.get('U');
        return total;
    }

    private int priceV(int count) {
        int total = 0;
        int packs3 = count / 3;
        total += packs3 * 130;
        count %= 3;

        int packs2 = count / 2;
        total += packs2 * 90;
        count %= 2;

        total += count * PRICE_MAP.get('V');
        return total;
    }
}

