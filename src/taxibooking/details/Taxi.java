package taxibooking.details;

public class Taxi {
    private int taxiID;
    private int earning;
    private int availableTime;
    private char lastDropPoint;
    private char lastPickUpPoint;

    public int getTaxiID() {
        return taxiID;
    }

    public void setTaxiID(int taxiID) {
        this.taxiID = taxiID;
    }

    public int getEarning() {
        return earning;
    }

    public void setEarning(int earning) {
        this.earning = earning;
    }

    public int getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(int availableTime) {
        this.availableTime = availableTime;
    }

    public char getLastDropPoint() {
        return lastDropPoint;
    }

    public void setLastDropPoint(char lastDropPoint) {
        this.lastDropPoint = lastDropPoint;
    }

    public char getLastPickUpPoint() {
        return lastPickUpPoint;
    }

    public void setLastPickUpPoint(char lastPickUpPoint) {
        this.lastPickUpPoint = lastPickUpPoint;
    }

    @Override
    public String toString() {
        return "\nTaxi{" +
                "taxiID=" + taxiID +
                ", earning=" + earning +
                ", availableTime=" + availableTime +/*
                ", lastDropTime=" + lastDropTime +*/
                '}';
    }
}
