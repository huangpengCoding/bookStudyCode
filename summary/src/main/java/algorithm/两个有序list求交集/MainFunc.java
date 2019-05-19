package algorithm.两个有序list求交集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/5/3 4:31 PM
 * @Usage: 两个有序的list求交集;
 */
public class MainFunc {

    public static List<Integer> func1(List<Integer> lis1, List<Integer> lis2) {
        List<Integer> res = new ArrayList();
        for (int i1 : lis1) {
            for (int i2 : lis2) {
                if (i1 == i2) {
                    res.add(i1);
                }
            }
        }
        return res;
    }

    public static List<Integer> func2(List<Integer> lis1, List<Integer> lis2, List<Integer> res2, int i, int j) {
        if (i >= lis1.size() || j >= lis2.size()) {
            return res2;
        }
        int val1 = lis1.get(i);
        int val2 = lis2.get(j);
        if (val1 == val2) {
            res2.add(val1);
        }
        if (val1 >= val2) {
            return func2(lis1, lis2, res2, i, ++j);
        } else {
            return func2(lis1, lis2, res2, ++i, j);
        }

    }

    public static void main(String[] args) {
        List<Integer> lis1 = Arrays.asList(1, 3, 4, 5, 6, 7, 9, 11, 12, 15, 16);
        List<Integer> lis2 = Arrays.asList(1, 4, 5, 6, 7, 8, 10, 11, 14, 16, 17, 20);
        //for循环处理
        System.out.println(func1(lis1, lis2));
        //两个指针移动处理
        List<Integer> res2 = new ArrayList<Integer>();
        System.out.println(func2(lis1, lis2, res2, 0, 0));
    }
}
