//Admin Class
import java.util.List;
import java.util.Scanner;


public class Admin extends Account { // constructor 

    public Admin(String username, String password) {
        super(username, password);

    }

    
       
            

    
    
    
       //--------------------------------Admin rights---------------------
        //----------------------------Create Event
    void createEvent(List<Event> event_list) {    //  reads the info and creates an object which is then added to the event list  
    //Event(String Title, String Genre, String TimenDate, int available_seats)
        System.out.println("Please insert the Event information! ");
        Scanner apantisi = new Scanner(System.in);
        System.out.println("Title:");
        String title = apantisi.nextLine();
        System.out.println("Genre:");
        String Genre = apantisi.nextLine();
        System.out.println("Date and Time:");
        String TimenDate = apantisi.nextLine();
        
        System.out.println("Available Seats:");
        int available_seats = apantisi.nextInt();
        System.out.println("Ticket price:");
        int cost_per_seat = apantisi.nextInt();
        
        
        Event neoEvent = new Event(title, Genre, TimenDate, available_seats, cost_per_seat);
        event_list.add(neoEvent);

    }//--------------end of Create Event-----------------

    //----------------------------------------CANCEL EVENT----------------------
    void cancelEvent(List<Event> event_list, String Titlos) { // searches the event and deletes it
        
        
            if (searchEvent(event_list,Titlos)>=0) {
                //int searchEvent(List<Event> event_list, String Titlos)
                event_list.remove(searchEvent(event_list,Titlos));
            }else{
            System.out.println("There's no event with such name!");
            
            }

       
            

    }//telos cancelEvent-------------------------------------------------------- 

}//telos admin
