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



    public static void main(String[] args) {
//        String s = "abcabcbb";
//        System.out.println(lengthOfLongestSubstring2(s));
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
    }
}