import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyList<Customer> müşteriler = new MyList<>(3);
        Scanner scanner = new Scanner(System.in);

        for (int i = 0;i<müşteriler.mylist.length;i++){
            System.out.print("Müşteri ID giriniz: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Müşteri Adı giriniz: ");
            String firstname = scanner.nextLine();
            müşteriler.add(new Customer(id, firstname));
        }


        System.out.println("Eklenen Müşteriler:");
        for (int i = 0; i < müşteriler.size; i++) {
            System.out.println(müşteriler.get(i));
        }
    }
}
