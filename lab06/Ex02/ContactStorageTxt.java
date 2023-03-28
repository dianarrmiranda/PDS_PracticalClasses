package lab06.Ex02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactStorageTxt extends ContactStorage {
    private File file;

    public ContactStorageTxt(File file) {
        super(file);
        this.file = file;
    }

    @Override
    public List<Contact> loadContacts() {
        List<Contact> contactos = new ArrayList<>();
        try (Scanner input = new Scanner(new FileReader(file))) {
            while (input.hasNextLine()) {

                String[] line = input.nextLine().split(" +");
                Contact contacto = new Contact(line[0], line[1]);
                contactos.add(contacto);
            }

            input.close();
        } catch (FileNotFoundException e) {
            System.err.printf("ERRO: %s\n", e.getMessage());
        }

        return contactos;

    }

    @Override
    public boolean saveContacts(List<Contact> list) {
        try (PrintWriter output = new PrintWriter(file)) {
            for (Contact contacto : list) {
                output.printf(contacto.toString() + "\n");
            }
            output.close();
            return true;
        } catch (FileNotFoundException e) {
            System.err.printf("ERRO: %s\n", e.getMessage());
            return false;
        }

    }
    

}
