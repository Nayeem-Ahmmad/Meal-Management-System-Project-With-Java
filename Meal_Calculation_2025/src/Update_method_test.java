
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Scanner;


// In the name of Allah...

public class Update_method_test {
    
    static class Person{
        String name, date, comment;
        double today_meal, total_meal, addBL, totalBL, today_marketBL, total_marketBL;
        Person( String date, String name, double today_meal, double total_meal, double addBL, double totalBL, double today_marketBL, double total_marketBL, String comment ){
            this.name = name;
            this.date = date;
            this.today_meal = today_meal;
            this.total_meal = total_meal;
            this.addBL = addBL;
            this.totalBL = totalBL;
            this.today_marketBL = today_marketBL;
            this.total_marketBL = total_marketBL;
            this.comment = comment;
        }
    }
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Map<String, List<Person>> members_info = new HashMap<>();
        // je folder theke files gula READ korbo....tar address
        String file_path = "F:/CODING/PROJECT_TEST/Project Test";
        File folder = new File(file_path);    // je file theke READ korbo sei folder ar akta object create..
        File[] files = folder.listFiles(); // folder thele all files array hisebe represented...
        
        if( files == null ){
            System.out.println("Folder is Empty");
            return;
        }
        
        // for time...
        DateTimeFormatter today = DateTimeFormatter.ofPattern("dd MMMM yyyy, hh:mm a");
        String date_time = LocalDateTime.now().format(today);
        
        for( File file : files ){
            
            if( !file.getName().endsWith(".txt") ) continue;
            
            try{
                
                Scanner fileReader = new Scanner(file);
                for( int i = 1; i <= 6; i++ ){
                    if( fileReader.hasNextLine() ) fileReader.nextLine();
                }
                
                // READ file and shift date to HashMap,,,,,
                while( fileReader.hasNextLine() ){
                    
                    String line = fileReader.nextLine();
                    if( line.trim().isEmpty() ) continue;
                    
                    try{
                        
                        String date = line.substring(0, 25).trim(); //25
                        String name = line.substring(25, 45).trim(); // 20
                        double today_meal = Double.parseDouble(line.substring(45, 57).trim()); // 12
                        double total_meal = Double.parseDouble(line.substring(57, 72).trim()); // 15
                        double addBL = Double.parseDouble(line.substring(72, 87).trim()); // 15
                        double totalBL = Double.parseDouble(line.substring(87, 107).trim()); // 20 
                        double today_marketBL = Double.parseDouble(line.substring(107, 127).trim()); // 20
                        double total_marketBL = Double.parseDouble(line.substring(127, 147).trim()); // 20
                        String comment = line.substring(147).trim(); // 15
                        members_info.putIfAbsent(name, new ArrayList<>());
                        members_info.get(name).add(new Person(date, name, today_meal, total_meal, addBL, totalBL, today_marketBL, total_marketBL, comment) );
                        
                    }catch( Exception e ){
                        System.out.println("Substring method failed for line : " + line );
                    }
                }
                fileReader.close();
            }catch( Exception e ){
                System.out.println("Error Reading file : " + file.getName() );
                e.printStackTrace();
            }
        }// successfully data transfer file to hashmap......
        
        
        
        // Case 2 : update for today......
        
        
        
        input.close();
        
    }
    
}
