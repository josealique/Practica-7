

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

class Tar {
    private String name;
    private RandomAccessFile randomAccessFile;

    // Constructor
    public Tar(String filename) throws Exception {
        this.name = filename;
        this.randomAccessFile= new RandomAccessFile(filename,"r");
    }

    // Torna un array amb la llista de fitxers que hi ha dins el TAR
    public String[] list()  {
        List<String> lista = new ArrayList<>();
        Header header;
        try {
            do {
                header = new Header(randomAccessFile);
                if (header.getSize() < 0) {
                    break;
                }
                int nBytes = header.getSize();
                int diff;
                if ((diff = (nBytes % 512)) != 0) {
                    nBytes += 512 - diff;
                }
                randomAccessFile.skipBytes(nBytes);
                lista.add(header.getName());
            } while(true);
        } catch (Exception e) {}
        System.out.println(lista);
        return lista.toArray(new String[lista.size()]);
    }

    // Torna un array de bytes amb el contingut del fitxer que té per nom
    // igual a l'String «name» que passem per paràmetre
    public byte[] getBytes(String name) {
        return null;
    }

    // Expandeix el fitxer TAR dins la memòria
    public void expand() throws Exception {

    }
}