import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.sql.SQLException;
@PropertySource(value = "classpath:config/jdbc.properties")
@SpringBootTest
public class JdbcTest {
    @Autowired
    DataSource dataSource;

    @Test
    public void test() throws SQLException {
        dataSource.getConnection();
        System.out.println(dataSource.getClass());
    }

}
