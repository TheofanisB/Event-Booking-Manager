//Booking Class
import java.util.List;
import java.util.logging.Logger;


public class Kratisi {
    String username;
    String title;
    String TimeNDate;
    int desiredNumOfSeats;// number of seats desired to book 
    float kostos;
    
    
    int athroismaKleismenon (List <Kratisi> kratisi_list,List<Event> event_list,int epilogi)// calculates how many seats are left in the event 
    {
        int sinolo=0;
        for (int i=0;i<kratisi_list.size();i++)
        {
            if (event_list.get(epilogi).getTitle().equals(kratisi_list.get(i).getTitle())){
            sinolo=sinolo+kratisi_list.get(i).desiredNumOfSeats;
            }
        }
    return sinolo;
    
    }//end of adding  

    public Kratisi(String username, String title, String TimeNDate, int desiredNumOfSeats,float kostos) { // constructor 
        this.username = username;
        this.title = title;
        this.TimeNDate = TimeNDate;
        this.desiredNumOfSeats = desiredNumOfSeats;
        this.kostos=kostos;
    }

    @Override 
    public String toString() {
        return "Kratisi{" + "username=" + username + ", title=" + title + ", TimeNDate=" + TimeNDate + ", desiredNumOfSeats=" + desiredNumOfSeats + '}';
    }
    // getters 
    public String getUsername() {
        return username;
    }

    public String getTitle() {
        return title;
    }

    public String getTimeNDate() {
        return TimeNDate;
    }

    public int getDesiredNumOfSeats() {
        return desiredNumOfSeats;
    }

    public float getKostos() {
        return kostos;
    }
//setter
    public void setKostos(float kostos) {
        this.kostos = kostos;
    }
   
    
    
}

