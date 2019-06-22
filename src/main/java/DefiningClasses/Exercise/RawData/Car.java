package DefiningClasses.Exercise.RawData;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tires tires;

    public Car(String model, Engine engine, Cargo cargo, Tires tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Tires getTires(){
        return this.tires;
    }

    public String getModel(){
        return this.model;
    }

    public Engine getEngine(){
        return this.engine;
    }
}
