import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] ints = TwoSum.solution2ms45(nums, target);
        for(int num : ints){
            System.out.println(num);
        }
    }
    
}
