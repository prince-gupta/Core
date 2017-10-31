package com.company.serialization.file;

import com.company.serialization.Parent;

import java.io.Serializable;

/**
 * Created by princegupta on 05/09/17.
 */
public class SerializationBox implements Serializable{


    private Integer variable = 10;

    private Parent parent = new Parent();

    public Integer getVariable() {
        return variable;
    }

    public void setVariable(Integer variable) {
        this.variable = variable;
    }
}
