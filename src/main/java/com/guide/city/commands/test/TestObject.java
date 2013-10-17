package com.guide.city.commands.test;


import com.guide.city.helpers.Views;
import org.codehaus.jackson.map.annotate.JsonView;

public class TestObject {

    @JsonView(Views.Public.class)
    private int intValue;

    @JsonView(Views.Public.class)
    private float floatValue;

    @JsonView(Views.Public.class)
    private String stringValue;

    @JsonView(Views.Private.class)
    private String hiddenString;

    public TestObject(){
        intValue = 100;
        floatValue = 3.14f;
        stringValue = "Test string value";
        hiddenString = "Hidden String";
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }


    public float getFloatValue() {
        return floatValue;
    }

    public void setFloatValue(float floatValue) {
        this.floatValue = floatValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getHiddenString() {
        return hiddenString;
    }

    public void setHiddenString(String hiddenString) {
        this.hiddenString = hiddenString;
    }
}
