<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.recon.daoImpl.GetReportDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
    
    
   <%
    // String fileName = new SimpleDateFormat("ddMMYYYYHHmmssSSS").format(new Date())+"_"+session.getAttribute("username");
	String fileName = new SimpleDateFormat("ddMMYYYYHHmm").format(new Date())+"_"+session.getAttribute("username");
	fileName = request.getAttribute("DisplayName").toString()+fileName;
	System.out.println("Report.jsp  :: File Name :: "+fileName);	
	%>
	 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>1Pay - Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<!-- Added by Bharat A on 02-10-2018 to Download Filtered Reports -->
<script src="reportDatatable/js/jquery-3.3.1.js"></script>
<script src="reportDatatable/js/jquery.dataTables.min.js"></script>
<script src="reportDatatable/js/dataTables.buttons.min.js"></script>
<script src="reportDatatable/js/buttons.flash.min.js"></script>
<script src="reportDatatable/js/jszip.min.js"></script>
<script src="reportDatatable/js/pdfmake.min.js"></script>
<script src="reportDatatable/js/vfs_fonts.js"></script>
<script src="reportDatatable/js/buttons.html5.min.js"></script>
<script src="reportDatatable/js/buttons.print.min.js"></script>
<!-- End by Bharat A on 02-10-2018 to Download Filtered Reports -->

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> 


<script>

$(document).ready(function() {
    $('#example').DataTable( {
    	dom: 'Blfrtip',
        buttons: 
        [
            'copy',
            {
                extend: 'excelHtml5',
                title: '',
                filename: '<%=fileName%>'			                                
            },
            {
                extend: 'csvHtml5',
                title: '',
                filename: '<%=fileName%>'		                        
            },
            {
                extend: 'pdfHtml5',
                filename: '<%=fileName%>',
                title: '',
                orientation: 'landscape',
                pageSize: 'LEGAL',
                customize: function (doc) 
                { 
                	doc.defaultStyle.fontSize = 7; //2,3,4,etc 
                	doc.styles.tableHeader.fontSize = 7; //2, 3, 4, etc 
                }                
            },
            {
                extend: 'print',
                customize: function ( win ) {
                    $(win.document.body)
                        .css( 'font-size', '9pt' );
                        /* .prepend(
                            '<img src="http://datatables.net/media/images/logo-fade.png" style="position:absolute; top:0; left:0;" />'
                        ) */
 
                    $(win.document.body).find( 'table' )
                        .addClass( 'compact' )
                        .css( 'font-size', 'inherit' );
                }
            }
        ]
    } );
} ); 
 

function download_csv(type) {
	// alert(type);
	document.getElementById("downloadType").value=type;
	
	    document.download.submit();		        	   
	}   
	
</script>




<style>
.dataTables_info
{
    margin-top: 15px;
    margin-bottom: 15px;	
}
#example_paginate
{
    margin-top: 15px;
    margin-bottom: 15px;
}

div.scrollmenu {
    /* background-color: #333; */
    overflow-x: auto;
    white-space: nowrap;
    margin-top: 25px;
}

div.scrollmenu a {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px;
    text-decoration: none;
}

div.scrollmenu a:hover {
    background-color: #777;
}

