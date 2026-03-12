package bookstore.bookstore.web;

import org.springframework.web.bind.annotation.RestController;

import bookstore.bookstore.model.Book;
import bookstore.bookstore.model.BookRepository;
import bookstore.bookstore.model.Category;
import bookstore.bookstore.model.CategoryRepository;

import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class RestBookController {
    
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public RestBookController(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/books")
    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> findById(@PathVariable("id") Long bookId) {
        return bookRepository.findById(bookId);
    }

    @PostMapping("/books")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Book saveBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
    
    @PutMapping("books/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Book saveEditedBook(@RequestBody Book editedBook, @PathVariable long id) {
        editedBook.setId(id);
        return bookRepository.save(editedBook);
    }

    @DeleteMapping("/books/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Iterable<Book> deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return bookRepository.findAll();
    }
    
    @GetMapping("/categories")
    public Iterable<Category> findAllCategories() {
        return categoryRepository.findAll();
    }
    
    @GetMapping("/categories/{id}")
    public Optional<Category> findByCategoryId(@PathVariable("id") Long categoryId) {
        return categoryRepository.findById(categoryId);
    }
}
    


