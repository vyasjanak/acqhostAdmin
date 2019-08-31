package com.recon.actionclasses;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.*;


public class DownloadAccoiunt extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public DownloadAccoiunt() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try
		{
			//String fromDate2 = session.getAttribute("fromdate_session").toString();
			//String toDate2 = session.getAttribute("todate_session").toString();
			HSSFWorkbook hwb = new HSSFWorkbook();
			int count = Integer.parseInt(request.getParameter("count"));
			int Rowcount = Integer.parseInt(request.getParameter("Rowcount"));
			String downloadType = request.getParameter("downloadType");
			String headerNamesvalues = request.getParameter("headerNames");
			String headerNames =  headerNamesvalues.substring(1, headerNamesvalues.length()-1); // split '[' and ']' from header
			
			String resultDataValues = request.getParameter("resultData");
			String resultData =  resultDataValues.substring(1, resultDataValues.length()-1);
			
			String para = "Report";
			String valuelist = null;

			
			System.out.println("Column Length = "+count);
			System.out.println("Row Length = "+Rowcount);
			String str_value = resultData;   
			// System.out.println("str_value = "+str_value);
			String[] str = null;
			int row_count =1;
			if (downloadType.equalsIgnoreCase("excel"))
			{
			System.out.println("<<<<<<<<<<<<< Report in Excel >>>>>>>>>>>>>>>>");
			HSSFSheet sheet = hwb.createSheet(para);
			HSSFRow rowhead = sheet.createRow(0);
			for(int i=0;i<count;i++)   // column name
			{
				String headerNamesList[] = headerNames.split(",");
				rowhead.createCell((short)i).setCellValue(headerNamesList[i]);  // header values
				// System.out.println(headerNamesList[i]);
			}
			
			// System.out.println("Header Complete");
			// System.out.println("resultData"+resultData);
			
			for(int i=0; i<Rowcount; i++)
			{
				HSSFRow row = sheet.createRow((short)row_count);
				 str = str_value.split("],");  // store value in str[i] and split with ' ], ';
				 // System.out.println("values of str "+str[i] +"  "+i);
				 
				if(i == 0)
				{
					 valuelist = str[i].substring(1);  // remove 1st charactor '['
				}
				else
				{
				 valuelist = str[i].substring(2);    // remove two charactor space and '['
				}
				// System.out.println("Values list of row : "+valuelist);
				for(int j=0;j<count;j++)
				{
					String value[] = valuelist.split(",");
					row.createCell((short)j).setCellValue(value[j]);  // column values
					// System.out.println("Values list of column : "+value[j]);
				}
				
				  row_count ++;
			}
	
			Date d = new Date();
			ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
			hwb.write(outByteStream);
			byte[] outArray = outByteStream.toByteArray();
			response.setContentType("application/ms-excel");
			response.setContentLength(outArray.length);
			response.setHeader("Expires:", "0");
			response.setHeader("Content-Disposition", "attachment; filename="+para + d + ".xls");
			OutputStream outStream = response.getOutputStream();
			outStream.write(outArray);
			outStream.flush();
			outStream.close();
			hwb.close();
		}
			
			if (downloadType.equalsIgnoreCase("PDF"))
			{
				
		try{
			//  save on server path
			// String filePath = getServletContext().getRealPath("/");
			/*String filePath = getServletContext().getRealPath("/") +"PDF";
			String pdfFileName = "Report"+new SimpleDateFormat("YYYYMMdd").format(new Date())+".pdf";
			File newfile = new File(filePath,pdfFileName); 
			FileOutputStream fos = new FileOutputStream(newfile);
			PdfWriter.getInstance(document, fos);*/
			
			   System.out.println("<<<<<<<<<<<<< Report in PDF >>>>>>>>>>>>>>>>");
			   
			   Document document = new Document();
			   ByteArrayOutputStream baos = new ByteArrayOutputStream();
			   PdfWriter.getInstance(document, baos);
	        
	           Rectangle pagesize = new Rectangle(1400,1100);
	           document.setPageSize(pagesize);
	           
	           //Inserting Image in PDF
	           Image image = Image.getInstance ("http://139.59.1.254:8080/Image/1paylogo.jpg");
	           image.scaleAbsolute(100f, 100f);//image width,height 
		 
		      //Inserting Table in PDF
	           PdfPTable table=new PdfPTable(count);
	          
	           table.setWidthPercentage(95);
	          
	           PdfPCell cell = new PdfPCell (new Paragraph ("Report"));
	          
		       cell.setColspan (count);
		       cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		       cell.setPadding (10.0f);
		       cell.setBackgroundColor (new BaseColor (140, 221, 8));                
		 
		       table.addCell(cell);                
		       for(int i=0;i<count;i++)   // column name
				{
					String headerNamesList[] = headerNames.split(",");
					table.addCell(headerNamesList[i]);
					// System.out.println("header values for pdf  =  "+headerNamesList[i]);
					table.setSpacingBefore(30.0f);       // Space Before table starts, like margin-top in CSS
				    table.setSpacingAfter(30.0f);        // Space After table starts, like margin-Bottom in CSS				
				}
		       
		       for(int i=0; i<Rowcount; i++)
				{
					 str = str_value.split("],");  // store value in str[i] and split with ' ], ';
					 
					if(i == 0)
					{
						 valuelist = str[i].substring(1);  
					}
					else
					{
					 valuelist = str[i].substring(2);    
					}
					for(int j=0;j<count;j++)
					{
						String value[] = valuelist.split(",");
						table.addCell(value[j]);
					}
					
				}
		      
			     
					 document.open();//PDF document opened........			       
					 document.add(image);
					
					 document.add(new Paragraph("Document Generated On - "+new Date().toString())); 
					 document.add(table);
					
					 document.newPage();         
					 document.close();
				 
			 
			      	 Date d = new Date();
					 response.setHeader("Expires", "0");
					 response.setContentType("application/pdf;charset=UTF-8");
					 response.setHeader("Content-Disposition", "attachment; filename="+para + d + ".pdf");
				     response.setContentType("application/pdf");
				     response.setContentLength(baos.size());
				    

			      OutputStream outStream = response.getOutputStream();
			      baos.writeTo(outStream);
			      outStream.flush();
	             System.out.println("Pdf created successfully..");
		 
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
				
			
		}
			
		}
		catch (Exception ex)
		{
			request.setAttribute("message", "Getting error while download excel !!");
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
										.getRequestDispatcher("/erroe.jsp");
								reqDispatcher.forward(request, response);
			// response.sendRedirect("error.jsp?message='Getting error while download excel'");
			ex.printStackTrace();
		}
	}


}
