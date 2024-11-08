public class Main {
    public static void main(String[] args) {
        try{
            String[]kelimeler = new String[]{"ahmet","mahmut","ayşe"};
            int[]sayilar = new int[]{1,2,3};
            System.out.println(sayilar[2]);
            System.out.print(kelimeler[3]);
        }
        catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException IndexOut){
            System.out.println("Hata Oluştu");
        }
        finally {
            System.out.println("Ben Her Türlü çalışırım");
        }


    }
}