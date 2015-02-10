package assignment;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ManufacturerDao {
	
	public void save(Manufacturer manufacturer){
		JAXBContext jaxbcontext;
		try{
			File dir = new File("D:\\assignment6");
			if(!dir.exists()){
				dir.mkdir();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		
		File file = new File("D:\\assignment6\\catalog.xml");
		try{
			jaxbcontext= JAXBContext.newInstance(Catalog.class);
			if(!file.exists()){
				Catalog catalog= new Catalog();
				catalog.setName("FirstCatalog");
				catalog.addmanufactures(manufacturer);
				Marshaller jaxbmarshaller = jaxbcontext.createMarshaller();
				jaxbmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbmarshaller.marshal(catalog, file);
				jaxbmarshaller.marshal(catalog, System.out);
				
			}
			else{
				int max=0;
				Unmarshaller unmarshaller= jaxbcontext.createUnmarshaller();
				Catalog catalog= (Catalog)unmarshaller.unmarshal(file);
				System.out.println(catalog);
				int index= catalog.getManufacturers().indexOf(manufacturer);
				if(index >= 0){
					System.out.println("Manufacturer already exist with the same id");
				}
				else{
					for(Manufacturer m : catalog.getManufacturers())
					{
						if(m.getId()> max)
						{
							max= m.getId();
						}
					}
					manufacturer.setId(max+1);
					catalog.addmanufactures(manufacturer);
				}
				
				Marshaller marshaller=jaxbcontext.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				marshaller.marshal(catalog, file);
				marshaller.marshal(catalog, System.out);
				
			}
			
		}catch(JAXBException e){
			e.printStackTrace();
		}
	}

	
	
	public Manufacturer find(int id){
		try{
			Manufacturer searchmanufacturer= new Manufacturer();
			searchmanufacturer.setId(id);
			File file = new File("D:\\assignment6\\catalog.xml");
			if(file.exists())
			{
				JAXBContext jaxbcontext= JAXBContext.newInstance(Catalog.class);
				Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
				Catalog catalog= (Catalog) unmarshaller.unmarshal(file);
				System.out.println(catalog);
				int index= catalog.getManufacturers().indexOf(searchmanufacturer);
				if(index >= 0)
				{
					return catalog.getManufacturers().get(index);
					
				} else
				{
					System.out.println("No manufacturer found with the given id");
				}
				
				
			}
		}catch(JAXBException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Manufacturer> findAll(){
		try
		{
			File file = new File("D:\\assignment6\\catalog.xml");
			if(file.exists()){
				JAXBContext jaxbcontext = JAXBContext.newInstance(Catalog.class);
				Unmarshaller jaxbmarshaller= jaxbcontext.createUnmarshaller();
				Catalog catalog= (Catalog)jaxbmarshaller.unmarshal(file);
				System.out.println(catalog);
				return catalog.getManufacturers();
				
			}
		}catch(JAXBException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public void remove(int id)
	{
		try{
			File file = new File("D:\\assignment6\\catalog.xml");
			if(file.exists())
			{
				JAXBContext jaxbcontext= JAXBContext.newInstance(Catalog.class);
				Unmarshaller jaxbunmarshaller= jaxbcontext.createUnmarshaller();
				Catalog catalog= (Catalog)jaxbunmarshaller.unmarshal(file);
				System.out.println(catalog);
				Manufacturer m = new Manufacturer();
				m.setId(id);
				catalog.getManufacturers().remove(m);
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
	
	public void update(Manufacturer manufacturer) {
		try {
	
			File file = new File("D:\\assignment6\\catalog.xml");
			if (file.exists()){
			JAXBContext jaxbcontent = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbcontent.createUnmarshaller();
			Catalog catalog = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(catalog);
			List<Manufacturer> allManufacturer;
			allManufacturer=catalog.getManufacturers();
			int index = allManufacturer.indexOf(manufacturer);
			if(index >= 0) {
				allManufacturer.set(index, manufacturer);
				catalog.setManufacturers(allManufacturer);
				
			} else {
				System.out.println("No such manufacturer exists");
			}
		
			Marshaller jaxbmarshaller = jaxbcontent.createMarshaller();

			jaxbmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					true);
			jaxbmarshaller.marshal(catalog, file);
			jaxbmarshaller.marshal(catalog, System.out);
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
}
