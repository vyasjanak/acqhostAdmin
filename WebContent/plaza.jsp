<%@ include file="/include.jsp"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>


 <%
	String fileName = new SimpleDateFormat("ddMMYYYYHHmm").format(new Date())+"_"+session.getAttribute("username");
	fileName = "plazaDetails_"+fileName;
	System.out.println("plaza.jsp  :: File Name :: "+fileName);	
 %>
	

<!DOCTYPE html>

<html lang="en">
	
	<head>
		<title>1Pay : Plaza Details</title>
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
    
    	<!-- Added by Bharat A on 02-10-2018 to Download Filtered Reports -->

			<link rel="stylesheet" href="reportDatatable/css/jquery.dataTables.min.css">
			<link rel="stylesheet" href="reportDatatable/css/buttons.dataTables.min.css">
		
		<!-- End by Bharat A on 02-10-2018 to Download Filtered Reports -->
		

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
		
		<!-- <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>  -->
		<script type="text/javascript" src="js/sweetalert.min.js" charset="UTF-8"></script>


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
	
</script>
	
	
<style type="text/css">
div.scrollmenu {
		    /* background-color: #333; */
		    overflow-x: auto;
		   /*  white-space: nowrap; */
		}
		
		div.scrollmenu a {
		    display: inline-block;
		   /*  color: white; */
		    text-align: center;
		    padding: 14px;
		    text-decoration: none;
		}
		
		/* div.scrollmenu a:hover {
		    background-color: #777;
		}    */       
          
      table.dataTable tbody th,table.dataTable tbody td{padding: 0px 10px;}       
</style>

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
	<body onload="loadPage()">
	
		<div id="app">
		
			<!-- sidebar -->
			<div class="sidebar app-aside" id="sidebar">
				<%@ include file="/sidemenu.jsp"%>
			</div>
			<!-- / sidebar -->
			<div class="app-content">
				
				<header class="navbar navbar-default navbar-static-top" id="navbar-top">
					
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
						<!-- start: DASHBOARD TITLE -->
						<section id="page-title" style=" padding:0px 0px;">
							<div class="row">
								<div class="col-sm-7">
									<h4 class="mainTitle" id="dashboard">Plaza Details</h4>
									
								</div>
							
							</div>
						</section>
						<!-- end: DASHBOARD TITLE -->
						<!-- start: FEATURED BOX LINKS -->
						<div class="container-fluid container-fullw bg-white">
								<%--  <logic:equal name="plazaForm" property="message" value="PCF"> 
									<div class="row">
										<div class="col-md-10" style="margin-bottom: 20px;">
										<script type="text/javascript"> swal("<%= request.getAttribute("getErrorMsg")%>"); </script> 
											<!-- <span class="fieldTextblink"><font color="Green"><b>Plaza Creation Failed.</b></font></span> -->	
										</div>
									</div>
								</logic:equal> --%>
								<logic:equal name="plazaForm" property="message" value="PCS"> 
									<div class="row">
										<div class="col-md-10" style="margin-bottom: 20px;">
										<script type="text/javascript"> swal("Plaza Created Successfully "); </script> 
											<span class="fieldTextblink"><font color="Green"> Plaza Created Successfully  </font></span>	
										</div>
									</div>
								</logic:equal>
								<logic:equal name="plazaForm" property="message" value="EM">
									<div class="row">
											<div class="col-md-10" style="margin-bottom: 20px;">
											<script type="text/javascript"> swal("Plaza Created but Error occurred while sending Email."); </script> 
										<span class="fieldTextblink"><font color="RED">	Plaza Created but Error occurred while sending Email.</font></span> 
											</div>
									</div>
									</logic:equal>
								<logic:equal name="plazaForm" property="message" value="PUS"> 
								<div class="row">
									<div class="col-md-10" style="margin-bottom: 20px;">
									<script type="text/javascript"> swal("Plaza Updated Successfully"); </script> 
										<span class="fieldTextblink"><font color="Green"><b>Plaza Updated Successfully</b></font></span>	
									</div>
								</div>
							</logic:equal>
							<%-- <logic:equal name="plazaForm" property="message" value="PUF"> 
								<div class="row">
									<div class="col-md-10" style="margin-bottom: 20px;">
										<span class="fieldTextblink"><font color="RED">Plaza Updation Failed. </font></span>	
									</div>
								</div>
							</logic:equal> --%>
							 <logic:equal name="plazaForm" property="message" value="PDS"> 
								<div class="row">
									<div class="col-md-10" style="margin-bottom: 20px;">
										<script type="text/javascript"> swal("Plaza Deleted Successfully"); </script> 
										<span class="fieldTextblink"><font color="Green"><b>Plaza Deleted Successfully</b></font></span>	
									</div>
								</div>
							</logic:equal>
							<logic:equal name="plazaForm" property="message" value="PDF"> 
								<div class="row">
									<div class="col-md-10" style="margin-bottom: 20px;">
									  <script type="text/javascript"> swal("Plaza Deletion Failed."); </script> 
										<span class="fieldTextblink"><font color="RED">Plaza Deletion Failed.</font></span>	
									</div>
								</div>
							</logic:equal>
						
								
								
								<html:form  styleClass="form-horizontal" action="/Plaza.do" method="post">
                                        						
                                       
                                     <div class="row"> 
									  
									   <div class="col-lg-2 col-sm-11">
											<div class="panel panel-transparent">
												<div class="panel-heading">
													<div class="panel-title">
														<!--Add More-->
                                                        <button class="btn btn-primary btn-o pull-right" onclick="addNewPlazaForm()">
														Add New
													</button>
													</div>
								
												</div>
												<html:hidden property="actionName"/>
											  <html:hidden property="id"/>
												
												 </div></div> </div> 
												</html:form>
				 <div class="panel-body"> 
													
						<div class="scrollmenu panel-body">	
                                <logic:present name="plazaData">             
                                   
                 						<table class="table table-bordered table-hover" id="example">          
									
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
										    <c:forEach items="${plazaData}" var="values">
											<tr>
												    <c:forEach items="${values}" var="value">
												    	<td>${value}</td>
												    </c:forEach>
												    <td><a href="javascript:editPlaza('${values.get(0)}')"><i class="ti-pencil"></i></a></td>
												    <td><a href="javascript:deletePlaza('${values.get(0)}')"><i class="ti-trash"></i></a></td>
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
    <!-- <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> -->
    <script type="text/javascript" src="js/sweetalert.min.js" charset="UTF-8"></script>
    
 
 
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

		 
		
		 function editPlaza(id) {
    	   	// alert("ID "+id);
		    document.forms[1].id.value=id;
			document.forms[1].actionName.value="edit";
			document.forms[1].submit();
		}
		
		function deletePlaza(id) {
		    if (confirm("Are you sure to delete?")){
				// alert("ID "+id);
			    document.forms[1].id.value=id;
				document.forms[1].actionName.value="delete";
				document.forms[1].submit();
			}
		}
		
		function addNewPlazaForm() {
			document.forms[1].actionName.value="addNewPlazaForm";
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
		
		
	</body>
</html>
