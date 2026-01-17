package de.webtech.project.movie;

import jakarta.persistence.*;
@Entity
@Table (name = "movies")
public class Movie {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String title;

    @Column(name = "release_year")
    private int releaseYear;

    @Column (nullable = false)
    private int rating; //1-5

    @Column(columnDefinition = "TEXT")
    private String review;

    public Movie() {}

    //Konstruktor
    public Movie(String title, int releaseYear){
        this.title = title;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.review = review;
    }
    // getter und Setter

    public Long getId() {
        return id;

    }
    public void setId(Long id) {
        this.id = id;
    }

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
    public int getRating() { return rating;}
    public void setRating(int rating) { this.rating = rating; }

    public String getReview() { return review; }
    public void setReview(String review) { this.review = review; }

}




