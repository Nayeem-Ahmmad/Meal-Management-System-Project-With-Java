


// In the name of ALLAH....
package Meal_Calculation;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Scanner;

public class Meal_Input_method {
    
    public static void main(String[] args) {
        
        File meal_data = new File("F:/CODING/Meal Management System/Meal_Calculation_2025/For Meal/Octobar_2025");
        meal_data.mkdir();
        String path_meal_data = meal_data.getAbsolutePath();
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("How many Number for your Family : ");
        int member = input.nextInt();
        input.nextLine();
        
        // create each person file list...
        
        for( int i = 1; i <= member; i++ ){
            
            DateTimeFormatter today = DateTimeFormatter.ofPattern("dd MMMM yyyy hh:mm a");
            String time = LocalDateTime.now().format(today);
            
            System.out.print("Enter Family Member Name : ");
            String name = input.nextLine();
            String file_address = path_meal_data + "/" + name + " Sheet.txt";
            File file = new File(file_address);
            
            try{
                
                Formatter write = new Formatter(file);
                //write.format("Information for : %-20s\n", name);
                write.format("\n\nAccount Name : %s\n", name );
                write.format("%-25s %-20s %-12s %-15s %-15s %-20s %-20s %-20s %-15s\n", "Date", "Name", "Meal", "Total_Meal", "Balance","Total Balance", "Market_Balance", "Total_market_balance", "Comment" );
                write.format("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                write.format("%-25s %-20s %-12.2f %-15.2f %-15.2f %-20.2f %-20.2f %-20.2f %-15s\n", time, name, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null );
                write.close();
                
            }catch( Exception e ){
                System.out.println("Error : " + e );
                e.printStackTrace();
            }
            
        }
        
        input.close();
        
    }
}