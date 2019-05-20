$(function () {
    $(document).ready(function(){
        showChanceList();
    });


   function showChanceList(){
       $.ajax({
           url: "../chance/list?pageNo=1&pageSize=10",
           type: "get",
           dataType: "json",
           success: function (json) {
                console.log(json.data)
               if (json.code == 0) {

                  var list=json.data;
                  for(var i=0;i<list.length;i++){

                      var html = '<tr>'
                          + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="checkbox1" type="checkbox"/></td>'
                          + '<td>#{chance_name}</td>'
                          + '<td>#{client_name}</td>'
                          + '<td>#{stage}</td>'
                          + '<td>#{possibility}</td>'
                          + '<td>>#{address}</td>'
                          + '<td>>#{money}</td>'
                          + '<td>>#{date_time}</td>'
                          + '<td>>#{transaction_status}</td>'
                          + '<td>>#{auth}</td>'
                          + '<td>>#{time}</td>'
                          + '</tr>';

                      html = html.replace("#{chance_name}",list[i].chanceName);
                      html = html.replace("#{client_name}",list[i].clientName);
                      html = html.replace("#{stage}",list[i].stage);
                      html = html.replace("#{possibility}",list[i].possibility);
                      html = html.replace("#{address}",list[i].address);
                      html = html.replace("#{money}",list[i].money);
                      html = html.replace("#{date_time}",list[i].dateTime);
                      html = html.replace("#{transaction_status}", list[i].transactionStatus);
                      html = html.replace("#{auth}",list[i].auth);
                      html = html.replace("#{time}",list[i].time);
                      $("#chance_td").append(html);

                  }
               }else {
                   alert(json.message);
               }
           }
       });
    }

    $("#save").click(function(){
        var formData = $("#chance_add").serialize(); //取表单值 并进行序列化；此时formData已经是乱码了
        formData = decodeURIComponent(formData,true);
        $.ajax({
            url:"../chance/insert",
            data:formData,
            type:"POST",
            dataType:"json",
            success:function(json) {

                if (json.code == 0) {
                    console.log($("#chanceName").val());
                        var html = '<tr>'
                            + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="checkbox1" type="checkbox"/></td>'
                            + '<td>#{chance_name}</td>'
                            + '<td>#{client_name}</td>'
                            + '<td>#{stage}</td>'
                            + '<td>#{possibility}</td>'
                            + '<td>>#{address}</td>'
                            + '<td>>#{money}</td>'
                            + '<td>>#{date_time}</td>'
                            + '<td>>#{transaction_status}</td>'
                            + '<td>>#{auth}</td>'
                            + '<td>>#{time}</td>'
                            + '</tr>';

                        /*html = html.replace("", $("#checkbox").val());*/
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

                } else {
                    alert(json.message);
                }
            }
        });
    });

});