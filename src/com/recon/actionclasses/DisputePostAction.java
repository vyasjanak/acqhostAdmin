package com.recon.actionclasses;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.util.DateUtil;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import com.recon.formclasses.Dispute;
import com.recon.utils.DBConnectionHandler;
import com.recon.dao.DisputeDao;
/*import com.recon.service.ReconService;*/
//import com.recon.formclasses.IBPSForm;






public class DisputePostAction extends DispatchAction
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
		DisputeDao disputeDao = new DisputeDao();
		if(!inprogress)
		{
			inprogress = true;
			Dispute txnForm = (Dispute) form;
					
			System.out.println("DisputePostAction---->");
			
			FormFile file = txnForm.getFile();
			System.out.println("File is : "+ file);
			
			FormFile file1 = txnForm.getFile();
			System.out.println("New File is : "+ file1);
			
			String extension = file.getFileName().substring(file.getFileName().lastIndexOf(".")+1);
			
			System.out.println("File extension is "+ extension);
			
			if(extension.equalsIgnoreCase("csv"))
			{
			
			File newFile = getFilePath(file); 
			System.out.println("File Path is "+ newFile);
			}
			
			
			if(extension.equalsIgnoreCase("csv"))
			{
				File newFile = getFilePath(file); 
				System.out.println("File Path is "+ newFile);
				String result = null;		
				try
				{
					List<Dispute> txnList = new ArrayList<>();
					
					txnList = disputeDao.txnCSVList(newFile);
					
					disputeDao.insertDisputeTxns(txnList);
					result = "success";
					if (result.equals("success")) 
	    			{
						
	            		System.out.println("Dispute transactions posted successfully");
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
	            	System.out.println("DisputePostAction :: Exception in getting attribute : "+e.getMessage());
	            	e.printStackTrace();
				}
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
	
	
	
	
	 public static void main(String a[]){
         	//for after 
	        /*Date current = new Date();
	        //create a date one day after current date
	        long nextDay = System.currentTimeMillis() + 1000*60*60*24;
	        //create date object
	        Date next = new Date(nextDay);
	        System.out.println("current : "+current);
	        System.out.println("nextDay : "+nextDay);
	        System.out.println("next : "+next);
	        //compare both dates
	        if(next.after(current)){
	            System.out.println("The date is future day");
	        } else {
	            System.out.println("The date is older than current day");
	        }*/
		 	//for before 
		 	Date current = new Date();
	        //create a date one day before current date
	        long prevDay = System.currentTimeMillis() - 1000*60*60*24;
	        //create date object
	        Date prev = new Date(prevDay);
	        //compare both dates
	        if(prev.before(current)){
	            System.out.println("The date is older than current day");
	        } else {
	            System.out.println("The date is future day");
	        }
	        List<Date> dates = new ArrayList<>();
	        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
	        String ondate;
	        Date date=null;
			try
			{
				//String sql = "SELECT on_date FROM npci_recon_status";
				String sql = "SELECT on_date FROM npci_recon_status";
				Connection conn = new DBConnectionHandler().getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
		        while (rs.next()) {
		        	//sdf.format(rs.getDate(1));
		        	//System.out.println(sdf.format(rs.getString(1)));
		        	ondate = (rs.getString(1));
		        	date = df.parse(ondate);
		        	dates.add(date);
		        }
			}
			catch(Exception e)
			{
				
			}
	        System.out.println(dates);
	        Date latest = Collections.max(dates);
	        System.out.println(latest);
	        DateFormat df1 = new SimpleDateFormat("dd/mm/yyyy"); 
	        try
	        {
	        Date cur = null;
	        String start_dt = "22/04/2018";
	        DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy"); 
	        cur = (Date)formatter.parse(start_dt);
	        //Date cur = new Date();
	        if(latest.before(cur)){
	        	System.out.println("Current date  : " +cur);
	        	System.out.println("Latest date get from db : "+latest);
	            System.out.println("The date is older than current day");
	        } else {
	            System.out.println("The date is future day");
	        }
	        }
	        catch(Exception e){}
	        
	        String sourceDate = "22/04/2018";
	        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
	        Date myDate = null;
			try {
				myDate = format.parse(sourceDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //myDate = DateUtil.addDays(myDate, 1);
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(myDate);
	        cal.add(Calendar.DATE, 1); //minus number would decrement the days
	        myDate = cal.getTime();
	        System.out.println(myDate);
	        //return cal.getTime();
	    }
}


