package ua.kpi.otherPackadge;

import ua.kpi.tef.ParentClass;

/**
 * Created by Maxim on 26.10.2016.
 */
public class OtherClass {
    private int intValue;
    ParentClass parentClass = new ParentClass();
    public void setPublicValue() {
        this.intValue = parentClass.publicValue;
    }
    public void setProtectedValue() {
        //this.intValue = parentClass.protectedValue;
        this.intValue = parentClass.getProtectedValue();
    }
    public void setDefaultValue() {
        //this.intValue = parentClass.defaultValue;
        this.intValue = parentClass.getDefaultValue();
    }
    public void setPrivateValue() {
        //this.intValue = parentClass.privateValue;
        intValue = parentClass.getPrivateValue();
    }
}
