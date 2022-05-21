package com.github.com.vikramhalder.stringmapper.objects;

import java.util.List;

public interface MapObject {
    List<MapObject> getMapList(String key);

    <T> List<T> getList(String key);

    MapObject getMap(String key);

    <T> T getObject(String key);

    Integer getInteger(String key);

    Float getFloat(String key);

    Double getDouble(String key);

    Boolean getBool(String key);

    String getString(String key);
}