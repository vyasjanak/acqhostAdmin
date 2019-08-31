package com.recon.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.recon.entities.DropdownBean;
import com.recon.entities.Reader;
import com.recon.utils.DBConnectionHandler;
import com.recon.utils.HibernateUtil;

public class ReaderDAOImpl extends HibernateUtil {
	
	public String addReader(Reader reader){
		Connection con = null;
		PreparedStatement ps = null;
		String query = null;
		String status = "-1";
		
		try {
			con = new DBConnectionHandler().getConnection();
			query = "INSERT INTO `reader_master`(`reader_id`,`toll_plaza_id`,`lane_id`,`is_active`,`created_on`,`created_by`,`approved_on`,`approved_by`)VALUES(?,?,?,?,now(),?,now(),?);";
			ps = con.prepareStatement(query);
			ps.setString(1, reader.getReaderId());
			ps.setString(2, reader.getTollplazaId());
			ps.setString(3, reader.getLaneId());
			ps.setString(4, reader.getIsActive());
			ps.setString(5, reader.getCreatedBy());
			ps.setString(6, reader.getApprovedBy());
			ps.executeUpdate();
			status = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return status;
	}

	public String approveReader(Reader read) {
		Connection con = null;
		PreparedStatement ps = null;
		String query = null;
		String status = "-1";
		
		try {
			con = new DBConnectionHandler().getConnection();
			query = "UPDATE reader_master SET approved_on=now(),approved_by=? where id=?";
			ps = con.prepareStatement(query);
			ps.setString(1, read.getApprovedBy());
			ps.setString(2, read.getId());
			ps.executeUpdate();
			status = "1";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
		return status;
	}
	
	public List<DropdownBean> getTollIds() {
		List<DropdownBean> serviceProviders = new ArrayList<DropdownBean>();
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		org.hibernate.Session session = getSession();
		Connection con = session.connection();
		
		try {
			String query = "{call pro_TollIdList()}";
			callableStatement = con.prepareCall(query);
			
			callableStatement.execute();
			 
			rs = callableStatement.getResultSet();
			
			if (rs != null) {
				while (rs.next()) {
					DropdownBean dropdownBean = new DropdownBean();
					dropdownBean.setCode(rs.getString("toll_plaza_id"));
					dropdownBean.setName(rs.getString("toll_name"));
					serviceProviders.add(dropdownBean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			try {
				if (rs != null) rs.close();
				if (callableStatement != null) callableStatement.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return serviceProviders;
	}

	
	public List<List<String>> getReaderDetails() {
		List<List<String>> readerData = null;
		List<String> readerList = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = new DBConnectionHandler().getConnection();
			String query = "{call pro_ReaderList()}";
			System.out.println("Calling Procedure pro_ReaderList()");
			callableStatement = con.prepareCall(query);
			callableStatement.execute();
	
			rs = callableStatement.getResultSet();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			if (rs != null) {
				readerData = new ArrayList<List<String>>();
				List<String> headerNames = new ArrayList<String>();
				for (int i = 1; i <= columnCount; i++) {
					headerNames.add(rsmd.getColumnLabel(i));
				}
				readerData.add(headerNames);
				while (rs.next()) {
					readerList = new ArrayList<String>();
					for (int i = 1; i <= columnCount; i++) {
						readerList.add(rs.getString(rsmd.getColumnLabel(i)));
					}
					readerData.add(readerList);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// session.close();
			try {
				if (rs != null) rs.close();
				if (callableStatement != null) callableStatement.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return readerData;
		
	}
	
	
}
