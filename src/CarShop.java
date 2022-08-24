import java.util.ArrayList;
import java.util.List;

public class CarShop {

    private final static int BUY_TIME = 2000;
    private final static int PRODUCE_TIME = 1000;
    final List<Car> cars = new ArrayList<>();

    public synchronized void buyCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            while(cars.size() == 0) {
                System.out.println("Машин нет!");
                wait();
            }
            Thread.sleep(BUY_TIME);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
            cars.remove(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void produceCar() {
        try {
            Thread.sleep(PRODUCE_TIME);
            cars.add(new Car());
            System.out.println(Thread.currentThread().getName() + " выпустил 1 авто");
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}