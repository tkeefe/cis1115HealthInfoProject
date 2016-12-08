
package myproject;

import java.util.Scanner;
import utilities.Prompt;

/**
 *
 * @author TravisKeefe
 */
public class HealthInfoAppMenu {
    Scanner in = new Scanner(System.in);
    DAOHealthInfo data = new DAOHealthInfo();
    
    public HealthInfoAppMenu(){
        menuLoop();
    }
    
    private void menuLoop(){
        int choice = 1;
        int id;
        String name;
        String address;
        String InsurancePolicy;
        int age;
        
        while(choice != 0){
            System.out.println("\nHealthInfo App");
            System.out.println("0 = Quit");
            System.out.println("1 = Retrieve All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Single Record");
            System.out.println("4 = Update");
            System.out.println("5 = Delete");
            System.out.println("6 = Retrieve All: Order by Id");
            System.out.println("7 = Retrieve All: Order by Name");
            System.out.println("8 = Retrieve All: Order by Age");
            System.out.println("9 = Retrieve All: Order by Address");
            System.out.println("10 = Retrieve All: Order by InsurancePolicy");
            System.out.println("11 = Retrieve All: Order by Name / Age Descending");
            System.out.println("12 = Retrieve All: Order by Name / Age Ascending");
            System.out.println("13 = Retrieve All: Statistics");
            
            choice = Prompt.getInt("Number of choices: ", 0, 13);
            
            if(choice == 1){
                System.out.println(data.toString());
            }else if(choice == 2){
                id = Prompt.getInt("Enter id: ");
                name = Prompt.getLine("Enter name: ");
                age = Prompt.getInt("Enter age: ");
                address = Prompt.getLine("Enter address: ");
                InsurancePolicy = Prompt.getLine("Enter Insurance Policy: ");
                HealthInfo he = new HealthInfo(id, name, age, address, InsurancePolicy);
                data.create(he);
            }else if(choice == 3){
                id = Prompt.getInt("Enter id: ");
                System.out.println(data.retrieve(id));
            }else if(choice == 4){
                ;
            }else if(choice == 5){
                id = Prompt.getInt("Enter id: ");
                data.delete(id);
            }else if(choice == 6){
                System.out.println(data.orderById());
            }else if(choice == 7){
                System.out.println(data.orderByName());
            }else if(choice == 8){
                System.out.println(data.orderByAge());
            }else if(choice == 9){
                System.out.println(data.orderByAddress());
            }else if(choice == 10){
                System.out.println(data.orderByInsurancePolicy()); 
            }else if(choice == 11){
                System.out.println(data.orderByNameAgeD());
            }else if(choice == 12){
                System.out.println(data.orderByNameAgeA());
            }else if(choice == 13){
                data.Statistics();
            }else if(choice == 0){
                ;
            }
            
        }
    }
    
    public static void main(String[] args) {
        new HealthInfoAppMenu();
    }
}
