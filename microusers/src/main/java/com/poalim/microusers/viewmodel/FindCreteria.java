package com.poalim.microusers.viewmodel;

import java.io.Serializable;
import java.util.List;

public class FindCreteria implements Serializable {
    private List<String> NameStartWith;

    public FindCreteria(List<String> nameStartWith) {
        NameStartWith = nameStartWith;

    }

    public FindCreteria() {

    }

    public List<String> getNameStartWith() {
        return NameStartWith;
    }

    public void setNameStartWith(List<String> nameStartWith) {
        NameStartWith = nameStartWith;
    }


    @Override
    public String toString() {
        return "FindCreteria{" +
                "NameStartWith=" + NameStartWith +
                '}';
    }
}
