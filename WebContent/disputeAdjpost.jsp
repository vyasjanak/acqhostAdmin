<%@ include file="/include.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
function onSubmitButton(){
  /* alert("Do you want to submit...?"); */
  document.getElementById('submitButtonDiv').style.display = "none";
  document.getElementById('progressBar').style.display = "block";
  return false;
}
</script>

<script type="text/javascript">
function postDisputeTxns(method)
{
	/* alert(method); */
	var invalid=0;
	
	if (document.getElementById("upload").files.length == 0) 
	{
		document.getElementById("upload").focus();
		document.getElementById("file_span").innerHTML = "Please choose file.";
		valueBackground("file_span");
		invalid = 1;
	}
	
	else if (document.getElementById("cycledate").value == "") 
	{
		document.getElementById("cycledate").focus();
		document.getElementById("cycledate_span").innerHTML = "Please select date.";
		valueBackground("cycledate_span");
		invalid = 1;
	}

	if(invalid != 0)
	{
		return false;
	}
	else
	{
		/* alert("Do you want to submit...?"); */
		document.getElementById('submitButtonDiv').style.display = "none";
		document.getElementById('progressBar').style.display = "block";
		var form = document.getElementById('formAdd');
		form.elements["dispatch"].value = method;
		
		form.submit();
		form.reset();
		return false;
	}	
}

function valueChange(id)
{
	document.getElementById(id).innerHTML ="";
}

	
function valueBackground(id)
{
	document.getElementById(id).style.color = 'red';  
	document.getElementById(id).style.fontWeight = 'bold';
}

function valueChange1(id)
{
	check_date(id);
	document.getElementById(id).innerHTML ="";
}

function check_date(id)
{
	var chkdate = document.getElementById(id).value;
	var edate = chkdate.split("/");
	var spdate = new Date();
	var sdd = spdate.getDate();
	var smm = spdate.getMonth();
	var syyyy = spdate.getFullYear();
	var today = new Date(syyyy,smm,sdd).getTime();
	var e_date = new Date(edate[2],edate[1]-1,edate[0]).getTime();
	if(e_date > today)
	 {
		document.getElementById(id).value ="";
	    alert("Date should not greater than today's date");
	    return false;
	 }
}


</script>

<title>1Pay : Dispute Adjustment</title>
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
<link rel="stylesheet" href="assets/css/themes/theme-1.css"
	id="skin_color" />
