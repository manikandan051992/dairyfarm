package ua.vspelykh.dairyfarm;

import ua.vspelykh.dairyfarm.model.entity.Cow;

import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.time.LocalDateTime.*;
import static ua.vspelykh.dairyfarm.model.AbstractBaseEntity.START_SEQ;

public class CowTestData {
    public static final MatcherFactory.Matcher<Cow> COW_MATCHER = MatcherFactory.usingIgnoringFieldsComparator
            (Cow.class, "farm", "vaccinations", "inseminations", "calvings");

    public static final int NOT_FOUND = 20;
    public static final int COW1_ID = START_SEQ + 2;

    public static final int TEST_FARM_ID = 1;

    public static final Cow cow1 = new Cow(COW1_ID, "9246",
            of(2018, Month.JANUARY, 30, 10, 0, 0), 9, 2,
            true, true);
    public static final Cow cow2 = new Cow(COW1_ID + 1, "2890",
            of(2019, Month.DECEMBER, 11, 12, 0, 0), 9, 3,
            true, true);
    public static final Cow cow3 = new Cow(COW1_ID + 2, "1990",
            of(2015, Month.JANUARY, 10, 4, 0, 0), 9, 6,
            true, true);
    public static final Cow cow4 = new Cow(COW1_ID + 3, "1234",
            of(2020, Month.JANUARY, 1, 19, 19, 0), 12, 3,
            true, true);
    public static final Cow cow5 = new Cow(COW1_ID + 4, "9391",
            of(2020, Month.JANUARY, 5, 12, 11, 0), 12, 3,
            true, true);
    public static final Cow cow6 = new Cow(COW1_ID + 5, "3333",
            of(2020, Month.JANUARY, 7, 10, 10, 0), 12, 3,
            true, true);

    public static final List<Cow> COWS_TEST_FARM = List.of(cow1, cow2, cow3, cow4, cow5, cow6);


    public static Cow getNew() {
        return new Cow(null, "3210", of(2020, Month.FEBRUARY, 1, 18, 0), 9);
    }

    public static Cow getUpdated() {
        return new Cow(COW1_ID,"1111", cow1.getBirth().plus(5, ChronoUnit.MINUTES), 10);
    }
}
