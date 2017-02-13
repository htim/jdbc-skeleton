<%@include file="shared/navigation.jsp"%>

<c:if test="${not empty user}">
    hello, ${user.login}
</c:if>

<%@include file="shared/footer.jsp"%>