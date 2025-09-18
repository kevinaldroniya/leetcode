import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoSum {

    public static int[] solution546msAnd44(int[] nums, int target){
        List<Integer> newNums = Arrays.stream(nums)
                .boxed()
                .toList();

        for (int i = 0; i < newNums.size(); i++) {
            int diff = target - newNums.get(i);
            int diffIndex = newNums.indexOf(diff);
            if (diffIndex < 0 || diffIndex == i) {
                continue;
            }
            return new int[]{i, diffIndex};
        }

        return new int[0];
    }

    public static int[] solution2ms45(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numsMap.containsKey(diff)) {
                return new int[] {numsMap.get(diff), i};
            }
            numsMap.put(nums[i], i);
        }
        return new int[0];
    }
}
