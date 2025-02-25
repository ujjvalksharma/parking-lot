package org.example;

import org.example.constant.PaymentType;
import org.example.entity.Car;
import org.example.entity.Entrance;
import org.example.entity.Exit;
import org.example.entity.LargeParkingSpot;
import org.example.entity.Location;
import org.example.entity.ParkingFloor;
import org.example.entity.ParkingLot;
import org.example.entity.ParkingSpot;
import org.example.entity.Payment;
import org.example.entity.Person;
import org.example.entity.SmallParkingSpot;
import org.example.entity.Truck;
import org.example.entity.Vehicle;
import org.example.entity.Ticket;
import org.example.repository.EntranceRepository;
import org.example.repository.ExitRepository;
import org.example.repository.ParkingFloorRepository;
import org.example.repository.ParkingLotRepository;
import org.example.repository.ParkingSpotRepository;
import org.example.repository.VechileRepository;
import org.example.service.EntranceService;
import org.example.service.ExitService;

import java.util.List;


/**
 * Some of design pattern used:
 * Singleton for repo, servies,
 * Double dispatch/Visitor to map Vehciles to Spot without using instanceOf,
 * Strategy for payment and parking
 *
 */
public class Driver {
  public static void main(String[] args) {
    ParkingSpot largeParkingSpot1 = new LargeParkingSpot(1, new Location(1,2));
    ParkingSpot largeParkingSpot2 = new LargeParkingSpot(2, new Location(10,4));
    ParkingSpot smallParkingSpot1 = new SmallParkingSpot(3, new Location(11,5));
    ParkingSpot smallParkingSpot2 = new SmallParkingSpot(4, new Location(0,0));

    ParkingSpotRepository.getInstance().save(largeParkingSpot1);
    ParkingSpotRepository.getInstance().save(largeParkingSpot2);
    ParkingSpotRepository.getInstance().save(smallParkingSpot1);
    ParkingSpotRepository.getInstance().save(smallParkingSpot2);


    Vehicle car = new Car(1,"abc" , "red");
    Vehicle truck = new Truck(2, "def" , "red");

    VechileRepository.getInstance().save(car);
    VechileRepository.getInstance().save(truck);

    ParkingFloor parkingFloor1 = new ParkingFloor(1, List.of(largeParkingSpot1, smallParkingSpot1));
    ParkingFloor parkingFloor2 = new ParkingFloor(2, List.of(largeParkingSpot2, smallParkingSpot2));

    ParkingFloorRepository.getInstance().save(parkingFloor1);
    ParkingFloorRepository.getInstance().save(parkingFloor2);

    Entrance entrance1 = new Entrance(1, new Location(4, 5));
    Entrance entrance2 = new Entrance(1, new Location(6, 7));
    Exit exit1 = new Exit(1, new Location(8, 20));
    Exit exit2 = new Exit(1, new Location(21, 40));

    EntranceRepository.getInstance().save(entrance1);
    EntranceRepository.getInstance().save(entrance2);
    ExitRepository.getInstance().save(exit1);
    ExitRepository.getInstance().save(exit2);

    ParkingLot parkingLot = new ParkingLot(
            List.of(parkingFloor1, parkingFloor2),
            List.of(entrance1, entrance2),
            List.of(exit1, exit2),
    1);

    Person person = new Person(1,  "ujjval", "licenceNumber1" );
    System.out.println("Person parking person: " + person);
    System.out.println("Car: " + car);
    ParkingLotRepository.getInstance().save(parkingLot);
    System.out.println("parkingLot : " + parkingLot);
    System.out.println("Entrance : " + entrance1);
    Ticket ticket = EntranceService.getInstance().parkVehicle(car, person, entrance1);
    System.out.println("ticket from entrance: " + ticket);
    Payment payment = ExitService.getInstance().processExit(ticket.getId(), PaymentType.CASH);
    System.out.println("Payment at exit: " + payment);



  }
}

//Db schema
//Sql queries

//Design ParkingLot
//
//R1: The parking lot should have the capacity to park 40,000 vehicles.
//R2: The four different types of parking spots are handicapped, compact, large, and motorcycle.
//R3: The parking lot should have multiple entrance and exit points.
// R4: Four types of vehicles should be allowed to park in the parking lot, which are as follows:
//Car, Truck, Van, Motorcycle
//R5: The parking lot should have a display board that shows free parking spots for each parking spot type.
//R6: The system should not allow more vehicles in the parking lot if the maximum capacity (40,000) is reached.
//R7: If the parking lot is completely occupied, the system should show a message on the entrance and on the parking lot display board.
//R8: Customers should be able to collect a parking ticket from the entrance and pay at the exit.
//R9: The customer can pay for the ticket either with an automated exit panel or pay the parking agent at the exit.
//R10: The payment should be calculated at an hourly rate.
//R11: Payment can be made using either a credit/debit card or cash.
//R12: The parking lot should have multiple floors where customers can park their cars.
//R13: we want to park to the parkingspot to the nearest entrances