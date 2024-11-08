import java.util.HashMap;
import java.util.Map;
public class Main {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // Count occurrences of each element
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        int majorityElement = 0;
        int majorityCount = 0;
        
        // Find the element with the highest count
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            
            if (count > nums.length / 2) {
                // Found the majority element
                majorityElement = num;
                majorityCount = count;
                break;
            }
        }
        
        return majorityElement;
    }
    public static void main(String[] args) {
        Main main = new Main();
        int[] arr = {1, 1, 2, 2, 2, 2, 2,};
        int majority = main.majorityElement(arr);
        System.out.println("Majority Element: " + majority);
    }
    
}