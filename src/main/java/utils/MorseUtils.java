package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MorseUtils {

    private final Map<String, String> morseCodeMap;

    public MorseUtils() {
        morseCodeMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/morse_code.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    morseCodeMap.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLetterMorseCode(String letter) {
        return morseCodeMap.get(letter.toUpperCase());
    }
}
