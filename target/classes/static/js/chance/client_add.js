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
                    html = html.replace("#{intention}",$("#intention").children().eq(data.data.list[i].intention).html());
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
                                    html = html.replace("#{intention}",$("#intention").children().eq(data.data.list[i].intention).html());
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
        $("#client_direction").val(data.direction);
        $("#client_tel").val(data.tel);

        switch(data.industry){
            case "A":
                $("#client_industry").val("A 农、林、牧、渔业");break;
            case "B":
                $("#client_industry").val("B 采矿业");break;
            case "C":
                $("#client_industry").val("C 制造业");break;
            case "D":
                $("#client_industry").val("D 电力生产和供应");break;
            case "E":
                $("#client_industry").val("E 建筑业");break;
            case "F":
                $("#client_industry").val("F 交通运输、仓储和邮政");break;
            case "G":
                $("#client_industry").val("G 计算机服务和软件业");break;
            case "H":
                $("#client_industry").val("H 批发和零售");break;
            case "I":
                $("#client_industry").val("I 住宿和餐饮业");break;
            case "J":
                $("#client_industry").val("J 金融业");break;
            case "K":
                $("#client_industry").val("K 房地产业");break;
            case "L":
                $("#client_industry").val("L 租赁和商务服务");break;
            case "M":
                $("#client_industry").val("M 科学研究");break;
            case "N":
                $("#client_industry").val("N 水利、环境管理");break;
            case "O":
                $("#client_industry").val("O 居民服务和其他服务");break;
            case "P":
                $("#client_industry").val("P 教育");break;
            case "Qva":
                $("#client_industry").val("Qva 社会保障和社会福利");break;
            case "R":
                $("#client_industry").val("R 文化、体育和娱乐业");break;
            case "S":
                $("#client_industry").val("S 公共管理和社会组织");break;
            case "T":
                $("#client_industry").val("T 国际组织");break;
            default:"数据有误";
        }

        switch(data.status){
            case "潜在客户":
                $("#client_status").val("潜在客户");break;
            case "意向客户":
                $("#client_status").val("意向客户");break;
            case "成交客户":
                $("#client_status").val("成交客户");break;
            case "失败客户":
                $("#client_status").val("失败客户");break;
            default:"数据有误";
        }

        switch(data.type){
            case "普通客户":
                $("#client_type option").eq(1).val("普通客户");break;
            case "老客户":
                $("#client_type option").eq(2).val("老客户");break;
            case "代理商":
                $("#client_type option").eq(3).val("代理商");break;
            case "合作商":
                $("#client_type option").eq(4).val("合作商");break;
            case "合作伙伴":
                $("#client_type option").eq(5).val("合作伙伴");break;
            case "其他":
                $("#client_type option").eq(6).val("其他");break;
            default:"数据有误";
        }

        switch(data.grade){
            case "A":
                $("#client_grade option").eq(1).val("★");break;
            case "B":
                $("#client_grade option").eq(2).val("★★");break;
            case "C":
                $("#client_grade option").eq(3).val("★★★");break;
            case "D":
                $("#client_grade option").eq(4).val("★★★★");break;
            case "E":
                $("#client_grade option").eq(5).val("★★★★★");break;
            default:"数据有误";
        }

        switch(data.source){
            case "手工录入":
                $("#client_source").val("手工录入");break;
            case "外包渠道":
                $("#client_source").val("外包渠道");break;
            case "推广渠道":
                $("#client_source").val("推广渠道");break;
            case "客户介绍":
                $("#client_source").val("客户介绍");break;
            case "广告渠道":
                $("#client_source").val("广告渠道");break;
            case "职员引荐":
                $("#client_source").val("职员引荐");break;
            case "其他":
                $("#client_source").val("其他");break;
            default:"数据有误";
        }

        switch(data.intention){
            case "A+":
                $("#client_intention option").eq(1).val("A+ 明确成交意向");break;
            case "A-":
                $("#client_intention option").eq(2).val("A- 有初步成交意向");break;
            case "B+":
                $("#client_intention option").eq(3).val("B+ 关键人有成交意向");break;
            case "B-":
                $("#client_intention option").eq(4).val("B- 关键人成交意向不确定");break;
            case "C+":
                $("#client_intention option").eq(5).val("C+ 初步联系 / 有意向");break;
            case "C-":
                $("#client_intention option").eq(6).val("C- 初步联系 / 意向不确定");break;
            case "D":
                $("#client_intention option").eq(7).val("D 新建客户");break;
            case "E":
                $("#client_intention option").eq(8).val("E 明显拒绝");break;
            case "F":
                $("#client_intention option").eq(9).val("F 无效客户");break;
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