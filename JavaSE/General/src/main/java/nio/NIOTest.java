package nio;


import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by shuhaoz on 2017/9/11 00011.
 */
public class NIOTest {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("C:/Users/shuhaoz/Desktop/1.txt");
		FileChannel fc = fos.getChannel();

		String s = "Test";
		ByteBuffer byteBuffer = ByteBuffer.allocate(12);
		byteBuffer.clear();
		byteBuffer.put(s.getBytes());
		byteBuffer.flip();

		while (byteBuffer.hasRemaining()) {
			fc.write(byteBuffer);
		}
		fc.close();
	}
}
