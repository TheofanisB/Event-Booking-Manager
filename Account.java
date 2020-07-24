//Account class
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class Account {

    private String username;
    private String password;

    //-----------------------------------------------REGISTER---------------------------------------------------------------- 
    int Register(List<Account> acc_list) {//new account function ( mono user)
      
        System.out.println("Please insert the Username and the password!");
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        int i = 0;

        do { // checks if its unique
            if (acc_list.get(i).getUsername().equals(a)) {// checks for same username in the account list 
                System.out.println("Username not available . Please insert a new username !");
                a = input.nextLine();
                i = -1;
            }
            i++;

        } while (i < acc_list.size());//end of unique account checking 

        //at this point the username is unique , so we're asking the password
        System.out.println("Please insert the password Password !");
        String pw = input.nextLine();
        
       User neoAccount = new User(a, pw); // creates a new account
        acc_list.add(neoAccount);// adding the new account to the list 
        
        return acc_list.size()-1; //the account is being added at the end of the list  so it will be on the   size-1 position 
    }//end of register ------------------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------LOGIN---------------------------------------------------

    int Login(List<Account> acc_list) { //Login Function (Returns the account's position)
        System.out.println("Login : Please insert a username");
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        int i = -1;
      
                    // username check
        int check=0;
        do{ // loop login  username
            i = -1;
            do {//loop that finds the username
                i++;
                if (acc_list.get(i).getUsername().equals(a)){check=1;} // if the username is found then check=1 
            }while(  i<acc_list.size()-1 && acc_list.get(i).getUsername().equals(a)==false); //while the username wasnt found and it hasn't gone through the entire list  
            if (check==0) // if the username was not found 
                    {
                        
                     System.out.println(" Please insert a registered username ");
                     a = input.next();
                    }
           
        }while(check!=1);// ends when the username is found
        System.out.println("Correct Username!");
        
            do {//password check
             System.out.println("Please insert a Password");
                a = input.next();
            }while (acc_list.get(i).getPassword().equals(a)==false); // password check 
            
       return i;         
   }//----------------------------------------------------End of LOGIN --------------------------------------------------------
    
    //-----------------------------Delete Account------------------------------------------------------
    int deleteAccount(List<Account> acc_list,String username)
    {
        for (int i=0;i<acc_list.size();i++) //for that goes through the list
        {
            if (username.equals(acc_list.get(i).getUsername()))
            {
            acc_list.remove(i);
            
            return -1; // -1 is the value for logging out
            }
        
        
        }
        return 1; // else the username stays logged it
    
    }
    // LOGOUT
    int logOut() // 
    {
    return -1;
    
    }
    //Login Type that lets us know if the user is a simple user or an admin
    int loginType(List<Account> acc_list,int itr){ 
       
       
         if(acc_list.get(itr) instanceof Admin) {
                    return 0;// 0 Admin
            } else{
                    return 1;// 1 User
            }
    
    }
    
    
    
    //-----------------------------Telos Delete Account------------------------------------------------------

//constructor
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //SETTERS GETTERS 
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    int searchEvent(List<Event> event_list, String Titlos) // vriskei tin ekdilosi kai epistrefei tin thesi tou stin lista 
    {
     for (int i = 0; i < event_list.size(); i++) {
            if (event_list.get(i).getTitle().equalsIgnoreCase(Titlos)) {
             return i;
            }

        }
     return -1; // an den to vrei girnaei -1
    
    }
    
      void displayEvents(List<Event> event_list) // ektiponei oles tis diathesimes ekdiloseis 
    {
    System.out.println("---------Diathesimes Ekdiloseis---------");
    for (int i=0;i<event_list.size();i++)
    {
    event_list.get(i).ektiposi();
    }
   
    }//telos display
      
      
      
      
      
      
      

   
    
    

}//telos account class

