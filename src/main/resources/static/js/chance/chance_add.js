$(function () {
    function showChanceList() {
        $.ajax({
            url: "../chance/list",
            data: {pageNo: 1, pageSize: 2},
            type: "get",
            dataType: "json",
            success: function (data) {
                console.log('length;' + data.data.list.length);
                for (var i = 0; i < data.data.list.length; i++) {
                    var html = '<tr>'
                        + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                        + '<td>#{chance_name}</td>'
                        + '<td>#{client_name}</td>'
                        + '<td>#{stage}</td>'
                        + '<td>#{possibility}</td>'
                        + '<td>#{address}</td>'
                        + '<td>#{money}</td>'
                        + '<td>#{date_time}</td>'
                        + '<td>#{transaction_status}</td>'
                        + '<td>#{auth}</td>'
                        + '<td>#{time}</td>'
                        + '</tr>';

                    html = html.replace("#{cusId}", "cus"+i);
                    html = html.replace("#{chance_name}", data.data.list[i].chanceName);
                    html = html.replace("#{client_name}", data.data.list[i].clientName);
                    html = html.replace("#{stage}", data.data.list[i].stage);
                    html = html.replace("#{possibility}", data.data.list[i].possibility);
                    html = html.replace("#{address}", data.data.list[i].address);
                    html = html.replace("#{money}", data.data.list[i].money);
                    html = html.replace("#{date_time}", data.data.list[i].dateTime);
                    html = html.replace("#{transaction_status}", data.data.list[i].transactionStatus);
                    html = html.replace("#{auth}", data.data.list[i].auth);
                    html = html.replace("#{time}", data.data.list[i].time);
                    $("#chance_td").append(html);
                    localStorage.setItem("cus" + i, JSON.stringify(data.data.list[i]))
                }

                $(".M-box").pagination({
                    pageCount: data.data.pages,   //总页码ajax中的pages总页
                    coping: true,                 //是否开启首页和末页
                    jump: true,                   //是否开启跳页
                    homePage: '首页',
                    endPage: '末页',
                    prevContent: '上页',
                    nextContent: '下页',
                    current: data.data.pageNo,
                    callback: function (api) {
                        $("#client_td").empty();
                        $.ajax({
                            url: "../chance/List",
                            data: {pageNo: api.getCurrent(), pageSize: 2},
                            type: "get",
                            dataType: "json",
                            success: function (data) {
                                for (var i = 0; i < data.data.list.length; i++) {
                                    var html = '<tr>'
                                        + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                                        + '<td>#{chance_name}</td>'
                                        + '<td>#{client_name}</td>'
                                        + '<td>#{stage}</td>'
                                        + '<td>#{possibility}</td>'
                                        + '<td>#{address}</td>'
                                        + '<td>#{money}</td>'
                                        + '<td>#{date_time}</td>'
                                        + '<td>#{transaction_status}</td>'
                                        + '<td>#{auth}</td>'
                                        + '<td>#{time}</td>'
                                        + '</tr>';

                                    html = html.replace("#{cusId}", "cus"+i);
                                    html = html.replace("#{chance_name}", data.data.list[i].chanceName);
                                    html = html.replace("#{client_name}", data.data.list[i].clientName);
                                    html = html.replace("#{stage}", data.data.list[i].stage);
                                    html = html.replace("#{possibility}", data.data.list[i].possibility);
                                    html = html.replace("#{address}", data.data.list[i].address);
                                    html = html.replace("#{money}", data.data.list[i].money);
                                    html = html.replace("#{date_time}", data.data.list[i].dateTime);
                                    html = html.replace("#{transaction_status}", data.data.list[i].transactionStatus);
                                    html = html.replace("#{auth}", data.data.list[i].auth);
                                    html = html.replace("#{time}", data.data.list[i].time);
                                    $("#chance_td").append(html);
                                    localStorage.setItem("cus" + i, JSON.stringify(data.data.list[i]))
                                }
                            }
                        });
                    }
                });

            }
        })
    }

    showChanceList(6)
});

$("#chance_btn").click(function () {
    var formData = $("#chance_add").serialize(); //取表单值 并进行序列化；此时formData已经是乱码了
    formData = decodeURIComponent(formData, true);
    console.log(formData);
    $.ajax({
        url: "../chance/insert",
        data: formData,
        type: "POST",
        dataType: "json",
        success: function (json) {
            if (json.code == 0){
                var html = '<tr>'
                    + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input type="checkbox" name="checkbox"/></td>'
                    + '<td>#{chance_name}</td>'
                    + '<td>#{client_name}</td>'
                    + '<td>#{stage}</td>'
                    + '<td>#{possibility}</td>'
                    + '<td>#{address}</td>'
                    + '<td>#{money}</td>'
                    + '<td>#{date_time}</td>'
                    + '<td>#{transaction_status}</td>'
                    + '<td>#{auth}</td>'
                    + '<td>#{time}</td>'
                    + '</tr>';

                html = html.replace("#{chance_name}", $("#chanceName").val());
                html = html.replace("#{client_name}", $("#clientName").val());
                html = html.replace("#{stage}", $("#stage").val());
                html = html.replace("#{possibility}", $("#possibility").val());
                html = html.replace("#{address}", $("#address").val());
                html = html.replace("#{money}", $("#money").val());
                html = html.replace("#{date_time}", $("#dateTime").val());
                html = html.replace("#{transaction_status}", $("#transaction_status").val());
                html = html.replace("#{auth}", $("#auth").val());
                html = html.replace("#{time}", $("#time").val());
                $("#chance_td").append(html);
                $("#cus_chance_add").modal("hide");
            } else {
                alert(json.message);
            }
        }
    });
});

