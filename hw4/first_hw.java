package hw4;

public class first_hw {

        static Object monitor = new Object();
        static String currentLetter = "A";
        public static void main(String[] args) {
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        printA();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        printB();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            Thread thread3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        printC();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            thread1.start();
            thread2.start();
            thread3.start();




        }public static void printA() throws InterruptedException {
            synchronized (monitor){
                for (int i = 0; i < 5; i++) {
                    while (!currentLetter.equals("A")){
                        monitor.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = "B";
                    monitor.notifyAll();
                }
            }

        }
        public static void printB() throws InterruptedException {
            synchronized (monitor){
                for (int i = 0; i < 5; i++) {
                    while (!currentLetter.equals("B")){
                        monitor.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = "C";
                    monitor.notifyAll();
                }
            }

        }
        public static void printC() throws InterruptedException {
            synchronized (monitor){
                for (int i = 0; i < 5; i++) {
                    while (!currentLetter.equals("C")){
                        monitor.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = "A";
                    monitor.notifyAll();

                }
            }

        }
    }
