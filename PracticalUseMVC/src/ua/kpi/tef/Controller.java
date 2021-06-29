package ua.kpi.tef;
import java.util.Scanner;

/**
 * Created by User on 17.03.2016.
 */
public class Controller {
    // The Constants
    public static final double PI = 3.14;
    public static final int FOUR = 4;

    // The Regex
    // ?nick@mail.com?
    public static final String REGEX_MAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    // ?http://www.my-site.com?
    public static final String REGEX_URL = "^((https?|ftp)\\:\\/\\/)?([a-z0-9]{1})((\\.[a-z0-9-])|([a-z0-9-]))*\\.([a-z]{2,6})(\\/?)$";
    // ?+38(044)555-55-55?
    public static final String REGEX_PHONE = "^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
  public static final String HELLO = "Hello";
  public static final String WORLD = "world!";

    // Constructor
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser() {
        Scanner sc = new Scanner(System.in);

        view.printMessage(View.INPUT_DATA);
        model.setWord(0, inputValueWithScanner(sc, HELLO));
        model.setWord(1, inputValueWithScanner(sc, WORLD));
        model.makeSentence();

        view.printMessageAndValue(View.OUR_SENTENCE, model.getSentence());
    }

    // The Utility methods
    public String inputValueWithScanner(Scanner sc, String correctValue) {
        String value = sc.next();
        if (!value.equals(correctValue)) {
            view.printMessage(View.WRONG_INPUT_DATA + View.INPUT_DATA);
            return "";
        }
        return value;
    }
}
