<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html lang="en">

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        账本
        <small>创建账本</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 账本</a></li>
        <li class="active">创建账本</li>
    </ol>
</section>

<!-- Main content -->
<section class="content container-fluid">
    <div class="box box-warning">
        <div class="box-header with-border">
            <h3 class="box-title">创建账本</h3>
        </div>
        <!-- /.box-header -->
        <div class="box-body">
            <form role="form" id="form_account">
                <!-- text input -->
                <div class="form-group">
                    <label>账本名称</label>
                    <input type="text" class="form-control" name="accountName" placeholder="Enter ...">
                </div>

                <div class="box-footer">
                    <button id="btn_create" type="button" class="btn btn-info pull-right">Create</button>
                </div>
            </form>
        </div>
    </div>

</section>
<!-- /.content -->

<script type="text/javascript">

    $(function() {
        $("#btn_create").click(function() {
            $.ajax({
                type : "POST",
                url : "${ctx}/money/account/create",
                data : $('#form_account').serialize(),
                success : function(msg) {
                    alert(JSON.stringify(msg));
                },
                error : function(msg) {
                    alert(JSON.stringify(msg));
                }
            });
        });

    });




</script>