package assignment;

import java.util.Date;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Book {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}

	int id;
	String isbn;
	String title;
	String author;
	String genre;
	Date date_published;
	String synopsis;
	
	
	public int getId() {
		return id;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}
	
	@XmlElement
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	
	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	
	@XmlElement
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Date getDate_published() {
		return date_published;
	}
	
	@XmlElement
	public void setDate_published(Date date_published) {
		this.date_published = date_published;
	}
	public String getSynopsis() {
		return synopsis;
	}
	
	@XmlElement
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	

}
