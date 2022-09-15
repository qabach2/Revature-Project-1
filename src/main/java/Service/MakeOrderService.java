package Service;

import Entity.HotDrinks;
import Entity.MakeOrder;


import Repositories.HotRepository;
import Repositories.IcedRepository;
import Repositories.MakeOrderRepository;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class MakeOrderService {
    HotRepository hr;
    IcedRepository ir;
    MakeOrderRepository mor;


    Connection conn = ConnectionUtil.getConnection();
    public MakeOrderService() throws SQLException {
        hr = new HotRepository();
        ir =new IcedRepository();
        mor = new MakeOrderRepository();
    }

    public MakeOrderService(HotRepository hr, IcedRepository ir, MakeOrderRepository mor) throws SQLException {
        this.hr = hr;
        this.ir = ir;
        this.mor = mor;
    }



    public List<MakeOrder> getAllMakeOrder() {

        return mor.getAllMakeOrder();
    }
    public MakeOrder getMakeOrderById(int Customer_Id){
        return mor.getMakeOrderById(Customer_Id);
    }

    public void removeMakeOrderById(int Customer_Id ){
        mor.removeMakeOrderById(Customer_Id);
    }
    public MakeOrder updateMakeOrderById(MakeOrder makeOrder){
        return mor.updateMakeOrderById(makeOrder);
    }
    public void addMakeOrder(MakeOrder makeOrder) {
        mor.addMakeOrder(makeOrder);
    }
}






//
