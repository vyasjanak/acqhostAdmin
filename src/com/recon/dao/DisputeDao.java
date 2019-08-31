package com.recon.dao;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.Timestamp;
import java.util.List;

import com.recon.formclasses.Dispute;
import com.recon.utils.DBConnectionHandler;

/*import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DisputeDao
{
	public List txnCSVList(File pathToCSVFile)throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(
				pathToCSVFile));
		String line = null;
		Scanner scanner = null;
		int index = 0;

		List<Dispute> txnList = new ArrayList<>();

		while ((line = reader.readLine()) != null) {
			Dispute txn = new Dispute();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0)
					txn.setReport_Date(data.replace("\"",""));
				else if (index == 1)
					txn.setDebit_credit_Adjustment_Date(data.replace("\"",""));
				else if (index == 2)
					txn.setDebit_credit_Adjustment_Settlement_Date(data.replace("\"",""));
				else if (index == 3)
					txn.setCase_Number(data.replace("\"",""));
				else if (index == 4)
					txn.setFunction_code_and_Description(data.replace("\"",""));
				else if (index == 5)
					txn.setTransaction_Sequence_Number(data.replace("\"",""));
				else if (index == 6)
					txn.setTag_ID(data.replace("\"",""));
				else if (index == 7)
					txn.setTransaction_Date(data.replace("\"",""));
				else if (index == 8)
					txn.setTransaction_Settlement_Date(data.replace("\"",""));
				else if (index == 9)
					txn.setrRN(data.replace("\"",""));
				else if (index == 10)
					txn.setTransaction_Type(data.replace("\"",""));
				else if (index == 11)
					txn.setMerchant_ID(data.replace("\"",""));
				else if (index == 12)
					txn.settID(data.replace("\"",""));
				else if (index == 13)
					txn.setTransaction_Status(data.replace("\"",""));
				else if (index == 14)
					txn.settAG_Status(data.replace("\"",""));
				else if (index == 15)
					txn.setaVC(data.replace("\"",""));
				else if (index == 16)
					txn.setTransaction_Currency_Code(data.replace("\"",""));
				else if (index == 17)
					txn.setSettlement_Amount(data.replace("\"",""));
				else if (index == 18)
					txn.setDebit_credit_Adjustment_Full_Partial_Indicator(data.replace("\"",""));
				else if (index == 19)
					txn.setOriginator_Point(data.replace("\"",""));
				else if (index == 20)
					txn.setAcquirer_ID(data.replace("\"",""));
				else if (index == 21)
					txn.setTransaction_Originator_Institution_PID(data.replace("\"",""));
				else if (index == 22)
					txn.setAcquirer_Name_and_Country(data.replace("\"",""));
				else if (index == 23)
					txn.setiIN(data.replace("\"",""));
				else if (index == 24)
					txn.setTransaction_Destination_Institution_PID(data.replace("\"",""));
				else if (index == 25)
					txn.setIssuer_Name_and_Country(data.replace("\"",""));
				else if (index == 26)
					txn.setVehicle_Registration_Number(data.replace("\"",""));
				else if (index == 27)
					txn.setVehicle_Class(data.replace("\"",""));
				else if (index == 28)
					txn.setVehicle_Type(data.replace("\"",""));
				else if (index == 29)
					txn.setMerchant_type(data.replace("\"",""));
				else if (index == 30)
					txn.setSub_Merchant_Type(data.replace("\"",""));
				else if (index == 31)
					txn.setFinancial_Non_Financial_Indicator(data.replace("\"",""));
				else if (index == 32)
					txn.setDebit_credit_Adjustment_Reason_Code(data.replace("\"",""));
				else if (index == 33)
					txn.setDebit_credit_Adjustment_Code_description(data.replace("\"",""));
				else if (index == 34)
					txn.setDebit_credit_Adjustment_Amount(data.replace("\"",""));
				else if (index == 35)
					txn.setDocument_Indicator(data.replace("\"",""));
				else if (index == 36)
					txn.setDocument_Attached_Date(data.replace("\"",""));
				else if (index == 37)
					txn.setDays_Aged(data.replace("\"",""));
				else
					System.out.println("Invalid data::" + data);
				index++;
			}
			index = 0;
			txnList.add(txn);
		}

		//close reader
		reader.close();

		for(int i = 0; i < txnList.size(); i++) 
		{
			System.out.println(
							txnList.get(i).getReport_Date()+"\t"+
							txnList.get(i).getDebit_credit_Adjustment_Date()+"\t"+
							txnList.get(i).getDebit_credit_Adjustment_Settlement_Date()+"\t"+
							txnList.get(i).getCase_Number()+"\t"+
							txnList.get(i).getFunction_code_and_Description()+"\t"+
							txnList.get(i).getTransaction_Sequence_Number()+"\t"+
							txnList.get(i).getTag_ID()+"\t"+
							txnList.get(i).getTransaction_Date()+"\t"+
							txnList.get(i).getTransaction_Settlement_Date()+"\t"+
							txnList.get(i).getrRN()+"\t"+
							txnList.get(i).getTransaction_Type()+"\t"+
							txnList.get(i).getMerchant_ID()+"\t"+
							txnList.get(i).gettID()+"\t"+
							txnList.get(i).getTransaction_Status()+"\t"+
							txnList.get(i).gettAG_Status()+"\t"+
							txnList.get(i).getaVC()+"\t"+
							txnList.get(i).getTransaction_Currency_Code()+"\t"+
							txnList.get(i).getSettlement_Amount()+"\t"+
							txnList.get(i).getDebit_credit_Adjustment_Full_Partial_Indicator()+"\t"+
							txnList.get(i).getOriginator_Point()+"\t"+
							txnList.get(i).getAcquirer_ID()+"\t"+
							txnList.get(i).getTransaction_Originator_Institution_PID()+"\t"+
							txnList.get(i).getAcquirer_Name_and_Country()+"\t"+
							txnList.get(i).getiIN()+"\t"+
							txnList.get(i).getTransaction_Destination_Institution_PID()+"\t"+
							txnList.get(i).getIssuer_Name_and_Country()+"\t"+
							txnList.get(i).getVehicle_Registration_Number()+"\t"+
							txnList.get(i).getVehicle_Class()+"\t"+
							txnList.get(i).getVehicle_Type()+"\t"+
							txnList.get(i).getMerchant_type()+"\t"+
							txnList.get(i).getSub_Merchant_Type()+"\t"+
							txnList.get(i).getFinancial_Non_Financial_Indicator()+"\t"+
							txnList.get(i).getDebit_credit_Adjustment_Reason_Code()+"\t"+
							txnList.get(i).getDebit_credit_Adjustment_Code_description()+"\t"+
							txnList.get(i).getDebit_credit_Adjustment_Amount()+"\t"+
							txnList.get(i).getDocument_Indicator()+"\t"+
							txnList.get(i).getDocument_Attached_Date()+"\t"+
							txnList.get(i).getDays_Aged()
							);
		}

		return txnList;
	}



	public void insertDisputeTxns(List<Dispute> txnList) throws SQLException 
	{

		String sql = "INSERT INTO dispute_txns("
				+ "report_Date, debit_credit_Adjustment_Date, debit_credit_Adjustment_Settlement_Date, case_Number, function_code_and_Description,"
				+ "transaction_Sequence_Number, tag_ID, transaction_Date, transaction_Settlement_Date, rRN, transaction_Type, merchant_ID,	tID,"
				+ "transaction_Status, tAG_Status,	aVC, transaction_Currency_Code,	settlement_Amount, debit_credit_Adjustment_Full_Partial_Indicator, "
				+ "originator_Point, acquirer_ID, transaction_Originator_Institution_PID, acquirer_Name_and_Country, iIN, transaction_Destination_Institution_PID, "
				+ "issuer_Name_and_Country, vehicle_Registration_Number, vehicle_Class, vehicle_Type, merchant_type, sub_Merchant_Type, "
				+ "financial_Non_Financial_Indicator, debit_credit_Adjustment_Reason_Code, debit_credit_Adjustment_Code_description, debit_credit_Adjustment_Amount, "
				+ "document_Indicator, document_Attached_Date, days_Aged"
				+ ") "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		System.out.println(sql);
		Connection conn = null;
		
		int iteration = 0;

		PreparedStatement pstmt = null;
		try  
		{
			conn =  new DBConnectionHandler().getConnection();

			for(Dispute txn : txnList){
				if(iteration != 0) {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, txn.getReport_Date());
					pstmt.setString(2, txn.getDebit_credit_Adjustment_Date());
					pstmt.setString(3, txn.getDebit_credit_Adjustment_Settlement_Date());
					pstmt.setString(4, txn.getCase_Number());
					pstmt.setString(5, txn.getFunction_code_and_Description());
					pstmt.setString(6, txn.getTransaction_Sequence_Number());
					pstmt.setString(7, txn.getTag_ID());
					pstmt.setString(8, txn.getTransaction_Date());
					pstmt.setString(9, txn.getTransaction_Settlement_Date());
					pstmt.setString(10, txn.getrRN());
					pstmt.setString(11, txn.getTransaction_Type());
					pstmt.setString(12, txn.getMerchant_ID());
					pstmt.setString(13, txn.gettID());
					pstmt.setString(14, txn.getTransaction_Status());
					pstmt.setString(15, txn.gettAG_Status());
					pstmt.setString(16, txn.getaVC());
					pstmt.setString(17, txn.getTransaction_Currency_Code());
					pstmt.setString(18, txn.getSettlement_Amount());
					pstmt.setString(19, txn.getDebit_credit_Adjustment_Full_Partial_Indicator());
					pstmt.setString(20, txn.getOriginator_Point());
					pstmt.setString(21, txn.getAcquirer_ID());
					pstmt.setString(22, txn.getTransaction_Originator_Institution_PID());
					pstmt.setString(23, txn.getAcquirer_Name_and_Country());
					pstmt.setString(24, txn.getiIN());
					pstmt.setString(25, txn.getTransaction_Destination_Institution_PID());
					pstmt.setString(26, txn.getIssuer_Name_and_Country());
					pstmt.setString(27, txn.getVehicle_Registration_Number());
					pstmt.setString(28, txn.getVehicle_Class());
					pstmt.setString(29, txn.getVehicle_Type());
					pstmt.setString(30, txn.getMerchant_type());
					pstmt.setString(31, txn.getSub_Merchant_Type());
					pstmt.setString(32, txn.getFinancial_Non_Financial_Indicator());
					pstmt.setString(33, txn.getDebit_credit_Adjustment_Reason_Code());
					pstmt.setString(34, txn.getDebit_credit_Adjustment_Code_description());
					pstmt.setString(35, txn.getDebit_credit_Adjustment_Amount());
					pstmt.setString(36, txn.getDocument_Indicator());
					pstmt.setString(37, txn.getDocument_Attached_Date());
					pstmt.setString(38, txn.getDays_Aged());
					
					pstmt.executeUpdate();
					//pstmt.addBatch();
				}
				//pstmt.executeBatch();
				//conn.commit();
				iteration++; 
			} 
			System.out.println("Dispute transactions are inserted successfully...........");
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(conn!=null)
					conn.close();
				if(pstmt!=null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			/*pstmt = null;
			conn=null;*/
		}
	}
	
	
	
	
	public void insertCycle(String cycledate, String cycle) throws Exception 
	{

		//String sql = "INSERT INTO npci_recon_status(on_date, cycle) VALUES('"+cycledate+"','"+cycle+"')";
		String sql = "INSERT INTO npci_recon_status(on_date, cycle) VALUES(?,?)";

		System.out.println(sql);
		System.out.println("In Dao date.... "+cycledate+" cycle ...."+cycle);
		//System.out.println("heloo........................");
		//Date dt=new Date();
		//String cdate = cycledate + " " + dt.getHours() +":" + dt.getMinutes() + ":" + dt.getSeconds();
		//System.out.println("Converted date : "+cdate);
		
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		//Txns txn = null;
		try  
		{
			conn =  new DBConnectionHandler().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cycledate);//txn.getCycledate());
			pstmt.setString(2, cycle);//txn.getCycle());
			pstmt.executeUpdate();
			System.out.println("Cycle is inserted successfully...........");
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		
		finally{
			try {
				if(pstmt!=null)
					pstmt.close();
				if(conn!=null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
	
	public static boolean checkCycle(String CDATE, String CYCLE)
	{
		boolean check=false;
		Connection conn = null;
		ResultSet rs = null;
		Statement st= null;
		//String CDATE = "13-03-2018";
		//String CYCLE = "1";
		String sql = "SELECT * FROM npci_recon_status";// where on_date='"+CDATE+"' and cycle='"+CYCLE+"'";
		//boolean flag=false;
		try{
			
			
			conn =  new DBConnectionHandler().getConnection();
			st = conn.createStatement();
		    rs = st.executeQuery(sql);
		       while(rs.next())
		       {
			       if(rs.getString(1).equals(CDATE) && rs.getString(2).equals(CYCLE)){
			    	   check=true;
			    	   System.out.println("DATE : "+rs.getString("on_date"));
			    	   System.out.println("CYCLE : "+rs.getString("cycle"));
			    	   System.out.println("In IF Flag value "+check);
			    	   break;
			       } else {
			    	   //continue;
			    	   check=false;
			       }
		       }
		       System.out.println("Flag value "+check);
		    } catch (Exception e){
		       System.out.println("Error while checking cycle records"+e.getMessage());
		       e.printStackTrace();
		    }
		
		finally{
			try {
				if(rs!=null)
					rs.close();
				if(st!=null)
					st.close();
				if(conn!=null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		return check;
	}
	
	public static void main1(String[] args) 
	{
		Connection conn = null;
		//PreparedStatement pstmt = null;
		ResultSet rs = null;
		Statement st= null;
		String CDATE = "13-03-2018";
		String CYCLE = "1";
				
		String sql = "SELECT * FROM npci_recon_status";// where on_date='"+CDATE+"' and cycle='"+CYCLE+"'";
		
		try{
			conn = new DBConnectionHandler().getConnection();
			//pstmt = (PreparedStatement) conn.createStatement();
			st = conn.createStatement();
		    rs = st.executeQuery(sql);
		    boolean flag=false;
		       while(rs.next())
		       {
		    	   /*if(rs.getString(1) != null && rs.getString(2) != null)*/
				       if(rs.getString("on_date").equals(CDATE) && rs.getString("cycle").equals(CYCLE)){
				    	   System.out.println("DATE : "+rs.getString("on_date"));
				    	   System.out.println("CYCLE : "+rs.getString("cycle"));
				    	   flag=true;
				    	   break;
				       } else {
				    	   //continue;
				    	   flag=false;
				       }
		       }
		       System.out.println("Flag value "+flag);
		    } catch (Exception e){
		       System.out.println("Error getting row count");
		       e.printStackTrace();
		    }
		
	}
	
	/*public boolean checkDate(String pdate,int cycle)
	{
		boolean chkdate = new ValidateCycle().validateCycle(pdate, cycle);
		return chkdate;
	}
	*/
	public String latestDate()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
        List<Date> dates = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        String ondate;
        Date date=null;
        Date latest=null;
        String latestDate = null;
		try
		{
			String sql = "SELECT on_date FROM npci_recon_status";
			conn = new DBConnectionHandler().getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
	        while (rs.next()) {
	        	ondate = (rs.getString(1));
	        	date = df.parse(ondate);
	        	dates.add(date);
	        }
		}
		catch(Exception e)
		{
			System.out.println("Error while getting date : "+e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try
			{  
				if (rs != null) 
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();

			}

		}

		
		//System.out.println(dates);
		if(dates.isEmpty())
		{
			System.out.println("Dates are empty");
			latestDate = "";
		}
		else
		{
			latest = Collections.max(dates);
			latestDate = df.format(latest);
		}
        return latestDate;
	}
}
