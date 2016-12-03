<%--
  Created by IntelliJ IDEA.
  User: zxk175
  Date: 16/11/13
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="icon" type="image/x-icon" href="../icon/favicon_64.ico"/>
    <link rel="shortcut icon" type="image/x-icon" href="../icon/favicon_64.ico"/>
    <title>${page_title}</title>
    <!-- jQuery -->
    <script type="text/javascript" src="../dependents/jquery/jquery.min.js"></script>
    <!-- bootstrap -->
    <script type="text/javascript" src="../dependents/bootstrap/js/bootstrap.js"></script>
    <link type="text/css" rel="stylesheet" href="../dependents/bootstrap/css/bootstrap.min.css">
    <!-- bootstrap-table -->
    <script type="text/javascript" src="../dependents/bootstrap-table/1.9.1/bootstrap-table.js"></script>
    <script type="text/javascript" src="../dependents/bootstrap-table/1.9.1/bootstrap-table-locale-all.js"></script>
    <link rel="stylesheet" type="text/css" href="../dependents/bootstrap-table/1.9.1/bootstrap-table.css"/>
    <!--[if lt IE 9]>
    <script src="../dependents/bootstrap/plugins/ie/html5shiv.js"></script>
    <script src="../dependents/bootstrap/plugins/ie/respond.js"></script>
    <![endif]-->
    <!--[if lt IE 8]>
    <script src="../dependents/bootstrap/plugins/ie/json2.js"></script>
    <![endif]-->
    <!-- font-awesome -->
    <link rel="stylesheet" type="text/css" href="../dependents/fontAwesome/css/font-awesome.min.css" media="all"/>
    <!-- layer -->
    <script type="text/javascript" src="../dependents/layer/layer.js"></script>
    <!-- laydate -->
    <link rel="stylesheet" type="text/css" href="../dependents/laydate/need/laydate.css"/>
    <script type="text/javascript" src="../dependents/laydate/laydate.js"></script>
    <!-- base -->
    <link rel="stylesheet" href="../css/base.css">
</head>
<body>

<div class="container-fluid">
    <input type="text" id="date" class="laydate-icon" style="margin: 10px 0;">

    <h4>查询条件</h4>
    <div class="row-fluid">
        <div class="span12">
            <div class="control-group form-inline" style="border: 1px solid #ccc;padding: 10px; border-radius: 3px;">
                <div class="input-group input-group-sm">
                    <label for="name">用户名称</label>
                    <input id="name" type="text">
                </div>
                <div class="input-group input-group-sm">
                    <label for="sex">性别</label>
                    <select id="sex">
                        <option value="-1">全部</option>
                        <option value="1">男</option>
                        <option value="0">女</option>
                    </select>
                </div>
                <button id="btn_search" type="button" class="btn btn-primary btn-sm">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                </button>
                <button id="btn_clean_search" type="button" class="btn btn-danger btn-sm">清空条件</button>
            </div>
        </div>
    </div>

    <div id="toolbar" class="btn-group">
        <!-- 工具栏 -->
        <button id="btn_add" type="button" class="btn btn-default btn-sm">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
        </button>
        <button id="btn_delete" type="button" class="btn btn-default btn-sm">
            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除
        </button>
        <button id="btn_refresh" type="button" class="btn btn-default btn-sm">
            <span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>刷新
        </button>
        <button id="btn_clean" type="button" class="btn btn-default btn-sm">清空</button>
        <button id="btn_init" type="button" class="btn btn-default btn-sm">初始化</button>
        <button id="btn_toggleview" type="button" class="btn btn-default btn-sm">切换视图</button>
        <button id="btn_togglepage" type="button" class="btn btn-default btn-sm">显隐分页</button>
        <button id="btn_selectpage" type="button" class="btn btn-default btn-sm">跳转</button>
    </div>

    <!-- 表格 -->
    <table id="users" class="table table-hover"></table>

    <!-- 新增或修改弹框 -->
    <div class="modal fade" id="addAndUpdate" tabindex="-1" role="dialog" aria-labelledby="addAndUpdateLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">×</span></button>
                    <h4 class="modal-title" id="addAndUpdateLabel">新增用户信息</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="txt_type" class="form-control" id="txt_type" placeholder="操作类型">
                    <input type="hidden" name="txt_id" class="form-control" id="txt_id" placeholder="编号">
                    <div class="form-group">
                        <label for="txt_name">名称</label>
                        <input type="text" name="txt_name" class="form-control" id="txt_name" placeholder="名称">
                    </div>
                    <div class="form-group">
                        <label class="control-label">性别</label>
                        <div class="controls">
                            <input id="p_man" type="radio" name="sex" value="1" checked/>
                            <label for="p_man" style="margin-right: 30px;">男</label>
                            <input id="p_woman" type="radio" name="sex" value="0"/>
                            <label for="p_woman">女</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txt_pwd">密码</label>
                        <input type="password" name="txt_pwd" class="form-control" id="txt_pwd" placeholder="密码">
                    </div>
                    <div class="form-group">
                        <label for="txt_email">邮箱</label>
                        <input type="text" name="txt_email" class="form-control" id="txt_email" placeholder="邮箱">
                    </div>
                    <div class="form-group">
                        <label for="txt_phone">手机</label>
                        <input type="text" name="txt_phone" class="form-control" id="txt_phone" placeholder="名称">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><span
                            class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
                    </button>
                    <button type="button" id="btn_add_update_submit" class="btn btn-primary btn-sm"
                            data-dismiss="modal"><span
                            class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="../js/laydate.js"></script>
<script type="text/javascript" src="../js/table.js"></script>
<script type="text/javascript" src="../js/table_crud.js"></script>
</body>
</html>
