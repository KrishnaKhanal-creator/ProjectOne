package Project1;
import java.util.*;

public class KhanalTakeOut {
    public static Scanner input = new Scanner(System.in);

    public static int choose,trays,feeds,numberOfPeople,leftover,choiceItalian;

    public static final double taxRate = 0.07,tipRate = 0.15;

    public static double subTotal, tax, tip, grandTotal,pricePerPerson;

    public static void orderNumberOfPeople(){
        System.out.println("How many people are ordering?");
        numberOfPeople = input.nextInt();
        if(numberOfPeople < 10){
            System.out.println("Number of people are invalid ( Need at least 10!");
            System.exit(0);
        }

    }
    public static void order(){
        Scanner input = new Scanner(System.in);
        System.out.println("CHOSE TYPE OF MEAL\n" +
                "------------\n" +
                "1.Italian\n" +
                "2.Chinese\n" +
                "3.American\n" +
                "Please choose what type of food you'd like to oder: ");
        choose = input.nextInt();

        if(choose==1 ){
            displayItalianFoodMenu();
            choiceItalian = input.nextInt();
            chooseItalianMethod(choiceItalian);
        }
        else if(choose==2){
            displayChineseFoodMenu();
            int choiceChinese = input.nextInt();
            chooseChineseMethod(choiceChinese);
        }
        else if(choose==3){
            displayAmericanFoodMenu();
            int choiceAmerican = input.nextInt();
            chooseAmericanMethod(choiceAmerican);
        }
        else {
            System.out.println("Invalid input please check your choice!");
        }

    }

    public static void chooseItalianMethod(int choiceItalian){
        switch (choiceItalian){
            case 1:FoodTypeDetail lasagnaTray = new FoodTypeDetail(5,17.99);
                break;
            case 2:FoodTypeDetail pizzaPack = new FoodTypeDetail(7,15.99);
                break;
            case 3:FoodTypeDetail Gazpacho = new FoodTypeDetail(4,12.99);
                break;
            default:
                System.out.println("Invalid input!");
        }

    }
    public static void chooseChineseMethod(int choiceChinese){
        switch (choiceChinese){
            case 1:FoodTypeDetail chickenAndBroccoli = new FoodTypeDetail(7,18.99);
                break;
            case 2:FoodTypeDetail sweetAndSourPork = new FoodTypeDetail(7,18.99);
                break;
            case 3:FoodTypeDetail shrimpFriedRice = new FoodTypeDetail(5,10.99);
                break;
            default:
                System.out.println("Invalid input!");
        }

    }
    public static void chooseAmericanMethod(int choiceAmerican){
        switch (choiceAmerican){
            case 1:FoodTypeDetail hamburgerAndHotDog = new FoodTypeDetail(8,21.99);
                break;
            case 2:FoodTypeDetail sweetAndSourPork = new FoodTypeDetail(5,22.99);
                break;
            case 3:FoodTypeDetail barbequeTray = new FoodTypeDetail(10,26.99);
                break;
            default:
                System.out.println("Invalid input!");
        }

    }


    public static void displayMainMenu(){
        System.out.println("\t\t\t\t|-------------------------|");
        System.out.println("\t\t\t\t        ORDER MENU         ");
        System.out.println("\t\t\t\t    1. Italian      ");
        System.out.println("\t\t\t\t    2. Chinese      ");
        System.out.println("\t\t\t\t    3. American     ");
        System.out.println("\t\t\t\t|-------------------------|");

    }
    public static void displayItalianFoodMenu(){
        System.out.println("Choose one\n" +
                "-----------\n" +
                "1.Lasagna Tray - Feeds 5 - 17.99\n" +
                "2.Pizza Pack - Feeds 7 - 15.99\n" +
                "3.Gazpacho Soup, salad and bread sticks pack - Feeds 4 - 12.99\n" +
                "Enter choice\n" +
                "Please Enter corresponding number to your food: ");
    }
    public static void displayChineseFoodMenu(){
        System.out.println("Choose one\n" +
                "-----------\n" +
                "1. Chicken and Broccoli Tray (includes 7 wonton soups, 7 egg rolls) - feeds 7 - 18.99\n" +
                "2. Sweet and Sour Pork Tray (includes 7 hot and sour soups, 7 egg rolls) - feeds 7 - 18.99\n" +
                "3. Shrimp Fried Rice Tray (includes 10 egg rolls) - Feeds 5 - 10.99\n" +
                "Enter choice\n" +
                "Please Enter corresponding number to your food: ");
    }
    public static void displayAmericanFoodMenu() {
        System.out.println("Choose one\n" +
                "-----------\n" +
                "1. Hamburger and Hot Dog Tray - includes buns and condiments - feeds 8 - 21.99\n" +
                "2. Grilled Chicken Sandwich and Mozzarella Sticks Tray - includes dipping sauces -Feeds 5 - 22.99\n" +
                "3. Barbeque Tray - includes buns and peach cobbler - Feeds 10 - 26.99\n" +
                "Enter Choice" +
                "Please Enter corresponding number to your food:");
    }

    public static int determineTrays(int people, int feeds) {
        if ((numberOfPeople % feeds) == 0) {
            trays = feeds / people;
            return trays;

        }
            trays = (numberOfPeople / feeds) + 1;
            return trays;

    }
    public static double getSubtotal(double price, int trays){
        subTotal = price*trays;
        return subTotal;
    }
    public static double getTax(double subtotal, double taxRate){
        tax = subtotal*taxRate;
        return tax;
    }
    public static double getTip(double subtotal, double tipRate){
        tip = subtotal*tipRate;
        return tip;
    }
    public static double getGrandTotal(double subtotal, double tax, double tip){
        grandTotal = subtotal+tax+tip;
        return grandTotal;
    }
    public static double pricePerPerson(double grandTotal, int people){
        pricePerPerson = grandTotal/numberOfPeople;
        return pricePerPerson;
    }
    public static int determineLeftOvers(int feeds, int trays, int people){
        leftover = (people - (feeds * trays));
        return leftover;
    }
    public static void displayTotal(){
        System.out.println("You need " + trays + " trays");
        System.out.println("Feeds: "+ FoodTypeDetail.getFeed());
        System.out.println("Price for "+ numberOfPeople + " people (" + trays +" trays: "+ Math.round(subTotal*100.0)/100.0);
        System.out.println("Tax: "+ Math.round(tax*100.0)/100.0);
        System.out.println("Total(food,tax,tip): "+ Math.round(grandTotal*100.0)/100.0);
        System.out.println("Price per Person: "+ Math.round(pricePerPerson*100.0)/100.0);
        System.out.println("Leftover servings for delivery person:" + leftover);
    }

// --------------------main method-------------------------------------------------

    public static void main(String[] args) {
        orderNumberOfPeople();
        order();
        determineTrays(numberOfPeople,FoodTypeDetail.getFeed());
        getSubtotal(FoodTypeDetail.getAmount(),trays);
        getTax(subTotal,taxRate);
        getTip(subTotal, tipRate);
        System.out.println("Tip: "+ Math.round(tip*100.0)/100.0);
        getGrandTotal(subTotal,tax,tip);
        pricePerPerson(grandTotal,numberOfPeople);
        determineLeftOvers(feeds,trays,numberOfPeople);
        displayTotal();
    }
}
