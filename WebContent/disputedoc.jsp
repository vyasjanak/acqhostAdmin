<%@ include file="/include.jsp"%>
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page buffer = "16kb" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<script type="text/javascript">
function searchDisputeTxns(method)
{
	var invalid=0;
	if (document.getElementById("from_date").value == "" && document.getElementById("to_date").value == "") 
	{
		alert("Please enter from-date and to-date to download transactions.");
		document.getElementById("from_date").focus();
		invalid = 1;
	}
	else if(document.getElementById("from_date").value == "")
	{
		document.getElementById("from_date_span").innerHTML = "Please enter from date.";
		document.getElementById("from_date").focus();
		valueBackground("from_date_span");
		invalid = 1;
	}
	else if(document.getElementById("to_date").value == "")
	{
		document.getElementById("to_date_span").innerHTML = "Please enter to date.";
		document.getElementById("to_date").focus();
		valueBackground("to_date_span");
		invalid = 1;
	}
	
	if(invalid != 0)
	{
		return false;
	}
	else
	{
		var form = document.getElementById('formAdd');
		form.elements["dispatch"].value = method;
		
		form.submit();
		form.reset();
		return false;
	}	
}

function valueBackground(id)
{
	document.getElementById(id).style.color = 'red';  
	document.getElementById(id).style.fontWeight = 'bold';
}
function valueChange(id)
{
	document.getElementById(id).innerHTML ="";
}

function downloadCall(method,acq_txn_id) {
	if(acq_txn_id!=null)
	{
		alert(acq_txn_id);
		var form = document.getElementById('formAdd');
		form.elements["acq_txn_id"].value = acq_txn_id;
		form.elements["dispatch"].value = method;
		form.submit();
	}
} 

function validateAction(obj)
{
	//alert(obj);
	var obj1=obj;
	//alert(document.getElementById("actionName"));
	document.getElementById("actionName").value = obj1;
	//alert(obj1);
	document.forms[0].action = "/MerchantAcq/docDispute.do";
	//alert(document.forms[0].action);
	document.forms['formAdd'].submit();
	//alert(obj);
}


function downloadDocument(method)
{
	var invalid=0;
	
	if(invalid != 0)
	{
		return false;
	}
	else
	{
		var form = document.getElementById('formAdd1');
		//form.elements["dispatch"].value = method;
		
		form.submit();
		form.reset();
		return false;
	}	
}

function dwonloadDisputeTxns(method)
{
	var invalid=0;
	if(true)
	{
		var form = document.getElementById('formAddCSV');
		form.elements["dispatch"].value = method;
		form.submit();
		form.reset();
		return false;
	}	
}

/* alert('hello');document.getElementById('formAdd').submit(); */

</script>

<title>1Pay : Dispute File</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <meta charset="utf-8" /> -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="" name="description" />
<meta content="" name="author" />
<!-- end: META -->
<!-- start: GOOGLE FONTS -->
<link
	href="http://fonts.googleapis.com/css?family=Lato:300,600,600italic,600,700|Raleway:300,600,500,600,700|Crete+Round:600italic"
	rel="stylesheet" type="text/css" />
<!-- end: GOOGLE FONTS -->
<!-- start: MAIN CSS -->
<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="vendor/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="vendor/themify-icons/themify-icons.min.css">
<link href="vendor/animate.css/animate.min.css" rel="stylesheet" media="screen">
<link href="vendor/perfect-scrollbar/perfect-scrollbar.min.css" rel="stylesheet" media="screen">
<link href="vendor/switchery/switchery.min.css" rel="stylesheet" media="screen">
<link href="vendor/bootstrap-datepicker/bootstrap-datepicker3.standalone.min.css" rel="stylesheet" media="screen">
				
		
<link rel="stylesheet" href="assets/css/styles.css">
<link rel="stylesheet" href="assets/css/plugins.css">
<link rel="stylesheet" href="assets/css/themes/theme-1.css" id="skin_color" />