</style>

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
		
		<!-- Added by Bharat A on 02-10-2018 to Download Filtered Reports -->

			<link rel="stylesheet" href="reportDatatable/css/jquery.dataTables.min.css">
			<link rel="stylesheet" href="reportDatatable/css/buttons.dataTables.min.css">
		
		<!-- End by Bharat A on 02-10-2018 to Download Filtered Reports -->
 
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
	<body>
        
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
					
					<div class="navbar-collapse collapse" id="navbar-heading">
                   		<%@ include file="/header.jsp"%>
					</div>
					
				</header>
				<!-- end: TOP NAVBAR -->
				<div class="main-content" >
					<div class="wrap-content container" id="container">
			
        
        <%
   		// DisplayName 
   		String to_date = request.getParameter("to_date");	
		String from_date = request.getParameter("from_date"); 
		
   		// String rep = (String) request.getAttribute("rep");
   		 String rep = (String) session.getAttribute("rep");
        
		%>
				<section id="page-title" style=" padding:0px 0px;">
							<div class="row">
								<div class="col-sm-7">
									<h4 class="mainTitle" id="dashboard"><%= request.getAttribute("DisplayName") %></h4>
									
								</div>
							
							</div>
						</section>		
				 	<form action="/acqhostAdmin/report.do?rep=<%=rep%>"  method="post">	
				 				 		
						<div class="col-md-12">						
						<div class="col-md-3">
							<div class="form-group">
								<label class="control-label">
									From Date<span class="symbol required"></span><font color="red"> <span id="from_datespan"></span></font>
								</label>
								
								<div class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" >
									<input class="form-control" onkeypress="return Date1(event);" maxlength="10" name="from_date" id="from_date" type="text" onkeyup="javascript:valueChange('from_datespan');"  placeholder="yyyy-mm-dd" readonly="readonly">
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
								</div>
							</div>
						</div>
										
										
						<div class="col-md-3">
							<div class="form-group">
								<label class="control-label">
									To Date<span class="symbol required"></span><font color="red"><span id="to_datespan"></span></font>
								</label>
								<div class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" >
									<input class="form-control" name="to_date" onkeypress="return Date1(event);" maxlength="10" id="to_date" type="text" onkeyup="javascript:valueChange('to_datespan');" placeholder="yyyy-mm-dd" readonly="readonly">
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
								</div>
							</div>
							
						</div>
						<input type="button" value="Submit" onclick="javascript:return validateDate();" style=" margin-top: 27px;  margin-left: 38px; "/>
						
						</div>
						<input type="hidden" id="rep" name="rep" value="<%=rep%>" /><br/>
										
					</form> 
					
        <br><br><br>
 <%-- <% int count = 0; %>   
 <% int resultDataRow = 0; %>   --%>
	
	  <logic:present name="resultData">  
	  <div class="scrollmenu">
                 <table class="table table-bordered table-hover" id="example"> 
                   
					<thead>
					<tr>
						<c:forEach items="${headerNames}" var="name">
							<th style="width: 45px;text-align: center;" align="center">${name}</th>
							<%-- <% count++; %> --%>
						</c:forEach>
					</tr>		
					</thead>
				<tbody>
				    <c:forEach items="${resultData}" var="values" varStatus="count">
				    
						<tr>
						<%-- <% resultDataRow++; %> --%>
                            <c:forEach items="${values}" var="value">
						       <td style="width: 45px;text-align: center;">${value}</td>
						   	</c:forEach>                        
                        </tr>
					</c:forEach>
				</tbody>
				
			 </table> 	
			</div>					
	 </logic:present>  
 <br>
  		<%-- <form action="DownloadAccoiunt" method="post" name="download">
  		<input type="hidden" name="downloadType" id="downloadType" value="">
		<input type="hidden" name="headerNames" value="${headerNames}">
		<input type="hidden" name="count" value="<%=count%>">	
		<input type="hidden" name="Rowcount" value="<%=resultDataRow%>">
		<input type="hidden" name="resultData" value="${resultData}">
		
		<%
    if(request.getAttribute("resultData")!=null)
    {
       %>
    	 <button class="btn btn-primary btn-o" onclick="download_csv('excel')">Download Excel</button>
		 <button class="btn btn-primary btn-o" onclick="download_csv('PDF')">Download PDF</button> 
  	<%  }
	%>


		 <br><br>
	</form>
 --%>

 </div></div></div>

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
<!-- start: MAIN JAVASCRIPTS -->


		<script src="vendor/jquery/jquery.min.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="vendor/modernizr/modernizr.js"></script>
		<script src="vendor/jquery-cookie/jquery.cookie.js"></script>
		<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
		<script src="vendor/switchery/switchery.min.js"></script>
		<script src="vendor/Chart.js/Chart.min.js"></script>
		<script src="assets/js/main.js"></script>
        <script src="assets/js/charts.js"></script>
		<script src="assets/js/index.js"></script>
		
	<!-- Added by Bharat A on 02-10-2018 to Download Filtered Reports -->
	<script src="reportDatatable/js/jquery-3.3.1.js"></script>
	<script src="reportDatatable/js/jquery.dataTables.min.js"></script>
	<script src="reportDatatable/js/dataTables.buttons.min.js"></script>
	<script src="reportDatatable/js/buttons.flash.min.js"></script>
	<script src="reportDatatable/js/jszip.min.js"></script>
	<script src="reportDatatable/js/pdfmake.min.js"></script>
	<script src="reportDatatable/js/vfs_fonts.js"></script>
	<script src="reportDatatable/js/buttons.html5.min.js"></script>
	<script src="reportDatatable/js/buttons.print.min.js"></script>
	<!-- End by Bharat A on 02-10-2018 to Download Filtered Reports -->
	
	<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        
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
		
		 <script>
		    jQuery(document).ready(function () {
		        Main.init();		      
		        UINotifications.init();
		    });
		    
		    
		</script> 
		<script type="text/javascript">
		function validateDate()
		{
			 var from = $("#from_date").val();
			 var to = $("#to_date").val();
		 if(document.getElementById("from_date").value == "")
        	{
        		document.getElementById("from_date").focus();
        		document.getElementById("from_datespan").innerHTML = "select From Date.";
        		document.getElementById("to_datespan").innerHTML = "";
        		valueBackground("from_datespan");
        	 
        		return false;      			
        	}
        	else if(document.getElementById("to_date").value == "")
        	{
        		document.getElementById("to_date").focus();
        		document.getElementById("to_datespan").innerHTML = "select To Date.";
        		document.getElementById("from_datespan").innerHTML = "";
        		valueBackground("to_datespan");
        	 
        		return false;      			
        	}
		 
		

		 else if(Date.parse(from) > Date.parse(to)){
			 document.getElementById("from_date").focus();
     		document.getElementById("from_datespan").innerHTML = "select valid Date.";
     		document.getElementById("to_datespan").innerHTML = "";
     		valueBackground("from_datespan");
     		
     		return false;      			 
		 }
		
		 
        	else
        		{
        		// alert("Submit");
        		document.forms[1].submit();
        		 return true;
        		}
		}
		</script>
		
  </body>
   
</html>