import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Client {
  private String name;
  private int id;

  public Client(String name, int id) {
    this.name = name;
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public int getId() {
    return id;
  }
  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (name) VALUES (:name)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .executeUpdate()
        .getKey();
    }
  }
  public static List<Client> all(){
    String sql = "SELECT * FROM clients";
    try(Connection con = DB.sql2o.open()){
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }
  public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients where id=:id";
      Client client = con.createQuery(sql)
       .addParameter("id", id)
       .executeAndFetchFirst(Client.class);
       return client;
    }
  }
  public void updateName(String name) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE clients SET name=:name WHERE id=:id";
      con.createQuery(sql)
        .addParameter("id", id)
        .addParameter("name", name)
        .executeUpdate();
    }
  }
  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM clients WHERE id= :id";
      con.createQuery(sql)
       .addParameter("id", id)
       .executeUpdate();
    }
  }
}
