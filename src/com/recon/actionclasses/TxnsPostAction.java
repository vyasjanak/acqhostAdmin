package com.recon.actionclasses;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import com.recon.formclasses.Txns;

import com.recon.dao.TxnsDao;
import com.recon.service.ReconService;
import com.recon.utils.PropUtility;


public class TxnsPostAction extends DispatchAction
{
	public static boolean inprogress;
	public ActionForward goToAddPage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		//Txns txnForm = (Txns) form;
		return mapping.findForward("add");
	}

	public ActionForward postBulktxns(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		TxnsDao txnDao = new TxnsDao();
		if(!inprogress)
		{
			inprogress = true;
			Txns txnForm = (Txns) form;
			String cycleDate = txnForm.getCycledate();
			String cycle = txnForm.getCycle();
			//boolean chkrecon = txnDao.checkDate(txnForm.getCycledate(),Integer.valueOf(txnForm.getCycle()));
			boolean chkrecon = txnDao.checkDate(cycleDate,Integer.valueOf(cycle));
			if (chkrecon)
			{
					//System.out.println("postBulktxns");
					System.out.println("TxnsPostAction---->");
					
					FormFile file = txnForm.getFile();
					System.out.println("File is : "+ file);
					String fileName = file.getFileName();
					String extension = file.getFileName().substring(file.getFileName().lastIndexOf(".")+1);
					System.out.println("Raw date file name :: "+file.getFileName());
					System.out.println("File extension is "+ extension);
					
					SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat targetFormat = new SimpleDateFormat("yyDDD");
					Date cDate = originalFormat.parse(cycleDate);
					String fname1 = PropUtility.getNameString("rawDataFile1")+targetFormat.format(cDate);
					String fname2 = PropUtility.getNameString("rawDataFile2")+targetFormat.format(cDate);
					
					boolean cycle1 = false, cycle2 = false;
					if(fileName.startsWith(fname1) && cycle.equals("1"))//PropUtility.getNameString("rawDataFile1")) && cycle.equals("1"))//rawDataFile1 //startsWith("861NGSB1830001")
					{
						cycle1 = true;
					}
					else if(fileName.startsWith(fname2) && cycle.equals("2"))//PropUtility.getNameString("rawDataFile2")) && cycle.equals("2"))//rawDataFile2
					{
						cycle2 = true;
					}
					
					
					if(cycle1 || cycle2)//if(file.getFileName().startsWith("861") || file.getFileName().startsWith("862"))
					{
						File newFile = getFilePath(file); 
						if(extension.equalsIgnoreCase("csv") && txnDao.isValidFile(newFile))
						{
							System.out.println("File Path is "+ newFile);
							String result = null;
							try
							{
								boolean flag = false; 
								flag = TxnsDao.checkCycle(cycleDate, cycle);	
								if(!flag)
								{
									if(!TxnsDao.checkFileProcessed(fileName))
									{
									System.out.println("FLAG value................ "+flag);
									List<Txns> txnList = new ArrayList<>();
									txnList = txnDao.txnCSVList(newFile);
									ReconService reconService = new ReconService();
									txnDao.insertTxns(txnList);
									//reconService.reconNPCI(cycleDate, cycle);//, fileName);
									    if(reconService.reconNPCI(cycleDate, cycle).equalsIgnoreCase("success"))
										{
											txnDao.insertCycle(cycleDate, cycle, fileName);
											//txnDao.insertCycle(txnForm.getCycledate(), txnForm.getCycle(), fileName);
											//txnEntity.checkreconStatus();
											result = "success";
											System.out.println("Transactions posted successfully");
						            		//request.setAttribute("posts", txnList);
						            		//ReconService txnEntity = new ReconService();
						            		List<Txns> summaryList = new ArrayList<>();
						            		summaryList = ReconService.getNPCIReconSummary();
						            		request.setAttribute("summaryList", summaryList);
						    				request.setAttribute("success", true);
						    				int total = txnDao.totalTxnCount(txnList);
						    				System.out.println("Total transactions are : "+total);
						    				request.setAttribute("total", total);
						    				txnForm.reset();
										}
									}
									else
									{
										System.out.println("This file already processed...............");
										request.setAttribute("filefailure", true);
									}
								}
								else
								{
									System.out.println("This date cycle already processed...............");
									request.setAttribute("cyclefailure", true);
									result = "fail";
									//txnForm.reset();
								}
				            }
				            catch(Exception e)
							{
				            	System.out.println("Exception in getting attribute : "+e.getMessage());
				            	e.printStackTrace();
							}
				    	}
					}					            
												       
					else	
					{
						System.out.println("Invalid file choosen...please upload file start with 861*/862*.csv file with given format");
						request.setAttribute("failure", true);
					}
			}
			else
			{
				String date = txnDao.latestDate();
				System.out.println("Date : "+date);
				request.setAttribute("date", date);
				System.out.println("Previous date recon not processed...............");
				request.setAttribute("datefailure", true);
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

