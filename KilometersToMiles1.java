class KilometersToMiles1 {
    public static void main(String[] args) {
	// initialize the distance variable
        double distanceInKm = 10.8;
	//initializing the miles factor

        double kmToMilesFactor = 1.6;
	//calculating the distance in miles
        double distanceInMiles = distanceInKm / kmToMilesFactor;

	//displaying the result 
        System.out.println("The distance "+ distanceInKm+" km in miles is "+distanceInMiles);
    }
}
