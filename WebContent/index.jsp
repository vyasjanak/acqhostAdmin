<%@ include file="/include.jsp"%>
<%@ page import="java.util.Map" %>

<!DOCTYPE html>
<!-- Template Name: Clip-Two - Responsive Admin Template build with Twitter Bootstrap 3.x | Author: ClipTheme -->
<!--[if IE 8]><html class="ie8" lang="en"><![endif]-->
<!--[if IE 9]><html class="ie9" lang="en"><![endif]-->
<!--[if !IE]><!-->
<html lang="en">
	<!--<![endif]-->
	<!-- start: HEAD -->
	<head>
		<title>1Pay : Dashboard</title>
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
         <style type="text/css">
            header .navbar-collapse
                {
                background-color:rgb(221,221,232) !important;
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
			 #fieldset1
			 {
			 padding: 0px; 
			 }
			 fieldset legend
			 {
				 color: #4981af !important;
			 }
             #navbar-top
             {
                 height:50px;
                 }
             /*.app-navbar-fixed
             {
                 padding-top:50px ;
                 }
               #sidebar
                {
                    width :250px;
                    }
            .navbar-header
            {
                width:250px !important;
                }
            #navbar-heading
            {
            margin-left:250px;
            }
            footer
            {
                margin-left:250px !important;
                }*/
        </style>
		<!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
	</head>
	<!-- end: HEAD -->
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
                 <div class="navbar-header"  style=" height:50px;" id="navbar_header_1"> <!---->
					<a href="#" class="sidebar-mobile-toggler pull-left hidden-md hidden-lg" style="color:white !important;" class="btn btn-navbar sidebar-toggle" data-toggle-class="app-slide-off" data-toggle-target="#app" data-toggle-click-outside="#sidebar">
						<i class="ti-align-justify"></i>
					</a>
					<!--<a class="navbar-brand" href="index.html">-->
					<a class="navbar-brand" href="#">
						<!--<img src="assets/images/logo.png" alt="Clip-Two"/>-->
						<h2 class="mainTitle" style="margin:5px 0px; color:white;">1Pay</h2> <!---->
					</a>
					<!-- -->
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
					<div class="wrap-content container" id="container" style="padding-bottom:0px !important;"> <!-- -->
						<!-- start: DASHBOARD TITLE -->
						<section id="page-title" style="padding:0px 0px;">
							<div class="row">
								<div class="col-sm-3">
									<span><h4 class="mainTitle" id="dashboard">Dashboard</h4></span>
									<!--<span class="mainDescription">overview &amp; stats </span>-->
                                   <!-- <h5 id="overview-text">overview &amp; stats</h5>-->
								</div>
                                <div class="col-sm-2">
                               <!-- <h5 id="overview-text">overview &amp; stats</h5>-->
                                </div>
								<div class="col-sm-5">
									<!-- start: MINI STATS WITH SPARKLINE -->
									
									<!-- end: MINI STATS WITH SPARKLINE -->
								</div>
							</div>
						</section>
						<!-- end: DASHBOARD TITLE -->
						<!-- start: FEATURED BOX LINKS -->
						<%
						Map<String, Object> pieChartData = (Map<String, Object>)request.getAttribute("pieChartData");
						Map<String, Object> dashboardData = (Map<String, Object>)request.getAttribute("dashboardData");
						%>
						<%-- <div class="container-fluid container-fullw bg-white" style="padding-bottom:0px;">
							<div class="row">
							  <div class="col-md-7">
							  <fieldset id="fieldset1">
							  <legend>Yesterday's</legend>
							   <div class="col-md-4 col-sm-6 col-xs-12">
								  <div class="info-box bg-red">
									<span class="info-box-icon">&#8377;</span>
									<div class="info-box-content">
									  <span class="info-box-text">Settled <br/> Amount</span>
									  <span class="info-box-number"><b><%=(String)dashboardData.get("yesSettAmt") %></b></span>
									 
												<span >
												<a style="color:white;" href="javascript:viewMore('1')">
													view more
												</a>
												</span>
									</div><!-- /.info-box-content -->
								  </div><!-- /.info-box -->
								</div><!-- /.col -->
								
								
								<div class="col-md-4 col-sm-6 col-xs-12">
								  <div class="info-box bg-orange">
									<span class="info-box-icon"> &#8377;</span>
									<div class="info-box-content">
									  <span class="info-box-text">Refund <br/>Amount</span>
									  <span class="info-box-number">
									  <b><%=(String)dashboardData.get("yesRefAmt") %></b></span>
									 
												<span >
												<a style="color:white;" href="javascript:viewMore('2')">
													view more
												</a>
												</span>
									</div><!-- /.info-box-content -->
								  </div><!-- /.info-box -->
								</div><!-- /.col -->
								 
								<div class="col-md-4 col-sm-6 col-xs-12">
								  <div class="info-box bg-teal">
									<span class="info-box-icon"> &#8377;</span>
									<div class="info-box-content">
									  <span class="info-box-text">Pending <br/>Settlement</span>
									  <span class="info-box-number">
									  <b><%=(String)dashboardData.get("yesPendtAmt") %></b></span>
									 
												<span >
												<a style="color:white;" href="javascript:viewMore('3')">
													view more
												</a>
												</span>
									</div><!-- /.info-box-content -->
								  </div><!-- /.info-box -->
								</div><!-- /.col -->
								</fieldset>
								</div>
								
								 
								 <div class="col-md-5">
								 <fieldset id="fieldset1">
								 <legend>Today's</legend>
                                <div class="col-md-6 col-sm-6 col-xs-12">
								  <div class="info-box bg-light-blue">
									<span class="info-box-icon"> &#8377;</span>
									<div class="info-box-content">
									  <span class="info-box-text">Transaction<br/>(Values)</span>
									  <span class="info-box-number">
									  <b><%=(String)dashboardData.get("todTxnVal") %></b></span>
												<span >
												<a style="color:white;" href="javascript:viewMore('4')">
													view more
												</a>
												</span>
									</div><!-- /.info-box-content -->
								  </div><!-- /.info-box -->
								</div><!-- /.col -->
								
								<div class="col-md-6 col-sm-6 col-xs-12">
								  <div class="info-box bg-aqua">
									<span class="info-box-icon"> #</span>
									<div class="info-box-content">
									  <span class="info-box-text">Transaction<br/>(Count)</span>
									  <span class="info-box-number">
									  <b><%=(String)dashboardData.get("todTxnCnt") %></b></span>
									 
												<span >
												<a style="color:white;" href="javascript:viewMore('5')">
													view more
												</a>
												</span>
									</div><!-- /.info-box-content -->
								  </div><!-- /.info-box -->
								</div><!-- /.col -->
								</fieldset>
								</div>
								</div>
							</div> --%>
  
						</div>
						<!-- end: FEATURED BOX LINKS -->
						<!-- start: FIRST SECTION -->
						<%-- <div class="container-fluid container-fullw">
							<div class="row">
								<div class="col-sm-12">
									<div class="row">
										<div class="col-md-9 col-lg-8">
											<div class="panel panel-white no-radius" id="visits" style="margin-bottom: 35px;">
												<div class="panel-heading border-light">
													<h4 class="panel-title"> Daily Transaction Tally</h4>
													<ul class="panel-heading-tabs border-light">
														
														<li>
															<div class="rate">
																<span class="text-medium">Details Report..</span>
															</div>
														</li>
														<li class="panel-tools">
															<a data-original-title="Refresh" data-toggle="tooltip" data-placement="top" class="btn btn-transparent btn-sm panel-refresh" href="#"><i class="ti-reload"></i></a>
														</li>
													</ul>
												</div>
												<div collapse="visits" class="panel-wrapper">
													<div class="panel-body">
														<div class="height-250"><!-- class="height-350"-->
															<canvas id="chart1" class="full-width"></canvas>
															<div class="margin-top-20">
																<div class="inline pull-left">
																	<div id="chart1Legend" class="chart-legend">
                                                                    
                                                                    </div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-5 col-lg-4">
										<div class="panel panel-white no-radius">
										<div class="panel-heading border-bottom">
											<h4 class="panel-title"></h4>
										</div>
										<div class="panel-body">
										<div style="height:197px !important;"><!-- class="height-200"-->
											<div class="text-center">
												<span class="mini-pie">
                                                 <canvas id="chart3" class="full-width"></canvas>
                                                  <span><%=(Integer.parseInt((String)pieChartData.get("Success"))+Integer.parseInt((String)pieChartData.get("Failed"))+Integer.parseInt((String)pieChartData.get("TimeOut")))%></span>
                                                 </span>
												<span class="inline text-large no-wrap"></span>
											</div>
											</div>
											<div class="margin-top-20 text-center legend-xs inline">
												<div id="chart3Legend" class="chart-legend"></div>
											</div>
										</div>
										<div class="panel-footer">
											<div class="clearfix padding-5 space5">
												<div class="col-sm-4 text-center no-padding">
													<div class="border-right border-dark">
														<!--<span class="text-bold block text-extra-large"><%=pieChartData.get("Success")%>%</span>-->
														<span class="text-bold block text-extra-large">
														<% float success=(Integer.parseInt((String)pieChartData.get("Success")));
														float total=100;
														float temp=(Integer.parseInt((String)pieChartData.get("Success"))+Integer.parseInt((String)pieChartData.get("Failed"))+Integer.parseInt((String)pieChartData.get("TimeOut")));
														float result=success*total/temp;
														String success1 = String.format("%.2f", result);
														%>
														
														<%= success1 %>%
														</span>
														<span class="text-light">Success</span>
													</div>
												</div>
												<div class="col-sm-4 text-center no-padding">
													<div class="border-right border-dark">
														<!--<span class="text-bold block text-extra-large"><%=pieChartData.get("Failed")%>%</span>-->
														<span class="text-bold block text-extra-large">
														<% float failed=(Integer.parseInt((String)pieChartData.get("Failed")));
														float totalf=100;
														float tempf=(Integer.parseInt((String)pieChartData.get("Success"))+Integer.parseInt((String)pieChartData.get("Failed"))+Integer.parseInt((String)pieChartData.get("TimeOut")));
														float resultf=failed*totalf/tempf;
														String resultf1 = String.format("%.2f", resultf);
														%>
														<%= resultf1 %>%
														</span>
														<span class="text-light">Failed</span>
													</div>
												</div>
												<div class="col-sm-4 text-center no-padding">
													<!--<span class="text-bold block text-extra-large"><%=pieChartData.get("TimeOut")%>%</span>-->
													<span class="text-bold block text-extra-large">
														<% float timeout=(Integer.parseInt((String)pieChartData.get("TimeOut")));
														float totalt=100;
														float tempt=(Integer.parseInt((String)pieChartData.get("Success"))+Integer.parseInt((String)pieChartData.get("Failed"))+Integer.parseInt((String)pieChartData.get("TimeOut")));
														float resultt=timeout*totalt/tempt;
														String resultt1 = String.format("%.2f", resultt);
														%>
														<%= resultt1%>%
														</span>
													<span class="text-light">Timedout</span>
												</div>
											</div>
										</div>
									</div>
								</div>
                                  </div>
								</div>
							</div>
						</div> --%>
						<!--model start-->
                        <div class="modal fade" id="viewMoreModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="myModalLabel">View More Data</h4>
									</div>
									<div class="modal-body">
								        <div class="row">
	                                       <div class="col-md-10" id="viewMoreData">
	                                       	   <table class="table table-bordered table-hover" id="Table4">
											       <thead>
													   <tr id="viewMoreHeader">
															
		                                                </tr>	
		                                            </thead>
											        <tbody id="viewMoreValues">
												        <tr>
													    </tr>
												    </tbody>
									            </table>
	                                        </div>
		                                </div>
									</div>
									
								</div>
							</div>
					    </div>
                        <!-- model end-->
					</div>
			</div>
		
			
			<!-- start: FOOTER -->
			<footer>
				<div class="footer-inner">
					<div class="pull-left">
						&copy; <span class="current-year"></span><span> 1Pay. All rights reserved</span>
					</div>
					<div class="pull-right">
						<span class="go-top"><i class="ti-angle-up"></i></span>
					</div>
				</div>
			</footer>
			<!-- end: FOOTER -->
			<!-- start: OFF-SIDEBAR -->
		
			<!-- end: OFF-SIDEBAR -->
			
		
		<!-- start: MAIN JAVASCRIPTS -->
		<script src="vendor/jquery/jquery.min.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="vendor/modernizr/modernizr.js"></script>
		<script src="vendor/jquery-cookie/jquery.cookie.js"></script>
		<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
		<script src="vendor/switchery/switchery.min.js"></script>
		<!-- end: MAIN JAVASCRIPTS -->
		<!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
		<script src="vendor/Chart.js/Chart.min.js"></script>
		<!--<script src="vendor/jquery.sparkline/jquery.sparkline.min.js"></script>-->
        <!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
		<!-- start: CLIP-TWO JAVASCRIPTS -->
		<script src="assets/js/main.js"></script>
		<!-- start: JavaScript Event Handlers for this page -->
        <script src="assets/js/charts.js"></script>
		<script src="assets/js/index.js"></script>
		<script>
			jQuery(document).ready(function() {
				Main.init();
				Index.init();
			});
			var labelNames = [];
			var failData = [];
			var successData = [];
			
			
			<%-- <%
				List<List<String>> lineChartData = (List<List<String>>)request.getAttribute("lineChartData");
				
				for (int i = 0;i<lineChartData.size();i++) {
			%>
				labelNames.push('<%=lineChartData.get(i).get(0)%>');
			    successData.push(<%=lineChartData.get(i).get(1)%>);
			    failData.push(<%=lineChartData.get(i).get(2)%>);
	        
	        <%}%> 
	        
	        var pieChartSuccess  = <%=pieChartData.get("Success")%>;
	        var pieChartFail  = <%=pieChartData.get("Failed")%>;
	        var pieChartTimeout  = <%=pieChartData.get("TimeOut")%>;  --%>
			
			function viewMore(rType) {
				$.ajax({				
					type: 'GET',
					url: "<%=request.getContextPath()%>/ajaxAction.do?type=viewMore&rType="+rType+"&userId="+'<%=(String)session.getAttribute("username")%>',
					success: function(data) {
					
					if (data != ""){
						var dataArr =  data.split("##");
						var headers = dataArr[0];
						
						$("#viewMoreHeader").html("");
						
					    var cellValues = headers.split("#");
					    var cellHtml = "";
					    for (var j = 0; j<cellValues.length;j++) {
                        	cellHtml = cellHtml + '<th>'+cellValues[j]+'</th>';
                        }
						$("#viewMoreHeader").append(cellHtml);                
						
						
						$("#viewMoreValues").html("");
						for (var i = 1; i  < dataArr.length;i++) {
						    var cellValues = dataArr[i].split("#");
						    var cellValueHtml = "";
						    for (var j = 0; j<cellValues.length;j++) {
                                cellValueHtml = cellValueHtml + '<td>'+cellValues[j]+'</td>';
                            }
							var viewMoreHtml = '<tr>'+cellValueHtml+'</tr>';
				                             
				             $("#viewMoreValues").append(viewMoreHtml);                
							//console.log(dataArr[i].split("#")[0]+"----"+dataArr[i].split("#")[1]);
						}
						console.log("Data fetched successful for view");
						$("#viewMoreModel").modal('show');
						
					} else {
						alert("No Data Found!");
					}
					},
					error: function (err) {
						console.log("Error in fetching data for view more.");
				    }
				});
			}
			
		</script>
       
		<!-- end: JavaScript Event Handlers for this page -->
		<!-- end: CLIP-TWO JAVASCRIPTS -->
	</body>
</html>
