
class BirdWatcher {
    private final int[] birdsPerDay;
    private int[] lastWeek = {0, 2, 5, 3, 7, 8, 4};

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return lastWeek.clone();
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        for(int c: birdsPerDay) {
            if(c == 0)
                return true;
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int n = 0;
        for(int i=0; i< (numberOfDays < 7 ? numberOfDays : 7); i++) {
            n += birdsPerDay[i];
        }
        return n;
    }

    public int getBusyDays() {
        int n = 0;
        for(int c: birdsPerDay) {
            if(c >= 5)
                n++;
        }
        return n;
    }
}
