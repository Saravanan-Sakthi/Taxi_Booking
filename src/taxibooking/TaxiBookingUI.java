package taxibooking;

import taxibooking.details.Customer;
import taxibooking.details.DataRecord;
import taxibooking.details.Taxi;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaxiBookingUI {
    public static void main(String[] args) {
        BookingEngine instance = BookingEngine.getInstance();
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.print("1. Add taxi to stand A\n2. Book taxi\n3. View taxi record\n4. Exit\nEnter the option: ");
            try {
                int option = scan.nextInt();
                if (option ==1){
                    System.out.print("Enter the point : ");
                    char point = scan.next().charAt(0);
                    instance.addTaxi(point);
                }
                else if(option == 2){
                    System.out.print("Enter the pick up point: ");
                    char pickUpPoint = scan.next().charAt(0);
                    System.out.print("Enter the drop point: ");
                    char dropPoint = scan.next().charAt(0);
                    System.out.print("Enter the pick up time: ");
                    int pickUpTime = scan.nextInt();
                    Customer request = createRequest(pickUpPoint, dropPoint, pickUpTime);
                    Taxi taxi = instance.getTaxi(request);
                    if(taxi != null) {
                        System.out.println("Taxi " + taxi.getTaxiID() + " is allocated for you");
                    }
                    else {
                        System.out.println("Sorry, no taxis available");
                    }
                }
                else if (option == 3){
                    HashMap<Taxi, ArrayList<Customer>> taxiDetails = DataRecord.INSTANCE.getRecord();
                    for (Taxi taxiData : taxiDetails.keySet()){
                        System.out.println(taxiData);
                        for (Customer customers : taxiDetails.get(taxiData)){
                            System.out.println(customers);
                        }
                    }
                }
                else if (option == 4){
                    break;
                }
                else {
                    System.out.println("Invalid input");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }
        }
    }

    private static Customer createRequest(char pickUpPoint, char dropPoint, int pickUpTime) {
        Customer request = new Customer();
        request.setPickUpPoint(pickUpPoint);
        request.setDropPoint(dropPoint);
        request.setPickUpTime(pickUpTime);
        return request;
    }
}
