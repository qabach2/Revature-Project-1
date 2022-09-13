import Entity.HotDrinks;
import Repositories.HotRepository;
import Repositories.IcedRepository;
import Service.HotService;
import Service.IcedService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;

import java.sql.SQLException;



public class ApiServer {
    public static void main(String[] args) throws SQLException {
        HotService hs = new HotService();
        IcedService is = new IcedService();

        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins).start(9000);

        app.get("/allHotDrinks/", ctx -> {
            ctx.json(hs.getAllHotDrinks());
        });

        app.get("/allIcedDrinks/", ctx -> {
            ctx.json(is.getAllIcedDrinks());
        });
        app.get("/allIcedDrinks/", ctx -> {
            ctx.json(is.getAllIcedDrinks());
        });

//        ObjectMapper mapper = new ObjectMapper();
//       HotDrinks requestHotDrinks  = mapper.readValue(ctx.body(), HotDrinks.class);
//       hs.addHotDrinks(requestHotDrinks.getDescription(), requestHotDrinks.getHotDrinksByID());
    }}















