package assignment;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class BookJaxb {
       public static void main(String args[]) {
    	   
    	   
    	   Book book = new Book();
    	   book.setId(5);
    	   book.setIsbn("aa");
    	   book.setTitle("coding");
    	   book.setAuthor("ankita");
    	   book.setGenre("rr");
    	   book.setDate_published(new Date("11/11/1989"));
    	   book.setSynopsis("ssrr");
         BookDao dao = new BookDao();
         dao.save(book);
         
         
         
       Book book1 = new Book();
  	   book1.setId(5);
  	   book1.setIsbn("aagdgdgddf");
  	   book1.setTitle("codingfggfgf");
  	   book1.setAuthor("ankita");
  	   book1.setGenre("rrfvdgdf");
  	   book1.setDate_published(new Date("11/11/1989"));
  	   book1.setSynopsis("ssrrfgdgdf");
        dao.update(book1);
        dao.remove(2);
        dao.findbyid(3);
        
         Catalog catalog = new Catalog();
         catalog.setId(2);
         catalog.setName("first");
         Manufacturer m = new Manufacturer();
         m.setId(2);
         m.setName("second");
         Product p =new Product();
         p.setSku("aa11");
         p.setCategory("bb");
         p.setDate_avaliable(new Date());
         p.setPrice(108.9f);
         p.setSubcategory("cc");
         p.setDescription("dd");
         m.addproduct(p);
         ManufacturerDao d =new ManufacturerDao();
         d.save(m);
       }
}
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
    	   
    	   
    	   
