handleBtnCarMore = function(e) {
    var vin = e;
    $.ajax({url: "/api/cars/" + vin, success: function(result) {
        $(".modal-title").html(result.brand + ' ' + result.model);
        $(".modal-body").html(
            "<table class=\"table table-bordered\">\n" +
            "    <tbody>\n" +
            "      <tr>\n" +
            "        <td>Brand</td>\n" +
            "        <td>" + result.brand + "</td>\n" +
            "      </tr>\n" +
            "      <tr>\n" +
            "        <td>Model</td>\n" +
            "        <td>" + result.model + "</td>\n" +
            "      </tr>\n" +
            "      <tr>\n" +
            "        <td>Country</td>\n" +
            "        <td>" + result.country + "</td>\n" +
            "      </tr>\n" +
            "      <tr>\n" +
            "        <td>Price</td>\n" +
            "        <td>" + result.price + "</td>\n" +
            "      </tr>\n" +
            "    </tbody>\n" +
            "  </table>"
        );
        $("#car-more-info").modal('show');
    }})

}