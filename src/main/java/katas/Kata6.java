package katas;

import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();
        List<MovieList> movieList = DataUtil.getMovieLists();


        return movies.stream().map(movie -> movie.getBoxarts())
                .flatMap(movie2 -> movie2.stream())
                //.map(w -> w.getWidth()* w.getHeight())
                .reduce(new BoxArt(0,0,""),(a, b) ->{
                    if ( (a.getWidth() * a.getHeight()) < (b.getWidth() * b.getHeight())) {
                        return b;
                    } return a;
                }).getUrl();



    };


    public static void main(String[] args) {
        Kata6 kata6 = new Kata6();
        System.out.println(kata6.execute());
    }
}
