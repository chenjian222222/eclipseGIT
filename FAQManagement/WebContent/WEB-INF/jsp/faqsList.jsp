<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
ul{
	list-style-type: none;
	margin-left: 650px;
}
li{
	float:left;
	list-style: none;
	margin-left: 10px;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("tr:odd").css("background","#00FF00");
	})
	function page_nav(frm,num){
		frm.pageIndex.value = num;
		frm.submit();
	}
</script>
<body>
	<form action="faqsList" method="post">
		<input type="hidden" name="pageIndex" value="1" />
	
	<p align="center" style="font-size: 30px">常见问题检索</p>
	<p align="center">
		请输入查询的关键字：
		<input type="text" name="queryTitle" value="${queryTitle}"/>
		<input type="submit" value="查询"/>
		<a href="faqsAdd">添加常见问题</a>
	</p>
	<c:if test="${fn:length(faqsList)>0}">
		<table align="center">
			<tr>
				<td>编号</td>
				<td>标题</td>
				<td>分类</td>
				<td>创建时间</td>
			</tr>
			<c:forEach var="faqs" items="${faqsList}" varStatus="status">
				<tr class="odd">
					<td>${status.index + 1}</td>
					<td><a href="${pageContext.request.contextPath}/faqsView?id=${faqs.id}" >${faqs.title}</a></td>
					<td>${faqs.cname}</td>
					<td><fmt:formatDate value="${faqs.createdate }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${fn:length(faqsList)==0}">
		<p align="center" style="font-size: 20px">没有找到"${queryTitle}"的相关内容</p>
		<p align="center" style="font-size: 20px">请修改关键词后重试</p>
	</c:if>
	<p align="center">
		共${pages.totalCount }条记录
		${pages.currentPageNo }/${pages.totalPageCount }页
	</p>
	<ul>
		<c:if test="${pages.currentPageNo > 1}">
			<li><a href="javascript:page_nav(document.forms[0],1);">首页</a>
			</li>
			<li ><a href="javascript:page_nav(document.forms[0],${pages.currentPageNo-1});">上一页</a>
			</li>
		</c:if>
		<c:if test="${pages.currentPageNo < pages.totalPageCount }">
			<li><a href="javascript:page_nav(document.forms[0],${pages.currentPageNo+1 });">下一页</a>
			</li>
			<li><a href="javascript:page_nav(document.forms[0],${pages.totalPageCount });">最后一页</a>
			</li>
		</c:if>
	</ul>
	</form>
</body>
</html>