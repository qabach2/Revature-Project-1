import Entity.HotDrinks;
import Entity.MakeOrder;
import Repositories.HotRepository;
import Repositories.IcedRepository;
import Service.HotService;
import Service.IcedService;
import Service.MakeOrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;

import java.sql.SQLException;



public class ApiServer {
    public static void main(String[] args) throws SQLException {
        HotService hs = new HotService();
        IcedService is = new IcedService();
        MakeOrderService mos = new MakeOrderService();
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins).start(9000);


        app.get("/allHotDrinks/", ctx -> {
            ctx.json(hs.getAllHotDrinks());
        });

        app.get("/allIcedDrinks/", ctx -> {
            ctx.json(is.getAllIcedDrinks());
        });
        app.get("/allMakeOrder/", ctx -> {
            ctx.json(mos.getAllMakeOrder());
        });
        app.get("MakeOrder{id}", ctx ->
        {
            ctx.json(mos.getMakeOrderById(Integer.parseInt(ctx.pathParam("id"))));
        });

        app.get("MakeOrder/Customer_Id/{id}", ctx -> {
            ctx.json(mos.getMakeOrderById(Integer.parseInt(ctx.pathParam("id"))));
        });


        app.get("/MakeOrder/Customer_Name/{name}", ctx -> {
            ctx.json(mos.getMakeOrderByName(ctx.pathParam("name")));
        });


        app.post("MakeOrder", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            MakeOrder requestMakeOrder = mapper.readValue(ctx.body(), MakeOrder.class);
            mos.addMakeOrder(requestMakeOrder.getCustomer_Id(), requestMakeOrder.getCustomer_Name(), requestMakeOrder.getDrink_Name());
        });


//        app.put("MakeOrder/Customer_Id/{id}", ctx -> {
//            ObjectMapper mapper = new ObjectMapper();
//            MakeOrder requestMakeOrder = mapper.readValue(ctx.body(), MakeOrder.class);
//           ctx. json(mos.updateMakeOrderById(requestMakeOrder.getCustomer_Id(),requestMakeOrder.getCustomer_Name(), requestMakeOrder.getDrink_Name());
//        });
        app.delete("MakeOrder/Customer_Id/{id}", ctx-> {
            mos.removeMakeOrderById(Integer.parseInt(ctx.pathParam("id")));});
//

        app.delete("/MakeOrder/Customer_Name/{name}",ctx -> {
            mos.removeMakeOrderByName(ctx.pathParam("name"));});



//
    }}




//


//
//















