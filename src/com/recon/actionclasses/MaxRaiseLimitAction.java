package com.recon.actionclasses;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.recon.dao.TxnsDao;

/**
 * Servlet implementation class MaxRaiseLimitAction
 */
//@WebServlet("/MaxRaiseLimitAction")
public class MaxRaiseLimitAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaxRaiseLimitAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("*********MaxRaiseLimitAction Call()*********");
		String originalTxnId = null; 
		String amount = null;
		try
		{
			originalTxnId = request.getParameter("originalTxnId");
			amount = request.getParameter("amount");
		}
		catch (Exception e) {
			System.out.println("Exception in MaxRaiseLimitAction :: "+e.getMessage());
			e.printStackTrace();
		}
		
		int txnAmount = TxnsDao.getMaxRaiseLimit(originalTxnId);
		System.out.println("**************txnAmount = "+txnAmount);
		System.out.println("**************amount = "+amount);
		String resp = null;
		if(Integer.valueOf(amount)<=txnAmount && Integer.valueOf(amount)!=0)
		{
			System.out.println("You can raise dispute on given amount");
			resp = "TRUE";
		}
		else
		{
			System.out.println("Sorry, You can not raise dispute on given amount :: "+amount);
			resp = "FALSE";
		}
		System.out.println("*********MaxRaiseLimitAction.java :: Response to API Call()*********");
		System.out.println(resp);
		response.setContentType("text/plain");
		response.setContentType("UTF-8");
		response.getWriter().write(resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
