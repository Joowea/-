package 异常多线程04咖啡厅卖咖啡case;

/*生产者（咖啡店）类：是一个线程类 继承Thread

 * 设置线程任务run()：制作咖啡
 *
 * 对咖啡的状态进行判断
 *  true：有
 *    咖啡店调用wait()方法进入等待
 *  false：无
 *    咖啡店制作咖啡
 *    交替生产四种咖啡（i%4）
 *    咖啡店制作号咖啡 修改咖啡状态为true
 *    唤醒顾客线程 让顾客喝咖啡
 *
 * 注意：
 *    咖啡店线程 和咖啡线程的关系：通信
 *    必须通过同步技术保证这两个线程只有一个在执行
 *    锁对象必须保证唯一（可以使用coffee对象作为锁对象）
 *    咖啡店类和顾客类需要把咖啡对象作为参数传递进来
 *       1.需要在成员位置创建一个咖啡变量
 *       2.使用带参数的构造方法 为这个咖啡变量赋值
 */

public class CoffeeShop extends Thread {
    //1.需要在成员位置创建一个咖啡变量
    private Coffee cf;

    //2.使用带参数的构造方法 为这个咖啡变量赋值
    public CoffeeShop(Coffee cf) {
        this.cf = cf;
    }

    //设置线程任务run()：制作咖啡
    @Override
    public void run() {

        int coffeeCount = 0;

        //必须通过同步技术保证这两个线程只有一个在执行
        synchronized (cf) {

            while (true){//无限制作咖啡

                //对咖啡的状态进行判断
                if (cf.coffeeFlag == true) {

                    //咖啡店调用wait()方法进入等待
                    try {
                        cf.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //被唤醒之后执行 制作咖啡
                //交替生产四种咖啡（i%4）
                switch (coffeeCount % 4) {
                    case 0:
                        cf.types = "美式拿铁";
                        cf.size = "超大杯";
                        break;
                    case 1:
                        cf.types = "卡布奇诺";
                        cf.size = "大杯";
                        break;
                    case 2:
                        cf.types = "摩卡";
                        cf.size = "中杯";
                        break;
                    case 3:
                        cf.types = "速溶";
                        cf.size = "小杯";
                        break;
                }
                coffeeCount++;
                System.out.println("正在生产[" + cf.size + "]的[" + cf.types + "]咖啡");

                //生产过程 需要等待3秒
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //修改咖啡状态为true
                cf.coffeeFlag = true;

                //唤醒顾客线程 让顾客喝咖啡
                System.out.println("[" + cf.size + "]的[" + cf.types + "]咖啡制作完毕，顾客可以取走");
                cf.notify();
            }
        }
    }
}
