package com.github.com.vikramhalder.stringmapper.reflect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.com.vikramhalder.stringmapper.StringMapper;
import com.github.com.vikramhalder.stringmapper.reflect.service.MapObjectsImpl;

import java.util.HashMap;
import java.util.Map;

public class StringMapperInit {

    @SuppressWarnings("unchecked")
    public StringMapperInit(StringMapper stringMapper, Object json, boolean error) {
        var map = new HashMap<>();
        try {
            if (json instanceof String) {
                map = new ObjectMapper().readValue((String) json, HashMap.class);
            } else if (json instanceof Map) {
                map = (HashMap<Object, Object>) json;
            }
        } catch (Exception exception) {
            if (error) {
                throw new RuntimeException(exception.getMessage());
            }
        }
        var mapObject = new MapObjectsImpl(map).getMapObject();
        try {
            var field = stringMapper.getClass().getDeclaredField("mapObjects");
            field.setAccessible(true);
            field.set(stringMapper, mapObject);
            field.setAccessible(false);
        } catch (Exception ignore) {
        }
    }
}
