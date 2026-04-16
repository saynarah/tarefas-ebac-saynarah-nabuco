package saynab.com.category_meme_service.domain;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="meme_categories")
public class CategoryMeme {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_meme_category")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false,unique = true)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @Column(name = "user_id")
    private Long userId;

    public CategoryMeme() {
    }

    public CategoryMeme(Long id, String name, String description, Date creationDate, Long userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
