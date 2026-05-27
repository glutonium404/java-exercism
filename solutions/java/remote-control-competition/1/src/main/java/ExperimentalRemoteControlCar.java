public class ExperimentalRemoteControlCar implements RemoteControlCar {

    private int dt = 0;

    public void drive() {
        dt += 20;
    }

    public int getDistanceTravelled() {
        return dt;
    }
}
