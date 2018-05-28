import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {
  Styist stylist;
  @Rule
  public DatabaseRule database = new DatabaseRule();
  @Test
  public void stylist_instantiatesCorrectly_true() {
    assertTrue(stylist instanceof Stylist);
  }
  @Test
  public void getId_returnsIdOfStylist_true() {
    stylist.save();
    assertTrue(stylist.getId() > 0);
  }
}
