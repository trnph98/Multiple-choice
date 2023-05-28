package com.example.tracnghiemv1;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class QuestionSort implements SortStrategy{



    @RequiresApi(api = Build.VERSION_CODES.N)


    @Override
    public void sort(ArrayList<Objects> items) {
        Collections.sort(items, Comparator.comparingInt(o -> Integer.parseInt(o.getImage())));
    }
}
