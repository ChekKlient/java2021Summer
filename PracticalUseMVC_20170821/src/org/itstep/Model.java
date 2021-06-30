package org.itstep;

import java.util.concurrent.ThreadLocalRandom;

public class Model {
    public static int MIN_SICRET_CODE = 0;
    public static int MAX_SICRET_CODE = 100;
    private int value;
     private int minBarrier;
    private int maxBarrier;
    private int sicretCode;
    private int[] history;
    private int attempts;

    public Model(){
        sicretCode = ThreadLocalRandom.current().nextInt(MIN_SICRET_CODE, MAX_SICRET_CODE+1);
        minBarrier = MIN_SICRET_CODE;
        maxBarrier = MAX_SICRET_CODE;
        history = new int[MAX_SICRET_CODE-MIN_SICRET_CODE+1];
    }

    public int getMinBarrier() {
        return minBarrier;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }

    public boolean checkCode(int res) {
        if(res<=maxBarrier && res>=minBarrier){
            history[attempts] = res;
            attempts++;
        }
        return res == sicretCode;
    }

    public boolean moreThenCode(int res) {

        if (res > sicretCode) maxBarrier = res;
        else minBarrier = res;
        return res > sicretCode;
    }
    public int[] getHistory(){
        int [] resHistory = new int[attempts];
        for (int i = 0; i < attempts; i++) {
            resHistory[i] = history[i];
        }
        return resHistory;
    }
}
