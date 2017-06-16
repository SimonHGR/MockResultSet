import com.dancingcloudservices.mockresultset.MockResultSet;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class NewEmptyJUnitTest {
  @Test
  public void emptyTableGivesFalseOnInitialNext() throws Throwable {
    MockResultSet mockResultSet = new MockResultSet(new String[][]{});
    assertThat(mockResultSet.next(), is(false));
  }
  
  @Test
  public void singleTableRowGivesTrueThenFalseOnNext() throws Throwable {
    MockResultSet mockResultSet = new MockResultSet(new String[][]{
      {"A Row!"}
    });
    assertThat(mockResultSet.next(), is(true));
    assertThat(mockResultSet.next(), is(false));    
  }

  @Test
  public void singleTableRowGivesDataOnNext() throws Throwable {
    MockResultSet mockResultSet = new MockResultSet(new String[][]{
      {"A Row!"}
    });
    
    mockResultSet.next();
    
    assertThat(mockResultSet.getString(1), is("A Row!"));    
  }
}
