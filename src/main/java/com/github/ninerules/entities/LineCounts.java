package com.github.ninerules.entities;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.checkerframework.checker.nullness.qual.NonNull;

public class LineCounts {
    private List<LineCount> list;

    public LineCounts(LineCount... numbers){
        list = Arrays.stream(numbers)
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object object){
        return object instanceof LineCounts &&
                checkEquals((LineCounts)object);
    }

    @Override
    public int hashCode(){
        Object[] array = list.toArray();
        return Objects.hash(array);
    }

    private boolean checkEquals(@NonNull LineCounts counts){
        LineCount[] counts1 = toArray(list);
        LineCount[] counts2 = toArray(counts.list);
        return Arrays.equals(counts1, counts2);
    }

    private LineCount[] toArray(List<LineCount> list){
        LineCount[] counts = new LineCount[list.size()];
        return list.toArray(counts);
    }

    @Override
    public String toString(){
        return list.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }
}
