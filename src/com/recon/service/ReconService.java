package com.recon.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.recon.formclasses.Txns;
import com.recon.utils.DBConnectionHandler;;

public class ReconService 
{
	public String reconNPCI(String rec_Date, String rec_Cycle) 
	{
		CallableStatement callableStatement = null;
		//ResultSet rs = null;
		Connection con = new DBConnectionHandler().getConnection();
		String result = null;
		try 
		{
			SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");
		    Date recdate = originalFormat.parse(rec_Date);
		    SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String finalDate = newFormat.format(recdate);
			String query = "{call pr_recon_npci(?,?)}";//pr_recon_npci    //pr_recontxns
			callableStatement = con.prepareCall(query);
			callableStatement.setString(1, finalDate);
			callableStatement.setString(2, rec_Cycle);
			callableStatement.execute();
			//callableStatement.executeUpdate();
			//callableStatement.close();
			//rs = callableStatement.getResultSet();
			result = "success";
			System.out.println("Procedure executed successfully--->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Success");			
			
		} catch (Exception e) {
			System.out.println("Exception in NPCI procedure <<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Exception: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			
			try {
				if (callableStatement != null) 
					callableStatement.close();
				if (con != null) 
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
		
	
	public void reconCBS(String rec_Date, String rec_Cycle)
	{
		CallableStatement callableStatement = null;
		Connection con = new DBConnectionHandler().getConnection();
		try 
		{
			SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");
		    Date recdate = originalFormat.parse(rec_Date);
		    SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String finalDate = newFormat.format(recdate);
			String query = "{call pr_recon_cbs(?,?)}";//pr_recon_cbs
			callableStatement = con.prepareCall(query);
			callableStatement.setString(1, finalDate);
			callableStatement.setString(2, rec_Cycle);
			callableStatement.execute();
			System.out.println("CBS Procedure executed successfully--->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Success");			
		} 
		catch (Exception e) 
		{
			System.out.println("Exception in cbs procedure <<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Exception: "+e.getMessage());
			e.printStackTrace();
		} 
		finally 
		{
			
			try 
			{
				if (callableStatement != null) 
					callableStatement.close();
				if (con != null) 
					con.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
	
	//for cbs recon
	public void checkCBSreconStatus()//(String cycledate, String cycle) 
	{
		CallableStatement callableStatement = null;
		//ResultSet rs = null;
		Connection con = new DBConnectionHandler().getConnection();
		try 
		{
			String query = "{call pro_cbs_recontxns()}";
			callableStatement = con.prepareCall(query);
			callableStatement.executeUpdate();
			System.out.println("CBS Procedure executed successfully--->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Success");			
		} 
		catch (Exception e) 
		{
			System.out.println("Exception in cbs procedure <<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Exception: "+e.getMessage());
			e.printStackTrace();
		} 
		finally 
		{
			
			try 
			{
				if (callableStatement != null) 
					callableStatement.close();
				if (con != null) 
					con.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
		
		
	public static List<Txns> getNPCIReconSummary()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("getNPCIReconSummary() ");
		String sqllist = "select * from npci_recon_summary order by id desc limit 1";// where recon_status = 'NRNS' and txn_time <= '"+lastdate+"' ORDER BY txn_time";
		List<Txns> summaryList = new ArrayList<Txns>(); 
		try 
		{
			conn = new DBConnectionHandler().getConnection();
			pstmt = conn.prepareStatement(sqllist);
			System.out.println("Query of getNPCIReconSummary :::: "+sqllist);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Txns txn = new Txns();
				txn.setRec_date(rs.getDate("recon_date"));
				txn.setCycle(rs.getString("recon_cycle"));
				txn.setTotal_rec(rs.getInt("total_file_rec"));
				txn.setTotal_match(rs.getInt("total_match_rec"));
				txn.setTotal_mismatch(rs.getInt("total_mismatch_rec"));
				txn.setAlready_recon(rs.getInt("already_recon"));
				txn.setRemark(rs.getString("remarks"));
				summaryList.add(txn);
			}
			 
		}
		catch (Exception e) 
		{
			System.out.println("Exception while getting list of NPCI recon summary : "+e.getMessage());
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
				System.out.println("Exception while closing list of NPCI recon summary"+e2.getMessage());
				e2.printStackTrace();
			}
		}
		return summaryList;
	}
	
	
	public static void main(String[] args) {
		getNPCIReconSummary();
	}
}		
	
