package Afleveringer.dijkstra;

import Afleveringer.dijkstra.WeightedCityNode;

import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {

        WeightedCityNode lyngby = new WeightedCityNode("Lyngby");
        WeightedCityNode hørsholm = new WeightedCityNode("Hørsholm");
        WeightedCityNode holte = new WeightedCityNode("Holte");
        WeightedCityNode virum = new WeightedCityNode("Virum");
        WeightedCityNode farum = new WeightedCityNode("Farum");
        WeightedCityNode rungsted = new WeightedCityNode("Rungsted");
        WeightedCityNode hillerød = new WeightedCityNode("Hillerød");
        WeightedCityNode allerød = new WeightedCityNode("Allerød");
        WeightedCityNode værløse = new WeightedCityNode("Værløse");
        WeightedCityNode københavn = new WeightedCityNode("København");

        // Lyngby
        lyngby.addNeighborCity(hørsholm, getRandomTime(true));
        hørsholm.addNeighborCity(lyngby, getRandomTime(true));

        lyngby.addNeighborCity(holte, getRandomTime(true));
        holte.addNeighborCity(lyngby, getRandomTime(true));

        lyngby.addNeighborCity(virum, getRandomTime(true));
        virum.addNeighborCity(lyngby, getRandomTime(true));

        lyngby.addNeighborCity(københavn, getRandomTime(false));
        københavn.addNeighborCity(lyngby, getRandomTime(false));

// Hørsholm
        hørsholm.addNeighborCity(rungsted, getRandomTime(true));
        rungsted.addNeighborCity(hørsholm, getRandomTime(true));

        hørsholm.addNeighborCity(hillerød, getRandomTime(false));
        hillerød.addNeighborCity(hørsholm, getRandomTime(false));

        hørsholm.addNeighborCity(allerød, getRandomTime(false));
        allerød.addNeighborCity(hørsholm, getRandomTime(false));

// Holte
        holte.addNeighborCity(virum, getRandomTime(true));
        virum.addNeighborCity(holte, getRandomTime(true));

        holte.addNeighborCity(farum, getRandomTime(true));
        farum.addNeighborCity(holte, getRandomTime(true));

        holte.addNeighborCity(allerød, getRandomTime(false));
        allerød.addNeighborCity(holte, getRandomTime(false));

// Virum
        virum.addNeighborCity(værløse, getRandomTime(true));
        værløse.addNeighborCity(virum, getRandomTime(true));

        virum.addNeighborCity(københavn, getRandomTime(false));
        københavn.addNeighborCity(virum, getRandomTime(false));

// Farum
        farum.addNeighborCity(værløse, getRandomTime(true));
        værløse.addNeighborCity(farum, getRandomTime(true));

        farum.addNeighborCity(allerød, getRandomTime(true));
        allerød.addNeighborCity(farum, getRandomTime(true));

        farum.addNeighborCity(hillerød, getRandomTime(false));
        hillerød.addNeighborCity(farum, getRandomTime(false));

// Rungsted
        rungsted.addNeighborCity(hillerød, getRandomTime(false));
        hillerød.addNeighborCity(rungsted, getRandomTime(false));

        rungsted.addNeighborCity(københavn, getRandomTime(false));
        københavn.addNeighborCity(rungsted, getRandomTime(false));

// Hillerød
        hillerød.addNeighborCity(allerød, getRandomTime(true));
        allerød.addNeighborCity(hillerød, getRandomTime(true));

// Værløse
        værløse.addNeighborCity(københavn, getRandomTime(false));
        københavn.addNeighborCity(værløse, getRandomTime(false));


findfastestPath(virum, hillerød);
    }

    public static void findfastestPath(WeightedCityNode start, WeightedCityNode distination){

        Scanner scanner = new Scanner(System.in);

        Map<WeightedCityNode, WeightedCityNode> previousCity = new HashMap<>();

        Map<WeightedCityNode, Integer> distanceToCity = new HashMap<>();

        Set<WeightedCityNode> visitedCities = new HashSet<>();

       PriorityQueue<UpdateDistanceStartToCurrentNode> queue = new PriorityQueue<>();

       queue.add(new UpdateDistanceStartToCurrentNode(start, 0));
       distanceToCity.put(start, 0);

        System.out.println("Din start by er lagt i priority queue \n");

       while (!queue.isEmpty()){

          UpdateDistanceStartToCurrentNode currentCity = queue.poll();

           System.out.println("Nuværende by der skal findes afstande til nabo byer på er: " + currentCity.node.getCityName() + "\n");

          if(currentCity.node.equals(distination)) {

              System.out.println("Der er beregnet afstand til destinationen, og den er : " + currentCity.getTotalTravel() + " km. \n " +
                      "Du skal rejse gennem følgende byer: ");
              for(Map.Entry<WeightedCityNode, WeightedCityNode> entry : previousCity.entrySet()){

                  WeightedCityNode city = entry.getKey();
                  WeightedCityNode previous = entry.getValue();

                  System.out.println(previous.getCityName() + " til " + city.getCityName() + "\n" );
              }

               break; }

          if(visitedCities.contains(currentCity.node)){
              System.out.println( currentCity.node.getCityName() + " har allerede en kortere rute fra start distinationen: " + start.getCityName());  continue; }

           waitForNextStep(scanner);

          visitedCities.add(currentCity.node);

          for(Map.Entry<WeightedCityNode, Integer> entry : currentCity.node.getNeighborCities().entrySet()){

             WeightedCityNode nextCity = entry.getKey();
             int weight = entry.getValue();

              System.out.println("Har følgende nabo byer: " + nextCity.getCityName() + " Med " + weight + " Km afstand fra: " + currentCity.getCityNameForUpdatedCity());

              waitForNextStep(scanner);

             if (visitedCities.contains(nextCity)){
                 System.out.println( "Der findes allerede en korter vej fra: " + start.getCityName() + "til: " + nextCity.getCityName() );
                 waitForNextStep(scanner);
                 continue; }


             int newDistance = currentCity.totalTravel + weight;

              System.out.println("Den nuværende beregnede afstand er: " + newDistance);

              waitForNextStep(scanner);

             if(newDistance < distanceToCity.getOrDefault(nextCity, Integer.MAX_VALUE)){

                 distanceToCity.put(nextCity, newDistance);
                 previousCity.put(nextCity, currentCity.node);

                 queue.add(new UpdateDistanceStartToCurrentNode(nextCity, newDistance));

                 System.out.println(nextCity.getCityName() + " Er lagt i priority queue: " + "Med opdateret distance: " + newDistance);

                 waitForNextStep(scanner);

                 List<String> cityOrder = new ArrayList<>();
                 WeightedCityNode step = distination;

                 int count = 0;

                 while (step != null){

                     if(count > 0) {
                         System.out.println("Byerne på ruten fra " + start.getCityName() + " til: " + distination.getCityName() + " findes");
                     }
                     cityOrder.add(0, step.getCityName());
                     step = previousCity.get(step);

                     count++;
                 }

             }
          }

       }

    }


    public static Integer getRandomTime(Boolean shortDistance){
        int distance;
        if (shortDistance){

            distance = (int)(Math.random()*11) + 5;
        }
        else{ distance = (int)(Math.random()*11) + 16;}

        return distance;
    }

    public static class UpdateDistanceStartToCurrentNode implements Comparable<UpdateDistanceStartToCurrentNode> {

        WeightedCityNode node;
        int totalTravel;

        public UpdateDistanceStartToCurrentNode(WeightedCityNode current, int totalTravel){

            this.node = current;
            this.totalTravel = totalTravel;
        }

        public String getCityNameForUpdatedCity(){ return node.getCityName(); }

        public Integer getTotalTravel(){ return totalTravel; }

        public int compareTo(UpdateDistanceStartToCurrentNode other) {
            return Integer.compare(this.totalTravel, other.totalTravel);
        }

    }

    public static void waitForNextStep(Scanner scanner) {
        System.out.print("Skriv y for næste step: ");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("y")) {
                System.out.println();
                return;
            }

            System.out.print("Skriv y for at fortsætte: ");
        }
    }

}
