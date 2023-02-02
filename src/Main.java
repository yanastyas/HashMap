import java.util.HashMap;
import java.util.Map;

import static java.lang.Character.toLowerCase;

public class Main {
    public static void main(String[] args) {
        String LoremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        Map<Character, Integer> LoremIpsumMap = new HashMap<>();
        LoremIpsumMap.put(toLowerCase(LoremIpsum.charAt(0)), 1);
        for (int i = 1; i < LoremIpsum.length(); i++) {
            char s = toLowerCase(LoremIpsum.charAt(i));
            if (Character.isLetter(s)) {
                if (LoremIpsumMap.containsKey(s)) {
                    int sAmount = LoremIpsumMap.get(s);
                    sAmount++;
                    LoremIpsumMap.put(s, sAmount);
                } else {
                    LoremIpsumMap.put(s, 1);
                }
            }
        }
        int maxLetter = -1;
        int minLetter = Integer.MAX_VALUE;
        char max = 0;
        char min = 0;
        for (Character key : LoremIpsumMap.keySet()) {
            int keyAmount = LoremIpsumMap.get(key);
            if (keyAmount > maxLetter) {
                maxLetter = keyAmount;
                max = key;
            }
            if (keyAmount < minLetter) {
                minLetter = keyAmount;
                min = key;
            }
        }
        System.out.println("Буква '" + min + "' встречается реже, всего - " + minLetter + " раз(а).");
        System.out.println("Буква '" + max + "' встречается чаще, всего - " + maxLetter + " раз(а).");
    }
}