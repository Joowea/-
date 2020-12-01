package 异常多线程02线程安全问题;

public class RunnableImpl implements Runnable {

    private int ticket = 100; //多线程的共享数据

    Object obj = new Object();

    @Override
    public void run() {

        while(true){ //死循环 让卖票重复执行

            synchronized (obj){
                if(ticket>0){ //判断是否还有票

                    try {
                        Thread.sleep(10); //提高问题出现的概率
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"-->正在卖第["+ticket+"]张票");

                    ticket--;
                }
            }
        }
    }
}
