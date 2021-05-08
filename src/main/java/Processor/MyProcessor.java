package Processor;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import model.BookModel;



public class MyProcessor implements Processor {

  
	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		String body = exchange.getIn().getBody(String.class);
	    // change the message to say Hello
		
		File fXmlFile = new File("C:\\project\\src\\main\\java\\vb.xml");

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		
		NodeList nList = doc.getElementsByTagName("book");
		System.out.println("============================");
		  List<BookModel> BookModel = new ArrayList<BookModel>();
		  BookModel bookModel = null;
		for (int temp = 0; temp < nList.getLength(); temp++)
		{
		 Node node = nList.item(temp);
		 System.out.println("");    //Just a separator
		 if (node.getNodeType() == Node.ELEMENT_NODE)
		 {
		    //Print each employee's detail
			 bookModel=new BookModel();
		    Element eElement = (Element) node;
		    bookModel.setAuthor(eElement.getElementsByTagName("author").item(0).getTextContent());
		    bookModel.setTitle(eElement.getElementsByTagName("title").item(0).getTextContent());
		   bookModel.setGenre(eElement.getElementsByTagName("genre").item(0).getTextContent());
		   bookModel.setDescription(eElement.getElementsByTagName("description").item(0).getTextContent());
		   BookModel.add(bookModel);
		   
		    System.out.println("Book id : "    + eElement.getAttribute("id"));
		    System.out.println("author : "  + eElement.getElementsByTagName("author").item(0).getTextContent());
		    System.out.println("title : "   + eElement.getElementsByTagName("title").item(0).getTextContent());
		    System.out.println("genre : "    + eElement.getElementsByTagName("genre").item(0).getTextContent());
		    System.out.println("description : "    + eElement.getElementsByTagName("description").item(0).getTextContent());
		 }
		 
		}
		
		 exchange.getOut().setBody(BookModel);
	}
		
}		
		
		
		
//		NodeList booklist=doc.getElementsByTagName("book");
//		System.out.println("length"+booklist.getLength());
//		
//		for(int i=0;i<booklist.getLength();i++)
//		{
//			Node b=booklist.item(i);
//			System.out.println("item"+b.getNodeName());
//			if(b.getNodeType()==Node.ELEMENT_NODE)
//			{
//				Element book=(Element)b;
//				System.out.println("bokk"+book.getNodeValue());
//				String id=book.getAttribute("id");
//				System.out.println("id"+id);
//				NodeList namelist=book.getChildNodes();
//				for(int j=0;j<namelist.getLength();j++)
//				{
//					Node name=booklist.item(j);
//					
//					if(name.getNodeType()==Node.ELEMENT_NODE)
//					{
//						Element bookdetails=(Element)name;
//						String author=bookdetails.getElementsByTagName("author").item(0).getTextContent();
//						
//						System.out.println("resultauthor"+author);
//						
//						System.out.println("result"+bookdetails.getTagName()+""+bookdetails.getTextContent());
//					}
//					
//				}
//			}
//		}
//		
//	}




