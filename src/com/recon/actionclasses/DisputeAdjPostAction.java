package com.recon.actionclasses;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;*/
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import javax.servlet.http.HttpSession;*/

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import com.recon.formclasses.DisputeAdjForm;
import com.recon.dao.DisputeAdjDao;
/*import com.recon.utils.DBConnection;*/



public class DisputeAdjPostAction extends DispatchAction
{
	public static boolean inprogress;
	public ActionForward goToAddPage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		return mapping.findForward("add");
	}

	public ActionForward postDisputeActionData(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		DisputeAdjDao disputeAdjDao = new DisputeAdjDao();
		if(!inprogress)
		{
			inprogress = true;
			DisputeAdjForm txnForm = (DisputeAdjForm) form;
					
			System.out.println("DisputeAdjPostAction---->");
			
			FormFile file = txnForm.getFile();
			System.out.println("File is : "+ file);
			
			String extension = file.getFileName().substring(file.getFileName().lastIndexOf(".")+1);
			System.out.println("File extension is "+ extension);
			
			File newFile = getFilePath(file);
			if(extension.equalsIgnoreCase("csv") && disputeAdjDao.isValidFile(newFile))
			{
				System.out.println("File Path is "+ newFile);
				String result = null;		
				try
				{
					List<DisputeAdjForm> txnList = new ArrayList<>();
					txnList = disputeAdjDao.txnCSVList(newFile);
					disputeAdjDao.insertDisputeAdjTxns(txnList);
					result = "success";
					if (result.equals("success")) 
	    			{
	            		System.out.println("Dispute adjustment transactions posted successfully");
	            		request.setAttribute("posts", txnList);
	    				request.setAttribute("success", true);
	    				txnForm.reset();
	    			} 
	    			else 
	    			{
	    				System.out.println("Transactions could not post, please check again...");
	    				request.setAttribute("failure", true);
	    				txnForm.reset();
	    			}
	            }
	            catch(Exception e)
				{
	            	System.out.println("DisputeAdjPostAction :: Exception in getting attribute : "+e.getMessage());
	            	e.printStackTrace();
				}
			}
			
			else
			{
				System.out.println("File format is mismatch or number of columns not 47, please upload correct .csv file only");
				request.setAttribute("formatfailure", true);
				txnForm.reset();
			}
		}
			
		else
		{	
			System.out.println("File Process in progress...............");
			request.setAttribute("inprogressfailure", true);
		}
		inprogress=false;					
		
		return mapping.findForward("add");
	}


	private File getFilePath(FormFile formfile) throws IOException {
		//Get the servers upload directory real path name
		File file = null;
	    String filePath = getServlet().getServletContext().getRealPath("/") +"uploadedTxns";
	    
	    //create the upload folder if not exists
	    File folder = new File(filePath);
	    if(!folder.exists()){
	    	folder.mkdir();
	    }
	    
	    String fileName = formfile.getFileName();
	    
	    if(!("").equals(fileName)){  
	    	
	        System.out.println("Server path:" +filePath);
	        File newFile = new File(filePath, fileName);
              
	        if(newFile.exists()){
	        	newFile.delete();
	        }
            FileOutputStream fos = new FileOutputStream(newFile);
            fos.write(formfile.getFileData());
            fos.flush();
            fos.close();
	          
	        file = newFile;
	        System.out.println("uploadedFilePath--->"+newFile.getAbsoluteFile());
	        System.out.println("uploadedFileName---->"+newFile.getName());
	    }
	    
	    return file;
	}
	
	public String convertDate(String input)
	{
		String output=null;
		input = "Mon Jun 18 00:00:00 IST 2012";
		DateTimeFormatter f = DateTimeFormatter.ofPattern( "E MMM dd HH:mm:ss z yyyy" ).withLocale( Locale.US );
		ZonedDateTime zdt = ZonedDateTime.parse( input , f );
		LocalDate ld = zdt.toLocalDate();
		DateTimeFormatter fLocalDate = DateTimeFormatter.ofPattern( "dd-MM-yyyy" );
		output=ld.format( fLocalDate);
		return output;
	}
}