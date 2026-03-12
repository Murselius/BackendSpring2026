package bookstore.bookstore;


import bookstore.bookstore.model.AppUser;
import bookstore.bookstore.model.AppUserRepository;
import bookstore.bookstore.model.Book;
import bookstore.bookstore.model.BookRepository;
import bookstore.bookstore.model.Category;
import bookstore.bookstore.model.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class BookstoreApplication {

	private final AppUserRepository appUserRepository;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

    BookstoreApplication(CategoryRepository categoryRepository, BookRepository bookRepository, AppUserRepository appUserRepository) {
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
        this.appUserRepository = appUserRepository;
    }

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	@Profile("!test")
	public CommandLineRunner bookDemo() {
		return (args) -> {
			log.info("save a couple of example books");

			Category category1 = new Category("War Novel");
			Category category2 = new Category("Satire");

			if (categoryRepository.count()==0) {
			
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			}

			if (bookRepository.count()==0) {
			bookRepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 44.95, category1));
			bookRepository.save(new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 39.95, category2));	
			}

			// Create users: admin/admin user/user
			if (appUserRepository.count()==0) {
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			appUserRepository.save(user1);
			appUserRepository.save(user2);
			}
			
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
