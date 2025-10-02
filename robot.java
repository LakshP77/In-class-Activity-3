// Robot.java
public class robot {
    private Battery battery;
    private String model;

    // Constructor (required)
    // Driver expects: new Robot(50)
    public robot(int initialBatteryPercent) {
        this.battery = new Battery(initialBatteryPercent);
        this.model = "R-100";
    }

    // ----- Accessors / Mutators -----
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    // Provide safe access to battery level without exposing internals
    public int getBatteryLevel() { return battery.getLevelPercent(); }

    public int getBatteryCapacityMah() { return battery.getCapacityMah(); }

    // 1) Check battery (prints status)
    public void checkBattery() {
        System.out.println("Battery level: " + battery.getLevelPercent() + "%");
    }

    // 2) Move (drains battery; prevents move if too low)
    public void move() {
        if (battery.isEmpty()) {
            System.out.println("Cannot move. Battery empty. Please recharge.");
            return;
        }
        // drain by a fixed cost for demo; could be parameterized
        int cost = 10;
        if (battery.getLevelPercent() < cost) {
            System.out.println("Battery too low to move safely. Please recharge.");
            return;
        }
        battery.drain(cost);
        System.out.println("Robot moved forward. (-" + cost + "% battery)");
    }

    // 3) Recharge battery
    public void rechargeBattery() {
        battery.recharge();
        System.out.println("Recharging complete. Battery is now 100%.");
    }

    // 4) Is battery empty? (prints and returns boolean so it’s useful both ways)
    public boolean isBatteryEmpty() {
        boolean empty = battery.isEmpty();
        System.out.println("Is battery empty? " + empty);
        return empty;
    }


    // Speak a message
    public void speak(String message) {
        System.out.println(model + ": " + message);
    }

    // Rotate some degrees (drains a little)
    public void rotate(int degrees) {
        if (degrees == 0) {
            System.out.println("No rotation needed.");
            return;
        }
        int cost = Math.min(5, Math.max(1, Math.abs(degrees) / 90)); // small cost
        if (battery.getLevelPercent() < cost) {
            System.out.println("Battery too low to rotate. Please recharge.");
            return;
        }
        battery.drain(cost);
        System.out.println("Rotated " + degrees + " degrees. (-" + cost + "% battery)");
    }
}
