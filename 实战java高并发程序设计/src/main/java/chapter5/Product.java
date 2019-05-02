package chapter5;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/5/2 6:23 PM
 * @Usage: 不变模式
 */
public final class Product {

    private final String no;
    private final String name;
    private final double price;

    public Product(String no, String name, double price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }

    public String getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
