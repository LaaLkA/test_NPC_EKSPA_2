package util;

import core.Animals.Rabbit;
import core.Gardens.Garden;

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        Rabbit rabbit = new Rabbit("Tobby", 5, 10);
        ArrayList<Garden> gardens = new ArrayList<>();
        for (int i = 1; i < 6; i++){
            System.out.println("Введите количество моркови на грядке " + (i + 1) + ": ");
            gardens.add(new Garden(i,scanner.nextInt()));
        }
        System.out.println(gardens);

        rabbit.collect(gardens);
        rabbit.rabbitBag();

    }
}
