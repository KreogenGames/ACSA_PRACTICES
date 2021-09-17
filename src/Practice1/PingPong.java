package Practice1;

class PingPongThread implements Runnable{
    private Object LOCK_OBJECT; //Нужен для корректного взаимодействия 2 потоков через методы wait()/notify()
    private String name;
    boolean runner = true;
    public PingPongThread(Object LOCK_OBJECT, String name) {
        this.LOCK_OBJECT = LOCK_OBJECT;
        this.name = name;
    }
    @Override
    public void run() {
        /*synchronized (LOCK_OBJECT) {
            while(true) {
                System.out.println(name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                LOCK_OBJECT.notify();
                try {
                    LOCK_OBJECT.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }*/
        while(runner){
            System.out.println(name);
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class PingPong {
    public static void main(String[] args) throws  InterruptedException {
        Object LOCK_OBJECT = new Object();
        //Thread ping = new Thread(new PingPongThread(LOCK_OBJECT, "Ping"));
        //Thread pong = new Thread(new PingPongThread(LOCK_OBJECT, "Pong"));
        PingPongThread ping = new PingPongThread(LOCK_OBJECT, "Ping");
        PingPongThread pong = new PingPongThread(LOCK_OBJECT, "Pong");

        Thread pinger = new Thread(ping);
        Thread ponger = new Thread(pong);

        pinger.start();
        ponger.start();

        ponger.sleep(5000);
        pong.runner =false;
        ponger.join();
        System.out.println("Ponger is stopped");
    }
}

