$(function(){
    var $loginForm = $("#loginForm");

    $loginForm.submit(function() {
        var data = $loginForm.serialize();
        console.log(data);
        edop.ajax({
            type: "GET",
            url: "/sms/login/doLogin",
            async: true,
            timeout: 200000,
            dataType: 'json',
            data: data,
            success: function(rest) {
                if (rest.success) {
                    console.log(rest.content);
                    window.location.href = 'main.html'
                } else {
                    edop.edopConfirm(rest.content, "error");
                }
            },
            error: function(rest) {
                return null;
            }
        });
    });
})