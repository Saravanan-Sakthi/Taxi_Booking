package taxibooking;

import taxibooking.details.Taxi;

import java.util.Comparator;

public class AddingOrder implements Comparator<Taxi> {
    @Override
    public int compare(Taxi o1, Taxi o2) {
        if (o1.getAvailableTime() == o2.getAvailableTime()){
            if(o1.getEarning()== o2.getEarning()){
                return o1.getTaxiID()-o2.getTaxiID();
            }
            else return o2.getEarning()-o1.getEarning();
        }
        else {
            return o1.getAvailableTime()-o2.getAvailableTime();
        }
    }
}
