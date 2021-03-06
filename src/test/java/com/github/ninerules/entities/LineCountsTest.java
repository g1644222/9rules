package com.github.ninerules.entities;

import static com.github.ninerules.Assert.assertAvailablePrivateConstructor;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class LineCountsTest {
    @Test
    public void testBasic(){
        LineCounts numbers = LineCountsBuilder.builder()
                .of(1, 2, 8, 9, 10).build();
        assertThat(numbers.toString(), is("1,2,8,9,10"));

        LineCounts numbers2 = LineCountsBuilder.builder()
                .of(1, 2, 8, 9, 10).build();
        assertThat(numbers, is(numbers2));
    }

    @Test
    public void testGenerate() {
        Stream<LineCount> stream = LineCountStream.generate();
        LineCounts counts = new LineCounts(stream.skip(3).limit(5).toArray(LineCount[]::new));
        assertThat(counts.toString(), is("4,5,6,7,8"));
    }

    @Test
    public void testRange(){
        LineCounts numbers = LineCountsBuilder.builder()
                .range(2, 5).build();
        assertThat(numbers.toString(), is("2,3,4"));
    }

    @Test
    public void testRangeClosed(){
        LineCounts numbers = LineCountsBuilder.builder()
                .rangeClosed(2, 5).build();
        assertThat(numbers.toString(), is("2,3,4,5"));
    }

    @Test
    public void testBuildFromStream(){
        Stream<LineCount> stream = IntStream.of(1, 2, 3, 8, 9).mapToObj(line -> new LineCount(line)); 
        LineCounts numbers = LineCountsBuilder.builder()
                .of(stream).build();
        assertThat(numbers.toString(), is("1,2,3,8,9"));
    }

    @Test
    public void testBuildFromArray(){
        LineCounts numbers = new LineCounts(new LineCount(1), new LineCount(4));
        assertThat(numbers.toString(), is("1,4"));

        LineCounts numbers2 = LineCountsBuilder.builder().of(1, 4).build();
        assertThat(numbers, is(numbers2));
    }

    @Test
    public void testNotEquals(){
        LineCounts numbers = new LineCounts(new LineCount(1), new LineCount(4));

        assertThat(numbers, is(not(new Object())));
    }

    @Test
    public void testHash(){
        LineCount[] counts = new LineCount[] { new LineCount(1), new LineCount(4) };

        assertThat(new LineCounts(counts).hashCode(), is(Objects.hash(new LineCount(1), new LineCount(4))));
    }

    @Test
    public void testPrivateConstructorOfLineCountStream() throws Exception{
        assertAvailablePrivateConstructor(LineCountStream.class);
    }
}
