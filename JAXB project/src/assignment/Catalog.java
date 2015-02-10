package assignment;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Catalog {
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
		Catalog other = (Catalog) obj;
		if (id != other.id)
			return false;
		return true;
	}

	int id;
	String name;
	List<Manufacturer> manufacturers;
	
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
	public List<Manufacturer> getManufacturers() {
		return manufacturers;
	}
	
	@XmlElementWrapper
	@XmlElement(name="Manufacturer")
	public void setManufacturers(List<Manufacturer> manufacturers) {
		this.manufacturers = manufacturers;
	}

	public void addmanufactures(Manufacturer m)
	{
		if(manufacturers==null)
		{
			manufacturers= new ArrayList<Manufacturer>();
		}
		manufacturers.add(m);
	}
	
	public void removemanufactures(Manufacturer m)
	{
		manufacturers.remove(m);
	}
}
