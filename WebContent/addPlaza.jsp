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
			
				 if (document.getElementById("settlementType").value == 'account')
					{
						if (document.getElementById("acc_type").selectedIndex == 0 || document.getElementById("acc_type").value == "" || document.getElementById("acc_type").value == "0") 
						{
			        		document.getElementById("acc_type").focus();
			        		document.getElementById("acc_type_span").innerHTML = "Please select Account type.";
			        		valueBackground("acc_type_span")        		
			        		return false;
						}
						else if (document.getElementById("bankName").value == "") 
						{
			        		document.getElementById("bankName").focus();
			        		document.getElementById("bankName_span").innerHTML = "Please enter bank name.";
			        		valueBackground("bankName_span")        		
			        		return false;
						}
						else if (document.getElementById("accountNo").value == "") 
						{
			        		document.getElementById("accountNo").focus();
			        		document.getElementById("accountNo_span").innerHTML = "Please enter account number.";
			        		valueBackground("accountNo_span")        		 
			        		return false;
						}    
						else if (document.getElementById("ifscCode").selectedIndex == 0 || document.getElementById("ifscCode").value == "" || document.getElementById("ifscCode").value == "0") 
						{        		
			        		document.getElementById("ifscCode").focus();
			        		document.getElementById("ifscCode_span").innerHTML = "Please enter ifsc code.";
			        		valueBackground("ifscCode_span")        		 
			        		return false;
						}
						else if (document.getElementById("ifscCode").value != "" && document.getElementById("ifscCode").value.length < 11) 
						{        		
			        		var value = document.getElementById('ifscCode').value;
			        		var len = value.length;
			        		document.getElementById("ifscCode").focus();
			        		document.getElementById("ifscCode_span").innerHTML = " Enter 11 Digit ifsc code.";
			        		valueBackground("ifscCode_span")        		 
			        		return false;
						}
				}
        	if (document.getElementById("toll_plaza_id").value == "") 
			{
        		
        		document.getElementById("toll_plaza_id").focus();
        		document.getElementById("toll_plaza_id_span").innerHTML = "Please enter Toll Plaza ID.";
        		valueBackground("toll_plaza_id_span")
        		return false;
			}else if (document.getElementById("merchant_id").value == "") 
			{
        		
        		document.getElementById("merchant_id").focus();
        		document.getElementById("merchant_id_span").innerHTML = "Please enter Mechant Id.";
        		valueBackground("merchant_id_span")
        		return false;
			}
			else if (document.getElementById("toll_name").value == "") 
			{
        		
        		document.getElementById("toll_name").focus();
        		document.getElementById("toll_name_span").innerHTML = "Please enter toll name.";
        		valueBackground("toll_name_span")
        		return false;
			}
			else if (document.getElementById("location").value == "") 
			{
        		
        		document.getElementById("location").focus();
        		document.getElementById("location_span").innerHTML = "Please enter Location.";
        		valueBackground("location_span")
        		return false;
			}
			else if (document.getElementById("contact_person").value == "") 
			{
        		
        		document.getElementById("contact_person").focus();
        		document.getElementById("contact_person_span").innerHTML = "Please enter contact person.";
        		valueBackground("contact_person_span")
        		return false;
			}
			else if (document.getElementById("emailid").value == "") 
			{
        		
        		document.getElementById("emailid").focus();
        		document.getElementById("email_span").innerHTML = "Please enter emailId.";
        		valueBackground("email_span")
        		return false;
			}
			else if (document.getElementById("contactNo").value == "") 
			{
        		
        		document.getElementById("contactNo").focus();
        		document.getElementById("contact_no_span").innerHTML = "Please enter contact no.";
        		valueBackground("contact_no_span")
        		return false;
			}
			else if (document.getElementById("geoCode").value == "") 
			{
        		
        		document.getElementById("geoCode").focus();
        		document.getElementById("geo_location_span").innerHTML = "Please enter geo location.";
        		valueBackground("geo_location_span")
        		return false;
			}
			else if (document.getElementById("tollType").value == "") 
			{
        		
        		document.getElementById("tollType").focus();
        		document.getElementById("toll_type_span").innerHTML = "Please enter toll type.";
        		valueBackground("toll_type_span")
        		return false;
			}
			else if (document.getElementById("add1").value == "") 
			{
        		
        		document.getElementById("add1").focus();
        		document.getElementById("add1_span").innerHTML = "Please enter address.";
        		valueBackground("add1_span")
        		return false;
			}
			/* else if (document.getElementById("add2").value == "") 
			{
        		
        		document.getElementById("add2").focus();
        		document.getElementById("add2_span").innerHTML = "Please enter address.";
        		valueBackground("add2_span")
        		return false;
			} */
			else if (document.getElementById("state").value == "") 
			{
        		
        		document.getElementById("state").focus();
        		document.getElementById("state_span").innerHTML = "Please enter state.";
        		valueBackground("state_span")
        		return false;
			}
			else if (document.getElementById("city").value == "") 
			{
        		
        		document.getElementById("city").focus();
        		document.getElementById("city_span").innerHTML = "Please enter city.";
        		valueBackground("city_span")
        		return false;
			}
			else if (document.getElementById("pin").value == "") 
			{
        		
        		document.getElementById("pin").focus();
        		document.getElementById("pin_span").innerHTML = "Please enter pin.";
        		valueBackground("pin_span")
        		return false;
			}
        	else
        	{	//alert("HI");
        		$('#SUBMIT').prop('disabled', true);        		
        		document.forms[1].actionName.value=action;
        		//document.forms[1].isActive.value="1";
        		//alert("action value"+document.forms[1].actionName.value);
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
		{	//alert('HI');
		    var charCode = (e.which) ? e.which : event.keyCode
		    if (charCode > 31 && (charCode < 48 || charCode > 57))
			{
		    	alert("Only Numbers Allowed.");
        		return false;		    
			}
			return true;
		}
		
		
	
	</script>
	
		<title>1Pay : Plaza Registration</title>
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
           /* .app-navbar-fixed
             {
              padding-top:50px !important;
                 }*/
   
        </style>
	</head>

<body onload="pageLoad()" >
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
								   <h4 class="mainTitle" id="dashboard">Plaza Registration</h4>
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
									
		<html:form action="/Plaza.do" styleId="formAdd" method="post">
					<br>						
					<fieldset>
					
					
						<legend>
							Plaza Information
						</legend>
					
					<div class="row">
						
						<div class="col-md-6">
								<div class="form-group">
			                           <label>
											Merchant Id <span class="symbol required"></span><span id="merchant_id_span"></span>
										</label>                     
			                          <html:select property="merchant_id" styleClass="form-control" styleId="merchant_id">
										<html:option value="">--Select Merchant--</html:option>
										<logic:present name="merchants">
											<html:options collection="merchants" labelProperty="name"
												property="code" />
										</logic:present>
									</html:select>
			                   </div>
							
						</div>
						
						<div class="col-md-6">
							<div class="form-group">
							
							<html:hidden property="actionName" />
							<html:hidden property="id"/> 
  
								<label class="control-label" >
									Toll Plaza Id <span class="symbol required"></span><span id="toll_plaza_id_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="toll_plaza_id" styleId="toll_plaza_id" />
								
							</div>
						</div>
		
						
					</div>
		
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>
									Toll Name <span class="symbol required"></span><span id="toll_name_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="toll_name" styleId="toll_name"/>
								
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>
									Location <span class="symbol required"></span><span id="location_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="location" styleId="location" /> 
								
							</div>
						</div>
						
					</div>
					<!-- pratik -->
					
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>
									Contact Person <span class="symbol required"></span><span id="contact_person_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="contact_person" styleId="contact_person" />
								
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>
									Email Id <span class="symbol required"></span><span id="email_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="emailid" styleId="emailid" maxlength="50"/> 
								
							</div>
						</div>
						
					</div>
					
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>
									Contact No. <span class="symbol required"></span><span id="contact_no_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="contactNo" styleId="contactNo" onkeypress="return isNumberKey(event);" maxlength="10"/>
								
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>
									Geo Location <span class="symbol required"></span><span id="geo_location_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="geoCode" styleId="geoCode" /> 
								
							</div>
						</div>
						
					</div>
					
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>
									Toll Type <span class="symbol required"></span><span id="toll_type_span"></span>
								</label>
								<html:select property="tollType" styleClass="form-control" styleId="tollType">
										<html:option value="">--Select Toll Type--</html:option>
										<html:option value="NH">National Highway Toll</html:option>
										<html:option value="State">State Toll</html:option>
										<html:option value="City">City Toll</html:option>
										<html:option value="Parking">Parking</html:option>
								</html:select>		
								<%-- <html:text styleClass="form-control" property="tollType" styleId="tollType"/> --%>
								
							</div>
						</div>
						
						<div class="col-md-6">
							<div class="form-group">
								<label>
									Settlement Account <span class="symbol required"></span><span id="settlement_type_span"></span>
								</label>
								<html:select property="settlementType" styleClass="form-control" styleId="settlementType" onchange="showDiv(this)">
										<html:option value="merchant">Merchant</html:option>
										<html:option value="account">Plaza</html:option>
										
								</html:select>		
								<%-- <html:text styleClass="form-control" property="tollType" styleId="tollType"/> --%>
								
							</div>
						</div>
						
						<!-- <div class="col-md-6">
							<div class="form-group">
								<label>
									Settlement Type <span class="symbol required"></span><span id="settlement_type_span"></span>
								</label>
								</br>
								<select property="settlementType" styleId="settlementType" styleClass="form-control" onchange="showDiv(this)">
										<option value="merchant">Merchant</option>
										<option value="account">Account</option>										
								</select>									
							</div>
						</div> -->
						
						
					</div>
					
					<div class="row" id="bankDetails" style="display: none;">
						<div class="col-md-6">
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
								
						<div class="col-md-6">
							<div class="form-group">
								<label>
									Bank Name <span class="symbol required"></span><span id="bankName_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="bankName" styleId="bankName"/>
								
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>
									Account <span class="symbol required"></span><span id="accountNo_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="accountNo" styleId="accountNo"  onkeypress="return isNumberKey(event);" maxlength="35"/> 
								
							</div>
						</div>
						
						<div class="col-md-6">
							<div class="form-group">
								<label>
									IFSC Code <span class="symbol required"></span><span id="ifscCode_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="ifscCode" styleId="ifscCode" maxlength="11" /> 
								
							</div>
						</div>
						
					</div>
								
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>
									Address 1 <span class="symbol required"></span><span id="add1_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="add1" styleId="add1"/>
								
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>
									Address 2 </span><span id="add2_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="add2" styleId="add2" /> 
								
							</div>
						</div>
						
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>
									State <span class="symbol required"></span><span id="state_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="state" styleId="state"/>
								
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>
									City <span class="symbol required"></span><span id="city_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="city" styleId="city" /> 
								
							</div>
						</div>
						
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>
									Pin <span class="symbol required"></span><span id="pin_span"></span>
								</label>
								
								<html:text styleClass="form-control" property="pin" styleId="pin" onkeypress="return isNumberKey(event);" maxlength="6"/>
								
							</div>
						</div>
						
						
					</div>					 
					</fieldset>
					
					<br>
					
					<html:button value="Back" property="Back" styleId="Back" styleClass="btn btn-primary btn-o pull-right" onclick="openPage('Plaza.do')"/>
					 <logic:notPresent name="edit">
					
					<html:button value="SUBMIT" property="SUBMIT" styleId="SUBMIT" styleClass="btn btn-primary btn-o pull-right" onclick="postForm('addPlaza');"/>		
					 </logic:notPresent>	
					
					 <logic:present name="edit">	
					<html:button value="Update" property="Update"  styleClass="btn btn-primary btn-o pull-center" onclick="postForm('updatePlaza')"/>
					</logic:present>
		</html:form>
		</div>
		</div>
		</div>
		</div></div></div>
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
	</div>
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
        
        <script>
	
			 /* var options =
			 {
			  types: ['(cities)'],
			  componentRestrictions: {country: "IND"}
			 };
		
			 var input = document.getElementById('location');
			 var autocomplete = new google.maps.places.Autocomplete(input, options); */
			 
			 //alert("Input : "+input+" ::: "+autocomplete);
  
 		</script>
        <script>
		function pageLoad()
	    {
			// alert("settlementType  "+document.getElementById("settlementType").value);
			var elem = document.getElementById("settlementType").value;
			// alert("elem "+ elem);
			if(elem == 'account'){
				// alert("Showing Div");
			      document.getElementById('bankDetails').style.display = "block";
			   	}
			   if(elem == 'merchant'){
					document.getElementById('bankDetails').style.display = "none";
				}
			   
	    	// alert("Hello");
	    	/* document.getElementById("merchant_id").value="";
	    	document.getElementById("toll_plaza_id").value="";
	    	document.getElementById("toll_name").value="";
	    	document.getElementById("location").value="";
	    	document.getElementById("contact_person").value="";
	    	document.getElementById("emailid").value="";
	    	document.getElementById("contactNo").value="";
	    	document.getElementById("geoCode").value="";
	    	document.getElementById("tollType").value="";
	    	document.getElementById("bankName").value="";
	    	document.getElementById("accountNo").value="";
	    	document.getElementById("ifscCode").value="";
	    	document.getElementById("add1").value="";
	    	document.getElementById("add2").value="";
	    	document.getElementById("state").value="";
	    	document.getElementById("city").value="";
	    	document.getElementById("pin").value=""; */
	    	
	    }
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
		function showDiv(elem){
				   if(elem.value == 'account'){
				      document.getElementById('bankDetails').style.display = "block";
				   	}
				   if(elem.value == 'merchant'){
						document.getElementById('bankDetails').style.display = "none";
					}
				}
		</script> 
</body>
</html>