package telran.books.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	long isbn;
	String title;
	@ManyToMany
	Set<Author> authors;
	@ManyToOne
	Publisher publisher;

	public Book() {
	}

	public Book(long isbn, String title, Set<Author> authors, Publisher publisher) {
		this.isbn = isbn;
		this.title = title;
		this.authors = authors;
		this.publisher = publisher;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", authors=" + authors + ", publisher=" + publisher + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (isbn ^ (isbn >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
		if (isbn != other.isbn) {
			return false;
		}
		return true;
	}

}
