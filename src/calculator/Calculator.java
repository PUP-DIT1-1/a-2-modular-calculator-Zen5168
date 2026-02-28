package calculator;
import java.util.*;
public class Calculator {
    
    // VARIABLES
    static Scanner sc = new Scanner(System.in);
    static boolean isRunning = true;
    static int choice;
    
    // INPUT VALIDATION (DOUBLE)
    static double getDoubleInput(){
        while(true){
            try{
            double input = sc.nextDouble();
            sc.nextLine();
            return input;
            
            }
            catch (InputMismatchException e) {
            String badInput = sc.nextLine();
            System.out.println("-------------------------------------------------------");
            System.out.println(badInput + " is not a number!");
            System.out.println("Please Try Again!");
            System.out.print("> "); 
        }   
    }
  }
     // INPUT VALIDATION (INT)
        static int getIntInput(){
        while(true){
            try{
            int input = sc.nextInt();
            sc.nextLine();
            return input;
            
            }
            catch (InputMismatchException e) {
            String badInput = sc.nextLine();
            System.out.println("-------------------------------------------------------");
            System.out.println(badInput + " is not a number!");
            System.out.println("Please Try Again!");
            System.out.println("-------------------------------------------------------");
            System.out.println("""
                               0. Modulus
                               1. Add 
                               2. Subtract 
                               3. Multiply 
                               4. Divide 
                               5. Exit
                               """);
            System.out.print("Choose an option: ");    
        }   
    }
  }
        
     // INPUT VALIDATION (UseAgain)
        static int UA(){
        while(true){
            try{
            int input = sc.nextInt();
            sc.nextLine();
            return input;
            
            }
            catch (InputMismatchException e) {
            String badInput = sc.nextLine();
            System.out.println("-------------------------------------------------------");
            System.out.println(badInput + " is not a number!");
            System.out.println("Please Try Again!");
            System.out.println("-------------------------------------------------------");
            System.out.println("Do you want to use Calculator ni Jex again?");
            System.out.println("""
                           1. yes
                           2. No """);
        System.out.print("Enter your choice: ");   
        }   
    }
  }
        
     // MAIN   
    public static void main (String[] args){
        
        calculator();
        
      }   
    
    // USE AGAIN
    static void useAgain(){
        int useAgain;
        do{
        System.out.println("Do you want to use Calculator ni Jex again?");
        System.out.println("""
                           1. yes
                           2. No """);
        System.out.print("Enter your choice: ");
        useAgain = UA();
        
        switch (useAgain){
            case 1: calculator();
                        break;
            case 2: System.out.println("Goodbye");
                        isRunning = false;
                        break;
            default: System.out.println("Invalid option!");
           }
        }
     while(useAgain != 1 && useAgain !=2);
}
    
    //  CALCULATOR
    static void calculator(){
        double result = 0;
        boolean validOperation = true;

        while (isRunning) {
            System.out.println("--- Calculator ni Jex ---");
            System.out.println("""
                               0. Modulus
                               1. Addition
                               2. Subtraction 
                               3. Multiplication
                               4. Division
                               5. Exit
                               """);
            System.out.print("Choose an option (0-5): ");    
            choice = getIntInput();
            
            if (choice != 0 && choice != 1 && choice !=2 && choice != 3 && choice != 4 && choice != 5) {
                System.out.println("Invalid choice");
            }
            
            else if(choice == 5){
                System.out.println("Goodbye!");
                isRunning = false;
                break;
            }
            
            else {
                switch(choice){
                    case 0: System.out.println("You chose Modulus");
                                break;
                    case 1: System.out.println("You chose Addition");                
                                break;
                    case 2: System.out.println("You chose Subtraction");                    
                                break;
                    case 3: System.out.println("You chose Multiplication");               
                                break;
                    case 4: System.out.println("You chose Division!");                
                                break;

                }
                
            System.out.print("Enter first number: ");
            double num1 = getDoubleInput();
            System.out.print("Enter second number: ");
            double num2 = getDoubleInput();

            switch (choice) {
                case 0: result = modulus(num1,num2);
                            break;
                case 1: result = add(num1, num2);
                            break;
                case 2:result = subtract(num1, num2);
                            break;
                case 3: result = multiply(num1, num2); 
                            break;
                case 4: 
                           if (num2 != 0) {
                               result = divide(num1, num2);
                          } 
                         
                           else {
                            System.out.println("Error: Cannot divide by zero.");
                               validOperation = false;
                    }
                           break;
            }

            if (validOperation) {
                System.out.println("The result is: " + result);
                useAgain();
            }
        }
      }
        sc.close();
    }

    public static double modulus(double a, double b) {
        return a % b;
    }
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }
}
