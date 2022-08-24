public class Main {
    private final static int BUYERS = 3;
    private final static int TIME = 3000;

    public static void main(String[] args) {
        final CarShop carShop = new CarShop();
        for (int i = 1; i <= BUYERS; i++) {
            new Thread(null, carShop::buyCar, "Покупатель " + i).start();
            try {

                Thread.sleep(TIME);
                new Thread(null, carShop::produceCar, "Производитель TOYOTA").start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}