package transportation;

public class Destination {
    private String place;

    private int distance;

    public Destination(String place, int distance) {
        this.place = place;
        this.distance = distance;
    }

    public String getPlace() {
        return place;
    }

    public int getDistance() {
        return distance;
    }
}
