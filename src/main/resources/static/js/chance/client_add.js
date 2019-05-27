$(function() {

    function getMsg() {
        $.ajax({
            url: "../client/clientEntityList",
            data: {pageNo: 1, pageSize: 2},
            type: "get",
            dataType: "json",
            success: function (data) {
                console.log('length;'+data.data.list.length);
                for (var i = 0; i < data.data.list.length; i++) {

                    var html = '<tr>'
                        + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                        + '<td>#{client_name}</td>'
                        + '<td>#{type}</td>'
                        + '<td>#{local}</td>'
                        + '<td>#{address}</td>'
                        + '<td>#{maturity}</td>'
                        + '<td>#{phone}</td>'
                        + '<td>#{need}</td>'
                        + '<td>#{state}</td>'
                        + '<td>#{follow_time}</td>'
                        + '</tr>';

                    html = html.replace("#{cusId}", "cus" + i);
                    html = html.replace("#{client_name}", data.data.list[i].clientName);
                    html = html.replace("#{type}", data.data.list[i].type);
                    html = html.replace("#{local}", data.data.list[i].local);
                    html = html.replace("#{address}", data.data.list[i].address);
                    html = html.replace("#{maturity}", data.data.list[i].maturity);
                    html = html.replace("#{phone}", data.data.list[i].phone);
                    html = html.replace("#{need}", data.data.list[i].need);
                    html = html.replace("#{state}", data.data.list[i].state);
                    html = html.replace("#{follow_time}", data.data.list[i].followTime);

                    $("#client_td").append(html);
                    localStorage.setItem("cus"+i,JSON.stringify(data.data.list[i]))
                }
                // $("#client_td").html(html)



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
                            url: "../client/clientEntityList",
                            data: {pageNo: api.getCurrent(), pageSize: 2},
                            type: "get",
                            dataType: "json",
                            success: function (data) {
                                //console.log(index);
                                for (var i = 0; i < data.data.list.length; i++) {
                                        var html = '<tr>'
                                            + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                                            + '<td>#{client_name}</td>'
                                            + '<td>#{type}</td>'
                                            + '<td>#{local}</td>'
                                            + '<td>#{address}</td>'
                                            + '<td>#{maturity}</td>'
                                            + '<td>#{phone}</td>'
                                            + '<td>#{need}</td>'
                                            + '<td>#{state}</td>'
                                            + '<td>#{follow_time}</td>'
                                            + '</tr>';

                                        html = html.replace("#{cusId}", "cus" + i);
                                        html = html.replace("#{client_name}", data.data.list[i].clientName);
                                        html = html.replace("#{type}", data.data.list[i].type);
                                        html = html.replace("#{local}", data.data.list[i].local);
                                        html = html.replace("#{address}", data.data.list[i].address);
                                        html = html.replace("#{maturity}", data.data.list[i].maturity);
                                        html = html.replace("#{phone}", data.data.list[i].phone);
                                        html = html.replace("#{need}", data.data.list[i].need);
                                        html = html.replace("#{state}", data.data.list[i].state);
                                        html = html.replace("#{follow_time}", data.data.list[i].followTime);

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




/*$(function () {
    showChanceList();
});*/


/*function showChanceList() {
    $.ajax({
        url: "../client/clientEntityList",
        type: "get",
        dataType: "json",
        success: function (json) {
            if (json.code == 0) {
                var list = json.data;
                console.log(list)
                for (var i = 0; i < list.length; i++) {
                    var html = '<tr>'
                        + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                        + '<td>#{client_name}</td>'
                        + '<td>#{type}</td>'
                        + '<td>#{local}</td>'
                        + '<td>#{address}</td>'
                        + '<td>#{maturity}</td>'
                        + '<td>#{phone}</td>'
                        + '<td>#{need}</td>'
                        + '<td>#{state}</td>'
                        + '<td>#{follow_time}</td>'
                        + '</tr>';

                    html = html.replace("#{cusId}", "cus"+i);
                    html = html.replace("#{client_name}", list[i].clientName);
                    html = html.replace("#{type}",list[i].type);
                    html = html.replace("#{local}", list[i].local);
                    html = html.replace("#{address}",list[i].address);
                    html = html.replace("#{maturity}", list[i].maturity);
                    html = html.replace("#{phone}", list[i].phone);
                    html = html.replace("#{need}", list[i].need);
                    html = html.replace("#{state}",list[i].state);
                    html = html.replace("#{follow_time}", list[i].followTime);
                    $("#client_td").append(html);

                    // TODO 会存在性能问题 所以后期做分页的时候得考虑到局部加载
                    localStorage.setItem("cus"+i,JSON.stringify(list[i]))
                }
            } else {
                alert(json.message);
            }
        }
    });
}*/

$("#client_btn").click(function () {
    var formData = $("#client_add").serialize(); //取表单值 并进行序列化；此时formData已经是乱码了
    formData = decodeURIComponent(formData, true);
    console.log(formData);
    $.ajax({
        url: "../client/insertClientEntity",
        data: formData,
        type: "POST",
        dataType: "json",
        success: function (json) {
            console.log(json);
            if (json.code == 0) {
                var html = '<tr>'
                    + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input type="checkbox" name="checkbox"/></td>'
                    + '<td>#{client_name}</td>'
                    + '<td>#{type}</td>'
                    + '<td>#{local}</td>'
                    + '<td>#{address}</td>'
                    + '<td>#{maturity}</td>'
                    + '<td>#{phone}</td>'
                    + '<td>#{need}</td>'
                    + '<td>#{state}</td>'
                    + '<td>#{follow_time}</td>'
                    + '</tr>';

                html = html.replace("#{client_name}", $("#clientName").val());
                html = html.replace("#{type}", $("#type").val());
                html = html.replace("#{local}", $("#local").val());
                html = html.replace("#{address}", $("#address").val());
                html = html.replace("#{maturity}", $("#maturity").val());
                html = html.replace("#{phone}", $("#phone").val());
                html = html.replace("#{need}", $("#need").val());
                html = html.replace("#{state}", $("#state").val());
                html = html.replace("#{follow_time}", $("#followTime").val());
                $("#client_td").append(html);
                $("#cus_all_add").modal("hide");
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
        $("#uid").val(data.uid);
        $("#client_date").val(data.date);
        $("#client_name").val(data.clientName);
        $("#client_local").val(data.local);
        $("#client_direction").val(data.direction);
        $("#client_phone").val(data.phone);

        switch(data.trade){
            case "A":
                $("#client_trade").val("A 农、林、牧、渔业");break;
            case "B":
                $("#client_trade").val("B 采矿业");break;
            case "C":
                $("#client_trade").val("C 制造业");break;
            case "D":
                $("#client_trade").val("D 电力生产和供应");break;
            case "E":
                $("#client_trade").val("E 建筑业");break;
            case "F":
                $("#client_trade").val("F 交通运输、仓储和邮政");break;
            case "G":
                $("#client_trade").val("G 计算机服务和软件业");break;
            case "H":
                $("#client_trade").val("H 批发和零售");break;
            case "I":
                $("#client_trade").val("I 住宿和餐饮业");break;
            case "J":
                $("#client_trade").val("J 金融业");break;
            case "K":
                $("#client_trade").val("K 房地产业");break;
            case "L":
                $("#client_trade").val("L 租赁和商务服务");break;
            case "M":
                $("#client_trade").val("M 科学研究");break;
            case "N":
                $("#client_trade").val("N 水利、环境管理");break;
            case "O":
                $("#client_trade").val("O 居民服务和其他服务");break;
            case "P":
                $("#client_trade").val("P 教育");break;
            case "Qva":
                $("#client_trade").val("Qva 社会保障和社会福利");break;
            case "R":
                $("#client_trade").val("R 文化、体育和娱乐业");break;
            case "S":
                $("#client_trade").val("S 公共管理和社会组织");break;
            case "T":
                $("#client_trade").val("T 国际组织");break;
            default:"数据有误";
        }

        switch(data.state){
            case "潜在客户":
                $("#client_state").val("潜在客户");break;
            case "意向客户":
                $("#client_state").val("意向客户");break;
            case "成交客户":
                $("#client_state").val("成交客户");break;
            case "失败客户":
                $("#client_state").val("失败客户");break;
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
        url: "../client/updateClientEntity",
        data: forData,
        type: "POST",
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
        var checkid= data.uid;
        $.ajax({
            url: "../client/deleteByClientId/"+checkid,
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