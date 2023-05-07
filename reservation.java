package Reservation;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.print.attribute.standard.DateTimeAtProcessing;

public class reservation {
   private Integer roomNumber;
   private String checkIn;
   private String checkOut; 

    

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

   public reservation(Integer roomNumber,String checkIn, String checkOut){
    this.roomNumber = roomNumber;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
   }
   public reservation(String checkIn, String checkOut) {
    this.checkIn = checkIn;
    this.checkOut = checkOut;
}

   
 
    public void setRoomNumber(Integer roomNumber){
        this.roomNumber = roomNumber;

    }
   public Integer getRoomNumber(){
    return roomNumber;
   }

   public void setCheckIn(String checkIn){
    this.checkIn = checkIn;

   }
   public String getCheckIn(){
    return checkIn;

   }
   public String getCheckOut() {
    return checkOut;
    }
    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public Long calculateNight(){
        
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.parse(getCheckIn(),formatter);
        LocalDate date_2 = LocalDate.parse(getCheckOut(),formatter);
        Duration duration = Duration.between(date.atStartOfDay(), date_2.atStartOfDay());
        if(date.isAfter(date_2)){
            throw new DomainException("Check-out must be after check-in date");

        }
        if(date.isBefore(now) || date.isBefore(now)){
            throw new DomainException("Reservation dates must be in the future");
        }
        return duration.toDays();
        
    

    
        
    }

    public String toString(){
        StringBuilder sc = new StringBuilder();
        sc.append("Reservation: room: "+getRoomNumber());
        sc.append(", Check-in:"+getCheckIn());
        sc.append(", check-out: "+getCheckOut()+", ");
        sc.append(calculateNight()+ " nights");

        return sc.toString();

    }


}
