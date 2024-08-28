package se.ericsson.cba.com.valgrindlogparser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * ValgrindReportGenerator generates valgrind report in html format.
 *
 * @author  XROHVIJ (Rohit Vijaywargi)
 * @version 1.0.0
 * @since   2015-02-15
 */
public class ValgrindReportGenerator {

	private static final String FILE_SEPARATOR = System.getProperty("file.separator");

	/**
	 * Prints Valgrind Report
	 * @param vlesti ValgrindLeakErrorStackTraceInformation instance
	 * @param outputDirectory Directory where the valgrind report will be generated
	 * @param invalidValgrindXMLLogsMap Map containing invalid XML file name as key and exception message as value
	 * @throws IOException
	 */
	public void printValgrindReport(ValgrindLeakErrorStackTraceInformation vlesti, String outputDirectory, HashMap<String, String> invalidValgrindXMLLogsMap) throws IOException {

		BufferedWriter writerObj;

		// index.html
		writerObj = new BufferedWriter(new FileWriter(outputDirectory +  FILE_SEPARATOR + "valgrind_report.html"));
		writerObj.write("<html>");
		writerObj.write("<head>");
		writerObj.write("<title>Valgrind Log Parser</title>");
		writerObj.write("</head>");

		writerObj.write("<frameset rows=\"120,*\">");
		writerObj.write("	<frame name=\"report\" src=\"rep.html\" marginheight=\"0\" marginwidth=\"0\" scrolling=\"no\" noresize>");
		if(!(invalidValgrindXMLLogsMap.size() == 0)) {
			writerObj.write("	<frame name=\"content\" src=\"InvalidValgrindLogFiles.html\" marginheight=\"0\" marginwidth=\"0\" scrolling=\"no\" noresize>");
		} else {
			writerObj.write("	<frame name=\"content\" src=\"Leak_DefinitelyLost.html\" marginheight=\"0\" marginwidth=\"0\" scrolling=\"no\" noresize>");
		}
		writerObj.write("</frameset>");
		writerObj.write("</html>");
		writerObj.close();

		// rep.html
		writerObj = new BufferedWriter(new FileWriter(outputDirectory + FILE_SEPARATOR + "rep.html"));
		writerObj.write("<html>");
		writerObj.write("<head>");
		writerObj.write("<title>Valgrind Leak/Error Report</title>");
		writerObj.write("<style type=\"text/css\">");
		writerObj.write("body {");
		writerObj.write("	font-family:verdana,arial,sans-serif;");
		writerObj.write("	font-size:10pt;");
		writerObj.write("	margin:10px;");
		writerObj.write("	background-color:#a08029;");
		writerObj.write("	}");
		writerObj.write("th {");
		writerObj.write("	font-size:9pt;");
		writerObj.write("	}");
		writerObj.write("td {");
		writerObj.write("	font-size:9pt;");
		writerObj.write("	}");
		writerObj.write("</style>");
		writerObj.write("</head>");
		writerObj.write("<body>");
		writerObj.write("<div STYLE=\" height: 100%; width: 100%; overflow: auto; \">");
		if(!(invalidValgrindXMLLogsMap.size() == 0)) {
			writerObj.write("<a href=\"InvalidValgrindLogFiles.html\" target=\"content\"><font color=\"red\"><b>Warning</b></font></a>");
		}
		writerObj.write("	<table border=\"1\" cellpadding=\"1\" cellspacing=\"0\" width=\"100%\">");

		writerObj.write("		<tr><th colspan=18 bgcolor=#FAF0E6>Valgrind Report</th></tr>");
		writerObj.write("		<tr>");
		writerObj.write("		<th bgcolor=#D3D3D3>Leak/Error Type</th>");
		writerObj.write("		<th bgcolor=#FF0000><a href=Leak_DefinitelyLost.html target=content>Leak<br>Definitely Lost</a></th>");
		writerObj.write("		<th bgcolor=#FF0000><a href=Leak_IndirectlyLost.html target=content>Leak<br>Indirectly Lost</a></th>");
		writerObj.write("		<th bgcolor=#FF0000><a href=Leak_PossiblyLost.html target=content>Leak<br>Possibly Lost</a></th>");
		writerObj.write("		<th bgcolor=#FF0000><a href=Leak_StillReachable.html target=content>Leak<br>Still Reachable</a></th>");
		writerObj.write("		<th bgcolor=#FF0000><a href=UninitValue.html target=content>Uninit<br>Value</a></th>");
		writerObj.write("		<th bgcolor=#FF0000><a href=UninitCondition.html target=content>Uninit<br>Condition</a></th>");
		writerObj.write("		<th bgcolor=#FF0000><a href=InvalidWrite.html target=content>Invalid<br>Write</a></th>");
		writerObj.write("		<th bgcolor=#FFA500><a href=InvalidRead.html target=content>Invalid<br>Read</a></th>");
		writerObj.write("		<th bgcolor=#FFA500><a href=InvalidJump.html target=content>Invalid<br>Jump</a></th>");
		writerObj.write("		<th bgcolor=#FFA500><a href=InvalidMemPool.html target=content>Illegal<br>MemPool</a></th>");
		writerObj.write("		<th bgcolor=#FFA500><a href=ClientCheck.html target=content>Client<br>Check</a></th>");
		writerObj.write("		<th bgcolor=#FFFF00><a href=SyscallParam.html target=content>Syscall<br>Param</a></th>");
		writerObj.write("		<th bgcolor=#FFFF00><a href=InvalidFree.html target=content>Invalid<br>Free</a></th>");
		writerObj.write("		<th bgcolor=#FFFF00><a href=MismatchedFree.html target=content>Mismatched<br>Free</a></th>");
		writerObj.write("		<th bgcolor=#FFFF00><a href=Overlap.html target=content>Overlap</a></th>");
		writerObj.write("		<th bgcolor=#87CEEB><a href=OtherLeaks.html target=content>Other<br>Leak(s)/Error(s)</a></th>");
		writerObj.write("		<th bgcolor=#D3D3D3>Total<br>Leak(s)/Error(s)</th>");
		writerObj.write("		</tr>");

		writerObj.write("		<tr>");
		writerObj.write("		<th bgcolor=#D3D3D3>Frequency with repeated occurrence</th>");
		writerObj.write("		<td align=center bgcolor=#FF0000>" + vlesti.getDefinitelyLostCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FF0000>" + vlesti.getIndirectlyLostCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FF0000>" + vlesti.getPossiblyLostCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FF0000>" + vlesti.getStillReachableCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FF0000>" + vlesti.getUninitValueCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FF0000>" + vlesti.getUninitCondCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FF0000>" + vlesti.getInvalidWriteCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FFA500>" + vlesti.getInvalidReadCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FFA500>" + vlesti.getInvalidJumpCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FFA500>" + vlesti.getInvalidMemPoolCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FFA500>" + vlesti.getClientCheckCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FFFF00>" + vlesti.getSyscallParamCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FFFF00>" + vlesti.getInvalidFreeCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FFFF00>" + vlesti.getMismatchedFreeCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FFFF00>" + vlesti.getOverlapCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#87CEEB>" + vlesti.getOtherLeakErrorCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#D3D3D3>" + vlesti.getTotalLeakErrorCount() + "</td>");
		writerObj.write("		</tr>");

		writerObj.write("		<tr>");
		writerObj.write("		<th bgcolor=#D3D3D3>Frequency without repeated occurrence</th>");
		writerObj.write("		<td align=center bgcolor=#FF0000>" + vlesti.getUniqueDefinitelyLostCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FF0000>" + vlesti.getUniqueIndirectlyLostCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FF0000>" + vlesti.getUniquePossiblyLostCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FF0000>" + vlesti.getUniqueStillReachableCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FF0000>" + vlesti.getUniqueUninitValueCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FF0000>" + vlesti.getUniqueUninitCondCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FF0000>" + vlesti.getUniqueInvalidWriteCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FFA500>" + vlesti.getUniqueInvalidReadCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FFA500>" + vlesti.getUniqueInvalidJumpCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FFA500>" + vlesti.getUniqueInvalidMemPoolCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FFA500>" + vlesti.getUniqueClientCheckCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FFFF00>" + vlesti.getUniqueSyscallParamCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FFFF00>" + vlesti.getUniqueInvalidFreeCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FFFF00>" + vlesti.getUniqueMismatchedFreeCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#FFFF00>" + vlesti.getUniqueOverlapCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#87CEEB>" + vlesti.getUniqueOtherLeakErrorCount() + "</td>");
		writerObj.write("		<td align=center bgcolor=#D3D3D3>" + vlesti.getUniqueTotalLeakErrorCount() + "</td>");
		writerObj.write("		</tr>");

		writerObj.write("	</table>");
		writerObj.write("</div>");
		writerObj.write("</body>");
		writerObj.write("</html>");
		writerObj.close();

		// InvalidValgrindLogFiles.html
		if(!(invalidValgrindXMLLogsMap.size() == 0)) {
			writerObj = new BufferedWriter(new FileWriter(outputDirectory + FILE_SEPARATOR + "InvalidValgrindLogFiles.html"));
			writerObj.write("<html>");
			writerObj.write("<head>");
			writerObj.write("<title>Invalid Valgrind Log Files</title>");
			writerObj.write("<style type=\"text/css\">");
			writerObj.write("body {");
			writerObj.write("	font-family:verdana,arial,sans-serif;");
			writerObj.write("	font-size:10pt;");
			writerObj.write("	margin:10px;");
			writerObj.write("	background-color:#a08029;");
			writerObj.write("	}");
			writerObj.write("th {");
			writerObj.write("	font-size:9pt;");
			writerObj.write("	}");
			writerObj.write("td {");
			writerObj.write("	font-size:9pt;");
			writerObj.write("	}");
			writerObj.write("</style>");
			writerObj.write("</head>");
			writerObj.write("<body>");
			writerObj.write("<div STYLE=\" height: 100%; width: 100%; overflow: auto; \">");
			writerObj.write("<table border=0 align=center>");
			writerObj.write("<tr bgcolor=\"red\">");
			writerObj.write("<td align=\"center\"><h2>WARNING : </h2><h4>The following Valgrind XML Logs have been skipped while generating valgrind report</h4></td>");
			writerObj.write("</tr>");
			ArrayList<String> logNames = new ArrayList<String>(invalidValgrindXMLLogsMap.keySet());
			for(String logName : logNames) {
				writerObj.write("<tr bgcolor=\"#FAF0E6\">");
				writerObj.write("<td><font color=\"red\"><b>Invalid XML Log : " + logName + "</b></font><br/><font color=\"black\">" + invalidValgrindXMLLogsMap.get(logName) + "</font></td>");
				writerObj.write("</tr>");
			}
			writerObj.write("</table>");
			writerObj.write("</div>");
			writerObj.write("</body>");
			writerObj.write("</html>");
			writerObj.close();
		}

		printTraceInfo(outputDirectory, "Leak_DefinitelyLost", vlesti.getDefinitelyLostLeakInformationList(), vlesti.getFileNamesListForDefinitelyLostLeakType());
		printTraceInfo(outputDirectory, "Leak_IndirectlyLost", vlesti.getIndirectlyLostLeakInformationList(), vlesti.getFileNamesListForIndirectlyLostLeakType());
		printTraceInfo(outputDirectory, "Leak_PossiblyLost", vlesti.getPossiblyLostLeakInformationList(), vlesti.getFileNamesListForPossiblyLostLeakType());
		printTraceInfo(outputDirectory, "Leak_StillReachable", vlesti.getStillReachableLeakInformationList(), vlesti.getFileNamesListForStillReachableLeakType());
		printTraceInfo(outputDirectory, "UninitValue", vlesti.getUninitValueErrorInformationList(), vlesti.getFileNamesListForUninitValueErrorType());
		printTraceInfo(outputDirectory, "UninitCondition", vlesti.getUninitCondErrorInformationList(), vlesti.getFileNamesListForUninitCondErrorType());
		printTraceInfo(outputDirectory, "InvalidWrite", vlesti.getInvalidWriteErrorInformationList(), vlesti.getFileNamesListForInvalidWriteErrorType());
		printTraceInfo(outputDirectory, "InvalidRead", vlesti.getInvalidReadErrorInformationList(), vlesti.getFileNamesListForInvalidReadErrorType());
		printTraceInfo(outputDirectory, "InvalidJump", vlesti.getInvalidJumpErrorInformationList(), vlesti.getFileNamesListForInvalidJumpErrorType());
		printTraceInfo(outputDirectory, "InvalidMemPool", vlesti.getInvalidMemPoolErrorInformationList(), vlesti.getFileNamesListForInvalidMemPoolErrorType());
		printTraceInfo(outputDirectory, "ClientCheck", vlesti.getClientCheckErrorInformationList(), vlesti.getFileNamesListForClientCheckErrorType());
		printTraceInfo(outputDirectory, "SyscallParam", vlesti.getSyscallParamErrorInformationList(), vlesti.getFileNamesListForSyscallParamErrorType());
		printTraceInfo(outputDirectory, "InvalidFree", vlesti.getInvalidFreeErrorInformationList(), vlesti.getFileNamesListForInvalidFreeErrorType());
		printTraceInfo(outputDirectory, "MismatchedFree", vlesti.getMismatchedFreeErrorInformationList(), vlesti.getFileNamesListForMismatchedFreeErrorType());
		printTraceInfo(outputDirectory, "Overlap", vlesti.getOverlapErrorInformationList(), vlesti.getFileNamesListForOverlapErrorType());
		printTraceInfo(outputDirectory, "OtherLeaks", vlesti.getOtherLeakErrorInformationList(), vlesti.getFileNamesListForOtherLeakErrorType());
	}

	/**
	 * Prints trace information related to particular leak/error type in respective html file
	 * @param outputDirectory Directory where the valgrind report will be generated
	 * @param leakType type of leak/error
	 * @param traceInfoList list containing trace information related to particular leak/error type
	 * @param filesContainingStackTrace list containing file names in which leak/error stack traces belonging to particular type occurred
	 * @throws IOException
	 */
	public void printTraceInfo(String outputDirectory, String leakType, ArrayList<ArrayList<String>> traceInfoList, ArrayList<ArrayList<String>> filesContainingStackTrace) throws IOException {

		BufferedWriter writerObj = new BufferedWriter(new FileWriter(outputDirectory + FILE_SEPARATOR + leakType + ".html"));

		writerObj.write("<html>");
		writerObj.write("<head>");
		writerObj.write("<title>Valgrind Leak/Error Report</title>");
		writerObj.write("<style type=\"text/css\">");
		writerObj.write("body {");
		writerObj.write("	font-family:verdana,arial,sans-serif;");
		writerObj.write("	font-size:10pt;");
		writerObj.write("	margin:10px;");
		writerObj.write("	background-color:#a08029;");
		writerObj.write("	}");
		writerObj.write("th {");
		writerObj.write("	font-size:9pt;");
		writerObj.write("	}");
		writerObj.write("td {");
		writerObj.write("	font-size:9pt;");
		writerObj.write("	}");
		writerObj.write("</style>");
		writerObj.write("</head>");
		writerObj.write("<body>");
		writerObj.write("<div STYLE=\" height: 100%; width: 100%; overflow: auto; \">");

		writerObj.write("<table border=0 align=center>");

		if(leakType.equals("Leak_DefinitelyLost") || leakType.contains("Leak_IndirectlyLost") || leakType.contains("Leak_PossiblyLost") || leakType.contains("Leak_StillReachable") || leakType.contains("UninitValue") || leakType.contains("UninitCondition") || leakType.contains("InvalidWrite")) {
			writerObj.write("<tr bgcolor=\"#FF0000\">");
		} else if(leakType.contains("InvalidRead") || leakType.contains("InvalidJump") || leakType.contains("InvalidMemPool") || leakType.contains("ClientCheck")) {
			writerObj.write("<tr bgcolor=\"#FFA500\">");
		} else if(leakType.contains("SyscallParam") || leakType.contains("InvalidFree") || leakType.contains("MismatchedFree") || leakType.contains("Overlap")) {
			writerObj.write("<tr bgcolor=\"#FFFF00\">");
		} else {
			writerObj.write("<tr bgcolor=\"#87CEEB\">");
		}

		if(traceInfoList.size() == 0) {
			writerObj.write("<th>" + leakType + "</th></tr>");
			writerObj.write("<tr bgcolor=\"#FAF0E6\">");
			writerObj.write("<td align=\"center\">No Leak of this type occurred</td></tr>");
		} else {

			writerObj.write("<th colspan=4>" + leakType + "</th></tr>");

			if(leakType.contains("Leak_DefinitelyLost") || leakType.contains("Leak_IndirectlyLost") || leakType.contains("Leak_PossiblyLost") || leakType.contains("Leak_StillReachable") || leakType.contains("UninitValue") || leakType.contains("UninitCondition") || leakType.contains("InvalidWrite")) {
				writerObj.write("<tr bgcolor=\"#FF0000\">");
			} else if(leakType.contains("InvalidRead") || leakType.contains("InvalidJump") || leakType.contains("InvalidMemPool") || leakType.contains("ClientCheck")) {
				writerObj.write("<tr bgcolor=\"#FFA500\">");
			} else if(leakType.contains("SyscallParam") || leakType.contains("InvalidFree") || leakType.contains("MismatchedFree") || leakType.contains("Overlap")) {
				writerObj.write("<tr bgcolor=\"#FFFF00\">");
			} else {
				writerObj.write("<tr bgcolor=\"#87CEEB\">");
			}

			writerObj.write("<th>Leak/Error Number</th>");
			writerObj.write("<th>Leak/Error Stack Trace</th>");
			writerObj.write("<th>Frequency count of Leak/Error</th>");
			writerObj.write("<th>Valgrind Logs in which Leak/Error occured</th>");
			writerObj.write("</tr>");

			for(int i = 0; i < traceInfoList.size(); i++) {

				writerObj.write("<tr bgcolor=\"#FAF0E6\">");

				//Leak/Error Number
				writerObj.write("<td>" + (i + 1) + "</td>");

				//Leak/Error Stack Trace
				writerObj.write("<td>");
				writerObj.write("");
				writerObj.write("<div style=\"width:100%; max-height:250px; overflow:auto\">");
				String leakErrorTrace[] = traceInfoList.get(i).get(0).split("%");
				for(String leakErrorLine : leakErrorTrace) {
					String str[] = leakErrorLine.split(" ");
					for(String st : str) {
						if(!(st.equals("===="))) {
							writerObj.write(st + " ");
						}
					}
					writerObj.write("<br>");
				}
				writerObj.write("</div>");
				writerObj.write("");
				writerObj.write("</td>");

				//Frequency count of Leak/Error
				writerObj.write("<td>" + traceInfoList.get(i).get(1) + "</td>");

				//Files in which Leak/Error occured
				writerObj.write("<td>");
				writerObj.write("");
				writerObj.write("<div style=\"width:100%; max-height:250px; overflow:auto\">");
				for(String fileName : filesContainingStackTrace.get(i)) {
					writerObj.write(fileName + "<br>");
				}
				writerObj.write("</div>");
				writerObj.write("");
				writerObj.write("</td>");

				writerObj.write("</tr>");
			} // for
		} // else
		writerObj.write("</table>");
		writerObj.write("</div>");
		writerObj.write("</body>");
		writerObj.write("</html>");
		writerObj.close();
	}
}
