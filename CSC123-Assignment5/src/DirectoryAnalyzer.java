// AUTHOR: AVISHEK BARUA
// EMAIL: abarua3@toromail.csudh.edu
// DATE: 03/14/2023
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DirectoryAnalyzer {

	public static void main(String[] args) throws IOException {

		ArrayList<DirectoryAnalyzerBackEnd> storage = new ArrayList<DirectoryAnalyzerBackEnd>();

		String userDirectory = args[0];

		File dir = new File(userDirectory);

		if (!dir.exists()) {

			System.out.print("THE DIRECTORY DOES NOT EXIST.");
		}

		if (!dir.isDirectory()) {

			System.out.println("THE INPUT IS NOT A DIRECTORY");
		}

		if (!dir.canRead()) {

			System.out.println("THE DIRECTORY CANNOT BE READ");
		}

		System.out.println("File Name\t\tSize\t\tAlpha Chars\t\tNumeric Chars\t\tSpaces");
		for (File f : dir.listFiles()) {

			DirectoryAnalyzerBackEnd fileObj = new DirectoryAnalyzerBackEnd(f);
			storage.add(fileObj);
			fileObj.setSize(f);
			fileObj.setAlphaCount(f);
			fileObj.setNumCount(f);
			fileObj.setSpaceCount(f);

			System.out.println(fileObj);

		}

		int totalDiskSize = 0;
		int totalAlphaChar = 0;
		int totalNumericChar = 0;
		int totalSpaceChar = 0;
		for (DirectoryAnalyzerBackEnd e : storage) {
			totalDiskSize += e.getFileSize();
			totalAlphaChar += e.getAlphaCounter();
			totalNumericChar += e.getNumCounter();
			totalSpaceChar += e.getSpaceCounter();

		}
		System.out.println();
		System.out.println("TOTAL FILES\t\t\t: " + storage.size());
		System.out.println("TOTAL ALPHA CHARS\t\t: " + totalAlphaChar);
		System.out.println("TOTAL NUMERIC CHARS\t\t: " + totalNumericChar);
		System.out.println("TOTAL SPACE CHARS\t\t: " + totalSpaceChar);
		System.out.println();

		if (totalDiskSize < 1024)
			System.out.println("TOTAL SIZE DISK: " + totalDiskSize + " bytes");
		else if (totalDiskSize >= 1024 && totalDiskSize < 1024000)
			System.out.println("TOTAL SIZE DISK: " + totalDiskSize / 1024 + " KB");
		else if (totalDiskSize >= 1024000 && totalDiskSize < 1.024e+9)
			System.out.println("TOTAL SIZE DISK: " + totalDiskSize / 1024000 + " MB");
		else if (totalDiskSize >= 1.024e+9 && totalDiskSize < 1.024e+12)
			System.out.println("TOTAL SIZE DISK: " + totalDiskSize / 1.024e+9 + " GB");

	}

}
