import java.io.BufferedWriter;
import java.io.IOException;

public class KronometreThread implements Runnable {
    private static int counter = 0; // Shared counter for synchronization
    Thread thread;
    private String threadName;
    private BufferedWriter writer;
    private Object fileWriteLock;

    public KronometreThread(String threadName, BufferedWriter writer, Object fileWriteLock) {
        this.threadName = threadName;
        this.writer = writer;
        this.fileWriteLock = fileWriteLock;
        System.out.println("Oluşturuluyor : " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Çalıştırılıyor : " + threadName);
        try {
            for (int i = 1; i <= 10; i++) {
                String line = threadName + " : " + i;
                System.out.println(line);

                synchronized (fileWriteLock) {
                    writer.write(line);
                    writer.newLine();
                    writeDashedLine(); // Write dashed line every second
                }

                Thread.sleep(1000);
            }
        } catch (InterruptedException | IOException exception) {
            System.out.println("Kesildi : " + threadName);
        } finally {
            System.out.println("Thread bitti : " + threadName);
        }
    }

    private void writeDashedLine() throws IOException {
        counter++;
        if (counter == Main.SIZE) { // If all threads have written, reset counter and write dashed line
            counter = 0;
            writer.write("------------");
            writer.newLine();
        }
    }

    public void start() {
        System.out.println("Thread nesnesi oluşuyor");
        if (thread == null) {
            thread = new Thread(this::run);
            thread.start();
        }
    }
}
