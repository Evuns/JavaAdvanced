package DefiningClasses.Exercise.RawData;

import java.util.Arrays;
import java.util.Collections;

public class Tires {

    private double firstPressure;
    private int firstAge;
    private double secondPressure;
    private int secondAge;
    private double thirdPressure;
    private int thirdAge;
    private double fourthPressure;
    private int fourthAge;

    public Tires(double firstPressure, int firstAge,
             double secondPressure,   int secondAge,
             double thirdPressure,    int thirdAge,
             double fourthPressure,   int fourthAge){
        this.firstPressure = firstPressure;
        this.firstAge = firstAge;
        this.secondPressure = secondPressure;
        this.secondAge = secondAge;
        this.thirdPressure = thirdPressure;
        this.thirdAge = thirdAge;
        this.fourthPressure = fourthPressure;
        this.fourthAge = fourthAge;
    }
    public boolean isPrintable(Tires tires){
        if(Collections.min(Arrays.asList(this.firstPressure, this.secondPressure, this.thirdPressure, this.fourthPressure)) > 1){
            return false;
        } else {
            return true;
        }
    }

    public double getFirstPressure(){
        return this.firstPressure;
    }

    public double getSecondPressure(){
        return this.secondPressure;
    }

    public double getThirdPressure(){
        return this.thirdPressure;
    }

    public double getFourthPressure(){
        return this.fourthPressure;
    }
}
