//
//考题url传到tiurl，返回数据是科目名字和对应题库的json地址
//timu.json为伪数据

var tiurl="timu.json";
$(document).ready(function(){
    $.get(tiurl,function (test){
        for(i=0;i<test.ti.length;i++){
            var t= "<li"+" "+"class='nav-third1'>"+
                "<a"+" "+"class='nav-third2'"+" "+"href='adchangt.html?chioce="+test.ti[i].choice+"&judge="+test.ti[i].judge+"'>"+
                "<span"+" "+"class='nav-third3'>"+test.ti[i].timu+"</span>"+
                "</a>"+
                "</li>";
            $(".testnumber").append(t);
        }
    })
})

//
//学生信息url传到surl，返回数据是学生id、姓名和性别
//student.json为伪数据
var surl="student.json";
$(document).ready(function(){
    $.get(surl,function (data){
        for(var i = 0; i < data.s.length; i++){
            var ls= "<tr"+" "+"class='cs-ad3-1'>"+
                "<th"+" "+"class='cs-ad3-2'><input"+" "+"class='cs-ad3-3'"+" "+ "type='text'"+" "+ "name=''"+" "+"id=snum"+i+"></th>"+
                "<th"+" "+"class='cs-ad3-4'><input"+" "+"class='cs-ad3-5'"+" "+ "type='text'"+" "+ "name=''"+" "+"id=sname"+i+"></th>"+
                "<th"+" "+"class='cs-ad3-6'><input"+" "+"class='cs-ad3-7'"+" "+ "type='text'"+" "+ "name=''"+" "+"id=ssex"+i+"></th>"+
                "</tr>";
            $(".changstudent").append(ls);
            var f0="#snum"+String(i);
            var f1="#sname"+String(i);
            var f2="#ssex"+String(i);
            $(f0).val(data.s[i].num);
            $(f1).val(data.s[i].name);
            $(f2).val(data.s[i].sex);
        }
    })

});

var geturl = window.location.href;
var url = geturl.split("&");
var curl=url[0].split("=");
var jurl=url[1].split("=");
var choiceurl = curl[1];
$(document).ready(function(){
    $.get(choiceurl,function (cdata){
        for(var i = 0; i < cdata.t.length; i++){
            var lt="<li"+" "+"class='ct-ad3-1'"+">" +
                "<div"+" "+"class='ct-ad3-2'>"+"<input"+" "+"name=''"+" "+"class='ct-ad3-3'"+" "+"type='text'"+" "+"id=cti"+String(i)+">"+"</div>"+"<br>"+
                "<div"+" "+"class='ct-ad3-4'>"+"&nbsp;&nbsp;A."+"<input"+" "+"name=''"+" "+"class='ct-ad3-5'"+" "+"type='text'"+" "+"id=acn"+String(i)+">"+"</div>"+"<br>"+
                "<div"+" "+"class='ct-ad3-4'>"+"&nbsp;&nbsp;B."+"<input"+" "+"name=''"+" "+"class='ct-ad3-5'"+" "+"type='text'"+" "+"id=bcn"+String(i)+">"+"</div>"+"<br>"+
                "<div"+" "+"class='ct-ad3-4'>"+"&nbsp;&nbsp;C."+"<input"+" "+"name=''"+" "+"class='ct-ad3-5'"+" "+"type='text'"+" "+"id=ccn"+String(i)+">"+"</div>"+"<br>"+
                "<div"+" "+"class='ct-ad3-6'>"+"&nbsp;&nbsp;正确答案："+"<input"+" "+"name=''"+" "+"class='ct-ad3-7'"+" "+"type='text'"+" "+"id=rcn"+String(i)+">"+"</div>"+"<br>"+
                "</li>";
            $(".adforms").append(lt);
            var f0="#cti"+String(i);
            var f1="#acn"+String(i);
            var f2="#bcn"+String(i);
            var f3="#ccn"+String(i);
            var f4="#rcn"+String(i);
            $(f0).val(cdata.t[i].m);
            $(f1).val(cdata.t[i].ac);
            $(f2).val(cdata.t[i].bc);
            $(f3).val(cdata.t[i].cc);
            $(f4).val(cdata.t[i].rc);
        }

    })

});

var judgeurl = jurl[1];
$(document).ready(function(){
    $.get(judgeurl,function (jdata){
        for(var i = 0; i < jdata.t.length; i++){
            var lt="<li"+" "+"class='ct-ad3-1'"+">" +
                "<div"+" "+"class='ct-ad3-2'>"+"<input"+" "+"name=''"+" "+"class='ct-ad3-3'"+" "+"type='text'"+" "+"id=jti"+String(i)+">"+"</div>"+"<br>"+
                "<div"+" "+"class='ct-ad3-6'>"+"&nbsp;&nbsp;正确答案："+"<input"+" "+"name=''"+" "+"class='ct-ad3-7'"+" "+"type='text'"+" "+"id=jr"+String(i)+">"+"</div>"+"<br>"+
                "</li>";
            $(".adforms").append(lt);
            var f0="#jti"+String(i);
            var f1="#jr"+String(i);

            $(f0).val(jdata.t[i].m);
            $(f1).val(jdata.t[i].j);
        }

    })

});