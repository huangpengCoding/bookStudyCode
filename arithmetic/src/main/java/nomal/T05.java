package nomal;

import java.util.Scanner;
import java.util.Stack;

/**
 由两个栈组成的队列
 用两个栈实现队列，支持队列的基本操作。
 输入描述
 第一行输入一个整数N，表示对队列进行的操作总数。

 下面N行每行输入一个字符串S，表示操作的种类。

 如果S为"add"，则后面还有一个整数X表示向队列尾部加入整数X。

 如果S为"poll"，则表示弹出队列头部操作。

 如果S为"peek"，则表示询问当前队列中头部元素是多少。
 输出描述
 对于每一个为"peek"的操作，输出一行表示当前队列中头部元素是多少。
 示例1
 输入
 6
 add 1
 add 2
 add 3
 peek
 poll
 peek
 输出
 1
 2
 */
public class T05 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int data){
        stack1.push(data);
    }

    public Integer pop() throws Exception {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            throw new Exception("no data");
        }
        return stack2.pop();
    }

    public Integer peek(){
        return stack1.peek();
    }


    public static void main(String[] args) throws Exception {
        T05 t = new T05();
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        while (i-->0){
            String operatorStr = scanner.nextLine();
            if(operatorStr.startsWith("add")){
                int data = Integer.parseInt(operatorStr.split(" ")[1].trim());
                t.push(data);
            }else if(operatorStr.trim().equals("peek")){
                t.peek();

            }else if(operatorStr.trim().equals("poll")){
              t.pop();
            }
        }

    }

}
