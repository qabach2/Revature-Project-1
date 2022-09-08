package Service;

import Entity.IcedDrinks;
import Repositories.IcedRepository;

import java.sql.SQLException;
import java.util.List;

public class IcedService {
          IcedRepository ir;


    public IcedService() throws  SQLException{
        ir = new IcedRepository();

    }


    public IcedService(IcedRepository ir)throws SQLException  {
                this.ir = ir;


    }

          //
    public List<IcedDrinks> getAllIcedDrinks() {

        return ir.getAllIcedDrinks();
    }
    public IcedDrinks getAllIcedDrinksById(int id){
        return ir.getAllIcedDrinksById(id);
    }

    public void removeIcedDrinksByIdNumber(int id ){
       ir.removeIcedDrinksById(id);
    }
    public IcedDrinks updateIcedDrinksById(IcedDrinks icedDrinks){
        return ir.updateIcedDrinksById(icedDrinks);
    }
    public void addIcedDrinks(IcedDrinks drinks) {
        ir.addIcedDrinks(drinks);
    }
}


//

