public class Transport {
    //- 번호
    int transNum;
    //- 주유량
    int fuel;
    //- 속도
    int nowSpeed;
    //- 최대 승객 수
    int maxPassenger;
    //- 현재 승객
    int nowPassenger;
    //- 운행 상태
    String status;
    // 기본요금
    int fare;


    public Transport(int transNum, int fuel, int nowSpeed, int maxPassenger, int nowPassenger, int fare, String status) {
        this.transNum = transNum;
        this.fuel = fuel;
        this.nowSpeed = nowSpeed;
        this.maxPassenger = maxPassenger;
        this.nowPassenger = nowPassenger;
        this.fare = fare;
        this.status = status;
    }

    public Transport(int transNum, int fuel, int nowSpeed, int nowPassenger, int fare, String status) {
        this(0, 100, 0, 0,  0, 0, "운행중");
    }

}


