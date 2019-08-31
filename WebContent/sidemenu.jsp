<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<div class="sidebar-container">
					<nav>
						<!-- start: SEARCH FORM -->
						<div class="search-form">
							<a class="s-open" href="#">
								<i class="ti-search"></i>
							</a> 
<form class="navbar-form" role="search">							 
							</form> 
						</div> 
						<!-- end: SEARCH FORM -->
						<!-- start: MAIN NAVIGATION MENU -->
						
						<ul class="main-navigation-menu">
							<li class="active open" style="background-color:#4981af !important;">
								<a href="dashboard.do">
									<div class="item-content">
										<div class="item-media">
											<i class="fa fa-tachometer"></i>
										</div>
										<div class="item-inner">
											<span class="title"> Dashboard </span>
										</div>
									</div>
								</a>
							</li>
							<%
								Map<String, List<String>> menuMap = (Map)session.getAttribute("menuMap");
								if (menuMap != null && menuMap.size() > 0) {
									for (Map.Entry<String, List<String>> entry : menuMap.entrySet())
									{
									    System.out.println(entry.getKey() + "/" + entry.getValue());
								
							
							%>
							
							  
							  <li>
								<a href="javascript:void(0)">
									<div class="item-content">
										<div class="item-media">
										<% if (entry.getKey().equals("Masters")) { %>
												<i class="ti-pencil" style="color:#4981af !important;"></i>
											<% } else if (entry.getKey().equals("Dispute Mgmt")) { %>
												<i class="ti-loop" style="color:#4981af !important;"></i>
											<% } else if (entry.getKey().equals("Payout & Settlement")) {%>
												<i class="ti-pencil-alt" style="color:#4981af !important;"></i>
											<% } else if (entry.getKey().equals("Reports")) { %>
												<i class="ti-package" style="color:#4981af !important;"></i>
											<% }  else if (entry.getKey().equals("Recon")) { %>
												<i class="ti-share-alt" style="color:#4981af !important;"></i>
											<% } else if (entry.getKey().equals("Chargeback")) { %>
											<i class="ti-package" style="color:#4981af !important;"></i>
											<% } else if (entry.getKey().equals("Wallet Utility")) { %>
												<i class="ti-layout-grid2" style="color:#4981af !important;"></i>									
											<% } %>
										</div>
										<div class="item-inner">
											<span class="title"> <%=entry.getKey()%> </span><i class="icon-arrow"></i>
										</div>
									</div>
								</a>
								<ul class="sub-menu">
								    <%
								        List<String> subMenus = (List<String>)entry.getValue();
								    	for (int i = 0; i < subMenus.size(); i++) {
								    	String subMenuData = subMenus.get(i);
								    	String action = subMenuData.split("##")[0];
								    %>
									<li>
										<a href="<%=subMenuData.split("##")[1] %>">
											<span class="title"> <%=subMenuData.split("##")[0]%> </span>
										</a>
									</li>
									<% } %>
								</ul>
							</li>
							<% }} %>
                            
 						</ul>
						<!-- end: MAIN NAVIGATION MENU -->
						<!-- start: CORE FEATURES -->
						
						<!-- end: CORE FEATURES -->
						<!-- start: DOCUMENTATION BUTTON -->
						
						<!-- end: DOCUMENTATION BUTTON -->
					</nav>
				</div>