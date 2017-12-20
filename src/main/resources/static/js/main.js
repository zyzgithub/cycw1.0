//-------------------------方法(Start)----------------
//alert(key);   名称
//alert(Enum_agentUserLogType[key]);   //值
function GetEnumValue(_Enum, _Name) {
    for (var key in _Enum) {
        if (GetEnumName(_Enum, _Name) == key) {
            return _Enum[key];
        }
    }
}

function GetEnumName(_Enum, _Value) {
    for (var key in _Enum) {
        if (_Value == _Enum[key]) {
            return key;
        }
    }
}


//-------------------------资金账户(Start)----------------

//支付订单类别
var Enum_tradeType = {
    //———————————————————— 现金、余额收入 ————————————————————
    余额充值: 1001,
    下级下单提成_违章: 1002,
    下单交易手续费_违章: 1003,
    接单收入_违章: 1004,
    订单取消_违章: 1005,
    提现取消: 1006,
    补款提成_违章: 1007,
    下单分站提成_违章: 1008,

    下级下单提成_交管: 1009,
    下单交易手续费_交管: 1010,
    接单收入_交管: 1011,
    订单取消_交管: 1012,
    补款提成_交管: 1013,
    下单分站提成_交管: 1014,

    下级下单提成_驾驶证业务: 1015,
    下单交易手续费_驾驶证业务: 1016,
    接单收入_驾驶证业务: 1017,
    订单取消_驾驶证业务: 1018,
    补款提成_驾驶证业务: 1019,
    下单分站提成_驾驶证业务: 1020,


    下级下单提成_服务包业务: 1021,
    下单交易手续费_服务包业务: 1022,
    接单收入_服务包业务: 1023,
    订单取消_服务包业务: 1024,
    补款提成_服务包业务: 1025,
    下单分站提成_服务包业务: 1026,

    下级下单提成_系统业务: 1031,
    下单交易手续费_系统业务: 1032,
    接单收入_系统业务: 1033,
    订单取消_系统业务: 1034,
    补款提成_系统业务: 1035,
    下单分站提成_系统业务: 1036,

    下级下单提成_商城商品业务: 1801,
    下单交易手续费_商城商品业务: 1802,
    接单收入_商城商品业务: 1803,
    订单取消_商城商品业务: 1804,
    补款提成_商城商品业务: 1805,
    下单分站提成_商城商品业务: 1806,

    下级下单提成_二手车商品业务: 1901,
    下单交易手续费_二手车商品业务: 1902,
    接单收入_二手车商品业务: 1903,
    订单取消_二手车商品业务: 1904,
    补款提成_二手车商品业务: 1905,
    下单分站提成_二手车商品业务: 1906,

    //———————————————————— 现金、余额支出 ————————————————————
    违章办理: 2001,
    违章补款: 2002,
    积分充值: 2003,
    余额提现: 2004,
    交管业务办理: 2005,
    驾驶证业务办理: 2006,
    服务包业务办理: 2007,
    系统业务办理: 2008,
    商城商品业务办理: 2009,
    二手车商品业务办理: 2010,

    //———————————————————— 积分收入 ————————————————————
    下单奖励积分: 3001,
    签到奖励积分: 3002,

    //———————————————————— 积分支出 ————————————————————
    违章查询扣除积分: 4001,

    //———————————————————— 其他 ————————————————————
    旧用户导入: 9001,
}


//支付类型
var Enum_fin_payType = {
    余额支付: 1,
    微信支付: 2,
    支付宝支付: 3
}
//支付类型
var Enum_fin_providerType = {
    余额: 1,
    微信原生: 2,
    支付宝原生: 3,
    通联支付: 4
}
//支付相应方式
var Enum_fin_payWorkType = {
    余额支付密码验证: 1,
    微信扫码支付: 2,
    支付宝扫码支付: 3,
    微信公众号支付: 4,
    支付宝服务窗支付: 5,
}


