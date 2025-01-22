public class ProfitAndLoss {
    public static void main(String[] args) {
        // Cost price and selling price
        int costPrice = 129, sellingPrice = 191;

        // Calculate profit and profit percentage
        int profit = sellingPrice - costPrice;
        double profitPercentage = (profit / (double) costPrice) * 100;

        // Print the results
        System.out.println("The Cost Price is " + costPrice + " and Selling Price is " + sellingPrice);
        System.out.println("The Profit is " + profit + " and the Profit Percentage is " + profitPercentage);
    }
}
