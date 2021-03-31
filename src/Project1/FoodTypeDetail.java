package Project1;

public class FoodTypeDetail {

    private static int feed;
    private static double amount;

    public FoodTypeDetail() {
    }

    public FoodTypeDetail( int feed, double amount) {
        this.feed = feed;
        this.amount = amount;
    }


    public static int getFeed() {

        return feed;
    }

    public static double getAmount() {

        return amount;
    }

}