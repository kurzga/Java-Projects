public class Main {
    public static void main(String[] args) {
     AccountManager account = new AccountManager();
     System.out.println("Hesap = "+account.getBalance());
     account.deposit(100);
     System.out.println("Hesap = "+account.getBalance());
     try{
         account.withdraw(90);
     }
     catch (BalanceInsufficientException exception){
         System.out.println(exception.getMessage());
     }
     System.out.println("Hesap = "+account.getBalance());
        try{
            account.deposit(50);
            System.out.println("Hesap = "+account.getBalance());
            account.withdraw(30);
        }
        catch (BalanceInsufficientException exception){
            System.out.println(exception.getMessage());
        }
        try{
            System.out.println("Hesap = "+account.getBalance());
            account.withdraw(50);
        }
        catch (BalanceInsufficientException exception){
            System.out.println(exception.getMessage());
        }

    }
}