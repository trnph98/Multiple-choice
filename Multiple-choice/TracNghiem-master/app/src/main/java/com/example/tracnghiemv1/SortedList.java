package com.example.tracnghiemv1;

import java.util.ArrayList;
import java.util.List;

public class SortedList {

    private SortStrategy strategy;
    private ArrayList<Question> items = new ArrayList<>() ;

    public void setSortStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void add(Question name) {
        this.items.add(name);
    }

    public void sort() {
        strategy.sort(this.items);
    }

    public ArrayList<Question> getItems() {
        return this.items;
    }
}