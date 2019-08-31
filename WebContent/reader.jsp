<%@page import="com.recon.utils.DBConnectionHandler"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ include file="/include.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	 
	 
<script src="js/jquery-1.12.4.js"></script>
 <script src="js/jquery.dataTables.min.js"></script>
	<script>
  $(document).ready(function() {
    $('#example').DataTable( {
        "pagingType": "full_numbers"
    } );
} ); 

</script>

	<script type="text/javascript">
		
			
		function postForm()
		{
		
		/* validation for super distributor */				
				
        	if (document.getElementById("readerId").value == "") 
			{
        		
        		document.getElementById("readerId").focus();
        		document.getElementById("cust_name_span").innerHTML = "Please enter Reader name.";
        		valueBackground("cust_name_span")
        		return false;
			}else if (document.getElementById("tollplazaId").value == "") 
			{
        		
        		document.getElementById("tollplazaId").focus();
        		document.getElementById("contact_person_span").innerHTML = "Please enter Toll Plaza Id.";
        		valueBackground("contact_person_span")
        		return false;
			}/* else if (document.getElementById("laneId").value == "") 
			{
        		
        		document.getElementById("laneId").focus();
        		document.getElementById("phone_span").innerHTML = "Please enter Lane Id.";
        		valueBackground("phone_span")
        		return false;
			}   */      	
        	else
        	{	// alert("HI");
        		$('#SUBMIT').prop('disabled', true);        		
        		document.forms[1].actionName.value="add";
        		document.forms[1].isActive.value="1";
        		// alert("action value"+document.forms[1].actionName.value);
        		document.forms[1].submit();
        	}			        			        				        
		}
		function valueChange(id)
		{
			document.getElementById(id).innerHTML = "";
		}
		function valueBackground(id)
		{
			document.getElementById(id).style.color = 'red';  
			document.getElementById(id).style.fontWeight = 'bold';
		}
	
		function isNumberKey(e) 
		{
		    var charCode = (e.which) ? e.which : event.keyCode
		    if (charCode > 31 && (charCode < 48 || charCode > 57))
			{
		    	alert("Only Numbers Allowed.");
        		return false;		    
			}
			return true;
		}
		
		
	
	</script>
	
	
	
	
		<title>1Pay : Reader Registration</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- <meta charset="utf-8" /> -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta content="" name="description" />
		<meta content="" name="author" />
		<!-- end: META -->
		<!-- start: GOOGLE FONTS -->
		<link href="http://fonts.googleapis.com/css?family=Lato:300,600,600italic,600,700|Raleway:300,600,500,600,700|Crete+Round:600italic" rel="stylesheet" type="text/css" />
		<!-- end: GOOGLE FONTS -->
		<!-- start: MAIN CSS -->
		<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="vendor/fontawesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="vendor/themify-icons/themify-icons.min.css">
		<link href="vendor/animate.css/animate.min.css" rel="stylesheet" media="screen">
		<link href="vendor/perfect-scrollbar/perfect-scrollbar.min.css" rel="stylesheet" media="screen">
		<link href="vendor/switchery/switchery.min.css" rel="stylesheet" media="screen">
		<link href="vendor/bootstrap-datepicker/bootstrap-datepicker3.standalone.min.css" rel="stylesheet" media="screen">
		<link href="vendor/bootstrap-timepicker/bootstrap-timepicker.min.css" rel="stylesheet" media="screen">
		<!-- end: MAIN CSS -->
		<!-- start: CLIP-TWO CSS -->
		<link rel="stylesheet" href="assets/css/styles.css">
		<link rel="stylesheet" href="assets/css/plugins.css">
		<link rel="stylesheet" href="assets/css/themes/theme-1.css" id="skin_color" />
		<link rel="stylesheet" href="css/style.min.css"/>
		
		
		<!-- DATA TABLES -->
<link href="vendor/animate.css/animate.min.css" rel="stylesheet"
	media="screen">
<link href="vendor/perfect-scrollbar/perfect-scrollbar.min.css"
	rel="stylesheet" media="screen">
<link href="vendor/switchery/switchery.min.css" rel="stylesheet"
	media="screen">
<!-- end: MAIN CSS -->
<!-- start: CLIP-TWO CSS -->
<link rel="stylesheet" href="assets/css/styles.css">
<link rel="stylesheet" href="assets/css/plugins.css">
<link rel="stylesheet" href="assets/css/themes/theme-1.css"
	id="skin_color" />
