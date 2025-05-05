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



    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring2(s));
    }
}