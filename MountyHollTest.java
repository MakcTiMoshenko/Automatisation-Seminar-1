package org.max.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.max.homework.MountyHoll.CAR_DOOR;
import static org.max.homework.MountyHoll.NUM_DOORS;

public class MountyHollTest {

    @Test
    void checkDoorsNotNull () {
        //given
        //when
        //then
        Assertions.assertTrue(NUM_DOORS > 0);
    }

    @Test
    void checkCarThere () {
        //given
        //when
        //then
        Assertions.assertTrue(CAR_DOOR > 0);
    }
    @Test
    void checkCarIsNotOpenDoor () {
        //given
        int openedDoor;

        Random random = new Random();
        openedDoor = random.nextInt(NUM_DOORS) + 1;

        //when
        //then
        Assertions.assertTrue(CAR_DOOR != openedDoor);
    }
    @Test
    void checkCarIsOpenDoor () {
        //given
        int openedDoor;

        Random random = new Random();
        openedDoor = random.nextInt(NUM_DOORS) + 1;
        //when
        int newDoor;
        newDoor = random.nextInt(NUM_DOORS) +2;
        //then
        Assertions.assertAll(
                () -> Assertions.assertNotEquals(CAR_DOOR, openedDoor),
                () -> Assertions.assertNotEquals(CAR_DOOR, newDoor)
                );
    }

}
