import com.sun.jdi.IntegerValue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        BufferedReader reader = null;
        int total =0;
        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\Dell\\Documents\\JavaProjects\\ReadingfileDemo\\src\\sayilar.txt"));
            String line = null;
            while ((line = reader.readLine())!= null){
              total+= Integer.valueOf(line);
            }
             System.out.println("Toplam="+total);
        } catch (FileNotFoundException e) {
            System.out.println("Dosya Bulunamadı");
        } catch (IOException e) {

        }
        catch (NumberFormatException a){
            System.out.println("Sayı giriniz lütfen");
        }
         finally {try {
            reader.close();
        }
        catch (IOException exception){
        }

        }
    }
}