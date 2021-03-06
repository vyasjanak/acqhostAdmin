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
		<title>1Pay :Concessioner</title>
		<!-- start: META -->
		<!--[if IE]><meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1" /><![endif]-->
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
<style type="text/css">
    /**
    * Override feedback icon position
    * See http://formvalidation.io/examples/adjusting-feedback-icon-position/
    */
    
</style>
<script>
    
</script>
 <style type="text/css">    
            .pg-normal {
                color: black;
                font-weight: normal;
                text-decoration: none;    
                cursor: pointer;    
            }
            .pg-selected {
                color: black;
                font-weight: bold;        
                text-decoration: underline;
                cursor: pointer;
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
			 .input-group-addon{
				background-color: #4981af !important;
				border: 1px solid #4981af !important;
				color: #ffffff !important;
			 }
           /*  .app-navbar-fixed
             {
              padding-top:50px !important;
                 }*/
                 
        </style>
		<!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
	</head>
	<!-- end: HEAD -->
	<body onload="loadPage()">
	
		<div id="app">
		
			<!-- sidebar -->
			<div class="sidebar app-aside" id="sidebar"  >
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
						<a class="navbar-brand" href="index.html">
							<!--<img src="assets/images/logo.png" alt="Clip-Two"/>-->
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
					
					<!-- end: NAVBAR COLLAPSE -->
				</header>
				<!-- end: TOP NAVBAR -->
				<div class="main-content" >
					<div class="wrap-content container" id="container">
						<!-- start: DASHBOARD TITLE -->
						<section id="page-title" style=" padding:0px 0px;">
							<div class="row">
								<div class="col-sm-7">
									<h4 class="mainTitle" id="dashboard">Concessioner</h4>
									
								</div>
							
							</div>
						</section>
						<!-- end: DASHBOARD TITLE -->
						<!-- start: FEATURED BOX LINKS -->
						<div class="container-fluid container-fullw bg-white">
								<logic:equal name="merchantMasterForm" property="message" value="DS"> 
									<div class="row">
										<div class="col-md-10" style="margin-bottom: 20px;">
											<span class="fieldTextblink"><font color="Green"><b>Concessioner Data deleted Successfully</b></font></span>	
										</div>
									</div>
								</logic:equal>
								<logic:equal name="merchantMasterForm" property="message" value="DF"> 
									<div class="row">
										<div class="col-md-10" style="margin-bottom: 20px;">
											<span class="fieldTextblink"><font color="RED">Concessioner date  is not deleted</font></span>	
										</div>
									</div>
								</logic:equal>
								<logic:equal name="merchantMasterForm" property="message" value="CS"> 
								<div class="row">
									<div class="col-md-10" style="margin-bottom: 20px;">
										<span class="fieldTextblink"><font color="Green"><b>Concessioner Created Successfully</b></font></span>	
									</div>
								</div>
							</logic:equal>
							<logic:equal name="merchantMasterForm" property="message" value="CF"> 
								<div class="row">
									<div class="col-md-10" style="margin-bottom: 20px;">
										<span class="fieldTextblink"><font color="RED">Concessioner creation failed. </font></span>	
									</div>
								</div>
							</logic:equal>
									<logic:equal name="merchantMasterForm" property="message" value="EM">
									<div class="row">
											<div class="col-md-10" style="margin-bottom: 20px;">
										<span class="fieldTextblink"><font color="RED">	Concessioner Created but Error occurred while sending Email.</font></span> 
											</div>
									</div>
									</logic:equal>
							</font>	
							<logic:equal name="merchantMasterForm" property="message" value="US"> 
								<div class="row">
									<div class="col-md-10" style="margin-bottom: 20px;">
										<span class="fieldTextblink"><font color="Green"><b>Concessioner Updated Successfully</b></font></span>	
									</div>
								</div>
							</logic:equal>
							<logic:equal name="merchantMasterForm" property="message" value="UF"> 
								<div class="row">
									<div class="col-md-10" style="margin-bottom: 20px;">
										<span class="fieldTextblink"><font color="RED">Concessioner date is not updated</font></span>	
									</div>
								</div>
							</logic:equal>
							<logic:equal name="merchantMasterForm" property="message" value="FileNotFound"> 
								<div class="row">
									<div class="col-md-10" style="margin-bottom: 20px;">
										<span class="fieldTextblink"><font color="RED">File does not exist</font></span>	
									</div>
								</div>
							</logic:equal>
							
							<%-- <logic:equal name="merchantMasterForm" property="message" value="NoData"> 
												<div class="row">
													<div class="col-md-10" style="margin-bottom: 20px;">
														<span class="fieldTextblink"><font color="RED">No Data Found.Please search again with different search parameters.</font></span>	
													</div>
												</div>
								</logic:equal> --%>
								
								<html:form  styleClass="form-horizontal" action="merchantMaster" method="post">
                                        <div class="row">
                                           <div class="col-md-10">
                                                <div class="row">
                                                
                                                <div class="col-md-4">
                                                <div class="form-group"><label class="control-label">Concessioner Id:</label></div></div>
                                                 <div class="col-md-8">
			                                                <div class="form-group">
			                                                <input type="text" class="form-control" name="merchantId" placeholder="Concessioner ID" styleId="merchantId" id="merchantId"/>
			                                                <%-- <html:select property="merchantId" styleClass="form-control" styleId="merchantId">
																<html:option value="">--Select Merchant--</html:option>
																<logic:present name="merchants">
																	<html:options collection="merchants" labelProperty="name"
																		property="code" />
																</logic:present>
															</html:select> --%>
			                                                </div>
			                                                </div>
			                               </div>
			                               <div class="row">
			                                                <div class="col-md-4">
			                                                <div class="form-group">
															<label class="control-label">Concessioner Name:</label></div></div>
			                                                <div class="col-md-8">
			                                                <div class="form-group">
			                                                <input type="text" class="form-control" name="merchantName" placeholder="Concessioner Name" id="merchantName"/>
			                                                </div>
			                                                </div>
			                              </div>
			                              
                       
                        </div> 
					</div>							
                                        <!--Add New Button with grid start-->
                                       <div class="row">
									  
									   <div class="col-lg-8 col-sm-11">
											<div class="panel panel-transparent">
												<div class="panel-heading">
													<div class="panel-title">
														<!--Add More-->
                                                        <button class="btn btn-primary btn-o pull-right" onclick="addNew()">
														Add New
													</button>
													</div>
													
													<div class="panel-title">
														<!--Add More-->
                                                        <button type="button" class="btn btn-primary btn-o pull-right" style="margin-right:10px"  OnClick ="return searchMerchant();">
														Search
													</button>
													</div>
												</div>
												<html:hidden property="actionName"/>
												 <html:hidden property="id"/>
												
												<html:hidden property="searchMid"/>
												<html:hidden property="searchMname"/> 
												</html:form>
												<div class="panel-body">
													<!--<p class="margin-bottom-30">
														Add Recon Configuration
													</p>-->
													<!--<button class="btn btn-primary btn-o pull-right" data-toggle="modal" data-target="#myModal">
														Add More
													</button>-->

                                        <logic:present name="merchantData">             
                                            
											<table class="table table-bordered table-responsive table-hover" style="" id="Table4">
										<thead>
											<tr>
												<c:forEach items="${headerNames}" var="name">
													<th>${name}</th>
												</c:forEach>
												<th>Edit</th>
												<th>Delete</th>
                                      	</tr>
										</thead>
										<tbody>
										    <c:forEach items="${merchantData}" var="values">
											<tr>
												    <c:forEach items="${values}" var="value">
												    	<td>${value}</td>
												    </c:forEach>
												    <td><a href="javascript:editMerchant('${values.get(0)}')"><i class="ti-pencil"></i></a></td>
												    <td><a href="javascript:deleteMerchant('${values.get(0)}')"><i class="ti-trash"></i></a></td>
	                                       </tr>
											</c:forEach>
										</tbody>
									</table>
									
									<div id="pageNavPosition"></div>
									</logic:present>
												</div>
											</div>
										
										</div>
										</div>

                                 <div class="row">
                                  <div class="col-lg-4 col-sm-6">
											<div class="panel panel-transparent">
												<div class="panel-heading">
													<div class="panel-title pull-left">
														<!--Show All Records-->
                                                        
													</div>
												</div>
												<div class="panel-body">
                                               
												</div>
											</div>
										</div>
                                 </div>
                                           <!--Add New Button with grid end-->
								
                                           
                                           
                                	</div>
                            </div>
						</div>
						
					</div>
					</div>
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
				
			
			<!-- start: FOOTER -->
			
			<!-- end: FOOTER -->
			<!-- start: OFF-SIDEBAR -->
			
		<!-- start: MAIN JAVASCRIPTS -->
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
		<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
		<script type="text/javascript" src="assets/js/paging.js"></script>
        <script type="text/javascript">
            function ShowHideDiv(chk_id, txt_id) {
                var dvtxt = txt_id;
                dvtxt.style.display = chk_id.checked ? "block" : "none";
            }
           // select all checkboxes
            function toggle(source) {
                var checkboxes = document.querySelectorAll('input[type="checkbox"]');
                var txtboxes = document.querySelectorAll('input[type="text"]');
                for (var i = 0; i < checkboxes.length; i++) {
                    if (checkboxes[i] != source) {
                        checkboxes[i].checked = source.checked;
                    }
                }
            }
			
			
        </script>


		<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
		<!-- start: CLIP-TWO JAVASCRIPTS -->
		<script src="assets/js/main.js"></script>
		<!-- start: JavaScript Event Handlers for this page -->
		<!--<script src="assets/js/index.js"></script>-->
        <script src="assets/js/ui-notifications.js"></script>
		<script>
		    jQuery(document).ready(function () {
		        Main.init();
		       // Index.init();
		        UINotifications.init();
		        //$(".mainTitle").text($("#dashboard").text());
		    });
			
			
			// function searchMerchant() {
				// document.forms[1].fromDate.value=$('#fdate').val();
				// document.forms[1].toDate.value=$('#tdate').val();
				// document.forms[1].submit();
				
				// var fromDate = $("#fdate").val();
				// var toDate = $("#tdate").val();
			// debugger
			// if(fromDate!=""||toDate!="")
			// {
			// if(Date.parse(fromDate) <= Date.parse(toDate)) 
			// {}
			// else { alert("Please Enter the correct date. From date must be less than To date. "); 
			// return false; 
			// }
			// }
			// }
			
			
			
		 function searchMerchant()
		 {
		    
		     document.forms[1].actionName.value="search";
			 document.forms[1].submit();
			var searchMid = $("#merchantId").val();
			var searchMname = $("#merchantName").val();
			 debugger
			 
	
				    	document.forms[1].searchMid.value = $("#merchantId").val();
				    	document.forms[1].searchMname.value=$('#merchantName').val();
						document.forms[1].actionName.value="search";
						document.forms[1].submit();
						return true;
					}
				
					
				/* else
				{
				document.forms[1].fromDate.value = $("#fdate").val();
		    	document.forms[1].toDate.value = $("#tdate").val();
		    	document.forms[1].searchMid.value = $("#merchantId").val();
		    	document.forms[1].searchMname.value=$('#merchantName').val();
				document.forms[1].actionName.value="search";
				document.forms[1].submit();
				return true;
				}	 	          
       */

		 
		
		 function editMerchant(id) {
    	   	// alert("ID "+id);
		    document.forms[1].id.value=id;
			document.forms[1].actionName.value="edit";
			document.forms[1].submit();
		}
		
		function deleteMerchant(id) {
		    if (confirm("Are you sure to delete?")){
				// alert("ID "+id);
			    document.forms[1].id.value=id;
				document.forms[1].actionName.value="delete";
				document.forms[1].submit();
			}
		}
		
		function addNew() {
			document.forms[1].actionName.value="addNew";
			document.forms[1].submit();
		}
		function loadPage() {
			$('#fdate').val(document.forms[1].fromDate.value);
			$('#tdate').val(document.forms[1].toDate.value);
		}
		</script>
		<script type="text/javascript">
		function Date1(e) 
		{
			 debugger
			 
				var regex = new RegExp("^[0-9 -/]+$");
				var key = String.fromCharCode(!event.charCode ? event.which: event.charCode);
				if (!regex.test(key)) 
					{
						event.preventDefault();
						return false;
					} 
		
        }
		
		
		
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
		<script type="text/javascript"><!--
        var pager = new Pager('Table4', 10); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    //--></script>
		<!-- end: JavaScript Event Handlers for this page -->
		<!-- end: CLIP-TWO JAVASCRIPTS -->
		
	</body>
</html>
