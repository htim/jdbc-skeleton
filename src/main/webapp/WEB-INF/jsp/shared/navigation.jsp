<%@include file="header.jsp" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Car Service</a>
        </div>
        <ul class = "nav navbar-nav">
            <li class = "active"> <a href="/">Home</a> </li>
            <li><a href="/cars">Cars</a> </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${empty user}">
                <li>
                    <a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a>
                </li>
            </c:if>
            <c:if test="${not empty user}">
                <li>
                    <a href="/me">${user.login}</a>
                </li>
                <li>
                    <a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>