<link rel="stylesheet" href="css/transaction.css" />	
<link rel="stylesheet" href="css/style.min.css" />

		
		<style>
		a#step4:before{
		    max-width: 50%;
		width: 50%;
		}
		
		</style>
		 <style type="text/css">
        .nav-tabs>li.active>a, .nav-tabs>li.active>a:hover, .nav-tabs>li.active>a:focus
        {
            background-color:rgb(4, 167, 237);
            color:White;
            }
            
            header .navbar-collapse
            {
                background-color:rgb(221,221,232) !important;
                }
                .navbar .navbar-header
                {
                    height:50px; 
                }
                .navbar .navbar-header a
                {
                    height:50px; 
                    line-height:50px;
                }
                 #sidebar
                {
                    top :50px !important;
                }
                  #navbar-top
                {
                 height:50px;
                 }
                 #navbar-heading
            {
            height :50px !important;
			background-color:#4981af !important;
            }
			#navbar_header_1
            {
               background-color:#367fa9 !important;
			   border-right: 1px solid transparent !important;
            }
            #user-dropdown
              {
              padding-top:3px;
              padding-bottom:3px;  
              }
             #dashboard
             {
                 margin-top:5px;
                 margin-bottom:5px;
				 font-weight:500;
				 font-size:24px;
				 color:black;
             }
             .fieldTextblink{
				font-size: 10px; 
				font-family: "Verdana"; 
				color: #cc0000;
				text-decoration:none;
				font-weight:bold;
			}  
           /* .app-navbar-fixed
             {
              padding-top:50px !important;
                 }*/
   
        </style>
        
        
         <!--  Start  Style for DataTable   -->      
<style>
table {
    border-collapse: collapse;
    font-size: 12px;
    border-spacing: 0;
    /* width: 100%; */
    border: 1px solid #ddd;
}
th{
background-color: #ffffff;
}

th, td {
    text-align: left;
    padding: 8px;
    background-color: #ffffff;
}

tr:nth-child(even){background-color: #f2f2f2}

.dataTables_filter{ 
	font-size: 13px;
	margin-left: 200px;
	margin-top: -23px;
    padding-bottom: 18px;
   /*  display: none; */
			}
.dataTables_length
	{ 
	width : 200px; 
	font-size: 13px;
	/* padding: 10px; */
	}
.dataTables_info{
    margin-top: 19px;
    width: 250px;
    font-size: 14px;
}
#example_paginate{
	margin-top: -15px;
    padding-left: 700px;
   font-size: 14px;
}

</style>

<style>
#example_paginate {
    display: inline-block;
}

#example_paginate a {
    color: black;
    float: left;
    padding: 7px 13px;
    text-decoration: none;
}

#example_paginate a.active {
    background-color: #4CAF50;
    color: white;
    border-radius: 5px;
}

