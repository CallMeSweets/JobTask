package logic.file.readers;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class SmallFileReader implements Reader {

    @Override
    public String readFile(String filePath) throws IOException {
        RandomAccessFile reader = new RandomAccessFile(filePath, "r");
        FileChannel channel = reader.getChannel();

        int bufferSize = 6000;
        if (bufferSize > channel.size()) {
            bufferSize = (int) channel.size();
        }
        ByteBuffer buff = ByteBuffer.allocate(bufferSize);
        channel.read(buff);
        buff.flip();

        String input = new String(buff.array());

        channel.close();
        reader.close();

        return input;
    }
}
