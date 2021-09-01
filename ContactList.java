

import java.util.*;

public class ContactList {

    private TreeMap<String, Person> contactList=new TreeMap<>();

    public boolean createContact(Person person) {
        if (contactList.containsKey(person.getName())) {
            return false;
        } else {
            contactList.put(person.getName(), person);
            return true;
        }
    }

    public boolean lookupContact(String name) {
        return contactList.containsKey(name);
    }

    public Person getContact(String name) {
        if (contactList.containsKey(name)) {
            return contactList.get(name);
        } else {
            return null;
        }
    }

    public Person[] getContactByRange(String start, String end) {
        if(start.compareTo(end)>=0)
        throw new IllegalArgumentException();
        SortedMap<String,Person> selected=contactList.subMap(start, end);
        Person[] re=new Person[size()];
        int i=0;
        while(!selected.isEmpty()){
            re[i++]=selected.remove(selected.firstKey());
        }
        return re;
    }

    public boolean deleteContact(String name) {
        if(lookupContact(name)){
            contactList.remove(name);
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return contactList.size();
    }

    public String[] fetchAllNames() {
        return (String[])contactList.keySet().toArray(new String[0]);
    }

    public String[] fetchAllPhoneNumbers() {
        TreeSet<String> temp=new TreeSet<>();
        Set<String> nameList=contactList.keySet();
        for (String name : nameList) {
            temp.addAll(contactList.get(name).getPhoneNumbers());
        }
        return (String[])temp.toArray(new String[0]);
    }
}
