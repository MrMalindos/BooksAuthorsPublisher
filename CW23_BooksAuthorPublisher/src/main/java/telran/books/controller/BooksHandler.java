package telran.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import telran.books.entity.Author;
import telran.books.entity.Book;
import telran.books.entity.Publisher;
import telran.books.interfaces.IBookConstants;
import telran.books.interfaces.IBooks;

@RestController
public class BooksHandler {
	@Autowired
	IBooks books;

	@PostMapping(IBookConstants.BOOK)
	public boolean addBook(@RequestBody Book book) {
		return books.addBook(book);
	}

	@DeleteMapping({ IBookConstants.BOOK + "/{isbn}" })
	public boolean removeBook(@RequestParam long isbn) {
		return books.removeBook(isbn);
	}

	@GetMapping({ IBookConstants.BOOK + "/{isbn}" })
	public Book getBookByISBN(@PathVariable long isbn) {
		return books.getBookByISBN(isbn);
	}

	@GetMapping({ IBookConstants.BOOKS + "/{authorName}" })
	public Iterable<Book> getBooksByAuthor(@PathVariable String authorName) {
		return books.getBooksByAuthor(authorName);
	}

	@GetMapping({ IBookConstants.PUBLISHER + "/{publisherName}" })
	public Iterable<Book> getBooksByPublisher(@PathVariable String publisherName) {
		return books.getBooksByPublisher(publisherName);
	}

	@GetMapping({ IBookConstants.AUTHORS + "/{isbn}" })
	public Iterable<Author> getBookAuthors(@PathVariable long isbn) {
		return books.getBookAuthors(isbn);
	}

	@GetMapping({ IBookConstants.PUBLISHERS + "/{authorName}" })
	public Iterable<Publisher> getPublishersByAuthor(@PathVariable String authorName) {
		return books.getPublishersByAuthor(authorName);
	}
}
