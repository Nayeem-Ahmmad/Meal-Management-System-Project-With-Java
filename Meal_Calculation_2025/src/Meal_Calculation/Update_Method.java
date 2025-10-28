// In the name of ALLAH....
package Meal_Calculation;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Formatter;

public class Update_Method {

    static class Person {

        public String date, name, comment;
        public double meal, total_meal, balance, total_balance, market_balance, total_market_balance;

        Person(String date, String name, double meal, double total_meal, double balance, double total_balance, double market_balance, double total_market_balance, String comment) {
            this.date = date;
            this.name = name;
            this.meal = meal;
            this.total_meal = total_meal;
            this.balance = balance;
            this.total_balance = total_balance;
            this.market_balance = market_balance;
            this.total_market_balance = total_market_balance;
            this.comment = comment;
        }
    }

    public static void main(String[] args) {

        Map<String, List<Person>> personList = new HashMap<>();
        // for meal / porer part holo je fill a Data update hoye thake...sekhan theke data
        // niye calculation kre..then update kore dekhe dey........................
        //String pathA = "F:/CODING/Project_with_Java/Meal_Calculation_2025/Data For Meal";
        String pathA = "F:/CODING/Project_with_Java/Meal_Calculation_2025/For Meal/Octobar_2025";
        File folder = new File(pathA);
        File[] files = folder.listFiles();
        Scanner input = new Scanner(System.in);

        if (files == null) {
            System.out.println("Folder is empty or not found.");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String date = LocalDateTime.now().format(formatter);

        for (File file : files) {
            if (!file.getName().endsWith(".txt")) {
                continue;
            }

            try {
                Scanner fileReader = new Scanner(file);
                if (fileReader.hasNextLine()) {
                    fileReader.nextLine();
                }
                if (fileReader.hasNextLine()) {
                    fileReader.nextLine();
                }
                if (fileReader.hasNextLine()) {
                    fileReader.nextLine();
                }
                if (fileReader.hasNextLine()) {
                    fileReader.nextLine();
                }
                if (fileReader.hasNextLine()) {
                    fileReader.nextLine();
                }

                while (fileReader.hasNextLine()) {
                    String line = fileReader.nextLine();
                    if (line.trim().isEmpty()) {
                        continue;
                    }

                    try {
                        String time = line.substring(0, 25).trim();
                        String name = line.substring(25, 45).trim();
                        double meal = Double.parseDouble(line.substring(45, 57).trim());
                        double total_meal = Double.parseDouble(line.substring(57, 72).trim());
                        double balance = Double.parseDouble(line.substring(72, 87).trim());
                        double total_balance = Double.parseDouble(line.substring(87, 107).trim());
                        double market_balance = Double.parseDouble(line.substring(107, 127).trim());
                        double total_market_balance = Double.parseDouble(line.substring(127, 142).trim());
                        String comment = line.substring(142).trim();

                        personList.putIfAbsent(name, new ArrayList<>());
                        personList.get(name).add(new Person(time, name, meal, total_meal, balance, total_balance, market_balance, total_market_balance, comment));
                    } catch (Exception e) {
                        System.out.println("Substring method failed for line: " + line);
                    }
                }
                fileReader.close();
            } catch (Exception e) {
                System.out.println("Error reading file: " + file.getName());
            }
        }

        int members = 0;
        
        double tkar_hisab = 0.0;

        for (String name : personList.keySet()) {

            List<Person> person_info = personList.get(name);
            members++;

            System.out.println("\nDo you want to for " + name + " ( chosses one option )");
            System.out.println("1.Just meal update.");
            System.out.println("2.Just meal and Balance update.");
            System.out.println("3.Just mean, Balance and Market update.");
            System.out.println("4.I don't Nothing\n");

            System.out.print("Your choice must be between ( 1 to 4 ) : ");
            int chose = input.nextInt();
            input.nextLine();
            System.out.print("Comment for today: ");
            String comment = input.nextLine();

            switch (chose) {
                case 1: {
                    System.out.print("Today meal for " + name + " : ");
                    double newMeal = input.nextDouble();
                    input.nextLine();

                    double lastMeal = person_info.get(person_info.size() - 1).total_meal;
                    double lastMarket_balance = person_info.get(person_info.size() - 1).total_market_balance;
                    double total_balance = person_info.get(person_info.size() - 1).total_balance;
                    double lastBalance = person_info.get(person_info.size() - 1).balance;
                    person_info.add(new Person(date, name, newMeal, newMeal + lastMeal, 0.0, total_balance, 0.0, lastMarket_balance, comment));
                    break;
                }
                case 2: {
                    System.out.print("Today meal for " + name + " : ");
                    double newMeal = input.nextDouble();
                    input.nextLine();

                    System.out.print("Add Balance for " + name + " : ");
                    double newBalance = input.nextDouble();
                    input.nextLine();

                    double lastMeal = person_info.get(person_info.size() - 1).total_meal;
                    double lastMarket_balance = person_info.get(person_info.size() - 1).total_market_balance;
                    //double lastBalance = person_info.get(person_info.size() - 1).balance;
                    double total_balance = person_info.get(person_info.size() - 1).total_balance;
                    person_info.add(new Person(date, name, newMeal, newMeal + lastMeal, newBalance, newBalance + total_balance, 0.0, lastMarket_balance, comment));
                    break;
                }
                case 3: {
                    System.out.print("Today meal for " + name + " : ");
                    double newMeal = input.nextDouble();
                    input.nextLine();

                    System.out.print("Add Balance for " + name + " : ");
                    double newBalance = input.nextDouble();
                    input.nextLine();

                    System.out.print("Add Market Balance for " + name + " : ");
                    double newMarket_balance = input.nextDouble();
                    input.nextLine();

                    double lastMeal = person_info.get(person_info.size() - 1).total_meal;
                    double lastMarket_balance = person_info.get(person_info.size() - 1).total_market_balance;
                    //double lastBalance = person_info.get(person_info.size() - 1).balance;
                    double last_total_balance = person_info.get(person_info.size() - 1).total_balance;
                    person_info.add(new Person(date, name, newMeal, newMeal + lastMeal, newBalance, newBalance + last_total_balance, newMarket_balance, newMarket_balance + lastMarket_balance, comment));
                    break;
                }
                case 4: {
                    // do nothing.............
                    double last_total_balance = person_info.get(person_info.size() - 1).total_balance;
                    double lastMeal = person_info.get(person_info.size() - 1).total_meal;
                    double lastMarket_balance = person_info.get(person_info.size() - 1).total_market_balance;
                    person_info.add(new Person(date, name, 0.0, lastMeal, 0.0, last_total_balance, 0.0, lastMarket_balance, comment));
                    break;
                }
                default: {
                    double lastMarket_balance = person_info.get(person_info.size() - 1).total_market_balance;
                    tkar_hisab += lastMarket_balance;
                    System.out.println("You chose Invalid option.");
                }
            }
        }

        double Total_meal = 0.0, totalmealB = 0.0, tMB = 0.0;

        for (List<Person> list : personList.values()) {
            for (Person p : list) {
                Total_meal += p.meal;
                totalmealB += p.balance;
                tMB += p.market_balance;
            }
        }
        
        //totalmealB = tkar_hisab;

        // new file create for final calculation....
        //String address = "F:/CODING/Meal Management System/Meal_Calculation_2025";
        String address = "F:/CODING/Project_with_Java/Meal_Calculation_2025/Total_calculation for meal";
        // New month start hole nicher line a for meal / ar pore con fill a update hoye thakbe seta bole dite hobe.........
        //...................................................................................
        String total_cal_file = "F:/CODING/Project_with_Java/Meal_Calculation_2025/Total_calculation for meal/Octobar_2025.txt";
        // every month ar total calculation korar jnno uporer last a oi month ar name diye dile hoye jabe....

        try {
            Formatter write = new Formatter(total_cal_file);
            write.format("\n\n%-25s %-20s %-20s %-20s\n", "Last Update", "Total Meal", "Total Balance", "Total Market Balance");
            write.format("-----------------------------------------------------------------------------------------\n");
            write.format("%-25s %-20.2f %-20.2f %-20.2f\n\n", date, Total_meal, totalmealB, tMB);

            double meal_rate = totalmealB / Total_meal;
            double extra = 0.0;
            double total_pay = 0.0, total_get = 0.0;

            if (totalmealB > tMB) {
                extra = totalmealB - tMB;
            }
            double baki = extra;

            if (extra > 0) {
                extra /= members;
            }

            write.format("\n\n                         STATEMENT FOR ALL MEMEBERS\n\n");
            write.format("Meal rate : %.2f\n", meal_rate);
            write.format("Extra : %.2f\n\n", baki);
            //write.format("%-20s %-10s %-10s %-13s %-12s %-10s %-10s\n", "Person", "Meal", "Balance", "Meal Balance", "Extra gain", "Get Money", "Pay Money");
            write.format("%-20s %-10s %-10s %-13s %-20s\n", "Person", "Meal", "Balance", "Meal Cost(BDT)", "Pay(-) or Gate(+)");
            write.format("-----------------------------------------------------------------------------------------\n");

            for (String name : personList.keySet()) {
                List<Person> person_info = personList.get(name);
                double balance = person_info.get(person_info.size() - 1).total_balance;
                double meal = person_info.get(person_info.size() - 1).total_meal;
                
                double k = meal_rate * meal;
                double gate_pay = balance - k;
                
                write.format("%-20s %-10.2f %-10.2f %-13.2f %-20.2f\n", name, meal, balance, k, gate_pay );

//                if (balance == (meal_rate * meal)) {
//                    write.format("The GOLDEN person is %s \n", name);
//                } else if (balance > (meal_rate * meal)) {
//                    double take_money = balance - (meal_rate * meal);
//                    total_get += take_money;
//                    write.format("%-20s %-10.2f %-10.2f %-13.2f %-12.2f %-10.2f %-10.2f\n", name, meal, balance, meal_rate * meal, extra, take_money + extra, 0.0);
//                } else {
//                    double pay_money = (meal_rate * meal) - balance;
//                    double check = pay_money - extra;
//                    total_pay += pay_money;
//
//                    if (check < 0) {
//                        check *= -1; // extra gain
//                        write.format("%-20s %-10.2f %-10.2f %-13.2f %-12.2f %-10.2f %-10.2f\n", name, meal, balance, meal_rate * meal, extra, check, 0.0);
//                    } else {
//                        write.format("%-20s %-10.2f %-10.2f %-13.2f %-12.2f %-10.2f %-10.2f\n", name, meal, balance, meal_rate * meal, extra, 0.0, check);
//                    }
//
//                }
            }

            write.format("\nGet money is %.2f BDT and Pay money is %.2f BDT\n", total_get, total_pay);
            double dif = total_get - total_pay;
            if (dif < 0) {
                dif *= -1;
            }
            write.format("Difference between Get and Pay money is : %.2f\n", dif);

            write.close();
        } catch (Exception e) {
            System.out.println("Error..");
            e.printStackTrace();
        }

        //updated file overwrite on files....
        for (Map.Entry<String, List<Person>> all_info : personList.entrySet()) {
            String name = all_info.getKey();
            List<Person> mealList = all_info.getValue();
            String path = pathA + "/" + name + " Sheet.txt";

            try {
                Formatter write = new Formatter(path);
                write.format("\n\nAccount Name : %s\n", name);
                write.format("%-25s %-20s %-12s %-15s %-15s %-20s %-20s %-20s %-15s\n", "Date", "Name", "Meal", "Total_Meal", "Balance", "Total Balance", "Market_Balance", "Total_market_balance", "Comment");
                write.format("-------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                for (Person p : mealList) {
                    write.format("%-25s %-20s %-12.2f %-15.2f %-15.2f %-20.2f %-20.2f %-20.2f %-15s\n", p.date, p.name, p.meal, p.total_meal, p.balance, p.total_balance, p.market_balance, p.total_market_balance, p.comment);
                }
                write.close();
            } catch (Exception e) {
                System.out.println("Erro...");
                e.printStackTrace();
            }
        }
        input.close();
        System.out.println("\nAll files updated successfully.");
    }
}
