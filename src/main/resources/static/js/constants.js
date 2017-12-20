//var url=" http://120.76.214.93:8081/mxsm_app_web";
//var img_url="http://120.76.214.93:8081/img/";


function getRootPath(){
    //获取当前网址，如： http://localhost:8083/proj/meun.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： proj/meun.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPath = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/proj
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/')+1);
    return(localhostPath + projectName);
}
var url=getRootPath();
function statechange() {
    if(document.readystate == 'complete') {
       for(i=0; i<window.frames.length; i++) {
          window.frames[i].document.onreadystatechange = statechange;
          if(window.frames[i].document.readystate != 'complete') {
             statechange();
             return;
          }
        }
     }
}

var bookstoreContrs = angular.module('bookstoreContrls', ['ionic']);//申明自定义模块  
//定义一个sb标签 实现 click 事件 contro 数据 会重新渲染
bookstoreContrs.run(function($ionicPlatform) {
    $ionicPlatform.ready(function() {
        // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
        // for form inputs)
        if(window.cordova && window.cordova.plugins.Keyboard) {
          cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
        }
        if(window.StatusBar) {
          StatusBar.styleDefault();
        }
      });
    })

bookstoreContrs.directive('refresh',function(){
    return{
        restrict:'AE',
        link:function(scope,element,attr){
            element.bind('click',function(){   
                 scope.loadData();
             	
            })
        }
    }
})
document.write("<script src='js/vehicle/main.js'></script>");
document.write("<script src='js/vehicle/order.js'></script>");

function SetCookie(name,value)//两个参数，一个是cookie的名子，一个是值
{
    var Days = 7; //此 cookie 将被保存 7 天
    var exp  = new Date();    //new Date("December 31, 9998");
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}
function getCookie(name)//取cookies函数       
{
    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
     if(arr != null) return (arr[2]); return null;
}
function delCookie(name)//删除cookie
{
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null) document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}


