package assignment;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Library {
     
	int id;
	String name;
	List<Book> books;
	
	public int getId() {
		return id;
	}
    @XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getBooks() {
		return books;
	}
	
	 @XmlElementWrapper
	 @XmlElement(name="Book")
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	 
	 public void addbook(Book b)
	 {  if(books==null)
	 {
		 books=new ArrayList<Book>();
	 }
		 books.add(b);
	 }
	 
	 public void removebook(Book b)
	 {
		 books.remove(b);
	 }
}
