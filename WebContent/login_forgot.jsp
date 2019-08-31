<%@taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<title>1Pay : Forgot Password</title>
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
		   <style type="text/css">
           #loading {
			   background-color: #000;
			   width: 100%;
			   height: 100%;
			   position: fixed;
			   z-index: 999;
			   opacity:0.6;
			   text-align:center;
			}
        </style>
	</head>
	<!-- end: HEAD -->
	<!-- start: BODY -->
	<body class="login">
		<div id="loading" style="display: none;">
	        <img src="assets/images/loading.gif" alt="Loading..." style="margin-top:12%" />
	   </div>
		<!-- start: FORGOT -->
		<div class="row">
			<div class="main-login col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
				<div class="logo margin-top-30">
							<!--<img src="assets/images/logo.png" alt="Clip-Two"/>-->
				</div>
				<!-- start: FORGOT BOX -->
				<div class="box-forgot">
					<logic:equal name="loginPageForm" property="message" value="SES">
						<div class="row">
							<div class="col-md-10" style="margin-bottom: 20px;">
								<span class="fieldTextblink"><font color="RED">Password is sent in your registered mobile number</font></span>	
							</div>
						</div>
					</logic:equal>
					<logic:equal name="loginPageForm" property="message" value="SEF">
						<div class="row">
							<div class="col-md-10" style="margin-bottom: 20px;">
								<span class="fieldTextblink"><font color="RED">Somthing went wrong..!!! Try again after some time</font></span>	
							</div>
						</div>
					</logic:equal>
					<logic:equal name="loginPageForm" property="message" value="IMN">
						<div class="row">
							<div class="col-md-10" style="margin-bottom: 20px;">
								<span class="fieldTextblink"><font color="RED">Sms could not be sent.Contact administrator</font></span>	
							</div>
						</div>
					</logic:equal>
					<logic:equal name="loginPageForm" property="message" value="MNA">
						<div class="row">
							<div class="col-md-10" style="margin-bottom: 20px;">
								<span class="fieldTextblink"><font color="RED">Mobile No is not registered </font></span>	
							</div>
						</div>
					</logic:equal>
					<logic:equal name="loginPageForm" property="message" value="Blank">
						<div class="row">
							<div class="col-md-10" style="margin-bottom: 20px;">
								<span class="fieldTextblink"><font color="RED">Enter Your Mobile Number	</font></span>	
							</div>
						</div>
					</logic:equal>
					
				    <html:form  styleClass="form-forgot" action="forgotPassword.do" method="post">
						<fieldset>
							<legend>
								Forget Password?
							</legend>
							<p>
								Enter your Mobile Number below to reset your password.
							</p>
							<div class="form-group">
								<span class="input-icon">
									<input type="text" class="form-control" name="email" placeholder="Mobile No" id="emailId" pattern="[0-9]" maxlength="10" required />
									<i class="fa fa-mobile" style="font-size: 1.7em;"></i> 
								</span>
							</div>
							<div class="form-actions">
								<a class="btn btn-primary btn-o" href="javascript:backToLogin()">
									<i class="fa fa-chevron-circle-left"></i> Log-In
								</a>
								<button type="submit" class="btn btn-primary pull-right" onclick="sendForgotPassword()">
									Submit <i class="fa fa-arrow-circle-right"></i>
								</button>
							</div>
						</fieldset>
						<html:hidden property="actionName" />
						<html:hidden property="emailForgotPass" />
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
			jQuery(document).ready(function() {
				/*Main.init();
				Login.init();*/
			});
			
			function sendForgotPassword() {
				if($("#emailId").val()== null){
					 hideLoader();
				}	
				else{					
					showLoader();
					document.forms[0].emailForgotPass.value = $("#emailId").val();
			        document.forms[0].actionName.value="save";
					document.forms[0].submit();
				}
			}
			function backToLogin() {
				document.forms[0].actionName.value="login";
				document.forms[0].submit();
			}
			
			function showLoader() {
	             jQuery('#loading').show();
	        }
	        
	        function hideLoader() {
	             jQuery('#loading').hide();
	        }
	        
	        /* function pageLoad()
	        {
	        	<c:set var="sCode" scope="session" value="${sessionScope.loaderCode}"/>
	        	<c:if test="${sCode == 1}">
				   hideLoader();
				</c:if>		        	
	        }
	        function allnumeric(inputtxt)
	        {
	           var numbers = /^[0-9]+$/;
	           if(inputtxt.value.match(numbers))
	           {
	           alert('Your Registration number has accepted....');
	           document.form1.text1.focus();
	           return true;
	           }
	           else
	           {
	           alert('Please input numeric characters only');
	           document.form1.text1.focus();
	           return false;
	           }
	        } */ 
		</script>
		<!-- end: JavaScript Event Handlers for this page -->
		<!-- end: CLIP-TWO JAVASCRIPTS -->
	</body>
	<!-- end: BODY -->
</html>