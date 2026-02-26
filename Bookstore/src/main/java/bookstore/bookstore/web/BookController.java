package bookstore.bookstore.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bookstore.bookstore.model.Book;
import bookstore.bookstore.model.BookRepository;
import bookstore.bookstore.model.CategoryRepository;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

	private final BookRepository repository; 
    private final CategoryRepository crepository;
	
    //Controller injection
    public BookController(BookRepository repository, CategoryRepository crepository) {
        this.repository = repository;
        this.crepository = crepository;
    }

    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	

    @RequestMapping(value= {"/", "/booklist"})
    public String studentList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid Book book, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            log.info("validation error tapahtui: " + book.toString());
            model.addAttribute("book", book);
            return "/addBook";
        }
        repository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model) {
    	model.addAttribute("book", repository.findById(bookId));
        model.addAttribute("categories", crepository.findAll());
        return "editbook";
    }
  
}
