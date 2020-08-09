package com.gun.ardic.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@SpringBootTest
public class BuyukKucukUnluUyumuTests {

    private final List<String> correctWords = Arrays.asList("adım", "ayak", "boyunduruk", "burun", "dalga", "dudak",
            "kırlangıç", "beşik", "bilezik", "gelincik", "gözlük", "üzengi", "vergi", "yüzük");

    private final List<String> incorrectWords = Arrays.asList("kalem", "kitap", "sosyoloji", "senaryo", "cevap",
            "sandalye", "talimat", "sinema", "otobüs", "matematik", "cami", "ezan", "talih", "bahçe", "tiyatro",
            "otomobil", "tatil", "tahmin", "mahalle", "cadde");

    private static final Locale locale = new Locale("TR", "tr");

    @Test
    public void testHappyPath() {
        testList(correctWords, true);
//        correctWords.forEach(s -> {
//            assertTrue(BuyukKucukUnluUyumu.kontrol(s));
//            assertTrue(BuyukKucukUnluUyumu.kontrol(s.toUpperCase(locale)));
//        });
    }

    @Test
    public void testFail() {
        testList(incorrectWords, false);
    }

    public void testList(List<String> words, boolean expectedResult) {
        words.forEach(s -> {
            assertEquals(expectedResult, BuyukKucukUnluUyumu.kontrol(s));
        });
    }
}
