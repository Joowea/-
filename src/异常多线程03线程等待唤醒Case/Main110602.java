package 异常多线程03线程等待唤醒Case;

public class Main110602 {

    public static void main(String[] args) {

        //创建一个锁对象 保证唯一
        Object obj = new Object();

        //创建一个顾客线程
        new Thread() {

            @Override
            public void run() {

                //1保证等待 与唤醒的线程只能有一个执行 需要使用同步技术
                synchronized (obj) {

                    System.out.println("告知老板要的包子和数量");

                    try { //2等待做包子 线程进入WAITING状态
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("顾客收到包子，开始吃包子");//7客户最后被唤醒 开始吃包子
                }
            }
        }.start();

        //3创建一个老板做包子的线程
        new Thread(){
            @Override
            public void run() {

                //4保证等待 与唤醒的线程只能有一个执行 需要使用同步技术
                //（上面线程在RUNNABLE状态时 不会执行此线程）
                synchronized (obj){

                    System.out.println("接到顾客需求，正在做包子...");

                    try {//5做包子的等待时间
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("包子已经做好，告知顾客");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    obj.notify();//6唤醒客户线程
                }
            }
        }.start();
    }
}
