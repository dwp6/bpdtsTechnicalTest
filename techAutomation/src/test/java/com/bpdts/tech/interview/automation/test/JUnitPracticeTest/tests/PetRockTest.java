package com.bpdts.tech.interview.automation.test.JUnitPracticeTest.tests;

import com.bpdts.tech.interview.automation.test.JUnitPracticeTest.PetRock;
import org.junit.Test;

import static org.junit.Assert.*;

public class PetRockTest {

    private PetRock rocky = new PetRock("Rocky");

    @Test
    public void getName() throws Exception {
        assertEquals("Rocky", rocky.getName());
    }

    @Test
    public void testUnhappyToStart() throws Exception {
        assertFalse(rocky.isHappy());
    }

    @Test
    public void testHappyAfterPlay() throws Exception {
        rocky.playWithRock();
        assertTrue(rocky.isHappy());
    }

    //@Ignore ("Exception not defined")
    @Test (expected = IllegalStateException.class)
    public void nameFail() throws Exception {
        rocky.getHappyMessage();
    }

    @Test
    public void name() throws Exception {
        rocky.playWithRock();
        String msg = rocky.getHappyMessage();
        assertEquals("I'm happy", msg);
    }
}
