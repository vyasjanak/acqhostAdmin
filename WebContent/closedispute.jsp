<%@ include file="/include.jsp"%>

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
		alert("Please enter from-date and to-date to search transactions.");
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

function updateCall(method,id,acqTxnId,amount) {
	if(confirm("Do you want to close transaction?"))
	{
		var form = document.getElementById('formAdd');
		form.elements["id"].value = id;
		form.elements["acq_txn_id"].value = acqTxnId;
		form.elements["txn_amount"].value = amount;
		form.elements["dispatch"].value = method;
		form.submit();
	}
} 

</script>

<title>1Pay : Dispute Close</title>
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
	  
<!-- new added -->	  
<!-- <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">   -->
<!-- <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.css" rel="stylesheet">  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>   -->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script> -->	  
	  
	  
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
								<h4 class="mainTitle" id="dashboard">Dispute Close</h4>
							</div>
						</div>
					</section>
					<!-- end: PAGE TITLE -->
					<!-- start: WIZARD DEMO -->

					<div class="container-fluid container-fullw bg-white">
						<div class="row">
							<br>
								<font color="green" size=2> 
									<logic:present name="success">
										<b>Transaction Dispute closed successfully !!!</b>
									</logic:present>
								</font>
								<font color="red" size=2> 
									<logic:present name="failure">
										<b>Ooops, an error occurred while closing!!!</b>
									</logic:present>
								</font> 
								<font color="red" size=2> 
									<logic:present name="datefailure">
										<script type="text/javascript">alert('Sorry!!!Between dates transactions not found');</script>
									</logic:present>
								</font> 

								<html:form action="/closeDispute" method="post" styleId="formAdd">
									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<html:hidden property="dispatch" />
											</div>
										</div>
									</div>
									<br>
									<fieldset>
										<legend>Close Dispute Transaction</legend>
										<html:hidden property="id"/>
										<html:hidden property="acq_txn_id"/>
										<html:hidden property="txn_amount"/>
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
													<html:button value="Search" property="" styleClass="btn btn-primary btn-o " onclick="searchDisputeTxns('getTransactionsUsingDate')" style="margin-top: 23px;"/>
												</div>
											</div>
										</div>
										<br><br><br><br>
										<%-- <div class="col-md-12">
											<div class="row">
												<div class="col-md-12">	
													<html:button value="Search" property="" styleClass="btn btn-primary btn-o pull-right" onclick="searchDisputeTxns('getTransactionsUsingDate')" />
												</div>
											</div>
										</div> --%>
										<br><br><br><br>
										
										<logic:notEmpty name="disputetxnslist">
										<table width="100%" >
											<tr style="font-weight: bold;">
												<td align="center">Sr.No.</td>
												<td align="center">AcqTxnId</td>
												<td align="center">TollTxnId</td>
												<td align="center">TollPlazaId</td>
												<td align="center">TxnType</td>
												<td align="center">TxnAmount</td>
												<td align="center">Tag_Id</td>
												<td align="center">DisputeDesc</td>
												<!-- <td bgcolor="#4981af" align="center"><font color="white">evidence_doc</font></td> -->
												<td align="center">Status</td>
												<td align="center">TxnTime</td>
												<td align="center">Action</td>
											</tr>
										<logic:iterate name="disputetxnslist" id="links">
											<tr>
												<td align="center"><bean:write name="links" property="id" />
												<td align="center"><bean:write name="links" property="acq_txn_id" />
												<td align="center"><bean:write name="links" property="toll_txn_id" />
												<td align="center"><bean:write name="links" property="toll_plaza_id" /> 
												<td align="center"><bean:write name="links" property="txn_type" /> 
												<td align="center"><bean:write name="links" property="txn_amount" />
												<td align="center"><bean:write name="links" property="tag_id" /> 
												<td align="center"><bean:write name="links" property="dispute_desc" />  
												<%-- <td bgcolor="#DBEAF9"><bean:write name="links" property="evidence_doc" /> --%>
												<td align="center"><bean:write name="links" property="status" /> 
												<td align="center"><bean:write name="links" property="txn_time" />
												<td align="center">				
														<a
															href="javascript:updateCall('updateTransactionStatus','<bean:write name="links" property="id" />','<bean:write name="links" property="acq_txn_id" />','<bean:write name="links" property="txn_amount" />');">
															<html:button value="Close" property="" styleClass="btn btn-primary btn-o" />
														</a>
												</td> 
											</tr>    

										</logic:iterate>
										</table>
									</logic:notEmpty>
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
												<td bgcolor="#4981af" align="center"><font color="white">Action</font></td>
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
															href="javascript:updateCall('updateTransactionStatus','<bean:write name="links" property="id" />');"><html:button
															value="Close" property=""
															styleClass="btn btn-primary btn-o" 
														/>
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
		
			
</body>
</html>