<%@include file="shared/navigation.jsp" %>

<form class="form-horizontal" method="post" action="/login">
    <spring:bind path="user.login">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="control-label col-sm-2" for="login">Login:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="login" name="login" required="required"
                       placeholder="Enter login"/>
            </div>
            <form:errors path="user.login"/>
        </div>
    </spring:bind>
    <spring:bind path="user.password">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="control-label col-sm-2" for="pwd">Password:</label>
            <div class="col-sm-6">
                <input type="password" class="form-control" id="pwd" name="password" required="required"
                       placeholder="Input password"/>
            </div>
            <form:errors path="user.password"/>
        </div>
    </spring:bind>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-6">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </div>
</form>

<%@include file="shared/footer.jsp" %>