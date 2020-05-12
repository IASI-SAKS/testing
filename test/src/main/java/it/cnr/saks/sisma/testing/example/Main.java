package it.cnr.saks.sisma.testing.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static jbse.meta.Analysis.ass3rt;

public class Main {
    private static final SimpleRestClient cl = new SimpleRestClient();
    private static boolean a, b;

    public static boolean getResult() {
        Object ret = null;
        Method testPostMethod = null;

        try {
            testPostMethod = SimpleRestClient.class.getMethod("testPost");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            ret = testPostMethod.invoke(cl);
        } catch (IllegalAccessException | InvocationTargetException | NullPointerException e) {
            e.printStackTrace();
            return false;
        }

        return (boolean)ret;
    }

    public static void m(int x) {
        if (x > 0) {
            a = true;
        } else {
            a = false;
        }
        if (x > 0) {
            b = true;
        } else {
            b = false;
        }
        ass3rt(a == b);
    }

    public static void main(String[] args) {
        int i = Integer.parseInt((args[1]));
        m(i);
    }
}