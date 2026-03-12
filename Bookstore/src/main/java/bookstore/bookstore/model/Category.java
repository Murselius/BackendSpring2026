package bookstore.bookstore.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
public class Category {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    @Column(name= "name", nullable = false)
	private String name;

    @JsonIgnoreProperties("category")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;

    public Category() {};

    public Category(String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long categoryid) {
        this.id = categoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Category [categoryid=" + id + ", name=" + name + "]";
    }

}
