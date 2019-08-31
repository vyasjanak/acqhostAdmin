package com.recon.servlets;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XMLParser {
	
	public String createFinalResponse(String xmlData,String ErrorMessage) {
		String sResp = null;
		try{
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = factory.newDocumentBuilder();
		 InputSource is = new InputSource();
		 is.setCharacterStream(new StringReader(xmlData));
		 Document document = builder.parse(is);
		 document.getDocumentElement().normalize();
         System.out.println("Root element :" + document.getDocumentElement().getNodeName());
         NodeList nlist = document.getChildNodes();
         if(nlist.getLength()>0){
        	 JSONObject json = new JSONObject();
        	 /*json.put("resp_code","00");
        	 json.put("resp_message", "Success");*/
        	 NodeList nList = nlist.item(0).getChildNodes();        	 
        	 for(int i=0; i<nList.getLength();i++){
        		 Node nNode1 = nList.item(i);
            	 json.put(nNode1.getNodeName(), nNode1.getTextContent());
             }
        	 sResp = json.toString();
         }
         
		}catch (Exception e) {
			e.printStackTrace();
			sResp = new ErrorResponse().generateError(e.getMessage(), "NA", "EE");
		}
		System.out.println("Final Response :" + sResp);
		return sResp;
		
	}
	
	public static void main(String[] args) {
		String xmlData = "<WalletDetails><name>Rahul</name><mobileNo>9833700965</mobileNo><emailId>rahul_r_singh@hotmail.com</emailId><balance>2831.00</balance></WalletDetails>";
		new XMLParser().createFinalResponse(xmlData, "document");
		
	}

}
