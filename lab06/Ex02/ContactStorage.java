package lab06.Ex02;
import java.io.File;
import java.util.List;

public class ContactStorage implements ContactsStorageInterface {
    
    private File file;
    private String extension= "binary";

   public ContactStorage(File file) {
        this.file = file;
        String[] nomeFile = file.getName().split("\\.");
        if(nomeFile.length > 1){
            extension = nomeFile[1];
        }
    }

    @Override
    public List<Contact> loadContacts(){
        ContactsStorageInterface tpStorage; 
        switch (extension) {
            case "txt"://extensao do ficheiro txt
                tpStorage = new ContactStorageTxt(file);
                break;
                
            default://binary file
                tpStorage = new ContactStorageBin(file);
                break;
        }

        return tpStorage.loadContacts();
    }

    @Override
    public boolean saveContacts(List<Contact> list){
        ContactsStorageInterface tpStorage; 
        switch (extension) {
            case "txt"://extensao do ficheiro txt
                tpStorage = new ContactStorageTxt(file);
                break;

            default://binary file
                tpStorage = new ContactStorageBin(file);
                break;
        }

        return tpStorage.saveContacts(list);
    }
}