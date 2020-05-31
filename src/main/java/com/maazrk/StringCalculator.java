package src.main.java.com.maazrk;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int Add(String numbers) {
        if (numbers == "") {
            return 0;
        }
        else {
            String[] nums = getTokens(numbers);
            int sum = 0;
            for (String token : nums) {
                sum += Integer.parseInt(token);
            }
            return sum;
        }
    }

    private String[] getTokens(String numbers) {
        String pattern = ",|\n";

        if (numbers.startsWith("//")) {
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numbers);
            m.matches();
            pattern = m.group(1);
            String parsedString = m.group(2);
            return parsedString.split(pattern);
        }
        return numbers.split(pattern);

    }

}