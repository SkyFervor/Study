package concurrent;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 3个线程轮流分别打印出A、B、C
 */
public class ThreadWheel {
    static class PrintTask implements Runnable {

        private String content;

        private PrintTask preTask;

        private boolean ready;

        public PrintTask(String content, boolean ready) {
            this.content = content;
            this.ready = ready;
        }

        public void setPreTask(PrintTask preTask) {
            this.preTask = preTask;
        }

        public void run() {
            try {
                while (true) {
                    synchronized (PrintTask.class) {
                        while (!preTask.ready) {
                            PrintTask.class.wait();
                        }
                        System.out.println(content);
                        preTask.ready = false;
                        this.ready = true;
                        PrintTask.class.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        PrintTask printTask1 = new PrintTask("A", false);
        PrintTask printTask2 = new PrintTask("B", false);
        PrintTask printTask3 = new PrintTask("C", true);
        printTask1.setPreTask(printTask3);
        printTask2.setPreTask(printTask1);
        printTask3.setPreTask(printTask2);

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                3, 3, 1, TimeUnit.MINUTES, new SynchronousQueue<>());
        threadPool.execute(printTask1);
        threadPool.execute(printTask2);
        threadPool.execute(printTask3);
    }
}
