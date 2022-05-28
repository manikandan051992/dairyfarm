package ua.vspelykh.dairyfarm.service;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import ua.vspelykh.dairyfarm.model.entity.Cow;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CowServiceTest {

    @Autowired
    private CowService cowService;
    @Test
    void get() {
        Cow cow = cowService.get(3,1);
        assertEquals("9246", cow.getNumber());
    }

    @Test
    void getLazyException(){

    }

    @Test
    void getWithFullInfo() {

        Cow cow = cowService.getWithFullInfo(3,1);
        System.out.println(cow.getInseminations());
        System.out.println(cow.getVaccinations());
        System.out.println(cow.getCalvings());
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }

    @Test
    void update() {
    }

    @Test
    void create() {
    }
}