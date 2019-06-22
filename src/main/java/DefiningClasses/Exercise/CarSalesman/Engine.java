package DefiningClasses.Exercise.CarSalesman;

public class Engine {

    private String model;
    private String power;
    private String displacement = "n/a";
    private String efficiency = "n/a";

    public Engine(String model, String power){
        this.model = model;
        this.power = power;
    }

    public void setDisplacement(String displacement){
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency){
        this.efficiency = efficiency;
    }

    public String getModel(){
        return this.model;
    }

    public String getPower(){
        return this.power;
    }

    public String getDisplacement(){
        return this.displacement;
    }

    public String getEfficiency(){
        return  this.efficiency;
    }
}
