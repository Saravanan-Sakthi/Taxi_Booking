package taxibooking;

import taxibooking.details.Customer;
import taxibooking.details.DataRecord;
import taxibooking.details.Taxi;

import java.util.TreeSet;

public class BookingEngine {
    private static int customerID;
    private static BookingEngine instance=null;
    private BookingEngine() {
    }

    public static BookingEngine getInstance() {
        if(instance == null){
            instance= new BookingEngine();
        }
        return instance;
    }

    public void addTaxi(char point){
        point= Character.toUpperCase(point);
        DataRecord.INSTANCE.addTaxi(point);
    }

    public Taxi getTaxi(Customer request){
        char pickUpPoint = request.getPickUpPoint();
        char dropPoint = request.getDropPoint();
        int distancePoints =(dropPoint>pickUpPoint) ? dropPoint-pickUpPoint : pickUpPoint-dropPoint;
        int pickUpTime = request.getPickUpTime();
        Taxi taxi = getTaxi(pickUpPoint, pickUpTime);
        if (taxi != null){
            request.setCustomerID(++customerID);
            request.setTaxiID(taxi.getTaxiID());
            request.setTravelStatus(true);
            moveTaxi(taxi, dropPoint);
            addEarning(taxi, distancePoints);
            taxi.setAvailableTime(pickUpTime+distancePoints);
            DataRecord.INSTANCE.addCustomerRecord(taxi, request);
            return taxi;
        }
        return null;
    }

    private Taxi getAvailableTaxi(TreeSet<Taxi> treeSet, int pickUpTime){
        Taxi check= new Taxi();
        check.setEarning(0);
        check.setAvailableTime(pickUpTime);
        Taxi available = treeSet.floor(check);
        if(available !=null && available.getAvailableTime()>pickUpTime){
            available= null;
        }
        return available ;
    }

    private Taxi getTaxi(char pickUpPoint, int pickUpTime){
        TreeSet<Taxi> freeTaxis = DataRecord.INSTANCE.getTaxiStand(pickUpPoint);
        Taxi taxi=null;
            int i=0;
            while(pickUpPoint - i >= 65 && pickUpPoint + i <= 70) {
                if (freeTaxis == null && pickUpPoint - i >= 65) {
                    freeTaxis = DataRecord.INSTANCE.getTaxiStand((char) (pickUpPoint - i));
                }
                if (freeTaxis == null && pickUpPoint + i <= 70){
                    freeTaxis = DataRecord.INSTANCE.getTaxiStand((char)(pickUpPoint+i));
                }
                if(freeTaxis != null) {
                    taxi = getAvailableTaxi(freeTaxis, pickUpTime - i);
                }
                if(taxi != null){
                    break;
                }
                freeTaxis= null;
                i++;
            }
        return taxi;
    }

    private void addEarning(Taxi taxi, int distancePoints){
        int kms = distancePoints*15;
        int earnings = 100+((kms-5)*10);
        taxi.setEarning(taxi.getEarning()+earnings);
    }

    private void moveTaxi(Taxi taxi, char dropPoint){
        TreeSet<Taxi> toPoint = DataRecord.INSTANCE.getTaxiStand(dropPoint);
        if (toPoint == null){
            toPoint= DataRecord.INSTANCE.addTaxiStand(dropPoint);
        }
        TreeSet<Taxi> fromPoint = DataRecord.INSTANCE.getTaxiStand(taxi.getLastDropPoint());
        fromPoint.remove(taxi);
        toPoint.add(taxi);
    }
}
