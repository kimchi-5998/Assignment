// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray



import java.util.Scanner;
// More packages may be imported in the space below
import java.io.*;
import java.util.Random;

class CustomerSystem{
    public static void main(String[] args){
        // Please do not edit any of these variables
        Scanner reader = new Scanner(System.in);
        String userInput, enterCustomerOption, generateCustomerOption, exitCondition;
        enterCustomerOption = "1";
        generateCustomerOption = "2";
        exitCondition = "9";

        // More variables for the main may be declared in the space below
        String creditCard = " ";

        do{
            printMenu();                                    // Printing out the main menu
            userInput = reader.nextLine();                  // User selection from the menu

            if (userInput.equals(enterCustomerOption)){
                // Only the line below may be editted based on the parameter list and how you design the method return
		        // Any necessary variables may be added to this if section, but nowhere else in the code
                enterCustomerInfo();
            }
            else if (userInput.equals(generateCustomerOption)) {
                // Only the line below may be editted based on the parameter list and how you design the method return
                generateCustomerDataFile("Valid List", true);
            }
            else{
                System.out.println("Please type in a valid option (A number from 1-9)");
            }

        } while (!userInput.equals(exitCondition));         // Exits once the user types 
        
        reader.close();
        System.out.println("Program Terminated");
    }
    public static void printMenu(){
        System.out.println("Customer and Sales System\n"
        .concat("1. Enter Customer Information\n")
        .concat("2. Generate Customer data file\n")
        .concat("3. Report on total Sales (Not done in this part)\n")
        .concat("4. Check for fraud in sales data (Not done in this part)\n")
        .concat("9. Quit\n")
        .concat("Enter menu option (1-9)\n")
        );
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static String enterCustomerInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("welcome new Customer");
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        System.out.println("Enter age:");
        int age = sc.nextInt();
        System.out.println("Enter gender:");
        String gender = sc.next();
        sc.nextLine();
        System.out.println("city:");
        String from = sc.nextLine();
        System.out.println("Address:");
        System.out.println("Welcome," +name+"!");
        System.out.println("Age:"+age);
        System.out.println("Gender:"+gender);
        System.out.println("City:"+from);
        return (name + ", " + age + ", " + gender + ", " + from);
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void validatePostalCode(){
    }
    /*
    * Author - Benjamin Kim
    * Description - Takes a credit card number and outputs if it is valid or not
    * 
    * @param - String creditCard
    * @return - booleanValid
    */
    public static String validateCreditCard() {
        Scanner user = new Scanner(System.in);
        System.out.println("Enter credit card number");
        String creditCard = user.nextLine();
        //Variables
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int sum;
        int oddSum = 0;
        int evenSum = 0;
        int sumDoubleDigit = 0;
        int sumSingleDigit = 0;
        boolean valid = false;

        //Counting characters
        count1 = creditCard.length() - 1;
        StringBuilder sb = new StringBuilder();

        //Reversing the numbers
        for (int i = 0; i <= count1; i++) {
            char character = creditCard.charAt(count1 - i);
            sb.append(character);
        }
        String reverseCreditCard = sb.toString();

        //count for reversed credit card number so the digits are now correctly in place
        count2 = reverseCreditCard.length() - 1;

        //Finding the odd and even values
        for (int i = 0; i <= count2; i++) {
            char digit = reverseCreditCard.charAt(i);
            int digitNum = digit - '0';

            //While loop to add all the odd digits
            while(i%2 == 0) {
                oddSum = oddSum + digitNum;
                break;
            }

            //While loop to calculate the even digits
            while(i%2 != 0) {
                int even = digitNum*2;

                //If even digit is more than 9, this happens
                if (even > 9) {   
                    count3 = String.valueOf(even).length() - 1;   //Get the length of the string
                    for (int j = 0; j <= count3; j++) {    //Getting the two characters to add them together
                        char evenDigit = String.valueOf(even).charAt(j);
                        int evenDigitNum = evenDigit - '0';    //Changing the character to a integer value so it can be added together
                        sumDoubleDigit = sumDoubleDigit + evenDigitNum; //Adding the digits to 0 to get sum of even numbers that are greater than 9 after doubling
                    }
                }
                else if (even <= 9) {    //When it does not become double digits
                    sumSingleDigit = sumSingleDigit + even;    //Adding single digits together
                }
                break;
            }
        }
        evenSum = sumDoubleDigit + sumSingleDigit;
        
        //Final Sum
        sum = oddSum + evenSum;

        //Finding if the card is valid
        if (sum%10 == 0) {  //If its ending in '0' it has to be divisible by 10 unless it is 0, but thats not possible.
            valid = true;
            return "Card is valid";
        }
        else {  //Any number not divisible by 10 doesn not end in 0.
            valid = false;
            return "Card is not valid";
        }
    }
    /*
    * Author - Benjamin Kim
    * Description - Makes a list of people with a randum id number and other info in a text file
    * 
    * @param - Text file name, Person's name, whether the postal code is valid, whether the credit card is valid,
    *  to add or replace (in this case, add)
    * @return - No return. It is a void method
    */
    public static void generateCustomerDataFile(String file, boolean addInfo){
        String customerInfo = enterCustomerInfo();
        String validCard = validateCreditCard();
        int id = newId("Valid List");
        try {   //Runs this code
            //Creating the file
            File fileName = new File(file);
            FileWriter fileWriter = new FileWriter(fileName, addInfo);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            //Text in the file
            printWriter.println(id + ", " + customerInfo + ", " + validCard);
    
            //Closing so that the lines actually print
            printWriter.close();

        } catch (IOException e) {   //If an IOException error occures, it prints this
            System.out.println("Error has occured");
        }
    }
    /*******************************************************************
    *       ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY         *
    *******************************************************************/
    public static String lastLine (String file) {
        String line;
        String lastLine = " ";
        Scanner scan = new Scanner(file);
        if (scan.hasNextLine()) {
            try {
                BufferedReader input = new BufferedReader(new FileReader(file));
                while ((line = input.readLine()) != null) {
                    if (line == " ") {
                        break;
                    }
                    lastLine = line;
                }
            } catch (IOException e) {
                System.out.println("Error has occured");
            }
        }
        else {
            return " ";
        }
        return lastLine;
    }

    public static int numLength(String line) {
        int lineLength = line.length(); //Get the length of the last line in the text file
        for (int i = 0; i <= lineLength; i++) {
            if (line.charAt(i) == ',') {
                return i - 1;
            }
        }
        return 0;
    }
    public static int getIdNumber(String line, int comma) {
        String idNumStr = line.substring(0, comma);
        int idNumber = Integer.parseInt(idNumStr); 
        return idNumber;
    }

    public static int newId(String file) {
        String lastLine = lastLine(file);
        int length = numLength(lastLine);
        int oldIdNum = getIdNumber(lastLine, length);
        int id = oldIdNum + 1;
        return id;
    }
}