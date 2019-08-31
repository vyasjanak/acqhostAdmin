package com.recon.actionclasses;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DownloadAction;

import com.recon.formclasses.DisputeRaiseForm;

public class VehiclePicDownload extends DownloadAction 
{
	protected StreamInfo getStreamInfo(ActionMapping mapping,  ActionForm form,   HttpServletRequest request,  HttpServletResponse response) throws Exception 
	{
	 	DisputeRaiseForm disputeRaiseForm = (DisputeRaiseForm) form;
        String fileName = request.getParameter("tps_txn_id");
        //String filePath=mapping.getParameter();
        
        String path = getServlet().getServletContext().getRealPath("/");
		String filePath = path.split("webapps")[0]+"Documents"+File.separator+"TPS"+File.separator+fileName.substring(fileName.indexOf("_")+1);
		fileName = fileName+".jpg";
		
		System.out.println("VehiclePicDownload.java ::: File to Download :: "+fileName+" from Path : "+filePath);
		
        response.setHeader("Content-disposition",   "attachment; filename=" + fileName);
        String contentType = "application/pdf";
        File file = new File(filePath,fileName);
        return new FileStreamInfo(contentType, file);
        
        //String filePath1 = "E:/PG/Apr-May/disputedTxnsDocs/"; //+File.separator+fileName;
        /* String acq_txn_id = disputeRaiseForm.getAcq_txn_id();
        String acq_txn_id1 = request.getParameter("acq_txn_id");
        System.out.println("acq_txn_id Form ::"+acq_txn_id);
        System.out.println("acq_txn_id1 parameter ::"+acq_txn_id1);
        
        String actionName = request.getParameter("actionName");
        System.out.println("actionName parameter ::"+actionName);*/
        //acq_txn_id.
        
		/*File file1 = new File(filePath1);
        //File[] files = file1.listFiles();
        List fileList = new ArrayList<>();
        File[] files = file1.listFiles();
        for(File f: files){
        	fileList.add(f.getName());
            System.out.println("List of files ::"+f.getName());
        }*/
        //request.setAttribute("fileList", fileList);*/
        
        //System.out.println("fileName1 ::"+fileName);
 	}
}

