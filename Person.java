

import java.util.*;

public class Person {

    private String name;
    TreeSet<String> phoneNumberList;

    public Person(String name, ArrayList<String> pnArray) {
        this.name = name;
        phoneNumberList = new TreeSet<>(pnArray);
    }

    public String getName() {
        return name;
    }

    public boolean addPhoneNumber(String pn) {
        if (phoneNumberList.contains(pn))
            return false;
        phoneNumberList.add(pn);
        return true;
    }

    public ArrayList<String> getPhoneNumbers() {
        return new ArrayList<>(phoneNumberList);
    }

    public boolean deletePhoneNumber(String pn) {
        if (pn == null || phoneNumberList.size() == 1)
            throw new IllegalArgumentException();
        if (phoneNumberList.remove(pn)) {
            return true;
        } else {
            return false;
        }
    }
}
