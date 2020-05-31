package src.main.java.com.maazrk;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int Add(String numbers) {
        if (numbers == "") {
            return 0;
        }
        else {
            int[] nums = Arrays.asList(getTokens(numbers)).stream().mapToInt(Integer::parseInt).toArray();
            validateTokens(nums);
            int sum = 0;
            for (int token : nums) {
                sum += token;
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

    private void validateTokens(int[] tokens) {
        //Check for negatives
        int[] negatives = Arrays.stream(tokens).filter(x -> x < 0).toArray();
        if (negatives.length > 0) {
            throw new RuntimeException("negatives not allowed: " + Arrays.toString(negatives));
        }
    }

}