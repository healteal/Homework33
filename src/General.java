import java.util.Arrays;

public class General extends Thread {
    static int[] array = new int[10];
    static int avg = 0;
    static int max = 0;

    public static void main(String[] args) {
        General t1 = new General();
        t1.start(); // Запуск потока 1
        while (t1.isAlive()) ;
        Runnable t2 = () -> {
            for (int j : array) {
                avg += j;
            }
            avg /= array.length;
        };
        Runnable t3 = new Runnable() {
            @Override
            public void run() {
                for (int j : array) {
                    if (max < j) {
                        max = j;
                    }
                }
            }
        };
        t2.run(); // Запуск потока 2
        t3.run(); // Запуск потока 3
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 50);
        }
        System.out.println(Arrays.toString(array));
    }
}
