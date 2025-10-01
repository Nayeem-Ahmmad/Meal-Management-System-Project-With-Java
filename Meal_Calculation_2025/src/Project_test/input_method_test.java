
package Project_test;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Scanner;


public class input_method_test {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        File folder = new File("F:/CODING/PROJECT_TEST/Project Test");
        folder.mkdir();
        String folder_path = folder.getAbsolutePath();
        
        System.out.print("How many family members : ");
        int members = input.nextInt();
        input.nextLine();
        
        DateTimeFormatter today = DateTimeFormatter.ofPattern("dd MMMM yyyy, hh:mm a");
        String time_date = LocalDateTime.now().format(today);
        
        for( int member = 1; member <= members; member++ ){
            
            System.out.print("Member name " + member + " : ");
            String name = input.nextLine();
            String file_path = folder_path + "/" + name + " Sheet.txt";
            File file = new File(file_path);
            
            try{
                
                Formatter write = new Formatter(file);
                write.format("\n\nAccount Name : %s\n\n", name );
                write.format("%-25s %-20s %-12s %-15s %-15s %-20s %-20s %-20s %-15s\n", "Date and Time","Name", "Today meal", "Total Meal", "Add Balance","Total Balance", "Today market", "Total market BL", "Comment" );
                write.format("---------------------------------------------------------------------------------------------------------------------------------------------\n");
                write.format("%-25s %-20s %-12.2f %-15.2f %-15.2f %-20.2f %-20.2f %-20.2f %-15s\n", time_date, name, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null );
                write.close();
                
            }catch( Exception e ){
                System.out.println("Find error");
                e.printStackTrace();
            }
            
        }
        
        input.close();
        
    }
}
