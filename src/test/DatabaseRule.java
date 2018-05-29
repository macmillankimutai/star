import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  @Override
  protected void before() {
    DB.sql2o = new Sql20("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
    }
  @Override
  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String deleteClientQuery = "DELETE FROM clients *;";
      String deleteStylistQuery = "DELETE FROM stylist *;";
      con.createQuery(deleteClientQuery).executeUpdate();
      con.createQuery(deleteStylistQuery).executeUpdate();
    }
  }
  }
}
