package com.gun.ardic.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class BuyukKucukUnluUyumu {

    public static final List<Character> BUYUK_UNLU = Arrays.asList('a', 'ı', 'o', 'u');
    public static final List<Character> KUCUK_UNLU = Arrays.asList('e', 'i', 'ö', 'ü');
    private static final Locale locale = new Locale("TR", "tr");

    public static boolean kontrol(String word) {
        /*
            alinti kelimeler ve birlesik kelimelerde unlu uyumu aranmaz. ancak
            isin kapsami genisledigi icin su an yapilmadi
         */
        return kontrolBuyukKucukUnluUyumu(word);
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

