<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<style>
.errors{
	color: red;
	font-weight: bold;

}
</style>

<div class="action-container">
	<div class="page-title">Request Info</div>
</div>
<div class="app-content app-main">
	<div class="form-page-content">

		<form:form cssClass="form-horizontal"  method="POST" action="${pageContext.servletContext.contextPath}/submitRegistration.htm" commandName="registrationInfoData">
			<h3 class="headingprofile">
				Fill in the form below
			</h3>
			<h5> <form:errors path="*" cssClass="errors" /></h5>
			<div class="form-group">
				<label class="control-label">Name : </label>
				<div class="form-feild">
				<form:input path="name" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label">Email ID: </label>
				<div class="form-feild">
				<form:input path="email" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label">Age: </label>
				<div class="form-feild">
				<form:input path="age" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label">Mobile : </label>
				<div class="form-feild">
				<form:input path="mobile" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label">City: </label>
				<div class="form-feild">
				<form:input path="city" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label">Company: </label>
				<div class="form-feild">
				<form:input path="company" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label">&nbsp;</label>
				<div class="form-feild">

				<button class="btn btn-blue" type="submit" id="update_user_profile_btn">Register</button></div>
			</div>
		</form:form>
	</div>
</div>