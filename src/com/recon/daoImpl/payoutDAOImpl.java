package com.recon.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.recon.utils.DBConnectionHandler;
import com.recon.utils.HibernateUtil;

public class payoutDAOImpl extends HibernateUtil{

	
	
	public Boolean payoutDetails(String conn_id, String toll_plaza_id, String txn_count, String total_amount,
			String net_amount, String hdfc_amount, String acq_amount, String to_date, String from_date) {

		
		Boolean status = false;
		PreparedStatement ps = null;
		Connection con =null;
		ResultSet rs = null;		
			
			String query = null;
			// System.out.println("tagId  :: "+tagId+"  tId  :: "+tId);
			try {
				con = DBConnectionHandler.getConnection();
				if(con!=null)
				{
					con.setAutoCommit(false);
				query ="INSERT INTO payout_master(conn_id,toll_plaza_id,txn_count,total_amount,net_amount,hdfc_amount,acq_amount,to_date,from_date,is_active) VALUES(?,?,?,?,?,?,?,?,?,?)";
				ps = con.prepareStatement(query);
				ps.setString(1,conn_id);
				ps.setString(2,toll_plaza_id);	
				ps.setString(3,txn_count);	
				
				ps.setString(4,total_amount);
				ps.setString(5,net_amount);
				ps.setString(6,hdfc_amount);
				ps.setString(7,acq_amount);
				ps.setString(8,to_date);
				ps.setString(9,from_date);
				ps.setString(10,"1");
				int i = ps.executeUpdate();
				con.commit();
				 if(i>0)
				{
					status = true;
					System.out.println("insert successfully");
				}	
				
			}
				else
				{
					System.out.println("MonthlyPassDaoImpl.java connection is null");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			finally{
				try {
					if(rs!=null)
					{
						rs.close();
						rs=null;
					}
					if(ps!=null)
					{
						ps.close();
						ps=null;
					}
					if(con!=null)
					{
						con.close();
						con=null;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return status;
	
	}
	
	public void payoutDetailsUpdate() {

		
		//Boolean status = false;
		PreparedStatement ps = null;
		Connection con =null;
		ResultSet rs = null;		
			
			String query = null;
			 System.out.println("In payoutDetailsUpdate");
			try 
			{
				con = DBConnectionHandler.getConnection();
				if(con!=null)
				{
					con.setAutoCommit(false);
				query ="update payout_master set is_active=0";
				System.out.println("query :: "+query);
				ps = con.prepareStatement(query);
				ps.executeUpdate();
				con.commit();
				//int i = 
				//System.out.println("i = "+i);
				
				/*if(i>0)
				{
					//status = true;
					System.out.println("update successfully");
				}*/	
				
				}
				else
				{
					System.out.println("payoutDAOImpl.java connection is null");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			finally{
				try {
					if(rs!=null)
					{
						rs.close();
						rs=null;
					}
					if(ps!=null)
					{
						ps.close();
						ps=null;
					}
					if(con!=null)
					{
						con.close();
						con=null;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


	public Boolean insertPayoutData(String from_date, String to_date) {
		
		System.out.println("In insertPayoutData method");
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		Connection con =null;
		ResultSet rs = null;		
			
		String query = null;
		boolean result = false;
			try {
				con = DBConnectionHandler.getConnection();
				if(con!=null)
				{
				query ="select distinct merchant_id from toll_plaza_master ";
				
				ps=con.prepareStatement(query);
				rs=ps.executeQuery();
				
				while(rs.next())
				{
					
					ArrayList< String > list =new ArrayList<>();
					String merchant = rs.getString("merchant_id");
					String sql = " select toll_plaza_id from toll_plaza_master where merchant_id ='"+merchant+"'";
					ps=con.prepareStatement(sql);
					ResultSet rs1 =ps.executeQuery();
					
					while(rs1.next()){

						list.add(rs1.getString("toll_plaza_id"));
					}
					
					Iterator<String> it = list.iterator(); 
					  String tollid= "";
			        while (it.hasNext()) {
			           // System.out.println(it.next()); 
			            if (tollid.equals(""))
			            {
			            	tollid += (String) it.next();
			            }
			            else
			            {
			            	tollid += "'"+","+ "'"+(String) it.next();
			            }
			        	} 
			        String sql1 ="select SUM(txn_amount),count(id) from recon_master where toll_plaza_id in ('"+tollid+""+"') and recon_status = 'RS' and txn_timestamp between '"+from_date+"' and '"+to_date+"'" ;
					PreparedStatement ps2 = con.prepareStatement(sql1);
					ResultSet rs2 =ps2.executeQuery();
					
					while(rs2.next()){

					int amount =rs2.getInt(1);
					String count = rs2.getString(2);
					//System.out.println(" amount " +amount + " count "+count);
					double per =(amount /100)*1.25;
					//String s = String.format(("%.2f", per));
					//System.out.println("per "+per);
					double bankAmount = (per / 100) * 0.9;
					//System.out.println("bankAmount "+bankAmount);
					double AcqAmount = (per - bankAmount);
					//System.out.println("AcqAmount "+AcqAmount);
					double netAmount = (amount - per);
					//System.out.println("netAmount "+netAmount);
					String amountper = String.valueOf(amount);
					String bankAmountnew = String.valueOf(bankAmount);
					String AcqAmountnew = String.valueOf(AcqAmount);
					String netAmountnew = String.valueOf(netAmount);
					String toll_id = tollid.replace("'", "");
					/*String toll[] = toll_id.split(",");
					String comb_toll = "";
					for(String w:toll){  
						comb_toll = comb_toll+" "+w;  
						} */ 
					System.out.println("merchant "+merchant+ " comb_toll "+toll_id +" count " +count +" Total amount " +amount + " netAmount "+netAmount +" AcqAmount " +AcqAmount +" bankAmount " +bankAmount);
					
					
					result =payoutDetails(merchant, toll_id, count, amountper,netAmountnew, bankAmountnew, AcqAmountnew, to_date ,from_date);
					
					
					if(result){
						System.out.println("payout pass inserted successfully ");
						//return mapping.findForward("success");
					}
					
				}
				
				} 
				
			}
				else
				{
					System.out.println("MonthlyPassDaoImpl.java connection is null");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			finally{
				try {
					if(rs!=null)
					{
						rs.close();
						rs=null;
					}
					if(ps!=null)
					{
						ps.close();
						ps=null;
					}
					if(con!=null)
					{
						con.close();
						con=null;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		
		
		return result;
	}
}
