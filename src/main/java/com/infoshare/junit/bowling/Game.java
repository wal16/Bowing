package com.infoshare.junit.bowling;

public class Game {

    public static final int FRAMES_TOTAL = 10;
    private int frameCount;
    private int rollCount;
    private int[][] frames = new int[12][2];

    public void roll(int pins) {
        frames[frameCount][rollCount++] = pins;
        if (isStrike(frameCount)) {
            frames[frameCount][rollCount++] = 0;
        }
        if (rollCount == 2) {
            frameCount++;
            rollCount = 0;
        }
    }

    public int score() {
        int result = 0;
        for (int frameIndex = 0; frameIndex< FRAMES_TOTAL; frameIndex++) {
            result += getFrameTotal(frameIndex);
            if (isStrike(frameIndex)) {
                result += getStrikeBonus(frameIndex);
            }else if (isSpare(frameIndex)) {
                result += getSpareBonus(frameIndex);
            }
        }
        return result;
    }

    private int getStrikeBonus(int frameIndex) {
        int bonus = getFrameTotal(frameIndex + 1);
        if (frameIndex<FRAMES_TOTAL && isStrike(frameIndex+1)) {
            bonus += getFrameTotal(frameIndex+1);
        }
        return bonus;
    }

    private boolean isStrike(int frameIndex) {
        return frames[frameIndex][0]==10;
    }

    private boolean isSpare(int frameIndex) {
        return getFrameTotal(frameIndex) ==10;
    }

    private int getSpareBonus(int frameIndex) {
        return getFirstRollAt(frameIndex+1);
    }

    private int getFrameTotal(int frameIndex) {
        return frames[frameIndex][0] + frames[frameIndex][1];
    }

    private int getFirstRollAt(int frameIndex) {
        return frames[frameIndex][0];
    }


}
