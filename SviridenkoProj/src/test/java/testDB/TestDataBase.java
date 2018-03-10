package testDB;
import libs.DataBase;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TestDataBase {

    Logger logger = Logger.getLogger(getClass());
    DataBase database;

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        database = new DataBase("MySQL_PADB_DB", "MySQL");
    }

    @After
    public void tearDown() throws SQLException {
        database.quit();
    }

    @Test
    public void testWithDataBase() throws SQLException {
        List<Map<String,String>> testData = database.selectTable("select * from seleniumTable");
//        logger.info(testData.get(305));
        database.modifyTable("INSERT INTO seleniumTable VALUES (305,'Sviridenko','pass')");
        logger.info(database.selectTable("select * from seleniumTable where login='Sviridenko'"));
        logger.info(database.selectTable("select * from seleniumTable where idNumber = 305"));

    }


}
