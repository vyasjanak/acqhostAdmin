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
		<title>1Pay - Config User</title>
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
		<link rel="stylesheet" href="css/style.min.css"/>
		<!-- end: CLIP-TWO CSS -->
		<!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
        <link href="vendor/sweetalert/sweet-alert.css" rel="stylesheet" media="screen">
		<link href="vendor/sweetalert/ie9.css" rel="stylesheet" media="screen">
		<link href="vendor/toastr/toastr.min.css" rel="stylesheet" media="screen">
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
           /*  .app-navbar-fixed
             {
              padding-top:50px !important;
                 }*/
                 
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
		<!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
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
									<h4 class="mainTitle" id="dashboard">Create User</h4>
									
								</div>
							
							</div>
						</section>
						<!-- end: DASHBOARD TITLE -->
						<!-- start: FEATURED BOX LINKS -->
						<div class="container-fluid container-fullw bg-white">
										<logic:equal name="configUserForm" property="message" value="CS"> 
											<div class="row">
												<div class="col-md-10" style="margin-bottom: 20px;">
													<span class="fieldTextblink"><font color="GREEN">User Created Successfully.</font></span>	
												</div>
											</div>
										</logic:equal>										
										<logic:equal name="configUserForm" property="message" value="CF"> 
											<div class="row">
												<div class="col-md-10" style="margin-bottom: 20px;">
													<span class="fieldTextblink"><font color="RED">User Creation Failed.</font></span>	
												</div>
											</div>
										</logic:equal>
										<logic:equal name="configUserForm" property="message" value="US"> 
											<div class="row">
												<div class="col-md-10" style="margin-bottom: 20px;">
													<span class="fieldTextblink"><font color="Green">User Updated Successfully.</font></span>	
												</div>
											</div>
										</logic:equal>
										<logic:equal name="configUserForm" property="message" value="UF"> 
											<div class="row">
												<div class="col-md-10" style="margin-bottom: 20px;">
													<span class="fieldTextblink"><font color="RED">User Updation Failed.</font></span>	
												</div>
											</div>
										</logic:equal>
										<logic:equal name="configUserForm" property="message" value="DS"> 
											<div class="row">
												<div class="col-md-10" style="margin-bottom: 20px;">
													<span class="fieldTextblink"><font color="Green">User Deleted Successfully.</font></span>	
												</div>
											</div>
										</logic:equal>
										<logic:equal name="configUserForm" property="message" value="DF"> 
											<div class="row">
												<div class="col-md-10" style="margin-bottom: 20px;">
													<span class="fieldTextblink"><font color="RED">User Deletion Failed</font></span>	
												</div>
											</div>
										</logic:equal>
										<logic:equal name="configUserForm" property="message" value="ME"> 
											<div class="row">
												<div class="col-md-10" style="margin-bottom: 20px;">
													<span class="fieldTextblink"><font color="RED">User Created Successfully but Error occurred in Mail Sending.</font></span>	
												</div>
											</div>
										</logic:equal>
										<logic:equal name="configUserForm" property="message" value="EE"> 
											<div class="row">
												<div class="col-md-10" style="margin-bottom: 20px;">
													<span class="fieldTextblink"><font color="RED">Ooopss!!!Something went Wrong.</font></span>	
												</div>
											</div>
										</logic:equal>
                                        <!--Add New Button with grid start-->
                                        <div class="col-lg-9 col-sm-11">
											<div class="panel panel-transparent">
												<!-- <div class="panel-heading"> -->
													<!-- <div class="panel-title pull-left"> -->
														<!-- <!--Add More--> 
                                                       <!-- <!-- <button class="btn btn-primary btn-o pull-right" data-toggle="modal" data-target="#myModal"> -->
														<!-- Add New -->
													<!-- </button>--> 
													<!-- </div> -->
												<!-- </div> -->
												<div class="panel-body">
													<!--<p class="margin-bottom-30">
														Add Recon Configuration
													</p>-->
													<!--<button class="btn btn-primary btn-o pull-right" data-toggle="modal" data-target="#myModal">
														Add More
													</button>-->
                                                    <html:form styleClass="form-horizontal" action="configUser" method="post">
                                                    <div class="row">
                                                <div class="col-md-10">
                                                <%-- <div class="row">
                                                <div class="col-md-4"><label class="control-label" id="sol_id">SOL/Branch ID:</label></div>
                                                <div class="col-md-8">
                                                <div class="form-group">
                                                <html:text styleClass="form-control" property="sol_id" styleId="config_sol_id" maxlength="10"/>
                                                </div>
                                                </div>
                                                </div>     --%>                                            
                                                <div class="row">
                                                <div class="col-md-4"><label class="control-label" id="UserId">User ID:</label></div>
                                                <div class="col-md-8">
                                                <div class="form-group">
                                                <html:text styleClass="form-control" property="userId" styleId="configUserId" maxlength="20" onkeypress="return IsAlphaNumeric1(event);"/>
                                                </div>
                                                </div>
                                                </div>
                                                <div class="row">
                                                <div class="col-md-4"><label class="control-label" id="UserName">User Name:</label></div>
                                                <div class="col-md-8">
                                                <div class="form-group">
                                                <html:text styleClass="form-control" property="userName" styleId="configUserName" maxlength="50" onkeypress="return IsAlphaNumeric(event);"/>
                                                </div>
                                                </div>
                                                </div>                                                
												<div class="row">
                                                <div class="col-md-4"><label class="control-label" id="Email">Email Id:</label></div>
                                                <div class="col-md-8">
                                                <div class="form-group">
                                                <html:text styleClass="form-control" property="email" styleId="configEmail" maxlength="50"/>
                                                </div>
                                                </div>
                                                </div>
												<div class="row">
                                                <div class="col-md-4"><label class="control-label" id="ContactNo">Contact No:</label></div>
                                                <div class="col-md-8">
                                                <div class="form-group">
                                                <html:text styleClass="form-control" property="contactNo" styleId="configContact" onkeypress="return isNumberKey(event);" maxlength="10" />
                                                </div>
                                                </div>
                                                </div>
                                                 <div class="row">
                                                <div class="col-md-4"><label class="control-label" id="Role">Role:</label></div>
                                                <div class="col-md-8">
                                                <div class="form-group">
                                                <html:select styleClass="form-control" property="role" styleId="roleId" >
                                                    <html:option value="">Select Role</html:option>
													<logic:present name="roles">
														<html:options collection="roles" labelProperty="rolename"
															property="roleid" />
													</logic:present>
                                                </html:select>
                                                </div>
                                                </div>
                                                </div>
                                                  <div class="row">
                                                <div class="col-md-4"><label class="control-label" id= "Password">Password:</label></div>
                                                <div class="col-md-8">
                                                <div class="form-group">
                                                <html:password styleClass="form-control" property="password" styleId="configPassword" maxlength="20" />
                                                </div>
                                                </div>
                                                </div>
                                               <div class="col-md-8">
	                                                <button class="btn btn-primary btn-o pull-right" onclick="return saveUser()" id="addUser">
															Add New
													</button>
													<!-- <button class="btn btn-primary btn-o pull-right" onclick="return searchConfigUser()" id="userSearch" style="margin-bottom: 30px; margin-right: 30px">
															Search
													</button> -->
													<button class="btn btn-primary btn-o pull-right" onclick="return updateConfigUser()" id="updateUser" style="display:none;">
															Update
													</button>	
                                                </div>
                                                
                                                </div>
                                                </div>
                                                <html:hidden property="actionName"/>
                                                <html:hidden property="selectedGroup"/>
                                                <html:hidden property="selectedRole"/>
                                                </html:form>
                                                <br /><br />
                                                <logic:present name="userData"> 
                                                     <table class="table table-bordered table-hover" id="Table4">
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
										    <c:forEach items="${userData}" var="values" varStatus="count">
												<tr>
	                                                <c:forEach items="${values}" var="value">
											    	   <td>${value}</td>
											        </c:forEach>
													<td><a href="javascript:editUser('${values[0]}')"><i class="ti-pencil"></i></a></td>
	                                                <td><a href="javascript:deleteUser('${values[0]}')"><i class="ti-trash"></i></a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<div id="pageNavPosition"></div>
									</logic:present>									
												</div>
											</div>
										</div>

                                 <div class="row">
                                  <!-- <div class="col-lg-4 col-sm-6"> -->
											<!-- <div class="panel panel-transparent"> -->
												<!-- <div class="panel-heading"> -->
													<!-- <div class="panel-title pull-left"> -->
														<!-- <!--Show All Records--> 
                                                        
													<!-- </div> -->
												<!-- </div> -->
												<!-- <div class="panel-body"> -->
                                             
												<!-- </div> -->
											<!-- </div> -->
										<!-- </div> -->
                                 </div>
                                           <!--Add New Button with grid end-->
								
                                           
                                           
                                	</div>
                            </div>
						</div>
						<!-- end: FEATURED BOX LINKS -->
						<!-- start: FIRST SECTION -->
						
						<!-- end: FIRST SECTION -->
						<!-- start: SECOND SECTION -->
						
						<!-- end: SECOND SECTION -->
						<!-- start: THIRD SECTION -->
						
						<!-- end: THIRD SECTION -->
						<!-- start: FOURTH SECTION -->
						
						<!-- end: FOURTH SECTION -->
					</div>
                    <footer>
				<div class="footer-inner">
					<div class="pull-left">
						&copy; <span class="current-year"></span>. <span>All rights reserved</span>
					</div>
					<div class="pull-right">
						<span class="go-top"><i class="ti-angle-up"></i></span>
					</div>
				</div>
			</footer>
				</div>
			
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
		<script type="text/javascript" src="assets/js/paging.js"></script>
        <!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
		<!-- start: CLIP-TWO JAVASCRIPTS -->
		<script src="assets/js/main.js"></script>
		<!-- start: JavaScript Event Handlers for this page -->
		<!--<script src="assets/js/index.js"></script>-->
        <script src="assets/js/ui-notifications.js"></script>
		<script>
		
	    jQuery(document).ready(function ()
	    {
	        Main.init();
	       // Index.init();
	        UINotifications.init();
	    });
		    
		function saveUser()
		{
			// alert("Save User");
			var UserId = $("#configUserId").val();
			var UserName= $ ("#configUserName").val();
			
			var Email= $ ("#configEmail").val();
			var ContactNo= $ ("#configContact").val();
			
			var Role= $ ("#roleId").val();
			var Password= $ ("#configPassword").val();
					
			if (UserId == "")
			{
			    	alert("Please enter User id");
					document.getElementById("configUserId").focus();
			    	return false;
			}
			 
			else if (UserName== "")
			{
	            alert("Enter UserName");
				document.getElementById("configUserName").focus();
	            
	            return false;
        	}
		
			else if(UserName!="")
			{				
			   var iChars = "!@#$%^&*()+=-[]\\\';,./{}|\":<>?~_"; 
			   for (var i = 0; i < UserName.length; i++)
			   {
				  	if (iChars.indexOf(UserName.charAt(i)) != -1)
				  	{
					  	alert (" special characters are not allowed");
					  	return false;
			  		}
			  	}
			}
			
			
			
 			if (Email=="")
 			{
	            alert("Enter Email ID");
	            document.getElementById("configEmail").focus(); 
	            return false;
        	}
			else if(Email!="")
			{
				var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
	        	if (!emailReg.test(Email))
	        	{
		            alert('invalid Email ID');
					return false;			
	        	} 		
			}	
		
		 	if (ContactNo== "")
		 	{
				 alert("Enter Contact no");
				 document.getElementById("configContact").focus(); 
	             return false;
			}
			else if(ContactNo!="")
			{	
				var numbers = /^[0-9]+$/;  
				if (!numbers.test(ContactNo)) 
				{
					alert("Plese enter valid Contact Number ");
					document.getElementById("configContact").focus(); 
					//document.getElementById("configContact").value = "";
					return false;
				}
			}
			
		 	if(ContactNo!="")
			{	
				var numbers = 10;  
				if (numbers>(ContactNo.length)) 
				{
					alert("Contact Number should be 10 digit");
					//document.getElementById("configContact").value = "";
					return false;
				}
			}
		 		
		 	if (Role == "" )
		 	{
	            alert("Select Role");
				document.getElementById("roleId").focus(); 
	            
	            return false;
        	}
			else if (Password== "")
			{
	            alert("Enter Password");
				document.getElementById("configPassword").focus(); 
	            
	            return false;
        	}
			else if(Password.length<8)
			{  
				alert("Password must be at least 8 characters long."); 
				document.getElementById("configPassword").focus();
				return false;  
  			}  
			else
			{
				// alert("Submit Form");
				document.forms[1].actionName.value="add";
				document.forms[1].submit();
				return true;
			}
		
		}
		
		function IsAlphaNumeric(e)
		{			 
			var regex = new RegExp("^[0-9a-zA-Z @\b]+$");
			var key = String.fromCharCode(!event.charCode ? event.which: event.charCode);
			if (!regex.test(key)) 
			{
			    event.preventDefault();
			    return false;
			} 
		}
		
		function IsAlphaNumeric1(e)
		{
			var regex = new RegExp("^[0-9a-zA-Z@\b]+$");
			var key = String.fromCharCode(!event.charCode ? event.which: event.charCode);
			if (!regex.test(key)) 
			{
			    event.preventDefault();
			    return false;
			} 	
		}	      
		
		function isNumberKey(e)
		{       
	        var charCode = (e.which) ? e.which : event.keyCode
	        if (charCode > 31 && (charCode < 48 || charCode > 57))
			{
		        alert("Only Numbers Allowed");
				return false;
	        
			}
			return true;
	    }
		
		
		function editUser(userId)
		{
			$("#addUser").hide();
		    $("#userSearch").hide();
			$("#updateUser").show();
			$("#configUserId").prop("disabled", false);
		    document.forms[1].userId.value=userId;
			document.forms[1].actionName.value="edit";
			document.forms[1].submit();
		}
		
		function deleteUser(userId)
		{
			if(confirm('Are you sure want to delete.'))
		    {
			    document.forms[1].userId.value=userId;
				document.forms[1].actionName.value="delete";
				document.forms[1].submit();
		    }
		}
		
		function updateConfigUser()
		{					
			var UserId = $("#configUserId").val();
			var UserName= $ ("#configUserName").val();
			var SolId= $ ("#config_sol_id").val();
			var Email= $ ("#configEmail").val();
			var ContactNo= $ ("#configContact").val();
			var group= $ ("#groupId").val();
			var Role= $ ("#roleId").val();
			var Password= $ ("#configPassword").val();
		
			
			if (UserId == "")
			{
			    	alert("Please enter User id");
					document.getElementById("configUserId").focus();
			    	return false;
			}
			 
			else if (UserName== "")
			{
	            alert("Enter UserName");
				document.getElementById("configUserName").focus();
	            
	            return false;
        	}
		
			else if(UserName!="")
			{				
			   var iChars = "!@#$%^&*()+=-[]\\\';,./{}|\":<>?~_"; 
			   for (var i = 0; i < UserName.length; i++)
			   {
				  	if (iChars.indexOf(UserName.charAt(i)) != -1)
				  	{
					  	alert (" special characters are not allowed");
					  	return false;
			  		}
			  	}
			}
			
			
	
			
 			if (Email=="")
 			{
	            alert("Enter Email ID");
	            document.getElementById("configEmail").focus(); 
	            return false;
        	}
			else if(Email!="")
			{
				var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
	        	if (!emailReg.test(Email))
	        	{
		            alert('invalid Email ID');
					return false;			
	        	} 		
			}	
		
		 	if (ContactNo== "")
		 	{
				 alert("Enter Contact no");
				 document.getElementById("configContact").focus(); 
	             return false;
			}
			else if(ContactNo!="")
			{	
				var numbers = /^[0-9]+$/;  
				if (!numbers.test(ContactNo)) 
				{
					alert("Plese enter valid Contact Number ");
					document.getElementById("configContact").focus(); 
					return false;
				}
			}
			
		 	if(ContactNo!="")
			{	
				var numbers = 10;  
				if (numbers>(ContactNo.length)) 
				{
					alert("Contact Number should be 10 digit");
					//document.getElementById("configContact").value = "";
					return false;
				}
			}
		 		
		 	if (Role == "" )
		 	{
	            alert("Select Role");
				document.getElementById("roleId").focus(); 
	            
	            return false;
        	}
			else if (Password== "")
			{
	            alert("Enter Password");
				document.getElementById("configPassword").focus(); 
	            
	            return false;
        	}
			else if(Password.length<8)
			{  
				alert("Password must be at least 8 characters long."); 
				document.getElementById("configPassword").focus();
				return false;  
  			}
			else
			{
				$("#configUserId").prop("disabled", false);
				$("#config_sol_id").prop("disabled", false);
				document.forms[1].actionName.value="update";
				document.forms[1].submit();
			}		 			  
		}
		
		function pageLoad()
		{
			if (document.forms[1].actionName.value == "edit")
			{
				$("#addUser").hide();
				$("#userSearch").hide();
		    	$("#updateUser").show();
		    	$("#configUserId").prop("disabled", true);
		    	$("#config_sol_id").prop("disabled", true);
		    	$("#groupId option[value='" + document.forms[1].selectedGroup.value + "']").attr("selected", 1);
		    	$("#roleId option[value='" + document.forms[1].selectedRole.value + "']").attr("selected", 1);
		    }
			else 
			{
				resetForm();
			}
		}
		
		function resetForm()
		{
			document.forms[1].userId.value = "";
			document.forms[1].userName.value = "";
			document.forms[1].email.value = "";
			document.forms[1].contactNo.value = "";
			//document.forms[1].sol_id.value = "";
			document.forms[1].role.value = "";
			document.forms[1].password.value = "";
		}
		</script>
		<script type="text/javascript">
        var pager = new Pager('Table4', 10); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    </script>
    <script>

	function searchConfigUser()
	 {
		
	    var UserId =$("#configUserId").val();
	    var UserName =$("#configUserName").val();
	    var EmailId=$("#configEmail").val();
	    
	    if(Email != "")
		{
			var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
        	if (!emailReg.test(EmailId))
        	{
	            alert('Invalid Email ID');
	            document.getElementById("configEmail").focus();	
	            return false;
        	} 		
		}
		
	    $("#updateUser").hide();
	    $("#addUser").show();			
	    $("#userSearch").show();
	    //document.forms[1].userId.value = UserId;
		document.forms[1].actionName.value="search";
		return true;
			          
  	}
	
	

</script>
		<!-- end: JavaScript Event Handlers for this page -->
		<!-- end: CLIP-TWO JAVASCRIPTS -->
	</body>
</html>
