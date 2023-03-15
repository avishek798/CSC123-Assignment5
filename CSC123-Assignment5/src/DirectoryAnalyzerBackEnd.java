// AUTHOR: AVISHEK BARUA
// EMAIL: abarua3@toromail.csudh.edu
// DATE: 03/14/2023
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DirectoryAnalyzerBackEnd {

	private int alphaCounter = 0;
	private int numCounter = 0;
	private int spaceCounter = 0;
	private int fileSize = 0;
	String fileName;

	public DirectoryAnalyzerBackEnd(File f) {

		fileName = f.getName();
	}

	public void setAlphaCount(File f) throws IOException {

		FileInputStream in = new FileInputStream(f);

		byte[] bytes = new byte[in.available()];
		in.read(bytes);

		for (byte b : bytes) {
			if (Character.isLetter((char) b)) {
				alphaCounter++;
			}

		}
		in.close();
	}

	public void setNumCount(File f) throws IOException {

		FileInputStream in = new FileInputStream(f);

		byte[] bytes = new byte[in.available()];
		in.read(bytes);

		for (byte b : bytes) {
			if (Character.isDigit((char) b)) {
				numCounter++;
			}

		}
		in.close();
	}

	public void setSpaceCount(File f) throws IOException {

		FileInputStream in = new FileInputStream(f);

		byte[] bytes = new byte[in.available()];
		in.read(bytes);

		for (byte b : bytes) {
			if (Character.isWhitespace((char) b)) {
				spaceCounter++;
			}

		}
		in.close();
	}

	public void setSize(File f) throws IOException {

		FileInputStream in = new FileInputStream(f);

		fileSize = in.available();

		in.close();

	}

	public int getFileSize() {
		return fileSize;
	}

	public int getAlphaCounter() {
		return alphaCounter;
	}

	public int getNumCounter() {
		return numCounter;
	}

	public int getSpaceCounter() {
		return spaceCounter;
	}

	public String toString() {
		return fileName + "\t\t" + fileSize + " bytes\t    " + alphaCounter + "\t\t\t     " + numCounter + "\t\t\t  "
				+ spaceCounter;

	}
}
