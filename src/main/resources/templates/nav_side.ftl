<#assign ctx=request.contextPath />
<!DOCTYPE html>
<!-- Sidebar Menu -->
<li class="header">Navigation</li>

<#list modules as module>
    <#if module.childrenModule?size==0>
    <li id="${module.moduleId}" class="singleNavSide" title=${module.moduleUrl}><a href="#"><i class="fa fa-link"></i>
        <span>${module.moduleName}</span></a></li>
    <#else>
    <li class="treeview">
        <a href="#"><i class="fa fa-link"></i> <span>${module.moduleName}</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
        </a>
        <ul class="treeview-menu">
            <#list module.childrenModule as child>
                <li id="${module.moduleId}" class="singleNavSide" title=${child.moduleUrl}><a href="#"><i class="fa fa-circle-o"></i> ${child.moduleName}</a></li>
            </#list>
        </ul>
    </li>
    </#if>
</#list>
<!-- /.sidebar-menu -->

<script type="text/javascript">
    $(".singleNavSide").click(function () {
        var xxx = $(this).attr("title");
        alert(xxx);
        showAtRight("${ctx}"+xxx+"/index")
        $(this).addClass("active");
    });

</script>

