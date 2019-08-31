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
		
		<link href="http://fonts.googleapis.com/css?family=Lato:300,400,400italic,600,700|Raleway:300,400,500,600,700|Crete+Round:400italic" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="vendor/fontawesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="vendor/themify-icons/themify-icons.min.css">
		
		
		<link rel="stylesheet" href="css/loder.css"/>
		<link rel="stylesheet" href="css/reportmain.css"/>
		<link rel="stylesheet" href="css/material-icons.css"/>
		
		 <script src="css/echarts.js"></script>
		<script src="css/ngecharts.js"></script>
		<script src="css/ui.js"></script>
		<script src="css/vendor.js"></script>
		
		
		
	</head>
	<!-- end: HEAD -->
	<body onload="pageLoad()">
		<div id="app">
			
			<div class="app-content">
				
				<!-- end: TOP NAVBAR -->
				<div class="main-content" >
					<div class="wrap-content container" id="container">
						
						<!-- end: DASHBOARD TITLE -->
						<!-- start: FEATURED BOX LINKS -->
						<div class="container-fluid container-fullw bg-white">
												
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
                                                <div class="col-md-4"><label class="control-label" id="TagID" style="font-weight: normal;">EPC/Tag ID:</label></div>
                                                <div class="col-md-8">
                                                <div class="form-group">
                                                <html:text styleClass="form-control" property="tagid" styleId="tagid" maxlength="32" onkeypress="checktagid()"/>
                                                </div>
                                                </div>
                                                </div>
                                               <div class="row">
                                                <div class="col-md-4"><label class="control-label" id="Tid" style="font-weight: normal;">TID :</label></div>
                                                <div class="col-md-8">
                                                <div class="form-group">
                                                <html:text styleClass="form-control" property="tid" styleId="tid" maxlength="32" onkeypress="checktid()" />
                                                </div>
                                                </div>
                                                </div>                                                
												<div class="row">
                                                <div class="col-md-4"><label class="control-label" id="Vehicle_No" style="font-weight: normal;">Vehicle No :</label></div>
                                                <div class="col-md-8">
                                                <div class="form-group">
                                                <html:text styleClass="form-control" property="vehicle_no" styleId="vehicle_no" maxlength="12" onkeypress="checkvechno()"/>
                                                </div>
                                                </div>
                                                </div>
                                                
                                                
                                                <div class="row"> 
                                                
                                               
                                             <div class="col-md-4"><label class="control-label" id="exce_type_label" style="font-weight: normal;">Exception Type : <span class="symbol required"></span></label></div>
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
                                                                                              
                                                </html:form>
                                                <br /><br />
                                                
               <logic:present name="walletInfo">  
                 <table class="table table-bordered table-hover" id="example"> 
                   
					<thead>
	
					<tr>
						<c:forEach items="${headerNames}" var="name">
							<th style="width: 45px;text-align: center;" align="center">${name}</th>
						</c:forEach>
						 <th style="width: 45px;text-align: center;" align="center">Delete</th> 
					</tr>
			
					</thead>
				<tbody>
				    <c:forEach items="${walletInfo}" var="values" varStatus="count">
				    
						<tr>
                            <c:forEach items="${values}" var="value">
						       <td style="width: 45px;text-align: center;">${value}</td>
						   	</c:forEach>
                         <td style="width: 45px;text-align: center;"><a href="javascript:deleteException('${values.get(1)}','${values.get(2)}')"><i class="ti-trash"></i></a></td>
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
	    
	    
	    
	    function deleteException(TagId,ExceCode) {
		    if (confirm("Are you sure to delete?")){
			   document.forms[0].tagid.value=TagId;
			   document.forms[0].exce_type.value= ExceCode;
			 
				document.forms[0].actionName.value="REMOVE";
				document.forms[0].submit();
			}
		}
	    
	    function checkvechno()
		{						
			var VNO = $("#vehicle_no").val();
			 if(VNO.length>=0)
			{		
		 	document.getElementById("tagid").value="";
	    	document.getElementById("tid").value="";
	    	
	    	$("#tagid").prop("readonly", true);
			$("#tid").prop("readonly", true);
			
			/* $("#tagid").prop("disabled", true);
			$("#tid").prop("disabled", true); */
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
					
					
					document.forms[0].actionName.value="SEARCH";
					document.forms[0].submit(); 
					
				/* 	}
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
					
					
					document.forms[0].actionName.value="ADD";
					document.forms[0].submit(); 
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
		<!-- end: JavaScript Event Handlers for this page -->
		<!-- end: CLIP-TWO JAVASCRIPTS -->
	</body>
</html>
