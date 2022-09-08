package Service;


import Entity.HotDrinks;
import Repositories.HotRepository;
import Repositories.IcedRepository;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class HotService {
    HotRepository hr;
    IcedRepository ir;


    Connection conn = ConnectionUtil.getConnection();
    public HotService() throws  SQLException{
        hr = new HotRepository();
        ir =new IcedRepository();
    }

    public HotService(HotRepository hr, IcedRepository ir) throws SQLException {
        this.hr = hr;
        this.ir = ir;
    }

//
 public List<HotDrinks> getAllHotDrinks() {

     return hr.getAllHotDrinks();
 }
 public HotDrinks getHotDrinksById(int id){
  return hr.getHotDrinksById(id);
 }

    public void removeHotDrinksById(int id ){
        hr.removeHotDrinksById(id);
    }
    public HotDrinks updateHotDrinksById(HotDrinks hotDrinks){
        return hr.updateHotDrinksById(hotDrinks);
    }
    public void addHotCoffee(HotDrinks drinks) {
        hr.addHotDrinks(drinks);
    }
    }



//
