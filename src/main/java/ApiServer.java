import Entity.HotDrinks;
import Repositories.HotRepository;
import Repositories.IcedRepository;
import Service.HotService;
import Service.IcedService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;

import java.sql.SQLException;



public class ApiServer {
    public static void main(String[] args) throws SQLException {
        HotService hs = new HotService();
        IcedService is = new IcedService();

        Javalin app = Javalin.create().start(8080);

        app.get("/HotDrinks/", ctx -> {ctx.result(hs.getAllHotDrinks().toString());});
}}

//        app.get("/HotDrinks/", ctx ->
//        {
//            ctx.json(is.getAllIcedDrinksById(Integer.parseInt(ctx.pathParam("id_number"))));
//        });
//        app.get("HotDrinks/Drinkid/{id}", ctx -> {
//            ctx.json(hs.getAllHotDrinks()ByID(Integer.parseInt(ctx.pathParam("id"))));
//        });
//        ObjectMapper mapper = new ObjectMapper();
//        HotDrinks requestHotDrinks  = mapper.readValue(ctx.body(), HotDrinks.class);
//        hs.addHotDrinks(requestHotDrinks.getDescription(), requestHotDrinks.getHotDrinksByID());
















