import java.util.Arrays;

public class Main {
    // Dang 1: Tim cap so co tong bang target
    public static void pairSum(int arr[], int target) {
        int left = 0; int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                System.out.println(arr[left] + " + " + arr[right] + " = " + target);
                break;
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }

    //167. Two Sum II - Input Array Is Sorted
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1, -1}; // Not found
    }

    //209. Minimum Size Subarray Sum
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    // 977. Squares of a Sorted Array
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int arr[] = {1, 2, 4, 7, 11, 15};
//        int target = 15;
//        pairSum(arr, target);
//        int numbers[] = {2, 7, 11, 15};
//        int target = 9;
//        int[] result = twoSum(numbers, target);
//        for (int num : result) {
//            System.out.print(num + " ");
//        }
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int sum = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        System.out.println("Min length = " + minLen);
    }
}