package com.enlamesa.back.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.enlamesa.back.model.WS_ST_Stocks_DT;
import com.enlamesa.back.utils.MyHandler;



@RestController
@RequestMapping("/test")
public class testController {

	@RequestMapping(method= RequestMethod.GET)
	public String getRestaurants(){
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

		try {

			File inputFile = new File("C:\\Users\\jaas1\\Desktop\\SAX\\feed.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			MyHandler handler = new MyHandler();
			saxParser.parse(inputFile, handler);     
			
			List <WS_ST_Stocks_DT> Elements = new ArrayList<WS_ST_Stocks_DT>();
			Elements = handler.getObjList();
			
			//Creamos las cabeceras del csv
			String cabecera = "";
			cabecera = cabecera + "NOMBRE_TIENDA" + ";";
			cabecera = cabecera + "REF" + ";";
			cabecera = cabecera + "EAN" + ";";
			cabecera = cabecera + "STOCK" + ";" + "\r\n";
			String line = "";
			System.out.print(cabecera);
			for(int i = 0; i < Elements.size();i++) {
				line += 
						Elements.get(i).getId_Tpv()+";"+
						Elements.get(i).getId_Articulo()+";"+
						Elements.get(i).getEAN()+";"+
						Elements.get(i).getStock();	
			}

			
			File tempFile = new File("C:\\Users\\jaas1\\Desktop\\SAX\\stockAux.xml");
			if (tempFile.createNewFile()) {
				FileWriter myWriter = new FileWriter("C:\\Users\\jaas1\\Desktop\\SAX\\stockAux.xml");
				myWriter.write(line);
				myWriter.close();
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		
		
		
		
		return "OK";
	}

}
