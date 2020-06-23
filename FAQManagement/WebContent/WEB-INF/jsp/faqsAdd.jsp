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
	$.ajax({
		type:"GET",//请求类型
		url:"getClasses.json",//请求的url
		data:{},//请求参数
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			var $info = "";
			$.each(data, function(index, content){ 
				$info += "<option value='" + content.id + "'>"+ content.cname +"</option>";
			}); 
			$("#select1").append($info);
			
		},
		error:function(XMLHttpResponse, textStatus, errorThrown){//当访问时候，404，500 等非200的错误状态码
			console.log("1 异步调用返回失败,XMLHttpResponse.readyState:"+XMLHttpResponse.readyState);
            console.log("2 异步调用返回失败,XMLHttpResponse.status:"+XMLHttpResponse.status);
            console.log("3 异步调用返回失败,textStatus:"+textStatus);
            console.log("4 异步调用返回失败,errorThrown:"+errorThrown);
		}
	});
	
	$("#button1").click(function(){
		var select1 = $("#select1").val();
		if (select1 == 0 ) {
			alert("请选择分类");
			return;
		}
		var title = $("#title").val();
		if (title == '') {
			alert("请输入标题");
			return;
		}
		var content = $("#content").val();
		if (content == '') {
			alert("请输入内容");
			return;
		}
		document.forms[0].submit();
		
	})
	$("#button2").click(function(){
		window.location.href="faqsList";
	})
})




 
</script>
<body>
	<form action="faqsSave" method="post">
		<p align="center">添加常见问题</p>
		<p align="center">
			分类：
			<select id="select1" name="classid">
				<option value="0">--请选择分类---</option>
			</select>
		</p>
		<p align="center">
			标题：
			<input type="text" name="title" id="title">
		</p>
		<p align="center">
			内容：
			<textarea rows="5" cols="20" name="content" id="content"></textarea>
		</p>
		<p align="center">
			<input type="button" value="保存" id="button1">
			<input type="reset" value="重置">
			<input type="button" value="返回" id="button2">
		</p>
		<p style="color: red">${error}</p>
	</form>

</body>
</html>