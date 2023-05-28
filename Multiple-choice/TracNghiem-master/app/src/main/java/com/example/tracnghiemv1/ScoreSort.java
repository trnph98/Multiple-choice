package com.example.tracnghiemv1;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class ScoreSort implements SortStrategy{


    @Override
    public void sort(ArrayList<Objects> items) {
        Collections.sort(items, Comparator.comparingInt(o -> o.getScore()));
    }
}
