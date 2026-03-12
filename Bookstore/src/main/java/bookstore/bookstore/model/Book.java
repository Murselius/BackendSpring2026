package bookstore.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Book {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;


    @NotEmpty(message= "Kirjan nimi ei voi olla tyhjä.")
    @Size(min= 3, max = 250, message = "Kirjan nimen pituus on 3 - 250 merkkiä.")
    @Column(name= "title", nullable = false)
    private String title;
    @Column(name= "author", nullable = false)
    private String author;
    @Column(name= "publication_year", nullable = false)
    private int publicationYear;
    @Column(name= "isbn", nullable = false)
    private String isbn;
    @Column(name= "price", nullable = false)
    private double price;

    @JsonIgnoreProperties("books")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Book(String title, String author, int publicationYear, String isbn, double price, Category category) {
        super();
        this.title=title;
        this.author=author;
        this.publicationYear=publicationYear;
        this.isbn=isbn;
        this.price=price;
        this.category=category;
    }

    public Book() {}

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publicationYear=" + publicationYear
                + ", isbn=" + isbn + ", price=" + price + "]";
    }

    
}
