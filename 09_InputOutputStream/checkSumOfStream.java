//package com.company;
import java.io.*;

public class checkSumOfStream {
	public static InputStream getStream(byte [] data)  {
		return new ByteArrayInputStream (data);
	}

	public static int checkSumOfStream(InputStream inputStream) throws IOException {
		DataInputStream dataInputStream = new DataInputStream(inputStream);
		int resultCheckSumOfStream = 0;
		int curByte;

		while ((curByte = dataInputStream.read()) > 0) {
			resultCheckSumOfStream = Integer.rotateLeft(resultCheckSumOfStream,1) ^ curByte;
		}

		return resultCheckSumOfStream;
	}

	public static void main(String[] args) throws IOException {
		InputStream stream;
		stream = getStream( new byte[] { 0x33, 0x45, 0x01} );

		int result;
		result = checkSumOfStream(stream);

		System.out.print(result);
	}
}
