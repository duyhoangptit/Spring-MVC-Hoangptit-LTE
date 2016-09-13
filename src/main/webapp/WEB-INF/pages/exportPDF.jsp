<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="content-wrapper">
    <table border="1px" cellpadding="8px">
        <tr>
            <td>Month</td>
            <td>Revenue</td>
        </tr>

        <c:forEach items="${revenueData}" var="current">
            <tr>
                <td><c:out value="${current.key}"/></td>
                <td><c:out value="${current.value}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>