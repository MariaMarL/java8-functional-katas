package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Movie;
import util.DataUtil;

import javax.swing.text.Document;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1 {
    public static List<Map> execute() {
        List<Movie> movies = DataUtil.getMovies();


        return  movies.stream().map(movie -> {

            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("Id", movie.getId().toString());
            hashMap.put("title", movie.getTitle());

            return hashMap;
        }).collect(Collectors.toList());

        //ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys"));

    }

    public static void main(String[] args) {
        Kata1 kata1 = new Kata1();
        System.out.println(kata1.execute());
    }


}
