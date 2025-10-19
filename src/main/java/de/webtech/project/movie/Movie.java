package de.webtech.project.movie;

public class Movie {private String title;
    private int releaseYear;


    //Konstruktor
    public Movie(String title, int releaseYear){
        this.title = title;
        this.releaseYear = releaseYear;
    }
    // getter und Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

}
