package com.gun.ardic.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class BuyukKucukUnluUyumu {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuyukKucukUnluUyumu.class);

    public static final List<Character> BUYUK_UNLU = Arrays.asList('a', 'ı', 'o', 'u');
    public static final List<Character> KUCUK_UNLU = Arrays.asList('e', 'i', 'ö', 'ü');
    private static final Locale locale = new Locale("TR", "tr");

    private static boolean kontrolBuyukKucukUnluUyumu2(String word) {
        int idx1 = -1;
        int idx2 = -1;

        for (char ch : BUYUK_UNLU) {
            idx1 = word.indexOf(ch);
            if (idx1 >= 0) break;
        }

        for (char ch : KUCUK_UNLU) {
            idx2 = word.indexOf(ch);
            if (idx2 >= 0) break;
        }

        return !(idx1 >= 0 && idx2 >= 0);
    }

    public static boolean kontrol(String word) {
        StopWatch sw = new StopWatch();
        sw.start();
//        boolean result = kontrolBuyukKucukUnluUyumu(word);
        boolean result = kontrolBuyukKucukUnluUyumu2(word);
        sw.stop();
        LOGGER.info("Elapsed: {}", sw.getTotalTimeMillis());
        return result;
    }

    private static boolean kontrolBuyukKucukUnluUyumu(String word) {
        int buyuk = 0;
        int kucuk = 0;
        for (char ch : word.toLowerCase(locale).toCharArray()) {
            if (BUYUK_UNLU.indexOf(ch) >= 0) {
                buyuk++;
            } else if (KUCUK_UNLU.indexOf(ch) >= 0) {
                kucuk++;
            }
        }


        boolean result = true;
        if (buyuk == 0 && kucuk == 0) {
            result = false;
        }

        if (buyuk > 0 && kucuk > 0) {
            result = false;
        }

        System.out.println(String.format("%s --> buyuk: %s, kucuk: %s, result: %s", word, buyuk, kucuk, result));
        return result;
    }


}

