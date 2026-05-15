public class JedliksToyCar {
    private int battery = 100;
    private int dis = 0;
    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return "Driven " + dis + " meters";
    }

    public String batteryDisplay() {
        if(battery <= 0)
            return "Battery empty";

        return "Battery at " + battery + "%";
    }

    public void drive() {
        if(battery <= 0)
            return;
        battery -= 1;
        dis += 20;
    }
}
