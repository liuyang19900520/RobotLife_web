<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html lang="en">

<div class="box">
    <div class="box-header with-border">
        <h3 class="box-title">模块列表功能</h3>
        <div class="box-tools pull-right">
            <!-- Collapse Button -->
            <button type="button" class="btn btn-box-tool" data-widget="collapse">
                <i class="fa fa-minus"></i>
            </button>
        </div>
        <!-- /.box-tools -->
    </div>
    <!-- /.box-header -->
    <div class="box-body">
        <div class="box box-default">
            <div class="box-header with-border">
                <h3 class="box-title">Modal Examples</h3>
            </div>
            <div class="box-body">
                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#modal-default">
                    Launch Default Modal
                </button>
                <button type="button" class="btn btn-info" data-toggle="modal" data-target="#modal-info">
                    Launch Info Modal
                </button>
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modal-danger">
                    Launch Danger Modal
                </button>
                <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modal-warning">
                    Launch Warning Modal
                </button>
                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#modal-success">
                    Launch Success Modal
                </button>
            </div>
        </div>

        <div class="modal fade" id="modal-default">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Default Modal</h4>
                    </div>
                    <div class="modal-body">

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>
    </div>
    <!-- /.box-body -->
    <div class="box-footer">
        The footer of the box
    </div>
    <!-- box-footer -->
</div>


<script type="text/javascript">

    $(function () {
        $('.box').boxWidget()

    })


</script>