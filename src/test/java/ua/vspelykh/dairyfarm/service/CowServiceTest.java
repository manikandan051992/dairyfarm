package ua.vspelykh.dairyfarm.service;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.vspelykh.dairyfarm.model.AbstractBaseEntity;
import ua.vspelykh.dairyfarm.model.entity.Cow;
import ua.vspelykh.dairyfarm.util.exception.NotFoundException;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ua.vspelykh.dairyfarm.CowTestData.*;

class CowServiceTest extends AbstractServiceTest{

    @Autowired
    private CowService cowService;
    @Test
    void get() {
        Cow actual = cowService.get(cow1.getId(),TEST_FARM_ID);
        COW_MATCHER.assertMatch(cow1, actual);
    }

    @Test
    void getLazyInitialization(){
        Cow actual = cowService.get(cow1.getId(),TEST_FARM_ID);
        assertThrows(LazyInitializationException.class, () -> System.out.println(actual.getVaccinations()));
    }

    @Test
    void getNotOwnFarm(){
        assertThrows(NotFoundException.class, () -> cowService.get(cow1.getId(), TEST_FARM_ID + 1));
    }

    //TODO:
//    @Test
//    void getNotOwnUser(){
//
//    }

    @Test
    void getWithFullInfo() {
        Cow actual = cowService.getWithFullInfo(cow1.getId(), TEST_FARM_ID);
        assertEquals(cow1, actual);
    }

    @Test
    void getWithFullInfoGraph(){
        Cow actual = cowService.getWithFullInfo(cow1.getId(), TEST_FARM_ID);
        assertDoesNotThrow(()->{
            actual.getCalvings().forEach(System.out::println);
            actual.getInseminations().forEach(System.out::println);
            actual.getVaccinations().forEach(System.out::println);
        });
    }

    @Test
    void delete() {
        cowService.delete(cow1.getId(), TEST_FARM_ID);
        assertThrows(NotFoundException.class,() -> cowService.get(cow1.getId(), TEST_FARM_ID));
    }

    @Test
    void deleteNotFound(){
        assertThrows(NotFoundException.class, () -> cowService.delete(NOT_FOUND, TEST_FARM_ID));
    }

//    @Test
//    void deleteNotOwn(){
//
//    }

    @Test
    void getAll() {
        List<Cow> actual = cowService.getAll(TEST_FARM_ID)
                .stream().sorted(Comparator.comparing(AbstractBaseEntity::getId)).toList();
        COW_MATCHER.assertMatch(actual, COWS_TEST_FARM);
    }

    @Test
    void update() {
        Cow updated = getUpdated();
        cowService.update(updated, TEST_FARM_ID);
        COW_MATCHER.assertMatch(cowService.get(COW1_ID, TEST_FARM_ID), getUpdated());
    }

    @Test
    void create() {
        Cow created = cowService.create(getNew(), TEST_FARM_ID);
        int newId = created.getId();
        Cow newCow = getNew();
        newCow.setId(newId);
        COW_MATCHER.assertMatch(created, newCow);
        COW_MATCHER.assertMatch(cowService.get(newId, TEST_FARM_ID), newCow);
    }
}