//店铺类型
var Enum_mchType = {
    PC店铺: 1,
    微信店铺: 2,
    支付宝店铺: 3,
    Wap店铺: 4,
    H5店铺: 5,
}

//-------------------------站内信消息类型(Start)----------------
//(会员)信箱消息类型
var Enum_member_msgType = {
    系统消息: 10001,
}


//------------------------其他(Start)-------------------------
//实名认证状态
var Enum_IDCardStatus = {
    未认证: 1,
    待审核: 2,
    未通过: 3,
    已认证: 4
}

//提现订单状态
var Enum_drawStatus = {
    已提交: 1,
    处理中: 2,
    提现成功: 3,
    提现失败: 4
}

//代理等级
var Enum_agentLevel = {
    总代理: 1,
    一级代理: 2,
    二级代理: 3,
}


//快递公司
var Enum_expressCompany = {
    EMS: 1,
    申通快递: 2,
    顺丰速运: 3,
    圆通速递: 4,
    韵达速递: 5,
    中通快递: 6,
    天天快递: 7,
    德邦物流: 8,
    快捷快递: 9,
    全峰快递: 10,
    百世汇通: 11,
    包裹信件: 12,
    丰巢快递: 13,
    优速物流: 14,
    宅急送: 15,
    其他快递公司: 9999
}


//可接单类型
var Enum_jdType = {
    本人本证违章: 1001,
    刷卡单违章: 1002,
    扣分单违章: 1003,

    六年免检: 2001,
    行驶证补证: 2002,
    机动车业务委托书: 2003,

    驾驶证补证: 3001,
    驾驶证换证: 3002,
    驾驶证异地转入: 3003,
}


//-------------------------交管业务:查询_报价_订单----------------
//订单状态
var Enum_jgOrderStatus = {
    已提交: 1,
    已支付待寄件: 2,
    已支付待处理: 3,
    有问题待跟踪: 4,
    已处理待确认: 5,
    处理成功: 6,
    用户申请退单: 7,
    接单人申请退单: 8,
    处理失败: 9
}

//-------------------------驾驶证业务:查询_报价_订单----------------
//订单状态
var Enum_jszOrderStatus = {
    已提交: 1,
    已支付待寄件: 2,
    已支付待处理: 3,
    有问题待跟踪: 4,
    已处理待确认: 5,
    处理成功: 6,
    用户申请退单: 7,
    接单人申请退单: 8,
    处理失败: 9
}

//-------------------------服务包业务:查询_报价_订单----------------
//订单状态
var Enum_servicepackOrderStatus = {
    已提交: 1,
    已支付待处理: 2,
    有问题待跟踪: 3,
    已处理待确认: 4,
    处理成功: 5,
    用户申请退单: 6,
    接单人申请退单: 7,
    处理失败: 8,
}
//-------------------------违章查询报价订单(Start)----------------
//车牌号码首位
var cphm1List = [{
    "name": "粤"
}, {
    "name": "云"
}, {
    "name": "青"
}, {
    "name": "琼"
}, {
    "name": "鲁"
}, {
    "name": "渝"
}, {
    "name": "京"
}, {
    "name": "津"
}, {
    "name": "沪"
}, {
    "name": "桂"
}, {
    "name": "湘"
}, {
    "name": "鄂"
}, {
    "name": "皖"
}, {
    "name": "闽"
}, {
    "name": "甘"
}, {
    "name": "贵"
}, {
    "name": "冀"
}, {
    "name": "豫"
}, {
    "name": "吉"
}, {
    "name": "苏"
}, {
    "name": "赣"
}, {
    "name": "辽"
}, {
    "name": "宁"
}, {
    "name": "晋"
}, {
    "name": "陕"
}, {
    "name": "川"
}, {
    "name": "浙"
}, {
    "name": "新"
}, {
    "name": "黑"
}, {
    "name": "蒙"
}, {
    "name": "藏"
}];
//基础Enum
var Enum_cx = {
    小型汽车: "02",
    摩托: "07",
    外籍汽车: "06",
    挂车: "15",
    A1大型客车: "01A1",
    A2牵引货车: "01A2",
    B1中型客车: "01B1",
    B2大型货车: "01B2",
    教练车: "16",
    香港车: "26",
    澳门车: "27",
}
//数据:
var Enum_quotnDetailStatus = {
    可下单: 1,
    无报价: 2,
    已在本系统下单: 3,
    违章信息不完整: 4,
    政策原因无法办理: 5
}
//订单状态
var Enum_orderStatus = {
    已提交: 1,
    已支付: 2,
    有问题待跟踪: 3,
    结束: 4
}

