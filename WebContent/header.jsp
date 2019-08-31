 <ul class="nav navbar-left">
            <li><span id="welcome-text" class="mainTitle" ><h3 style="padding-top:10px; color:white;"> Welcome <%=(String)session.getAttribute("fullname") %> </h3></span></li>
        </ul>
		<ul class="nav navbar-right">
			<!-- start: MESSAGES DROPDOWN -->
							
			<!-- end: MESSAGES DROPDOWN -->
			<!-- start: ACTIVITIES DROPDOWN -->
							
			<!-- end: ACTIVITIES DROPDOWN -->
			<!-- start: LANGUAGE SWITCHER -->
							
			<!-- start: LANGUAGE SWITCHER -->
			<!-- start: USER OPTIONS DROPDOWN -->
			<li class="dropdown current-user">
				<a href class="dropdown-toggle" data-toggle="dropdown" id="user-dropdown" style="color:white;">
					<!-- <img src="assets/images/avatar-1.jpg" alt="Peter"> --> <span class="username" ><%=(String)session.getAttribute("fullname") %> <i class="ti-angle-down"></i></i></span>
				</a>
				<ul class="dropdown-menu dropdown-dark">
					<li>
						<a href="changePassword.do">
							Change Password
						</a>
					</li>			
					<li>
						<a href="logout.do">
							Log Out
						</a>
					</li>
				</ul>
			</li>
			<!-- end: USER OPTIONS DROPDOWN -->
		</ul>
		<!-- start: MENU TOGGLER FOR MOBILE DEVICES -->
		<!--<div class="close-handle visible-xs-block menu-toggler" data-toggle="collapse" href=".navbar-collapse">
			<div class="arrow-left"></div>
			<div class="arrow-right"></div>
		</div>-->
		<!-- end: MENU TOGGLER FOR MOBILE DEVICES -->