// Battery.java
public class Battery {
    private int capacityMah;      // total capacity 
    private int levelPercent;     // 0–100

    // Constructor (required)
    public Battery(int initialLevelPercent) {
        this(3000, initialLevelPercent); // default capacity
    }

    // Overloaded constructor (optional bonus)
    public Battery(int capacityMah, int initialLevelPercent) {
        if (capacityMah <= 0) throw new IllegalArgumentException("Capacity must be positive.");
        this.capacityMah = capacityMah;
        setLevelPercent(initialLevelPercent); // use setter for validation
    }

    // ACCESSORS (getters)
    public int getCapacityMah() {
        return capacityMah;
    }

    public int getLevelPercent() {
        return levelPercent;
    }

    // MUTATORS (setters) with validation
    public void setLevelPercent(int levelPercent) {
        if (levelPercent < 0 || levelPercent > 100) {
            throw new IllegalArgumentException("Battery level must be between 0 and 100.");
        }
        this.levelPercent = levelPercent;
    }

    // Behavior: drain some percentage (never below 0)
    public void drain(int percent) {
        if (percent < 0) throw new IllegalArgumentException("Drain percent cannot be negative.");
        levelPercent = Math.max(0, levelPercent - percent);
    }

    // Behavior: recharge to full
    public void recharge() {
        levelPercent = 100;
    }

    // Behavior: check if empty
    public boolean isEmpty() {
        return levelPercent == 0;
    }

    @Override
    public String toString() {
        return "Battery{" + levelPercent + "%, " + capacityMah + "mAh}";
    }
}
