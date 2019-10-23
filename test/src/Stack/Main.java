package Stack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] str = scanner.nextLine().split(" ");
            int[] nums = new int[str.length + 1];
            for (int i = 1; i < nums.length; ++i) {
                nums[i] = Integer.parseInt(str[i - 1]);
            }
            int m1 = scanner.nextInt();
            int m2 = scanner.nextInt();
            int cnt = 0;
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] == m1 || nums[i] == m2) {
                    cnt++;
                }
            }
            if (cnt != 2) {
                System.out.println(-1);
                return;
            }
            int index = 1;
            while (--n >= 0) {
                if (nums[index] == -1) {
                    System.out.println(-1);
                    break;
                }
                if (nums[index] == m1 || nums[index] == m2) {
                    System.out.println(nums[index]);
                    break;
                }
                if (nums[index] > Math.min(m1, m2) && nums[index] < Math.max(m1, m2)) {
                    System.out.println(nums[index]);
                    break;
                }
                if (nums[index] < Math.min(m1, m2)) {
                    index = index * 2 + 1;
                } else {
                    index = index * 2;
                }
            }
            System.out.println(-1);
        }
    }
}

