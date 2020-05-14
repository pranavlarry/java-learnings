package com.pranavlari.Collections;

import java.util.*;

public class Main {


    public static void main(String[] args) {
	// write your code here
        List<String> test  = new ArrayList<>();
        test.addAll(Arrays.asList("Heelo","Hiii","Whats up"));

        Iterator<String> it = test.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }

        List<Name> linkedTest = new LinkedList<>();
        linkedTest.addAll(Arrays.asList(new Name("lari"),new Name("pranav")));
        Iterator<Name> list = linkedTest.listIterator();

        while (list.hasNext()){
            System.out.println(list.next().name);
        }

    }

    private static class Name {
        private String name;
        private Map<String,Integer> testing = new HashMap<>();

        public Name(String name) {
            this.name = name;
            this.testing.put("Hello",1);
            this.testing.put("Hi",2);
        }
    }
}
