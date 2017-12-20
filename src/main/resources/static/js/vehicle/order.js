// 获取所有用户会员信息
bookstoreContrs.controller('orderCtrl', function ($scope, $http, $state, $stateParams) {

    //界面添加一个class
    //$scope.pageClass = 'page-about';
    var carDo = $stateParams.carDo;

    //货车驾驶证违章信息Url
    var vehicleInfoUrl = url + "/violation/getViolationListByOffSite";
    //提交未处理订单
    var addOrderInfo = url + "/violation/saveSiteViolation";
    $scope.loadData = function () {
        $http.get(vehicleInfoUrl, {params: {"carDo": carDo}}).success(function (response) {
            $scope.orderList = response.response;
            $scope.carDo = carDo;
            $scope.showfine = 0;
            $scope.shownum = 0;
            $scope.showscore = 0;
            $.each($scope.orderList.datas, function (i, order) {
                $scope.showfine = parseInt($scope.showfine) + parseInt(order.fine);
                $scope.shownum = $scope.orderList.datas.length;
                $scope.showscore = parseInt($scope.showscore) + parseInt(order.violationPoints);
            });
        });
    }
    //本人本车界面切换
    $scope.changeManager = function () {

        var x = $("#change").attr("value");
        var b = "block";
        if (x == b) {
            $("#change").css("display", "none");
            $("#change").attr("value", "none");
            $("#changeManager").css("background-color", "#c9302c");
            $("#changeManager").css("color", "#fff");
            $("#changeManager").css("border-color", "#ac2925");
            $("#changeManager").html("点击切换到本人驾证扣分办理")
        } else {
            $("#change").css("display", "block");
            $("#change").attr("value", "block");
            $("#changeManager").css("background-color", "#f2dede");
            $("#changeManager").css("color", "#a94442");
            $("#changeManager").css("border-color", "#ebccd1");
            $("#changeManager").html("切换到普通扣分办理")
        }
    }

    $scope.selected = []; //定义的id
    $scope.selectedTags = []; //定义的内容
    $scope.num = 0; //选中项
    $scope.score = 0; //当前要扣的分数
    $scope.money = 0; //当前要缴纳的金额

    //checkbox 多选操作数据绑定
    var updateSelected = function (action, id, name) {
        if (action == 'add') {
            $scope.selected.push(id);
            $scope.selectedTags.push(name);
            alert($scope.selectedTags);
            $scope.num = $scope.num + 1;
            //转换可解析的对象
            $scope.result = [
                angular.fromJson(name)
            ];
            //获取分数
            var score = $scope.result[0].violationPoints;
            var money = $scope.result[0].fine;
            $scope.score = parseInt($scope.score) + parseInt(score);
            $scope.money = parseInt($scope.money) + parseInt(12) + parseInt(money);
        } else if (action == 'remove') {
            var idx = $scope.selected.indexOf(id);
            $scope.selected.splice(idx, 1);
            $scope.selectedTags.splice(idx, 1);
            alert($scope.selectedTags);
            $scope.num = $scope.num - 1;
            $scope.result = [
                angular.fromJson(name)
            ];
            var score = $scope.result[0].violationPoints;
            var money = $scope.result[0].fine;
            $scope.score = parseInt($scope.score) - parseInt(score);
            $scope.money = parseInt($scope.money) - parseInt(12) - parseInt(money);
        }

    }

    $scope.updateSelection = function ($event, id) {
        var checkbox = $event.target;
        var action = (checkbox.checked ? 'add' : 'remove');
        alert(id);
        updateSelected(action, id, checkbox.name);
    }

    // $scope.isSelected = function (id) {
    //     return $scope.selected.indexOf(id) >= 0;
    // }

    //checkbox 全选,取消数据绑定

    var updateSelectedAll = function (action, name) {
        $scope.score = 0;
        $scope.money = 0;
        //全选
        if (action == 'add') {

            $scope.selectedTags.push(name);
            var dataObj = eval("(" + name + ")");
            $scope.num = dataObj.length;

            $.each(dataObj, function (i, order) {
                $scope.score = parseInt($scope.score) + parseInt(order.violationPoints);
                $scope.money = parseInt($scope.money) + parseInt(12) + parseInt(order.fine);
            });
            $(':checkbox').prop('checked', true);
        }
        //取消全选
        if (action == 'remove') {
            $(':checkbox').attr('checked', false);
            $scope.num = 0;
            $scope.score = 0;
            $scope.money = 0;
        }
    }
    $scope.updateSelectionAll = function ($event) {
        var checkbox = $event.target;
        var action = (checkbox.checked ? 'add' : 'remove');
        updateSelectedAll(action, checkbox.name);
    }

    $scope.saveOrder = function () {
        var oderInfo =  $scope.selectedTags ;

        alert(oderInfo);
        $http.get(addOrderInfo, {params: {"orderInfo": oderInfo}}).success(function (response) {
            var code = response.code;
            var msg = response.msg;
            if (code == "0") {
                //保存订单成功跳转支付界面
                alert(msg);
            }
        });
    }
});
