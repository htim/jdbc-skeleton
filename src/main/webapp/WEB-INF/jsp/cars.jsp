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
                <td><button type="button" class="btn btn-info btn-md" onclick="handleBtnCarMore('${item.vin}')">Show more</button></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<div id="car-more-info" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title"></h4>
      </div>
      <div class="modal-body">
        <p>Some text in the modal.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>

<%@include file="shared/footer.jsp"%>