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
                generateCustomerDataFile();
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
    * Description - Takes a credit card number with more than 9 characters and outputs if it is valid or not
    * 
    * @param - String creditCard
    * @return - booleanValid
    */
    public static String validateCreditCard() {
        Scanner user = new Scanner(System.in);
    
        //Variables
        String creditCard = " ";    //Blank string so the string can be used outside while loop
        int count = 0;  //Count for while loop
        int count1 = 0; //Count for for loop that reverses string. Is one less than count because of how a computer counts digits
        int count2 = 0; //Count for reversed credot card. Need to count it again to use in other for loop
        int count3 = 0; //Count for even digits that equal more than 10 when doubled
        int sum;    //Overall sum of credit card after all processes are done
        int oddSum = 0; //Sum of the odd digits
        int evenSum = 0;    //Overall sum of even digits
        int sumDoubleDigit = 0; //Sum of even digits that had 2 digits after doubling
        int sumSingleDigit = 0; //Sum of even digits that had only 1 digit after doubling

        while(count < 9) {  //While loop for user to input credit card number
            System.out.println("Enter credit card number");
            creditCard = user.nextLine();   //String instead of int since int can't hold that high of a value
            count = creditCard.length();    //Count the length
            if (count >= 9) {   //If the string is more than 9 characters, its valid
                System.out.println("Number is long enough");
            }
            else {  //Anything less than 9 and it goes back to the top of the loop
                System.out.println("Number is not long enough");
            }
        }

        //Counting characters
        count1 = count - 1; //if count above is 9, the digits are going to be 0 - 8, therefore you need minus 1
        StringBuilder sb = new StringBuilder(); //String builder: Something I found on google so that I can get a variable to work with

        //Reversing the numbers
        for (int i = 0; i <= count1; i++) { //For loop to reverse number
            char character = creditCard.charAt(count1 - i); //Digits switch positions
            sb.append(character);   //String builder adds the digits each time together to form a string
        }
        String reverseCreditCard = sb.toString();   //Storing the reversed number

        //count for reversed credit card number so the digits are now correctly in place
        count2 = reverseCreditCard.length() - 1;

        //Finding the odd and even values
        for (int i = 0; i <= count2; i++) { //Separating the characters again
            char digit = reverseCreditCard.charAt(i);   //Finding each character in each digit
            int digitNum = digit - '0'; //Switching the characters to separate integers to work with

            //While loop to add all the odd digits
            while(i%2 == 0) {   //Since it counts 0 - int, the digits would shift, making even digits to the computer, odd digits to us
                oddSum = oddSum + digitNum; //Add the number to a variable each time
                break;
            }

            //While loop to calculate the even digits
            while(i%2 != 0) {   //Since it counts 0 - int, the digits would dhift, making odd digits to the computer, even digits to us
                int even = digitNum*2;  //Multipling numbers by 2

                //If even digit is more than 9, this happens
                if (even > 9) { //After doubling, the number is greater than 9, it goes through this loop
                    count3 = String.valueOf(even).length() - 1;   //Get the length of the string
                    for (int j = 0; j <= count3; j++) {    //Getting the two characters to add them together
                        char evenDigit = String.valueOf(even).charAt(j);    //Getting value of each digit
                        int evenDigitNum = evenDigit - '0';    //Changing the character to a integer value so it can be added together
                        sumDoubleDigit = sumDoubleDigit + evenDigitNum; //Adding the digits together
                    }
                }
                else if (even <= 9) {    //When it does not become double digits
                    sumSingleDigit = sumSingleDigit + even;    //Adding single digits together
                }
                break;
            }
        }
        evenSum = sumDoubleDigit + sumSingleDigit;  //Adding 2 different types of even digits together
        sum = oddSum + evenSum; //Final sum of odd and even digits

        //Finding if the card is valid
        if (sum%10 == 0) {  //If its ending in '0' it has to be divisible by 10 unless it is 0, but thats not possible.
            return "Card is valid";
        }
        else {  //Any number not divisible by 10 doesn not end in 0.
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
    public static void generateCustomerDataFile(){
        //Just in case
        Random rand = new Random(); //Random in case unique id doesn't work
        int id = rand.nextInt(1000000); //Making range very big

        //Calling other methods to add to CSV file
        String file = fileName();
        String customerInfo = enterCustomerInfo();  
        String validCard = validateCreditCard();

        //int id = newId("Valid List"); Commented this method out since it may not work but added in case Mr. Ho wants to look at it

        try {   //Runs this code
            //PrintWriter which makes files and prints lines in the file allows program to print lines
            PrintWriter printWriter = new PrintWriter(new File(file));

            //Text in the file
            printWriter.println(id + ", " + customerInfo + ", " + validCard);   //Using the methods
    
            //Closing so that the lines actually print
            printWriter.close();

        } catch (IOException e) {   //If an IOException error occures, it prints this
            System.out.println("Error has occured");
        }
    }
    /*******************************************************************
    *       ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY         *
    *******************************************************************/

    /*
     * Author - Benjamin Kim
     * Description - Allows the user the file on their own
     * 
     * @param - none
     * @return - File name as a string
     */
    public static String fileName() {
        Scanner user = new Scanner(System.in);
        System.out.println("Name your file");
        String fileName = user.nextLine();
        String file = (fileName + ".csv");
        return file;
    }
    /* 
     * The methods below are what is used to make the unique ID number. 
     * It didn't work so I put it in comments below in case Mr. Ho wants to see it
     */
    
    /*
     * Author - Benjamin Kim
     * Description - takes the last line from the CSV file, reads it , and stores it as a string
     * 
     * @param - File name
     * @return - Last Line in file
     */
    /*
    public static String lastLine (String file) {
        String line;
        String lastLine = " ";
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
        return lastLine;
    } */

    /*
     * Author - Benjamin Kim
     * Description - Takes length of last line and takes out the length of the ID number
     * 
     * @param - Last line
     * @return - Amount of digits according to a computer
     */
    /*
    public static int numLength(String line) {
        int lineLength = line.length(); //Get the length of the last line in the text file
        for (int i = 0; i <= lineLength; i++) {
            if (line.charAt(i) == ',') {
                return i - 1;
            }
        }
        return 0;
    } */

    /*
     * Author - Benjamin Kim
     * Description - Gets the actual integer value of ID number
     * 
     * @param - Last line and where the number ends
     * @return - Old Id number
     */
    /*
    public static int getIdNumber(String line, int comma) {
        String idNumStr = line.substring(0, comma);
        int idNumber = Integer.parseInt(idNumStr); 
        return idNumber;
    } */

    /*
     * Author - Benjamin Kim
     * Description - Creates new ID number
     * 
     * @param - File name
     * @return - New ID number
     */
    /*
    public static int newId(String file) {
        String lastLine = lastLine(file);
        int length = numLength(lastLine);
        int oldIdNum = getIdNumber(lastLine, length);
        int id = oldIdNum + 1;
        return id;
    } */
}