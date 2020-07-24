//File Functions Class
import java.io.*;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class FileEditor {

    private Formatter x; // for printing
    private Scanner z; // for reading 

    public void openFile() {
        try {
            x = new Formatter("arxeio_kratiseon.txt"); // creates the file 
        } catch (FileNotFoundException e)// if there's ANY issue finding the file
        {
            System.out.println("Couldnt open the file !");
        }
    }//telos openFile

    public void addKratiseis(List<Kratisi> kratisi_list) {//Saving bookings from the list to the file 

        for (int i = 0; i < kratisi_list.size(); i++) {
            x.format(kratisi_list.get(i).toString()); // saves all the bookings to a file
        }
    }

    public void closeFile() {
        x.close();
    }
    
    public void readKratiseis(List<Kratisi> kratisi_list)//reads all the bookings and turns them into a list 
    {
        while (z.hasNext()){ // DIDNT FINISH THIS 
            String grammi=z.next();
            //LINE SPLITTING NEEDED HERE
       //     kratisi_list.add(grammi); 
    
        }
    }

}//telos FileEditor
