package vn.techmaster.firstweb.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import vn.techmaster.firstweb.model.Book;
import vn.techmaster.firstweb.request.UpsertBookRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BookService {
    private List<Book> books;

    public BookService() {
        books = new ArrayList<>();
        books.add(new Book(1, "Book1", "Des1", 2022));
        books.add(new Book(2, "Book2", "Des2", 2021));
        books.add(new Book(3, "Book3", "Des3", 2025));
        books.add(new Book(4, "Book4", "Des4", 2024));
        books.add(new Book(5, "Book5", "Des5", 2023));

    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookById(int id) {
//        return  books.stream().map(Book::getId).filter(n -> n == id);
//
        for (Book book : books) {
            if (book.getId() == id) return book;
        }

        return null;
    }

    public Book createBook(UpsertBookRequest request) {
        Random rd = new Random();
        int id = rd.nextInt(1000);

        Book book = new Book(
                id,
                request.getTitle(),
                request.getDescription(),
                request.getPublishYear()
        );
        books.add(book);
        return book;
    }

    public Book updateBook(int id, UpsertBookRequest request) {
        Book book = getBookById(id);

        book.setTitle(request.getTitle());
        book.setDescription(request.getDescription());
        book.setPublishYear(request.getPublishYear());
        return book;
    }

    public void deleteBook(int id) {
        Book book = getBookById(id);
        books.remove(book);
    }
}
