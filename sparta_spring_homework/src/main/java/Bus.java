public class Bus extends Transport implements StartDriving,Boarding,ChangeSpd,ChangeStatus{

    public Bus(int transNum, int fuel, int nowSpeed, int maxPassenger, int nowPassenger, int fare, String status) {
        super(transNum, fuel, 0, 45, 1, 100, status);
    }

    @Override
    public void board(int nowSpeed, int maxPassenger, int nowPassenger, String status) {

    }

    @Override
    public void changeSpd(int nowSpeed, String status) {

    }

    @Override
    public void ChangeStat(int fuel, int nowPassenger, String status) {

    }

    @Override
    public void start(int transNum, int fuel, int nowSpeed, int maxPassenger, int nowPassenger, String status) {

    }
}
