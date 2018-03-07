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
        <h4 class="box-title">検索条件</h4>
        <form role="form">
            <div class="box-body">
                <div class="row">
                    <!-- text input -->
                    <div class="form-group  col-xs-6">
                        <label>模块ID</label> <input id="ipt_coupinName" type="text" class="form-control"
                                                   placeholder="Enter Coupon Name ...">
                    </div>
                    <!-- select -->
                    <div class="form-group col-xs-6">
                        <label>父模块ID</label> <select id="sel_cates" class="form-control">
                        <option value="0"></option>
                    </select>
                    </div>

                </div>

                <button id="btn_select" type="button" class="btn btn-primary pull-right">SELECT</button>
                <button id="btn_ins" type="button" class="btn btn-primary pull-right" data-toggle="modal"
                        data-target="#modal-default" style="margin-right: 20px">
                    ADD
                </button>
            </div>
        </form>
        <h4 class="box-title">検索结果</h4>
        <div class="col-xs-13">
            <table id="t_coupon" class="table table-bordered table-hover" width="100%">
                <thead>
                <tr>
                    <th>moduleId</th>
                    <th>moduleName</th>
                    <th>parentId</th>
                    <th>moduleLevel</th>
                    <th>moduleUrl</th>
                    <th>moduleImg</th>
                    <th>moduleRank</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
            </table>
        </div>

        <div class="modal fade" id="modal-default">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 id="mod_title" class="modal-title"></h4>
                    </div>
                    <div class="modal-body box-warning">
                        <!-- /.box-header -->
                        <div class="box-body">
                            <form role="form" id="form_module">
                                <!-- text input -->
                                <!-- select -->
                                <div class="form-group">
                                    <label>ParentId</label> <select id="sel_pid" class="form-control" name="parentId">
                                    <option value="0"></option>
                                </select>
                                </div>
                                <div class="form-group">
                                    <label>moduleId</label>
                                    <input id="ipt_moduleId" type="text" class="form-control" name="moduleId"
                                           placeholder="Enter ...">
                                </div>
                                <div class="form-group">
                                    <label>moduleName</label>
                                    <input id="ipt_moduleName" type="text" class="form-control" name="moduleName"
                                           placeholder="Enter ...">
                                </div>
                                <div class="form-group">
                                    <label>moduleUrl</label>
                                    <input id="ipt_moduleUrl" type="text" class="form-control" name="moduleUrl"
                                           placeholder="Enter ...">
                                </div>
                                <div class="form-group">
                                    <label>moduleImg</label>
                                    <div class="input-group input-group-sm">
                                        <input id="ipt_moduleImg" type="text" class="form-control" name="moduleImg">
                                        <span class="input-group-btn">
                                            <a type="button" class="btn btn-info btn-flat" href="${ctx}/images"
                                               target="_blank">Reference</a>
                                         </span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>moduleLevel</label> <select id="sel_moduleLevel" name="moduleLevel"
                                                                       class="form-control">
                                    <option value="FUNCTION">FUNCTION</option>
                                    <option value="URL">URL</option>
                                </select>
                                </div>
                                <div class="form-group">
                                    <label>moduleRank</label>
                                    <input id="ipt_moduleRank" type="text" class="form-control" name="moduleRank"
                                           placeholder="Enter ...">
                                </div>
                                <div class="form-group">
                                    <label>DeleteFlag</label> <select id="sel_deleteFlg" name="deleteFlag"
                                                                      class="form-control">
                                    <option value="0">ABLE</option>
                                    <option value="1">DISABLE</option>
                                </select>
                                </div>
                            </form>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" id="btn_save">Save changes</button>
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

<!-- DataTables -->
<script src="${ctx}/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${ctx}/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>

