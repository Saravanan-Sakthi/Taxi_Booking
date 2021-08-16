package taxibooking.details;

import taxibooking.AddingOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public enum DataRecord {
    INSTANCE;

    private static int taxiID;
    private AddingOrder comparator= new AddingOrder();
    private HashMap<Character, TreeSet<Taxi>> taxis= new HashMap<>();
    private HashMap<Taxi, ArrayList<Customer>> taxiRecord= new HashMap<>();
    public void addTaxi( char point){
        point= Character.toUpperCase(point);
        TreeSet<Taxi> taxiStand = taxis.computeIfAbsent(point, k -> new TreeSet<>(comparator));
        Taxi newTaxi = new Taxi();
        newTaxi.setTaxiID(++taxiID);
        newTaxi.setLastDropPoint(point);
        newTaxi.setLastPickUpPoint(point);
        taxiStand.add(newTaxi);
    }

    public TreeSet<Taxi> getTaxiStand(char pickUpPoint){
        return taxis.get(pickUpPoint);
    }

    public TreeSet<Taxi> addTaxiStand(char point){
        TreeSet<Taxi> taxiStand = new TreeSet<>(comparator);
        taxis.put(point, taxiStand);
        return taxiStand;
    }

    public void addCustomerRecord(Taxi taxi, Customer data){
        ArrayList<Customer> rides = taxiRecord.computeIfAbsent(taxi, k -> new ArrayList<>());
        rides.add(data);
    }

    public HashMap<Taxi, ArrayList<Customer>> getRecord(){
        return taxiRecord;
    }

}
