import transportation.Bus;
import transportation.Destination;
import transportation.Status;
import transportation.Taxi;

public class Main {

    public static void main(String[] args) {
        // Bus 2대 생성, 차량번호 비교
        Bus bus = new Bus(1000, 30, Status.운행중);
        Bus sampleBus= new Bus(1000, 30, Status.운행중);
        compareNumber(bus.getNumber(), sampleBus.getNumber());

        // 승객 탑승
        bus.addPassenger(2);
        bus.addMoney(bus.getCalculatedFee());
        // 출력 Bus
        bus.printBasicValue();

        bus.changeFuel(-50);
        bus.printFuel();
        // 주유량 체크
        bus.checkNeedFuel();

        // 버스 상태 변경
        bus.changeStatus(Status.차고지행);
        bus.deletePassenger(); // 차고지 행으로 모든 승객 하차

        bus.changeFuel(10);

        // 출력
        bus.printStatus();
        bus.printFuel();

        bus.changeStatus(Status.운행중);

        bus.addPassenger(45); // 경고

        bus.addPassenger(5);
        bus.addMoney(bus.getCalculatedFee());
        bus.printBasicValue();
        bus.printEarnedMoney();

        bus.changeFuel(-55);
        bus.printFuel();
        bus.checkNeedFuel(); // 경고

        System.out.println("\n---------------------------------------\n");

        Taxi taxi = new Taxi(3000, 4, Status.일반, new Destination("서울역", 2), 1000);
        Taxi sampleTaxi = new Taxi(3000, 4, Status.일반, new Destination("sample",0), 0);

        compareNumber(taxi.getNumber(), sampleTaxi.getNumber());
        taxi.printFuel();
        taxi.printStatus();

        taxi.changeStatus(Status.운행중);
        taxi.addPassenger(2);
        taxi.printBasicValue();

        // 목적지 도착
        taxi.changeFuel(-80);
        taxi.checkNeedFuel();
        // 요금 결제
        taxi.addMoney(taxi.getCalculatedFee());
        taxi.deletePassenger();
        taxi.deleteDestination();

        taxi.printFuel();
        taxi.printEarnedMoney();

        taxi.addPassenger(5); // 경고

        taxi.addPassenger(3);
        taxi.setDestination(new Destination("구로디지털단지역", 12));
        taxi.printBasicValue();

        // 목적지 도착
        taxi.changeFuel(-20);
        taxi.printFuel();
        taxi.checkNeedFuel(); // 경고
        // 요금 결제
        taxi.addMoney(taxi.getCalculatedFee());
        taxi.deletePassenger();
        taxi.deleteDestination();
        taxi.printEarnedMoney();
    }

    private static void compareNumber(String number1, String number2) {
        if (number1.equals(number2)) {
            throw new RuntimeException("차량 번호가 서로 같습니다");
        }
        System.out.println("========= 차량번호 비교 =========");
        System.out.println(number1);
        System.out.println(number2);
        System.out.println("========= 차량번호 비교 끝=========");
    }
}
