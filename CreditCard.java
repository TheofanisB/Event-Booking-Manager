//Credit Card Class
import java.util.List;
import java.util.Scanner;

public class CreditCard {
    String name;
    String arithmos;
    float balance;// account balance

    public CreditCard(String name, String arithmos, float balance) {// contructor
        this.name = name;
        this.arithmos = arithmos;
        this.balance = balance;
    }

    

    public String getName() {
        return name;
    }

    public String getArithmos() {
        return arithmos;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    
    int Pay (String onoma,String arithmos_kartas,float request,List <CreditCard> bank_db) // payment function
    {
        int check=-1;
        do{ //CHECKING INFO
            
       for (int i=0;i<bank_db.size();i++)
       {
       if (onoma.equalsIgnoreCase(bank_db.get(i).getName()) && arithmos_kartas.equalsIgnoreCase(bank_db.get(i).getArithmos()))// if the username and the number are in the list
       {
           System.out.println("Correct Credit Card Information! Payment went through");  
           check=0;
       }
      
       }//end of for
        Scanner input = new Scanner(System.in);
       if (check==-1){ // if the info isnt valid
       System.out.println(" Wrong info !!! Please re-enter your credit card info !");
            System.out.print("Name :");
             onoma = input.next();
            System.out.print("Number :");
           arithmos_kartas = input.next();
       
       }
       
       
        }while (check==-1);// loop that keeps going until it is given valid info
        
    if (getBalance()-request>=0) // BALANCE CHECK 
    {
        System.out.println("Succesful Payment!");
        setBalance(getBalance()-request);
        return 1;
    
    }else
    {
        System.out.println("Payment Failed ");
        return -1;
    
    }
    
    
    }
    
    
}
