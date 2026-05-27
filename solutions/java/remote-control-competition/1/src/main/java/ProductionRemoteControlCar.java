class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    private int dt = 0;
    private int nv = 0;

    public void drive() {
        dt += 10;
    }

    public int getDistanceTravelled() {
        return dt;
    }

    public int getNumberOfVictories() {
        return nv;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        nv = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar car) {
        return Integer.compare(nv, car.getNumberOfVictories());
    }
}

