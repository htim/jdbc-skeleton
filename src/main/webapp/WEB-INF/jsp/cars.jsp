<%@include file="shared/navigation.jsp"%>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Brand</th>
        <th>Model</th>
        <th>Year</th>
        <th>Country</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${cars}" var="item">
            <tr>
                <td>${item.brand}</td>
                <td>${item.model}</td>
                <td>${item.date}</td>
                <td>${item.country}</td>
                <spring:url value="/cars/${item.vin}" var="carUrl"></spring:url>
                <td><a href="${carUrl}">More...</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>


<%@include file="shared/footer.jsp"%>