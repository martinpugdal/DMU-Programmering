package movieexercise;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoviesApp {
    public static List<Movie> readMovies(String filename) throws IOException {
        List<Movie> movies = new ArrayList<>();
        try (Scanner in = new Scanner(new File(filename))) {
            while (in.hasNextLine()) {
                String nameLine = in.nextLine();
                String yearLine = in.nextLine();
                String directorsLine = in.nextLine();
                String producersLine = in.nextLine();
                String actorsLine = in.nextLine();
                movies.add(new Movie(getString(nameLine),
                        Integer.parseInt(getString(yearLine)),
                        getList(directorsLine), getList(producersLine),
                        getList(actorsLine)));
            }
        }
        return movies;
    }

    private static String getString(String line) {
        int colon = line.indexOf(":");
        return line.substring(colon + 1).trim();
    }

    private static List<String> getList(String line) {
        return Stream.of(getString(line).split(", "))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        List<Movie> movieList = readMovies("C:\\Users\\Marti\\Documents\\GitHub\\Programmering1\\L10 Streams\\src\\" + "movies.txt");
//        for (Movie m : movieList) {
//            System.out.println(m.getTitle());
//        }

//        movieList.stream().forEach(e -> System.out.println(e.getTitle()));
//        System.out.println("Number of movies: " + movieList.size());

        //  The numer of movies starting with "H"
        long count = movieList.
                stream().
                filter(e -> e.getTitle().startsWith("H")).
                count();
        System.out.println("Number of movies starting with H: " + count);


        // The title of the movies starting with "X"
        movieList.
                stream().
                filter(e -> e.getTitle().startsWith("X")).
                forEach(e -> System.out.println(e.getTitle()));

        // The number of films where the director is also an actor
        count = movieList.
                stream().
                filter(e -> e.getActors().containsAll(e.getDirectors())).
                count();
        System.out.println("Number of movies where the director is also an actor: " + count);

        //The number of actors in the film with the most actors
        movieList.
                stream().
                mapToInt(e -> e.getActors().size()).
                max().
                ifPresent(e -> System.out.println("Number of actors in the film with the most actors: " + e));
        // The title of the film with the most actors
        int temp = (int) count;
        movieList.
                stream().
                filter(e -> e.getActors().size() == temp).
                findAny().
                ifPresent(e -> System.out.println("Title of the film with the most actors: " + e.getTitle()));

        //Number of films divided by first letter in the film title
        movieList.
                stream().
                collect(Collectors.groupingBy(e -> e.getTitle().charAt(0), Collectors.counting())).
                forEach((k, v) -> System.out.println("Number of films starting with " + k + ": " + v));

        // Number of movies whose title starts with "The "
        count = movieList.
                stream().
                filter(e -> e.getTitle().startsWith("The ")).
                count();
        System.out.println("Number of movies whose title starts with The: " + count);
    }


}

