import java.io.*;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 5;

    public static void main(String[] args) {
        CreateFile();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Dell\\Desktop\\Yazılım\\Java Projects\\WorkingWithFiles\\writings.txt"))) {
            Object fileWriteLock = new Object();

            KronometreThread threads[] = new KronometreThread[SIZE];

            for (int i = 0; i < threads.length; i++) {
                KronometreThread thread = new KronometreThread("thread_" + i, writer, fileWriteLock);
                threads[i] = thread;
            }

            for (KronometreThread thread : threads) {
                thread.start();
            }

            for (KronometreThread thread : threads) {
                thread.thread.join();
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        GetFileInfo();
        ReadFile();

    }
    public static void CreateFile(){
        File file = new File("C:\\Users\\Dell\\Desktop\\Yazılım\\Java Projects\\WorkingWithFiles\\writings.txt");
        try {
            if(file.createNewFile()){
                System.out.println("Dosya oluşturuldu");
            }
            else {
                System.out.println("Dosya zaten mevcut");

            }

        }

        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void GetFileInfo(){
        File file = new File("C:\\Users\\Dell\\Desktop\\Yazılım\\Java Projects\\WorkingWithFiles\\writings.txt");
        if(file.exists()){
            System.out.println("Dosya adı = "+ file.getName());
            System.out.println("Dosya yolu = "+ file.getAbsolutePath());
            if(file.canWrite()){
                System.out.println("Dosya yazılabilir");
            }
            else {
                System.out.println("Dosya yazılamaz");
            }
            if(file.canRead()){
                System.out.println("Dosya okunabilir");
            }
            else {
                System.out.println("Dosya okunamaz");
            }
            System.out.println("Dosya boyutu = "+file.length());
        }
        else {
            System.out.println("Dosya Bulunamadı");
        }
    }
    public static void ReadFile(){
        File file = new File("C:\\Users\\Dell\\Desktop\\Yazılım\\Java Projects\\WorkingWithFiles\\writings.txt");
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
             String line = reader.nextLine();
                 System.out.println(line);

            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Dosya Bulunamadı");
        }

    }
}