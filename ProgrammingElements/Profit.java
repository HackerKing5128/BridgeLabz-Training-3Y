class Profit {
    public static void main(String[] args) {
        double costPrice = 129;
        double sellPrice = 191;

        double profit = sellPrice - costPrice;
        double profitPercentage = (profit / costPrice) * 100.0;

        System.out.println("The Cost Price is INR " + costPrice + " and Selling Price is INR " + sellPrice + "\nThe Profit is INR " + profit + "and the Profit Percentage is " + (float)profitPercentage + "%");

    }
}
