package assignment;

import java.util.Date;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Product {
	int id;
	String sku;
	String name;
	String description;
	Float price;
	String category;
	String subcategory;
	Date date_avaliable;
	
	
	public int getId() {
		return id;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}
	
	@XmlElement
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getPrice() {
		return price;
	}
	
	@XmlElement
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	
	@XmlElement
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	
	@XmlElement
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public Date getDate_avaliable() {
		return date_avaliable;
	}
	
	@XmlElement
	public void setDate_avaliable(Date date_avaliable) {
		this.date_avaliable = date_avaliable;
	}

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
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
