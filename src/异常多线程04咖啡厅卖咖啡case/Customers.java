package 异常多线程04咖啡厅卖咖啡case;

/*
 * 消费者（顾客）类：是一个线程类 继承Thread
 *
 * 设置线程任务run()：喝咖啡
 *
 * 对咖啡的状态进行判断：
 *   false：没有咖啡
 *       顾客调用wait()方法进行等待
 *   true：有咖啡
 *       顾客喝咖啡
 *       顾客喝完咖啡
 *       咖啡状态改为：false
 *       顾客唤醒咖啡店线程 制作咖啡
 *
 * 注意：
 *    咖啡店线程 和咖啡线程的关系：通信
 *    必须通过同步技术保证这两个线程只有一个在执行
 *    锁对象必须保证唯一（可以使用coffee对象作为锁对象）
 *    咖啡店类和顾客类需要把咖啡对象作为参数传递进来
 *       1.需要在成员位置创建一个咖啡变量
 *       2.使用带参数的构造方法 为这个咖啡变量赋值
 */

public class Customers extends Thread {

    private Coffee cf;

    public Customers(Coffee cf) {
        this.cf = cf;
    }

    //设置线程任务run()：喝咖啡
    @Override
    public void run() {

        synchronized (cf) {

            while (true){

                //对咖啡的状态进行判断：
                if (cf.coffeeFlag == false) {//false：没有咖啡

                    //顾客调用wait()方法进行等待
                    try {
                        cf.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //唤醒后执行
                //true：有咖啡
                //顾客喝咖啡
                System.out.println("顾客正在喝[" + cf.size + "]的[" + cf.types + "]咖啡");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("顾客喝完了咖啡");

                System.out.println("_________________________");

                //咖啡状态改为：false
                cf.coffeeFlag = false;

                //顾客唤醒咖啡店线程 制作咖啡
                cf.notify();

            }
        }
    }
}
