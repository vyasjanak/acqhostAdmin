package com.recon.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.recon.utils.DBConnectionHandler;
import com.recon.utils.HibernateUtil;
import com.recon.entities.DisputeMaster;
import com.recon.entities.AcqRequestPay;
public class AcqDisputeRaiseDao 
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
					//System.out.println("Executed...");	
					/*String hql = "from RequestPay where txn_id= :txn_id and merchant_id= :merchant_id";      
				            System.out.println(hql);
				            Query query = session.createQuery(hql);
				            query.setParameter("txn_id", txn_id);
				            query.setParameter("merchant_id", merchant_id);
				            txns = query.list();*/
				}
				else if(tag_id != null && !tag_id.isEmpty()) {
					txns = session.createQuery("from AcqRequestPay where tag_id= :tag_id and merchant_id= :merchant_id")
							.setParameter("tag_id", tag_id)
							.setParameter("toll_plaza_id", merchant_id)
							.list();
				}
				else if(vehicle_no != null && !vehicle_no.isEmpty()) {
					txns = session.createQuery("from AcqRequestPay where vehicle_no= :vehicle_no and merchant_id= :merchant_id")
							.setParameter("vehicle_no", vehicle_no)
							.setParameter("toll_plaza_id", merchant_id)
							.list();
				}
				//session.getTransaction().commit();
				
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
				//session.getTransaction().commit();
			}
			System.out.println("DisputeRaiseDao :: getTransactions() ExecuteQuery");
		} catch (Exception e) {
			System.err.println("Error getting transactions :" + e);
			e.printStackTrace();
			//session.getTransaction().rollback();
		}
		finally
		{
			session.close();
		}
		return txns;
	}
	
	public boolean isDisputed(String acq_txn_id, String tag_id, String vehicle_no) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		boolean check=false;
		//List txns = null;
		try 
		{
			session.beginTransaction();
			Query query = session.createQuery("select 2 from DisputeMaster where  acq_txn_id= :acq_txn_id");
			query.setString("acq_txn_id", acq_txn_id);
			return (query.uniqueResult() != null);
			
			/*if (txn_id != null && !txn_id.isEmpty()) {
				txns = session.createQuery("from DisputeMaster where txn_id= :txn_id").setParameter("txn_id", txn_id).list(); 
			}
			else if(tag_id != null && !tag_id.isEmpty()) {
				txns = session.createQuery("from DisputeMaster where tag_id= :tag_id").setParameter("tag_id", tag_id).list();
			}
			else if(vehicle_no != null && !vehicle_no.isEmpty()) {
				txns = session.createQuery("from DisputeMaster where vehicle_no= :vehicle_no").setParameter("vehicle_no", vehicle_no).list();
			}*/
			
		} catch (Exception e) {
			System.err.println("Error getting transactions :" + e.getMessage());
			e.printStackTrace();
			//session.getTransaction().rollback();
		}
		finally
		{
			session.close();
		}
		return check;
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
	
	public List<DisputeMaster> getTransactionsByDate(String from_date, String to_date)//, String merchant_id) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		List txns = null;
		/*Connection dbConnection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		String userIdSql = "{call proc_MerchantBase(?,?,?)}";*/
		try 
		{
			session.beginTransaction();
			if (from_date != null && !from_date.isEmpty() && to_date != null && !to_date.isEmpty()) {
				
				from_date = from_date+" 00:00:00";
				to_date = to_date+" 23:59:59";
				txns=session.createQuery("FROM DisputeMaster WHERE status='Open' AND date_time BETWEEN :from_date AND :to_date ")
				.setParameter("from_date", from_date)
				.setParameter("to_date", to_date)
				.list();
				/*txns = session.createQuery("from RequestPay where txn_id= :txn_id").setParameter("txn_id", from_date).list();*/ 
			}
			/*if(!merchant_id.equalsIgnoreCase("admin"))
			{
					dbConnection = new DBConnection().getConnection();
					callableStatement = dbConnection.prepareCall(userIdSql);

					callableStatement.setString(1, from_date);
					callableStatement.setString(2, to_date);
					callableStatement.setString(3, merchant_id);
					callableStatement.executeUpdate();
					rs = (ResultSet) callableStatement.executeQuery();
					while(rs.next())
					{
						System.out.println(rs.getString(1));
						System.out.println(rs.getString(2));
						//txns.add(rs.getString(1));
					}
					System.out.println("Called procedure :"+txns);
					return txns;				
						
			}*/
			//session.getTransaction().commit();
			System.out.println("DisputeRaiseDao :: getTransactionsByDate() ExecuteQuery");
		} catch (Exception e) {
			System.err.println("Error getting transactions :" + e);
			e.printStackTrace();
			//session.getTransaction().rollback();
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
	
}
