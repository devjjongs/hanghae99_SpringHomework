public class Bus extends Transport implements StartDriving, Boarding, ChangeSpd, ChangeStatus {
    int newPassenger;
    int noBoarding;
    int boardingPermit;

    public Bus(int transNum, int fuel, int nowSpeed, int maxPassenger, int nowPassenger, int fare, Status status) {
        super(201, 100, 0, 30, 1, 1000, status.운행중);
    }

    @Override
    public void board(int nowSpeed, int maxPassenger, int nowPassenger, Status status) {
        if (nowSpeed == 0) {
            if ((nowPassenger + newPassenger) <= 30) {
                System.out.println("승객 " + newPassenger + "명 탑승");
            } else if ((nowPassenger + newPassenger) > 30) {
                boardingPermit = 30 - nowPassenger;
                noBoarding = newPassenger - boardingPermit;
                System.out.println("승객 " + boardingPermit + " 명 탑승, " + noBoarding + "명 탑승 불가");
            } else {
                System.out.println("인원 초과, 탑승 불가");
            }
        } else if (nowSpeed > 0) {
            System.out.println("현재 속도 :" + nowSpeed + ", 탑승 불가");
        }
    }

    @Override
    public void changeSpd(int nowSpeed, Status status) {

    }

    @Override
    public void ChangeStat(int fuel, int nowPassenger, Status status) {

    }

    @Override
    public void start(int transNum, int fuel, int nowSpeed, int maxPassenger, int nowPassenger, Status status) {
        if (fuel > 10) {
            status = status.운행중;
        }
    }
}
