<%@ include file="/include.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	
	<script>
	 function openPage(pageURL) {
		//  alert("URL "+pageURL);
	      window.location = pageURL;
	    }
	</script>
	
	<script type="text/javascript">
		
	
		function postForm(action)
		{
			
        	if (document.getElementById("cust_name").value == "") 
			{
        		document.getElementById("cust_name").focus();
        		document.getElementById("cust_name_span").innerHTML = "Please enter Concessioner name.";
        		valueBackground("cust_name_span")
        		return false;
			}
        	else if (document.getElementById("contact_person").value == "") 
			{
        		document.getElementById("contact_person").focus();
        		document.getElementById("contact_person_span").innerHTML = "Please enter contact person name.";
        		valueBackground("contact_person_span")
        		return false;
			}
        	else if (document.getElementById("phone").value == "" && document.getElementById("phone").value.length < 10) 
			{
        		document.getElementById("phone").focus();
        		document.getElementById("phone_span").innerHTML = "Please enter contact number.";
        		valueBackground("phone_span");
        		return false;
			}
        	else if (document.getElementById("email_id").value == "") 
			{
        		document.getElementById("email_id").focus();
        		document.getElementById("email_id_span").innerHTML = "Please enter email id.";
        		valueBackground("email_id_span")
        		return false;
			}        	
        	else if (document.getElementById("address1").value == "") 
			{
        		document.getElementById("address1").focus();
        		document.getElementById("address1_span").innerHTML = "Please enter address.";
        		valueBackground("address1_span")
        		return false;
			}
        	
        	else if (document.getElementById("location").value == "") 
			{
        		document.getElementById("location").focus();
        		document.getElementById("location_span").innerHTML = "Please Enter Location (City/State/Country).";
        		valueBackground("location_span");
        		return false;
			}
        	/*  else if(document.getElementById("location").value != "") 
        	{
        		
        		 var regex = /(,|-)/.test(yourString);
     		    var location = document.getElementById("location").value;
     		    
     		    if(location != null && location != "" && !regex.test(location))
     			{	
     		    	document.getElementById("location").focus();
             		document.getElementById("location_span").innerHTML = "Location with comma seperator ";
             		valueBackground("location_span")
             		return false;
     			}
        	}  */
        	else if (document.getElementById("pin").value == "" && document.getElementById("pin").value.length < 6) 
			{
        		document.getElementById("pin").focus();
        		document.getElementById("pin_span").innerHTML = "Please enter pin number.";
        		valueBackground("pin_span");
        		return false;
			}	
        	
		
		
        	else if (document.getElementById("base_mdr").value == "") /* && charCode > 31 && (charCode < 46 || charCode > 57)) */
        	{
        		document.getElementById("base_mdr").value="";
        		document.getElementById("base_mdr").focus();
        		document.getElementById("basemdrspan").innerHTML = "Please enter base rate(0-9 numbers only).";
        		valueBackground("basemdrspan");
        		
        		return false;
			} 
        	else if (document.getElementById("tsp_mdr").value == "") /* && charCode > 31 && (charCode < 46 || charCode > 57)) */
        	{
        		document.getElementById("tsp_mdr").value="";
        		document.getElementById("tsp_mdr").focus();
        		document.getElementById("tspmdrspan").innerHTML = "Please enter TSP rate(0-9 numbers only).";
        		valueBackground("tspmdrspan");
        		
        		return false;
			} 
        	else if(document.getElementById("from_date").value == "")
        	{
        		document.getElementById("from_date").focus();
        		document.getElementById("from_datespan").innerHTML = "Select From Date.";
        		valueBackground("from_datespan");
        	 
        		return false;      			
        	}
        	else if(document.getElementById("to_date").value == "")
        	{
        		document.getElementById("to_date").focus();
        		document.getElementById("to_datespan").innerHTML = "Select To Date.";
        		valueBackground("to_datespan");
        	 
        		return false;      			
        	}
        	else if(document.getElementById("mdr_type").selectedIndex == 0)
        	{
        		document.getElementById("mdr_type").focus();
        		document.getElementById("mdr_typespan").innerHTML = "Select MDR Type.";
        		valueBackground("mdr_typespan");
        	 
        		return false;      			
        	}
        	
        	
        	else if(document.getElementById("is_active").selectedIndex == 0)
        	{
        		document.getElementById("is_active").focus();
        		document.getElementById("is_active_span").innerHTML = "Select Active Type.";
        		valueBackground("is_active_span");
        	 
        		return false;      			
        	}
        	
        	
        	
        	else if (document.getElementById("acc_type").selectedIndex == 0 || document.getElementById("acc_type").value == "" || document.getElementById("acc_type").value == "0") 
			{
        		document.getElementById("acc_type").focus();
        		document.getElementById("acc_type_span").innerHTML = "Select Account type.";
        		valueBackground("acc_type_span")        		
        		return false;
			}
        	else if (document.getElementById("account_number").value == "") 
			{
        		document.getElementById("account_number").focus();
        		document.getElementById("account_number_span").innerHTML = "Please enter account number.";
        		valueBackground("account_number_span")        		 
        		return false;
			}        	
        	
		
        	else if (document.getElementById("bank_name").selectedIndex == 0 || document.getElementById("bank_name").value == "" )  
			{
        		document.getElementById("bank_name").focus();
        		document.getElementById("bank_name_span").innerHTML = "Select bank name.";
        		valueBackground("bank_name_span")        		
        		return false;
			}
        	 else if (document.getElementById("ifsc_code").selectedIndex == 0 || document.getElementById("ifsc_code").value == "" || document.getElementById("ifsc_code").value == "0") 
 			{        		
         		document.getElementById("ifsc_code").focus();
         		document.getElementById("ifsc_code_span").innerHTML = "Enter ifsc code.";
         		valueBackground("ifsc_code_span")        		 
         		return false;
 			} 
        	
        	else if (document.getElementById("ifsc_code").value != "" && document.getElementById("ifsc_code").value.length < 7) 
			{        		
        		var value = document.getElementById('ifsc_code').value;
        		var len = value.length;
        		document.getElementById("ifsc_code").focus();
        		document.getElementById("ifsc_code_span").innerHTML = " Enter 11 Digit ifsc.";
        		valueBackground("ifsc_code_span")        		 
        		return false;
			}
        	
        	
        	else
        	{
        		$('#SUBMIT').prop('disabled', true);        		
        		document.forms[1].actionName.value=action;
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
		
		function isNumberKeyFloat(e) 
		{
		    var charCode = (e.which) ? e.which : event.keyCode
		    if (charCode > 31 && ( charCode < 45 || charCode > 57 ) )
			{
		    	alert("Only Numbers Allowed.");
        		return false;		    
			}
			return true;
		}
		
		function validateEmail() 
		{
		    var regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,5}$/;
		    var mailId = document.getElementById("email_id").value;
		    
		    if(mailId != null && mailId != "" && !regex.test(mailId))
			{	
		    	document.getElementById("email_id").focus();
        		document.getElementById("email_id_span").innerHTML = "Please Enter Valid Email Id.";
        		valueBackground("email_id_span")
        		return false;
			}
			
			return true;
		}
	
		
		
			
	</script>
	
		<title>1Pay : Concessioner</title>
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
		<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
		<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
		<script src="vendor/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
		<script src="vendor/bootstrap-timepicker/bootstrap-timepicker.min.js"></script>
	
		<script src="vendor/jquery/jquery.min.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	
		
		
		<!--here is validation  -->
		<!-- <script type="text/javascript" src="js/wallet.js" ></script> -->
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
			
			 .input-group-addon{
				background-color: #4981af !important;
				border: 1px solid #4981af !important;
				color: #ffffff !important;
			 }
			
        .help-block
		{
			margin-top:0px !important;
		}
		
           /* .app-navbar-fixed
             {
              padding-top:50px !important;
                 }*/
   
        </style>
        
        <style>

#IFSC {background-color: #e7e7e7; color: black; font-family: Arial; margin-right: 97px;} /* Gray */ 
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
								   <h4 class="mainTitle" id="dashboard">Concessioner</h4>
								</div>
							</div>
						</section>
					<!-- end: PAGE TITLE -->
					<!-- start: WIZARD DEMO -->					
					
					<div class="container-fluid container-fullw bg-white">
						<div class="row">
						<br>
										
						
							<div class="col-md-12">								

								<!-- start: WIZARD FORM -->
									
		<html:form action="/merchantMaster" styleId="formAdd" method="post">
					<br>						
					<fieldset>
						<legend>
							Personal Information
						</legend>
					
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
							
							<html:hidden property="actionName" />
  							<html:hidden property="id"/>
								<label class="control-label" >
									Concessioner Name <span class="symbol required"></span><span id="cust_name_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="cust_name" styleId="cust_name" onkeyup="javascript:valueChange('cust_name_span');" />
								
							</div>
						</div>
		
						<div class="col-md-6">
							<div class="form-group">
								<label>
									Contact Person  <span class="symbol required"></span><span id="contact_person_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="contact_person" styleId="contact_person" onkeyup="javascript:valueChange('contact_person_span');"/> 
								
							</div>
						</div>
					</div>
		
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>
									Contact Number <span class="symbol required"></span><span id="phone_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="phone" styleId="phone" maxlength="10" onblur ="return validatePhone();" onkeypress="return isNumberKey(event);"/>
								
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">
									Email-ID <span class="symbol required"></span><span id="email_id_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="email_id" styleId="email_id" onkeypress="javascript:valueChange('email_id_span');" onblur="return validateEmail();" />
								
							</div>
						</div>
					</div>
					
					
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label>
									Address <span class="symbol required"></span><span id="address1_span"></span>
								</label>
								
								<html:textarea styleClass="form-control" property="address1" styleId="address1" onkeyup="javascript:valueChange('address1_span');"/>
								
							</div>
						</div>
					</div>
					
					
					
					 <div class="row">
								
						<div class="col-md-6">
							<div class="form-group">
														
								<label class="control-label" >
									Location (City/State/Country) <span class="symbol required"></span><span id="location_span"></span>
								</label>
															
								 <html:text styleClass="form-control" property="location" styleId="location"/>
							
							</div>
						</div>
						<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label" >
									PIN <span class="symbol required"></span><span id="pin_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="pin" styleId="pin" maxlength="6" onkeyup="javascript:valueChange('pin_span');" onkeypress="return isNumberKey(event);"/>
							
							</div>
							</div>
						</div>
					
					
						
						
						
						
					</div>
					</fieldset>
					
					<br>
					<!-- bharat mdr -->
					
					<fieldset>
							<legend>
								MDR Details
							</legend>
							
							<div class="row">
							
							
							<div class="col-md-3">
									<div class="form-group">
										<label class="control-label">
											Base MDR<span class="symbol required"></span><span id="basemdrspan"></span> 
										</label>
										<br>
										<html:text styleClass="form-control" property="base_mdr" styleId="base_mdr" onkeyup="javascript:valueChange('basemdrspan');" onkeypress="return isNumberKeyFloat(event);" maxlength="5"/>
									</div>
							</div>
							
							
							<div class="col-md-3">
									<div class="form-group">
										<label class="control-label">
											TSP MDR<span class="symbol required"></span><span id="tspmdrspan"></span> 
										</label>
										<br>
										<html:text styleClass="form-control" property="tsp_mdr" styleId="tsp_mdr" onkeyup="javascript:valueChange('tspmdrspan');" onkeypress="return isNumberKeyFloat(event);" maxlength="5"/>
									</div>
							</div>
							
				
						<div class="col-md-3">
							<div class="form-group">
								<label class="control-label">
									From Date<span class="symbol required"></span><span id="from_datespan"></span>
								</label>
								
								<div class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" >
									<input class="form-control" onkeypress="return Date1(event);" maxlength="10" property="from_date" styleId="from_date" name="from_date" id="from_date" type="text" onkeyup="javascript:valueChange('from_datespan');"  placeholder="yyyy-mm-dd" readonly="readonly">
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
								</div>
								<input type="hidden" id="dtp_input2" value="" /><br/>

							</div>
						</div>
										
										
						<div class="col-md-3">
							<div class="form-group">
								<label class="control-label">
									To Date<span class="symbol required"></span><span id="to_datespan"></span>
								</label>
								<div class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" >
									<input class="form-control" property="to_date" styleId="to_date" name="to_date" onkeypress="return Date1(event);" maxlength="10" id="to_date" type="text" onkeyup="javascript:valueChange('to_datespan');" placeholder="yyyy-mm-dd">
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
								</div>
									<input type="hidden" id="dtp_input2" value="" /><br/>
							</div>
						</div>
																
							</div>
							
							<div class="row">
							
							   <div class="col-md-3">
									<div class="form-group">
										
										<label class="control-label" >
											MDR Type <span class="symbol required"></span><span id="mdr_typespan"></span>
										</label>
										<html:select styleClass="form-control" property="mdr_type" styleId="mdr_type" onchange="javascript:valueChange('mdr_typespan');">
											<html:option value="">---Select MDR Type---</html:option>
											<html:option value="P">Percentage</html:option>
											<html:option value="F">Flat</html:option>
										</html:select>
									</div>
									</div> 
									
									
							  <div class="col-md-3">
									<div class="form-group">
										<label class="control-label" >
											IS Active <span class="symbol required"></span><span id="is_active_span"></span>
										</label>
										
										<html:select styleClass="form-control" property="is_active" styleId="is_active" onchange="javascript:valueChange('is_active_span');">
											<html:option value="">---Select Type---</html:option>
											<html:option value="T">True</html:option>
											<html:option value="F">False</html:option>
										</html:select>
										
									</div>
								</div> 
							
							</div>
						</fieldset>
					
					<br>
						
						<!-- <br> -->
						
						<fieldset>
							<legend>
								Account Details
							</legend>
							
							<div class="row">
									<div class="col-md-3">
										<div class="form-group">
										
										<label class="control-label" >
											Account Type <span class="symbol required"></span><span id="acc_type_span"></span>
										</label>
										<html:select styleClass="form-control" property="acc_type" styleId="acc_type" onchange="javascript:valueChange('acc_type_span');">
											<html:option value="0">---Select Type---</html:option>
											<html:option value="Savings">Savings</html:option>
											<html:option value="Current">Current</html:option>
										</html:select>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label class="control-label" >
											Account Number <span class="symbol required"></span><span id="account_number_span"></span>
										</label>
								
										<html:text styleClass="form-control" property="account_number" styleId="account_number" maxlength="16" onkeyup="javascript:valueChange('account_number_span');" onkeypress="return isNumberKey(event);"/>
										
									</div>
								</div>
								
								<div class="col-md-3">
									<div class="form-group">
										<label class="control-label" >
											Bank Name <span class="symbol required"></span><span id="bank_name_span"></span>
										</label>
								
										<%-- <html:text styleClass="form-control" property="bank_name" styleId="bank_name" maxlength="25" onkeyup="javascript:valueChange('bank_name_span');"  /> --%>	<!-- readonly="true"  -->
										
									<html:select property="bank_name" styleClass="form-control" styleId="bank_name" onchange="getIFSC()">
										<html:option value="">--Select Bank Name--</html:option>
										<logic:present name="bankNames">
											<html:options collection="bankNames" labelProperty="name"
												property="name" />
										</logic:present>
									</html:select>
									
									</div>
								</div>

								<div class="col-md-3">
									<div class="form-group">
										<label class="control-label" >
											IFSC Code <span class="symbol required"></span><span id="ifsc_code_span"></span>
										</label>
										
										<!-- <label><span class="label IFSC">IFSC</span></label> -->
								<!--  <input type="text" name="IFSC" id="IFSC" property="IFSC" styleId="IFSC" style="width: 50px; height: 32px;" readonly="readonly" /> 	 -->	
								<html:text styleClass="form-control" property="IFSC" styleId="IFSC"  style="width: 50px; height: 32px;" readonly="readonly"  />
								<html:text styleClass="form-control" property="ifsc_code" styleId="ifsc_code" maxlength="7" onkeyup="javascript:valueChange('ifsc_code_span');" style="margin-top: -32px; margin-left: 55px; width: 135px" readonly="true" />  <!-- style="width: 129px; margin-left: 60px;" --> 
										
									</div>
								</div>
								
								
								
							</div>
						</fieldset>
					
					
					<%-- <html:button value="SUBMIT" property="SUBMIT" styleId="SUBMIT" styleClass="btn btn-primary btn-o pull-right" onclick="postForm()"/>	 --%>
					
					<center>
					<input type="button" class="btn btn-primary btn-o pull-center" id="backbutton" value="Back" name="button" onclick="openPage('merchantMaster.do')" />
					 <logic:notPresent name="edit">	
					 	&nbsp;	
					 <html:button value="SUBMIT" property="SUBMIT"  styleClass="btn btn-primary btn-o pull-center" onclick="postForm('createMerchant')"/>
					</logic:notPresent>
					&nbsp;
					<logic:present name="edit">	
					<html:button value="Update" property="Update"  styleClass="btn btn-primary btn-o pull-center" onclick="postForm('updateMerchant')"/>
					</logic:present>
					</center>	
					
		</html:form>
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
		<script src="vendor/selectFx/classie.js"></script>
		<script src="vendor/selectFx/selectFx.js"></script>
		
		<script src="vendor/jquery-validation/jquery.validate.min.js"></script>
		<script src="vendor/jquery-smart-wizard/jquery.smartWizard.js"></script>
		<script src="vendor/jquery-file-upload/vendor/jquery.ui.widget.js"></script>	
		<script src="http://blueimp.github.io/JavaScript-Templates/js/tmpl.min.js"></script>		
		<script src="vendor/javascript-Load-Image/load-image.all.min.js"></script>
		<script src="http://blueimp.github.io/JavaScript-Canvas-to-Blob/js/canvas-to-blob.min.js"></script>
		
		<!-- blueimp Gallery script -->
		<script src="http://blueimp.github.io/Gallery/js/jquery.blueimp-gallery.min.js"></script>
		<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
		<script src="vendor/jquery-file-upload/jquery.iframe-transport.js"></script>
		<!-- The basic File Upload plugin -->
		<script src="vendor/jquery-file-upload/jquery.fileupload.js"></script>
		<!-- The File Upload processing plugin -->
		<script src="vendor/jquery-file-upload/jquery.fileupload-process.js"></script>
		<!-- The File Upload image preview & resize plugin -->
		<script src="vendor/jquery-file-upload/jquery.fileupload-image.js"></script>
		<!-- The File Upload audio preview plugin -->
		<script src="vendor/jquery-file-upload/jquery.fileupload-audio.js"></script>
		<!-- The File Upload video preview plugin -->
		<script src="vendor/jquery-file-upload/jquery.fileupload-video.js"></script>
		<!-- The File Upload validation plugin -->
		<script src="vendor/jquery-file-upload/jquery.fileupload-validate.js"></script>
		<!-- The File Upload user interface plugin -->
		<script src="vendor/jquery-file-upload/jquery.fileupload-ui.js"></script>
		<!-- The main application script -->
		<script src="vendor/jquery-file-upload/main.js"></script>
		<script src="vendor/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
		<script src="vendor/bootstrap-timepicker/bootstrap-timepicker.min.js"></script>

		<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
		<!-- start: CLIP-TWO JAVASCRIPTS -->
		<script src="assets/js/main.js"></script>
		<!-- start: JavaScript Event Handlers for this page -->
		<script src="assets/js/form-wizard.js"></script>
		<script src="assets/js/bulkUpload.js"></script>
		<script src="assets/js/xlsx.min.js"></script>
		
		
		 <script src="assets/js/main.js"></script>
        <script src="assets/js/ui-notifications.js"></script> 
		 <script src="vendor/jquery/jquery.min.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.min.js"></script> 
		<script src="vendor/modernizr/modernizr.js"></script>
		<script src="vendor/jquery-cookie/jquery.cookie.js"></script> 
		
		<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC520sSaxJvIyPXi0lrUTc6O9E7WLD47mA&libraries=places"></script>
		
		 <script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
		<script src="vendor/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
		<script src="vendor/bootstrap-timepicker/bootstrap-timepicker.min.js"></script> 
        
        
        
		
		
		
         <script>
        jQuery(document).ready(function () {
	        Main.init();
	       // Index.init();
	        UINotifications.init();
	        //$(".mainTitle").text($("#dashboard").text());
	    });
		    
		    
		</script> 
       
		
		
        <script type="text/javascript">
		$('.form_date').datetimepicker({
       
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    });
		</script>
		
		<script type="text/javascript">
		function Date1(e) 
		 {
		  debugger
		 
		  var regex = new RegExp("^[0-9 /-]+$");
		 var key = String.fromCharCode(!event.charCode ? event.which: event.charCode);
			 if (!regex.test(key)) 
				 {
					 event.preventDefault();
					 return false;
				 } 
	
		 }
		
		</script>
		
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
 		
 		<script type="text/javascript">
 		
 		function getIFSC() {
			//alert("Hello");
			
		    var bank_name = $("#bank_name").val();
			// alert("Bank Name "+bank_name);
		    
		    if (document.getElementById("bank_name").selectedIndex == 0 || document.getElementById("bank_name").value == "" )  
			{
        		// document.getElementById("bank_name").focus();
        		
        		$('#IFSC').val("IFSC");
        		$("#ifsc_code").prop("readonly", true);
			} 
					
				 
		    else if( bank_name !=null && bank_name != "")
					{
					 $.ajax({				
						url: "<%=request.getContextPath()%>/ajaxAction.do?type=getIFSC",
								
						type: 'POST',	   
			        	data: {bank_name : bank_name},
						success: function(result) {
							if (result != null && result != "") {
								// alert("set IFSC COde "+result);
								$('#IFSC').val(result);
								$("#ifsc_code").prop("readonly", false);
							} 
							
							
								
							
						},
						error: function (err) {
							console.log("Error in Getting IFSC");
					    }
					});
					}		
 		}		
 		</script>
 		<script type="text/javascript">
 		function pageLoad()
 		{
 			// alert("PageLoad");
 			 if (document.getElementById("bank_name").selectedIndex == 0 || document.getElementById("bank_name").value == "" )  
 			{
         	// 	alert("PageLoad bank_name selectedIndex == 0 ");
         		$('#IFSC').val("IFSC");
         		$("#ifsc_code").prop("readonly", true);
 			} 
 			
 			
 		}
 		
 		</script>
        
        
</body>
</html>