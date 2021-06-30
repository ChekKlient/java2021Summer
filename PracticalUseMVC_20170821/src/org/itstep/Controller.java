package org.itstep;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.Scanner;

public class Controller {
        private Model model;
        private View view;

    // Constants

    // REGEX

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    //Work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);
        int res=0;

        while (true){
            res = inputIntValueWithScannerAndDiapason(sc);
            if (model.checkCode(res)) break;
            if (model.moreThenCode(res)) view.printMessage(View.INPUT_MORE_THEN_CODE);
            else view.printMessage(View.INPUT_LESS_THEN_CODE);
        }
        view.printMessage(View.INPUT_EQUAL_CODE);
        int[] history = model.getHistory();
        view.printMessage(View.NUMBER_ATTEMPTS + history.length);
        for (int i = 0; i < history.length; i++) {
            view.printMessage(View.ATTEMPT + (i+1) + View.IS + history[i]);
        }
    }

        // The Utility methods
    public int inputIntValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_INT_DATA);
        while( ! sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_DATA + View.INPUT_INT_DATA);
            sc.next();
        }
        return sc.nextInt();
    }

    public int inputIntValueWithScannerAndDiapason(Scanner sc) {
        int res=0;
        view.printMessage(view.INPUT_INT_DATA +
                model.getMinBarrier() + " - " + model.getMaxBarrier());

        while( true ) {
            // check int - value
            while (!sc.hasNextInt()) {
                view.printMessage(view.WRONG_INPUT_DATA
                        + view.INPUT_INT_DATA);
                sc.next();
            }
            // check value in diapason
            if ((res = sc.nextInt()) <= model.getMinBarrier() ||
                    res >= model.getMaxBarrier()) {
                view.printMessage(view.WRONG_RANGE_DATA
                        + View.INPUT_INT_DATA);
                continue ;
            }
            break;
        }
        return res;
    }


}
