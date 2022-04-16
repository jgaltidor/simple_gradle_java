package jga.example.gradle;
import org.junit.Test;
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestMain
{
	@Test
	public void testNothing() {
		System.out.println("running a test");
		Assert.assertEquals(500, 500);
	}

	@Test
	public void testReadStream() throws IOException {
		String contents = contentsOfResource("/some_file.txt");
		System.out.println("contents: " + contents);
	}

	private static String contentsOfResource(String resourceName) throws IOException {
		InputStream is = TestMain.class.getResourceAsStream(resourceName);
		InputStreamReader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader);
		StringBuilder sb = new StringBuilder();
		String line = null;
		while((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}
}
