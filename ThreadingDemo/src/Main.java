public class Main {
    public static void main(String[] args) {
        KronometreThread threads[] = new KronometreThread[5];
        for (int i =0;i<threads.length;i++) {
            KronometreThread thread = new KronometreThread("thread_" + i);
            threads[i]=thread;
            thread.start();
        }

    }
}