#example_paginate a:hover:not(.active) {
    background-color: #ddd;
    border-radius: 5px;
}
 #example_filter
{
margin-top: -32px;
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
			<header class="navbar navbar-default navbar-static-top" id="navbar-top">
					<!-- start: NAVBAR HEADER -->
					<div class="navbar-header"  style=" height:50px;" id="navbar_header_1">
						<a href="#" class="sidebar-mobile-toggler pull-left hidden-md hidden-lg" style="color:white !important;" class="btn btn-navbar sidebar-toggle" data-toggle-class="app-slide-off" data-toggle-target="#app" data-toggle-click-outside="#sidebar">
							<i class="ti-align-justify"></i>
						</a>
						<a class="navbar-brand" href="#">
							<!-- <img style = "height:50px; width:180px;" src="assets/images/logo.png" alt="PMC BANK"/> -->
                             <h2 class="mainTitle" style="margin:5px 0px; color:white;">1Pay</h2> 
						</a>
						<a href="#" class="sidebar-toggler pull-right visible-md visible-lg" style="color:white !important;" data-toggle-class="app-sidebar-closed" data-toggle-target="#app">
							<i class="ti-align-justify"></i>
						</a>
						<a class="pull-right menu-toggler visible-xs-block" id="menu-toggler" style="color:white !important;" data-toggle="collapse" href=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span>
							<i class="ti-view-grid"></i>
						</a>
					</div>
					<!-- end: NAVBAR HEADER -->
					<!-- start: NAVBAR COLLAPSE -->
					<div class="navbar-collapse collapse" id="navbar-heading">
                   		<%@ include file="/header.jsp"%>
					</div>
				</header>
			<!-- end: TOP NAVBAR -->
			<div class="main-content" >
				<div class="wrap-content container" id="container">
					<!-- start: PAGE TITLE -->
					
					<section id="page-title" style=" padding:0px 0px;">
							<div class="row">
								<div class="col-sm-7">
								   <h4 class="mainTitle" id="dashboard">Reader Registration</h4>
								</div>
							</div>
						</section>
					<!-- end: PAGE TITLE -->
					<!-- start: WIZARD DEMO -->					
					
					<div class="container-fluid container-fullw bg-white">
						<div class="row">
						<br>
										 <center>
										 
										 	<%--  <font color="white" size=5 style="Bold"> 
												<logic:equal name="readerForm" property="message" value="AA">
													 
												</logic:equal>
											</font>	  --%>
										 
										 
											<font color="red" size=5 style="Bold"> 
												<logic:equal name="readerForm" property="message" value="EE">
													Error In Inserting
												</logic:equal>
											</font>
										
											<font color="green" size=5 style="Bold"> 
												<logic:equal name="readerForm" property="message" value="SE">
													Inserted Successfully 
												</logic:equal>
											</font>	
											
											
											
											 
											
											<%--<font color="red" size=5 style="Bold"> 
												<logic:equal name="walletMasterForm" property="message" value="EE">
													Oopss!!!Something went Wrong. 
												</logic:equal>
											</font>	--%>
										</center>  
						
							<div class="col-md-12">								

								<!-- start: WIZARD FORM -->
								
									
		<html:form action="/Reader" styleId="formAdd" method="post">
					<br>						
					<fieldset>
					
					
						<legend>
							Reader Information
						</legend>
					
					<div class="row">
						
		
						<div class="col-md-6">
							<div class="form-group">
								<label>
									Toll Plaza Id <span class="symbol required"></span><span id="contact_person_span"></span>
								</label>
								<html:select property="tollplazaId" styleClass="form-control" styleId="tollplazaId">
										<html:option value="">--Select Toll Plaza--</html:option>
										<logic:present name="tollids">
											<html:options collection="tollids" labelProperty="name"
												property="code" />
										</logic:present>
								</html:select>
								<%-- <html:text styleClass="form-control" property="tollplazaId" styleId="tollplazaId" /> --%> 
								
							</div>
						</div>
					</div>
		
					<div class="row">
					
						<div class="col-md-6">
							<div class="form-group">
							
							<html:hidden property="actionName" />
							<html:hidden property="isActive"/>
  
								<label class="control-label" >
									Reader Id <span class="symbol required"></span><span id="cust_name_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="readerId" styleId="readerId" />
								
							</div>
						</div>
						
						<div class="col-md-6">
							<div class="form-group">
								<label>
									Lane Id </span><span id="phone_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="laneId" styleId="laneId"/>
								
							</div>
						</div>
						
					</div>
					 
					</fieldset>
					
					<br>
					
					<html:button value="SUBMIT" property="SUBMIT" styleId="SUBMIT" styleClass="btn btn-primary btn-o pull-right" onclick="postForm()"/>		
					
		</html:form>
		</div>
		
					<div class="panel-body">
                                <logic:present name="readerData">             
                                            
									<table class="table table-bordered table-responsive table-hover" style="" id="example">
										<thead>
											<tr>
												<c:forEach items="${headerNames}" var="name">
													<th>${name}</th>
												</c:forEach>
												<!-- <th>Edit</th>
												<th>Delete</th> -->
                                      	</tr>
										</thead>
										<tbody>
										    <c:forEach items="${readerData}" var="values">
											<tr>
												    <c:forEach items="${values}" var="value">
												    	<td>${value}</td>
												    </c:forEach>
												   <%--  <td><a href="javascript:editPlaza('${values.get(0)}')"><i class="ti-pencil"></i></a></td>
												    <td><a href="javascript:deletePlaza('${values.get(0)}')"><i class="ti-trash"></i></a></td> --%>
	                                       </tr>
											</c:forEach>
										</tbody>
									</table>
									
									<div id="pageNavPosition"></div>
						</logic:present>
				</div>
												
					
		</div>
			
		</div>
		
		<!-- start: FOOTER -->
		<footer>
			<div class="footer-inner">
				<div class="pull-left">
					&copy; <span class="current-year"></span><span>&nbsp;1Pay. All rights reserved</span>
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
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC520sSaxJvIyPXi0lrUTc6O9E7WLD47mA&libraries=places"></script>
        <script
		src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
        <script>
	
			 var options =
			 {
			  types: ['(cities)'],
			  componentRestrictions: {country: "IND"}
			 };
		
			 var input = document.getElementById('location');
			 var autocomplete = new google.maps.places.Autocomplete(input, options);
			 
			 //alert("Input : "+input+" ::: "+autocomplete);
  
 		</script>
        
        <script>
		    jQuery(document).ready(function () {
		        Main.init();
		       // Index.init();
		        UINotifications.init();
		        //$(".mainTitle").text($("#dashboard").text());
		    });
		    
		</script>
		<script>
		function pageLoad()
	    {
	    	// alert("Hello");
	    	document.getElementById("tollplazaId").value="";
	    	document.getElementById("readerId").value="";
	    	document.getElementById("laneId").value="";
	    }
		</script>
</body>
</html>