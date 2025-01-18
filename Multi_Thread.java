/**
 * @author Michael Lee (mylee13845@gmail.com)
 * This program is a basic multi-threading program that uses both Thread and Runnable
 */
// class Task1 extends Thread {
//     @Override
//     public void run() {
//         for (int i = 0; i < 10; i++) {
//             System.out.println("thread1 ==> " + "count: " + i);
//         }
//     }
// }
// class Task2 extends Thread {
//     @Override
//     public void run() {
//         for (int i = 0; i < 10; i++) {
//             System.out.println("thread2 ==> " + "count: " + i);
//         }
//     }
// }

class Task1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("thread1 ==> " + "count: " + i);
        }
    }
}
class Task2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("thread2 ==> " + "count: " + i);
        }
    }
}
public class Multi_Thread {
    public static void main(String[] args) {
        System.out.println("Start of main thread");
        //Extends thread (class is now limited to extending thread and can not extend any other class, enables tight coupling)
        // Task1 task = new Task1();
        // Task2 task2 = new Task2();
        //Implements runnable (Loose coupling and is implemented only if need a special run method)
        Runnable r1 = new Task1();
        Runnable r2 = new Task2();
        Thread task1 = new Thread(r1);
        Thread task2 = new Thread(r2);
        task1.start();
        task2.start();
        try{
            task1.join();
            task2.join();
        }catch(InterruptedException e){

        }
        System.out.println("End of main thread");
    }
}
