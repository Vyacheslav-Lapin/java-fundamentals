package com.epam.courses.java.fundamentals.oop.TasksFromPDF.Task3;

import java.util.ArrayList;
import java.util.List;

public class NovicePack {
    private List<Stationery> stationeryList = new ArrayList<>();

    public NovicePack() {
        createPack();
    }

    private void createPack() {
        stationeryList.add(new Pen(2, 25, "Blue", 0.5));
        stationeryList.add(new Pencil(2, 15, Pencil.pencliHardness.M));
        stationeryList.add(new Folder(3, 50, "Green"));
        stationeryList.add(new Notepad(1, 40, 100));
    }

    public List<Stationery> getStationeryList() {
        return stationeryList;
    }
}
