import java.io.*;

public class Header {
    private byte[] name = new byte[100];
    private byte[] mode = new byte[8];
    private byte[] uid = new byte[8];
    private byte[] guid = new byte[8];
    private byte[] size = new byte[12];
    private byte[] mtime = new byte[12];
    private byte[] checksum = new byte[8];
    private byte[] type = new byte[1];
    private byte[] linkname = new byte[100];
    private byte[] magic = new byte[8];
    private byte[] uname = new byte[32];
    private byte[] gname = new byte[32];
    private byte[] dev1 = new byte[8];
    private byte[] dev2 = new byte[8];
    private byte[] file;
    public Header(RandomAccessFile is) throws IOException {
        if (is.read(name) < 0)
            throw new EOFException();

        if (name[0] == '\0') {
            throw new EOFException();
        }

        is.read(mode);
        is.read(uid);
        is.read(guid);
        is.read(size);
        is.read(mtime);
        is.read(checksum);
        is.read(type);
        is.read(linkname);
        is.read(magic);
        is.read(uname);
        is.read(gname);
        is.read(dev1);
        is.read(dev2);
        file = new byte[(int) (512 - (is.getFilePointer() % 512))];
        is.read(file);
        ByteArrayInputStream bos = new ByteArrayInputStream(file);
    }

    public String getName() {
        return new String(name).trim();
    }

    public int getSize() {
        try {
            return Integer.parseInt(new String(size).trim(),8);
        } catch (Exception e){
            return 0;
        }
    }
}
