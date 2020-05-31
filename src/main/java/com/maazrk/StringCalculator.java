package src.main.java.com.maazrk;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    int calledCount;

    public StringCalculator() {
        this.calledCount = 0;
    }

    public int Add(String numbers) {
        this.calledCount += 1;
        if (numbers == "") {
            return 0;
        }
        else {
            int[] nums = Arrays.asList(getTokens(numbers)).stream().mapToInt(Integer::parseInt).toArray();
            validateTokens(nums);
            int sum = 0;
            for (int token : nums) {
                if (token <= 1000) {
                    sum += token;
            
                }
            }
            return sum;
        }
    }

    public int GetCalledCount() {
        return calledCount;
    }

    private String[] getTokens(String numbers) {
        String pattern = ",|\n";

        if (numbers.startsWith("//")) {
            Matcher m = Pattern.compile("//\\[?(.*?)\\]?\n(.*)").matcher(numbers);
            m.matches();
            pattern = m.group(1);
            String parsedString = m.group(2);
            return parsedString.split(Pattern.quote(pattern));
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