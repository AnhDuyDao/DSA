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


    public static void main(String[] args) {
//        int arr[] = {1, 2, 4, 7, 11, 15};
//        int target = 15;
//        pairSum(arr, target);
        int numbers[] = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(numbers, target);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}