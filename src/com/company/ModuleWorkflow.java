package com.company;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ModuleWorkflow {

    public static void main(String[] args) {
        int failures = 0;
        String state = "Introductory Exercises";
        ArrayList<String> records = new ArrayList<String>();
        Scanner in = new Scanner(System.in);
        do {
            System.out.println(state);
            System.out.print("> ");
            String input = in.nextLine();
            switch(state) {
                case "Introductory Exercises":
                    if (Objects.equals(input, "pass")) {
                        state = "Project";
                        records.add("Completed Introductory Exercises");
                    } else {
                        System.out.println("Error");
                    }
                    break;
                case "Project":
                    if (Objects.equals(input, "pass")) {
                        state = "Benchmark";
                        records.add("Completed Project");
                    } else {
                        System.out.println("Error");
                    }
                    break;
                case "Benchmark":
                    if (Objects.equals(input, "pass")) {
                        state = "Complete";
                        records.add("Completed Benchmark");
                    } else if (Objects.equals(input, "fail")){
                        if (failures != 2) {
                            state = "Project";
                            records.add("Failed Benchmark");
                            failures++;
                        } else {
                            state = "Fail";
                            records.add("Failed");
                        }
                    } else {
                        System.out.println("Error");
                    }
                    break;
            }
        } while (!state.equals("Complete") && !state.equals("Fail"));
        System.out.println(state);
        System.out.println(records.toString());
    }
}
