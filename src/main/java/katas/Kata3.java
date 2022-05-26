package katas;

import com.google.common.collect.ImmutableList;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Goal: Use map() and flatMap() to project and flatten the movieLists into an array of video ids (flatMap(c -> c.stream()))
    DataSource: DataUtil.getMovieLists()
    Output: List of Integers
*/
public class Kata3 {
    public static List<Integer> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

         return movieLists.stream()
                .map(MovieList::getVideos)
                .flatMap(Collection::stream)
                .map(Movie::getId)
                .collect(Collectors.toList());


    }

    public static void main(String[] args) {
        Kata3 kata3 = new Kata3();
        System.out.println(kata3.execute());
    }
}
