package transportation;

public class Bus extends Transportation {

    public Bus(int fee, int maxPassenger, Status status) {
        super(fee, maxPassenger, status);
    }

    @Override
    public void checkNeedFuel() {
        if (getFuel() < 10) {
            changeStatus(Status.차고지행);
            printStatus();
            printNeedFuel();
        }
    };

    @Override
    public void printBasicValue() {
        System.out.println("탑승 승객 수 = " + getCurrentPassenger());
        System.out.println("잔여 승객 수 = " + getRemainPassenger());
        System.out.println("요금 확인 = " + getCalculatedFee());
    }

    @Override
    public int getCalculatedFee() { // 탑승 손님의 요금 확인
        return getCurrentPassenger() * getBasicFee();
    }

}