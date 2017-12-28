package telran.books.interfaces;

import telran.books.entity.Author;
import telran.books.entity.Book;
import telran.books.entity.Publisher;

public interface IBooks {

	boolean addBook(Book book);

	boolean removeBook(long isbn);

	Book getBookByISBN(long isbn);

	Iterable<Book> getBooksByAuthor(String authorName);

	Iterable<Book> getBooksByPublisher(String publisherName);

	Iterable<Author> getBookAuthors(long isbn);

	Iterable<Publisher> getPublishersByAuthor(String authorName);

}
