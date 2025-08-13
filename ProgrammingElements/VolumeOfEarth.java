class VolumeOfEarth {
    public static double volume(double radius) {
        return ((double) 4 / 3) * Math.PI * Math.pow(radius, 3);
    }

    public static void main(String[] args) {
        double radius = 6378;  // In Kilometers

        double volumeInCubicKilo = volume(radius);
        double volumeInCubicMiles = volumeInCubicKilo * 1.6;

        System.out.println("The volume of earth in cubic kilometers is " + (float)volumeInCubicKilo + " and cubic miles is " + (float)volumeInCubicMiles);

    }
}