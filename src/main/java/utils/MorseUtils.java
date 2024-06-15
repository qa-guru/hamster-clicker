package utils;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class MorseUtils {

    private final Map<String, String> morseCodeMap = new HashMap<>();

    public MorseUtils() {
        try {
            String filePath = "src/main/resources/morse_code.txt";
            Files.lines(Paths.get(filePath))
                    .forEach(line -> {
                        String[] parts = line.split("=");
                        morseCodeMap.put(parts[0], parts[1]);
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getLetterMorseCode(String letter) {
        return morseCodeMap.get(letter.toUpperCase());
    }
}
