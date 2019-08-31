package com.recon.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.recon.formclasses.Txns;
import com.recon.utils.DBConnectionHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TxnsDao
{
	public boolean isValidFile(File pathToCSVFile)
	{
		Scanner scanIn = null;
	    int rows = 0;
	    int cols = 0;
	    String inputLine = "";
	    try {
	        scanIn = new Scanner(new BufferedReader(new FileReader(pathToCSVFile)));
	        scanIn.useDelimiter(",");
	        while (scanIn.hasNextLine()) {
	        	inputLine = scanIn.nextLine();
	            String[] inArray = inputLine.split(",");
	            rows++;
	            cols = inArray.length;
	        }

	    } catch (Exception e) {
	        System.out.println(e);
	    }
		System.out.println("Number of columns in file :: "+cols);
		System.out.println("Number of rows in file :: "+rows);
		if(cols==64)
			return true;
		else
			return false;
	}
	public List txnCSVList(File pathToCSVFile)throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(
				pathToCSVFile));
		String line = null;
		Scanner scanner = null;
		int index = 0;

		List<Txns> txnList = new ArrayList<>();

		//System.out.println("prinitng");

		while ((line = reader.readLine()) != null) {
			Txns txn = new Txns();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0)
					txn.setTransaction_Sequence_Number(data.replace("\"",""));
				else if (index == 1)
					txn.setTransaction_ID(data.replace("\"",""));
				else if (index == 2)
					txn.setMessage_ID(data.replace("\"",""));
				else if (index == 3)
					txn.setNote(data.replace("\"",""));
				else if (index == 4)
					txn.setReference_ID(data.replace("\"",""));
				else if (index == 5)
					txn.setReference_URL(data.replace("\"",""));
				else if (index == 6)
					txn.setTransaction_Date_and_Time(data.replace("\"",""));
				else if (index == 7)
					txn.setTransaction_Type(data.replace("\"",""));
				else if (index == 8)
					txn.setOriginal_transaction_ID(data.replace("\"",""));
				else if (index == 9)
					txn.setTag_ID(data.replace("\"",""));
				else if (index == 10)
					txn.settID(data.replace("\"",""));
				else if (index == 11)
					txn.setaVC(data.replace("\"",""));
				else if (index == 12)
					txn.setWim(data.replace("\"",""));
				else if (index == 13)
					txn.setMerchant_Id(data.replace("\"",""));
				else if (index == 14)
					txn.setMerchant_Type(data.replace("\"",""));
				else if (index == 15)
					txn.setSub_Merchant_Type(data.replace("\"",""));
				else if (index == 16)
					txn.setLane_Id(data.replace("\"",""));
				else if (index == 17)
					txn.setLane_Direction(data.replace("\"",""));
				else if (index == 18)
					txn.setLane_Reader_ID(data.replace("\"",""));
				else if (index == 19)
					txn.setParking_Floor(data.replace("\"",""));
				else if (index == 20)
					txn.setParking_Zone(data.replace("\"",""));
				else if (index == 21)
					txn.setParking_Slot(data.replace("\"",""));
				else if (index == 22)
					txn.setParking_Reader_ID(data.replace("\"",""));
				else if (index == 23)
					txn.setReader_Read_Date_and_Time(data.replace("\"",""));
				else if (index == 24)
					txn.setSignature_Data(data.replace("\"",""));
				else if (index == 25)
					txn.setSignature_Authentication(data.replace("\"",""));
				else if (index == 26)
					txn.setePC_Verified(data.replace("\"",""));
				else if (index == 27)
					txn.setProc_Restriction_Res(data.replace("\"",""));
				else if (index == 28)
					txn.setVehicle_Auth(data.replace("\"",""));
				else if (index == 29)
					txn.setPublic_Key_CVV(data.replace("\"",""));
				else if (index == 30)
					txn.setReader_Transaction_Counter(data.replace("\"",""));
				else if (index == 31)
					txn.setReader_Transaction_Status(data.replace("\"",""));
				else if (index == 32)
					txn.setPayer_Address(data.replace("\"",""));
				else if (index == 33)
					txn.setIssuer_ID(data.replace("\"",""));
				else if (index == 34)
					txn.setPayer_Code(data.replace("\"",""));
				else if (index == 35)
					txn.setPayer_name(data.replace("\"",""));
				else if (index == 36)
					txn.setPayer_Type(data.replace("\"",""));
				else if (index == 37)
					txn.setTransaction_Amount(data.replace("\"",""));
				else if (index == 38)
					txn.setCurrency_Code(data.replace("\"",""));
				else if (index == 39)
					txn.setPayee_Address(data.replace("\"",""));
				else if (index == 40)
					txn.setAcquirer_ID(data.replace("\"",""));
				else if (index == 41)
					txn.setPayee_Code(data.replace("\"",""));
				else if (index == 42)
					txn.setPayee_name(data.replace("\"",""));
				else if (index == 43)
					txn.setPayee_Type(data.replace("\"",""));
				else if (index == 44)
					txn.setResponse_Code(data.replace("\"",""));
				else if (index == 45)
					txn.setTransaction_Status(data.replace("\"",""));
				else if (index == 46)
					txn.setApproval_Number(data.replace("\"",""));
				else if (index == 47)
					txn.setPayee_Error_Code(data.replace("\"",""));
				else if (index == 48)
					txn.setSettled_Amount(data.replace("\"",""));
				else if (index == 49)
					txn.setSettled_Currency(data.replace("\"",""));
				else if (index == 50)
					txn.setAccount_Type(data.replace("\"",""));
				else if (index == 51)
					txn.setAvailable_Balance(data.replace("\"",""));
				else if (index == 52)
					txn.setLedger_Balance(data.replace("\"",""));
				else if (index == 53)
					txn.setAccount_Number(data.replace("\"",""));
				else if (index == 54)
					txn.setCustomer_Name(data.replace("\"",""));
				else if (index == 55)
					txn.setInitiated_By(data.replace("\"",""));
				else if (index == 56)
					txn.setInitiated_Time(data.replace("\"",""));
				else if (index == 57)
					txn.setLast_Updated_By(data.replace("\"",""));
				else if (index == 58)
					txn.setLast_Updated_Time(data.replace("\"",""));
				else if (index == 59)
					txn.setVehicle_Registration_number(data.replace("\"",""));
				else if (index == 60)
					txn.setVehicle_Class(data.replace("\"",""));
				else if (index == 61)
					txn.setVehicle_Type(data.replace("\"",""));
				else if (index == 62)
					txn.setTag_status(data.replace("\"",""));
				else if (index == 63)
					txn.setTag_Issue_Date(data.replace("\"",""));

				else
					System.out.println("Invalid data::" + data);
				index++;
			}
			index = 0;
			txnList.add(txn);
		}

		//close reader
		reader.close();

		/*for(int i = 0; i < txnList.size(); i++) 
		{
			System.out.println(
					txnList.get(i).getTransaction_Sequence_Number()+"\t"+
							txnList.get(i).getTransaction_ID()+"\t"+
							txnList.get(i).getMessage_ID()+"\t"+
							txnList.get(i).getNote()+"\t"+
							txnList.get(i).getReference_ID()+"\t"+
							txnList.get(i).getReference_URL()+"\t"+
							txnList.get(i).getTransaction_Date_and_Time()+"\t"+
							txnList.get(i).getTransaction_Type()+"\t"+
							txnList.get(i).getOriginal_transaction_ID()+"\t"+
							txnList.get(i).getTag_ID()+"\t"+
							txnList.get(i).gettID()+"\t"+
							txnList.get(i).getaVC()+"\t"+
							txnList.get(i).getWim()+"\t"+
							txnList.get(i).getMerchant_Id()+"\t"+
							txnList.get(i).getMerchant_Type()+"\t"+
							txnList.get(i).getSub_Merchant_Type()+"\t"+
							txnList.get(i).getLane_Id()+"\t"+
							txnList.get(i).getLane_Direction()+"\t"+
							txnList.get(i).getLane_Reader_ID()+"\t"+
							txnList.get(i).getParking_Floor()+"\t"+
							txnList.get(i).getParking_Zone()+"\t"+
							txnList.get(i).getParking_Slot()+"\t"+
							txnList.get(i).getParking_Reader_ID()+"\t"+
							txnList.get(i).getReader_Read_Date_and_Time()+"\t"+
							txnList.get(i).getSignature_Data()+"\t"+
							txnList.get(i).getSignature_Authentication()+"\t"+
							txnList.get(i).getePC_Verified()+"\t"+
							txnList.get(i).getProc_Restriction_Res()+"\t"+
							txnList.get(i).getVehicle_Auth()+"\t"+
							txnList.get(i).getPublic_Key_CVV()+"\t"+
							txnList.get(i).getReader_Transaction_Counter()+"\t"+
							txnList.get(i).getReader_Transaction_Status()+"\t"+
							txnList.get(i).getPayer_Address()+"\t"+
							txnList.get(i).getIssuer_ID()+"\t"+
							txnList.get(i).getPayer_Code()+"\t"+
							txnList.get(i).getPayer_name()+"\t"+
							txnList.get(i).getPayer_Type()+"\t"+
							txnList.get(i).getTransaction_Amount()+"\t"+
							txnList.get(i).getCurrency_Code()+"\t"+
							txnList.get(i).getPayee_Address()+"\t"+
							txnList.get(i).getAcquirer_ID()+"\t"+
							txnList.get(i).getPayee_Code()+"\t"+
							txnList.get(i).getPayee_name()+"\t"+
							txnList.get(i).getPayee_Type()+"\t"+
							txnList.get(i).getResponse_Code()+"\t"+
							txnList.get(i).getTransaction_Status()+"\t"+
							txnList.get(i).getApproval_Number()+"\t"+
							txnList.get(i).getPayee_Error_Code()+"\t"+
							txnList.get(i).getSettled_Amount()+"\t"+
							txnList.get(i).getSettled_Currency()+"\t"+
							txnList.get(i).getAccount_Type()+"\t"+
							txnList.get(i).getAvailable_Balance()+"\t"+
							txnList.get(i).getLedger_Balance()+"\t"+
							txnList.get(i).getAccount_Number()+"\t"+
							txnList.get(i).getCustomer_Name()+"\t"+
							txnList.get(i).getInitiated_By()+"\t"+
							txnList.get(i).getInitiated_Time()+"\t"+
							txnList.get(i).getLast_Updated_By()+"\t"+
							txnList.get(i).getLast_Updated_Time()+"\t"+
							txnList.get(i).getVehicle_Registration_number()+"\t"+
							txnList.get(i).getVehicle_Class()+"\t"+
							txnList.get(i).getVehicle_Type()+"\t"+
							txnList.get(i).getTag_status()+"\t"+
							txnList.get(i).getTag_Issue_Date());

		}*/
		//System.out.println("Transactions are : "+txnList);

		/*for (Txns l : txnList) 
		{
			  System.out.println("Start list");
			  for (String s : l) 
			  {
			    System.out.println("Entry:  " + s);
			  }
		}*/

		return txnList;
	}



	int processed=0, notprocessed=0, total=0;
	public void insertTxns(List<Txns> txnList) 
	{
		
		String sql = "INSERT INTO temp_txns("
				+ "transaction_Sequence_Number, transaction_ID, message_ID, note, reference_ID, reference_URL, transaction_Date_and_Time,"
				+ "transaction_Type, original_transaction_ID, tag_ID, tID, aVC, wim, merchant_Id, merchant_Type, sub_Merchant_Type,"
				+ "lane_Id, lane_Direction, lane_Reader_ID, parking_Floor, parking_Zone, parking_Slot, parking_Reader_ID, reader_Read_Date_and_Time, "
				+ "signature_Data, signature_Authentication, ePC_Verified, proc_Restriction_Res, vehicle_Auth, public_Key_CVV, "
				+ "reader_Transaction_Counter, reader_Transaction_Status, payer_Address, issuer_ID, payer_Code, payer_name, payer_Type, "
				+ "transaction_Amount, currency_Code, payee_Address, acquirer_ID, payee_Code, payee_name, payee_Type, response_Code, "
				+ "transaction_Status, approval_Number, payee_Error_Code, settled_Amount, settled_Currency, account_Type, available_Balance,"
				+ "ledger_Balance, account_Number, customer_Name, initiated_By, initiated_Time, last_Updated_By, last_Updated_Time, "
				+ "vehicle_Registration_number, vehicle_Class, vehicle_Type, tag_status, tag_Issue_Date"
				+ ") "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String txnID = null;
		String referenceID = null;
		int iteration = 0;
		//NPCIReconProcessing npciReconDao = new NPCIReconProcessing();
		try  
		{
			conn = new DBConnectionHandler().getConnection();
			System.out.println(sql);
			for(Txns txn : txnList){
				if(iteration != 0) {
					
					total++;
					Date dt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(txn.getTransaction_Date_and_Time());
					String dateTimeTrans = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dt);
					
					Date dt1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(txn.getReader_Read_Date_and_Time());
					String readerTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dt1);
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, txn.getTransaction_Sequence_Number());
					txnID = txn.getTransaction_ID();
					if(txnID.startsWith("'")){
						txnID = txnID.substring(1);
					}
					pstmt.setString(2, txnID);
					pstmt.setString(3, txn.getMessage_ID());
					pstmt.setString(4, txn.getNote());
					referenceID = txn.getReference_ID();
					if(referenceID.startsWith("'")){
						referenceID = referenceID.substring(1);
					}
					pstmt.setString(5, referenceID);
					pstmt.setString(6, txn.getReference_URL());
					pstmt.setString(7, dateTimeTrans);
					pstmt.setString(8, txn.getTransaction_Type());
					pstmt.setString(9, txn.getOriginal_transaction_ID());
					pstmt.setString(10, txn.getTag_ID());
					pstmt.setString(11, txn.gettID());
					pstmt.setString(12, txn.getaVC());
					pstmt.setString(13, txn.getWim());
					pstmt.setString(14, txn.getMerchant_Id());
					pstmt.setString(15, txn.getMerchant_Type());
					pstmt.setString(16, txn.getSub_Merchant_Type());
					pstmt.setString(17, txn.getLane_Id());
					pstmt.setString(18, txn.getLane_Direction());
					pstmt.setString(19, txn.getLane_Reader_ID());
					pstmt.setString(20, txn.getParking_Floor());
					pstmt.setString(21, txn.getParking_Zone());
					pstmt.setString(22, txn.getParking_Slot());
					pstmt.setString(23, txn.getParking_Reader_ID());
					pstmt.setString(24, readerTime);
					pstmt.setString(25, txn.getSignature_Data());
					pstmt.setString(26, txn.getSignature_Authentication());
					pstmt.setString(27, txn.getePC_Verified());
					pstmt.setString(28, txn.getProc_Restriction_Res());
					pstmt.setString(29, txn.getVehicle_Auth());
					pstmt.setString(30, txn.getPublic_Key_CVV());
					pstmt.setString(31, txn.getReader_Transaction_Counter());
					pstmt.setString(32, txn.getReader_Transaction_Status());
					pstmt.setString(33, txn.getPayer_Address());
					pstmt.setString(34, txn.getIssuer_ID());
					pstmt.setString(35, txn.getPayer_Code());
					pstmt.setString(36, txn.getPayer_name());
					pstmt.setString(37, txn.getPayer_Type());
					pstmt.setString(38, txn.getTransaction_Amount());
					pstmt.setString(39, txn.getCurrency_Code());
					pstmt.setString(40, txn.getPayee_Address());
					pstmt.setString(41, txn.getAcquirer_ID());
					pstmt.setString(42, txn.getPayee_Code());
					pstmt.setString(43, txn.getPayee_name());
					pstmt.setString(44, txn.getPayee_Type());
					pstmt.setString(45, txn.getResponse_Code());
					pstmt.setString(46, txn.getTransaction_Status());
					pstmt.setString(47, txn.getApproval_Number());
					pstmt.setString(48, txn.getPayee_Error_Code());
					pstmt.setString(49, txn.getSettled_Amount());
					pstmt.setString(50, txn.getSettled_Currency());
					pstmt.setString(51, txn.getAccount_Type());
					pstmt.setString(52, txn.getAvailable_Balance());
					pstmt.setString(53, txn.getLedger_Balance());
					pstmt.setString(54, txn.getAccount_Number());
					pstmt.setString(55, txn.getCustomer_Name());
					pstmt.setString(56, txn.getInitiated_By());
					pstmt.setString(57, txn.getInitiated_Time());
					pstmt.setString(58, txn.getLast_Updated_By());
					pstmt.setString(59, txn.getLast_Updated_Time());
					pstmt.setString(60, txn.getVehicle_Registration_number());
					pstmt.setString(61, txn.getVehicle_Class());
					pstmt.setString(62, txn.getVehicle_Type());
					pstmt.setString(63, txn.getTag_status());
					pstmt.setString(64, txn.getTag_Issue_Date());
					pstmt.executeUpdate();
					//String sTxn = System.currentTimeMillis()+"";
					//npciReconDao.addToRequestMaster(txn, sTxn);
				}
				iteration++; 
			} 
			System.out.println("Transactions are inserted successfully...........");
			System.out.println("........................................................................................");
		}
		catch (Exception e) 
		{
			System.out.println("Exception while insert in temp txns of NPCI In TxnDao :: "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(pstmt!=null)
					pstmt.close();
				if(conn!=null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	//validate transaction
	public boolean validateTransactionId(String txnId)
	{
		boolean check=false;
		Connection conn = null;
		ResultSet rs = null;
		Statement st= null;
		
		String sql = "SELECT txn_id FROM acq_req_pay_master";
		try{
			conn = new DBConnectionHandler().getConnection();
			st = conn.createStatement();
		    rs = st.executeQuery(sql);
		       while(rs.next())
		       {
			       if(rs.getString("txn_id").equals(txnId))
			       {
			    	   check=true;
			    	   System.out.println("txn_id : "+rs.getString("txn_id"));
			    	   break;
			       } 
			       else 
			       {
			    	   //continue;
			    	   check=false;
			       }
		       }
		       //System.out.println("Flag value "+check);
		    } catch (Exception e){
		       System.out.println("Error while checking adj records"+e.getMessage());
		       e.printStackTrace();
		    }
			finally{
				rs = null;
				st = null;
				conn = null;
			}
		
		return check;
	}
	
	
	public void insertCycle(String cycledate, String cycle, String file_name) 
	{
		//String sql = "INSERT INTO npci_recon_status(on_date, cycle) VALUES('"+cycledate+"','"+cycle+"')";
		String sql = "INSERT INTO npci_recon_status(on_date, cycle,file_name) VALUES(?,?,?)";

		System.out.println(sql);
		System.out.println("In Dao date.... "+cycledate+" cycle ...."+cycle);
		Connection conn = null;
		PreparedStatement pstmt = null;
		//Txns txn = null;
		try  
		{
			conn = new DBConnectionHandler().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cycledate);//txn.getCycledate());
			pstmt.setString(2, cycle);//txn.getCycle());
			pstmt.setString(3, file_name);
			pstmt.executeUpdate();
			System.out.println("Cycle is inserted successfully...........");
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
		}
	}
	
	public static boolean checkCycle(String CDATE, String CYCLE)//, String fileName)
	{
		boolean check=false;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement st= null;
		String sql = "SELECT * FROM npci_recon_status where on_date=? and cycle=?";// where on_date='"+CDATE+"' and cycle='"+CYCLE+"'";
		//boolean flag=false;
		try{
			conn = new DBConnectionHandler().getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, CDATE);
			st.setString(2, CYCLE);
			//st.setString(3, fileName);
		    rs = st.executeQuery();
		    if(rs.next()){
		    	   check=true;
		    	   System.out.println("DATE : "+rs.getString("on_date"));
		    	   System.out.println("CYCLE : "+rs.getString("cycle"));
		    	   //System.out.println("file_name : "+rs.getString("file_name"));
		    	   System.out.println("In IF Flag value "+check);
		     } else {
		    	   //continue;
		    	   check=false;
		     }
		     System.out.println("Flag value "+check);
		    } catch (Exception e){
		       System.out.println("Error while checking cycle records"+e.getMessage());
		       e.printStackTrace();
		    }
		finally{
			try {
				if(conn!=null)
					conn.close();
				if(st!=null)
					st.close();
				if(rs!=null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return check;
	}
	
	public static boolean checkFileProcessed(String fileName)
	{
		boolean check=false;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement st= null;
		String sql = "SELECT * FROM npci_recon_status where file_name=?";// where on_date='"+CDATE+"' and cycle='"+CYCLE+"'";
		//boolean flag=false;
		try{
			conn = new DBConnectionHandler().getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, fileName);
		    rs = st.executeQuery();
		    if(rs.next()){
		    	   check=true;
		    	   System.out.println("file_name : "+rs.getString("file_name"));
		    	   System.out.println("In IF Flag value "+check);
		     } else {
		    	   //continue;
		    	   check=false;
		     }
		     System.out.println("Flag value "+check);
		    } catch (Exception e){
		       System.out.println("Error while checking cycle records"+e.getMessage());
		       e.printStackTrace();
		    }
		finally{
			try {
				if(conn!=null)
					conn.close();
				if(st!=null)
					st.close();
				if(rs!=null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
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
	
	public boolean checkDate(String pdate,int cycle)
	{
		boolean chkdate = new ValidateCycle().validateCycle(pdate, cycle);
		return chkdate;
	}
	
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
	
	public int totalTxnCount(List<Txns> txnList)
	{
		int total=0;
		int iteration = 0;
		for(Txns txn : txnList){
			if(iteration != 0) {
				total++;
			}
			iteration++; 
		}
		return total;
	}
	
	public List<Txns> getExceptionTransactions()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("getExceptionTransactions() ");
		String sqllist = "select * from exception_txns_master";// where recon_status = 'NRNS' and txn_time <= '"+lastdate+"' ORDER BY txn_time";
		List<Txns> txnslist = new ArrayList<Txns>(); 
		try 
		{
			conn = new DBConnectionHandler().getConnection();
			pstmt = conn.prepareStatement(sqllist);
			System.out.println("ExceptionList Query  :: "+sqllist);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Txns txn = new Txns();
				txn.setId(rs.getLong("id"));
				txn.setTransaction_ID(rs.getString("transaction_ID"));
				txn.setTransaction_Date_and_Time(rs.getString("transaction_Date_and_Time"));
				txn.setTransaction_Type(rs.getString("transaction_Type"));
				txn.setOriginal_transaction_ID(rs.getString("original_transaction_ID"));
				txn.setTag_ID(rs.getString("tag_ID"));
				txn.setMerchant_Id(rs.getString("merchant_Id"));
				txn.setReader_Read_Date_and_Time(rs.getString("reader_Read_Date_and_Time"));
				txn.setIssuer_ID(rs.getString("issuer_ID"));
				txn.setTransaction_Amount(rs.getString("transaction_Amount"));
				txn.setAcquirer_ID(rs.getString("acquirer_ID"));
				txn.setVehicle_Registration_number(rs.getString("vehicle_Registration_number"));
				txn.setReason(rs.getString("reason"));
				java.sql.Timestamp timestamp = rs.getTimestamp("process_date");
				txn.setProcess_date(simpleDateFormat.format(timestamp));
				txnslist.add(txn);
			}
			 
		}
		catch (Exception e) 
		{
			System.out.println("Exception while getting list of Exception txns"+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println("Exception while closing list of Exception txns"+e2.getMessage());
				e2.printStackTrace();
			}
		}
		return txnslist;
	}
	public static int getMaxRaiseLimit(String txnId)
	{
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		String sql = null;
		int allowedAmt = 0;
		try
		{
			conn = new DBConnectionHandler().getConnection();
			sql = "SELECT txn_id, txn_amount FROM acq_req_pay_master where txn_id=?";
			st =  conn.prepareStatement(sql);
			st.setString(1, txnId);
		    rs = st.executeQuery();
		    if(rs.next())
		    {
		    	allowedAmt = rs.getInt("txn_amount");
		    	System.out.println("Transaction amount is :: "+allowedAmt);
		    	return allowedAmt;
		    }
		} 
		catch (Exception e)
		{
	       System.out.println("Exception while checking limit"+e.getMessage());
	       e.printStackTrace();
	    }
		finally
		{
			try {
			if(rs!=null)
				rs.close();
			if(st!=null)
				st.close();
			if(conn!=null)
				conn.close();
			} catch (Exception e2) {
			e2.printStackTrace();
			}
		}
		return allowedAmt;
	}
}
