<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html lang="en">

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        系统管理
        <small>模块</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i>Home</a></li>
        <li>系统管理</li>
        <li class="active">模块</li>
    </ol>
</section>
<section class="content">
<!-- /.box -->
<div id="div_list">


</div>
<div id="div_model">
</div>

</section>

<script type="text/javascript">
    $(function() {

        $('.box').boxWidget()

        $.ajax({
            type: "GET",
            url: "${ctx}/system/module/list/index",
            dataType: "html",
            success: function (data) {
                //返回数据根据结果进行相应的处理
                $("#div_list").html(data);
            },
            error: function () {
                $("#div_list").html("获取数据失败！");
            }
        });

        $.get( "${ctx}/system/module/model/index", function( data ) {
            $( "#div_model" ).html( data );
        });

    });

</script>