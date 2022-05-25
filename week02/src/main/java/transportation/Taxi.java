package transportation;

public class Taxi extends Transportation{

    private Destination destination;

    private int basicDistance = 1;

    private int farePerDistance;

    public Taxi(int fee, int maxPassenger, Status status, Destination destination, int farePerDistance) {
        super(fee, maxPassenger, status);
        this.destination = destination;
        this.farePerDistance = farePerDistance;
    }

    public Destination getDestination() {
        return destination;
    }

    @Override
    public void checkNeedFuel() {
        if (getFuel() < 10) {
            changeStatus(Status.운행불가);
            printStatus();
            printNeedFuel();
        }
    };

    @Override
    public int getCalculatedFee() {
        return getBasicFee() + (getExtraDistance()) * this.farePerDistance;
    }

    public int getExtraDistance() {
        return Math.max(destination.getDistance() - basicDistance, 0);
    }

    @Override
    public void printBasicValue() {
        System.out.println("탑승 승객수 = " + getCurrentPassenger());
        System.out.println("잔여 승객수 = " + getRemainPassenger());
        System.out.println("기본 요금 확인 = " + getBasicFee());
        System.out.println("목적지 = " + getDestination().getPlace());
        System.out.println("목적지까지 거리 = " + getDestination().getDistance());
        System.out.println("지불할 요금 = " + getCalculatedFee());
        System.out.println("상태 = " + getStatus());
    }

    public void deleteDestination() {
        destination = null;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
