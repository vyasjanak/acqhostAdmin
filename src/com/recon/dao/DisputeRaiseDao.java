package com.recon.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.recon.utils.DBConnectionHandler;
import com.recon.utils.GenericUtils;
import com.recon.utils.HibernateUtil;
import java.sql.PreparedStatement;
import com.recon.entities.AcqRequestPay;
import com.recon.entities.DisputeMaster;
public class DisputeRaiseDao 
{
	
	public List getTransactions(String txn_id, String tag_id, String vehicle_no, String merchant_id) 
	{
		System.out.println("AcqDisputeRaiseDao.java ::: getTransactions() :: User : "+merchant_id);
		Session session = HibernateUtil.getSessionFactory().openSession();
		List txns = null;
		try 
		{
			session.beginTransaction();
			if(!merchant_id.equalsIgnoreCase("admin"))
			{
				if (txn_id != null && !txn_id.isEmpty()) {
					txns = session.createQuery("from AcqRequestPay where txn_id= :txn_id and toll_plaza_id= :toll_plaza_id")
							.setParameter("txn_id", txn_id)
							.setParameter("toll_plaza_id", merchant_id)
							.list();
				}
				else if(tag_id != null && !tag_id.isEmpty()) {
					txns = session.createQuery("from AcqRequestPay where tag_id= :tag_id and toll_plaza_id= :toll_plaza_id")
							.setParameter("tag_id", tag_id)
							.setParameter("toll_plaza_id", merchant_id)
							.list();
				}
				else if(vehicle_no != null && !vehicle_no.isEmpty()) {
					txns = session.createQuery("from AcqRequestPay where vehicle_no= :vehicle_no and toll_plaza_id= :toll_plaza_id")
							.setParameter("vehicle_no", vehicle_no)
							.setParameter("toll_plaza_id", merchant_id)
							.list();
				}
			}
			else
			{
				if (txn_id != null && !txn_id.isEmpty()) {
					txns = session.createQuery("from AcqRequestPay where txn_id= :txn_id").setParameter("txn_id", txn_id).list(); 
				}
				else if(tag_id != null && !tag_id.isEmpty()) {
					txns = session.createQuery("from AcqRequestPay where tag_id= :tag_id").setParameter("tag_id", tag_id).list();
				}
				else if(vehicle_no != null && !vehicle_no.isEmpty()) {
					txns = session.createQuery("from AcqRequestPay where vehicle_no= :vehicle_no").setParameter("vehicle_no", vehicle_no).list();
				}
			}
			System.out.println("DisputeRaiseDao :: getTransactions() ExecuteQuery");
		} catch (Exception e) {
			System.err.println("Error getting transactions :" + e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return txns;
	}
	
	/*public List getTransactions(String original_txn_id, String tag_id, String vehicle_no)//, String merchant_id) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		List txns = null;
		try 
		{
			session.beginTransaction();
			if (original_txn_id != null && !original_txn_id.isEmpty()) {
				txns = session.createQuery("from AcqRequestPay where original_txn_id= :original_txn_id").setParameter("original_txn_id", original_txn_id).list(); 
			}
			else if(tag_id != null && !tag_id.isEmpty()) {
				txns = session.createQuery("from AcqRequestPay req where tag_id= :tag_id and original_txn_id not in(select acq_txn_id from DisputeMaster)").setParameter("tag_id", tag_id).list();
			}
			else if(vehicle_no != null && !vehicle_no.isEmpty()) {
				txns = session.createQuery("from AcqRequestPay where vehicle_no= :vehicle_no and original_txn_id not in(select acq_txn_id from DisputeMaster)").setParameter("vehicle_no", vehicle_no).list();
			}
			
			System.out.println("DisputeRaiseDao :: getTransactions() ExecuteQuery");
		} catch (Exception e) {
			System.err.println("Error getting transactions :" + e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return txns;
	}*/
	
	public boolean isDisputed(String acq_txn_id, String tag_id, String vehicle_no) {
		System.out.println("........................................................");
		Session session = HibernateUtil.getSessionFactory().openSession();
		boolean check=false;
		//List txns = null;
		try 
		{
			session.beginTransaction();
			Query query = session.createQuery("select acq_txn_id from DisputeMaster where  acq_txn_id= :acq_txn_id");
			query.setString("acq_txn_id", acq_txn_id);
			return (query.uniqueResult() != null);
			
		} catch (Exception e) {
			System.err.println("Error getting transactions :" + e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return check;
	}
	
	public String addToDisputeMaster(String txn_id, int amount, String dispute_desc, String evidence_doc, String date_time,
			String function_code, String reason_code, String reason_code_type, String full_par_indicator)//, String remark) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try 
		{
			session.beginTransaction();
			DisputeMaster disputeMaster = new DisputeMaster();
			String toll_txn_id = null;
			String toll_plaza_id = null;
			String txn_type = null, tag_id=null, tid=null, txn_time=null, issuer_id=null, acquirer_id=null, txn_amount = null, mmt=null;
			//int amountFP = 0;
			List<AcqRequestPay> txns = getTransactionToDispute(txn_id);
			for (AcqRequestPay req : txns)
			{
				toll_txn_id = req.getOriginal_txn_id();
				toll_plaza_id = req.getToll_plaza_id();
				txn_type = req.getTxn_type();
				tag_id = req.getTag_id();
				tid = req.getTid();
				txn_time = req.getAcq_txn_time();
				issuer_id = req.getOrg_id();
				acquirer_id = req.getAcq_id();
				//txn_amount = Integer.toString((int) req.getTxn_amount());
			}
			disputeMaster.setTag_id(tag_id);
			disputeMaster.setFunction_code(function_code);
			
			Date old_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(txn_time);  
			SimpleDateFormat sdformat = new SimpleDateFormat("yyMMddHHmmss");//in npci bulk dispute format
			String newTxnDate = sdformat.format(old_date);	
			
			disputeMaster.setTxn_time(newTxnDate);
			disputeMaster.setAcq_txn_id(txn_id);
			//String issuerId = NetcUtils.getPropertyValue("issuerId");
			disputeMaster.setIssuer_id(issuer_id);
			disputeMaster.setAcquirer_id(acquirer_id.substring(0,6));
			if(full_par_indicator.equalsIgnoreCase("F"))
			{
				mmt = "Chargeback raised full through file";
				//txn_amount = txn_amount+"00";
				//amount = amount;
			}
			else
			{
				mmt = "Chargeback raised partial through file";
				//amount = amount/2;//used
				//txn_amount = Integer.valueOf(txn_amount)/2;
				//amountFP = Integer.valueOf((txn_amount))/2;
				//txn_amount = Integer.toString(amountFP);
				//txn_amount = txn_amount+"00";
			}
			disputeMaster.setTxn_amount(amount+"00");//this is txnamount this amount is required for format //(Float.toString(amount));//this is raised amount
			disputeMaster.setReason_code(reason_code);
			disputeMaster.setToll_plaza_id(toll_plaza_id);
			disputeMaster.setFull_par_indicator(full_par_indicator);
			disputeMaster.setTid(tid);
			
			disputeMaster.setMmt(mmt);
			disputeMaster.setToll_txn_id(toll_txn_id);
			disputeMaster.setTxn_type(txn_type);
			disputeMaster.setDispute_desc(dispute_desc);
			disputeMaster.setEvidence_doc(evidence_doc);
			disputeMaster.setStatus("Open");
			disputeMaster.setRodt(date_time);
			//disputeMaster.setRemark(remark);
			session.save(disputeMaster);
			session.getTransaction().commit();
			System.out.println("DisputeRaiseDao :: addToDisputeMaster() Dispute transaction saved successfully...");
		}
		catch (Exception e) 
		{
			System.err.println("DisputeRaiseDao :: addToDisputeMaster() Error while saving Dispute transaction :" + e.getMessage());
			e.printStackTrace();
			session.getTransaction().rollback();
			return "failure" ;
		}
		finally
		{
			session.close();
		}
	return "success";
	}
	
	
	public String saveDisputeTxn(String acq_txn_id, String toll_txn_id, String toll_plaza_id, String dispute_type, float amount, String adjustment_type, String dispute_desc, String evidence_doc, String status, String date_time) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try 
		{
			session.beginTransaction();
			DisputeMaster disputeMaster = new DisputeMaster();
			disputeMaster.setAcq_txn_id(acq_txn_id);
			disputeMaster.setToll_txn_id(toll_txn_id);
			disputeMaster.setToll_plaza_id(toll_plaza_id);
			disputeMaster.setDispute_type(dispute_type);
			disputeMaster.setAmount(amount);
			disputeMaster.setAdjustment_type(adjustment_type);
			disputeMaster.setDispute_desc(dispute_desc);
			disputeMaster.setEvidence_doc(evidence_doc);
			disputeMaster.setStatus(status);
			disputeMaster.setDate_time(date_time);
			session.save(disputeMaster);
			session.getTransaction().commit();
			System.out.println("DisputeRaiseDao :: saveDisputeTxn() Dispute transaction saved successfully...");
		}
		catch (Exception e) 
		{
			System.err.println("DisputeRaiseDao :: saveDisputeTxn() Error while saving Dispute transaction :" + e.getMessage());
			e.printStackTrace();
			session.getTransaction().rollback();
			return "failure" ;
		}
		finally
		{
			session.close();
		}
	return "success";
	}
	
	public List<DisputeMaster> getDisputeTxns()
	{
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<DisputeMaster> txnslist = new ArrayList<DisputeMaster>();
        try {
            session.beginTransaction();
            txnslist = session.createQuery("from DisputeMaster").list();
                    /*.setParameter("name", "%" + wfid + "%").list();*/
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Error getting txns list :" + e);
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally
		{
			session.close();
		}
        return txnslist;
    }
	public List<DisputeMaster> getDisputeDoc()
	{
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<DisputeMaster> txnslist = new ArrayList<DisputeMaster>();
        try {
            session.beginTransaction();
            txnslist = session.createQuery("select evidence_doc from DisputeMaster").list();
            System.out.println("getDisputeDoc() ::"+txnslist);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Error getting txns list :" + e);
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally
		{
			session.close();
		}
        return txnslist;
    }
	//by date
	public List<DisputeMaster> getTransactionsByDate(String from_date, String to_date)//, String merchant_id) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		List txns = null;
		
		try 
		{
			session.beginTransaction();
			if (from_date != null && !from_date.isEmpty() && to_date != null && !to_date.isEmpty()) {
				
				from_date = from_date+" 00:00:00";
				to_date = to_date+" 23:59:59";
				txns=session.createQuery("FROM DisputeMaster WHERE status='Open' AND rodt BETWEEN :from_date AND :to_date ")
				.setParameter("from_date", from_date)
				.setParameter("to_date", to_date)
				.list();
			}
			
			System.out.println("DisputeRaiseDao :: getTransactionsByDate() ExecuteQuery");
		} catch (Exception e) {
			System.err.println("Error getting transactions :" + e);
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
		return txns;
	}
	
	public String updateTransaction(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String result=null;
		try 
		{
			session.beginTransaction();
			if (id != 0) 
			{
				String hql = "UPDATE DisputeMaster set status ='Close' "  + 
			             "WHERE id = :id";
				Query query=session.createQuery(hql);
				query.setParameter("id", id);
				query.executeUpdate();
				session.getTransaction().commit();
				System.out.println("DisputeRaiseDao :: updateTransaction() ExecuteQuery");
				result="success";
			}
			else
			{
				result="failure";
			}
		} catch (Exception e) {
			System.err.println("Error getting transactions :" + e);
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally
		{
			session.close();
		}
		return result;
	}
		
	public static List<AcqRequestPay> getTransactionToDispute(String txn_id)//, String merchant_id) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<AcqRequestPay> txns = new ArrayList<>();
		try 
		{
			session.beginTransaction();
			if (txn_id != null && !txn_id.isEmpty()) {
				txns = session.createQuery("from AcqRequestPay where txn_id= :txn_id").setParameter("txn_id", txn_id).list(); 
			}
			System.out.println("DisputeRaiseDao :: getTransactionToDispute() ExecuteQuery");
		} catch (Exception e) {
			System.err.println("Error getting dipsute transactions :" + e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return txns;
	}
	
	
	
	
	public static void main1(String[] args) throws Exception{
		List<AcqRequestPay> txns = getTransactionToDispute("00102620481");
		System.out.println("Dispute record "+txns);
		for (AcqRequestPay d : txns)
		{
			System.out.println("......"+d.getOriginal_txn_id());
			System.out.println("......"+d.getTag_id());
			System.out.println("......"+d.getTxn_amount());
		}
		String s="720301@iin.npci";
		String s2 = s.substring (0,6);
		System.out.println(s2);
		String txn_time = "2018-04-30 07:17:48";
		String dDate="Sat Apr 11 12:16:44 IST 2015";
		DateFormat formatter = new SimpleDateFormat("yyMMDDHHmmss");
		Date date = formatter.parse(txn_time);
		System.out.println(date);
		Date date1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(txn_time);  
		SimpleDateFormat sdformat = new SimpleDateFormat("yyMMddHHmmss");
	    System.out.println(sdformat.format(date1));
	}
	
	private ArrayList reasonCodeList1;
	public ArrayList getReasonCodeList1() {
		return reasonCodeList1;
	}
	public void setReasonCodeList1(ArrayList reasonCodeList1) {
		this.reasonCodeList1 = reasonCodeList1;
	}
	public static ArrayList getReasonList1() 
	{
	    ArrayList reasonList1 = new ArrayList();
	    reasonList1.add(new ReasonData("3001", "NETC Toll services not availed/ Tag holder does not recognise the transaction"));
	    reasonList1.add(new ReasonData("3002", "Duplicate transaction done at Toll Plaza"));
	    reasonList1.add(new ReasonData("3003", "Vehicle was in exempted list"));
	    reasonList1.add(new ReasonData("3004", "Vehicle was in black list"));
	    reasonList1.add(new ReasonData("3005", "Vehicle was in low balance list"));
	    reasonList1.add(new ReasonData("3006", "Toll fare calculation error"));
	    reasonList1.add(new ReasonData("3007", "Vehicle class mismatch"));
	    reasonList1.add(new ReasonData("3008", "Signature not validated"));
	    reasonList1.add(new ReasonData("3009", "Wrong Debit Adjustment raised"));
	    reasonList1.add(new ReasonData("3010", "Credit posted as Debit"));
	    reasonList1.add(new ReasonData("3011", "Paid by other means"));
	    reasonList1.add(new ReasonData("3012", "Fraudulent tagholder not present transaction"));
	    reasonList1.add(new ReasonData("3013", "Fraudulent multiple transaction"));
	    reasonList1.add(new ReasonData("3014", "Other Specify"));
	    //System.out.println(reasonList1);
		return reasonList1;
	}
	
	public static ArrayList getReasonList2() 
	{
	    ArrayList reasonList1 = new ArrayList();
	    reasonList1.add(new ReasonData("3015", "NETC Toll services not availed/ Tag holder does not recognise the transaction"));
	    reasonList1.add(new ReasonData("3016", "Toll fare calculation error"));
	    reasonList1.add(new ReasonData("3017", "Vehicle class mismatch"));
	    reasonList1.add(new ReasonData("3018", "Wrong Credit Adjustment raised"));
	    reasonList1.add(new ReasonData("3019", "Debit posted as Credit"));
	    reasonList1.add(new ReasonData("3020", "Paid by other means"));
	    reasonList1.add(new ReasonData("3021", "Fraudulent multiple transaction"));
	    reasonList1.add(new ReasonData("3022", "Other Specify"));
	    //System.out.println(reasonList1);
		return reasonList1;
	}
	
	public static ArrayList getReasonList3() //Reason Code for Re-presentment
	{
	    ArrayList reasonList1 = new ArrayList();
	    reasonList1.add(new ReasonData("4001", "Supporting Documents for services availed/valid transactions"));
	    reasonList1.add(new ReasonData("4002", "Supporting Documents for multiple passing"));
	    reasonList1.add(new ReasonData("4003", "Proof of Vehicle is not in exempted List"));
	    reasonList1.add(new ReasonData("4004", "Proof of Vehicle is not in black list"));
	    reasonList1.add(new ReasonData("4005", "Proof of Vehicle is not in  low balance list"));
	    reasonList1.add(new ReasonData("4006", "Proof of valid Toll Fare calculation"));
	    reasonList1.add(new ReasonData("4007", "Proof of valid Vehicle class"));
	    reasonList1.add(new ReasonData("4008", "Proof of successful response"));
	    reasonList1.add(new ReasonData("4009", "Proof of successful signature validation"));
	    reasonList1.add(new ReasonData("4010", "Other Specify"));
		return reasonList1;
	}
	
	public static ArrayList getReasonList4() //Reason Code for Debit Adjustment
	{
	    ArrayList reasonList1 = new ArrayList();
	    reasonList1.add(new ReasonData("1001", "Toll fare calculation error"));
	    reasonList1.add(new ReasonData("1002", "Vehicle class mismatch"));
	    reasonList1.add(new ReasonData("1003", "Unregistered Tag in the mapper"));
	    reasonList1.add(new ReasonData("1004", "Vehicle is not in exempted list"));
	    reasonList1.add(new ReasonData("1005", "Vehicle is not in black list"));
	    reasonList1.add(new ReasonData("1006", "Vehicle is not in low balance list"));
	    reasonList1.add(new ReasonData("1007", "Other Specify"));
		return reasonList1;
	}
	
	public static ArrayList getReasonList5() //Reason Code for Credit Adjustment
	{
	    ArrayList reasonList1 = new ArrayList();
	    reasonList1.add(new ReasonData("2001", "Toll fare calculation error"));
	    reasonList1.add(new ReasonData("2002", "Duplicate transaction done at Toll Plaza"));
	    reasonList1.add(new ReasonData("2003", "Tag holder was charged for unsuccessful transaction"));
	    reasonList1.add(new ReasonData("2005", "Paid by other means<"));
	    reasonList1.add(new ReasonData("2006", "Vehicle is in exempted list"));
	    reasonList1.add(new ReasonData("2007", "Other Specify"));
		return reasonList1;
	}
	
	public static ArrayList getReasonList6() //Reason Code for Pre-compliance and Compliance
	{
		ArrayList reasonList1 = new ArrayList();
	    reasonList1.add(new ReasonData("5001", "Tag is not NETC Tag"));
	    reasonList1.add(new ReasonData("5002", "Tag is not as per the EPC Guidelines"));
	    reasonList1.add(new ReasonData("5003", "Tag Vendor not certified by NPCI"));
	    reasonList1.add(new ReasonData("5004", "Other Specify"));
		return reasonList1;
	}
	public void addToRecon(String acqTxnId,String amount)
	{
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		Connection conn =null;
		String sql1 = "INSERT INTO recon_master("
				+"msg_identifier, txn_timestamp, tag_id, acq_txn_id, acq_id, toll_plaza_id, txn_type, txn_amount, resp_code, recon_status, recon_date_time"
				+ ")"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		String sql2 = "select * from acq_req_pay_master where txn_id=?";
			try  
			{
				conn = new DBConnectionHandler().getConnection();
				pstmt1 = conn.prepareStatement(sql2);
				pstmt1.setString(1, acqTxnId);
				rs = pstmt1.executeQuery();
				if(rs.next()){
					pstmt = conn.prepareStatement(sql1);
					pstmt.setString(1, rs.getString("message_identifier"));
					pstmt.setString(2, rs.getString("acq_txn_time"));
					pstmt.setString(3, rs.getString("tag_id"));
					pstmt.setString(4, rs.getString("txn_id"));
					pstmt.setString(5, rs.getString("acq_id"));
					pstmt.setString(6, rs.getString("toll_plaza_id"));
					String txnType = rs.getString("txn_type");
					pstmt.setString(7,txnType);
					String respcode = null;
					if(txnType.equalsIgnoreCase("DEBIT"))
						respcode = "DRADJ";
					else
						respcode = "CRADJ";
					pstmt.setString(8, amount);
					pstmt.setString(9, respcode);
					pstmt.setString(10, "RS");
					pstmt.setString(11, GenericUtils.todaysDateTime());
					pstmt.executeUpdate();
					System.out.println("Dispute has closed and insert in recon successfully...");
				}
				else
				{
					System.out.println("While closing dispute individually txn id not found");
				}
			}
			catch (Exception e) {
				System.out.println("Exception in insert to recon while closing individual dispute :: "+e.getMessage());
				e.printStackTrace();
			}
			finally {
				try {
					if(pstmt!=null)
						pstmt.close();
					if(pstmt1!=null)
						pstmt1.close();
					if(conn!=null)
						conn.close();
				} catch (Exception e2) {
					System.out.println("Excepiton while closing dispute insert "+e2.getMessage());
					e2.printStackTrace();
				}
			}
	}
	
	public List getPayoutByDate(String from_date, String to_date) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List txns = null;
		try 
		{
			session.beginTransaction();
			if (from_date != null && !from_date.isEmpty() && to_date != null && !to_date.isEmpty()) {
				
				txns=session.createQuery("FROM PayoutMaster WHERE is_active= '1' ").list();
				//.setParameter("from_date", from_date)
				//.setParameter("to_date", to_date)
				
				/*txns = session.createQuery("from RequestPay where txn_id= :txn_id").setParameter("txn_id", from_date).list();*/ 
			}
			session.getTransaction().commit();
			System.out.println("DisputeRaiseDao :: getTransactionsByDate() ExecuteQuery ");
		} catch (Exception e) {
			System.err.println("Error getting transactions :" + e);
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return txns;
	}

}

/*Map<String, String> map = new HashMap<String, String>();
map.put("3001", "NETC Toll services not availed/ Tag holder does not recognise the transaction");
map.put("3002", "Duplicate transaction done at Toll Plaza");
map.put("3003", "Vehicle was in exempted list");
map.put("3004", "Vehicle was in black list");
map.put("3005", "Vehicle was in low balance list");
map.put("3006", "Toll fare calculation error");
map.put("3007", "Vehicle class mismatch");
map.put("3008", "Signature not validated");
map.put("3009", "Wrong Debit Adjustment raised");
map.put("3010", "Credit posted as Debit");
map.put("3011", "Paid by other means");
map.put("3012", "Fraudulent tagholder not present transaction");
map.put("3013", "Fraudulent multiple transaction");
map.put("3014", "Other Specify");
System.out.println(map);*/
