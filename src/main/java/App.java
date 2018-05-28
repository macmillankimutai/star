import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
  ProcessBuilder process = new ProcessBuilder();
    Integer port;

    if (process.environment().get("PORT") != null) {
      port = Integer.parseInt(process.environment().get("PORT"));
    } else {
      port = 4567;
    }
    setPort(port);

get("/", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("template", "templates/index.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());
get("/client", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  String name = request.queryParams("name");

  Client myClient = new Client(name);
  model.put("myClient", myClient);

  model.put("template", "templates/client-form.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());
post("/client", (request,response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  String name = request.queryParams("name");
  Client newClient = new Client(name);
  request.session().attribute("client", newClient);
  model.put("template", "template/client.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());
get("/client/update", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  String name = request.queryParams("name");
  Client myClient = new Client(name);
  model.put("myClient", myClient);
  model.put("template", "templates/client-update.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());
post("/client/update", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  String name = request.queryParams("name");
  Client newClient = new Client(name);
  request.session().attribute("client", newClient);
  model.put("template", "template/client.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());
get("/stylist", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  String name = request.queryParams("name");
  String description = request.queryParams("description");

  Stylist myStylist = new Stylist(name, description);
  model.put("myStylist", myStylist);
  model.put("template", "template/stylist.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());
post("/stylist", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  String name = request.queryParams("name");
  String description = request.queryParams("description");
  Stylist newStylist = new Stylist(name, description);
  request.session().attribute("stylist", newStylist);
  model.put("template", "template/stylist.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());
get("/stylist/update", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  String name = request.queryParams("name");
  String description = request.queryParams("description");

  Stylist myStylist = new Stylist(name, description);
  model.put("myStylist", myStylist);
  model.put("template", "template/stylist.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());
post("/stylist/update", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  String name = request.queryParams("name");
  String description = request.queryParams("description");
  Stylist newStylist = new Stylist(name, description);
  request.session().attribute("stylist", newStylist);
  model.put("template", "template/stylist.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());
}
}