<!-- here is validation --> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<!-- spk -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">  
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.css" rel="stylesheet">  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>  
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>
   
<link href="vendor/bootstrap-datepicker/bootstrap-datepicker3.standalone.min.css" rel="stylesheet" media="screen">
<link href="vendor/bootstrap-timepicker/bootstrap-timepicker.min.css" rel="stylesheet" media="screen">
<!-- end: MAIN CSS -->
<!-- start: CLIP-TWO CSS -->
<link rel="stylesheet" href="assets/css/styles.css">
<link rel="stylesheet" href="assets/css/plugins.css">
<link rel="stylesheet" href="assets/css/themes/theme-1.css" id="skin_color" />
<link rel="stylesheet" href="css/style.min.css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>  
<!-- <script type="text/javascript" src="js/tollplaza.js"></script> -->

<style>
a#step4:before {
	max-width: 50%;
	width: 50%;
}
</style>
<style type="text/css">
.nav-tabs>li.active>a, .nav-tabs>li.active>a:hover, .nav-tabs>li.active>a:focus
	{
	background-color: rgb(4, 167, 237);
	color: White;
}

header .navbar-collapse {
	background-color: rgb(221, 221, 232) !important;
}

.navbar .navbar-header {
	height: 50px;
}

.navbar .navbar-header a {
	height: 50px;
	line-height: 50px;
}

#sidebar {
	top: 50px !important;
}

#navbar-top {
	height: 50px;
}

#navbar-heading {
	height: 50px !important;
	background-color: #4981af !important;
}

#navbar_header_1 {
	background-color: #367fa9 !important;
	border-right: 1px solid transparent !important;
}

#user-dropdown {
	padding-top: 3px;
	padding-bottom: 3px;
}

#dashboard {
	margin-top: 5px;
	margin-bottom: 5px;
	font-weight: 500;
	font-size: 24px;
	color: black;
}

.fieldTextblink {
	font-size: 10px;
	font-family: "Verdana";
	color: #cc0000;
	text-decoration: none;
	font-weight: bold;
}
/* .app-navbar-fixed
             {
              padding-top:50px !important;
                 }*/
                 
/* td {
    border:1px solid grey;
    padding:5px;
}   
.fitTo10 { width:10%; }    */ 
a.export,
a.export:visited {
  display: inline-block;
  text-decoration: none;
  color: #000;
  background-color: #ddd;
  border: 1px solid #ccc;
  padding: 8px;
}          
                 
</style>

<style type="text/css">

div.scrollmenu {
    /* background-color: #333; */
    overflow-x: auto;
    white-space: nowrap;
}

div.scrollmenu a {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px;
    text-decoration: none;
}

div.scrollmenu a:hover {
    background-color: #777;
}

</style>
</head>

