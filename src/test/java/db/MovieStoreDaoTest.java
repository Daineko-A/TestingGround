package db;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieStoreDaoTest {

    @Test
    public void getInstance() {
    }

    @Test
    public void getMovfieById() {
        MovieStoreDao instance = MovieStoreDao.getInstance();
        assertNotNull(instance.getMovfieById(1L).get());
    }
}