$("#update").click(function () {
    var length = 0;
    var checkId = "";
    //所有的checkbox的list集合
    var checkbox = document.getElementsByName("checkbox");

    //所以我需要先去判断现在的check到底有多少个
    //一个继续干   多个不干   没有不干
    for (var i = 0; i < checkbox.length; i++) {
        if( checkbox[i].checked){
            length++;
            checkId = checkbox[i];
        }
    }
    if(length <= 0 || length > 1 ){
        alert("请选择单条数据操作!!!")
        checkId = "";
        return;
    }else{
        $("#cus_chance_alter").modal("show")
        //获取当前被check的id  获取数据
        var data = JSON.parse(localStorage.getItem(checkId.id));
        $("#chanceid").val(data.chanceid);
        $("#chance_name").val(data.chanceName);
        $("#client_name").val(data.clientName);
        switch(data.type){
            case "A":
                $("#chance_type").val("A 合作");break;
            case "B":
                $("#chance_type").val("B 外包");break;
            case "C":
                $("#chance_type").val("C 投包");break;
            case "D":
                $("#chance_type").val("D 渠道");break;
            default:"数据有误";
        }
        switch(data.source){
            case "A":
                $("#chance_source").val("A 客户主动联系");break;
            case "B":
                $("#chance_source").val("B 网上搜索渠道");break;
            case "C":
                $("#chance_source").val("C 市场业务");break;
            case "D":
                $("#chance_source").val("D 广告宣传");break;
            case "E":
                $("#chance_source").val("E 招标");break;
            case "F":
                $("#chance_source").val("F 外包网站");break;
            default:"数据有误";
        }
        $("#date_time").val(data.dateTime);
        $("#chance_money").val(data.money);
        switch(data.stage){
            case "A":
                $("#chane_stage option").eq(1).val("A 初步沟通");break;
            case "B":
                $("#chane_stage option").eq(2).val("B 立项评估");break;
            case "C":
                $("#chane_stage option").eq(3).val("C 需求分析");break;
            case "D":
                $("#chane_stage option").eq(4).val("D 解决方案");break;
            case "E":
                $("#chane_stage option").eq(5).val("E 已报价");break;
            case "F":
                $("#chane_stage option").eq(6).val("F 商务谈判");break;
            case "G":
                $("#chane_stage option").eq(7).val("F 合同 / 订单签订");break;
            default:"数据有误";
        }
        $("#chance_possibility").val(data.possibility);

        switch(data.possibility){
            case 0:
                $("#chance_possibility option").eq(1).val("0%");break;
            case 10:
                $("#chance_possibility option").eq(2).val("10%");break;
            case 20:
                $("#chance_possibility option").eq(3).val("20%");break;
            case 30:
                $("#chance_possibility option").eq(4).val("30%");break;
            case 40:
                $("#chance_possibility option").eq(5).val("40%");break;
            case 50:
                $("#chance_possibility option").eq(6).val("50%");break;
            case 60:
                $("#chance_possibility option").eq(7).val("60%");break;
            case 70:
                $("#chance_possibility option").eq(8).val("70%");break;
            case 80:
                $("#chance_possibility option").eq(9).val("80%");break;
            case 90:
                $("#chance_possibility option").eq(10).val("90%");break;
            case 100:
                $("#chance_possibility option").eq(11).val("100%");break;
            default:"数据有误";
        }
        $("#chance_cribe").val(data.cribe);
        $("#chance_remarks").val(data.remarks);
        //数据key 与对应的 id 进行数据绑定  包含cusId
        //提交整个ajax请求到后台 包含cusId
    }
});

$("#update_sub").click(function () {
    var forData = $("#chance_update").serialize();
    forData = decodeURIComponent(forData, true);
    $.ajax({
        url: "../chance/update",
        data: forData,
        type: "POST",
        dataType: "json",
        async:true,
        success: function (json) {
            if (json.code == 0) {
                //修改完成后
                //模态框隐藏   $("#cus_chance_alter").modal("hide")
                $("#cus_chance_alter").modal("hide");
                //局部页面刷新
                window.location.reload(true);
            } else {
                alert(json.message);
            }
        }
    })

})

$("#delete_btn").click(function () {
  var checkboxs=document.getElementsByName("checkbox");
    for (var i = 0; i < checkboxs.length; i++) {
        if( checkboxs[i].checked){
            length++;
            checkId = checkboxs[i];
        }
    }
    if(length <= 0 || length > 1 ){
        alert("请选择单条数据操作!!!")
        checkId = "";
        return;
    }else {
        var data = JSON.parse(localStorage.getItem(checkId.id));
        var checkid= data.chanceid;
        $.ajax({
            url: "../chance/delete/"+checkid,
            type: "POST",
            dataType: "json",
            async:true,
            success: function (json) {
                if (json.code == 0) {
                alert("删除成功");
                    $("#cus_chance_delete").modal("hide");
                    //局部页面刷新
                    window.location.reload(true);
                }else{
                    alert("删除失败");
                }
            }
        });
    }
});