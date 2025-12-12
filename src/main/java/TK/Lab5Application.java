package TK;

import TK.entities.*;
import TK.repositories.*;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Lab5Application implements CommandLineRunner {

    private final BookEntityRepository bookRepository;
    private final MagazineEntityRepository magazineRepository;
    private final DiscMagEntityRepository discMagRepository;
    private final TicketEntityRepository ticketRepository;

    public Lab5Application(BookEntityRepository bookRepository,
                           MagazineEntityRepository magazineRepository,
                           DiscMagEntityRepository discMagRepository,
                           TicketEntityRepository ticketRepository) {
        this.bookRepository = bookRepository;
        this.magazineRepository = magazineRepository;
        this.discMagRepository = discMagRepository;
        this.ticketRepository = ticketRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab5Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        bookRepository.deleteAll();
        magazineRepository.deleteAll();
        discMagRepository.deleteAll();
        ticketRepository.deleteAll();

        for (int i = 0; i < 10; i++) {
            BookEntity book = new BookEntity();
            String bookTitle = faker.book().title();
            book.setTitle(bookTitle);
            book.setAuthor(faker.book().author());
            book.setPrice(Double.parseDouble(faker.commerce().price(10, 100)));
            book.setCopies(faker.number().numberBetween(1, 100));
            bookRepository.save(book);
        }

        BookEntity book1 = new BookEntity();
        book1.setTitle(faker.book().title());
        book1.setAuthor("Julius Caesar");
        book1.setPrice(Double.parseDouble(faker.commerce().price(5, 50)));
        book1.setCopies(faker.number().numberBetween(1, 100));
        bookRepository.save(book1);

        BookEntity book2 = new BookEntity();
        book2.setTitle(faker.book().title());
        book2.setAuthor("Julius Caesar");
        book2.setPrice(Double.parseDouble(faker.commerce().price(5, 50)));
        book2.setCopies(faker.number().numberBetween(1, 100));
        bookRepository.save(book2);

        for (int i = 0; i < 5; i++) {
            MagazineEntity magazine = new MagazineEntity();
            magazine.setTitle(faker.book().title());
            magazine.setOrderQty(faker.number().numberBetween(10, 1000));
            magazine.setCurrentIssue(new Date());
            magazine.setPrice(Double.parseDouble(faker.commerce().price(5, 20)));
            magazine.setCopies(faker.number().numberBetween(1, 100));
            magazineRepository.save(magazine);
        }

        for (int i = 0; i < 3; i++) {
            DiscMagEntity discMag = new DiscMagEntity();
            discMag.setTitle(faker.book().title());
            discMag.setOrderQty(faker.number().numberBetween(10, 1000));
            discMag.setCurrentIssue(new Date());
            discMag.setHasDisc(Boolean.parseBoolean(String.valueOf(faker.bool())));
            discMag.setPrice(Double.parseDouble(faker.commerce().price(8, 25)));
            discMag.setCopies(faker.number().numberBetween(1, 100));
            discMagRepository.save(discMag);
        }

        for (int i = 0; i < 7; i++) {
            TicketEntity ticket = new TicketEntity();
            ticket.setTitle(faker.team().name() + " Event");
            ticket.setDescription(faker.lorem().sentence());
            ticket.setPrice(Double.parseDouble(faker.commerce().price(20, 150)));
            ticket.setCopies(faker.number().numberBetween(1, 100));
            ticketRepository.save(ticket);
        }

        List<BookEntity> allBooks = bookRepository.findAll();
        if (allBooks.isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        System.out.println("--- Found Books ---");
        for (BookEntity book : allBooks) {
            System.out.println("ID: " + book.getId() +
                    ", Title: " + book.getTitle() +
                    ", Author: " + book.getAuthor() +
                    ", Price: $" + String.format("%.2f", book.getPrice()));
        }

        System.out.println("--- Julius Caesar's Books ---");
        List<BookEntity> caesarsBooks = bookRepository.findByAuthor("Julius Caesar");
        for (BookEntity book : caesarsBooks) {
            System.out.println("ID: " + book.getId() +
                    ", Title: " + book.getTitle() +
                    ", Author: " + book.getAuthor() +
                    ", Price: $" + String.format("%.2f", book.getPrice()));
        }

    }
}