<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
</head>
<body>
	<div class="container">
		<div class="starter-template">
			<h1>Spring Boot Web JSP Example 2</h1>
			<h2>Language : 
				<a href="?lang=en_US">English</a> 
				| <a href="?lang=zh_TW">繁體中文</a>
				| <a href="?lang=zh_CN">簡體中文</a>
				| <a href="?lang=ru">русский</a>
			</h2>
			<h2>Message: ${message}</h2>
			<h2>Current Locale : ${pageContext.response.locale}</h2>
			<h2>hello: <s:message code="hello" text="default" /></h2>
			<h2>customer.name: <s:message code="customer.name" text="default" /></h2>
			<h2>career: <s:message code="career" text="default" /></h2>
		</div> 
	</div>
	<!-- /.container -->
</body>

</html>
