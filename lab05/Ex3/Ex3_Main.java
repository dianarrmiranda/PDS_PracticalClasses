package lab05.Ex3;

import java.util.List;

public class Ex3_Main {
    public static void main(String[] args) {
        Movie movie = new Movie.Builder("Barbie", 2023)
                .director(new Person("Greta Gerwig"))
                .writer(new Person("Greta Gerwig"))
                .cast(List.of(new Person("Margot Robbie"), new Person("Ryan Gosling"), new Person("Issa Rae")))
                .genres(List.of("Family", "Comedy"))
                .languages(List.of("English", "Portuguese"))
                .locations(List.of(new Place("New York"), new Place("Los Angeles")))
                .isNetflix(true)
                .isIndependent(true)
                .isTelevision(false)
                .build();

        System.out.println(movie);

        Movie movie2 = new Movie.Builder("Ticket to Paradise", 2022)
        .director(new Person("Ol Parker"))
        .writer(new Person("Daniel Pipski"))
        .cast(List.of(new Person("George Clooney"), new Person("Sean Lynch"), new Person("Julia Roberts")))
        .genres(List.of("Romance", "Comedy"))
        .languages(List.of("English"))
        .isNetflix(false)
        .isIndependent(false)
        .isTelevision(true)
        .build();

        System.out.println(movie2);

    }

}
