package 异常多线程04咖啡厅卖咖啡case;

/*
* 测试类
*
*   包含main方法 程序入口
*
*   创建咖啡对象
*
*   创建咖啡店对象 开启 制作咖啡
*
*   创建顾客对象 开启 和咖啡
*/

public class Main110603 {

    public static void main(String[] args) {

        Coffee cf = new Coffee();


        new Customers(cf).start();
        new CoffeeShop(cf).start();
    }
}
