package com.enlamesa.back.utils;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.enlamesa.back.model.WS_ST_Stocks_DT;


public class MyHandler extends DefaultHandler{

	private List<WS_ST_Stocks_DT> objList = null; 
	private WS_ST_Stocks_DT xmlObjeto = null;
	private StringBuilder data = null;


	public List<WS_ST_Stocks_DT> getObjList() {
		return objList;
	}

	boolean bId_Tpv = false;
	boolean bEAN = false;
	boolean bStock = false;
	boolean bId_Articulo = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("WS_ST_Stocks_DT")) {
			
			// initialize Employee object and set id attribute
			xmlObjeto = new WS_ST_Stocks_DT();
			// initialize list
			if (objList == null)
				objList = new ArrayList<>();
		} else if (qName.equalsIgnoreCase("Id_Tpv")) {
			bId_Tpv = true;
		} else if (qName.equalsIgnoreCase("EAN")) {
			bEAN = true;
		} else if (qName.equalsIgnoreCase("Stock")) {
			bStock = true;
		} else if (qName.equalsIgnoreCase("Id_Articulo")) {
			bId_Articulo = true;
		}
		// create the data container
		data = new StringBuilder();
	}
	
	
	
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (bId_Tpv) {
			
			xmlObjeto.setId_Tpv(data.toString());
			
			bId_Tpv = false;
		} else if (bEAN) {
			xmlObjeto.setEAN(data.toString());
			bEAN = false;
		} else if (bStock) {
			xmlObjeto.setStock(data.toString());
			bStock = false;
		} else if (bId_Articulo) {
			xmlObjeto.setId_Articulo(data.toString());
			bId_Articulo = false;
		}
		
		if (qName.equalsIgnoreCase("WS_ST_Stocks_DT")) {
			// add Employee object to list
			objList.add(xmlObjeto);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		data.append(new String(ch, start, length));
	}
	
	
	
	


}
