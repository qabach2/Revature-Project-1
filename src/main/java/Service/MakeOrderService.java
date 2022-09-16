package Service;

import Entity.IcedDrinks;
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
    public MakeOrder getMakeOrderByName(String Customer_Name){
        return mor.getMakeOrderByName(Customer_Name);
    }

    public void removeMakeOrderById(int Customer_Id ){
        mor.removeMakeOrderById(Customer_Id);
    }
    public void removeMakeOrderByName(String Customer_Name ){
        mor.removeMakeOrderByName(Customer_Name);
    }
    public MakeOrder updateMakeOrderById(MakeOrder makeOrder){
        return mor.updateMakeOrderById(makeOrder);}

    public void addMakeOrder(int Customer_Id, String Customer_Name, String Drink_Name) throws SQLException {
        MakeOrder existingMakeOrder = mor.getMakeOrderById(Customer_Id);
        if(existingMakeOrder == null) {
            MakeOrder newMakeOrder = new MakeOrder(Customer_Id, Customer_Name, Drink_Name);
            mor.addMakeOrder(newMakeOrder);
        }else{

    }
      conn.commit();
   }}
//







//
