

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
        ArrayList<Person> re=new ArrayList<>(size());
        for (String name : nameList) {
            if(name.compareTo(start)>=0&&name.compareTo(end)<0){
                re.add(contactList.get(name));
            }
        }
        return (Person[])re.toArray();
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
        ArrayList<String> temp=new ArrayList<>();
        for (String name : nameList) {
            temp.addAll(contactList.get(name).getPhoneNumbers());
        }
        return (String[])temp.toArray(new String[0]);
    }
}