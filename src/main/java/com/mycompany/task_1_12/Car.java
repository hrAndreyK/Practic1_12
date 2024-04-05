/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.task_1_12;

/**
 *
 * @author user
 */
import java.io.*;
import java.util.Scanner;

public class Car implements Externalizable {
    String make;
    String model;
    int year;
    double price;
    boolean isNew;
    public Car() {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(make);
        out.writeObject(model);
        out.writeInt(year);
        out.writeDouble(price);
        out.writeBoolean(isNew);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        make = (String) in.readObject();
        model = (String) in.readObject();
        year = in.readInt();
        price = in.readDouble();
        isNew = in.readBoolean();
    }
}