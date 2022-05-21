package com.github.com.vikramhalder.stringmapper.reflect.service;

import com.github.com.vikramhalder.stringmapper.objects.MapObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapObjectsImpl {
    private final MapObject mapObject;

    public MapObject getMapObject() {
        return mapObject;
    }

    public MapObjectsImpl(Map<Object, Object> map) {
        mapObject = new MapObject() {
            @Override
            @SuppressWarnings("unchecked")
            public List<MapObject> getMapList(String key) {
                try {
                    return ((List<Object>) map.get(key)).stream().map(m -> new MapObjectsImpl((Map<Object, Object>) m).getMapObject()).collect(Collectors.toList());
                } catch (Exception ignore) {
                }
                return new ArrayList<>();
            }

            @Override
            @SuppressWarnings("unchecked")
            public MapObject getMap(String key) {
                try {
                    return new MapObjectsImpl((Map<Object, Object>) map.get(key)).getMapObject();
                } catch (Exception ignore) {
                }
                return new MapObjectsImpl(null).getMapObject();
            }


            @Override
            @SuppressWarnings("unchecked")
            public <T> List<T> getList(String key) {
                try {
                    return (List<T>) map.get(key);
                } catch (Exception e) {
                    return null;
                }
            }

            @Override
            @SuppressWarnings("unchecked")
            public <T> T getObject(String key) {
                try {
                    return (T) map.get(key);
                } catch (Exception e) {
                    return null;
                }
            }

            @Override
            public Integer getInteger(String key) {
                try {
                    return Integer.parseInt(map.get(key).toString());
                } catch (Exception e) {
                    return null;
                }
            }

            @Override
            public Float getFloat(String key) {
                try {
                    return Float.parseFloat(map.get(key).toString());
                } catch (Exception e) {
                    return null;
                }
            }

            @Override
            public Double getDouble(String key) {
                try {
                    return Double.parseDouble(map.get(key).toString());
                } catch (Exception e) {
                    return null;
                }
            }

            @Override
            public Boolean getBool(String key) {
                try {
                    return Boolean.parseBoolean(map.get(key).toString());
                } catch (Exception e) {
                    return null;
                }
            }

            @Override
            public String getString(String key) {
                try {
                    return map.get(key).toString();
                } catch (Exception e) {
                    return null;
                }
            }
        };
    }
}
