package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sum = 0;

        try {
            File myObj = new File("src/main/resources/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();


                String first = "";
                int smallest = data.length()+1;
                String second = "";
                int largest = -1;

                for (Digit digit:
                     Digit.values()) {
                    if (data.indexOf(digit.wordRepresentation) >= 0 && data.indexOf(digit.wordRepresentation) < smallest) {
                        smallest = data.indexOf(digit.wordRepresentation);
                        first = digit.digitRepresentation;
                    }
                    if (data.indexOf(digit.digitRepresentation) >= 0 && data.indexOf(digit.digitRepresentation) < smallest) {
                        smallest = data.indexOf(digit.digitRepresentation);
                        first = digit.digitRepresentation;
                    }

                    if (data.lastIndexOf(digit.wordRepresentation) >= 0 && data.lastIndexOf(digit.wordRepresentation) > largest) {
                        largest = data.lastIndexOf(digit.wordRepresentation);
                        second = digit.digitRepresentation;
                    }
                    if (data.lastIndexOf(digit.digitRepresentation) >= 0 && data.lastIndexOf(digit.digitRepresentation) > largest) {
                        largest = data.lastIndexOf(digit.digitRepresentation);
                        second = digit.digitRepresentation;
                    }
                }
                sum += Integer.valueOf(first.concat(second));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(sum);
    }
}