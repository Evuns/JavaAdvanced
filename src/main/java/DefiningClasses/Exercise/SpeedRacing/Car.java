package DefiningClasses.Exercise.SpeedRacing;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCostPerKilo;
    private int kilometers = 0;

    public Car(String model, double fuelAmount, double fuelCostPerKilo){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKilo = fuelCostPerKilo;
    }

    public double getFuelAmount(){
        return this.fuelAmount;
    }

    public int getKilometers(){
        return  this.kilometers;
    }

    public double getFuelCostPerKilo(){
        return  this.fuelCostPerKilo;
    }

    public void setFuelAmount(double fuelAmountNeeded) {
        this.fuelAmount -= fuelAmountNeeded;
    }

    public void setKilometers(int traveledKilometers){
        this.kilometers += traveledKilometers;
    }

    public boolean canTraveled(int distance){
        double maxKilo = this.fuelAmount / this.fuelCostPerKilo;
        if(maxKilo >= distance){
            return true;
        } else{
            return  false;
        }
    }

    public String getModel(){
        return this.model;
    }
}
