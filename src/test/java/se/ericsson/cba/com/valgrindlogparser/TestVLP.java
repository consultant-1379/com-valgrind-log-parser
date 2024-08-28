package se.ericsson.cba.com.valgrindlogparser;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;
import java.io.IOException;

import se.ericsson.cba.com.valgrindlogparser.ValgrindLogParserAndReportGenerator;

/**
 * Unit test for ValgrindLogParser.
 */
public class TestVLP extends TestCase
{
	/**
	 * Create the test case
	 * @param testName name of the test case
	 */
	public TestVLP( String testName )
	{
		super( testName );
	}

	/**
	 * Returns suite of tests being tested
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( TestVLP.class );
	}

	/**
	 * Test ValgrindLogParser functionality
	 * @throws IOException
	 */
	public void testVLP() throws IOException
	{
		String FILE_SEPARATOR = System.getProperty("file.separator");
		File vlpReportDirectory = new File("test_stub" + FILE_SEPARATOR + "test_report");

		// Ensure that previous test result is cleared
		if(vlpReportDirectory.exists() && vlpReportDirectory.isDirectory()) {
			deleteFile(vlpReportDirectory);
		}

		vlpReportDirectory.mkdir();
		String args[] = {"test_stub/test_logs", "test_stub/test_report"};
		try {
			ValgrindLogParserAndReportGenerator.main(args);
		} catch(Exception ex) {
			System.out.println("Caught Exception : " + ex);
		}
	}

	/**
	 * Deletes a given file/directory recursively
	 * @param file name of file/directory to be deleted
	 * @throws IOException
	 */
	public void deleteFile(File file) throws IOException {

		if(file.isDirectory()) {
			//directory is empty, then delete it
			if(file.list().length == 0) {
				file.delete();
			} else {
				String files[] = file.list();
				for (String temp : files) {
					//construct the file structure
					File fileDelete = new File(file, temp);

					//recursive delete
					deleteFile(fileDelete);
				}

				//check the directory again, if empty then delete it
				if(file.list().length == 0) {
					file.delete();
				}
			}
		} else {
			//if file, then delete it
			file.delete();
		}
	}
}
