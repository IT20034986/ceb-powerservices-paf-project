package com;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.google.gson.*;

import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.Inquiry;

@Path("/Inquiry")
public class InquiryService {
	Inquiry inquiryObj = new Inquiry();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readInquiry() {
		return inquiryObj.readInquiry();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertInquiry(@FormParam("cust_name") String cust_name,			
	 @FormParam("acc_num") String acc_num,
	 @FormParam("area") String area,
	 @FormParam("date") String date,
	 @FormParam("reason") String reason)
	{
	 String output = inquiryObj.insertInquiry(cust_name, acc_num, area, date, reason);
	
	 return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateInquiry(String Inquiry_Data)
	{
	
	 JsonObject INQObject = new JsonParser().parse(Inquiry_Data).getAsJsonObject();
	//Read the values from the JSON object
	 String Iqid = INQObject.get("Iqid").getAsString();
	 String cust_name = INQObject.get("cust_name").getAsString();
	 String acc_num = INQObject.get("acc_num").getAsString();
	 String area = INQObject.get("area").getAsString();
	 String date = INQObject.get("date").getAsString();
	 String reason = INQObject.get("reason").getAsString();
	 String output = inquiryObj.updateInquiry(Iqid, cust_name, acc_num, area, date, reason);
	return output;
	} 
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteInquiry(String Inquiry_Data)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(Inquiry_Data, "", Parser.xmlParser());

	//Read the value from the element
	 String Iqid = doc.select("Iqid").text();
	 String output = inquiryObj.deleteInquiry(Iqid);
	return output;
	}
}
