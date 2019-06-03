$(function() {

    function getMsg() {
        $.ajax({
            url: "../client/selectPage",
            data: {pageNo: 1, pageSize: 2},
            type: "get",
            dataType: "json",
            success: function (data) {
                for (var i = 0; i < data.data.list.length; i++) {

                    var html = '<tr>'
                        + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                        + '<td>#{companyName}</td>'
                        + '<td>#{type}</td>'
                        + '<td>#{companyCity}</td>'
                        + '<td>#{address}</td>'
                        + '<td>#{source}</td>'
                        + '<td>#{tel}</td>'
                        + '<td>#{intention}</td>'
                        + '<td>#{status}</td>'
                        + '<td>#{linkName}</td>'
                        + '</tr>';

                    html = html.replace("#{cusId}", "cus" + i);
                    html = html.replace("#{companyName}", data.data.list[i].companyName);
                    html = html.replace("#{type}",$("#type").children().eq(data.data.list[i].type).html());
                    html = html.replace("#{companyCity}", data.data.list[i].companyCity);
                    html = html.replace("#{address}", data.data.list[i].address);
                    html = html.replace("#{source}",$("#source").children().eq(data.data.list[i].source).html());
                    html = html.replace("#{tel}", data.data.list[i].tel);
                    html = html.replace("#{intention}",data.data.list[i].intention);
                    html = html.replace("#{status}",$("#status").children().eq(data.data.list[i].status).html());
                    html = html.replace("#{linkName}", data.data.list[i].linkName);

                    $("#client_td").append(html);
                    localStorage.setItem("cus"+i,JSON.stringify(data.data.list[i]))
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
                            url: "../client/selectPage",
                            data: {pageNo: api.getCurrent(), pageSize: 2},
                            type: "get",
                            dataType: "json",
                            success: function (data) {
                                for (var i = 0; i < data.data.list.length; i++) {
                                        var html = '<tr>'
                                            + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                                            + '<td>#{companyName}</td>'
                                            + '<td>#{type}</td>'
                                            + '<td>#{companyCity}</td>'
                                            + '<td>#{address}</td>'
                                            + '<td>#{source}</td>'
                                            + '<td>#{tel}</td>'
                                            + '<td>#{intention}</td>'
                                            + '<td>#{status}</td>'
                                            + '<td>#{linkName}</td>'
                                            + '</tr>';

                                        html = html.replace("#{cusId}", "cus" + i);
                                    html = html.replace("#{companyName}", data.data.list[i].companyName);
                                    html = html.replace("#{type}",$("#type").children().eq(data.data.list[i].type).html());
                                    html = html.replace("#{companyCity}", data.data.list[i].companyCity);
                                    html = html.replace("#{address}", data.data.list[i].address);
                                    html = html.replace("#{source}",$("#source").children().eq(data.data.list[i].source).html());
                                    html = html.replace("#{tel}", data.data.list[i].tel);
                                    html = html.replace("#{intention}",data.data.list[i].intention);
                                    html = html.replace("#{status}",$("#status").children().eq(data.data.list[i].status).html());
                                    html = html.replace("#{linkName}", data.data.list[i].linkName);

                                    $("#client_td").append(html);
                                    localStorage.setItem("cus"+i,JSON.stringify(data.data.list[i]))
                                }
                            }
                            });
                            }
                        });

                    }
                })
            }
            getMsg(6)

})

