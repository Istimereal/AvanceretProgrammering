package Afleveringer.dijkstra;

import java.util.HashMap;
import java.util.Map;

public class WeightedCityNode {

   private String name;;

    private Map<WeightedCityNode, Integer> neighborCities;

    public WeightedCityNode(String name){

        this.name = name;
        this.neighborCities = new HashMap<>();
    }

    public String getCityName(){ return name; }

    public Map<WeightedCityNode, Integer> getNeighborCities() { return neighborCities; }

    public void addNeighborCity(WeightedCityNode neighbor, int distance ){
        neighborCities.put(neighbor, distance);
    }

}
