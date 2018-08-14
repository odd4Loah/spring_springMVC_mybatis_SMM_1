<%--
  Created by IntelliJ IDEA.
  User: lihoo
  Date: 2018/8/13
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%--使用@taglib指令添加json的标签库json-taglib--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>--%>
<%@ include file="../includes/includes.jsp" %>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body>



<json:object escapeXml="false">
    <json:property name="code" value="200"></json:property>
    <%--<json:property name="code" value="${code}"></json:property>--%>
    <json:property name="message">
        <%--<spring:message code="man"/>--%>
        <%--<spring:message code="${code}"/>--%>
    </json:property>
    <json:property name="total" value="144"/>
    <%--<json:property name="total" value="${total}"/>--%>
    <json:array name="data">

        <%----%>
        <%--<c:forEach items="${articleList}" var="article">--%>
            <%--<json:object>--%>
                <%--<json:property name="id" value="${article.id}"/>--%>
                <%--<json:property name="title" value="${article.title}"/>--%>
                <%--<json:property name="img" value="${article.img}"/>--%>
                <%--<json:property name="digest" value="${article.digest}"/>--%>
                <%--<json:property name="author" value="${article.author}"/>--%>
                <%--<json:property name="collection" value="${article.collection}"/>--%>
                <%--<json:property name="praise" value="${article.collection}"/>--%>
                <%--<json:property name="status" value="${article.status}"/>--%>
                <%--<json:property name="content" value="${article.content}"/>--%>
                <%--<json:property name="createBy" value="${article.createBy}"/>--%>
                <%--<json:property name="createAt" value="${article.createAt}"/>--%>
                <%--<json:property name="updateAt" value="${article.updateAt}"/>--%>
                <%--<json:property name="updateBy" value="${article.updateBy}"/>--%>
            <%--</json:object>--%>
        <%--</c:forEach>--%>



        <c:forEach items="${stus}" var="s" varStatus="st">
            <json:object>
                <json:property name="id" value="${s.id}"/>
                <json:property name="username" value="${s.username}"/>
                <json:property name="qq_num" value="${s.qq_num}"/>
                <json:property name="study_type" value="${s.study_type}"/>
                <json:property name="study_time" value="${s.study_time}"/>
                <json:property name="school" value="${s.school}"/>
                <json:property name="study_id" value="${s.study_id}"/>
                <json:property name="daily_link" value="${s.daily_link}"/>
                <json:property name="promise" value="${s.promise}"/>
                <json:property name="teach_bro" value="${s.teach_bro}"/>
                <json:property name="know_us_from" value="${s.know_us_from}"/>
                <json:property name="create_at" value="${s.create_at}"/>
                <json:property name="update_at" value="${s.update_at}"/>
            </json:object>
        </c:forEach>




    </json:array>
</json:object>







</body>
</html>
