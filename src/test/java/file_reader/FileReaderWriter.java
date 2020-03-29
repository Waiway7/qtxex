package file_reader;

import java.io.File;
import java.io.FileReader;
import java.net.URL;

import org.testng.annotations.Test;

public class FileReaderWriter{
	
	public void canReadFromFileUsingFileReader(String pathName) throws Exception {
		Thread.sleep(1000);
		
		File file = new File(pathName);
		FileReader reader = null;
		try {
			reader = new FileReader(file.getPath());
			int line;
			while((line = reader.read()) != -1) {
				System.out.print((char) line);	
			}
			System.out.println("");
			file.delete();
		}	
		finally {
			if(reader != null) {
				reader.close();
			}
		}
	}

}