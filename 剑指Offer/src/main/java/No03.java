/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/5/15 8:55 PM
 * @Usage:
 */
public class No03 {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(search(arr, 12));
    }

    private static boolean search(int[][] arr, int value) {
        int x = arr[0].length - 1;
        int y = 0;
        while (x >= 0 && y <= arr.length - 1) {
            if (arr[x][y] > value) {
                x--;
            } else if (arr[x][y] < value) {
                y++;
            } else {
                return true;
            }
        }
        return false;
    }
}
