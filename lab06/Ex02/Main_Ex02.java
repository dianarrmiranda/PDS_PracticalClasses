package lab06.Ex02;

import java.io.File;

public class Main_Ex02 {

    public static void main(String[] args) {
        
        System.out.println("-------------------------------------- Test TXT file --------------------------------------");

        ListContacts listContacts = new ListContacts();

        File file = new File("./lab06/Ex02/Contacts.txt");

        ContactsStorageInterface store = new ContactStorage(file);

        System.out.println("Abrir e carregar o ficheiro");
        listContacts.openAndLoad(store);

        System.out.println("Add Edgar");
        listContacts.add(new Contact("Edgar", "123456789"));
        System.out.println(listContacts.getByName("Edgar"));
        System.out.println("O Edgar existe? " + listContacts.exist(listContacts.getByName("Edgar")));
        


        System.out.println("Remover Costa");
        listContacts.remove(listContacts.getByName("Costa"));
        System.out.println("O Costa existe? " + listContacts.exist(listContacts.getByName("Costa")));
        System.out.println("Add Juliana com o numero 915789325");
        listContacts.add(new Contact("Juliana", "915789325"));
        System.out.println();
        System.out.println("Lista de contactos atualizada");
        for (Contact c : listContacts.getContacts()) {
            System.out.println(c);
        }

        //Guardar num ficheiro txt a lista de contactos
        ContactsStorageInterface store2 = new ContactStorage(new File("./lab06/Ex02/ContactsSave.txt"));
        listContacts.saveAndClose(store2);

        System.out.println();
        System.out.println("-------------------------------------- Test BIN file --------------------------------------");

        ListContacts listContacts2 = new ListContacts();

        File file2 = new File("./lab06/Ex02/Contacts.bin");

        ContactsStorageInterface store3 = new ContactStorage(file2);

        System.out.println("Abrir e carregar o ficheiro");
        listContacts2.openAndLoad(store3);

        System.out.println("Ver contacto com o nome Lourosa");
        System.out.println(listContacts2.getByName("Lourosa"));

        System.out.println("Add José com o numero 936588741");
        listContacts2.add(new Contact("José", "936588741"));
        System.out.println(listContacts2.getByName("José"));
        System.out.println("O José existe? " + listContacts2.exist(listContacts2.getByName("José")));
        System.out.println("Remover Feira");
        listContacts2.remove(listContacts2.getByName("Feira"));
        System.out.println("O Feira existe? " + listContacts2.exist(listContacts2.getByName("Feira")));

        System.out.println();
        System.out.println("Lista de contactos atualizada");
        for (Contact c : listContacts2.getContacts()) {
            System.out.println(c);
        }

        //Guardar num ficheiro bin a lista de contactos
        ContactsStorageInterface store4 = new ContactStorage(new File("./lab06/Ex02/ContactsSave.bin"));
        listContacts2.saveAndClose(store4);



    }

    
}
