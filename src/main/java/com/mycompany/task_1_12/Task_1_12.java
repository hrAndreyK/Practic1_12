/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.task_1_12;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Task_1_12 {

    public static void main(String[] args) {
            System.out.print("Hohlov Andrey RIBO-03-22 1var");
        try {
            Car car = new Car();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter make: ");
            car.make = scanner.nextLine();

            System.out.print("Enter model: ");
            car.model = scanner.nextLine();

            System.out.print("Enter year: ");
            try {
                car.year = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for year. Please enter a valid integer.");
                return;
            }
            if (car.year < 1900 || car.year > 2025) {
                System.out.println("year<1900");
                return;
            }
            System.out.print("Enter price: ");
            try {
                car.price = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for price. Please enter a valid double.");
                return;
            }

            System.out.print("Is it a new car? (true/false): ");
            car.isNew = Boolean.parseBoolean(scanner.nextLine());

            FileOutputStream fileOut = new FileOutputStream("C:/car_data.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            Thread t = new Thread(() -> {
                try {
                    out.writeObject(car);
                    out.close();
                    fileOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            t.start();
            t.join();

            System.out.println("Car object has been serialized and saved to C:/car_data.txt");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
