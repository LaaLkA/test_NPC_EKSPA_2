package core.Animals;

import core.Gardens.Garden;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Rabbit {
    private String name;
    private Integer bag;
    private Integer maxWeight;
    private Integer totalTrips;
    private Integer currentWeight;

    public Rabbit(String name, int maxWeight, int totalTrips) {
        this.name = name;
        this.bag = 0;
        this.maxWeight = maxWeight;
        this.totalTrips = totalTrips;
        this.currentWeight = 0;
    }

    public void collect(ArrayList<Garden> gardens) {
        sortGardens(gardens);
        int fieldIndex = 0;
        int CarrotCnt;

        for (int trips = 1; trips <= totalTrips; trips++) {
            for (fieldIndex = 0; fieldIndex < gardens.size(); fieldIndex++) {
                if (gardens.get(fieldIndex).getCarrotCount() != 0) {
                    CarrotCnt = gardens.get(fieldIndex).getCarrotCount();
                    currentWeight = gardens.get(fieldIndex).getCarrotWeight();
                    gardens.get(fieldIndex).setCarrotCount(CarrotCnt - 1);

                    if (currentWeight == maxWeight) {
                        bag += currentWeight;
                        System.out.println(bag);
                    } else {
                        for (int l = gardens.size() - 1; l > 0; l--) {
                            if (currentWeight + gardens.get(l).getCarrotWeight() == maxWeight) {
                                CarrotCnt = gardens.get(l).getCarrotCount();
                                bag += currentWeight + gardens.get(l).getCarrotWeight();
                                gardens.get(l).setCarrotCount(CarrotCnt - 1);
                                System.out.println(bag);
                            }
                        }

                    }
                }
                if (gardens.get(fieldIndex).getCarrotCount() != 0) {
                    CarrotCnt = gardens.get(fieldIndex).getCarrotCount();
                    currentWeight = gardens.get(fieldIndex).getCarrotWeight();
                    gardens.get(fieldIndex).setCarrotCount(CarrotCnt - 1);

                    if (currentWeight == maxWeight) {
                        bag += currentWeight;
                        System.out.println(bag);
                    } else {
                        for (int l = gardens.size() - 1; l > 0; l--) {
                            if (currentWeight + gardens.get(l).getCarrotWeight() == maxWeight) {
                                CarrotCnt = gardens.get(l).getCarrotCount();
                                bag += currentWeight + gardens.get(l).getCarrotWeight();
                                gardens.get(l).setCarrotCount(CarrotCnt - 1);
                                System.out.println(bag);
                            }
                        }
                    }
                }
            }
            System.out.println(trips);
        }
    }


    private void sortGardens(ArrayList<Garden> gardens) {
        Garden temp = new Garden();
        for (int i = 0; i < gardens.size() - 1; i++) {
            for (int j = 0; j < gardens.size() - i - 1; j++) {
                if (gardens.get(j + 1).getCarrotWeight() > gardens.get(j).getCarrotWeight()) {
                    temp = gardens.get(j);
                    gardens.set(j, gardens.get(j + 1));
                    gardens.set(j + 1, temp);
                }
            }
        }
    }

    public void rabbitBag() {
        System.out.println("У кролика в сумке " + bag + " кг моркови");
    }
}
