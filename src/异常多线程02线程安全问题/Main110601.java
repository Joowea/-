package 异常多线程02线程安全问题;

public class Main110601 {

    public static void main(String[] args){

        RunnableImpl run = new RunnableImpl();

        Thread t1 = new Thread(run); //创建三个线程共同卖一百张票
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);

        t1.start();
        t2.start();
        t3.start();

        /*
        ...
        Thread-1-->正在卖第[3]张票
        Thread-2-->正在卖第[3]张票
        Thread-0-->正在卖第[1]张票
        Thread-2-->正在卖第[0]张票
        Thread-1-->正在卖第[-1]张票  出现线程安全问题
        */
    }
}
