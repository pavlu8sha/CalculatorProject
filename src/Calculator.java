import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private final Map<String, Integer> romeToArabic = new HashMap();
    private final Map<Integer, String> arabicToRome = new HashMap();

    Calculator() {
        romeToArabic.put("I", 1);
        romeToArabic.put("II", 2);
        romeToArabic.put("III", 3);
        romeToArabic.put("IV", 4);
        romeToArabic.put("V", 5);
        romeToArabic.put("VI", 6);
        romeToArabic.put("VII", 7);
        romeToArabic.put("VIII", 8);
        romeToArabic.put("IX", 9);
        romeToArabic.put("X", 10);

        arabicToRome.put(1, "I");
        arabicToRome.put(2, "II");
        arabicToRome.put(3, "III");
        arabicToRome.put(4, "IV");
        arabicToRome.put(5, "V");
        arabicToRome.put(6, "VI");
        arabicToRome.put(7, "VII");
        arabicToRome.put(8, "VIII");
        arabicToRome.put(9, "IX");
        arabicToRome.put(10, "X");
        arabicToRome.put(11, "XI");
        arabicToRome.put(12, "XII");
        arabicToRome.put(13, "XIII");
        arabicToRome.put(14, "XIV");
        arabicToRome.put(15, "XV");
        arabicToRome.put(16, "XVI");
        arabicToRome.put(17, "XVII");
        arabicToRome.put(18, "XVIII");
        arabicToRome.put(19, "XIX");
        arabicToRome.put(20, "XX");
        arabicToRome.put(0, "0");
    }

    String calculate(String input) {
        String[] entries = input.split(" ");
        if (entries.length != 3) {
            throw new IllegalArgumentException("С„РѕСЂРјР°С‚ РјР°С‚РµРјР°С‚РёС‡РµСЃРєРѕР№ РѕРїРµСЂР°С†РёРё РЅРµ СѓРґРѕРІР»РµС‚РІРѕСЂСЏРµС‚ Р·Р°РґР°РЅРёСЋ - РґРІР° РѕРїРµСЂР°РЅРґР° Рё РѕРґРёРЅ РѕРїРµСЂР°С‚РѕСЂ (+, -, /, *)");
        }
        String aStr = entries[0];
        String operator = entries[1];
        String bStr = entries[2];

        if (romeToArabic.containsKey(aStr) && romeToArabic.containsKey(bStr)) {
            int a = romeToArabic.get(aStr);
            int b = romeToArabic.get(bStr);
            int result;
            switch (operator) {
                case "+" : result = a + b; break;
                case "-" : result = a - b; break;
                case "/" : result = a / b; break;
                case "*" : result = a * b; break;
                default: throw new IllegalArgumentException("РќРµРїСЂР°РІРёР»СЊРЅС‹Р№ С„РѕСЂРјР°С‚ РґР°РЅРЅС‹С…");
            }
            if (result < 0) {
                throw new IllegalArgumentException("РќРµРїСЂР°РІРёР»СЊРЅС‹Р№ С„РѕСЂРјР°С‚ РґР°РЅРЅС‹С…");
            } else {
                return arabicToRome.get(result);
            }
        } else {
            try {
                int a = Integer.parseInt(aStr);
                int b = Integer.parseInt(bStr);
                if (a > 0 && a < 11 && b > 0 && b < 11) {
                    switch (operator) {
                        case "+" : return String.valueOf(a + b);
                        case "-" : return String.valueOf(a - b);
                        case "/" : return String.valueOf(a / b);
                        case "*" : return String.valueOf(a * b);
                        default: throw new IllegalArgumentException("РќРµРїСЂР°РІРёР»СЊРЅС‹Р№ С„РѕСЂРјР°С‚ РґР°РЅРЅС‹С…");
                    }
                } else {
                    throw new IllegalArgumentException("Р§РёСЃР»Рѕ РґРѕР»Р¶РЅРѕ Р±С‹С‚СЊ РѕС‚ 1 РґРѕ 10");
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("РќРµРїСЂР°РІРёР»СЊРЅС‹Р№ С„РѕСЂРјР°С‚ РґР°РЅРЅС‹С…");
            }
        }
    }
}