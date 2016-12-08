
package utilities;

import java.util.Scanner;

/**
 *
 * @author TravisKeefe
 */
public class Prompt {
    public static int getInt(String prompt){
        Scanner in = new Scanner(System.in);
        boolean isValid = false;
        int i = 0;
        while(isValid == false){
            System.out.print(prompt);
            if(in.hasNextInt()){
                i = in.nextInt();
                isValid = true;
            }else{
                System.out.println("\nError! Invalid integer value. Try again.");
        }
            in.nextLine();
    }
        return i;
    }
    
    public static int getInt(String prompt, int min, int max){
        boolean isValid = false;
        int i = 0;
        while(isValid == false){
            i = getInt(prompt);
            if(i<min){
                System.out.println("\nError! Must be greater than or equal to " + min);
            }else if(i>max){
                System.out.println("\nError! Must be less than or equal to " + max);
            }else{
                isValid = true;
            }
        }
          return i;      
    }
    
    public static double getDouble(String prompt){
        Scanner in = new Scanner(System.in);
        boolean isValid = false;
        double i = 0;
        while(!isValid){
            System.out.print(prompt);
            if(in.hasNextDouble()){
                i = in.nextDouble();
                isValid = true;
            }else{
                System.out.println("\nError! Invalid double value. Try again!");
            }
            in.nextLine();
        }
        return i;
    }
    
    public static String getLine(String prompt){
        Scanner in = new Scanner(System.in);
        System.out.print(prompt);
        return in.nextLine();
    }
}
