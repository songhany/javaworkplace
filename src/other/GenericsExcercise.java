package other;

import java.util.ArrayList;

public class GenericsExcercise {

    public static void main(String[] args) {
        ArrayList<Object> variables = new ArrayList<Object>();

        // Add differnt Object types to the list
        Double doubleNumber = 1.5;
        String name = "Songhan Yu";
        Integer intNumber = 1;
        Character letter = 'a';
        variables.add(doubleNumber);
        variables.add(name);
        variables.add(intNumber);
        variables.add(letter);

        for (Object variable : variables) {
            GenericsExcercise.displayClassName(variable);
        }
    }

    static<T> void displayClassName(T variable) {
        System.out.println(variable.getClass().getName());
    }
}