<body onload="pageLoad()">
	<div id="app">
		<!-- sidebar -->
		<div class="sidebar app-aside" id="sidebar">
			<%@ include file="/sidemenu.jsp"%>
		</div>

		<!-- / sidebar -->

		<div class="app-content">
			<!-- start: TOP NAVBAR -->
			<header class="navbar navbar-default navbar-static-top"
				id="navbar-top">
				<!-- start: NAVBAR HEADER -->
				<div class="navbar-header" style="height: 50px;"
					id="navbar_header_1">
					<a href="#"
						class="sidebar-mobile-toggler pull-left hidden-md hidden-lg"
						style="color: white !important;"
						class="btn btn-navbar sidebar-toggle"
						data-toggle-class="app-slide-off" data-toggle-target="#app"
						data-toggle-click-outside="#sidebar"> <i
						class="ti-align-justify"></i>
					</a> <a class="navbar-brand" href="#"> <!-- <img style = "height:50px; width:180px;" src="assets/images/logo.png" alt="PMC BANK"/> -->
						<h2 class="mainTitle" style="margin: 5px 0px; color: white;">1Pay</h2>
					</a> <a href="#"
						class="sidebar-toggler pull-right visible-md visible-lg"
						style="color: white !important;"
						data-toggle-class="app-sidebar-closed" data-toggle-target="#app">
						<i class="ti-align-justify"></i>
					</a> <a class="pull-right menu-toggler visible-xs-block"
						id="menu-toggler" style="color: white !important;"
						data-toggle="collapse" href=".navbar-collapse"> <span
						class="sr-only">Toggle navigation</span> <i class="ti-view-grid"></i>
					</a>
				</div>
				<!-- end: NAVBAR HEADER -->
				<!-- start: NAVBAR COLLAPSE -->
				<div class="navbar-collapse collapse" id="navbar-heading">
					<%@ include file="/header.jsp"%>
				</div>
			</header>
			<!-- end: TOP NAVBAR -->
			<div class="main-content">
				<div class="wrap-content container" id="container">
					<!-- start: PAGE TITLE -->

					<section id="page-title" style="padding: 0px 0px;">
						<div class="row">
							<div class="col-sm-7">
								<h4 class="mainTitle" id="dashboard">Dispute File</h4>
							</div>
						</div>
					</section>
					<!-- end: PAGE TITLE -->
					<!-- start: WIZARD DEMO -->

					<div class="container-fluid container-fullw bg-white">
						<div class="row">
							<br>
							
								<font color="green" size=3> 
									<logic:present name="success">
									<script type="text/javascript">alert('Dispute transactions posted successfully...!!!');</script>
									</logic:present>
								</font>
					
								<font color="red" size=3> 
									<logic:present name="failure">
									<script type="text/javascript">alert('Ooops, an error occurred, Please check file format...!!!');</script>
									</logic:present>
								</font>
								<font color="red" size=2> 
									<logic:present name="datefailure">
										<script type="text/javascript">alert('Sorry!!!Between dates transactions not found');</script>
									</logic:present>
								</font> 
								
								<html:form action="/docDispute" method="post" styleId="formAdd">
									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<html:hidden property="dispatch" />
											</div>
										</div>
									</div>
									<br>
									<fieldset>
										<legend>Disputed Transaction File Download</legend>
										<html:hidden property="id"/>
										<div class="col-md-12">
											<div class="row">
												<div class="col-md-3">
													<label class="control-label"> From-Date : <span class="symbol required"></span><span id="from_date_span"></span></label>
													
													<html:text styleClass="form-control" property="from_date" styleId="from_date" onchange="javascript:valueChange('from_date_span');" />
													     
												</div>
												<div class="col-md-3">
													<label class="control-label"> To-Date : <span class="symbol required"></span><span id="to_date_span"></span></label>
													<html:text styleClass="form-control" property="to_date" styleId="to_date" onchange="javascript:valueChange('to_date_span');" />
														<%-- <input  class="form-control" type="text" placeholder="click to show datepicker"  id="to_date">
														<html:text property="file" styleClass="form-control" styleId="to_date" /> --%>
 														<!-- <input type='text' class="form-control" id='to_date'> --> 
												</div>
												<div class="col-md-3">
													<html:button value="Search" property="" styleClass="btn btn-primary btn-o" onclick="searchDisputeTxns('getTransactionsUsingDate')" style="margin-top: 23px;"/>
												</div>
											</div>
										</div>
										<br><br><br><br><br><br><br><br>
										
										<!-- to download doc -->
										
										<div id="dvData" style="overflow: auto">
										
										<logic:notEmpty name="disputetxnslist">
										<table style="overflow: auto"> 
											<tr style="font-weight: bold;" bgcolor="#DBEAF9">
												<td>Tag_ID</td>
												<td>Function_Code</td>
												<td>Txn_Time</td>
												<td>Txn_Id</td>
												<td>Issuer_ID</td>
												<td>Acquirer_ID</td>
												<td>Txn_Amount</td>
												<td>Reason_Code</td>
												<td>Full_Partial_Indicator</td>
												<td>Toll_Plaza_Id</td>
												<td>TID</td>
												<td>MMT</td>
												<td>Internal Tracking Number</td>
																																		
												<td>Evidence Doc</td>
											</tr>
										<logic:iterate name="disputetxnslist" id="links">
											<tr >
													<td><bean:write name="links" property="tag_id" />
													<td><bean:write name="links" property="function_code" />
													<td><bean:write name="links" property="txn_time" />
													<td><bean:write name="links" property="acq_txn_id" /> 
													<td><bean:write name="links" property="issuer_id" />
													<td><bean:write name="links" property="acquirer_id" />
													<td><bean:write name="links" property="txn_amount" /> 
													<td><bean:write name="links" property="reason_code" />
													<td><bean:write name="links" property="full_par_indicator" /> 
													<td><bean:write name="links" property="toll_plaza_id" />
													<td><bean:write name="links" property="tid" />
													<td><bean:write name="links" property="mmt" />
													<td><bean:write name="links" property="toll_txn_id" />
													
													<td>
													<c:choose>
															<c:when test="${links.evidence_doc == 'NA'}">
																<bean:write name="links" property="evidence_doc" /> 
															</c:when>
															<c:otherwise>
																<i> 
																<html:hidden property="acq_txn_id" value='<bean:write name="links" property="acq_txn_id" />'/>
																<a href="/acqhostAdmin/download.do?acq_txn_id=<bean:write name="links" property="acq_txn_id"/> ">
																	Download <bean:write name="links" property="acq_txn_id" />
																</a>
																</i>
															</c:otherwise>
													</c:choose>
													</td>
													
											</tr>
										</logic:iterate>
										</table>
									</logic:notEmpty>
										
										<%-- <logic:notEmpty name="disputetxnslist">
										<table> 
											<tr style="font-weight: bold;">
												<td bgcolor="#4981af" align="center"><font color="white">Sr.No.</font></td>
												<td bgcolor="#4981af" align="center"><font color="white">AcqTxnId</font></td>
												<td bgcolor="#4981af" align="center"><font color="white">TollTxnId</font></td>
												<td bgcolor="#4981af" align="center"><font color="white">TollPlazaId</font></td>
												<td bgcolor="#4981af" align="center"><font color="white">DisputeType</font></td>
												<td bgcolor="#4981af" align="center"><font color="white">Amount</font></td>
												<td bgcolor="#4981af" align="center"><font color="white">AdjustmentType</font></td>
												<td bgcolor="#4981af" align="center"><font color="white">DisputeDesc</font></td>
												<td bgcolor="#4981af" align="center"><font color="white">Status</font></td>
												<td bgcolor="#4981af" align="center"><font color="white">DateTime</font></td>
												
												<td class="fitTo10" bgcolor="#4981af" align="center"><font color="white">Download Evidence Doc</font></td>
											</tr>
										<logic:iterate name="disputetxnslist" id="links">
											<tr >
													<td bgcolor="#DBEAF9" align="center"><bean:write name="links" property="id" />
													<td bgcolor="#DBEAF9"><bean:write name="links" property="acq_txn_id" />
													<td bgcolor="#DBEAF9"><bean:write name="links" property="toll_txn_id" />
													<td bgcolor="#DBEAF9"><bean:write name="links" property="toll_plaza_id" /> 
													<td bgcolor="#DBEAF9"><bean:write name="links" property="dispute_type" />
													<td bgcolor="#DBEAF9"><bean:write name="links" property="amount" />
													<td bgcolor="#DBEAF9"><bean:write name="links" property="adjustment_type" /> 
													<td bgcolor="#DBEAF9"><bean:write name="links" property="dispute_desc" />
													<td bgcolor="#DBEAF9"><bean:write name="links" property="status" /> 
													<td bgcolor="#DBEAF9"><bean:write name="links" property="date_time" />
													<td bgcolor="#DBEAF9" align="center">
													<html:hidden property="acq_txn_id" value='<bean:write name="links" property="acq_txn_id" />'/>
														<a href="/acqhostAdmin/download.do?acq_txn_id=<bean:write name="links" property="acq_txn_id"/> ">
															Download<bean:write name="links" property="acq_txn_id" />
														</a>
													</td>
											</tr>
										</logic:iterate>
										</table>
									</logic:notEmpty> --%>
									</div>
									<br><br>
									<!-- <a href="#" class="export">Export to CSV</a> -->
									
										
										<%-- <%
      										response.setContentType("application/vnd.ms-excel");
      										response.setHeader("Content-disposition", "attachment; filename=report.csv");
    
      										/* for (int j=0; j<9; j++){
											            StringBuffer line = new StringBuffer();
											          for(int i=0;i<=17;i++){
											                line.append("\"").append(i + j).append("\",");      
											            } */
											%>
											            <%=line%>
											<%      
											     /*  } */
											%>
									 --%>
										
									
										<%-- <% request.getAttribute("disputetxnslist"); %> --%>
										<%-- <display:table id="data" name="disputetxnslist" requestURI="/docDispute.do" pagesize="10" export="true">
								            <display:column property="id" title="Sr.No." sortable="true" media="html" group="1" />
								            <display:column property="acq_txn_id" title="AcqTxnId" sortable="true" />
								            <display:column property="toll_txn_id" title="TollTxnId" sortable="true" />
								            <display:column property="dispute_type" title="DisputeType" sortable="true" />
								            <display:column property="amount" title="Amount" sortable="true" />
								            <display:column property="adjustment_type" title="AdjustmentType" sortable="true" />
								            <display:column property="dispute_desc" title="DisputeDesc" sortable="true" />
								            <display:column property="evidence_doc" title="EvidenceDoc" sortable="true" />
								            <display:column property="status" title="Status" sortable="true" />
								            <display:column property="date_time" title="RaisedDateTime" sortable="true" />
								           	
								            <display:setProperty name="export.excel.filename" value="dispute.xls"/>
								            <display:setProperty name="export.pdf.filename" value="dispute.pdf"/>
								            <display:setProperty name="export.pdf" value="true" />
								        </display:table> --%>
										
									
									<%-- <display:table id="data" name="disputetxnslist" requestURI="/docDispute.do" pagesize="10" export="true">
								             <display:setProperty name="export.excel.filename" value="dispute.xls"/>
								            <display:setProperty name="export.pdf.filename" value="dispute.pdf"/>
								            <display:setProperty name="export.pdf" value="true" />
								    </display:table>	 --%>
										
											
											<%-- <tr >
												
												<!-- <td class="fitTo10"> -->
													<html:link action="download"><!-- Download -->
														<bean:write name="links" property="acq_txn_id"/>
													</html:link> 
													<input type="hidden" value='<bean:write name="links" property="acq_txn_id" />' /> 
													<td bgcolor="#DBEAF9" align="center"><bean:write name="links" property="id" />
													<td bgcolor="#DBEAF9" align="center"><bean:write name="links" property="acq_txn_id" />
													<td bgcolor="#DBEAF9" align="center"><bean:write name="links" property="amount" />
													<td bgcolor="#DBEAF9" align="center">
													<input type="hidden" name="acq_txn_id" id="acq_txn_id" value='<bean:write name="links" property="acq_txn_id" />' />
													<html:hidden property="acq_txn_id"/>
													<a href="/MerchantAcq/download.do">
													<bean:write name="links" property="acq_txn_id" />	Download
													</a>
													
													<a name="<bean:write name="links" property="acq_txn_id" />" id="<bean:write name="links" property="acq_txn_id" />" href="/MerchantAcq/download.do" 
													<!-- onclick="document.getElementById('formAdd').submit();"> --><bean:write name="links" property="acq_txn_id" />	
													</a>
													<input type="hidden" name="acq_txn_id" value='<bean:write name="links" property="acq_txn_id" />' />											
													<a href="/MerchantAcq/download.do" onclick="javascript:downloadCall('getStreamInfo','<bean:write name="links" property="acq_txn_id" />');"> Download </a>
													</td>
														<html:param name="acq_txn_id">
														<html:hidden property="acq_txn_id"/>
														<input type='hidden' value='<bean:write name="links" property="acq_txn_id" />' />
														<bean:write name="links" property="acq_txn_id" />
														</html:param>
													</html:link>												
												<!-- </td> -->
											</tr>    --%>
										
										
									<%-- <logic:notEmpty name="disputetxnslist">
										<table width="100%">
											<tr style="font-weight: bold;">
												<td bgcolor="#4981af" align="center"><font color="white">Sr.No.</font></td><!-- #FF9900 -->
												<td bgcolor="#4981af" align="center"><font color="white">acq_txn_id</font></td>
												<td bgcolor="#4981af" align="center"><font color="white">toll_txn_id</font></td>
												<td bgcolor="#4981af" align="center"><font color="white">toll_plaza_id</font></td>
												<td bgcolor="#4981af" align="center"><font color="white">dispute_type</font></td>
												<td bgcolor="#4981af" align="center"><font color="white">amount</font></td>
												<td bgcolor="#4981af" align="center"><font color="white">adjustment_type</font></td>
												<td bgcolor="#4981af" align="center"><font color="white">dispute_desc</font></td>
												<!-- <td bgcolor="#4981af" align="center"><font color="white">evidence_doc</font></td> -->
												<td bgcolor="#4981af" align="center"><font color="white">status</font></td>
												<td bgcolor="#4981af" align="center"><font color="white">date_time</font></td>
												<td bgcolor="#4981af" align="center"><font color="white">Download</font></td>
											</tr>
										<logic:iterate name="disputetxnslist" id="links">
											<tr>
												<td bgcolor="#DBEAF9" align="center"><bean:write name="links" property="id" />
												<td bgcolor="#DBEAF9"><bean:write name="links" property="acq_txn_id" />
												<td bgcolor="#DBEAF9"><bean:write name="links" property="toll_txn_id" />
												<td bgcolor="#DBEAF9"><bean:write name="links" property="toll_plaza_id" /> 
												<td bgcolor="#DBEAF9"><bean:write name="links" property="dispute_type" /> 
												<td bgcolor="#DBEAF9"><bean:write name="links" property="amount" />
												<td bgcolor="#DBEAF9"><bean:write name="links" property="adjustment_type" /> 
												<td bgcolor="#DBEAF9"><bean:write name="links" property="dispute_desc" />  
												<td bgcolor="#DBEAF9"><bean:write name="links" property="evidence_doc" />
												<td bgcolor="#DBEAF9"><bean:write name="links" property="status" /> 
												<td bgcolor="#DBEAF9"><bean:write name="links" property="date_time" />
												<td bgcolor="#DBEAF9" align="center">				
														<a
															href="javascript:downloadCall('downloadDoc','<bean:write name="links" property="id" />');">
															Download
														</a>
												</td>
											</tr>   

										</logic:iterate>
										</table>
									</logic:notEmpty> --%>
									
									
									<br>
									<br>
									</fieldset>

								</html:form>
								
								<html:form action="/docDispute" method="post" styleId="formAddCSV">
									<html:hidden property="dispatch" />
									<html:button value="DownloadCSV" property="" styleClass="btn btn-primary btn-o" onclick="dwonloadDisputeTxns('downloadCSV'); " />
								</html:form>
							</div>
						</div>
					</div>

					<!-- start: FOOTER -->
					<footer>
						<div class="footer-inner">
							<div class="pull-left">
								&copy; <span class="current-year"></span><span>&nbsp;1Pay.
									All rights reserved</span>
							</div>
							<div class="pull-right">
								<span class="go-top"><i class="ti-angle-up"></i></span>
							</div>
						</div>
					</footer>

					<script src="vendor/jquery/jquery.min.js"></script>
					<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
					<script src="vendor/modernizr/modernizr.js"></script>
					<script src="vendor/jquery-cookie/jquery.cookie.js"></script>
					<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
					<script src="vendor/switchery/switchery.min.js"></script>
					<!-- end: MAIN JAVASCRIPTS -->
					
					<script src="vendor/sweetalert/sweet-alert.min.js"></script>
					<script src="vendor/toastr/toastr.min.js"></script>
					<script src="assets/js/main.js"></script>
					<script type="text/javascript" src="assets/js/paging.js"></script>
					<script src="assets/js/ui-notifications.js"></script>
					<script type="text/javascript" src="./jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
					
					 <!-- added by spk -->
			      	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>  
				    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
				    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>
					
					
										
			<script type="text/javascript">
			jQuery(document).ready(function () {
			    Main.init();
			    UINotifications.init();
			});
			</script>
			
			<script type="text/javascript">/*woking for above date  */
			$(document).ready(function(){
				 $('#from_date').datepicker({
                	 autoclose: true,  
                	 format: "yyyy-mm-dd"
                }); 
				
				 $('#to_date').datepicker({
		           	 autoclose: true,  
		           	 format: "yyyy-mm-dd"
		           });  
			});
			</script>
			
			<script type="text/javascript">
			$(document).ready(function() {

				  function exportTableToCSV($table, filename) {

				    var $rows = $table.find('tr:has(td)'),

				      // Temporary delimiter characters unlikely to be typed by keyboard
				      // This is to avoid accidentally splitting the actual contents
				      tmpColDelim = String.fromCharCode(11), // vertical tab character
				      tmpRowDelim = String.fromCharCode(0), // null character

				      // actual delimiter characters for CSV format
				      colDelim = '","',
				      rowDelim = '"\r\n"',

				      // Grab text from table into CSV formatted string
				      csv = '"' + $rows.map(function(i, row) {
				        var $row = $(row),
				          $cols = $row.find('td');

				        return $cols.map(function(j, col) {
				          var $col = $(col),
				            text = $col.text();

				          return text.replace(/"/g, '""'); // escape double quotes

				        }).get().join(tmpColDelim);

				      }).get().join(tmpRowDelim)
				      .split(tmpRowDelim).join(rowDelim)
				      .split(tmpColDelim).join(colDelim) + '"';

				    // Deliberate 'false', see comment below
				    if (false && window.navigator.msSaveBlob) {

				      var blob = new Blob([decodeURIComponent(csv)], {
				        type: 'text/csv;charset=utf8'
				      });

				      // Crashes in IE 10, IE 11 and Microsoft Edge
				      // See MS Edge Issue #10396033
				      // Hence, the deliberate 'false'
				      // This is here just for completeness
				      // Remove the 'false' at your own risk
				      window.navigator.msSaveBlob(blob, filename);

				    } else if (window.Blob && window.URL) {
				      // HTML5 Blob        
				      var blob = new Blob([csv], {
				        type: 'text/csv;charset=utf-8'
				      });
				      var csvUrl = URL.createObjectURL(blob);

				      $(this)
				        .attr({
				          'download': filename,
				          'href': csvUrl
				        });
				    } else {
				      // Data URI
				      var csvData = 'data:application/csv;charset=utf-8,' + encodeURIComponent(csv);

				      $(this)
				        .attr({
				          'download': filename,
				          'href': csvData,
				          'target': '_blank'
				        });
				    }
				  }

				  // This must be a hyperlink
				  $(".export").on('click', function(event) {
				    // CSV
				    var args = [$('#dvData>table'), 'dispute.csv'];

				    exportTableToCSV.apply(this, args);

				    // If CSV, don't do event.preventDefault() or return false
				    // We actually need this to be a typical hyperlink
				  });
				});
			
			
			
			</script>
			
</body>
</html>