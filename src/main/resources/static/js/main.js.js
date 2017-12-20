function GoToUrl(_url) {
    if (_url != "###" && _url != "") {
        OpenLoadingWindow(1);
        window.location.href = _url;
    }
}
function GoToOpenUrl(_url) {
    if (_url != "###" && _url != "") {
        var tempwindow = window.open();
        tempwindow.location = _url;
    }
}

//时间格式化
function DataTable_TimeFormat(date) {
    try {
        if (date != "" && date != null) {
            var reg = /\./;//用来验证数字，包括小数的正则
            if (reg.test(date)) {
                date = date.split('.')[0];
            }
            return date.replace("T", " ").replace(" 00:00:00", "");
        } else {
            return "";
        }
    } catch (e) {
        return "";
    }
}
//时间格式化
function DataTable_TimeFormat_yyyyMMdd(date) {
    try {
        if (date != "" && date != null) {
            var reg = /\./;//用来验证数字，包括小数的正则
            if (reg.test(date)) {
                date = date.split('.')[0];
            }
            return date.replace("T", " ").substring(0, 10);
        } else {
            return "";
        }
    } catch (e) {
        return "";
    }
}
//时间格式化
function DataTable_TimeFormat_yyyyMM(date) {
    try {
        if (date != "" && date != null) {
            var reg = /\./;//用来验证数字，包括小数的正则
            if (reg.test(date)) {
                date = date.split('.')[0];
            }
            return date.replace("T", " ").substring(0, 7);
        } else {
            return "";
        }
    } catch (e) {
        return "";
    }
}


function OpenCustomWindow(_obj) {
    var llq_width = document.body.offsetWidth;//浏览器宽度
    var all_width = _obj.parent().width();//当前右边DIV的总宽度
    var show_width = _obj.find('.CustomWindow_content').width();//需要显示的弹出框宽度
    if (show_width < 100) {
        show_width = llq_width * show_width / 100;//用百分比计算
    }
    var leftvalue = (llq_width - show_width) / 2 - (llq_width - all_width);
    var llq_height = document.documentElement.clientHeight;//浏览器高度
    var gdt_height = $(document).scrollTop();//滚动条高度
    var show_height = _obj.find('.CustomWindow_content').height();//需要显示的弹出框高度
    var topvalue = gdt_height + (llq_height - show_height) / 2;

    _obj.find('.CustomWindow_content').css("left", leftvalue + "px");
    _obj.find('.CustomWindow_content').css("top", topvalue + "px");
    _obj.show();
}
function CloseCustomWindow(_obj) {
    _obj.hide();
}