<link rel="stylesheet" href="css/style.min.css" />
	  
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
								<h4 class="mainTitle" id="dashboard">Dispute CR/DR Adjustment</h4>
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
										<script type="text/javascript">alert('Dispute adjustment transactions posted successfully...!!!');</script>
									</logic:present>
								</font>
					
								<font color="red" size=3> 
									<logic:present name="failure">
										<script type="text/javascript">alert('Ooops, an error occurred, Please check file format...!!!');</script>
									</logic:present>
								</font>
								
								<font color="red" size=3> 
									<logic:present name="formatfailure">
										<script type="text/javascript">alert('Please check, File format should be .csv or Incorrect file choosen...');</script>
									</logic:present>
								</font>
							

							<div class="col-md-12">

								<html:form action="/postDisputeAdj" styleId="formAdd" method="post" enctype="multipart/form-data">
									<html:hidden property="dispatch" />
										<fieldset>
											<legend> Dispute Adjustment Upload </legend>
												<div theme="simple">
													<div class="col-md-12">
														<div class="row">
															<div class="col-md-4">
																<div class="form-group" id="submitButtonDiv">
																	<label class="control-label"> Dispute Adjustment File<span class="symbol required"></span><span	id="file_span"></span>
																</label>
																<html:file styleClass="form-control" property="file" styleId="upload" onchange="javascript:valueChange('file_span');" />
															</div>
														</div>
														<div class="col-md-3">
															<div class="form-group">
																<label class="control-label">Date</label> <span class="symbol required"></span><span id="cycledate_span"></span>
																	<div id="submitButtonDiv"></div>
																		<div class="input-group date form_date" data-date="" data-date-format="dd/mm/yyyy">
																		<!-- 'DD/MM/YYYY HH:mm:ss' -->
																			<html:text styleClass="form-control" maxlength="20"	styleId="cycledate" property="cycledate" onkeypress="return Date1(cycledate);" onchange="javascript:valueChange1('cycledate'); javascript:valueChange('cycledate_span');" />
																			<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
																		</div>
																	</div>
																</div>
																
																<br><br><br><br>
																<div class="col-md-12" id="submitButtonDiv">
																	<br><br><br><br>
																	<html:button value="Upload Adj Disputes" property="" styleClass="btn btn-primary btn-o pull-right" onclick="postDisputeTxns('postDisputeActionData')" />
																</div>
														</div>
													<div id="progressBar" style="display: none">
														<p style="text-align: center">
															Please wait ...</br>
															</br>
															</br>
															<!-- <img src="js/ajax_wait.gif" alt="Progress Bar"> -->
															<img src="js/ajax-loader.gif" alt="Progress Bar">
														</p>
													</div>
												</div>
									</fieldset>

									<!-- table display -->
									<!-- <input type="text" id="search" placeholder="Type to search"> -->
									<!-- <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search..." title="Type here"> -->

									<div style="width: auto; height: 400px; overflow: auto;">
										<table id="PerformanceTable">
											<!--  id="myTable"-->
											<c:forEach items="${posts}" var="post" varStatus="stat">
												<c:if test="${stat.first}">
													<tr>
														<th>${post.report_date}</th> 
														<th>${post.dispute_raise_date}</th> 
														<th>${post.dispute_raised_settlement_date}</th> 
														<th>${post.case_number}</th> 
														<th>${post.function_code}</th> 
														<th>${post.function_code_and_description}</th> 
														<th>${post.transaction_sequence_number}</th> 
														<th>${post.tag_id}</th> 
														<th>${post.tid}</th> 
														<th>${post.transaction_date_time}</th> 
														<th>${post.reader_read_date_time}</th> 
														<th>${post.transaction_settlement_date}</th> 
														<th>${post.transaction_amount}</th> 
														<th>${post.settlement_amount}</th> 
														<th>${post.settlement_currency_code}</th> 
														<th>${post.note}</th> 
														<th>${post.transaction_id}</th> 
														<th>${post.transaction_type}</th> 
														<th>${post.merchant_id}</th> 
														<th>${post.lane_id}</th> 
														<th>${post.merchant_type}</th> 
														<th>${post.sub_merchant_type}</th> 
														<th>${post.transaction_status}</th> 
														<th>${post.tag_status}</th> 
														<th>${post.avc}</th> 
														<th>${post.wim}</th> 
														<th>${post.originator_point}</th> 
														<th>${post.acquirer_id}</th> 
														<th>${post.transaction_orig_institution_pid}</th> 
														<th>${post.acquirer_name_and_country}</th> 
														<th>${post.iin}</th> 
														<th>${post.transaction_destination_institution_pid}</th> 
														<th>${post.issuer_name_and_country}</th> 
														<th>${post.vehicle_registration_number}</th> 
														<th>${post.vehicle_class}</th> 
														<th>${post.vehicle_type}</th> 
														<th>${post.financial_non_financial_indicator}</th> 
														<th>${post.dispute_reason_code}</th> 
														<th>${post.dispute_reason_code_description}</th> 
														<th>${post.disputed_amount}</th> 
														<th>${post.full_partial_indicator}</th> 
														<th>${post.member_message_text}</th> 
														<th>${post.document_indicator}</th> 
														<th>${post.document_attached_date}</th> 
														<th>${post.deadline_date}</th> 
														<th>${post.days_to_act}</th> 
														<th>${post.direction_of_dispute}</th>

													</tr>
												</c:if>
											</c:forEach>


											<c:forEach items="${posts}" var="post" varStatus="stat">
												<c:if test="${!stat.first}">
													<tr>
														<td>${post.report_date}</td> 
														<td>${post.dispute_raise_date}</td> 
														<td>${post.dispute_raised_settlement_date}</td> 
														<td>${post.case_number}</td> 
														<td>${post.function_code}</td> 
														<td>${post.function_code_and_description}</td> 
														<td>${post.transaction_sequence_number}</td> 
														<td>${post.tag_id}</td> 
														<td>${post.tid}</td> 
														<td>${post.transaction_date_time}</td> 
														<td>${post.reader_read_date_time}</td> 
														<td>${post.transaction_settlement_date}</td> 
														<td>${post.transaction_amount}</td> 
														<td>${post.settlement_amount}</td> 
														<td>${post.settlement_currency_code}</td> 
														<td>${post.note}</td> 
														<td>${post.transaction_id}</td> 
														<td>${post.transaction_type}</td> 
														<td>${post.merchant_id}</td> 
														<td>${post.lane_id}</td> 
														<td>${post.merchant_type}</td> 
														<td>${post.sub_merchant_type}</td> 
														<td>${post.transaction_status}</td> 
														<td>${post.tag_status}</td> 
														<td>${post.avc}</td> 
														<td>${post.wim}</td> 
														<td>${post.originator_point}</td> 
														<td>${post.acquirer_id}</td> 
														<td>${post.transaction_orig_institution_pid}</td> 
														<td>${post.acquirer_name_and_country}</td> 
														<td>${post.iin}</td> 
														<td>${post.transaction_destination_institution_pid}</td> 
														<td>${post.issuer_name_and_country}</td> 
														<td>${post.vehicle_registration_number}</td> 
														<td>${post.vehicle_class}</td> 
														<td>${post.vehicle_type}</td> 
														<td>${post.financial_non_financial_indicator}</td> 
														<td>${post.dispute_reason_code}</td> 
														<td>${post.dispute_reason_code_description}</td> 
														<td>${post.disputed_amount}</td> 
														<td>${post.full_partial_indicator}</td> 
														<td>${post.member_message_text}</td> 
														<td>${post.document_indicator}</td> 
														<td>${post.document_attached_date}</td> 
														<td>${post.deadline_date}</td> 
														<td>${post.days_to_act}</td> 
														<td>${post.direction_of_dispute}</td>
													</tr>
												</c:if>
											</c:forEach>

										</table>
									</div>

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
					<!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
					<!--<script src="vendor/Chart.js/Chart.min.js"></script>
					<script src="vendor/jquery.sparkline/jquery.sparkline.min.js"></script>-->
					<script src="vendor/sweetalert/sweet-alert.min.js"></script>
					<script src="vendor/toastr/toastr.min.js"></script>
					<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
					<!-- start: CLIP-TWO JAVASCRIPTS -->
					<script src="assets/js/main.js"></script>
					<script type="text/javascript" src="assets/js/paging.js"></script>
					<!-- start: JavaScript Event Handlers for this page -->
					<!--<script src="assets/js/index.js"></script>-->
					<script src="assets/js/ui-notifications.js"></script>
					<script type="text/javascript" src="./jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
					
					 <!-- added by spk -->
			      	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>  
				    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
				    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>
				   	<!-- old one -->    
				    <script src="vendor/toastr/toastr.min.js"></script>
					<script type="text/javascript" src="js/bootstrap-datetimepicker.js"
					charset="UTF-8"></script>
					<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
					<!-- start: CLIP-TWO JAVASCRIPTS -->
					<script src="assets/js/main.js"></script>
					<script src="assets/js/ui-notifications.js"></script>
										
					<script>
			jQuery(document).ready(function () {
			    Main.init();
			   // Index.init();
			    UINotifications.init();
			});
			function loadPage() {
				$('#fdate').val(document.forms[1].fromDate.value);
				$('#tdate').val(document.forms[1].toDate.value);
				$('#transactionId').val(document.forms[1].txnId.value);
			}
			function saveOpenModal() {
				document.getElementById("pageAction").value = "save";
				$('#configModal').find(
						'input:text, input:password, select, textarea').val('');
				$('#configModal').find('input:radio, input:checkbox').prop(
						'checked', false);
				$('#myModal').modal('show');
			}
		</script>
	
		<script type="text/javascript">
			$('.form_date').datetimepicker({
	
				weekStart : 1,
				todayBtn : 1,
				autoclose : true,
				todayHighlight : 1,
				startView : 2,
				minView : 2,
				forceParse : 0
				<%-- maxDate : <%=new SimpleDateFormat("dd/MM/yyyy").format(new Date())%> --%>
			});
		</script>
	
		<script>
			function Date1(e) {
				//debugger
				
				var regex = new RegExp("^[0-9 -/]+$");
				var key = String.fromCharCode(!event.charCode ? event.which
						: event.charCode);
				if (!regex.test(key)) {
					event.preventDefault();
					return false;
				}
	
			}
		</script>
	 
       
       <script type="text/javascript">
            // When the document is ready
            
            /* running */
            $(document).ready(function () {
    			$('#datepicker').datepicker({
        			startDate: '-180d',
        			endDate: '+1d',
        			format: 'dd-mm-yyyy',
        			autoclose: true
    			});
			});
       
       </script>

					<!-- <script>
		function showDiv(elem){
	   if(elem.value == 'account'){
	      document.getElementById('bankDetails').style.display = "block";
	   	}
	   if(elem.value == 'merchant'){
			document.getElementById('bankDetails').style.display = "none";
		}
		}
		</script> -->
</body>
</html>