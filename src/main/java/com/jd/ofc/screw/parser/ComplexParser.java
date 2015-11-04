package com.jd.ofc.screw.parser;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.jd.ofc.screw.exception.ScrewException;

public abstract class ComplexParser implements Parser{

    public static Class<?> getImplClass(Class<?> clazz) {
        if (clazz.isInterface() || Modifier.isAbstract(clazz.getModifiers())) {
            if (Collection.class.isAssignableFrom(clazz)) {
                Class<?> ret = ArrayList.class;
                if (List.class.isAssignableFrom(clazz))
                    ret = ArrayList.class;
                else if (Queue.class.isAssignableFrom(clazz)
                        || Deque.class.isAssignableFrom(clazz))
                    ret = LinkedList.class;
                else if (SortedSet.class.isAssignableFrom(clazz))
                    ret = TreeSet.class;
                else if (Set.class.isAssignableFrom(clazz))
                    ret = HashSet.class;
                return ret;
            } else if (Map.class.isAssignableFrom(clazz)) {
                Class<?> ret = HashMap.class;
                if (SortedMap.class.isAssignableFrom(clazz))
                    ret = TreeMap.class;
                return ret;
            }
            throw new ScrewException("not support the type " + clazz);
        } else
            return clazz;
    }
}
