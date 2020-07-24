//User Class
import java.util.List;
import java.util.Scanner;


public class User  extends Account {

    public User(String username,String password) { // constructor 
        super(username,password);
        
    }
    
  
   
    
    void orderTickets( String username,List<Event> event_list,int choice,List <Kratisi> kratisi_list,List <CreditCard> bank_db)// Function that books tickets
    {
        System.out.println("How many tickets for seats would you like to order?");
        Scanner input = new Scanner(System.in);
         int epithimites = input.nextInt();
         
         
         
         
         
        if(kratisi_list.get(0).athroismaKleismenon(kratisi_list, event_list, choice)+epithimites>event_list.get(choice).getAvailable_seats()  )//Checks if there's available seats 
            
        {// if there aren't enough seats it asks for a smaller booking 
          
        System.out.println("There is an insufficient amount of seats  !");
        do{
          System.out.println("How many seats would you like to book?");
        
         epithimites = input.nextInt();
        }while (kratisi_list.get(0).athroismaKleismenon(kratisi_list, event_list, choice)+epithimites>event_list.get(choice).getAvailable_seats() );
        
            
        }else {// if there's enough seats 
          //calculates the cost , checks if the user paid and then books the seats  
            float cost=event_list.get(choice).getCost_per_seat()*epithimites;
            //-----------ASKING FOR $$$$$$$$$$$$$$$$
            System.out.println("Please insert your credit card info  !");
            System.out.print("Name :");
            String onoma = input.next();
            System.out.print("Number :");
            String arithmos_kartas = input.next();
           
             bank_db.get(0).Pay(onoma,arithmos_kartas,cost,bank_db);//using 0 because that's a default user in the system 
             
            
            //--End of payment and now we make the booking 
            Kratisi new_kratisi =new Kratisi(username,event_list.get(choice).getTitle(),event_list.get(choice).getTimenDate(),epithimites,cost);
            kratisi_list.add(new_kratisi);
            
       
        
        
        }
    
    }//end of ordering tickets 
    
          
       int chooseEvent(List<Event> event_list){// method that lets the user pick an event
        displayEvents(event_list);
        System.out.println("What is the title of the event you would like to watch?");
        Scanner input = new Scanner(System.in);
        int k;
        do{ // loop that searches the event  
        String choice = input.nextLine();
         k=searchEvent(event_list,choice);
       
        if (k<0) // if no event with such name was found then 
        {
         System.out.println("There's no show with such title  . Please insert a new title ");
        }
        }while (k<0);
        return k;
 }//end of chooseEvent function 
       
       void cancelOrder(String username,List <Kratisi> kratisi_list,List<CreditCard> bank_db) //method that allows the user to cancel their bookings 
    {
        for (int i=0;i<kratisi_list.size();i++)
        {
        if (kratisi_list.get(i).getUsername().equals(username)){
            
            //gives a refund to the user 
            for (int j=0;j<bank_db.size();j++)
            {
                if (username.equals(bank_db.get(j).getName()))
                {
                    
                    bank_db.get(j).setBalance(bank_db.get(j).getBalance()+kratisi_list.get(i).getKostos());
                 //returns the money to the bank account 
                }
            
            }
            
            kratisi_list.remove(i); //deletes the booking 
            
        }
        }
    
    
  }//end of cancelOrder
    
     
    
    
    
    
    
    
}
