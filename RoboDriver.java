public class RoboDriver {
    public static void main(String[] args) {
        robot r1 = new robot(50);
        r1.checkBattery();
        r1.move();
        r1.checkBattery();
        r1.rechargeBattery();
        r1.checkBattery();
        r1.isBatteryEmpty();
    }
}
