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
        if (skus == null) return -1;

        Map<Character, Integer> counts = new HashMap<>();
        for (char sku : skus.toCharArray()) {
            if (!PRICE_MAP.containsKey(sku)) return -1;
            counts.put(sku, counts.getOrDefault(sku, 0) + 1);
        }

        if (skus.isEmpty()) return 0;

        int a = counts.getOrDefault('A', 0);
        int b = counts.getOrDefault('B', 0);
        int c = counts.getOrDefault('C', 0);
        int d = counts.getOrDefault('D', 0);
        int e = counts.getOrDefault('E', 0);
        int f = counts.getOrDefault('F', 0);
        int g = counts.getOrDefault('G', 0);
        int h = counts.getOrDefault('H', 0);
        int i = counts.getOrDefault('I', 0);
        int j = counts.getOrDefault('J', 0);
        int k = counts.getOrDefault('K', 0);
        int l = counts.getOrDefault('L', 0);
        int m = counts.getOrDefault('M', 0);
        int n = counts.getOrDefault('N', 0);
        int o = counts.getOrDefault('O', 0);
        int p = counts.getOrDefault('P', 0);
        int q = counts.getOrDefault('Q', 0);
        int r = counts.getOrDefault('R', 0);
        int s = counts.getOrDefault('S', 0);
        int t = counts.getOrDefault('T', 0);
        int u = counts.getOrDefault('U', 0);
        int v = counts.getOrDefault('V', 0);
        int w = counts.getOrDefault('W', 0);
        int x = counts.getOrDefault('X', 0);
        int y = counts.getOrDefault('Y', 0);
        int z = counts.getOrDefault('Z', 0);

        int total = 0;

        int freeB = e / 2;
        int chargeableB = Math.max(0, b - freeB);

        int freeM = n / 3;
        int chargeableM = Math.max(0, m - freeM);

        int freeQ = r / 3;
        int chargeableQ = Math.max(0, q - freeQ);

        total += e * PRICE_MAP.get('E');
        total += n * PRICE_MAP.get('N');
        total += r * PRICE_MAP.get('R');

        
        total += priceF(f);
        total += priceU(u);

        total += priceA(a);          // A: 5 for 200, then 3 for 130, then singles
        total += priceB(chargeableB);// B after E-frees: 2 for 45, then singles
        total += priceH(h);          // H: 10 for 80, then 5 for 45, then singles
        total += priceK(k);          // K: 2 for 150
        total += priceP(p);          // P: 5 for 200
        total += priceQ(chargeableQ);// Q after R-frees: 3 for 80
        total += priceV(v);          // V: 3 for 130, then 2 for 90, then singles

        // -----------------------------
        // Singles (no multibuy on these after handling freebies)
        // -----------------------------
        total += c * PRICE_MAP.get('C');
        total += d * PRICE_MAP.get('D');
        total += g * PRICE_MAP.get('G');
        total += i * PRICE_MAP.get('I');
        total += j * PRICE_MAP.get('J');
        total += l * PRICE_MAP.get('L');
        total += chargeableM * PRICE_MAP.get('M'); // M after N-frees
        total += o * PRICE_MAP.get('O');
        total += s * PRICE_MAP.get('S');
        total += t * PRICE_MAP.get('T');
        total += w * PRICE_MAP.get('W');
        total += x * PRICE_MAP.get('X');
        total += y * PRICE_MAP.get('Y');
        total += z * PRICE_MAP.get('Z');

        return total;
    }

    // -------- Pricing helpers --------

    private int priceA(int count) {
        int total = 0;
        int packs5 = count / 5;
        total += packs5 * 200;
        count %= 5;

        int packs3 = count / 3;
        total += packs3 * 130;
        count %= 3;

        total += count * PRICE_MAP.get('A');
        return total;
    }

    private int priceB(int count) {
        int total = 0;
        int packs2 = count / 2;
        total += packs2 * 45;
        count %= 2;

        total += count * PRICE_MAP.get('B');
        return total;
    }

    private int priceF(int count) {
        int total = 0;
        int triples = count / 3; // each triple costs 2*10 = 20
        total += triples * (2 * PRICE_MAP.get('F'));
        total += (count % 3) * PRICE_MAP.get('F');
        return total;
    }

    private int priceH(int count) {
        int total = 0;
        int tenPacks = count / 10; // larger bundle first
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
        int groups4 = count / 4; // every 4 items pay for 3
        total += groups4 * (3 * PRICE_MAP.get('U'));
        total += (count % 4) * PRICE_MAP.get('U');
        return total;
    }

    private int priceV(int count) {
        int total = 0;
        int packs3 = count / 3; // larger bundle first (3 for 130)
        total += packs3 * 130;
        count %= 3;

        int packs2 = count / 2; // then 2 for 90
        total += packs2 * 90;
        count %= 2;

        total += count * PRICE_MAP.get('V'); // singles
        return total;
    }
}


