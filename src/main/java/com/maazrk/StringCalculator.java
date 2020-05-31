package src.main.java.com.maazrk;

public class StringCalculator {

    public int Add(String numbers) {
        if (numbers == "") {
            return 0;
        }
        else if (numbers.contains(",")){
            String[] nums = numbers.split(",");
            return Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
        }
        else {
            return Integer.parseInt(numbers);
        }
    }

}