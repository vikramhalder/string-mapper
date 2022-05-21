package com.github.com.vikramhalder.stringmapper.objects;

import java.util.List;

public interface MapList<E> extends List<E> {
    E get(int index);
}