$("#insert_btn").click(function () {
    var formData = $("#client_add").serialize(); //取表单值 并进行序列化；此时formData已经是乱码了
    formData = decodeURIComponent(formData, true);
    $.ajax({
        url: "../client/insert",
        data: formData,
        type: "POST",
        dataType: "json",
        async:true,
        success: function (json) {
            if (json.code == 0) {
                var html = '<tr>'
                    + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input type="checkbox" name="checkbox"/></td>'
                    + '<td>#{companyName}</td>'
                    + '<td>#{type}</td>'
                    + '<td>#{companyCity}</td>'
                    + '<td>#{address}</td>'
                    + '<td>#{source}</td>'
                    + '<td>#{tel}</td>'
                    + '<td>#{intention}</td>'
                    + '<td>#{status}</td>'
                    + '<td>#{linkName}</td>'
                    + '</tr>';

                html = html.replace("#{companyName}", $("#companyName").val());
                html = html.replace("#{type}", $("#type").val());
                html = html.replace("#{companyCity}", $("#companyCity").val());
                html = html.replace("#{address}", $("#address").val());
                html = html.replace("#{source}", $("#source").val());
                html = html.replace("#{tel}", $("#tel").val());
                html = html.replace("#{intention}", $("#intention").val());
                html = html.replace("#{status}", $("#status").val());
                html = html.replace("#{linkName}", $("#linkName").val());
                $("#client_td").append(html);
                $("#cus_all_add").modal("hide");
                window.location.reload(true);
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
        $("#cus_all_alter").modal("show")
        //获取当前被check的id  获取数据
        var data = JSON.parse(localStorage.getItem(checkId.id));
        $("#linkId").val(data.linkId);
        $("#id").val(data.id);
        $("#access_time").val(data.accessTime);
        $("#company_name").val(data.companyName);
        $("#company_city").val(data.companyCity);
        $("#client_intention").val(data.intention);
        $("#client_tel").val(data.tel);
        switch(data.industry){
            case 1:
                $("#client_industry option").eq(1).attr("selected","农、林、牧、渔业");break;
            case 2:
                $("#client_industry option").eq(2).attr("selected","采矿业");break;
            case 3:
                $("#client_industry option").eq(3).attr("selected","制造业");break;
            case 4:
                $("#client_industry option").eq(4).attr("selected","电力生产和供应");break;
            case 5:
                $("#client_industry option").eq(5).attr("selected","建筑业");break;
            case "6":
                $("#client_industry option").eq(6).attr("selected","交通运输、仓储和邮政");break;
            case 7:
                $("#client_industry option").eq(7).attr("selected","计算机服务和软件业");break;
            case 8:
                $("#client_industry option").eq(8).attr("selected","批发和零售");break;
            case 9:
                $("#client_industry option").eq(9).attr("selected","住宿和餐饮业");break;
            case 10:
                $("#client_industry option").eq(10).attr("selected","金融业");break;
            case 11:
                $("#client_industry option").eq(11).attr("selected","房地产业");break;
            case 12:
                $("#client_industry option").eq(12).attr("selected","租赁和商务服务");break;
            case 13:
                $("#client_industry option").eq(13).attr("selected","科学研究");break;
            case 14:
                $("#client_industry option").eq(14).attr("selected","水利、环境管理");break;
            case 15:
                $("#client_industry option").eq(15).attr("selected","居民服务和其他服务");break;
            case 16:
                $("#client_industry option").eq(16).attr("selected","教育");break;
            case "17":
                $("#client_industry option").eq(17).attr("selected","社会保障和社会福利");break;
            case 18:
                $("#client_industry option").eq(18).attr("selected","R 文化、体育和娱乐业");break;
            case 19:
                $("#client_industry option").eq(19).attr("selected","公共管理和社会组织");break;
            case 20:
                $("#client_industry option").eq(20).attr("selected","国际组织");break;
            default:"数据有误";
        }

        switch(data.status){
            case 1:
                $("#client_status option").eq(1).attr("selected","潜在客户");break;
            case 2:
                $("#client_status option").eq(2).attr("selected","意向客户");break;
            case 3:
                $("#client_status option").eq(3).attr("selected","成交客户");break;
            case 4:
                $("#client_status option").eq(4).attr("selected","失败客户");break;
            default:"数据有误";
        }

        switch(data.type){
            case 1:
                $("#client_type option").eq(1).attr("selected","普通客户");break;
            case 2:
                $("#client_type option").eq(2).attr("selected","老客户");break;
            case 3:
                $("#client_type option").eq(3).attr("selected","代理商");break;
            case 4:
                $("#client_type option").eq(4).attr("selected","合作商");break;
            case 5:
                $("#client_type option").eq(5).attr("selected","合作伙伴");break;
            case 6:
                $("#client_type option").eq(6).attr("selected","其他");break;
            default:"数据有误";
        }

        switch(data.grade){
            case 1:
                $("#client_grade option").eq(1).attr("selected","★");break;
            case 2:
                $("#client_grade option").eq(2).attr("selected","★★");break;
            case 3:
                $("#client_grade option").eq(3).attr("selected","★★★");break;
            case 4:
                $("#client_grade option").eq(4).attr("selected","★★★★");break;
            case 5:
                $("#client_grade option").eq(5).attr("selected","★★★★★");break;
            default:"数据有误";
        }

        switch(data.source){
            case 1:
                $("#client_source option").eq(1).attr("selected","手工录入");break;
            case 2:
                $("#client_source option").eq(2).attr("selected","外包渠道");break;
            case 3:
                $("#client_source option").eq(3).attr("selected","推广渠道");break;
            case 4:
                $("#client_source option").eq(4).attr("selected","客户介绍");break;
            case 5:
                $("#client_source option").eq(5).attr("selected","广告渠道");break;
            case 6:
                $("#client_source option").eq(6).attr("selected","职员引荐");break;
            case 7:
                $("#client_source option").eq(7).attr("selected","其他");break;
            default:"数据有误";
        }

        switch(data.direction){
            case 1:
                $("#client_direction option").eq(1).attr("selected","明确成交意向");break;
            case 2:
                $("#client_direction option").eq(2).attr("selected","有初步成交意向");break;
            case 3:
                $("#client_direction option").eq(3).attr("selected","关键人有成交意向");break;
            case 4:
                $("#client_direction option").eq(4).attr("selected","关键人成交意向不确定");break;
            case 5:
                $("#client_direction option").eq(5).attr("selected","初步联系 / 有意向");break;
            case 6:
                $("#client_direction option").eq(6).attr("selected","初步联系 / 意向不确定");break;
            case 7:
                $("#client_direction option").eq(7).attr("selected","新建客户");break;
            case 8:
                $("#client_direction option").eq(8).attr("selected","明显拒绝");break;
            case 9:
                $("#client_direction option").eq(9).attr("selected","无效客户");break;
            default:"数据有误";
        }
        $("#client_address").val(data.address);
        $("#client_remarks").val(data.remarks);
        //数据key 与对应的 id 进行数据绑定  包含cusId
        //提交整个ajax请求到后台 包含cusId
    }
});

$("#update_client").click(function () {
    var forData = $("#client_form").serialize();
    forData = decodeURIComponent(forData, true);
    $.ajax({
        url: "../client/update",
        data: forData,
        type: "PUT",
        dataType: "json",
        async:true,
        success: function (json) {
            if (json.code == 0) {
                //修改完成后
                //模态框隐藏   $("#cus_chance_alter").modal("hide")
                $("#cus_all_alter").modal("hide");
                //局部页面刷新
                window.location.reload(true);
            } else {
                alert(json.message);
            }
        }
    })

})

$("#delete_client").click(function () {
  var checkboxs=document.getElementsByName("checkbox");
    for (var i = 0; i < checkboxs.length; i++) {
        if( checkboxs[i].checked){
            length++;
            checkId = checkboxs[i];
        }
        console.log(length)
    }
    if(length <= 0 || length > 1 ){
        alert("请选择单条数据操作!!!")
        checkId = "";
        return;
    }else {
        var data = JSON.parse(localStorage.getItem(checkId.id));
        var checkid= data.id;
        $.ajax({
            url: "../client/delete/"+checkid,
            type: "POST",
            dataType: "json",
            async:true,
            success: function (json) {
                if (json.code == 0) {
                alert("删除成功");
                    $("#cus_all_delete").modal("hide");
                    //局部页面刷新
                    window.location.reload(true);
                }else{
                    alert("删除失败");
                }
            }
        });
    }
});