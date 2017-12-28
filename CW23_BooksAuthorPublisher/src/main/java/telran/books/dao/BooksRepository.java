package telran.books.dao;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import telran.books.entity.Author;
import telran.books.entity.Book;
import telran.books.entity.Publisher;
import telran.books.interfaces.IBooks;

@Repository
public class BooksRepository implements IBooks {
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public boolean addBook(Book book) {
		if (getBookByISBN(book.getIsbn()) != null) {
			return false;
		}
		Publisher publisher = book.getPublisher();
		if (em.find(Publisher.class, publisher.getPublisherName()) == null) {
			em.persist(publisher);
		}
		Set<Author> authors = book.getAuthors();
		for (Author author : authors) {
			if (em.find(Author.class, author.getName()) == null) {
				em.persist(author);
			}
		}
		em.persist(book);
		return true;
	}

	@Override
	@Transactional
	public boolean removeBook(long isbn) {
		Book book = getBookByISBN(isbn);
		if (book == null) {
			return false;
		}
		em.remove(book);
		return true;
	}

	@Override
	public Book getBookByISBN(long isbn) {
		return em.find(Book.class, isbn);
	}

	@Override
	public Iterable<Book> getBooksByAuthor(String authorName) {
		Query query = em.createQuery("select b from Book b join b.authors a where a.name=?1");
		query.setParameter(1, authorName);
		return query.getResultList();
	}

	@Override
	public Iterable<Book> getBooksByPublisher(String publisherName) {
		Query query = em.createQuery("select b from Book b join b.publisher p where p.publisherName=?1");
		query.setParameter(1, publisherName);
		return query.getResultList();
	}

	@Override
	public Iterable<Author> getBookAuthors(long isbn) {
		return getBookByISBN(isbn).getAuthors();
	}

	@Override
	public Iterable<Publisher> getPublishersByAuthor(String authorName) {
		Query query = em
				.createQuery("select distinct p from Book b join b.publisher p join b.authors a where a.name=?1");
		query.setParameter(1, authorName);
		return query.getResultList();
	}

}
