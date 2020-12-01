package 异常多线程05线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main110702ThreadPool {

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(3);

        while (true){

            es.submit(new RunnableImpl());
        }
    }
}

