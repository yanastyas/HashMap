
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class Main {

    public final static String LoremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        char[] arr = LoremIpsum.toLowerCase(Locale.ROOT).toCharArray();
        Map<Character, Integer> symbols = new HashMap<>();
        for (char s : arr) {
            if (Character.isLetter(s)) {
                Integer integer = symbols.get(s);
                if (integer == null) {
                    symbols.put(s, 1);
                    continue;
                }
                symbols.put(s, ++integer);
            }
        }
        Integer max = getMax(symbols);
        Integer min = getMin(symbols);

        System.out.println("В тексте встречается чаще всего буква: ");
        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println("'" + entry.getKey() + "'" + " - " + entry.getValue() + " раз(а).");
            }
        }
        System.out.println("В тексте встречается реже всего:");
        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            if (entry.getValue() == min) {
                System.out.println("'" + entry.getKey() + "'" + " - " + entry.getValue() + " раз(а).");
            }
        }
    }

    private static Integer getMax(Map<Character, Integer> symbols) {
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
            }
        }
        return max;
    }

    private static Integer getMin(Map<Character, Integer> symbols) {
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            if (min > entry.getValue()) {
                min = entry.getValue();
            }
        }
        return min;
    }

}

