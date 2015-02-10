package assignment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class BookDao {

	public void save(Book book) {
		JAXBContext jaxbcontent;
		try {
			File dir = new File("D:\\assignment6");
			if (!dir.exists()) {
				dir.mkdir();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		File file = new File("D:\\assignment6\\library.xml");

		try {
			jaxbcontent = JAXBContext.newInstance(Library.class);
			if (!file.exists()) {
               
				Library library = new Library();
				library.setName("FirstLibrary");
				library.addbook(book);

				Marshaller jaxbmarshaller = jaxbcontent.createMarshaller();

				jaxbmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				jaxbmarshaller.marshal(library, file);
				jaxbmarshaller.marshal(library, System.out);
			} else {
				int max=0;
				Unmarshaller jaxbUnmarshaller = jaxbcontent
						.createUnmarshaller();
				Library library = (Library) jaxbUnmarshaller.unmarshal(file);
				System.out.println(library);
				int index = library.getBooks().indexOf(book);
				if(index >= 0) {
					System.out.println("Book aleady exist with the same id");
				} else {
					
				for (Book b:library.getBooks())
				{
					if(b.getId()>max)
						max=b.getId();
					    
				}
				
				book.setId(max+1);
				library.addbook(book);
				}
				
		
				Marshaller jaxbmarshaller = jaxbcontent.createMarshaller();

				jaxbmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				jaxbmarshaller.marshal(library, file);
				jaxbmarshaller.marshal(library, System.out);
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	
	public Book findbyid(int id)
	{
		try {
			Book searchBook = new Book();
			searchBook.setId(id);
			File file = new File("D:\\assignment6\\library.xml");
			if (file.exists()){
			JAXBContext jaxbcontent = JAXBContext.newInstance(Library.class);
			Unmarshaller jaxbUnmarshaller = jaxbcontent.createUnmarshaller();
			Library library = (Library) jaxbUnmarshaller.unmarshal(file);
			System.out.println(library);
			int index = library.getBooks().indexOf(searchBook);
			if(index >= 0) {
				return library.getBooks().get(index);
			} else {
				System.out.println("Book is lost!!");
			}
			
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Book> findAll()
	{
		try {
			
			File file = new File("D:\\assignment6\\library.xml");
			if (file.exists()){
			JAXBContext jaxbcontent = JAXBContext.newInstance(Library.class);
			Unmarshaller jaxbUnmarshaller = jaxbcontent.createUnmarshaller();
			Library library = (Library) jaxbUnmarshaller.unmarshal(file);
			System.out.println(library);
			
				return library.getBooks();
			
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void remove(int id)
	{
       try {
			
			File file = new File("D:\\assignment6\\library.xml");
			if (file.exists()){
			JAXBContext jaxbcontent = JAXBContext.newInstance(Library.class);
			Unmarshaller jaxbUnmarshaller = jaxbcontent.createUnmarshaller();
			Library library = (Library) jaxbUnmarshaller.unmarshal(file);
			System.out.println(library);
			Book b= new Book();
			b.setId(id);
			library.getBooks().remove(b);
			
			Marshaller jaxbmarshaller = jaxbcontent.createMarshaller();

			jaxbmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					true);
			jaxbmarshaller.marshal(library, file);
			jaxbmarshaller.marshal(library, System.out);
			
			}	
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void update(Book book) {
		try {
	
			File file = new File("D:\\assignment6\\library.xml");
			if (file.exists()){
			JAXBContext jaxbcontent = JAXBContext.newInstance(Library.class);
			Unmarshaller jaxbUnmarshaller = jaxbcontent.createUnmarshaller();
			Library library = (Library) jaxbUnmarshaller.unmarshal(file);
			System.out.println(library);
			List<Book> allBooks;
			allBooks=library.getBooks();
			int index = allBooks.indexOf(book);
			if(index >= 0) {
				allBooks.set(index, book);
				library.setBooks(allBooks);
				
			} else {
				System.out.println("No such book exists");
			}
		
			Marshaller jaxbmarshaller = jaxbcontent.createMarshaller();

			jaxbmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					true);
			jaxbmarshaller.marshal(library, file);
			jaxbmarshaller.marshal(library, System.out);
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}