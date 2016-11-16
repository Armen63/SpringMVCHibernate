<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Person Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color: #737f02;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color: #181bff;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>


<c:url var="addAction" value="/address/add" ></c:url>

<form:form action="${addAction}" commandName="address">
    <table>
        <c:if test="${!empty address.address}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="PersonId" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="address">
                    <spring:message text="Address"/>
                </form:label>
            </td>
            <td>
                <form:input path="address" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty address.address}">
                    <input type="submit"
                           value="<spring:message text="Add Address"/>" />
                </c:if>
                <c:if test="${empty address.address}">
                    <input type="submit"
                           value="<spring:message text="Add Address"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

<h3>Address List</h3>
<c:if test="${!empty listAddress}">
    <table class="tg">
        <tr>
            <th width="80">Address ID</th>
            <th width="120">Address Name</th>

        </tr>
        <c:forEach items="${listAddress}" var="address">
            <tr>
                <td>${address.id}</td>
                <td>${address.address}</td>
               <%-- <td>${person.country}</td>
                <td><a href="<c:url value='/edit/${person.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/remove/${person.id}' />" >Delete</a></td>--%>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