//订单明细状态
var Enum_orderDetailStatus = {
    已提交: 1,
    已支付待处理: 2,
    有问题待跟踪: 3,
    已处理待确认: 4,
    处理成功: 5,
    用户申请退单: 6,
    接单人申请退单: 7,
    处理失败: 8
}


//车辆归属
var Enum_clyt = {
    私人车: 1,
    公司车: 2
}
//违法类别
var Enum_wflb = {
    现场单: 1,
    电子监控: 2
}
//违法打单报价类型
var Enum_priceType = {
    现场单价格: 1,
    扣分单价格: 2,
    特殊代码价格: 3
}

//跟踪单类别
var Enum_trackType = {
    补款: 1,
    重新派单: 2
}
//跟踪单状态
var Enum_trackStatus = {
    待处理: 1,
    处理完成: 2,
    处理失败: 3
}
//办理类型
var Enum_blType = {
    刷卡单: 1,
    扣分单: 2,
    本人认罚扣分单: 3
}

//报价偏好
var Enum_baojiaSelectType = {
    综合排序: 1,
    价格最优: 2,
    手续最简: 3,
}


//报价系统审核状态
var Enum_passSysStatus = {
    待审核: 1,
    审核通过: 2,
    审核未通过: 3,
    管理员禁用: 4
}
//报价分站审核状态
var Enum_passSiteStatus = {
    待审核: 1,
    审核通过: 2,
    审核未通过: 3,
    管理员禁用: 4
}

//-------------------------违章查询报价订单(End)----------------


//-------------------------证件(Start)----------------
var Enum_fileRefType = {
    无关联订单: 1,
    车辆信息: 2,
    驾驶员信息: 3,
    违章订单证件: 4,
    交管业务订单证件: 5,
}
var Enum_fileType = {
    行驶证正副本: 1001,
    行驶证正副本反面: 1003,
    驾驶证正副本: 2001,
    驾驶证正副本反面: 2003,
    身份证正面: 3001,
    身份证反面: 3002,
    机动车登记证扫描件: 4001,
    车辆照片: 9001,
}
var Enum_postPaper = {
    行驶证正本原件: 1001,
    行驶证副本原件: 1002,
    驾驶证正本原件: 2001,
    驾驶证副本原件: 2002,
    身份证原件: 3001,
    交强险副本原件: 4001,
    车船税原件: 5001,
    当地居住证原件: 6001,
}
//-------------------------证件(End)----------------


//-------------------------商城(Start)----------------

//商品状态
var Enum_goodsStatus = {
    等待上线: 1, //定时开售
    上线中: 2,
    下架中: 3,
    已删除: 4,
}
//商品分类
var Enum_goodsType = {
    其他: 99,
}
//购买方式
var Enum_buyType = {
    价格展示: 1,
    虚拟商品: 2,
    实物商品: 3,
    外链接购买: 4,
}
//运费类型
var Enum_yunfeiType = {
    全国包邮: 1,
    全国统一邮费: 2,
    //第三方物流公司: 3,
}
//订单状态
var Enum_shopOrderStatus = {
    已提交: 1,
    已支付: 2,
    已发货: 3,
    交易完成: 4,
    用户申请退单: 5,
    待用户退货: 6,
    待商户确认退货: 7,
    交易失败: 8,
    有问题待跟踪: 9,
}

