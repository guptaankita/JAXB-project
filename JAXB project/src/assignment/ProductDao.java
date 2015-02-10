package assignment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ProductDao {
	
	public void save(Product product, Manufacturer manufacturer){
		JAXBContext jaxbcontext;
		try
		{
			File dir= new File("D:\\assignment6");
			if(!dir.exists()){
				dir.mkdir();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		File file = new File("D:\\assignment6\\catalog.xml");
		try{
			jaxbcontext= JAXBContext.newInstance(Catalog.class);
			if(!file.exists()){
				Catalog catalog= new Catalog();
				if(!manufacturer.getProducts().contains(product)){
					manufacturer.addproduct(product);
				}
				catalog.addmanufactures(manufacturer);
				Marshaller jaxbmarshaller = jaxbcontext.createMarshaller();
				jaxbmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbmarshaller.marshal(catalog, file);
				jaxbmarshaller.marshal(catalog, System.out);
				}
			else
			{
				int max=0;
				Unmarshaller jaxbunmarshaller= jaxbcontext.createUnmarshaller();
				Catalog catalog = (Catalog)jaxbunmarshaller.unmarshal(file);
				System.out.println(catalog);
				if(catalog.getManufacturers().contains(manufacturer))
				{
				int index=manufacturer.getProducts().indexOf(product);
				if(index >= 0){
					System.out.println("Product already exists");
					
				}
				else
				{
					for(Product p: manufacturer.getProducts())
					{
						if(p.getId()> max)
							max=p.getId();
					}
					product.setId(max+1);
					manufacturer.addproduct(product);
					
				}
				}
				else{
					manufacturer.addproduct(product);
					
				}
				catalog.addmanufactures(manufacturer);
				Marshaller marshall= jaxbcontext.createMarshaller();
				marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				marshall.marshal(catalog, file);
				marshall.marshal(catalog, System.out);
			}
			
		}catch(JAXBException e){
			e.printStackTrace();
				
			}
		}
	

	public Product find(int id){
		try{
			Product searchproduct=new Product();
			searchproduct.setId(id);
			File file=new File("D:\\assignment6\\catalog.xml");
			if(file.exists()){
				JAXBContext jaxbcontext= JAXBContext.newInstance(Catalog.class);
				Unmarshaller jaxbunmarshaller= jaxbcontext.createUnmarshaller();
				Catalog catalog=(Catalog)jaxbunmarshaller.unmarshal(file);
				System.out.println(catalog);
				for(Manufacturer m : catalog.getManufacturers())
				{
				int index= m.getProducts().indexOf(searchproduct);
				if(index >= 0)
				{
					return m.getProducts().get(index);
					
				}
				else
				{
					System.out.println("No product exist with this id");
				
				}
				}
			}
		}catch(JAXBException e){
			e.printStackTrace();
		}
		return null;
	}
		
	public List<Product> findAll() {
		try{
			File file = new File("D:\\assignment6\\product.xml");
			if(file.exists()){
				JAXBContext jaxbcontext = JAXBContext.newInstance(Manufacturer.class);
				Unmarshaller jaxbunmarshall= jaxbcontext.createUnmarshaller();
				Catalog catalog= (Catalog)jaxbunmarshall.unmarshal(file);
				System.out.println(catalog);
				List<Product> allProducts = new ArrayList<Product>();
				for(Manufacturer m: catalog.getManufacturers())
				{
					allProducts.addAll(m.getProducts());
				}
				return allProducts;
			}
		}catch(JAXBException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public void remove(int id){
		try
		{
			Product searchproduct=new Product();
			searchproduct.setId(id);
			File file = new File("D:\\assignment6\\product.xml");
			if(file.exists()){
				JAXBContext jaxbcontext= JAXBContext.newInstance(Catalog.class);
				Unmarshaller jaxbunmarshaller= jaxbcontext.createUnmarshaller();
				Catalog catalog=(Catalog)jaxbunmarshaller.unmarshal(file);
				System.out.println(catalog);
				for(Manufacturer m : catalog.getManufacturers())
				{
				int index= m.getProducts().indexOf(searchproduct);
				if(index >= 0)
				{
					m.getProducts().remove(index);
					break;
					
				}
				else
				{
					System.out.println("No product exist with the current manufacturer");
				
				}
				}
			
				Marshaller marshall= jaxbcontext.createMarshaller();
				marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				marshall.marshal(catalog, file);
				marshall.marshal(catalog, System.out);
			}
			
		}catch(JAXBException e){
			e.printStackTrace();
		}
	}
	
	public void update(Product product)
	{   try
	{
		File file=new File("D:\\assignment6\\catalog.xml");
		if(file.exists()){
			JAXBContext jaxbcontext= JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbunmarshaller= jaxbcontext.createUnmarshaller();
			Catalog catalog=(Catalog)jaxbunmarshaller.unmarshal(file);
			System.out.println(catalog);
			for(Manufacturer m : catalog.getManufacturers())
			{
			int index= m.getProducts().indexOf(product);
			
			if(index >= 0)
			{
				
				 m.getProducts().set(index, product);
				 
				
			}
			else
			{
				System.out.println("No product exist with this id");
			
			}
			
			}
			Marshaller jaxbmarshaller = jaxbcontext.createMarshaller();

			jaxbmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					true);
			jaxbmarshaller.marshal(catalog, file);
			jaxbmarshaller.marshal(catalog, System.out);
		}
	}catch(JAXBException e){
		e.printStackTrace();
	}
		
	}

}
