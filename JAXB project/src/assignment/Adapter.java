package assignment;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Adapter {

	public static void toAcme(String input, String tx, String output)
			throws IOException, URISyntaxException, TransformerException {

		TransformerFactory factory = new net.sf.saxon.TransformerFactoryImpl();
		Source xslt = new StreamSource(new File(tx));
		Transformer transformer = factory.newTransformer(xslt);

		Source text = new StreamSource(new File(input));
		transformer.transform(text, new StreamResult(new File(output)));
	}
	
	public static void toBcc(String input, String tx, String output)
			throws IOException, URISyntaxException, TransformerException {

		TransformerFactory factory = new net.sf.saxon.TransformerFactoryImpl();
		Source xslt = new StreamSource(new File(tx));
		Transformer transformer = factory.newTransformer(xslt);

		Source text = new StreamSource(new File(input));
		transformer.transform(text, new StreamResult(new File(output)));
	}


	public static void main(String[] args) throws IOException,
			URISyntaxException, TransformerException {
              
		
				Adapter.toAcme(
						"D:\\assignment6\\library.xml",
						"F:\\eclipseprojects\\Assignment6\\src\\assignment\\bcctoacme.xsl",
						"D:\\assignment6\\transformtoacme.xml");
				
				Adapter.toBcc(
						"D:\\assignment6\\catalog.xml",
						"F:\\eclipseprojects\\Assignment6\\src\\assignment\\acmetobcc.xsl",
						"D:\\assignment6\\transformtobcc.xml");

	}
}