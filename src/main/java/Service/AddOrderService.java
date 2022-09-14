package Service;

import Entity.AddOrder;

import Entity.HotDrinks;
import Repositories.AddOrderRepository;
import Repositories.HotRepository;
import Repositories.IcedRepository;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;


public class AddOrderService {
    HotRepository hr;
    IcedRepository ir;
    AddOrderRepository  aor;


    Connection conn = ConnectionUtil.getConnection();
    public AddOrderService() throws SQLException {
        hr = new HotRepository();
        ir =new IcedRepository();
        aor = new AddOrderRepository();
    }

    public AddOrderService(HotRepository hr, IcedRepository ir, AddOrderRepository aor) throws SQLException {
        this.hr = hr;
        this.ir = ir;
        this.aor = aor;
    }



    public void addOrders(AddOrder Orders) {
        aor.addOrder(Orders);
    }



}



//
