var geturl = window.location.href;

var url = geturl.split("&");
var curl=url[0].split("=");
var jurl=url[1].split("=");

var choiceurl = curl[1];
var h = curl[2];
var hh = choiceurl+"="+h;

//var choiceurl ="http://localhost:8080/maven/Getxuanpaper?kemu=";
$(document).ready(function () {
    $.get(hh, function (cdata) {
    	if(cdata=="false"){
    		return ;
    	}
    	var cdata = $.parseJSON( cdata );
    	// alert("jjjjjjjjjjj");
        for (var i = 0; i < cdata.t.length; i++) {
        	
            var ch = "<li" + " " + "class='te-st1-1'" + ">" +
            	"<input"+" "+"type='hidden'"+" "+"name='questionid'"+" "+"value="+cdata.t[i].qid+""+" "+">"+
                " <span" + " " + "class='te-st1-2'" + ">" + cdata.t[i].m + "</span><br>" +
                "<input" + " " + "class='te-st1-3'" + " " + "type='radio'" + " " + "name='an"+cdata.t[i].qid+"'" + " " + " " + "value='a'>" + " <span" + " " + "class='te-st1-4'" + ">A." + cdata.t[i].ac + "</span><br>" + "<br>" +
                "<input" + " " + "class='te-st1-3'" + " " + "type='radio'" + " " + "name='an"+cdata.t[i].qid+"'" + " " + " " + "value='b'>" + " <span" + " " + "class='te-st1-4'" + ">B." + cdata.t[i].bc + "</span><br>" + "<br>" +
                "<input" + " " + "class='te-st1-3'" + " " + "type='radio'" + " " + "name='an"+cdata.t[i].qid+"'" + " " + " " + "value='c'>" + " <span" + " " + "class='te-st1-4'" + ">C." + cdata.t[i].cc + "</span><br>" + "<br>" +
                "</li>";
           
         // alert("jjjjjjjjjjj");
        //   alert(cdata.t[i].xc);
          // $("input[name='an3']:eq(1)").attr('checked','true');
           $(".examination").append(ch)
        }
      /*  for (var i = 0; i < cdata.t.length; i++) {
        	// alert(cdata.t[i].xc);
      	 var s1 = cdata.t[i].xc;
      	 var s2 = 1;
        	// alert(typeof s1);
        	$("input[name="+s1+"]:eq("+s2+")").attr('checked','true');
        }*/
    })
// 答案：cdata.t[i].rc
});
var judgeurl=jurl[1]+"="+jurl[2];

$(document).ready(function () {
    $.get(judgeurl, function (jdata) {
    	//window.location.href="http://localhost:8080/maven/query.html";
    	//return;
    	if(jdata=="false"){
    		
    		alert("该时间没有该科目的考题！！");
    		window.location.href="http://localhost:8080/maven/query.html"
    	}
    	
    	var jdata = $.parseJSON( jdata );
        for (var i = 0; i < jdata.t.length; i++) {
            var ju = "<li" + " " + "class='te-st1-1'" + ">" +
            	"<input"+" "+"type='hidden'"+" "+"name='jqid'"+" "+"value="+jdata.t[i].jid+""+" "+">"+
                " <span" + " " + "class='te-st1-2'" + ">" + jdata.t[i].m + "</span><br>" +
                "<input" + " " + "class='te-st1-3'" + " " + "type='radio'" + " " + "name='ju"+jdata.t[i].jid+"'"+ " "+ "value='T'>" + " <span" + " " + "class='te-st1-4'" + ">对.</span><br>" + "<br>" +
                "<input" + " " + "class='te-st1-3'" + " " + "type='radio'" + " " + "name='ju"+jdata.t[i].jid+"'" + " " + "value='F'>" + " <span" + " " + "class='te-st1-4'" + ">错.</span><br>" + "<br>" +
                "</li>";
            $(".examination").append(ju)
        }
    })
// 答案：data.t[i].rc
});

var T;
$(document).ready(function () {
		var outtimeurl = "http://localhost:8080/maven/Timeout";
	//	alert(outtimeurl);
		$.get(outtimeurl, function (t){
			//alert(t);
			 T=Number(t);
		});
        setInterval(function () {
        	
            timeshow();
        }, 1000);
        function timeshow() {
        	//alert("hhhh");
        //	alert("fff"+T);
            T--;
            var minutes =  Math.floor(T / 60);
            var seconds =  T % 60;
            var show = "离考试结束还剩" + minutes + "分" + seconds + "秒";
            document.getElementById("time").innerHTML = show;
            if (T == 0) {
                $('.forms').submit();
            }

            if(seconds/6==Math.floor(seconds / 6)){
            //	$('.forms').submit();
            	  /*$.ajax({
                      type: "GET",
                      url: "http://localhost:8080/maven/baocun",
                      data: {username:$("#username").val(), content:$("#content").val()},
                      dataType: "json",
                      success: function(data){

                      }
                  });*/
            }
        }

    }
)
//学生成绩查询url到queryurl，返回科目名称和对应成绩
//query.json为伪数据
var queryurl="http://localhost:8080/maven/QueryGrade";
$(document).ready(function(){
    $.get(queryurl,function (results){
    	var results = $.parseJSON( results );
        for(i=0;i<results.c.length;i++){
            var q="<tr"+" "+"class='qu-st2-1'>"+
                "<td"+" "+"class='qu-st2-2'>"+
                results.c[i].name+
                "</td>"+
                "<td"+" "+"class='qu-st2-3'>"+
                results.c[i].num+
                "</td>"+
                "<tr>"
            $(".querytable").append(q);
        }
    })
})

//考题url传到tiurl，返回数据是科目名字和对应题库的json地址
//timu.json为伪数据
var tiurl="http://localhost:8080/maven/Fengke";
$(document).ready(function(){
    $.get(tiurl,function (test){
    	
        for(i=0;i<test.ti.length;i++){
            var t= "<li"+" "+"class='nav-third1'>"+
                "<a"+" "+"class='nav-third2'"+" "+"href='test.html?choice="+test.ti[i].choice+"&judge="+test.ti[i].judge+"'>"+
                "<span"+" "+"class='nav-third3'>"+test.ti[i].timu+"</span>"+
                "</a>"+
                "</li>";
            $(".testnumber").append(t);
        }
    })
})

function scoring(){

}