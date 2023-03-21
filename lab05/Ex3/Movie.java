package lab05.Ex3;

import java.util.List;

public class Movie {
    private final String title;
    private final int year;
    private final Person director;
    private final Person writer;
    private final String series;
    private final List<Person> cast;
    private final List<Place> locations;
    private final List<String> languages;
    private final List<String> genres;
    final boolean isTelevision;
    private final boolean isNetflix;
    private final boolean isIndependent;

    public static class Builder {
        private final String title;
        private final int year;

        private Person director;
        private Person writer;

        private String series;
        private List<Person> cast;
        private List<Place> locations;
        private List<String> languages;
        private List<String> genres;

        private boolean isTelevision;
        private boolean isNetflix;
        private boolean isIndependent;

        public Builder(String title, int year) {
            this.title = title;
            this.year = year;
        }

        public Builder director(Person director) {
            this.director = director;
            return this;
        }

        public Builder writer(Person writer) {
            this.writer = writer;
            return this;
        }

        public Builder series(String series) {
            this.series = series;
            return this;
        }

        public Builder cast(List<Person> cast) {
            this.cast = cast;
            return this;
        }

        public Builder locations(List<Place> locations) {
            this.locations = locations;
            return this;
        }

        public Builder languages(List<String> languages) {
            this.languages = languages;
            return this;
        }

        public Builder genres(List<String> genres) {
            this.genres = genres;
            return this;
        }

        public Builder isTelevision(boolean isTelevision) {
            this.isTelevision = isTelevision;
            return this;
        }

        public Builder isNetflix(boolean isNetflix) {
            this.isNetflix = isNetflix;
            return this;
        }

        public Builder isIndependent(boolean isIndependent) {
            this.isIndependent = isIndependent;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }

    public Movie(Builder builder) {
        title = builder.title;
        year = builder.year;
        director = builder.director;
        writer = builder.writer;
        series = builder.series;
        cast = builder.cast;
        locations = builder.locations;
        languages = builder.languages;
        genres = builder.genres;
        isTelevision = builder.isTelevision;
        isNetflix = builder.isNetflix;
        isIndependent = builder.isIndependent;
    }

    public String toString() {
        String s;
        s = this.title + " (" + this.year + ")\n";
        if (this.director != null) {
            s += "Director: " + this.director + "\n";
        }
        if (this.writer != null) {
            s += "Writer: " + this.writer + "\n";
        }
        if (this.cast != null) {
            s += "Cast: " + this.cast + "\n";
        }
        if (this.locations != null) {
            s += "Locations: " + this.locations + "\n";
        }
        if (this.languages != null) {
            s += "Languages: " + this.languages + "\n";
        }
        if (this.genres != null) {
            s += "Genres: " + this.genres + "\n";
        }
        if (this.series != null) {
            s += "Series: " + this.series + "\n";
        }
        if (this.isTelevision && this.isNetflix) {
            s += "Available on Netflix and Television\n";
        } else if (this.isTelevision) {
            s += "Available on Television\n";
        } else if (this.isNetflix) {
            s += "Available on Netflix\n";
        }
        if (this.isIndependent) {
            s += "Independent\n";
        }

        return s;
    }
    
}
