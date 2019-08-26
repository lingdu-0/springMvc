<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/18
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
账户:<input id="name"/><br/>
密码:<input type="password" id="password"/><br/>
<input type="button" id="submit" value="登录"><br/>
<script>
    window.onload = function () {
        $('#submit').click(function () {
            var name = $('#name').val();
            var password = $('#password').val();
            if (name.length != 0 && password.length != 0) {
                var sendData = {};
                sendData.name = name;
                sendData.password = password;
                $.ajax({
                    url: "login",
                    type: "post",
                    contentType: "application/json",
                    data: JSON.stringify(sendData),
                    dataType: 'json',
                    error: function () {
                        alert("请求失败");
                    },
                    success: function (data) {
                        if (data.msgResult) {
                            alert(data.msg);
                        } else {
                            alert(data.msg);
                        }
                    }
                });
            } else {
                alert("输入不能为空!");
            }
        });
    }
</script>

</body>
</html>
