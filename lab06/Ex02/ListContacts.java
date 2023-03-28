package lab06.Ex02;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListContacts implements ContactsInterface{

    private List<Contact> contacts;
    
    public ListContacts() {
        this.contacts = new ArrayList<>();
    }
    
    @Override
    public void openAndLoad(ContactsStorageInterface store) {
        System.out.println(store.loadContacts());
        this.contacts.addAll(store.loadContacts());
    }

    @Override
    public void saveAndClose() {
        if(contacts.size() == 0){
            System.out.println("No contacts to save");
            return;
        }

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the name of the file to save the contacts: ");
        String fileName = input.nextLine();

        ContactsStorageInterface store = new ContactStorage(new File(fileName));

        store.saveContacts(contacts);
        input.close();
    }

    @Override
    public void saveAndClose(ContactsStorageInterface store) {
        if (contacts.size() == 0) {
            System.out.println("No contacts to save");
            return;
        }

        store.saveContacts(contacts);
    }

    @Override
    public boolean exist(Contact contact) {
        boolean existe = false;
        for (Contact c : contacts) {
            if (c.equals(contact)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    @Override
    public Contact getByName(String name) {
        for (Contact c : contacts) {
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean add(Contact contact) {
        if (exist(contact)) {
            return false;
        }
        contacts.add(contact);
        return true;
    }

    @Override
    public boolean remove(Contact contact) {
        if (!exist(contact)) {
            return false;
        }
        contacts.remove(contact);
        return true;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
