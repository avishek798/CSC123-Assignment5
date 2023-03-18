// AUTHOR: AVISHEK BARUA
// EMAIL: abarua3@toromail.csudh.edu
// DATE: 03/14/2023

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) throws IOException {

		String sourceInput = args[0];
		String targetInput = args[1];

		File sourceF = new File(sourceInput);

		if (!sourceF.exists() || !sourceF.isFile()) {

			System.out.println("ERROR WITH SOURCE FILE.");
			System.exit(0);

		}

		File targetF = new File(targetInput);
		File dir = new File(targetF.getParent());

		if (targetF.exists()) {

			System.out.println("TARGET FILE ALREADY EXISTS.");
			System.exit(0);
		}

		dir.mkdirs();
		targetF.createNewFile();

		FileInputStream in = new FileInputStream(sourceF);
		FileOutputStream out = new FileOutputStream(targetF);

		int totalBytesSource = in.available();

		byte[] bytes = new byte[totalBytesSource];
		in.read(bytes);

		out.write(bytes);

		out.flush();
		in.close();
		out.close();

		System.out.println(totalBytesSource + " BYTES COPIED FROM " + sourceF.getPath() + " TO " + targetF.getPath());

	}

}
