package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.MovieList;
import util.DataUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .map(MovieList::getVideos)
                .flatMap(movie2->movie2.stream())
                .map(movie -> {
                    BoxArt boxArt = movie.getBoxarts().stream()
                            .filter(boxart -> boxart.getWidth() ==150 && boxart.getHeight()==200)

                            .findFirst()
                            .orElseThrow();
                    HashMap<String, String> map = new HashMap<>();
                    map.put("title", movie.getTitle());
                    map.put("id", movie.getId().toString());
                    map.put("Boxart", boxArt.getUrl());
                    return map;
                }).collect(Collectors.toList());


        //return null;
        //ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys", "boxart", new BoxArt(150, 200, "url")));
    }

    public static void main(String[] args) {
        Kata4 kata4 = new Kata4();
        System.out.println(kata4.execute());
    }
}
