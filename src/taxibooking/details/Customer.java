package taxibooking.details;

public class Customer {
    private int customerID;
    private char pickUpPoint;
    private char dropPoint;
    private int pickUpTime;
    private boolean travelStatus;
    private int taxiID;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public char getPickUpPoint() {
        return pickUpPoint;
    }

    public void setPickUpPoint(char pickUpPoint) {
        pickUpPoint= Character.toUpperCase(pickUpPoint);
        this.pickUpPoint = pickUpPoint;
    }

    public char getDropPoint() {
        return dropPoint;
    }

    public void setDropPoint(char dropPoint) {
        dropPoint= Character.toUpperCase(dropPoint);
        this.dropPoint = dropPoint;
    }

    public int getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(int pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public boolean getTravelStatus() {
        return travelStatus;
    }

    public void setTravelStatus(boolean travelStatus) {
        this.travelStatus = travelStatus;
    }

    public int getTaxiID() {
        return taxiID;
    }

    public void setTaxiID(int taxiID) {
        this.taxiID = taxiID;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", pickUpPoint=" + pickUpPoint +
                ", dropPoint=" + dropPoint +
                ", pickUpTime=" + pickUpTime +
                ", travelStatus=" + travelStatus +
                ", taxiID=" + taxiID +
                '}';
    }
}
