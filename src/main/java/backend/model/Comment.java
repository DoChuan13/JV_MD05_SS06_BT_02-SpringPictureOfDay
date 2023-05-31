package backend.model;


import javax.persistence.*;

@Entity
@Table(name = "comment", schema = "cms")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String picture;
    private String author, feedback;
    private byte stars;
    private int likes;

    public Comment() {
    }

    public Comment(Long id, String picture, String author, String feedback, byte stars, int likes) {
        this.id = id;
        this.picture = picture;
        this.author = author;
        this.feedback = feedback;
        this.stars = stars;
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public byte getStars() {
        return stars;
    }

    public void setStars(byte star) {
        this.stars = star;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int like) {
        this.likes = like;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", author='" + author + '\'' +
                ", feedback='" + feedback + '\'' +
                ", star=" + stars +
                ", like=" + likes +
                '}';
    }
}
