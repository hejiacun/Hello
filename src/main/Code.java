package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: hejiacun
 * @create: 2020-01-08
 **/
public class Code {
    public static void main(String[] args) {
        List<Integer> height = Arrays.asList(1,0,2,5,0,3,0,4);
//        method1(height);
//        method2(height);
//        method3(height);
        int[] nums = {2,0,1,4};
        maxSlidingWindow(nums, 3);

        System.out.println(Thread.currentThread().getName());
        AtomicInteger atomicInteger = new AtomicInteger(3);
        System.out.println(atomicInteger);
    }

    private static int method1(List<Integer> height) {
        List<Integer> list = new ArrayList<>();
        int n = height.size();
        int total = 0;
        for (int i =1; i < n -1;i++) {
            int l = 0;
            int r = 0;
            for (int j = i; j < n; j++) {
                r = Math.max(r, height.get(j));
            }
            for (int j = i; j >= 0; j--) {
                l = Math.max(l, height.get(j));
            }
            int length = Math.min(r, l) - height.get(i);
            list.add(length);
            total += length;
        }
        System.out.println(list);
        System.out.println(total);
        return total;
    }

    private static int method2(List<Integer> height) {
        List<Integer> list = new ArrayList<>();
        int n = height.size();
        int total = 0;
        List<Integer> left = new ArrayList<>(Collections.nCopies(n, 0));
        List<Integer> right = new ArrayList<>(Collections.nCopies(n, 0));
        left.set(0, height.get(0));
        right.set(n-1, height.get(n-1));
        for (int i = 1; i < n; i++) {
            left.set(i, Math.max(height.get(i), left.get(i - 1)));
        }
        for (int i = n-2; i >= 0; i--) {
            right.set(i, Math.max(height.get(i), right.get(i + 1)));
        }
        for (int i =1; i < n -1;i++) {
            int length = Math.min(right.get(i), left.get(i)) - height.get(i);
            list.add(length);
            total += length;
        }
        System.out.println(list);
        System.out.println(total);
        return total;
    }

    private static int method3(List<Integer> height) {
        int n = height.size();
        List<Integer> list = new ArrayList<>(Collections.nCopies(n, 0));
        int total = 0, left = 0, right = n-1;
        int l = height.get(0);
        int r = height.get(n-1);

        while (left <= right) {
            l = Math.max(l, height.get(left));
            r = Math.max(r, height.get(right));
            if (l < r) {
                int length = l - height.get(left);
                list.set(left, length);
                total += length;
                left++;
            } else {
                int length = r - height.get(right);
                total += length;
                list.set(right, length);
                right--;
            }
        }
        System.out.println(list);
        System.out.println(total);
        return total;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        int [] left = new int[n];
        left[0] = nums[0];
        int [] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            // from left to right
            if (i % k == 0) {
                left[i] = nums[i];  // block_start
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }

            // from right to left
            int j = n - i - 1;
            if ((j + 1) % k == 0) {
                right[j] = nums[j];  // block_end
            } else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }

        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            output[i] = Math.max(left[i + k - 1], right[i]);
        }
        for (int i = 0; i < output.length; i++) {
            int i1 = output[i];
            System.out.println(i1);
        }
        return output;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            l1 = new ListNode(0);
        }
        l1.val += l2 == null ? 0 : l2.val;
        if (l1.val > 9) {
            l1.val = l1.val % 10;
            if (l1.next == null) {
                l1.next = new ListNode(1);
            } else {
                l1.next.val += 1;
            }
            l1.next = addTwoNumbers(l1.next, l2 == null ? null : l2.next);
        } else {
            l1.next = addTwoNumbers(l1.next, l2 == null ? null : l2.next);
        }
        return l1;
    }


      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
}
