package algorithm.先递增再递减的数组找出最大值;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/5/18 7:58 PM
 * @Usage:
 */
public class MainFunc {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 12, 36, 72, 51, 43, 23, 21};
        System.out.println(findMaxInArr(arr, 0, arr.length));
    }

    public static int findMaxInArr(int[] arr, int l, int r) {
        int mid = (l + r) / 2;
        if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
            return findMaxInArr(arr, mid, r);
        } else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
            return findMaxInArr(arr, l, mid);
        } else if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
            return arr[mid];
        }
        return -1;
    }
}
