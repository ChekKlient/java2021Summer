package ua.kpi.tef;

/**
 * Created by Maxim on 26.10.2016.
 */
public class ChildClass extends ParentClass {

    public void otherMethod() {
        int intValue;
        intValue = publicValue;
        intValue = protectedValue;
        intValue = defaultValue;
        //intValue = privateValue;
        intValue = getPrivateValue();
    }
}
