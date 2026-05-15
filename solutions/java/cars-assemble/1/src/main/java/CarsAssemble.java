public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        double p = 0; 
        if(speed >= 1 && speed <= 4) p = 1;
        else if(speed >= 5 && speed <=8) p = 0.9;
        else if(speed == 9) p = 0.8;
        else if(speed == 10) p = 0.77;
        return speed * 221 * p;
    }

    public int workingItemsPerMinute(int speed) {
        return (int)(productionRatePerHour(speed) / 60);
    }
}
