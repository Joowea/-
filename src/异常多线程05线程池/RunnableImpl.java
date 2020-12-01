package 异常多线程05线程池;

public class RunnableImpl implements Runnable {
    @Override
    public void run() {

        System.out.println("["+Thread.currentThread().getName()+"]线程正在执行任务");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
