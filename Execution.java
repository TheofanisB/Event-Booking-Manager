//Bakitas Theofanis 321/2015133
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 User Accounts:
Username Password
User1    123

Admin Accounts:
Username Password
Admin1    123



Credit Card:
Username Number
Takis	1234


Event :
Karagkiozis
 */
public class Execution {

    public static void Run() {
        // dimiourgia liston 
        List<Account> acc_list = new ArrayList<>(); // list of accounts
        List<Event> event_list = new ArrayList<>(); // list of events
        List<Kratisi> kratisi_list = new ArrayList<>();// list of bookings
        List<CreditCard> bank_db = new ArrayList<>(); // list of credit cards
        
        CreditCard pseftiki = new CreditCard("Takis", "1234", 1000); //default card-------------------
         bank_db.add(pseftiki); //adds it to the list
         
        Account default_acc = new Account("default", "default");//---------------------default account
        User user1 = new User("User1", "123");
        acc_list.add(user1); // adds user1 to the list
        Admin admin1 = new Admin("Admin1", "123");//-----------------------------admin account
         acc_list.add(admin1);// adds admin 1 to the list 
        acc_list.add(default_acc);//adds the default account to the list
       

        // Event(String Title, String Genre, String TimenDate, int available_seats,int cost_per_seat)
        Event event1 = new Event("Karagkiozis", "Paradosiako", "12/12/2019 18:30", 100, 10);//------------------------
        event_list.add(event1);
        
        //public Kratisi(String username, String title, String TimeNDate, int desiredNumOfSeats,float kostos)
        Kratisi kratisi1=new Kratisi("User1","Karagkiozis","default",0,10);//---------------------------
        kratisi_list.add(kratisi1);
        
        
        //File
        FileEditor file1 = new FileEditor(); // creates new FileEditor
        file1.openFile(); // opens the file

        int loginStatus = 0;// variable that lets us know if the user is logged in

      //----------------------------------------------------------------------
        // Start
        // Asks for login or Registration
        System.out.println("---------------------------Welcome------------------------ \n 1.Login       2.Register");
        Scanner apantisi = new Scanner(System.in);
        int ap = apantisi.nextInt();
        if (ap == 1) // logs in
        {
            loginStatus = default_acc.Login(acc_list);

        } else if (ap == 2) // registers 
        {
            loginStatus = default_acc.Register(acc_list);

        }
        //Done logging in and shows the next menu 
        System.out.println(" \n 1.Continue     2.Logout    3.Delete your Account");
        ap = apantisi.nextInt();
        if (ap == 1) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Continuing~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            
        } else if (ap == 2) {
            loginStatus = default_acc.logOut();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Logging out~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } else if (ap == 3) {
            System.out.println("To verify deleting your account , Please insert your username!");
            String userToDel = apantisi.next();
            loginStatus = default_acc.deleteAccount(acc_list, userToDel);
            if (loginStatus < 0) {
                System.out.println("Deleted succesfully!");
            } else {

                System.out.println("I diagrafi apetixe! Aposindeeste gia logous asfaleias!");
                loginStatus = -1;// if login status is over -1 then it is logged in
                // it also lets us know which username is logged in
                
            }

        }
if (loginStatus>-1){ //if it found an account then it will search for the account type
        int menu_options = acc_list.get(loginStatus).loginType(acc_list, loginStatus); // checks if the account is a user or an admin 

        //----------------------------------------------------------------------
        // ----------------------------------ADMIN MENU--------------------------------
        if (menu_options == 0)// if the account type is admin then it shows the admin menu 
        {
            System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*ADMIN MENU*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
        
        int stop=0;
      do {

        acc_list.get(loginStatus).displayEvents(event_list); // printing out the available events 
        System.out.println("1. Add an Event 2. Delete Event 3.Exit");
                int epilogi=apantisi.nextInt();
        if (epilogi==2)//Delete an Event
        {
            
            System.out.println("Please insert the title of the event!");
        String titlos_ergou;
         titlos_ergou = apantisi.next();
        //((Admin) acc_list.get(loginStatus))
       ((Admin) acc_list.get(loginStatus)).cancelEvent(event_list,titlos_ergou);//check if there's such an event and deletes it 
        }else if (epilogi==1){ // dimiourgia ekdilosis 
            
        ((Admin) acc_list.get(loginStatus)).createEvent(event_list);
        
        System.out.println("Would you like to continue? 0.Yes 1.No ");
        do{
        stop=apantisi.nextInt(); 
        }while(stop<0 && stop>1);// if the user wants to do something else 
        }else
        {
        stop=1;
        
        }
       
      
      
      
      
      
      
      
      }while (stop==0);//end of loops in admin menu
        
      
      //end of admin menu
     
        
    
    
    
    }// user
        
        //((User) acc_list.get(loginStatus))
          else if (menu_options == 1) // if the menu options =1 then its a user 
    {
         System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*USER MENU*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
         int choice =((User) acc_list.get(loginStatus)).chooseEvent(event_list);
         ((User) acc_list.get(loginStatus)).orderTickets(acc_list.get(loginStatus).getUsername(),event_list,choice,kratisi_list,bank_db);
         System.out.println("Would you like to cancel your orders ? 1.No 2.Yes");
          int ans = apantisi.nextInt(); //reads the answer
          if (ans==2)
          {
          ((User) acc_list.get(loginStatus)).cancelOrder( acc_list.get(loginStatus).getUsername(), kratisi_list, bank_db);
          
          }
         
         
    } 
}
file1.addKratiseis(kratisi_list); // saves all the booking in a file
    file1.closeFile(); // closes out the file 
   }
}
