<!DOCTYPE html>

<html lang="en">

<body>
    <form action="login" method="POST">
        <div class="form-group has-feedback">
            <input name="userName" type="text" class="form-control" placeholder="用户名"/>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <input name="password" type="password" class="form-control"/>
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="row">
            <!-- /.col -->
            <div class="col-xs-12">
                <button type="submit" class="btn btn-primary btn-block btn-flat">登 录</button>
            </div>
            <!-- /.col -->
        </div>
    </form>
</body>

</html>
