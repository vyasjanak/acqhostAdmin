package com.recon.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.recon.entities.TblMerchantMaster;


public class ListDao 
{
	private SessionFactory sessionfactory;
	private Session session;
  
	public ListDao()
	{
		if (this.sessionfactory == null) 
		{
			this.sessionfactory = new Configuration().configure().buildSessionFactory();
		}
		this.session = this.sessionfactory.openSession();
	}
	
	//for merchants
	private List<TblMerchantMaster> merchants;

	public List<TblMerchantMaster> getMerchants() {
		return merchants;
	}
	public void setMerchants(List<TblMerchantMaster> merchants) {
		this.merchants = merchants;
	}
	
	public List<TblMerchantMaster> listMerchants()
	{
	    System.out.println("ListDao :: Fetch Merchants");
	    Query qr = this.session.createQuery("from TblMerchantMaster");
	    
	    List<TblMerchantMaster> merchants = new ArrayList<TblMerchantMaster>();
	    merchants = qr.list();
	    //System.out.println("Merchants..."+merchants);
	    return merchants;
	}
	

}
