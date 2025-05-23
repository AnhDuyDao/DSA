import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    // Dang: Doan con co do dai nho nhat co tong >= target
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, sum = 0, minLength = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }

    // 3. Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring1(String s) {
        int left = 0;
        String temp = "";
        int maxLength = Integer.MIN_VALUE;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            temp = s.substring(left, right + 1);

            while (temp.indexOf(c) != temp.lastIndexOf(c)) {
                maxLength = Math.max(maxLength, right - left);
                temp = s.substring(left, right);
                left++;
            }

        }
        return maxLength;
    }

    // Sửa bài dùng 2 vòng for với O(n^2), tối ưu dùng HashSet, ở những bài sau
    public static int lengthOfLongestSubstring2(String s) {
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            for (int i = left; i < right; i++) {
                if (s.charAt(i) == c) {
                    left = i + 1;
                    break;
                }
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    // BT: Maximum sum of all subarrays of size K
    public static int maxSum(int[] arr, int n, int k) {
        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int windowSum = maxSum;
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    // 643. Maximum Average Subarray I
    public static double findMaxAverage(int[] nums, int k) {
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }
        int windowSum = maxSum;
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return (double) maxSum / k;
    }

    // Smallest subarray with sum greater than a given value
    public static ArrayList<Integer> smallestSubarrSumGreater(int[] arr, int target) {
        int n = arr.length;
        int left = 0, sum = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = -1, minEnd = -1;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                    minEnd = right;
                }
                sum -= arr[left];
                left++;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        if (minStart != -1) {
            for (int i = minStart; i <= minEnd; i++) {
                result.add(arr[i]);
            }
        }
        return result;
    }

    // Sửa bài: Longest Substring Without Repeating Characters bằng Sliding Window bằng cách trừ mã ASCII của 2 kí tự
    // Lỗi nếu gặp khoảng trắng hoặc kí tự in hoa ngo phạm vi mảng boolean[26]
    public static int lengthOfLongestSubstring3(String s) {
        int maxLength = Integer.MIN_VALUE;
        int left = 0;
        // Assuming only lowercase letters a-z ASCII with values 0-25
        boolean[] visited = new boolean[26];
        // Extending the current window to the right
        for (int right = 0; right < s.length(); right++) {
            // If character is repeated, move left pointer marking
            // visited characters as false until the repeating
            // character is no longer part of the current window
            while (visited[s.charAt(right) - 'a'] == true) {
                visited[s.charAt(left) - 'a'] = false;
                left++;
            }
            // Marked char as visited
            visited[s.charAt(right) - 'a'] = true;
            // Update the maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength != Integer.MIN_VALUE ? maxLength : 0;
    }

    // Dùng HashSet vì HashSet có thể chứa các kí tự không trùng lặp
    public static int lengthOfLongestSubstring4(String s) {
        Set<Character> setChar = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength = Integer.MIN_VALUE;
        while (right < s.length()) {
            if (!setChar.contains(s.charAt(right))) {
                setChar.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                setChar.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength != Integer.MIN_VALUE ? maxLength : 0;
    }

    public static void main(String[] args) {
//        String s = "abcabcbb";
//        System.out.println(lengthOfLongestSubstring2(s));
//        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
//        int k = 4;
//        int n = arr.length;
//        System.out.println(maxSum(arr, n, k));
//        int[] nums = {1,12,-5,-6,50,3};
//        int k = 4;
//        System.out.println(findMaxAverage(nums, k));
//        int[] arr = {1, 4, 45, 6, 0, 19};
//        int target = 51;
//        ArrayList<Integer> result = smallestSubarrSumGreater(arr, target);
//        for (int num : result) {
//            System.out.print(num + " ");
//        }

//        char c1 = s.charAt(2);
//        int asciic1 = (int) c1;
//        System.out.println(asciic1);
//        char c2 = s.charAt(0);
//        int asciic2 = (int) c2;
//        System.out.println(asciic2);
//        System.out.println(c1 - c2);

        String s = "abcabcbb";
        int result = lengthOfLongestSubstring4(s);
        System.out.println(result);
    }
}