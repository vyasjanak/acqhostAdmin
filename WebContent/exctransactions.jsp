<%@ include file="/include.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>1Pay : Exception Transactions</title>
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
								<h4 class="mainTitle" id="dashboard">Exception Transactions</h4>
							</div>
						</div>
					</section>
					<!-- end: PAGE TITLE -->
					<!-- start: WIZARD DEMO -->

					<div class="container-fluid container-fullw bg-white">
						<div class="row">
							<br>
								<form action="/nrnstxns"  method="post">	
			<!-- <fieldset>
				<legend>Exception Transactions Download</legend>	 --> 
 			<div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_content" style="overflow: auto">
                   <logic:notEmpty name="extxnslist">
                    <table id="datatable-buttons" class="table table-striped table-bordered" cellspacing="0" width="100%" >
                      <thead>
						<tr>
						<td>Sr. No</td>
						<td>Transaction ID</td>
						
						<td>Transaction Date and Time</td>
						<td>Transaction Type</td>
						<td>Original Transaction ID</td>
						<td>Tag ID</td>
						
						<td>Merchant ID</td>
						
						<td>Reader_Read_Date_and_Time</td>
						
						<td>Issuer_ID</td>
						<td>Transaction_Amount</td>
						<!-- <td>Currency_Code</td>
						<td>Payee_Address</td> -->
						<td>Acquirer_ID</td>
						
						<td>Vehicle_Registration_number </td>
						
						
						<td>Action</td>
						<td>Process Date</td>
					</tr>
				</thead>

             <tbody>
   				<logic:iterate name="extxnslist" id="post">
					<tr>
				     <td><bean:write name="post" property="id" />
					 <td><bean:write name="post" property="transaction_ID" />
					
					 <td><bean:write name="post" property="transaction_Date_and_Time" />
					 <td><bean:write name="post" property="transaction_Type" />
					 <td><bean:write name="post" property="original_transaction_ID" />
					 <td><bean:write name="post" property="tag_ID" />
					
					 <td><bean:write name="post" property="merchant_Id" />
					
					 <td><bean:write name="post" property="reader_Read_Date_and_Time" />
					 
					 <td><bean:write name="post" property="issuer_ID" />
					
					 <td><bean:write name="post" property="transaction_Amount" />
					<%--  <td><bean:write name="post" property="currency_Code" />
					 <td><bean:write name="post" property="payee_Address" /> --%>
					 <td><bean:write name="post" property="acquirer_ID" />
					 
					 <td><bean:write name="post" property="vehicle_Registration_number" />
						
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
     <!-- </fieldset> -->
</form>
								</div>
								</div>
								</div>
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