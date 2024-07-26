package core.Animals;

import core.Gardens.Garden;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
//        for (int trips = 1; trips < totalTrips; trips++) {
//            if (!gardens.isEmpty()) {
//                currentWeight = gardens.get(0).getCarrotWeight();
//                if (currentWeight != maxWeight) {
//                    for (int l = gardens.size() - 1; l > 0; l--) {
//                        if (currentWeight + gardens.get(l).getCarrotWeight() == maxWeight) {
//                            bag += currentWeight + gardens.get(l).getCarrotWeight();
//                            gardens.remove(l);
//                            gardens.remove(0);
//                            break;
//                        }
//                    }
//                } else {
//                    bag += currentWeight;
//                    gardens.remove(0);
//                }
//            } else {
//                trips -= 1;
//                System.out.println("Все полянки пустые. Кролик собрал " + bag + "кг моркови за " + trips + " ходки");
//                break;
//            }
//        }
        int fieldIndex = 0;
        int firshCarrotCnt = 0;
        int secondCarrotCnt = 0;
        for (int trips = 1; trips < totalTrips; trips++) {
            if (!gardens.isEmpty()) {
                if (gardens.get(fieldIndex).getCarrotCount() != 0) {
                    firshCarrotCnt = gardens.get(fieldIndex).getCarrotCount();
                    currentWeight = gardens.get(fieldIndex).getCarrotWeight();
                    gardens.get(fieldIndex).setCarrotCount(firshCarrotCnt - 1);
                    if (currentWeight != maxWeight) {
                        for (int l = gardens.size() - 1; l > 0; l--) {
                            if (currentWeight + gardens.get(l).getCarrotWeight() == maxWeight) {
                                secondCarrotCnt = gardens.get(l).getCarrotCount();
                                bag += currentWeight + gardens.get(l).getCarrotWeight();
                                if (secondCarrotCnt > 0){
                                    gardens.get(l).setCarrotCount(secondCarrotCnt - 1);
                                } gardens.remove(l);

                                break;
                            }
                        }
                    } else {
                        bag += currentWeight;
                        gardens.remove(fieldIndex);
                    }
                }
            }
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
