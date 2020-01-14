package com.bpdts.tech.interview.automation.test.JUnitPracticeTest;

public class PetRock {

    private String name;
    private boolean happy = false;

    public PetRock(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isHappy() {
        return happy;

    }

    public void playWithRock() {
        happy = true;

    }

    public String getHappyMessage() {
        if (!happy) {
            throw new IllegalStateException();
        }
        return "I'm happy";

        }
}
