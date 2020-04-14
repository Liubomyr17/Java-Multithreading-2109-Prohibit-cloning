package com.company;

/*

2109 Prohibit cloning

Allow clone class A
Prohibit cloning class B
Allow to clone class C
Don't forget the equals and hashCode methods!

Requirements:
1. Class A must support the Cloneable interface.
2. Class B must be a descendant of class A.
3. When declaring class B, implements Cloneable must not be explicitly specified.
4. The clone method in class B must be redefined so that when trying to clone an object of class B, a CloneNotSupportedException is thrown.
5. Class C must be a descendant of class B.
6. Cloning of class C objects should succeed.


 */

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B implements Cloneable {
        public C(int i, int j, String name) {
            super(i, j, name);
        }
        @Override
        protected C clone() throws CloneNotSupportedException {
            int i = getI();
            int j = getJ();
            String name = getName();
            return new C(i, j, name);
        }
    }

    public static void main(String[] args) {

    }
}