<script type="text/javascript">

    $(function () {
        $('.box').boxWidget()
        parentModuleId();
        initTable();

    })

    $('#btn_ins').click(function () {
        $("#mod_title").text("新增模块");
        clearModule();
        initModel();
    });

    $('#btn_select').click(function () {
        initTable();
    });

    $('#btn_save').click(function () {
        saveModule();
    });

    function initTable() {
        //初始化表格
        $('#t_coupon')
                .dataTable(
                        {
                            "ordering": false,
                            "processing": true,
                            "searching": false,
                            "serverSide": true,
                            "destroy": true,
                            "scrollX": true,
                            "ajax": {
                                "type": "POST",
                                "url": "${ctx}/system/module/list"
                            },
                            "columns": [{
                                "data": "moduleId"
                            }, {
                                "data": "moduleName"
                            }, {
                                "data": "parentId"
                            }, {
                                "data": "moduleLevel"
                            }, {
                                "data": "moduleUrl"
                            }, {
                                "data": "moduleImg"
                            }, {
                                "data": "moduleRank"
                            }, {
                                "data": "moduleId"
                            }, {
                                "data": "deleteFlag"
                            }], "columnDefs": [
                            {
                                "targets": -1,
                                "data": "deleteFlag",
                                "render": function (data, type, row,
                                                    meta) {

                                    if (data == "0") {
                                        return '<a class="btn btn-danger" type="button"  href="#" id="btn_del" onclick="deleteModule('
                                                + row.moduleId
                                                + ')" >削除</a>';
                                    }
                                }
                            }, {
                                "targets": -2,
                                "data": "moduleId",
                                "render": function (data, type, row,
                                                    meta) {

                                    return '<a class="btn btn-warning"  data-toggle="modal" data-target="#modal-default" type="button"  href="#" id="btn_edt" onclick="editModule(\''
                                            + row.moduleId
                                            + '\')" >Edit</a>';

                                }
                            }, {
                                "targets": -4,
                                "data": "moduleImg",
                                "render": function (data, type, row,
                                                    meta) {

                                    return '<div class="row" style="margin:1px"><i class="fa fa-fw '
                                            + row.moduleImg
                                            + '"></i>' + row.moduleImg + '</div>';

                                }
                            }]
                        });
    }

    function initModel() {
        $.ajax({
            type: "GET",
            url: "${ctx}/system/module/parentIds",
            async: false,
            success: function (data) {
                $("#sel_pid").find("option").not(":first").remove()
                $.each(data, function (i) {
                    $(
                            "<option value='" + data[i].moduleId + "'>"
                            + data[i].moduleName
                            + "</option>").appendTo("#sel_pid");
                })
            },
            error: function () {

            }
        });
    }

    function parentModuleId() {
        $.ajax({
            type: "GET",
            url: "${ctx}/system/module/parentIds",
            async: false,
            success: function (data) {
                $.each(data, function (i) {
                    $(
                            "<option value='" + data[i].moduleId + "'>"
                            + data[i].moduleName
                            + "</option>").appendTo("#sel_cates");
                })
            },
            error: function () {
                alert("Get the Model ParentIds Ajax failed");
            }
        });
    }

    function editModule(editId) {
        $("#mod_title").text("Edit Module");
        initModel();
        $.ajax({
            type: "POST",
            url: "${ctx}/system/module/module",
            data: {"moduleId": editId},

            success: function (data) {
                alert(JSON.stringify(data))
                $("#sel_pid").val(data.parentId);
                $('#ipt_moduleId').val(data.moduleId);
                $('#ipt_moduleName').val(data.moduleName);
                $('#ipt_moduleUrl').val(data.moduleUrl);
                $('#sel_moduleLevel').val(data.moduleLevel);
                $('#ipt_moduleRank').val(data.moduleRank);
                $('#ipt_moduleImg').val(data.moduleImg);
                $('#sel_deleteFlg').val(data.deleteFlag);
            },
            error: function () {
                alert("Edit the Module Ajax failed");
            }
        });
    }

    function saveModule() {
        //获得值
        var parentId = $("#sel_pid").val();
        var moduleId = $('#ipt_moduleId').val();
        var moduleName = $('#ipt_moduleName').val();
        var moduleUrl = $('#ipt_moduleUrl').val();
        var moduleLevel = $('#sel_moduleLevel').val();
        var moduleImg = $('#ipt_moduleImg').val();
        var moduleRank = $('#ipt_moduleRank').val();
        var deleteFlag = $('#sel_deleteFlg').val();
        var updateBy = '${Session.CURRENT_USER.userId!""}';

        $.ajax({
            type: "POST",
            url: "${ctx}/system/module/save",
            data: {
                "moduleId": moduleId,
                "moduleName": moduleName,
                "parentId": parentId,
                "moduleUrl": moduleUrl,
                "moduleLevel": moduleLevel,
                "moduleImg": moduleImg,
                "moduleRank": moduleRank,
                "deleteFlag": deleteFlag,
                "updateBy": updateBy
            },
            success: function (data) {
                alert(JSON.stringify(data))
                if (data.ret == 1) {
                    alert("Changes Saved Successfully");
                } else {
                    alert("Changes Saved Failed");
                }
                $('#modal-default').modal('hide')
                initTable()
            },
            error: function (data) {
                alert(JSON.stringify(data))
            }

        });
    }

    function clearModule() {
        $("#sel_pid").val("");
        $('#ipt_moduleId').val("");
        $('#ipt_moduleName').val("");
        $('#ipt_moduleUrl').val("");
        $('#sel_moduleLevel').val("");
        $('#ipt_moduleRank').val("");
        $('#ipt_moduleImg').val("");
        $('#sel_deleteFlg').val("");
    }
</script>