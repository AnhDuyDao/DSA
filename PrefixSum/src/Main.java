public class Main {
    public static int[] buildPrefix(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        return prefix;
    }

    public static int rangeSum(int[] prefix, int left, int right) {
        return prefix[right + 1] - prefix[left];
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 5};
        int[] prefix = buildPrefix(arr);
        System.out.println("Tổng từ chỉ số 1 đến 3 = " + rangeSum(prefix, 1, 3)); // Output: 7
    }
}