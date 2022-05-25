package transportation;

import java.util.UUID;
public abstract class Transportation {

    private final String number = UUID.randomUUID().toString(); // 번호

    private int fuel = 100; // 주유량

    private final int basicFee; // 기본 요금

    private int currentSpeed; // 속도

    private int currentPassenger; // 현재 승객

    private final int maxPassenger; // 최대 승객수

    private Status status; //상태

    private int earnedMoney; // 누적 요금


    public Transportation(int basicFee, int maxPassenger, Status status) {
        this.basicFee = basicFee;
        this.maxPassenger = maxPassenger;
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public int getFuel() {
        return fuel;
    }

    public void printFuel() {
        System.out.println("주유량 = " + this.fuel);
    }

    public void printNeedFuel() {
        System.out.println("!!!!! 주유가 필요합니다 !!!!!");
    }

    public Status getStatus() {
        return status;
    }

    public void printStatus() {
        System.out.println("상태 = " + this.status);
    }

    public int getBasicFee() {
        return basicFee;
    }

    public int getCurrentPassenger() {
        return currentPassenger;
    }

    public int getRemainPassenger() {
        return this.maxPassenger - this.currentPassenger;
    }

    public void addPassenger(int newPassenger) {
        if (this.currentPassenger + newPassenger > maxPassenger ) {
            System.out.println("!!!!! 최대 승객 수 초과 !!!!!");
        } else {
            this.currentPassenger += newPassenger;
        }
    }

    public void changeStatus(Status status) {
        this.status = status;
    }

    public void changeSpeed(int targetSpeed) {
        while (this.currentSpeed != targetSpeed) {
            if (targetSpeed > this.currentSpeed) {
                this.currentSpeed++;
            }
            if (targetSpeed < this.currentSpeed) {
                this.currentSpeed--;
            }
        }
    }

    public void changeFuel(int fuel) {
        this.fuel += fuel;
    }

    public void deletePassenger() {
        this.currentPassenger = 0;
    }

    public void addMoney(int money) {
        this.earnedMoney += money;
    }

    public int getEarnedMoney() {
        return earnedMoney;
    }

    public void printEarnedMoney() {
        System.out.println("누적 요금 = " + this.earnedMoney);
    }
    abstract void checkNeedFuel();

    abstract int getCalculatedFee();

    abstract void printBasicValue();
}
