package Reservation;


import java.util.Scanner;

public class Execution {
    public static void main(String[] args)  {

      try{
        Scanner sc = new Scanner(System.in);
        int roomNumber = sc.nextInt();
        sc.nextLine();
        String checkIn = sc.nextLine();
        String checkOut = sc.nextLine();
        Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);

        System.out.println(reservation);

        System.out.println("Enter the data to update the reservation:");
   
        String checkInUpdate = sc.nextLine();
        String checkOutUpdate = sc.nextLine();
        reservation = new Reservation(roomNumber,checkInUpdate, checkOutUpdate);
       
        System.out.println(reservation);
        sc.close();
      }
      
      catch(DomainException e){
        System.out.println("Error in reservation: "+e.getMessage());
      }
     
      


        

    }
    
}
