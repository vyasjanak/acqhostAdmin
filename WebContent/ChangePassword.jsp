<%@ include file="/include.jsp"%>
<!DOCTYPE html>
<!-- Template Name: Clip-Two - Responsive Admin Template build with Twitter Bootstrap 3.x | Author: ClipTheme -->
<!--[if IE 8]><html class="ie8" lang="en"><![endif]-->
<!--[if IE 9]><html class="ie9" lang="en"><![endif]-->
<!--[if !IE]><!-->
<html lang="en">
	<!--<![endif]-->
	<!-- start: HEAD -->
	<!-- start: HEAD -->
	<head>
		<title>1Pay : Change Password</title>
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
		<!-- end: CLIP-TWO CSS -->
		<!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
		<!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
	</head>
	<!-- end: HEAD -->
	<!-- start: BODY -->
	<body class="login" onload="pageLoad()">
		<!-- start: FORGOT -->
		<div class="row">
			<div class="main-login col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
				<div class="logo margin-top-30">
							<!--<img src="assets/images/logo.png" alt="Clip-Two"/>-->
				</div>
				<!-- start: FORGOT BOX -->
				<div class="box-forgot">
					<logic:equal name="changePasswordForm" property="message" value="PassFieldsNull"> 
						<div class="row">
							<div class="col-md-10" style="margin-bottom: 20px;">
								<span class="fieldTextblink"><font color="RED">Password field/s received in request are NULL.</font></span>	
							</div>
						</div>
					</logic:equal>
					<logic:equal name="changePasswordForm" property="message" value="SamePassword"> 
						<div class="row">
							<div class="col-md-10" style="margin-bottom: 20px;">
								<span class="fieldTextblink"><font color="RED">Old Password and New Password received in request are same.</font></span>	
							</div>
						</div>
					</logic:equal>
					<logic:equal name="changePasswordForm" property="message" value="PassMismatch"> 
						<div class="row">
							<div class="col-md-10" style="margin-bottom: 20px;">
								<span class="fieldTextblink"><font color="RED">New Password received in request doesn't match with Confirm Password received in request.</font></span>	
							</div>
						</div>
					</logic:equal>
					<logic:equal name="changePasswordForm" property="message" value="PassChangedSucc"> 
						<div class="row">
							<div class="col-md-10" style="margin-bottom: 20px;">
								<span class="fieldTextblink"><font color="RED">Password changed Successfully.</font></span>	
							</div>
						</div>
					</logic:equal>
					<logic:equal name="changePasswordForm" property="message" value="PassChangedFail"> 
						<div class="row">
							<div class="col-md-10" style="margin-bottom: 20px;">
								<span class="fieldTextblink"><font color="RED">DB Error Occurred while changing Password.</font></span>	
							</div>
						</div>
					</logic:equal>					
					
					<html:form styleClass="form-forgot" action="changePassword.do" method="post" >
						<fieldset>
							<legend>
								Change Password
							</legend>
							<p>
								Enter below to change your password.
							</p>
							<div class="form-group">
								<span class="input-icon">
									<input type="password" class="form-control" name="oldPassword" placeholder="Old Password" id="oldPassword">
                                    <i class="fa fa-lock"></i> </span>
							</div>
                            <div class="form-group">
                                <span class="input-icon">
                                    <input type="password" class="form-control" name="newPassword" placeholder="New Password" id="newPassword">
                                    <i class="fa fa-lock"></i>
                                </span>
                            </div>
                            <div class="form-group">
                                <span class="input-icon">
                                    <input type="password" class="form-control" name="confPassword" placeholder="Confirmed Password" id="confPassword">
                                    <i class="fa fa-lock"></i>
                                </span>
                            </div>
							<div class="form-actions">
								<a class="btn btn-primary btn-o" href="javascript:backToLogin()">
									<i class="fa fa-chevron-circle-left"></i> Log-In
								</a>
								<button type="button" class="btn btn-primary pull-right" onclick="pageSubmit()">
									Submit <i class="fa fa-arrow-circle-right"></i>
								</button>
							</div>
						</fieldset>
						<html:hidden property="actionName"/>
						<html:hidden property="oldPassword"/>
						<html:hidden property="newPassword"/>
					</html:form>
					<!-- start: COPYRIGHT -->
					<div class="copyright">
						&copy; <span class="current-year"></span><span class="text-bold text-uppercase"> </span><span>1Pay. All rights reserved</span>
					</div>
					<!-- end: COPYRIGHT -->
				</div>
				<!-- end: FORGOT BOX -->
			</div>
		</div>
		<!-- end: FORGOT -->
		<!-- start: MAIN JAVASCRIPTS -->
		<script src="vendor/jquery/jquery.min.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="vendor/modernizr/modernizr.js"></script>
		<script src="vendor/jquery-cookie/jquery.cookie.js"></script>
		<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
		<script src="vendor/switchery/switchery.min.js"></script>
		<!-- end: MAIN JAVASCRIPTS -->
		<!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
		<script src="vendor/jquery-validation/jquery.validate.min.js"></script>
		<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
		<!-- start: CLIP-TWO JAVASCRIPTS -->
		<script src="assets/js/main.js"></script>
		<!-- start: JavaScript Event Handlers for this page -->
		<script src="assets/js/login.js"></script>
		<script>
			jQuery(document).ready(function()
			{
				/*Main.init();
				Login.init();*/
			});
			
			function pageSubmit()
			{
			    var oldPassword = $("#oldPassword").val(); 
			    var newPassword = $("#newPassword").val();
			    var confPassword = $("#confPassword").val();
			    
			    if(oldPassword == "")
			    {
			    	alert("Please enter old Password.");
			    	document.getElementById("oldPassword").focus();
			    }
			    else if(newPassword == "")
			    {
			    	alert("Please enter New Password.");
			    	document.getElementById("newPassword").focus();
			    }
			    else if(confPassword == "")
			    {
			    	alert("Please confirm your New Password.");
			    	document.getElementById("confPassword").focus();
			    }
			    else if(newPassword.length<8)
				{  
					alert("Password must be at least 8 characters long."); 
					document.getElementById("newPassword").focus();
	  			}
			    else if (oldPassword == newPassword || oldPassword == confPassword)
				{
					alert("Old Password and New Password should not be same.");
					document.getElementById("newPassword").focus();
				}
			    else if (newPassword != confPassword)
				{
					alert("New Password and Confirm Password must be same.");
					document.getElementById("confPassword").focus();
				}
			    else
			    {
			    	$.ajax
			    	({				
						type: 'GET',
						url: "<%=request.getContextPath()%>/ajaxAction.do?type=changePassword&oldPassword="+oldPassword,
						success: function(data)
						{
							if (data == "C")
							{								
								if (newPassword == confPassword)
								{
									document.forms[0].oldPassword.value=oldPassword;
									document.forms[0].newPassword.value=newPassword;
									document.forms[0].actionName.value="save";
							    	document.forms[0].submit();
								}
								else
								{
									alert("New Password and Confirm password are mismatch.");
								}
							} 
							else
							{
								alert("Please enter correct old password.");
							}
						},
						error: function (err)
						{
							console.log("Error occurred while changing Password.");
					    }
					});
			    }			    				
			}
			
			function backToLogin() {
				document.forms[0].actionName.value="login";
				document.forms[0].submit();
			}
			
			function pageLoad(){
				<%
					
					/*session.removeAttribute("username");
		            session.invalidate();*/
				%>
			}
		</script>
		<!-- end: JavaScript Event Handlers for this page -->
		<!-- end: CLIP-TWO JAVASCRIPTS -->
	</body>
	<!-- end: BODY -->
</html>