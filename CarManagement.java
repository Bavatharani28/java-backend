class Engine {
    int engineNumber;
    String engineType;
    int horsePower;

    Engine(int engineNumer, String engineType, int horsePower) {
        this.engineNumber = engineNumer;
        this.engineType = engineType;
        this.horsePower = horsePower;
    }

    public void displayEngineDetails() {
        System.out.println("Engine Number: " + engineNumber);
        System.out.println("Engine Type : " + engineType);
        System.out.println("Horse Power : " + horsePower);
    }

    public void startEngine() {
        System.out.println("Engine Starts");
    }
}

class Car {
    String carNumber;
    String carBrand;
    Engine engine;

    Car(String carNumber, String carBrand, Engine engine) {
        this.carNumber = carNumber;
        this.carBrand = carBrand;
        this.engine = engine;
    }

    public void displayCarDetails() {
        System.out.println("CarNumber : " + carNumber);
        System.out.println("Car Brand : " + carBrand);
        engine.displayEngineDetails();
    }

    public void startCar() {
        engine.startEngine();
        System.out.println("Car Starts");
    }
}

public class CarManagement {
    public static void main(String args[]) {
        Engine eng1 = new Engine(1000, "Petrol Engine", 100);
        Car car1 = new Car("TN48Q2478", "BMW", eng1);
        car1.displayCarDetails();
        eng1.displayEngineDetails();
        car1.startCar();
    }
}
