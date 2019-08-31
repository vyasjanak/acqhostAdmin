<%@ include file="/include.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
function onSubmitButton(){
  /* alert("Do you want to submit...?"); */
  document.getElementById('submitButtonDiv').style.display = "none";
  document.getElementById('progressBar').style.display = "block";
  return false;
}
</script>

<script type="text/javascript">
function postTxns(method)
{
	/* alert(method); */
	var invalid=0;
	
	if (document.getElementById("upload").files.length == 0) 
	{
		document.getElementById("upload").focus();
		document.getElementById("file_span").innerHTML = "Please upload file.";
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
	/* else if (document.getElementById("cycledate").value >  new Date()) 
	{
		alert("Working!");
		var date = document.getElementById("inputDate").value;
		var varDate = new Date(date); //dd-mm-YYYY
		var today = new Date();

		if(varDate >= today) {
		//Do something..
		alert("Working!");
		}
		invalid = 1;
	} */
	else if (document.getElementById("cycle").selectedIndex == 0) 
	{
		document.getElementById("cycle").focus();
		document.getElementById("cycle_span").innerHTML = "Please select cycle.";
		valueBackground("cycle_span");
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
	
<script type="text/javascript">
var allowedExtensions = {
		  '.csv'  : 1
		};
		 
		function checkExtension(filename) 
		{
		    var match = /\..+$/;
		    var ext = filename.match(match);
		    if (allowedExtensions[ext]) 
		    {
		    	return true;
		    } 
		    else 
		    {
		    	document.getElementById("file_span").innerHTML = "File must be NPCI .csv format!";
		    	document.getElementById("upload").value="";
				document.getElementById("upload").focus();
				valueBackground("file_span");
			    return false;
		    }
		}

</script>
	
<title>1Pay : Recon Transactions</title>
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
								<h4 class="mainTitle" id="dashboard">Recon Transactions</h4>
							</div>
						</div>
					</section>
					<!-- end: PAGE TITLE -->
					<!-- start: WIZARD DEMO -->

			<div class="container-fluid container-fullw bg-white">
				<div class="row">
					<br>
							

			<!-- start: WIZARD FORM -->
			<font color="green" size=2> 
				<logic:present name="success">
				<b>Total transactions in file <%=request.getAttribute("total")%>. </b>
				<%-- <b><%-- Total transactions are <%=request.getAttribute("total")%>, <%=request.getAttribute("notprocessed")%> Transaction(s) found out of <%=request.getAttribute("total")%> transactions</b> --%> 
				<script type="text/javascript">alert('Transactions posted successfully...!!!');</script>
				<!-- <b>Invoice added successfully!</b> --> 
				</logic:present>
			</font>
	
			<%-- <font color="red" size=3> 
				<logic:present name="failure">
				<script type="text/javascript">alert('Ooops, an error occurred, Please check file format...!!!');</script>
				<!-- <b>Ooops, an error occurred!!</b> --> 
				</logic:present>
			</font> --%>
			<font color="red" size=3> 
				<logic:present name="failure">
				<script type="text/javascript">alert('Invalid file and cycle combination/Invalid file choosen, Please check file/cycle combination or format...!!!');</script>
				</logic:present>
			</font>
			
			<font color="red" size=2> 
				<logic:present name="inprogressfailure">
					<b>File processing in progress...!!!</b> 
				</logic:present>
			</font>	
			<font color="red" size=2> 
				<logic:present name="cyclefailure">
					<b>Cycle has been already processed, Please try another cycle...!!!</b> 
				</logic:present>
			</font>
			<font color="red" size=2> 
				<logic:present name="datefailure">
					<b>Sorry, Please check previous recon date and cycles to process, last date is <%=(String)request.getAttribute("date")%>!!!</b> 
				</logic:present>
			</font>
			<font color="red" size=2> 
				<logic:present name="filefailure">
					<b>File has been already processed, Please try another file...!!!</b> 
				</logic:present>
			</font>
			<%-- <font color="red" size=2> 
				<logic:present name="datecyclefailure1">
					<b>Please process cycles!!!</b> 
				</logic:present>
			</font>
			<font color="red" size=2> 
				<logic:present name="datecyclefailure2">
					<b>Please process CYCLE2!!!</b> 
				</logic:present>
			</font> --%>
	
			<!-- post upload -->
			
			<%-- <%
    			String URL = "http://localhost:8080/UploadPost/txnrequestprocess.jsp";
	    	
 			%> --%>
 			<!-- <br><br>
			Search:<input type="text" class="form-control" id="Search" onkeyup="myFunction()" placeholder="Search Transaction Here...">
    		<br> -->
			
			<html:form  action="/postTxns" styleId="formAdd" method="post" enctype="multipart/form-data"><%-- /postTxns <%=URL%>--%>
				
			<html:hidden property="dispatch" /> 
			<fieldset>
						<legend>
								NPCI Transactions		
						</legend>
			<div theme="simple">
				<div class="col-md-12">
					<div class="row"> 
						
						<div class="row">
							<div class="col-md-4">
								<div class="form-group" id="submitButtonDiv">
									
									<label class="control-label">
												Bulk TxnsFile Upload <span class="symbol required"></span><span id="file_span"></span>
									</label>
									<html:file styleClass="form-control" property="file" styleId="upload" onchange="javascript:valueChange('file_span'); checkExtension(this.value);"/>
  								</div>
  							</div>
  							<div class="col-md-3">
								<div class="form-group">
    			
				         			 <label class="control-label">Date</label>
				         			 <span class="symbol required"></span><span id="cycledate_span"></span>
				         			 <div id="submitButtonDiv"></div>
				         			 
				         			 
				         			 <div class="input-group date form_date" data-date="" data-date-format="dd/mm/yyyy"><!--mm/dd/yyyy  yyyy-mm-dd   -->
				         			 <!-- 'DD/MM/YYYY HH:mm:ss' -->
										<html:text styleClass="form-control" maxlength="20"
											styleId="cycledate" property="cycledate"
											onchange="javascript:valueChange1('cycledate'); javascript:valueChange('cycledate_span');" />
										<span class="input-group-addon"><span
												class="glyphicon glyphicon-calendar"></span>
											</span>
											<!-- onkeypress="return Date1(cycledate);" -->
									</div>
				         		</div>
       		  				</div>	
       		  				
       		  				<div class="col-md-3">
								<div class="form-group">
    			
				         			 <label class="control-label">Cycle</label>
				         			 <span class="symbol required"></span><span id="cycle_span"></span>
				         			 <div id="submitButtonDiv"></div>
				         			 
				         			  	<html:select styleClass="form-control" property="cycle" styleId="cycle" onchange="javascript:valueChange('cycle_span');">
				         			  	  <html:option value="-1">Select Cycle</html:option>	
				         			 	  <html:option value="1">Cycle 1</html:option>
				         			 	  <html:option value="2">Cycle 2</html:option>
				         			 	</html:select>
            							<!-- <input type="text" id="processdate" class="form-control datepicker" placeholder="dd-mm-yyyy" name="processdate" /> --> 
            							            							
				         			 </div>
				         		</div>
       		  				</div>	
       		  				
    					<br><br>
    						
    					<div class="col-md-10" id="submitButtonDiv">
    					<br><br>
    					
						<div id="textbox">
						  		<%-- <p class="alignleft"><html:link href="${pageContext.request.contextPath}/">Home</html:link></p> --%>
						   		<p align="right">
							   		<html:link href="${pageContext.request.contextPath}/nrnstxns.do?dispatch=goToAddPage">
										Exception Transactions
									</html:link>
									
									<html:button value="Process" property="" styleClass="btn btn-primary btn-o" onclick="postTxns('postBulktxns')"/>
								</p>
						</div>
						</div>
						
						
    					
    						
    					<div id="progressBar" style="display:none">
							<p style="text-align:center">Please wait ...</br></br></br>
 							<!-- <img src="js/ajax_wait.gif" alt="Progress Bar"> -->
 							<img src="js/ajax-loader.gif" alt="Progress Bar">
 							</p>
							
						</div>
    					
    				</div>
    		<!-- 	</div>
    		</div> -->
    		</fieldset>	
    		
    		<div align="center">
    		<logic:notEmpty name="summaryList">
    		
                <table width="auto" class="table table-bordered table-hover">
                    <thead>
						<tr style="font-weight:bold;">
							<th>Recon Date</th>
							<th>Recon Cycle</th>
							<th>Total Txn In File</th>
							<th>Total Match</th>
							<th>Total Deemed Accepted & Reconcilled</th>
							<th>Already Reconcilled</th>
							<th>Remark</th>
						</tr>
					</thead>

		             <tbody>
		   				<logic:iterate name="summaryList" id="post">
							<tr>
							     <td><bean:write name="post" property="rec_date" />
							     <td><bean:write name="post" property="cycle" />
								 <td><bean:write name="post" property="total_rec" />
								 <td><bean:write name="post" property="total_match" />
								 <td><bean:write name="post" property="total_mismatch" />
								 <td><bean:write name="post" property="already_recon" />
								 <td><bean:write name="post" property="remark" />
							</tr>
						</logic:iterate>
					</tbody>
					
           		</table>
          </logic:notEmpty>
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
					
					
					
					<script type="text/javascript">
						jQuery(document).ready(function () {
			   			 Main.init();
			    		UINotifications.init();
						});
					</script>
				
					<script>
						
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
			
					<script>
					    function myFunction()
					    {
					    // Declare variables
					   	var input, filter, table, tr, td, i ;
						input = document.getElementById("Search");
						filter = input.value.toUpperCase();
						table = document.getElementById("PerformanceTable");
						tr = table.getElementsByTagName("tr"),
						th = table.getElementsByTagName("th");
					
					    // Loop through all table rows, and hide those who don't match the        search query
					    for (i = 1; i < tr.length; i++) {
					            tr[i].style.display = "none";
					            for(var j=0; j<th.length; j++){
					        td = tr[i].getElementsByTagName("td")[j];      
					        if (td) {
					            if (td.innerHTML.toUpperCase().indexOf(filter.toUpperCase()) > -1)                               {
					                tr[i].style.display = "";
					                break;
					            }
					        }
					    }
					    }
					
					}
					</script>
       
</body>
</html>