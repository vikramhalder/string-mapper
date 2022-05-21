package com.github.com.vikramhalder.stringmapper;

import com.github.com.vikramhalder.stringmapper.objects.MapObject;
import com.github.com.vikramhalder.stringmapper.reflect.StringMapperInit;

import java.util.HashMap;

public class StringMapper {
    private final Object json;
    private MapObject mapObjects;
    private boolean errorMessage = false;

    public StringMapper(String json) {
        this.json = json;
    }

    public StringMapper(HashMap<?, ?> map) {
        this.json = map;
    }

    public StringMapper setErrorMessage(boolean error) {
        errorMessage = error;
        return this;
    }

    public MapObject map() {
        new StringMapperInit(this, json, errorMessage);
        return mapObjects;
    }
}
