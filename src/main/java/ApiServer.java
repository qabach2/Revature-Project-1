import Entity.HotDrinks;
import Repositories.HotRepository;
import Repositories.IcedRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;

import java.sql.SQLException;



public class ApiServer {
    public static void main(String[] args) throws SQLException {
        HotRepository hr = new HotRepository();
        IcedRepository ir = new IcedRepository();
        Javalin app = Javalin.create().start (8080);
        app.get("/IcedDrinks/", ctx -> {

            ctx.result(hr.getAllHotDrinks().toString());});
        ObjectMapper mapper = new ObjectMapper();
//        HotDrinks requestHotDrinks  = mapper.readValue(ctx.body(), HotDrinks.class);
//        hr.addHotDrinks(requestHotDrinks.getDescription(), requestHotDrinks.getArtistID());


    }
}











