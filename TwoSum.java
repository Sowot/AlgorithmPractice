import java.util.HashMap;
import java.util.Map;

/**
 * Given nums = [2, 7, 11, 15], target = 9
 * Because nums[0] + nums[1] = 2 + 7 = 9
 * return [0, 1]
 */
public class TwoSum {

    /**
     * use hash map to improve the search efficiency
     * TC: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int offset = target - nums[i];
            if (map.containsKey(offset) && map.get(offset) != i) {
                return new int[]{i, map.get(offset)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] tmp = {5, 3, 7, 6};
        int[] res = new TwoSum().twoSum(tmp, 11);
        for (int i = 0; i < res.length; i++) {
            System.out.print(i + " ");
        }
    }
}
