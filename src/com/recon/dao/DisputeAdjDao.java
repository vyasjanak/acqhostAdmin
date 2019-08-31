package com.recon.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Timestamp;
import java.util.List;

import com.recon.formclasses.DisputeAdjForm;
import com.recon.utils.DBConnectionHandler;
import com.recon.utils.GenericUtils;

/*import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class DisputeAdjDao
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
		if(cols==47)
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

		List<DisputeAdjForm> txnList = new ArrayList<>();

		while ((line = reader.readLine()) != null) {
			DisputeAdjForm txn = new DisputeAdjForm();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0)
					txn.setReport_date(data.replace("\"",""));
				else if (index == 1)
					txn.setDispute_raise_date(data.replace("\"",""));
				else if (index == 2)
					txn.setDispute_raised_settlement_date(data.replace("\"",""));
				else if (index == 3)
					txn.setCase_number(data.replace("\"",""));
				else if (index == 4)
					txn.setFunction_code(data.replace("\"",""));
				else if (index == 5)
					txn.setFunction_code_and_description(data.replace("\"",""));
				else if (index == 6)
					txn.setTransaction_sequence_number(data.replace("\"",""));
				else if (index == 7)
					txn.setTag_id(data.replace("\"",""));
				else if (index == 8)
					txn.setTid(data.replace("\"",""));
				else if (index == 9)
					txn.setTransaction_date_time(data.replace("\"",""));
				else if (index == 10)
					txn.setReader_read_date_time(data.replace("\"",""));
				else if (index == 11)
					txn.setTransaction_settlement_date(data.replace("\"",""));
				else if (index == 12)
					txn.setTransaction_amount(data.replace("\"",""));
				else if (index == 13)
					txn.setSettlement_amount(data.replace("\"",""));
				else if (index == 14)
					txn.setSettlement_currency_code(data.replace("\"",""));
				else if (index == 15)
					txn.setNote(data.replace("\"",""));
				else if (index == 16)
					txn.setTransaction_id(data.replace("\"",""));
				else if (index == 17)
					txn.setTransaction_type(data.replace("\"",""));
				else if (index == 18)
					txn.setMerchant_id(data.replace("\"",""));
				else if (index == 19)
					txn.setLane_id(data.replace("\"",""));
				else if (index == 20)
					txn.setMerchant_type(data.replace("\"",""));
				else if (index == 21)
					txn.setSub_merchant_type(data.replace("\"",""));
				else if (index == 22)
					txn.setTransaction_status(data.replace("\"",""));
				else if (index == 23)
					txn.setTag_status(data.replace("\"",""));
				else if (index == 24)
					txn.setAvc(data.replace("\"",""));
				else if (index == 25)
					txn.setWim(data.replace("\"",""));
				else if (index == 26)
					txn.setOriginator_point(data.replace("\"",""));
				else if (index == 27)
					txn.setAcquirer_id(data.replace("\"",""));
				else if (index == 28)
					txn.setTransaction_orig_institution_pid(data.replace("\"",""));
				else if (index == 29)
					txn.setAcquirer_name_and_country(data.replace("\"",""));
				else if (index == 30)
					txn.setIin(data.replace("\"",""));
				else if (index == 31)
					txn.setTransaction_destination_institution_pid(data.replace("\"",""));
				else if (index == 32)
					txn.setIssuer_name_and_country(data.replace("\"",""));
				else if (index == 33)
					txn.setVehicle_registration_number(data.replace("\"",""));
				else if (index == 34)
					txn.setVehicle_class(data.replace("\"",""));
				else if (index == 35)
					txn.setVehicle_type(data.replace("\"",""));
				else if (index == 36)
					txn.setFinancial_non_financial_indicator(data.replace("\"",""));
				else if (index == 37)
					txn.setDispute_reason_code(data.replace("\"",""));
				else if (index == 38)
					txn.setDispute_reason_code_description(data.replace("\"",""));
				else if (index == 39)
					txn.setDisputed_amount(data.replace("\"",""));
				else if (index == 40)
					txn.setFull_partial_indicator(data.replace("\"",""));
				else if (index == 41)
					txn.setMember_message_text(data.replace("\"",""));
				else if (index == 42)
					txn.setDocument_indicator(data.replace("\"",""));
				else if (index == 43)
					txn.setDocument_attached_date(data.replace("\"",""));
				else if (index == 44)
					txn.setDeadline_date(data.replace("\"",""));
				else if (index == 45)
					txn.setDays_to_act(data.replace("\"",""));
				else if (index == 46)
					txn.setDirection_of_dispute(data.replace("\"",""));
				
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
					txnList.get(i).getReport_date()+"\t"+
					txnList.get(i).getDispute_raise_date()+"\t"+
					txnList.get(i).getDispute_raised_settlement_date()+"\t"+
					txnList.get(i).getCase_number()+"\t"+
					txnList.get(i).getFunction_code()+"\t"+
					txnList.get(i).getFunction_code_and_description()+"\t"+
					txnList.get(i).getTransaction_sequence_number()+"\t"+
					txnList.get(i).getTag_id()+"\t"+
					txnList.get(i).getTid()+"\t"+
					txnList.get(i).getTransaction_date_time()+"\t"+
					txnList.get(i).getReader_read_date_time()+"\t"+
					txnList.get(i).getTransaction_settlement_date()+"\t"+
					txnList.get(i).getTransaction_amount()+"\t"+
					txnList.get(i).getSettlement_amount()+"\t"+
					txnList.get(i).getSettlement_currency_code()+"\t"+
					txnList.get(i).getNote()+"\t"+
					txnList.get(i).getTransaction_id()+"\t"+
					txnList.get(i).getTransaction_type()+"\t"+
					txnList.get(i).getMerchant_id()+"\t"+
					txnList.get(i).getLane_id()+"\t"+
					txnList.get(i).getMerchant_type()+"\t"+
					txnList.get(i).getSub_merchant_type()+"\t"+
					txnList.get(i).getTransaction_status()+"\t"+
					txnList.get(i).getTag_status()+"\t"+
					txnList.get(i).getAvc()+"\t"+
					txnList.get(i).getWim()+"\t"+
					txnList.get(i).getOriginator_point()+"\t"+
					txnList.get(i).getAcquirer_id()+"\t"+
					txnList.get(i).getTransaction_orig_institution_pid()+"\t"+
					txnList.get(i).getAcquirer_name_and_country()+"\t"+
					txnList.get(i).getIin()+"\t"+
					txnList.get(i).getTransaction_destination_institution_pid()+"\t"+
					txnList.get(i).getIssuer_name_and_country()+"\t"+
					txnList.get(i).getVehicle_registration_number()+"\t"+
					txnList.get(i).getVehicle_class()+"\t"+
					txnList.get(i).getVehicle_type()+"\t"+
					txnList.get(i).getFinancial_non_financial_indicator()+"\t"+
					txnList.get(i).getDispute_reason_code()+"\t"+
					txnList.get(i).getDispute_reason_code_description()+"\t"+
					txnList.get(i).getDisputed_amount()+"\t"+
					txnList.get(i).getFull_partial_indicator()+"\t"+
					txnList.get(i).getMember_message_text()+"\t"+
					txnList.get(i).getDocument_indicator()+"\t"+
					txnList.get(i).getDocument_attached_date()+"\t"+
					txnList.get(i).getDeadline_date()+"\t"+
					txnList.get(i).getDays_to_act()+"\t"+
					txnList.get(i).getDirection_of_dispute()
					);
			
		}

		return txnList;
	}

	public void insertDisputeAdjTxns(List<DisputeAdjForm> txnList) 
	{

		String sql = "INSERT INTO dispute_adjustment("
				+"report_date, dispute_raise_date, dispute_raised_settlement_date, case_number, function_code, function_code_and_description, transaction_sequence_number,"
				+"tag_id, tid, transaction_date_time, reader_read_date_time, transaction_settlement_date, transaction_amount, settlement_amount, settlement_currency_code," 
				+"note, transaction_id, transaction_type, merchant_id, lane_id, merchant_type, sub_merchant_type, transaction_status, tag_status, avc, wim, originator_point," 
				+"acquirer_id, transaction_orig_institution_pid, acquirer_name_and_country, iin, transaction_destination_institution_pid, issuer_name_and_country, vehicle_registration_number," 
				+"vehicle_class, vehicle_type, financial_non_financial_indicator, dispute_reason_code, dispute_reason_code_description, disputed_amount, full_partial_indicator," 
				+"member_message_text, document_indicator, document_attached_date, deadline_date, days_to_act, direction_of_dispute"
				+ ")"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		
		
		String sql1 = "INSERT INTO recon_master("
				+"msg_identifier, txn_timestamp, tag_id, acq_txn_id, acq_id, toll_plaza_id, txn_type, txn_amount, resp_code, recon_status, recon_date_time"
				+ ")"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

		System.out.println(sql);
		Connection conn = null;
		
		int iteration = 0;

		PreparedStatement pstmt = null, pstmt1 = null;
		PreparedStatement pstmt2 = null;
		String sql2 = "update dispute_adjustment set status = ? where transaction_id=?";//where transaction_id='"+txn_id+"'";
		try  
		{
			conn = new DBConnectionHandler().getConnection();
			for(DisputeAdjForm txn : txnList){
				if(iteration != 0) {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, txn.getReport_date());
					pstmt.setString(2, txn.getDispute_raise_date());
					pstmt.setString(3, txn.getDispute_raised_settlement_date());
					pstmt.setString(4, txn.getCase_number());
					pstmt.setString(5, txn.getFunction_code());
					pstmt.setString(6, txn.getFunction_code_and_description());
					pstmt.setString(7, txn.getTransaction_sequence_number());
					pstmt.setString(8, txn.getTag_id());
					pstmt.setString(9, txn.getTid());
					pstmt.setString(10, txn.getTransaction_date_time());
					pstmt.setString(11, txn.getReader_read_date_time());
					pstmt.setString(12, txn.getTransaction_settlement_date());
					pstmt.setString(13, txn.getTransaction_amount());
					pstmt.setString(14, txn.getSettlement_amount());
					pstmt.setString(15, txn.getSettlement_currency_code());
					pstmt.setString(16, txn.getNote());
					//pstmt.setString(17, txn.getTransaction_id());
					String txnID = txn.getTransaction_id();
					if(txnID.startsWith("'")){
						txnID = txnID.substring(1);
					}
					pstmt.setString(17, txnID);
					pstmt.setString(18, txn.getTransaction_type());
					pstmt.setString(19, txn.getMerchant_id());
					pstmt.setString(20, txn.getLane_id());
					pstmt.setString(21, txn.getMerchant_type());
					pstmt.setString(22, txn.getSub_merchant_type());
					pstmt.setString(23, txn.getTransaction_status());
					pstmt.setString(24, txn.getTag_status());
					pstmt.setString(25, txn.getAvc());
					pstmt.setString(26, txn.getWim());
					pstmt.setString(27, txn.getOriginator_point());
					pstmt.setString(28, txn.getAcquirer_id());
					pstmt.setString(29, txn.getTransaction_orig_institution_pid());
					pstmt.setString(30, txn.getAcquirer_name_and_country());
					pstmt.setString(31, txn.getIin());
					pstmt.setString(32, txn.getTransaction_destination_institution_pid());
					pstmt.setString(33, txn.getIssuer_name_and_country());
					pstmt.setString(34, txn.getVehicle_registration_number());
					pstmt.setString(35, txn.getVehicle_class());
					pstmt.setString(36, txn.getVehicle_type());
					pstmt.setString(37, txn.getFinancial_non_financial_indicator());
					pstmt.setString(38, txn.getDispute_reason_code());
					pstmt.setString(39, txn.getDispute_reason_code_description());
					pstmt.setString(40, txn.getDisputed_amount());
					pstmt.setString(41, txn.getFull_partial_indicator());
					pstmt.setString(42, txn.getMember_message_text());
					pstmt.setString(43, txn.getDocument_indicator());
					pstmt.setString(44, txn.getDocument_attached_date());
					pstmt.setString(45, txn.getDeadline_date());
					pstmt.setString(46, txn.getDays_to_act());
					pstmt.setString(47, txn.getDirection_of_dispute());
					pstmt.executeUpdate();
					
					//String txn_id = txn.getTransaction_id();
					boolean chk1 = validateTransactionId(txnID);
					boolean chk2 = validateDipsuteTransactionId(txnID);
					if(chk1 && chk2)
					{
						String respcode = null;
						System.out.println("found in acqreqpay and disputemasternpci, belongs to us then insert in recon");
						pstmt1 = conn.prepareStatement(sql1);
						pstmt1.setString(1, txn.getCase_number());
						pstmt1.setString(2, GenericUtils.dateConvertToRecon(txn.getTransaction_date_time()));
						pstmt1.setString(3, txn.getTag_id());
						pstmt1.setString(4, txnID);
						pstmt1.setString(5, txn.getAcquirer_id());
						pstmt1.setString(6, txn.getMerchant_id());
						String txnType = txn.getTransaction_type();
						pstmt1.setString(7, txnType);
						pstmt1.setString(8, txn.getSettlement_amount());
						if(txnType.equalsIgnoreCase("DEBIT"))
							respcode = "DRADJ";
						else
							respcode = "CRADJ";
						pstmt1.setString(9, respcode);
						pstmt1.setString(10, "RS");
						pstmt1.setString(11, GenericUtils.todaysDateTime());
						pstmt1.executeUpdate();
						
						pstmt2 = conn.prepareStatement(sql2);
						pstmt2.setString(1, "Matched");
						pstmt2.setString(2, txnID);
						pstmt2.executeUpdate();
						updateDisputeMasterStatus(txnID);//update status of dispute_master as close
						System.out.println("Recon data inserted successfully...");
					}
					else
					{
						updateDipsuteAdjStatus(txnID);//update dispute adj status as matched/unmatched
					}
				}
				iteration++; 
			} 
			System.out.println("Dispute transactions are inserted successfully...........");
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(pstmt!=null)
					pstmt.close();
				if(pstmt1!=null)
					pstmt1.close();
				if(pstmt2!=null)
					pstmt2.close();
				if(conn!=null)
					conn.close();
			} catch (Exception e2) {
				System.out.println("Excepiton while closing dispute insert "+e2.getMessage());
				e2.printStackTrace();
			}
		}
	}
	
	public static void updateDisputeMasterStatus(String txn_id)
	{
		Connection con = null;
		PreparedStatement preparedStmt = null;
		String sql = "update dispute_master_npci set status = ?, rodt = ?, remark=? where acq_txn_id=?";//where transaction_id='"+txn_id+"'";
		try
		{
			con = new DBConnectionHandler().getConnection();
			preparedStmt = con.prepareStatement(sql);
		    preparedStmt.setString(1, "Close");
		    preparedStmt.setString(2, GenericUtils.todaysDateTime());
		    preparedStmt.setString(3, "By DisputeFile");
		    preparedStmt.setString(4, txn_id);
		    preparedStmt.executeUpdate();
		    System.out.println("dispute_master_npci status updated Successfully .........");
		}
		catch(Exception e)
		{
			System.out.println("Something wrong while updating dispute_master_npci..."+e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try
			{  
				if(preparedStmt!=null)
					preparedStmt.close();
				if(con!=null)
					con.close();

			} catch (Exception e) {
				e.printStackTrace();

			}

		}
	}
	
	public boolean validateTransactionId(String txnId)
	{
		boolean check=false;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement st= null;
		String sql = "SELECT txn_id FROM acq_req_pay_master where txn_id=?";
		try{
			conn = new DBConnectionHandler().getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, txnId);
		    rs = st.executeQuery();
		    if(rs.next())
		    {
	    	   check=true;
	    	   System.out.println("txn_id found : "+rs.getString("txn_id"));
		    } 
		    else 
		    {
	    	   check=false;
		    }
		    } catch (Exception e){
		       System.out.println("Error while checking adj records in DisputeAdjDao.java"+e.getMessage());
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
				} catch (Exception e2) {
					System.out.println("Exception while closing adjdispute"+e2.getMessage());
					e2.printStackTrace();
				}
			}
		return check;
	}
	public boolean validateDipsuteTransactionId(String txnId)
	{
		boolean check=false;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement st= null;
		
		String sql = "SELECT acq_txn_id FROM dispute_master_npci where acq_txn_id=? and status='Open'";
		try{
			conn = new DBConnectionHandler().getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, txnId);
		    rs = st.executeQuery();
		    if(rs.next())
			{
			   check=true;
			   System.out.println("txn_id found : "+rs.getString("acq_txn_id"));
			} 
		    else 
		    {
		    	check=false;
		    }
		    } catch (Exception e){
		       System.out.println("Error while checking dispute_master_npci records"+e.getMessage());
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
				} catch (Exception e2) {
					System.out.println("Exception while closing dispute_master_npci"+e2.getMessage());
					e2.printStackTrace();
				}
			}
		return check;
	}
	
	public static void updateDipsuteAdjStatus(String txn_id)
	{
			Connection con = null;
			PreparedStatement preparedStmt = null;
			String sql = "update dispute_adjustment set status = ? where transaction_id=?";//where transaction_id='"+txn_id+"'";
			try
			{
				con = new DBConnectionHandler().getConnection();
				preparedStmt = con.prepareStatement(sql);
			    preparedStmt.setString(1, "Txn mismatch with reqpay");
			    preparedStmt.setString(2, txn_id);
			    
			    preparedStmt.executeUpdate();
			    System.out.println("Dispute adj status updated Successfully .........");
			}
			catch(Exception e)
			{
				System.out.println("Something wrong while updating ..."+e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				try
				{  
					if(preparedStmt!=null)
						preparedStmt.close();
					if(con!=null)
						con.close();

				} catch (Exception e) {
					e.printStackTrace();

				}

			}

	}

	}
