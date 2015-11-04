package com.wj2304.screw;

import java.lang.reflect.Array;

import org.junit.Test;

import com.wj2304.screw.support.ArrayProxy;
import com.wj2304.screw.support.ArrayProxyFactoryUsingJavassist;

public class ArrayProxyFactoryUsingJavassistTest {

    @Test
    public void testArrayProxySet() throws Exception {
        int[] a = new int[1];
        ArrayProxy arrayProxy = ArrayProxyFactoryUsingJavassist.INSTANCE
                .getArrayProxy(a.getClass());
        long start = System.currentTimeMillis();
        for(int i = 0;i < 1;i++){
            arrayProxy.set(a, 0, 123);
        }
        System.out.println("Javassist generates class proxy time -> " + (System.currentTimeMillis() - start));
    }
    
    @Test
    public void testArraySet() throws Exception {
        int[] a = new int[1];
        long start = System.currentTimeMillis();
        for(int i = 0;i < 10000000;i++){
            Array.set(a, 0, 123);
        }
        System.out.println("Javassist generates class proxy time -> " + (System.currentTimeMillis() - start));
    }
}
