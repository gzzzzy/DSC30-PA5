

import java.util.*;

public class ContactList {

    private HashMap<String, Person> contactList=new HashMap<>();
    TreeSet<String> nameList=new TreeSet<>();

    public boolean createContact(Person person) {
        if (contactList.containsKey(person.getName())) {
            return false;
        } else {
            contactList.put(person.getName(), person);
            nameList.add(person.getName());
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
        Set<String> selected=nameList.subSet(start, end);
        ArrayList<Person> re=new ArrayList<>(size());
        for (String name : selected) {
            re.add(contactList.get(name));
        }
        return (Person[])re.toArray(new Person[0]);
    }

    public boolean deleteContact(String name) {
        if(lookupContact(name)){
            contactList.remove(name);
            nameList.remove(name);
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return contactList.size();
    }

    public String[] fetchAllNames() {
        return (String[])nameList.toArray(new String[0]);
    }

    public String[] fetchAllPhoneNumbers() {
        TreeSet<String> temp=new TreeSet<>();
        for (String name : nameList) {
            temp.addAll(contactList.get(name).getPhoneNumbers());
        }
        return (String[])temp.toArray(new String[0]);
    }
}
