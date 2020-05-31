package src.main.java.com.maazrk;

public class StringCalculator {

    public int Add(String numbers) {
        if (numbers == "") {
            return 0;
        }
        else if (numbers.contains(",")){
            String[] nums = numbers.split(",");
            int sum = 0;
            for (String token : nums) {
                sum += Integer.parseInt(token);
            }
            return sum;
        }
        else {
            return Integer.parseInt(numbers);
        }
    }

}