<%@ include file="/include.jsp"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
function searchDisputeTxns(method)
{
	var invalid=0;
	
	if (document.getElementById("txn_id").value == "" && document.getElementById("tag_id").value == "" && document.getElementById("vehicle_no").value == "") 
	{
		document.getElementById("txn_id").focus();
		alert("Please enter one of the fields to search the transaction.");
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

function uploadDoc(method)
{
	var invalid=0;
	if (document.getElementById("amount").value == "" ) 
	{
		document.getElementById("amount_span").innerHTML = "Please enter amount to raise dispute.";
		document.getElementById("amount").focus();
		valueBackground("amount_span");
		invalid = 1;
	}
	else if (document.getElementById("reason").value == "" ) 
	{
		/* alert("bhai reason likh na."); */
		document.getElementById("reason_span").innerHTML = "Please enter reason for dispute.";
		document.getElementById("reason").focus();
		valueBackground("reason_span");
		invalid = 1;
	}
	else if(document.getElementById("rtype").selectedIndex == 0)
	{
		document.getElementById("reasontype_span").innerHTML = "Please select reason type.";
		document.getElementById("rtype").focus();
		valueBackground("reasontype_span");
		invalid = 1;
	}
	
	else if(document.getElementById("reasoncode1").selectedIndex == 0 && document.getElementById("rtype").value == 1)
	{
		document.getElementById("reasoncode1").focus();
		document.getElementById("reasoncode1_span").innerHTML = "Please select reason code.";
		valueBackground("reasoncode1_span");
		invalid = 1;
	}
	else if(document.getElementById("reasoncode2").selectedIndex == 0 && document.getElementById("rtype").value == 2)
	{			
		document.getElementById("reasoncode2").focus();
		document.getElementById("reasoncode2_span").innerHTML = "Please select reason code.";
		valueBackground("reasoncode2_span");
		invalid = 1;
	}
	else if(document.getElementById("reasoncode3").selectedIndex == 0 && document.getElementById("rtype").value == 3)
	{
		document.getElementById("reasoncode3").focus();
		document.getElementById("reasoncode3_span").innerHTML = "Please select reason code.";
		valueBackground("reasoncode3_span");
		invalid = 1;
	}
	else if(document.getElementById("reasoncode4").selectedIndex == 0 && document.getElementById("rtype").value == 4)
	{
		document.getElementById("reasoncode4").focus();
		document.getElementById("reasoncode4_span").innerHTML = "Please select reason code.";
		valueBackground("reasoncode4_span");
		invalid = 1;
	}
	else if(document.getElementById("reasoncode5").selectedIndex == 0 && document.getElementById("rtype").value == 5)
	{
		document.getElementById("reasoncode5").focus();
		document.getElementById("reasoncode5_span").innerHTML = "Please select reason code.";
		valueBackground("reasoncode5_span");
		invalid = 1;
	}
	else if(document.getElementById("reasoncode6").selectedIndex == 0 && document.getElementById("rtype").value == 6)
	{
		document.getElementById("reasoncode6").focus();
		document.getElementById("reasoncode6_span").innerHTML = "Please select reason code.";
		valueBackground("reasoncode6_span");
		invalid = 1;
	}
	else if(document.getElementById("fp1").checked == false && document.getElementById("fp2").checked == false)
	{
		alert("Please Choose Full/Partial Indicator");
		document.getElementById("fp_span").innerHTML = "Please Choose Full/Partial Indicator.";
		valueBackground("fp_span");
		invalid = 1;
	}
	else if (document.getElementById("file").files.length == 0) 
	{
		document.getElementById("file_span").innerHTML = "Please upload file regarding dispute.";
		document.getElementById("file").focus();
		valueBackground("file_span");
		invalid = 1;
	}
	else if(document.getElementById("function_code").selectedIndex == 0)
	{
		document.getElementById("funcode_span").innerHTML = "Please select function code.";
		document.getElementById("function_code").focus();
		valueBackground("funcode_span");
		invalid = 1;
	}
	/* else if (document.getElementById("file").files.length == 0) 
	{
		document.getElementById("file_span").innerHTML = "Please upload file regarding dispute.";
		document.getElementById("file").focus();
		valueBackground("file_span");
		invalid = 1;
	} */
	
	if(invalid != 0)
	{
		return false;
	}
	else
	{
		var form = document.getElementById('formDocAdd');
		form.elements["dispatch"].value = method;
		
		form.submit();
		form.reset();
		return false;
	}	
}

function isNumberKey(e) {
	var charCode = (e.which) ? e.which : event.keyCode
	if (charCode > 31 && (charCode < 48 || charCode > 57))
	{
		alert("Only Numbers Allowed");
		return false;

	}
	else
	{
		return true;

	}
}
</script>
<script type="text/javascript">
var allowedExtensions = {
		  '.jpg'  : 1,
		  '.jpeg'  : 2,
		  '.pdf'  : 3
		};
		 
		function checkExtension(filename) 
		{
		    var match = /\..+$/;
		    var ext = filename.match(match);
		    if (allowedExtensions[ext]) 
		    {
		    	return true;
		    } 
		    else 
		    {
		    	document.getElementById("file_span").innerHTML = "File must be in .jpg format!";
		    	document.getElementById("file").value="";
				document.getElementById("file").focus();
				valueBackground("file_span");
			    //alert("File must be .jpg!");
			    //will clear the file input box.
			    //location.reload();
			    return false;
		    }
		}

</script>


<script>

function checkTxn()
{
	 var txnId = document.getElementById("txn_id");
	 var tagId = document.getElementById("tag_id");
	 var vehId = document.getElementById("vehicle_no");
	 if(txnId.value!=null || txnId.value!='')
	 {
	    /* alert("hi....."); */
	    tagId.readOnly = true;
	    vehId.readOnly = true;
	    return false;
	 }
	 else if(tagId.value!=null || tagId.value!='')
	 {
		 txnId.readOnly = true;
		 vehId.readOnly = true;
		 return false;
	 }
	 else if(vehId.value!=null || vehId.value!='')
	 {
		 txnId.readOnly = true;
		 tagId.readOnly = true;
		 return false;
	 }
	 else
	 {
		 txnId.readOnly = false;
		 tagId.readOnly = false;
		 vehId.readOnly = false;
		 return false;
	 }
}
function checkTag()
{
	 if(document.getElementById("tag_id").value!=null)
	 {
	    //alert("hi.....");
	    document.getElementById("txn_id").readOnly = true;
	    document.getElementById("vehicle_no").readOnly = true;
	    return false;
	 }
	 else
	 {
		 document.getElementById("txn_id").readOnly = false;
		 document.getElementById("vehicle_no").readOnly = false;
		 return false;
	 }
}
function checkVehicle()
{
	 if(document.getElementById("vehicle_no").value!=null)
	 {
	    //alert("hi.....");
	    document.getElementById("txn_id").readOnly = true;
	    document.getElementById("tag_id").readOnly = true;
	    return true;
	 }
	 else if(document.getElementById("vehicle_no").value==null || document.getElementById("vehicle_no").value=='')
	 {
		 document.getElementById("txn_id").readOnly = false;
		 document.getElementById("tag_id").readOnly = false;
		 return false;
	 }
}

function changeVehicle()
{
	 if(document.getElementById("vehicle_no").value==null || document.getElementById("vehicle_no").value=='')
	 {
		 document.getElementById("txn_id").readOnly = false;
		 document.getElementById("tag_id").readOnly = false;
		 return false;
	 }
}
</script>

<title>1Pay : Dispute Raise</title>
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
<!-- <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">  
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.css" rel="stylesheet">  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>  
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>
   
<link href="vendor/bootstrap-datepicker/bootstrap-datepicker3.standalone.min.css" rel="stylesheet" media="screen">
<link href="vendor/bootstrap-timepicker/bootstrap-timepicker.min.css" rel="stylesheet" media="screen"> -->
<!-- end: MAIN CSS -->
<!-- start: CLIP-TWO CSS -->
<link rel="stylesheet" href="assets/css/styles.css">
<link rel="stylesheet" href="assets/css/plugins.css">
<link rel="stylesheet" href="assets/css/themes/theme-1.css"
	id="skin_color" />
<link rel="stylesheet" href="css/style.min.css" />


 <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
	  
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

.modal-header, h4, .close {
     /*  background-color:white; */
     /*  color:white !important; */
      /* text-align: center; */
      }
  .modal-footer {
     background-color: #f9f9f9;
  }

div.scrollmenu {
		    /* background-color: #333; */
		    overflow-x: auto;
		   /*  white-space: nowrap; */
		}
		
		div.scrollmenu a {
		    display: inline-block;
		   /*  color: white; */
		    text-align: center;
		    padding: 14px;
		    text-decoration: none;
		}
</style>
</head>

<body onload="changeList();">
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
								<h4 class="mainTitle" id="dashboard">Dispute Raise</h4>
							</div>
						</div>
					</section>
					<!-- end: PAGE TITLE -->
					<!-- start: WIZARD DEMO -->

					<div class="container-fluid container-fullw bg-white">
						<div class="row">
							<br>
							
								<font color="red" size=3> 
									<logic:present name="failure">
									<script type="text/javascript">alert('Transaction not found!!!');</script>
									</logic:present>
								</font>
								
								<font color="green" size=3> 
									<logic:present name="uploadsuccess">
									Dispute raised & Document uploaded successfully!!!
									<!-- <script type="text/javascript">alert('Dispute raised & Document uploaded successfully!!!');</script> -->
									</logic:present>
								</font>
								<font color="red" size=3> 
									<logic:present name="uploadfailure">
									Dispute can not be raised!!!
									<!-- <script type="text/javascript">alert('Document can not be uploaded successfully!!!');</script> -->
									</logic:present>
								</font>
								<font color="red" size=3> 
									<logic:present name="failuredispute">
									<script type="text/javascript">alert('Dispute has been already raised for this transaction!!!');</script>
									</logic:present>
								</font>
								<font color="red" size=3> 
									<logic:present name="formatfailure">
									<script type="text/javascript">alert('Please, upload doc file in .jpg format!!!');</script>
									</logic:present>
								</font>
								
								
							
							<div class="col-md-12">

								<html:form action="/raiseDispute" styleId="formAdd" method="post" enctype="multipart/form-data" onsubmit="searchDisputeTxns('searchTransactions')">

									<html:hidden property="dispatch" />
									<fieldset>
										<legend>Raise Dispute Transaction</legend>
											<!-- <div theme="simple"> -->
													<div class="row">
														<div class="col-md-6">
															<div class="form-group">
																<label class="control-label"> Transaction ID <span id="txn_id_span"></span>
																</label>
																<html:text styleClass="form-control" property="txn_id" styleId="txn_id" maxlength="40" /><!--onblur="disableOthers()"  -->
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-md-6">
															<div class="form-group">
																<label class="control-label"> EPC ID(TagID) <span id="tag_id_span"></span>
																</label>
																<html:text styleClass="form-control" property="tag_id" styleId="tag_id" maxlength="24" />
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-md-6">
															<div class="form-group">
																<label class="control-label"> Vehicle Number <span id="vehicle_no_span"></span>
																</label>
																<html:text styleClass="form-control" property="vehicle_no" styleId="vehicle_no" maxlength="10" />
															</div>
														</div>
													</div>
													
													<div class="row">
														<div class="col-md-6" align="center">	
															<html:button value="Search" property="" styleClass="btn btn-primary btn-o" onclick="searchDisputeTxns('searchTransactions')" />
														</div>
													</div>
							
							<logic:notEmpty name="txns" >
							 <div class="panel-body">
							  <div class="scrollmenu">
							<table width="auto" class="table table-bordered table-hover">
								<tr style="font-weight:bold;">
									<td >Action</td>
									<td >Txn Timestamp</td>
									<td >Org Id</td>
									<td >Txn Id</td>
									<td >Original Txn Id</td>
									<td >Tag ID</td>
									<td >TID</td>
									<td >Txn Amount</td><!--AVC  -->
									<td >Txn Type</td>
									<td >Front Pic</td>
									<td >Back Pic</td>
								</tr>
							<logic:iterate name="txns" id="txns">
								<tr>
									<td >
									<input type="radio" id="myBtn" name="myBtn" value="<bean:write name="txns" property="txn_id" />" /></td>
									
									<td ><bean:write name="txns" property="acq_txn_time" /></td>
									<td ><bean:write name="txns" property="org_id" /></td>
									<td ><bean:write name="txns" property="txn_id" /></td>
									<td ><bean:write name="txns" property="original_txn_id" /></td>
									
									<td ><bean:write name="txns" property="tag_id" /></td>
									<td ><bean:write name="txns" property="tid" /></td>
									<td ><bean:write name="txns" property="txn_amount" /></td>
									<td ><bean:write name="txns" property="txn_type" /></td>
									<td>
									<a href="/acqhostAdmin/vehPicDownload.do?tps_txn_id=frontPic_<bean:write name="txns" property="txn_ref_id"/> ">
															frontPic_<bean:write name="txns" property="txn_ref_id" />
									</a>
									</td>
									<td>
									<a href="/acqhostAdmin/vehPicDownload.do?tps_txn_id=backPic_<bean:write name="txns" property="txn_ref_id"/> ">
															backPic_<bean:write name="txns" property="txn_ref_id" />
									</a>
									</td>
								</tr>
							</logic:iterate>
							</table>
							</div>
							</div>
							</logic:notEmpty>
							
							</fieldset>
							</html:form>

							</div>
						</div>
					</div>

  
					<!-- Modal -->
								
					<div class="modal fade" id="myModal" role="dialog">
					    <div class="modal-dialog">
					    
					      <!-- Modal content-->
					      <div class="modal-content">
					        
					        <div class="modal-body" style="padding:40px 50px;">
					        <div class="modal-header"><!-- for close button on top -->
					          		<button type="button" class="close" data-dismiss="modal" id="closebtn" onclick="javascript:resetAction();">&times;</button>
					          	</div>	
					        
					          	<html:form method='post' action="/raiseDispute" enctype="multipart/form-data" styleId="formDocAdd">
					          	
					          	<html:hidden property="dispatch" />
					          	<div id="divid" class="modal-body">
        						 <html:hidden property="txn_id" styleId="inputid" value=""/>
								</div>
								
									
								  					          						         					          	
					          	  Amount : <span class="symbol required"></span><span id="amount_span"></span>
						          <html:text property='amount' styleId='amount' styleClass='form-control' onkeyup="javascript:valueChange('amount_span');" onkeypress="return isNumberKey(event);"/>
						          Reason : <span class="symbol required"></span><span id="reason_span"></span>
						          <html:textarea property='reason' styleId='reason' styleClass='form-control' onkeyup="javascript:valueChange('reason_span');"/>
						          
						          Reason Code Type : <span class="symbol required"></span><span id="reasontype_span"></span>
					             <select class="form-control" id='rtype' onchange="javascript:valueChange('reasontype_span'); changeList();" name="reason_code_type"><!-- javascript:showDiv(this); -->
					              <option value="0">--Select Reason Code Type--</option>
								  <option value="1">Chargeback (Debit)</option>
								  <option value="2">Chargeback (Credit)</option>
								  <option value="3">Re-presentment</option>
								  <option value="4">Debit Adjustment</option>
								  <option value="5">Credit Adjustment</option>
								  <option value="6">Pre-compliance and Compliance</option>
								  </select>
								 
						         <div id="div1" >
						          Reason Code : <span class="symbol required"></span><span id="reasoncode1_span"></span>
						          <html:select property="reason_code" styleClass='form-control' styleId="reasoncode1" onchange="javascript:valueChange('reasoncode1_span');">
	                					<html:option value="0">Select Reason Code for Chargeback Debit</html:option>
	                					<html:optionsCollection name="disputeRaiseForm" property="reasonCodeList1" label="reason_desc" value="reason_code"/>
            					  </html:select>
								 </div>
								
								 <div id="div2">
							       Reason Code : <span class="symbol required"></span><span id="reasoncode2_span"></span>
							       <html:select property="reason_code" styleClass='form-control' styleId="reasoncode2" onchange="javascript:valueChange('reasoncode2_span');">
	                					<html:option value="0">Select Reason Code for Chargeback Credit</html:option>
	                					<html:optionsCollection name="disputeRaiseForm" property="reasonCodeList2" label="reason_desc" value="reason_code" />
            					   </html:select>
            					  </div>
						          
								  <div id="div3" >
							          Reason Code : <span class="symbol required"></span><span id="reasoncode3_span"></span>
							          <html:select property="reason_code" styleClass='form-control' styleId="reasoncode3" onchange="javascript:valueChange('reasoncode3_span');">
	                					<html:option value="0">Select Reason Code for Re-presentment</html:option>
	                					<html:optionsCollection name="disputeRaiseForm" property="reasonCodeList3" label="reason_desc" value="reason_code" />
            					  	  </html:select>
								  </div>
								  <div id="div4" >
							          Reason Code : <span class="symbol required"></span><span id="reasoncode4_span"></span>
							          <html:select property="reason_code" styleClass='form-control' styleId="reasoncode4" onchange="javascript:valueChange('reasoncode4_span');">
	                					<html:option value="0">Select Reason Code for Debit Adjustment</html:option>
	                					<html:optionsCollection name="disputeRaiseForm" property="reasonCodeList4" label="reason_desc" value="reason_code" />
            					  	  </html:select>
								 </div>
								  <div id="div5" >
							          Reason Code : <span class="symbol required"></span><span id="reasoncode5_span"></span>
							          <html:select property="reason_code" styleClass='form-control' styleId="reasoncode5" onchange="javascript:valueChange('reasoncode5_span');">
	                					<html:option value="0">Select Reason Code for Credit Adjustment</html:option>
	                					<html:optionsCollection name="disputeRaiseForm" property="reasonCodeList5" label="reason_desc" value="reason_code" />
            					  	  </html:select>
								 </div>
								  <div id="div6" >
							          Reason Code : <span class="symbol required"></span><span id="reasoncode6_span"></span>
							          <html:select property="reason_code" styleClass='form-control' styleId="reasoncode6" onchange="javascript:valueChange('reasoncode6_span');">
	                					<html:option value="0">Select Reason Code for Pre-compliance and Compliance</html:option>
	                					<html:optionsCollection name="disputeRaiseForm" property="reasonCodeList6" label="reason_desc" value="reason_code" />
            					  	  </html:select>
								 </div>
								 
								 Full/Partial Indicator : <span class="symbol required"></span><span id="fp_span"></span><br>
								 &nbsp;&nbsp;<html:radio property="full_par_indicator" value="F" styleId="fp1" onclick="javascript:valueChange('fp_span');">Full</html:radio>
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:radio property="full_par_indicator" value="P" styleId="fp2" onclick="javascript:valueChange('fp_span');">Partial</html:radio><br>
						         Select file : (Allow *.jpg only) <span class="symbol required"></span><span id="file_span"></span>
						          <html:file styleClass="form-control" property="file" styleId="file" onchange="checkExtension(this.value); valueChange('file_span');" /><!-- javascript:valueChange('file_span'); -->
						        
					             Function Code : <span class="symbol required"></span><span id="funcode_span"></span>
					             <select class="form-control" id="function_code" name="function_code" onchange="javascript:valueChange('funcode_span');">
					              <option value="-1">--Select Function Code--</option>
					               <option value="200">NETC Settled Transaction</option>
					               <option value="205">Re-presentment  (Full/Partial)</option>
					               <option value="261">Re-presentment Acceptance</option>
					               <option value="501">Deemed Re-presentment Acceptance</option>
					               <option value="450">Chargeback  (Full/Partial) </option>
					               <option value="470">Chargeback Acceptance</option>
					               <option value="500">Deemed Chargeback Acceptance</option>
					               <option value="451">Credit Chargeback</option>
					               <option value="452">Credit Chargeback Acceptance</option>
					               <option value="502">Deemed Credit Chargeback Acceptance</option>
					               <option value="471">Pre-Arbitration  (Full/Partial) </option>
					               <option value="473">Pre-Arbitration Declined</option>
					               <option value="474">Pre-Arbitration Acceptance (Full/Partial)</option>
					               <option value="479">Arbitration</option>
					               <option value="480">Arbitrations Acceptance</option>
					               <option value="481">Arbitrations Continuation </option>
					               <option value="482">Arbitrations Withdrawn</option>
					               <option value="483">Arbitrations Verdict</option>
					               <option value="672">Pre-compliance  (Single/Bulk)</option>
					               <option value="673">Pre-compliance Acceptance (Full/Partial)</option>
					               <option value="674">Pre-compliance Declined </option>
					               <option value="675">Compliance  (Single/ Bulk)</option>
					               <option value="676">Compliance Acceptance</option>
					               <option value="677">Compliance Continuation </option>
					               <option value="678">Compliance Withdrawn</option>
					               <option value="679">Compliance Verdict</option>
					               <option value="680">Good Faith  (Single/ Bulk) </option>
					               <option value="681">Good Faith Acceptance (Full/Partial)</option>
					               <option value="682">Good Faith Declined</option>
					               <option value="505">Deemed Good Faith Declined</option>
								   <option value="700">Member Fund Collection</option>
								   <option value="701">Member Fund Disbursement</option>
								   <option value="760">NPCI Fee Collection</option>
								   <option value="761">NPCI Fee Disbursement</option>
								   <option value="762">Credit Adjustment</option>
								   <option value="763">Debit Adjustment</option>
								 </select>
						         <br><br><br>
						          <div align="center">	
						          	<html:button value="Raise Dispute" property="" styleClass="btn btn-primary btn-o" onclick="uploadDoc('disputeTxnsDoc'); " /><!-- javascript:removeCodeType(); -->
								  </div>
					        	</html:form>
					        </div>
					        <div class="modal-footer">
					        </div>
					        
					        <!-- <div class="modal-footer">
					          <button type="submit" class="btn btn-danger btn-default pull-right" data-dismiss="modal" >
					          <span class="glyphicon glyphicon-remove"></span> Cancel</button>
					        </div> -->
					      </div>
					   </div>
					</div>							
					<!-- end Modal -->

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
					
					
										
			<!-- <script type="text/javascript">
			jQuery(document).ready(function () {
			    Main.init();
			    UINotifications.init();
			});
			</script>
			
			<script>
				$(document).ready(function(){
				/* $('#formAdd').find("input:radio:checked").attr('id').click(function(){ */
					$(document).on('change', 'input[name="myBtn"]:radio', function(){
   					 //alert($(this).val());
   					$("#myModal").modal();
					});
				});
			</script> -->
			
			<!-- <script>
				$(document).ready(function(){
   				$("#myBtn").click(function(){
        		$("#myModal").modal();
   				 });
				});
			</script> -->
			
			
			<script type="text/javascript">
			jQuery(document).ready(function () {
			    Main.init();
			    UINotifications.init();
			});
			</script>
			
			
			<script>
				$(document).ready(function(){
				/* $('#formAdd').find("input:radio:checked").attr('id').click(function(){ */
					$(document).on('change', 'input[name="myBtn"]:radio', function(){
						var valrad=$(this).val();
   					 //alert("Before modal :: "+valrad);
   					 //$('#inputid').val($('#divid').text());
   					 $(".modal-body #inputid").val( valrad );
   					$('#divid').val($('#inputid').text());
   					 //document.getElementById('newText').innerHTML = valrad;
   					$("#myModal").modal();
   					//document.getElementById('newText').innerHTML = valrad;
   					//alert(valrad);
					});
				});
			</script>
			
			
<script type="text/javascript">

function pageLoad()
{
	// alert("Hello");
	document.getElementById("txn_id").value="";
	document.getElementById("tag_id").value="";
	document.getElementById("vehicle_no").value="";
}

</script>
<script type="text/javascript">
	   
function resetAction()
{
	if(document.getElementById("myBtn").checked==true)
	{
		document.getElementById("myBtn").checked=false;
	}
}

function changeList()
{
	//alert("load");
	var el = document.getElementById("rtype").selectedIndex;
	if(el==0)
	{
		//alert("load0");
		//alert("1 is selected ");
		document.getElementById("reasoncode1").disabled = true;
		document.getElementById("reasoncode2").disabled = true;
		document.getElementById("reasoncode3").disabled = true;
		document.getElementById("reasoncode4").disabled = true;
		document.getElementById("reasoncode5").disabled = true;
		document.getElementById("reasoncode6").disabled = true;
		document.getElementById('div1').style.display = "none";
		document.getElementById('div2').style.display = "none";
		document.getElementById('div3').style.display = "none";
		document.getElementById('div4').style.display = "none";
		document.getElementById('div5').style.display = "none";
		document.getElementById('div6').style.display = "none";
	}
	
	else if(el==1)
	{
		//alert("1 is selected ");
		//alert("load1");
		document.getElementById("reasoncode1").disabled = false;
		document.getElementById("reasoncode2").disabled = true;
		document.getElementById("reasoncode3").disabled = true;
		document.getElementById("reasoncode4").disabled = true;
		document.getElementById("reasoncode5").disabled = true;
		document.getElementById("reasoncode6").disabled = true;
		document.getElementById('div1').style.display = "block";
		document.getElementById('div2').style.display = "none";
		document.getElementById('div3').style.display = "none";
		document.getElementById('div4').style.display = "none";
		document.getElementById('div5').style.display = "none";
		document.getElementById('div6').style.display = "none";
	}
	else if(el==2)
	{
		//alert("1 is selected ");
		document.getElementById("reasoncode2").disabled = false;
		document.getElementById("reasoncode1").disabled = true;
		document.getElementById("reasoncode3").disabled = true;
		document.getElementById("reasoncode4").disabled = true;
		document.getElementById("reasoncode5").disabled = true;
		document.getElementById("reasoncode6").disabled = true;
		document.getElementById('div2').style.display = "block";
		document.getElementById('div1').style.display = "none";
		document.getElementById('div3').style.display = "none";
		document.getElementById('div4').style.display = "none";
		document.getElementById('div5').style.display = "none";
		document.getElementById('div6').style.display = "none";
	}
	else if(el==3)
	{
		//alert("1 is selected ");
		document.getElementById("reasoncode3").disabled = false;
		document.getElementById("reasoncode2").disabled = true;
		document.getElementById("reasoncode1").disabled = true;
		document.getElementById("reasoncode4").disabled = true;
		document.getElementById("reasoncode5").disabled = true;
		document.getElementById("reasoncode6").disabled = true;
		document.getElementById('div3').style.display = "block";
		document.getElementById('div1').style.display = "none";
		document.getElementById('div2').style.display = "none";
		document.getElementById('div4').style.display = "none";
		document.getElementById('div5').style.display = "none";
		document.getElementById('div6').style.display = "none";
	}
	else if(el==4)
	{
		//alert("1 is selected ");
		document.getElementById("reasoncode4").disabled = false;
		document.getElementById("reasoncode2").disabled = true;
		document.getElementById("reasoncode3").disabled = true;
		document.getElementById("reasoncode1").disabled = true;
		document.getElementById("reasoncode5").disabled = true;
		document.getElementById("reasoncode6").disabled = true;
		document.getElementById('div4').style.display = "block";
		document.getElementById('div1').style.display = "none";
		document.getElementById('div2').style.display = "none";
		document.getElementById('div3').style.display = "none";
		document.getElementById('div5').style.display = "none";
		document.getElementById('div6').style.display = "none";
	}
	else if(el==5)
	{
		//alert("1 is selected ");
		document.getElementById("reasoncode5").disabled = false;
		document.getElementById("reasoncode2").disabled = true;
		document.getElementById("reasoncode3").disabled = true;
		document.getElementById("reasoncode4").disabled = true;
		document.getElementById("reasoncode1").disabled = true;
		document.getElementById("reasoncode6").disabled = true;
		document.getElementById('div5').style.display = "block";
		document.getElementById('div1').style.display = "none";
		document.getElementById('div2').style.display = "none";
		document.getElementById('div3').style.display = "none";
		document.getElementById('div4').style.display = "none";
		document.getElementById('div6').style.display = "none";
	}
	else if(el==6)
	{
		//alert("1 is selected ");
		document.getElementById("reasoncode6").disabled = false;
		document.getElementById("reasoncode2").disabled = true;
		document.getElementById("reasoncode3").disabled = true;
		document.getElementById("reasoncode4").disabled = true;
		document.getElementById("reasoncode5").disabled = true;
		document.getElementById("reasoncode1").disabled = true;
		document.getElementById('div6').style.display = "block";
		document.getElementById('div1').style.display = "none";
		document.getElementById('div2').style.display = "none";
		document.getElementById('div3').style.display = "none";
		document.getElementById('div4').style.display = "none";
		document.getElementById('div5').style.display = "none";
	}
}

function radioValidation(){

    var indicator = document.getElementsByName('fp');
    var genValue = false;

    for(var i=0; i<indicator.length;i++){
        if(indicator[i].checked == true){
        	indicator = true;    
        }
    }
    if(!genValue){
        alert("Please Choose Full/Partial Indicator");
        return false;
    }

}

function changeBodyList()
{
	document.getElementById("reasoncode1").disabled = true;
	document.getElementById("reasoncode2").disabled = true;
	document.getElementById("reasoncode3").disabled = true;
	document.getElementById("reasoncode4").disabled = true;
	document.getElementById("reasoncode5").disabled = true;
	document.getElementById("reasoncode6").disabled = true;
	document.getElementById('div1').style.display = "none";
	document.getElementById('div2').style.display = "none";
	document.getElementById('div3').style.display = "none";
	document.getElementById('div4').style.display = "none";
	document.getElementById('div5').style.display = "none";
	document.getElementById('div6').style.display = "none";
}

function disableOthers()
{
	var el1 = document.getElementById("txn_id").value;
	var el2 = document.getElementById("tag_id").value;
	var el3 = document.getElementById("vehicle_no").value;
	alert(el);
	if(el1.length<0 || el1==null || el1=="" || el2.length<0 || el2==null || el2=="" || el3.length<0 || el3==null || el3=="")
	{
		document.getElementById("txn_id").disabled = false;
		document.getElementById("tag_id").disabled = false;
		document.getElementById("vehicle_no").disabled = false;
	}
	else if(el1.length<0 || el1!=null || el1!="")
	{
		document.getElementById("tag_id").disabled = true;
		document.getElementById("vehicle_no").disabled = true;
	}
	else if(el2.length>0 || el2!=null || el2!="")
	{
		document.getElementById("txn_id").disabled = true;
		document.getElementById("vehicle_no").disabled = true;
	}
	else if(el3.length>0 || el3!=null || el3!="")
	{
		document.getElementById("txn_id").disabled = true;
		document.getElementById("tag_id").disabled = true;
	}
	else
	{
		document.getElementById("txn_id").disabled = false;
		document.getElementById("tag_id").disabled = false;
		document.getElementById("vehicle_no").disabled = false;
	}
	
}

</script>
<script type="text/javascript">

	 $(document).ready(function(){
		$('#amount').blur(function(event)
				{
					var amt = $('#amount').val();
					var txnId = $('#inputid').val();
					//alert(amt);
					//alert(txnId);   192.168.1.99
					$.get('/acqhostAdmin/MaxRaiseLimitAction', {amount: amt,originalTxnId: txnId.toString()}, function(data)
							{
								//var resp = $('#mobspan').text(data); 
								//alert(data);
								if(data=='FALSE')
								{
									//alert("You can not raise dispute greater than transaction amount");
									document.getElementById('amount').value = "";
									document.getElementById('amount_span').innerHTML="<font color='red'> Raising amount is greater than txn amount</font>";
								}
								/* else
								{
									document.getElementById('amount_span').innerHTML="<font color='green'>Allowed</font>";
									//document.getElementById("dotxn").style.display = "none";
									//document.getElementById("submit").disabled = true;
								} */
							});
				});	
	});
</script>
	
</body>
</html>