public class VolumeOfEarth {
    public static void main(String[] args) {
        // Radius of Earth in kilometers and miles
        double radiusKm = 6378;
        double radiusMiles = radiusKm / 1.6;

        double volumeKm3 = (4.0 / 3) * Math.PI * Math.pow(radiusKm, 3);
        double volumeMiles3 = (4.0 / 3) * Math.PI * Math.pow(radiusMiles, 3);

        // Print the volume in both units
        System.out.println("The volume of earth in cubic kilometers is " + volumeKm3 + " and cubic miles is " + volumeMiles3);
    }
}
