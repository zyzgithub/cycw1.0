package test;

import com.alibaba.fastjson.JSONObject;
import com.gzbeishan.org.tempuri.IVehicleGZQueryServiceProxy;
import com.gzbeishan.vo.CarDO;
import com.gzbeishan.vo.ViolationDO;
import com.gzbeishan.vo.ViolationWSResp;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by zhangyong on 2017/12/8.
 */
public class test {
    private static IVehicleGZQueryServiceProxy proxy = new IVehicleGZQueryServiceProxy();

    public static void main(String[] args) throws RemoteException {

        CarDO vo = new CarDO();
        vo.setPlateNum("粤B6UU82");
        vo.setPlateType("02");
        vo.setVin("041335");
        vo.setEngine("275908");
        String response = proxy.getViolationQuery(vo.getPlateNum(), vo.getPlateType(), vo.getEngine(), vo.getVin());
        System.out.println("================================");
        System.out.println(response);
        ViolationWSResp car = JSONObject.parseObject(response, ViolationWSResp.class);
        List<ViolationDO> violation = car.getSite();
        for (ViolationDO violationDO : violation) {
            System.out.println(violationDO.getViolationBehavior());
        }

    }
}
