package core.Animals;

import core.Gardens.Garden;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Rabbit {
    private String name;
    private Integer bag;
    private int maxWeight;
    private int totalTrips;
    private Integer currentWeight;

    public Rabbit(String name, int maxWeight, int totalTrips) {
        this.name = name;
        this.bag = 0;
        this.maxWeight = maxWeight;
        this.totalTrips = totalTrips;
        this.currentWeight = 0;
    }

//    public void collect(ArrayList<Garden> gardens) {
//        sortGardens(gardens);
//        int fieldIndex = 0;
//        int CarrotCnt;
//
//        for (int trips = 1; trips <= totalTrips; trips++) {
//
//            if (allGardensEmpty(gardens)) {
//                System.out.println("Все грядки пустые. Кролик собрал всю морковку за " + (trips + 1) + " ходок");
//                break;
//            }
//
//            for (fieldIndex = 0; fieldIndex < gardens.size(); fieldIndex++) {
//
//                CarrotCnt = gardens.get(fieldIndex).getCarrotCount();
//                if (CarrotCnt != 0) {
//                    currentWeight = gardens.get(fieldIndex).getCarrotWeight();
//                    gardens.get(fieldIndex).setCarrotCount(CarrotCnt - 1);
//
//                    if (currentWeight == maxWeight) {
//                        bag += currentWeight;
//                        System.out.println(bag);
//                    } else {
//                        for (int l = gardens.size() - 1; l > 0; l--) {
//                            if (currentWeight + gardens.get(l).getCarrotWeight() == maxWeight) {
//                                CarrotCnt = gardens.get(l).getCarrotCount();
//                                bag += currentWeight + gardens.get(l).getCarrotWeight();
//                                gardens.get(l).setCarrotCount(CarrotCnt - 1);
//                                System.out.println(bag);
//                            }
//                        }
//
//                    }
//                }
//            }
//        }
//    }

    public void collect(ArrayList<Garden> gardens) {
        sortGardens(gardens);
        int CarrotCnt;

        for (int trips = 1; trips <= totalTrips; trips++) {

            if (allGardensEmpty(gardens)) {
                System.out.println("Все грядки пустые. Кролик собрал всю морковку за " + trips + " ходок");
                break;
            }

            for (Garden garden : gardens) {
                CarrotCnt = garden.getCarrotCount();
                if (CarrotCnt != 0) {
                    currentWeight = garden.getCarrotWeight();
                    garden.setCarrotCount(CarrotCnt - 1);
                    bag += currentWeight;
                    System.out.println("Текущий вес в сумке: " + bag + " кг");
                    break;
                }
            }
        }
    }

    private boolean allGardensEmpty(ArrayList<Garden> gardens) {
        for (Garden garden : gardens) {
            if (garden.getCarrotCount() > 0) {
                return false;
            }
        }
        return true;
    }


    private void sortGardens(ArrayList<Garden> gardens) {
//        Garden temp = new Garden();
//        for (int i = 0; i < gardens.size() - 1; i++) {
//            for (int j = 0; j < gardens.size() - i - 1; j++) {
//                if (gardens.get(j + 1).getCarrotWeight() > gardens.get(j).getCarrotWeight()) {
//                    temp = gardens.get(j);
//                    gardens.set(j, gardens.get(j + 1));
//                    gardens.set(j + 1, temp);
//                }
//            }
//        }

            gardens.sort((g1, g2) -> g2.getCarrotWeight() - g1.getCarrotWeight());

    }

    public void rabbitBag() {
        System.out.println("У кролика в сумке " + bag + " кг моркови");
    }
}
