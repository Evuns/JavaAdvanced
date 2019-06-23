package EXAM.spaceStationRecruitment;

import java.util.Comparator;
import java.util.LinkedHashMap;

public class SpaceStation {
    private String name;
    private int capacity;
    private LinkedHashMap<String, Astronaut> data;

    public SpaceStation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return data.size();
    }

    public void add(Astronaut astronaut) {
        if (data.size() < capacity) {
            this.data.put(astronaut.getName().toLowerCase(), astronaut);
        }
    }

    public boolean remove(String name) {
        if (this.data.containsKey(name.toLowerCase())) {
            this.data.remove(name.toLowerCase());
            return true;
        }
        return false;
    }

    public Astronaut getOldestAstronaut() {
        return data.values()
                .stream()
                .max(Comparator.comparingInt(Astronaut::getAge))
                .orElse(null);
    }

    public Astronaut getAstronaut(String name) {
        return data.get(name);
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("Astronauts working at Space Station %s:", this.name));
        for (Astronaut astronaut : data.values()) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(astronaut.toString());
        }
        return stringBuilder.toString().trim();
    }
}

