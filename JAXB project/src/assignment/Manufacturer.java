package assignment;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Manufacturer {
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
		Manufacturer other = (Manufacturer) obj;
		if (id != other.id)
			return false;
		return true;
	}

	int id;
	String name;
	List<Product> products;
	
	
	
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
	public List<Product> getProducts() {
		return products;
	}
	
	 @XmlElementWrapper
	 @XmlElement(name="Product")
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	 
	 public void addproduct(Product p)
	 {   if(products==null)
	 {
		 products= new ArrayList<Product>();
	 }
		 products.add(p);
	 }
	 
	 public void removeproduct(Product p)
	 {
		 products.remove(p);
	 }

}
