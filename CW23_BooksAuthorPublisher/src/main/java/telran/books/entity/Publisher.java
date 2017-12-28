package telran.books.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Publisher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	String publisherName;
	@OneToMany(mappedBy = "publisher")
	@JsonIgnore
	Set<Book> books;

	public Publisher() {
	}

	public Publisher(String publisherName) {
		this.publisherName = publisherName;
		books = new HashSet<>();
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((publisherName == null) ? 0 : publisherName.hashCode());
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
		if (!(obj instanceof Publisher)) {
			return false;
		}
		Publisher other = (Publisher) obj;
		if (publisherName == null) {
			if (other.publisherName != null) {
				return false;
			}
		} else if (!publisherName.equals(other.publisherName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Publisher [publisherName=" + publisherName + "]";
	}

}
