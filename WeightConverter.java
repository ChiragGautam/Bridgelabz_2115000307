class WeightConverter {
    public static void main(String[] args) {
        double weightInPounds = 150; // Example weight in pounds
        double conversionFactor = 2.2; // 1 pound = 2.2 kg
        double weightInKilograms = weightInPounds / conversionFactor; // Convert to kg
        System.out.println("The weight of the person in pounds is " + weightInPounds + " and in kilograms is " + weightInKilograms);
    }
}
