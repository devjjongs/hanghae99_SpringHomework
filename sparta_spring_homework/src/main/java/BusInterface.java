public interface BusInterface {
    void driving(int maxPassenger, int nowPassenger, int fare, int busNum, int fuel, int nowSpeed, String status);

    void changeStatus(int fuel, String status);

    void boardingPassengers(int maxPassenger, int nowPassenger, Status status);

    void changeSpeed(int fuel, int nowSpeed);
}
