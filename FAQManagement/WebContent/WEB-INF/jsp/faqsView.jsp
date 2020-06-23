<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#button2").click(function(){
		window.location.href="faqsList";
	})
})
</script>
<body>
		<p align="center">查看常见问题</p>
		<p align="center">
			分类：
			${faq.cname }
		</p>
		<p align="center">
			时间：
			<fmt:formatDate value="${faq.createdate }" pattern="yyyy-MM-dd HH:mm:ss"/>
		</p>
		<p align="center">
			标题：
			${faq.title}
		</p>
		<p align="center">
			内容：
			<textarea rows="5" cols="20" name="content" id="content" readonly="readonly">
				${faq.content }
			</textarea>
		</p>
		<p align="center">
			<input type="button" value="返回" id="button2">
		</p>

</body>
</html>