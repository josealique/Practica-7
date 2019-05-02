import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class Tar {
    private String name;

    // Constructor
    public Tar(String filename) throws Exception {
        this.name = filename;
    }

    // Torna un array amb la llista de fitxers que hi ha dins el TAR
    public String[] list() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(name));
        String[] lista = new String[0];
        byte[] bytes = new byte[100];
        for (int i = 0; i < bytes.length; i++) {
            int c = fileInputStream.read();
            if (c == 100){
                c
            }
        }
        return null;
    }

    // Torna un array de bytes amb el contingut del fitxer que té per nom
    // igual a l'String «name» que passem per paràmetre
    public byte[] getBytes(String name) {
        return null;
    }

    // Expandeix el fitxer TAR dins la memòria
    public void expand() throws Exception {
//        FileInputStream inputStream = new FileInputStream(new File(name));
//        for (int i = 0; i < inputStream.read(); i++) {
//            byte[] test = new byte[100];
//            inputStream.read(test);
//            System.out.println(new String(test));
//        }
    }
}