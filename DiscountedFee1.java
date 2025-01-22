class DiscountedFee1 {
    public static void main(String[] args) {
        //initialize the fee variable
	int fee = 125000;
	//initialize the discount Percent
        int discountPercent = 10;
	//calculating the discount
        int discount = (fee * discountPercent) / 100;
	//calculating the discountedFee
        int discountedFee = fee - discount;

	//displaying the final result
        System.out.println("The discount amount is " + discount + " and final discounted fee is " + discountedFee);
    }
}
