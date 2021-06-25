package ua.kpi.tef;

/**
 * Created by User on 17.03.2016.
 */
public class Model {
    private String[] words;
private String sentence;

    // The Program logic
public Model()
{
	words = new String[2];
}
public void makeSentence(){
	sentence = words[0] + " " + words[1];	
}
    public int getSentence() {
        return sentence;
    }

    public void setWord(int index, String value) {
        this.words[index] = value;
    }
}
