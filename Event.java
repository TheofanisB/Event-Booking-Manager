//Event Class 
import java.util.List;

public class Event {
    String Title;
    String Genre;
    String TimenDate;
    int available_seats;
    int cost_per_seat;

    public Event(String Title, String Genre, String TimenDate, int available_seats,int cost_per_seat) {// constructor 
        this.Title = Title;
        this.Genre = Genre;
        this.TimenDate = TimenDate;
        this.available_seats = available_seats;
        this.cost_per_seat=cost_per_seat;
    }
//setters getters
    public String getTitle() {
        return Title;
    }

    public String getGenre() {
        return Genre;
    }

    public String getTimenDate() {
        return TimenDate;
    }

    public int getAvailable_seats() {
        return available_seats;
    }

    public int getCost_per_seat() {
        return cost_per_seat;
    }

  
    // Printing out the event info
    public void ektiposi() {
        System.out.println( "{" + "Title=" + Title + ", Genre=" + Genre + ", TimenDate=" + TimenDate + ", available_seats=" + available_seats + ", cost_per_seat=" + cost_per_seat + '}');
    }

    
    
   
    
    
    
    
    
    
    
    
}
