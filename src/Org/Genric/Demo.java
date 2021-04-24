package Org.Genric;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Demo {
	@Test
	public void read() throws IOException {
		FileInputStream fis = new FileInputStream("./config.properties");
		Properties p = new Properties();
		p.load(fis);
		String val = p.getProperty("XLsheet");
		System.out.println(val);
	}

}
