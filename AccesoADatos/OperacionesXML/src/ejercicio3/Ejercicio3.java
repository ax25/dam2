package ejercicio3;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import java.util.*;

public class Ejercicio3 {
	public static void main(String args[]){
		try{
			SAXBuilder builder=new SAXBuilder();
			Document doc=builder.build("Ejercicio3.xml");
			Element root=doc.getRootElement();
			
			/*1.A�adir un atributo a autor de tipo cat1 que sea siglo=XXI*/
			List<Element> elementos=root.getChildren();
			Iterator it=elementos.iterator();
			while(it.hasNext()){
				Element cat=(Element)it.next();
				if(cat.getAttributeValue("tipo").equals("cat1")){
					cat.setAttribute("siglo","XXI");
				}
			}
			new XMLOutputter().output(doc,System.out);
			
			/*2.Borrar las direcciones de todos los autores*/
			System.out.println("\nSegunda parte\n");
			Iterator it2=elementos.iterator();
			while(it2.hasNext()){
				Element hautor=(Element)it2.next();
				System.out.println(hautor);
				hautor.removeChild("direccion");
			}
			new XMLOutputter().output(doc,System.out);
			
			/*3.A�adir una etiqueta nueva para el primer y tercer autor
<premio> cervantes</premio>
<Pelicula> alatriste</pelicula>*/
			System.out.println("\nTercera parte\n");
			Element premio=new Element("premio");
			premio.setText("cervantes");
			Element pelicula=new Element("pelicula");
			pelicula.setText("alatriste");
			
			elementos.get(0).addContent(premio);
			elementos.get(0).addContent(pelicula);
			
			Element premio2=new Element("premio");
			premio2.setText("cervantes");
			Element pelicula2=new Element("pelicula");
			pelicula2.setText("alatriste");
			elementos.get(2).addContent(premio2);
			elementos.get(2).addContent(pelicula2);
			new XMLOutputter().output(doc,System.out);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
