<%@ include file="/include.jsp"%>

<!DOCTYPE html>
<!-- Template Name: Clip-Two - Responsive Admin Template build with Twitter Bootstrap 3.x | Author: ClipTheme -->
<!--[if IE 8]><html class="ie8" lang="en"><![endif]-->
<!--[if IE 9]><html class="ie9" lang="en"><![endif]-->
<!--[if !IE]><!-->
<html lang="en">
	<!--<![endif]-->
	<!-- start: HEAD -->
	<head>
		<title>1Pay - Exception Details</title>
		
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta content="" name="description" />
		<meta content="" name="author" />
		<!-- end: META -->
		<!-- start: GOOGLE FONTS -->
		<link href="http://fonts.googleapis.com/css?family=Lato:300,400,400italic,600,700|Raleway:300,400,500,600,700|Crete+Round:400italic" rel="stylesheet" type="text/css" />
		<!-- end: GOOGLE FONTS -->
		<!-- start: MAIN CSS -->
		<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="vendor/fontawesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="vendor/themify-icons/themify-icons.min.css">
		<link href="vendor/animate.css/animate.min.css" rel="stylesheet" media="screen">
		<link href="vendor/perfect-scrollbar/perfect-scrollbar.min.css" rel="stylesheet" media="screen">
		<link href="vendor/switchery/switchery.min.css" rel="stylesheet" media="screen">
		<!-- end: MAIN CSS -->
		<!-- start: CLIP-TWO CSS -->
		<link rel="stylesheet" href="assets/css/styles.css">
		<link rel="stylesheet" href="assets/css/plugins.css">
		<link rel="stylesheet" href="assets/css/themes/theme-1.css" id="skin_color" />
		<link rel="stylesheet" href="css/style.min.css" rel="stylesheet"/>
		<!-- end: CLIP-TWO CSS -->
		<!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
        <link href="vendor/sweetalert/sweet-alert.css" rel="stylesheet" media="screen">
		<link href="vendor/sweetalert/ie9.css" rel="stylesheet" media="screen">
		<link href="vendor/toastr/toastr.min.css" rel="stylesheet" media="screen">
		
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    
    <script src="js/jquery-1.12.4.js"></script>
 <script src="js/jquery.dataTables.min.js"></script>
 
 
 
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
			 .input-group-addon{
				background-color: #4981af !important;
				border: 1px solid #4981af !important;
				color: #ffffff !important;
			 }
           
                 
        </style>
		
		
		<!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
		
 <!-- <link rel="stylesheet" href="css/loder.css"/>
 <link rel="stylesheet" href="css/reportmain.css"/>
 <link rel="stylesheet" href="css/material-icons.css"/>
 
  <script src="css/echarts.js"></script>
 <script src="css/ngecharts.js"></script>
 <script src="css/ui.js"></script>
 <script src="css/vendor.js"></script> -->
		
		
		
	</head>
	<!-- end: HEAD -->
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
					<div class="navbar-header" style=" height:50px;" id="navbar_header_1">
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
					<!--<a class="dropdown-off-sidebar sidebar-mobile-toggler hidden-md hidden-lg" data-toggle-class="app-offsidebar-open" data-toggle-target="#app" data-toggle-click-outside="#off-sidebar">
						&nbsp;
					</a>-->
					<!--<a class="dropdown-off-sidebar hidden-sm hidden-xs" data-toggle-class="app-offsidebar-open" data-toggle-target="#app" data-toggle-click-outside="#off-sidebar">
						&nbsp;
					</a>-->
					<!-- end: NAVBAR COLLAPSE -->
				</header> 
				<!-- end: TOP NAVBAR -->
				<div class="main-content" >
					<div class="wrap-content container" id="container">
						<!-- start: DASHBOARD TITLE -->
						<section id="page-title" style=" padding:0px 0px;">
							<div class="row">
								<div class="col-sm-7">
									<h4 class="mainTitle" id="dashboard">Exception Details</h4>
									
								</div>
							
							</div>
						</section> 
						<!-- end: DASHBOARD TITLE -->
						<!-- start: FEATURED BOX LINKS -->
						<div class="container-fluid container-fullw bg-white">
																			
										
										
                                       
                                        <div class="col-lg-9 col-sm-11">
											<div class="panel panel-transparent">
											
												<div class="panel-body"> 
												
											    <logic:equal name="exceptionDetailForm" property="message" value="Error">
													<div class="row">
													<div class="col-md-10" style="margin-bottom: 20px;">
													
														 <span class="fieldTextblink"><font color="RED">${getErrorMsg}</font></span>	 
													
													</div>
													</div>
												</logic:equal>
												
												<logic:equal name="exceptionDetailForm" property="message" value="Resp">
													<div class="row">
													<div class="col-md-10" style="margin-bottom: 20px;">
														 <span class="fieldTextblink"><font color="GREEN">${getRespMsg}</font></span> 
															
													</div>
													</div>
												</logic:equal>  
												
								
													
                                                   
                                                 <html:form action="/ExceptionDetails"  method="post">
                                                  <html:hidden property="actionName" />   
                                                  
                                                  
                                                <div class="col-md-10">
                                                                                       
                                                <div class="row">
                                                <div class="col-md-4"><label class="control-label" id="TagID">EPC/Tag ID:</label></div>
                                                <div class="col-md-8">
                                                <div class="form-group">
                                                <html:text styleClass="form-control" property="tagid" styleId="tagid" maxlength="32" onkeypress="checktagid()"/>
                                                </div>
                                                </div>
                                                </div>
                                               <div class="row">
                                                <div class="col-md-4"><label class="control-label" id="Tid">TID :</label></div>
                                                <div class="col-md-8">
                                                <div class="form-group">
                                                <html:text styleClass="form-control" property="tid" styleId="tid" maxlength="32" onkeypress="checktid()" />
                                                </div>
                                                </div>
                                                </div>                                                
												<div class="row">
                                                <div class="col-md-4"><label class="control-label" id="Vehicle_No">Vehicle No :</label></div>
                                                <div class="col-md-8">
                                                <div class="form-group">
                                                <html:text styleClass="form-control" property="vehicle_no" styleId="vehicle_no" maxlength="12" onkeypress="checkvechno()"/>
                                                </div>
                                                </div>
                                                </div>
                                                
                                                
                                                <div class="row"> 
                                                
                                               
                                             <div class="col-md-4"><label class="control-label" id="exce_type_label">Exception Type : <span class="symbol required"></span></label></div>
                                             <div class="col-md-8"> 
                                                <div class="form-group">
                                                
						                     <html:select property="exce_type" styleClass="form-control" styleId="exce_type" >
													<html:option value="">--Select Exception Type--</html:option>
													<html:option value="01">Blacklist</html:option>
													<html:option value="02">Exempted</html:option>
													<html:option value="03">Low Balance</html:option>
													<html:option value="04">Hotlist</html:option>
													<html:option value="05">Invaild Carriage</html:option>
											</html:select>
                                                </div>
                                                
                                                </div> 
                                                </div>
                                            
                                                
                                                
                 
                                    	
                                               <div class="col-md-8">
	                                               
													<button class="btn btn-primary btn-o pull-right" onclick="return searchDetails()" id="exce_search" style="margin-bottom: 30px; margin-right: -100px">
															Search
													</button>
													
													<button class="btn btn-primary btn-o pull-right" onclick="return addDetails()" id="exce_add" style="margin-bottom: 30px; margin-right: -200px">
															 Add  
													</button>
														
                                                </div>
                                                
                                                </div>
                                               
                                                <%-- <html:hidden property="actionName"/> --%>
                                                
                                                </html:form>
                                                <br /><br />
                                                
               <logic:present name="walletInfo">  
	  			
	  			
                 <table class="table table-bordered table-hover" id="example">                 
					<thead>	
					<tr>					
						<c:forEach items="${headerNames}" var="name">
							<th style="width: 45px;text-align: center;" align="center">${name}</th>
						</c:forEach>						
					</tr>			
					</thead>
				<tbody>
				    <c:forEach items="${walletInfo}" var="values" varStatus="count">				    
						<tr>
                            <c:forEach items="${values}" var="value">
						       <td style="width: 45px;text-align: center;">${value}</td>
						   	</c:forEach>                       
                        </tr>
					</c:forEach>
				</tbody>				
			 </table> 									
	 </logic:present>  		
														
												</div>
											</div>
										</div>
                                </div>
                            </div>
						 </div>
					</div> 
                   
				</div> 
			
			<!-- start: FOOTER -->
			
			<!-- end: FOOTER -->
			<!-- start: OFF-SIDEBAR -->
			
		
		 <script src="vendor/jquery/jquery.min.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="vendor/modernizr/modernizr.js"></script>
		<script src="vendor/jquery-cookie/jquery.cookie.js"></script>
		<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
		<script src="vendor/switchery/switchery.min.js"></script>
		
		<script src="vendor/Chart.js/Chart.min.js"></script>
		<script src="vendor/jquery.sparkline/jquery.sparkline.min.js"></script>
        <script src="vendor/sweetalert/sweet-alert.min.js"></script>
		<script src="vendor/toastr/toastr.min.js"></script>
		<script type="text/javascript" src="assets/js/paging.js"></script>
       
		<script src="assets/js/main.js"></script>
		
		<script src="assets/js/index.js"></script>
        <script src="assets/js/ui-notifications.js"></script> 
		<script>
		
	    jQuery(document).ready(function ()
	    {
	        Main.init();
	       // Index.init();
	        UINotifications.init();
	    });
	    
	    function pageLoad()
	    {
	    	// alert("Hello");
	    	document.getElementById("exce_type").value="";
	    	document.getElementById("tagid").value="";
	    	document.getElementById("tid").value="";
	    	document.getElementById("vehicle_no").value="";
	    	
	    }
	    
	    jQuery(function($) {
	    	  var input = $('#tagid');
	    	  input.on('keydown', function() {
	    	    var key = event.keyCode || event.charCode;
	    	    var TagId = $("#tagid").val();
	    	    if( key == 8 || key == 46 )
	    	       {
	    	    	// alert("Backspace");
	    	    	if(TagId.length<=1)
	    	    		{
	    	    		// alert("Backspace Length 1 TAGID");
	    	    		$("#tid").prop("readonly", false);
	    				$("#vehicle_no").prop("readonly", false);
	    	    		}
	    	       }
	    	  });
	    	});
	    
	    jQuery(function($) {
	    	  var input = $('#tid');
	    	  input.on('keydown', function() {
	    	    var key = event.keyCode || event.charCode;
	    	    var tid = $("#tid").val();
	    	    if( key == 8 || key == 46 )
	    	       {
	    	    	// alert("Backspace");
	    	    	if(tid.length<=1)
	    	    		{
	    	    		// alert("Backspace Length 1 tid");
	    	    		$("#tagid").prop("readonly", false);
	    				$("#vehicle_no").prop("readonly", false);
	    	    		}
	    	       }
	    	  });
	    	});
	    
	    jQuery(function($) {
	    	  var input = $('#vehicle_no');
	    	  input.on('keydown', function() {
	    	    var key = event.keyCode || event.charCode;
	    	    var VNO = $("#vehicle_no").val();
	    	    if( key == 8 || key == 46 )
	    	       {
	    	    	// alert("Backspace");
	    	    	if(VNO.length<=1)
	    	    		{
	    	    		// alert("Backspace Length 1 Vehicle NO  ");
	    	    		$("#tagid").prop("readonly", false);
	    				$("#tid").prop("readonly", false);
	    	    		}
	    	       }
	    	  });
	    	});
	    
	    
	    
	    
	    
	    function checkvechno()
		{						
			var VNO = $("#vehicle_no").val();
			 if(VNO.length>=0)
			{		
		 	document.getElementById("tagid").value="";
	    	document.getElementById("tid").value="";
	    	
	    	$("#tagid").prop("readonly", true);
			$("#tid").prop("readonly", true);
			
			}	
				 			  
		}
	    
	    
	    function checktagid()
		{					
			var TagId = $("#tagid").val();	 	
			if(TagId.length>=0)
			{		
				
			document.getElementById("tid").value="";
		    document.getElementById("vehicle_no").value="";
			$("#tid").prop("readonly", true);
			$("#vehicle_no").prop("readonly", true);
			
			}					 			  
		}
	    
	    function checktid()
		{					
			var transId = $("#tid").val();

			 if(transId.length>=0)
			{	
		 	document.getElementById("tagid").value="";
	    	document.getElementById("vehicle_no").value="";
			$("#tagid").prop("readonly", true);
			$("#vehicle_no").prop("readonly", true);
			}		 			  
		}
	    
	    
	    /* function check()
		{					
			var TagId = $("#tagid").val();
			var tid = $("#tid").val();
			var VNO = $("#vehicle_no").val();
		 	
			if(TagId.length>0)
			{		
			// alert("TagID length  "+TagId.length);
			$("#tid").prop("disabled", true);
			$("#vehicle_no").prop("disabled", true);
			}	
			
			else if(tid.length>0)
			{		
			// alert("tid length  "+tid.length);
			$("#tagid").prop("disabled", true);
			$("#vehicle_no").prop("disabled", true);
			}	
			
			else if(VNO.length>0)
			{		
			
			$("#tagid").prop("disabled", true);
			$("#tid").prop("disabled", true);
			}	
				 			  
		} */
		    
	    function searchDetails()
		{					
			var TagId = $("#tagid").val();
			var transId = $("#tid").val();
			var VNO = $("#vehicle_no").val();
			var exce_type = $("#exce_type").val();
			

			if (TagId != "" || transId != "" || VNO != "")
			{
				
				/* if(exce_type != "")
					{ */
					
					if(TagId.length>0)
					{	
						document.getElementById("tid").value="";
					    document.getElementById("vehicle_no").value="";
					}	
					
					else if(transId.length>0)
					{		
						document.getElementById("tagid").value="";
				    	document.getElementById("vehicle_no").value="";
					}	
					
					else if(VNO.length>0)
					{		
					
						document.getElementById("tagid").value="";
				    	document.getElementById("tid").value="";
					}	
					
					
					document.forms[1].actionName.value="SEARCH"; // UAT then submit froms[0]
					document.forms[1].submit(); 
					
			/* 		}
				else
					{
					alert("please select the exception.");
				 	return false;
					} */
			}
			
			
			 else
			{
				 alert("Values is empty ");
				 return false;
				
			}
		 	
			
		}
		
		function addDetails()
		{					
			var TagId = $("#tagid").val();
			var transId = $("#tid").val();
			var VNO = $("#vehicle_no").val();
			var exce_type = $("#exce_type").val();

			if (TagId != "" || transId != "" || VNO != "")
			{
				//alert("TagID "+TagId);
				//alert("TID "+transId);
				//alert("VNO "+VNO);
				
				if(exce_type != "")
					{
					
					if(TagId.length>0)
					{		
						//alert("TagID  length"+TagId);
						document.getElementById("tid").value="";
					    document.getElementById("vehicle_no").value="";
					}	
					
					else if(transId.length>0)
					{		
						//alert("TID Length "+transId);
						document.getElementById("tagid").value="";
				    	document.getElementById("vehicle_no").value="";
					}	
					else if(VNO.length>0)
					{		
						//alert("VNO Length "+VNO);
						document.getElementById("tagid").value="";
				    	document.getElementById("tid").value="";
					}	
					document.forms[1].actionName.value="ADD";  // UAT then submit froms[0]
					document.forms[1].submit(); 
					}
				else
					{
					alert("please select the exception.");
				 	return false;
					}
			}			
			 else
			{
				 alert("Values is empty ");
				 return false;
				
			}		  			  
		}

</script>
		
	</body>
</html>
