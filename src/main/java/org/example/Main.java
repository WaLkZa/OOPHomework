package org.example;

import org.example.IO.InputReader;
import org.example.IO.OutputWriter;
import org.example.model.impl.Chicken;
import org.example.service.impl.Barn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        List<Chicken> chickens = new ArrayList<>();
//        try {
//            chickens.add(new Chicken("Chicken",5));
//            chickens.add(new Chicken("Chicken",6));
//            chickens.add(new Chicken("Chicken",0));
//            chickens.add(new Chicken("Chicken",1));
//            chickens.add(new Chicken("Chicken",2));
//        } catch(Exception ex) {
//            System.out.println(ex.getMessage());
//        }

        List<Chicken> chickens = InputReader.readInput();
        Barn barn = new Barn(chickens);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of weeks: ");
        int numberOfWeeks = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfWeeks; i++) {
            System.out.printf("%d week type: ", i);
            String weekType = scanner.nextLine();
            barn.generateWeek(weekType);
        }

        String barnResult = barn.toString();
        System.out.println(barnResult);

        System.out.println("Want to save the output in a txt file? (y/n)");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            OutputWriter.writeResult(barnResult);
        }
    }
}