<%@ include file="/include.jsp"%>
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page buffer = "16kb" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>1Pay : Exception Transactions</title>

<!-- VVS -->
<!-- Bootstrap -->
    <link href="reportjs/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="reportjs/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="reportjs/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="reportjs/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="reportjs/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="reportjs/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="reportjs/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="reportjs/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="reportjs/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">
	<link href="reportjs/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="reportjs/bootstrap/dist/css/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="reportjs/build/css/custom.min.css" rel="stylesheet">


<!--  EnD VVS -->

</head>
<body>

<form action="/nrnstxns"  method="post">	
			<fieldset>
				<legend>Exception Transactions Download</legend>	 
 			<div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_content">
                   <logic:notEmpty name="extxnslist">
                    <table id="datatable-buttons" class="table table-striped table-bordered" cellspacing="0" width="100%" >
                      <thead>
						<tr>
						<td>Sr. No</td>
						<td>Transaction ID</td>
						<!-- <td>Message ID</td>
						<td>Note</td>
						<td>Reference ID</td>
						<td>Reference URL</td> -->
						<td>Transaction Date and Time</td>
						<td>Transaction Type</td>
						<td>Original Transaction ID</td>
						<td>Tag ID</td>
						<!-- <td>TID</td>
						<td>AVC</td>
						<td>WIM</td> -->
						<td>Merchant ID</td>
						<!-- <td>Merchant Type</td>
						<td>Sub Merchant Type</td>
						<td>Lane_Id</td>
						<td>Lane_Direction</td>
						<td>Lane_Reader_ID</td>
						<td>Parking_Floor</td>
						<td>Parking_Zone</td>
						<td>Parking_Slot</td>
						<td>Parking_Reader_ID</td> -->
						<td>Reader_Read_Date_and_Time</td>
						<!-- <td>Signature_Data</td>
						<td>Signature_Authentication</td>
						<td>EPC_Verified</td>
						<td>Proc_Restriction_Res</td>
						<td>Vehicle_Auth</td>
						<td>Public_Key_CVV</td>
						<td>Reader_Transaction_Counter</td>
						<td>Reader_Transaction_Status</td>
						<td>Payer_Address</td>
						<td>Issuer_ID</td>
						<td>Payer_Code</td>
						<td>Payer_name</td>
						<td>Payer_Type</td> -->
						<td>Issuer_ID</td>
						<td>Transaction_Amount</td>
						<!-- <td>Currency_Code</td>
						<td>Payee_Address</td> -->
						<td>Acquirer_ID</td>
						<!-- <td>Payee_Code</td>
						<td>Payee_name</td>
						<td>Payee_Type</td>
						<td>Response_Code</td>
						<td>Transaction_Status</td>
						<td>Approval_Number</td>
						<td>payee_Error_Code</td>
						<td>Settled_Amount</td>
						<td>Settled_Currency</td>
						<td>Account_Type</td>
						<td>Available_Balance</td>
						<td>Ledger_Balance</td>
						<td>Account_Number </td>
						<td>Customer_Name</td>
						<td>Initiated_By</td>
						<td>Initiated_Time</td>
						<td>Last_Updated_By</td>
						<td>Last_Updated_Time</td> -->
						<td>Vehicle_Registration_number </td>
						<!-- <td>Vehicle_Class</td>
						<td>Vehicle_Type</td>
						<td>Tag_status</td>
						<td>Tag_Issue_Date</td> -->
						
						<td>Action</td>
						<td>Process Date</td>
					</tr>
				</thead>

             <tbody>
   				<logic:iterate name="extxnslist" id="post">
					<tr>
				     <td><bean:write name="post" property="id" />
					 <td><bean:write name="post" property="transaction_ID" />
					 <%-- <td><bean:write name="post" property="message_ID" />
					 <td><bean:write name="post" property="note" />
					 <td><bean:write name="post" property="reference_ID" />
					 <td><bean:write name="post" property="reference_URL" /> --%>
					 <td><bean:write name="post" property="transaction_Date_and_Time" />
					 <td><bean:write name="post" property="transaction_Type" />
					 <td><bean:write name="post" property="original_transaction_ID" />
					 <td><bean:write name="post" property="tag_ID" />
					<%--  <td><bean:write name="post" property="tID" />
					 <td><bean:write name="post" property="aVC" />
					 <td><bean:write name="post" property="wim" /> --%>
					 <td><bean:write name="post" property="merchant_Id" />
					<%--  <td><bean:write name="post" property="merchant_Type" />
					 <td><bean:write name="post" property="sub_Merchant_Type" />
					 <td><bean:write name="post" property="lane_Id" />
					 <td><bean:write name="post" property="lane_Direction" />
					 <td><bean:write name="post" property="lane_Reader_ID" />
					 <td><bean:write name="post" property="parking_Floor" />
					 <td><bean:write name="post" property="parking_Zone" />
					 <td><bean:write name="post" property="parking_Slot" />
					 <td><bean:write name="post" property="parking_Reader_ID" /> --%>
					 <td><bean:write name="post" property="reader_Read_Date_and_Time" />
					 <%-- <td><bean:write name="post" property="signature_Data" />
					 <td><bean:write name="post" property="signature_Authentication" />
					 <td><bean:write name="post" property="ePC_Verified" />
					 <td><bean:write name="post" property="proc_Restriction_Res" />
					 <td><bean:write name="post" property="vehicle_Auth" />
					 <td><bean:write name="post" property="public_Key_CVV" />
					 <td><bean:write name="post" property="reader_Transaction_Counter" />
					 <td><bean:write name="post" property="reader_Transaction_Status" />
					 <td><bean:write name="post" property="payer_Address" /> --%>
					 <td><bean:write name="post" property="issuer_ID" />
					<%--  <td><bean:write name="post" property="payer_Code" />
					 <td><bean:write name="post" property="payer_name" />
					 <td><bean:write name="post" property="payer_Type" /> --%>
					 <td><bean:write name="post" property="transaction_Amount" />
					<%--  <td><bean:write name="post" property="currency_Code" />
					 <td><bean:write name="post" property="payee_Address" /> --%>
					 <td><bean:write name="post" property="acquirer_ID" />
					 <%-- <td><bean:write name="post" property="payee_Code" />
					 <td><bean:write name="post" property="payee_name" />
					 <td><bean:write name="post" property="payee_Type" />
					 <td><bean:write name="post" property="response_Code" />
					 <td><bean:write name="post" property="transaction_Status" />
					 <td><bean:write name="post" property="approval_Number" />
					 <td><bean:write name="post" property="payee_Error_Code" />
					 <td><bean:write name="post" property="settled_Amount" />
					 <td><bean:write name="post" property="settled_Currency" />
					 <td><bean:write name="post" property="account_Type" />
					 <td><bean:write name="post" property="available_Balance" />
					 <td><bean:write name="post" property="ledger_Balance" />
					 <td><bean:write name="post" property="account_Number" />
					 <td><bean:write name="post" property="customer_Name" />
					 <td><bean:write name="post" property="initiated_By" />
					 <td><bean:write name="post" property="initiated_Time" />
					 <td><bean:write name="post" property="last_Updated_By" />
					 <td><bean:write name="post" property="last_Updated_Time" /> --%>
					 <td><bean:write name="post" property="vehicle_Registration_number" />
					<%--  <td><bean:write name="post" property="vehicle_Class" />
					 <td><bean:write name="post" property="vehicle_Type" />
					 <td><bean:write name="post" property="tag_status" />
					 <td><bean:write name="post" property="tag_Issue_Date" /> --%>	
					 <td><bean:write name="post" property="reason" />
					 <td><bean:write name="post" property="process_date" />									    
				</tr>
			</logic:iterate>
				    
			</tbody>
           </table>
          </logic:notEmpty>
     </div>
     </div>
     </div>
     <html:link href="${pageContext.request.contextPath}/postTxns.do?dispatch=goToAddPage">Home</html:link>
     </fieldset>
</form>


    <!-- jQuery -->
    <script data-cfasync="false" src="/cdn-cgi/scripts/f2bf09f8/cloudflare-static/email-decode.min.js"></script><script src="reportjs/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="reportjs/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="reportjs/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="reportjs/nprogress/nprogress.js"></script>
    <!-- iCheck -->
    <script src="reportjs/iCheck/icheck.min.js"></script>
    <!-- Datatables -->
    <script src="reportjs/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="reportjs/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="reportjs/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="reportjs/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="reportjs/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="reportjs/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="reportjs/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="reportjs/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="reportjs/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="reportjs/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="reportjs/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="reportjs/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
    <script src="reportjs/jszip/dist/jszip.min.js"></script>
    <script src="reportjs/pdfmake/build/pdfmake.min.js"></script>
    <script src="reportjs/pdfmake/build/vfs_fonts.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="reportjs/build/js/custom.min.js"></script>
    
    
    <script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
    
</body>
</html>