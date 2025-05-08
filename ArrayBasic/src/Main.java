public class Main {
    public static boolean bAfterA(String s) {
        boolean startedB = false;
        boolean result = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                startedB = true;
            }
            if (s.charAt(i) == 'a' && startedB) {
                System.out.println("Có a sau b");
                return false;
            }
        }
        result = true;
        return result;
    }



    public static void main(String[] args) {
//        int[] a = {5, 2, 9, 1, 7};
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }
//
//        int sum = 0;
//        for (int i = 0; i < a.length; i++) {
//            sum += a[i];
//        }
//        System.out.println("Tổng = " + sum);
//
//        int max = a[0];
//        for (int i = 1; i < a.length; i++) {
//            if (a[i] > max) {
//                max = a[i];
//            }
//        }
//        System.out.println("Max = " + max);
//
//        int X = 2;
//        int count = 0;
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] == X) {
//                count++;
//            }
//        }
//        System.out.println("Số lần xuất hiện của " + X + " là " + count);

        String s = "b";
        System.out.println(bAfterA(s));
    }
}