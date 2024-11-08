import java.util.Random;

public class Main {

    public static void main(String[] args)
    {
        Basamak bas = new Basamak();
        Basamak basamak = new Basamak();
        Random random = new Random();
       int rnd = random.nextInt(0,10);
       int rnd2 = random.nextInt(0,10);
       int rnd3 = random.nextInt(1,10);
       basamak.Birler(rnd);
       basamak.Onlar(rnd2);
       basamak.Yuzler(rnd3);

        Basamak basamak1 = new Basamak();
        Random random1 = new Random();
        int rnd4 = random1.nextInt(0,10);
        int rnd5 = random1.nextInt(0,10);
        int rnd6 = random1.nextInt(1,10);
        basamak1.Birler(rnd4);
        basamak1.Onlar(rnd5);
        basamak1.Yuzler(rnd6);

        Basamak basamak2 = new Basamak();
        Random random2 = new Random();
        int rnd7 = random2.nextInt(0,10);
        int rnd8 = random2.nextInt(0,10);
        int rnd9= random2.nextInt(1,10);
        basamak2.Birler(rnd7);
        basamak2.Onlar(rnd8);
        basamak2.Yuzler(rnd9);

        int toplam = basamak.b+ basamak.o+ basamak.y;
        System.out.println("ilk sayı = "+toplam);
        int toplam1= basamak1.b+ basamak1.o+ basamak1.y;
        System.out.println("ikinci sayı = "+toplam1);
        int toplam2 = basamak2.b+ basamak2.o+ basamak2.y;
        System.out.println("üçüncü sayı = "+toplam2);
        if (toplam < toplam1 & toplam<toplam2)
        {
            bas.min_num = toplam;
        }
        if (toplam1 < toplam & toplam1<toplam2)
        {
            bas.min_num = toplam1;
        }
        if (toplam2 < toplam & toplam2<toplam1)
        {
            bas.min_num = toplam2;
        }

        bas.o = bas.min_num%100-bas.min_num%10;
        bas.y = bas.Ayiriciy(bas.min_num,bas.y)*100;
        bas.b = bas.min_num-(bas.y+bas.o);
        bas.min_num = bas.y+bas.o+bas.b;
        System.out.println("En küçük sayı = "+bas.min_num);
        bas.min_num = bas.y;
        bas.min_num = bas.min_num+(bas.o/10+bas.b*10);
        System.out.println("Birler ve onlar basamağı değişmiş hali = "+bas.min_num);
        bas.b = bas.b *10;
        if(bas.b >=50)
        {
         bas.min_num = bas.y+100;
        }
        else
        {
         bas.min_num = bas.y;
        }
        System.out.println("Yüzdelik olarak yuvarlanmış hali = "+bas.min_num);

    }
}