public class KronometreThread implements Runnable{
    private Thread thread;
    private String threadname;
    public KronometreThread(String threadname)
    {
        this.threadname = threadname;
        System.out.println("Oluşturuluyor : "+threadname);
    }
    @Override
    public void run() {
       System.out.println("Çalıştırılıyor : "+threadname);
          try{
              for (int i = 1;i<=10;i++){
                  System.out.println(threadname+" : "+i);
                  Thread.sleep(1000);
              }
          }
          catch (InterruptedException exception){
              System.out.println("Kesildi : "+threadname);
          }
          System.out.println("Thread bitti : "+threadname);
    }
    public void start(){
        System.out.println("Thread nesnesi oluşuyor");
        if(thread==null){
            thread = new Thread(this::run,threadname);
            thread.start();
        }
    }
}
