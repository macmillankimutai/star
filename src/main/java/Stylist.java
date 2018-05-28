import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Stylist {
  private String name;
  private String description;
  private int id;

  public Stylist(String name, String description) {
    this.name = name;
    this.description = description;
  }
  public String getName() {
    return name;
  }
  public String getDescription() {
    return description;
  }
  public int getId() {
    return id;
  }
  public static List<Client> getUnassociatedClients(){
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE stylist_id=0";
      return con.createQuery(sql)
        .executeAndFetch(Client.class);
    }
  }
  public void update(String name) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE stylist SET name=:name WHERE id=:id";
      con.createQuery(sql)
        .addParameter("name", name)
        .addParameter("id", id)
        .executeUpdate();
    }
  }
  // public void update(String description) {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "UPDATE stylist SET description=:description WHERE id=:id";
  //     con.createQuery(sql)
  //       .addParameter("description", description)
  //       .addParameter("id", id)
  //       .executeUpdate();
  //   }
  // }
  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM stylist WHERE id = :id ;";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
  public static Stylist find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists where id=:id";
      Stylist stylist = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Stylist.class);
        return stylist;
    }
  }
  public void save(){
    String sql = "INSERT INTO stylist (name, description) VALUE (:name, :description)";
    try(Connection con = DB.sql2o.open()){
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("description", this.description)
        .executeUpdate()
        .getKey();
    }
  }
  public static List<Stylist> all(){
    String sql = "SELECT * FROM stylist";
    try(Connection con = DB.sql2o.open()){
      return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }
}
