package se.ericsson.cba.com.valgrindlogparser;

import java.util.ArrayList;

/**
 * ValgrindLeakErrorStackTraceInformation stores the leak/error stack trace information in respective lists.
 *
 * @author  XROHVIJ (Rohit Vijaywargi)
 * @version 1.0.0
 * @since   2015-02-15
 */
public class ValgrindLeakErrorStackTraceInformation{

	private int definitelyLostCount, indirectlyLostCount, possiblyLostCount, stillReachableCount, uninitValueCount, uninitCondCount, invalidWriteCount;
	private int invalidReadCount, invalidJumpCount, invalidMemPoolCount, clientCheckCount;
	private int syscallParamCount, invalidFreeCount, mismatchedFreeCount,  overlapCount;
	private int otherLeakErrorCount, totalLeakErrorCount;

	private int uniqueDefinitelyLostCount, uniqueIndirectlyLostCount, uniquePossiblyLostCount, uniqueStillReachableCount, uniqueUninitValueCount, uniqueUninitCondCount, uniqueInvalidWriteCount;
	private int uniqueInvalidReadCount, uniqueInvalidJumpCount, uniqueInvalidMemPoolCount, uniqueClientCheckCount;
	private int uniqueSyscallParamCount, uniqueInvalidFreeCount, uniqueMismatchedFreeCount, uniqueOverlapCount;
	private int uniqueOtherLeakErrorCount, uniqueTotalLeakErrorCount;

	private ArrayList<ArrayList<String>> definitelyLost;
	private ArrayList<ArrayList<String>> indirectlyLost;
	private ArrayList<ArrayList<String>> possiblyLost;
	private ArrayList<ArrayList<String>> stillReachable;
	private ArrayList<ArrayList<String>> uninitValue;
	private ArrayList<ArrayList<String>> uninitCond;
	private ArrayList<ArrayList<String>> invalidWrite;
	private ArrayList<ArrayList<String>> invalidRead;
	private ArrayList<ArrayList<String>> invalidJump;
	private ArrayList<ArrayList<String>> invalidMemPool;
	private ArrayList<ArrayList<String>> clientCheck;
	private ArrayList<ArrayList<String>> syscallParam;
	private ArrayList<ArrayList<String>> invalidFree;
	private ArrayList<ArrayList<String>> mismatchedFree;
	private ArrayList<ArrayList<String>> overlap;
	private ArrayList<ArrayList<String>> otherLeakError;

	private ArrayList<ArrayList<String>> filesContainingDefinitelyLost;
	private ArrayList<ArrayList<String>> filesContainingIndirectlyLost;
	private ArrayList<ArrayList<String>> filesContainingPossiblyLost;
	private ArrayList<ArrayList<String>> filesContainingStillReachable;
	private ArrayList<ArrayList<String>> filesContainingUninitValue;
	private ArrayList<ArrayList<String>> filesContainingUninitCond;
	private ArrayList<ArrayList<String>> filesContainingInvalidWrite;
	private ArrayList<ArrayList<String>> filesContainingInvalidRead;
	private ArrayList<ArrayList<String>> filesContainingInvalidJump;
	private ArrayList<ArrayList<String>> filesContainingInvalidMemPool;
	private ArrayList<ArrayList<String>> filesContainingClientCheck;
	private ArrayList<ArrayList<String>> filesContainingSyscallParam;
	private ArrayList<ArrayList<String>> filesContainingInvalidFree;
	private ArrayList<ArrayList<String>> filesContainingMismatchedFree;
	private ArrayList<ArrayList<String>> filesContainingOverlap;
	private ArrayList<ArrayList<String>> filesContainingOtherLeakError;

	/**
	 * Constructor
	 */
	public ValgrindLeakErrorStackTraceInformation() {

		definitelyLostCount = 0;
		indirectlyLostCount = 0;
		possiblyLostCount = 0;
		stillReachableCount = 0;
		uninitValueCount = 0;
		uninitCondCount = 0;
		invalidWriteCount = 0;
		invalidReadCount = 0;
		invalidJumpCount = 0;
		invalidMemPoolCount = 0;
		clientCheckCount = 0;
		syscallParamCount = 0;
		invalidFreeCount = 0;
		mismatchedFreeCount = 0;
		overlapCount = 0;
		otherLeakErrorCount = 0;
		totalLeakErrorCount = 0;

		uniqueDefinitelyLostCount = 0;
		uniqueIndirectlyLostCount = 0;
		uniquePossiblyLostCount = 0;
		uniqueStillReachableCount = 0;
		uniqueUninitValueCount = 0;
		uniqueUninitCondCount = 0;
		uniqueInvalidWriteCount = 0;
		uniqueInvalidReadCount = 0;
		uniqueInvalidJumpCount = 0;
		uniqueInvalidMemPoolCount = 0;
		uniqueClientCheckCount = 0;
		uniqueSyscallParamCount = 0;
		uniqueInvalidFreeCount = 0;
		uniqueMismatchedFreeCount = 0;
		uniqueOverlapCount = 0;
		uniqueOtherLeakErrorCount = 0;
		uniqueTotalLeakErrorCount = 0;

		definitelyLost = new ArrayList<ArrayList<String>>();
		indirectlyLost = new ArrayList<ArrayList<String>>();
		possiblyLost = new ArrayList<ArrayList<String>>();
		stillReachable = new ArrayList<ArrayList<String>>();
		uninitValue = new ArrayList<ArrayList<String>>();
		uninitCond = new ArrayList<ArrayList<String>>();
		invalidWrite = new ArrayList<ArrayList<String>>();
		invalidRead = new ArrayList<ArrayList<String>>();
		invalidJump = new ArrayList<ArrayList<String>>();
		invalidMemPool = new ArrayList<ArrayList<String>>();
		clientCheck = new ArrayList<ArrayList<String>>();
		syscallParam = new ArrayList<ArrayList<String>>();
		invalidFree = new ArrayList<ArrayList<String>>();
		mismatchedFree = new ArrayList<ArrayList<String>>();
		overlap = new ArrayList<ArrayList<String>>();
		otherLeakError = new ArrayList<ArrayList<String>>();

		filesContainingDefinitelyLost = new ArrayList<ArrayList<String>>();
		filesContainingIndirectlyLost = new ArrayList<ArrayList<String>>();
		filesContainingPossiblyLost = new ArrayList<ArrayList<String>>();
		filesContainingStillReachable = new ArrayList<ArrayList<String>>();
		filesContainingUninitValue = new ArrayList<ArrayList<String>>();
		filesContainingUninitCond = new ArrayList<ArrayList<String>>();
		filesContainingInvalidWrite = new ArrayList<ArrayList<String>>();
		filesContainingInvalidRead = new ArrayList<ArrayList<String>>();
		filesContainingInvalidJump = new ArrayList<ArrayList<String>>();
		filesContainingInvalidMemPool = new ArrayList<ArrayList<String>>();
		filesContainingClientCheck = new ArrayList<ArrayList<String>>();
		filesContainingSyscallParam = new ArrayList<ArrayList<String>>();
		filesContainingInvalidFree = new ArrayList<ArrayList<String>>();
		filesContainingMismatchedFree = new ArrayList<ArrayList<String>>();
		filesContainingOverlap = new ArrayList<ArrayList<String>>();
		filesContainingOtherLeakError = new ArrayList<ArrayList<String>>();
	}

	/**
	 * Sets the count of definitely lost leak traces to a new value
	 * @param definitelyLostCount count of definitely lost leak traces
	 */
	public void setDefinitelyLostCount(int definitelyLostCount) {
		this.definitelyLostCount = definitelyLostCount;
	}

	/**
	 * Gets the count of definitely lost leak traces
	 * @return definitelyLostCount count of definitely lost leak traces
	 */
	public int getDefinitelyLostCount() {
		return definitelyLostCount;
	}

	/**
	 * Sets the count of indirectly lost leak traces to a new value
	 * @param indirectlyLostCount count of indirectly lost leak traces
	 */
	public void setIndirectlyLostCount(int indirectlyLostCount) {
		this.indirectlyLostCount = indirectlyLostCount;
	}

	/**
	 * Gets the count of indirectly lost leak traces
	 * @return indirectlyLostCount count of indirectly lost leak traces
	 */
	public int getIndirectlyLostCount() {
		return indirectlyLostCount;
	}

	/**
	 * Sets the count of possibly lost leak traces to a new value
	 * @param possiblyLostCount count of possibly lost leak traces
	 */
	public void setPossiblyLostCount(int possiblyLostCount) {
		this.possiblyLostCount = possiblyLostCount;
	}

	/**
	 * Gets the count of possibly lost leak traces
	 * @return possiblyLostCount count of possibly lost leak traces
	 */
	public int getPossiblyLostCount() {
		return possiblyLostCount;
	}

	/**
	 * Sets the count of still reachable leak traces to a new value
	 * @param stillReachableCount count of still reachable leak traces
	 */
	public void setStillReachableCount(int stillReachableCount) {
		this.stillReachableCount = stillReachableCount;
	}

	/**
	 * Gets the count of still reachable leak traces
	 * @return stillReachableCount count of still reachable leak traces
	 */
	public int getStillReachableCount() {
		return stillReachableCount;
	}

	/**
	 * Sets the count of uninitialized value error traces to a new value
	 * @param uninitValueCount count of uninitialized value error traces
	 */
	public void setUninitValueCount(int uninitValueCount) {
		this.uninitValueCount = uninitValueCount;
	}

	/**
	 * Gets the count of uninitialized value error traces
	 * @return uninitValueCount count of uninitialized value error traces
	 */
	public int getUninitValueCount() {
		return uninitValueCount;
	}

	/**
	 * Sets the count of uninitialized conditional jump error traces to a new value
	 * @param uninitCondCount Uninitialized Condition error count
	 */
	public void setUninitCondCount(int uninitCondCount) {
		this.uninitCondCount = uninitCondCount;
	}

	/**
	 * Gets the count of uninitialized conditional jump error traces
	 * @return uninitCondCount Uninitialized Condition error count
	 */
	public int getUninitCondCount() {
		return uninitCondCount;
	}

	/**
	 * Sets the count of invalid write error traces to a new value
	 * @param invalidWriteCount count of invalid write error traces
	 */
	public void setInvalidWriteCount(int invalidWriteCount) {
		this.invalidWriteCount = invalidWriteCount;
	}

	/**
	 * Gets the count of invalid write error traces
	 * @return invalidWriteCount count of invalid write error traces
	 */
	public int getInvalidWriteCount() {
		return invalidWriteCount;
	}

	/**
	 * Sets the count of invalid read error traces to a new value
	 * @param invalidReadCount count of invalid read error traces
	 */
	public void setInvalidReadCount(int invalidReadCount) {
		this.invalidReadCount = invalidReadCount;
	}

	/**
	 * Gets the count of invalid read error traces
	 * @return invalidReadCount count of invalid read error traces
	 */
	public int getInvalidReadCount() {
		return invalidReadCount;
	}

	/**
	 * Sets the count of invalid jump error traces to a new value
	 * @param invalidJumpCount count of invalid jump error traces
	 */
	public void setInvalidJumpCount(int invalidJumpCount) {
		this.invalidJumpCount = invalidJumpCount;
	}

	/**
	 * Gets the count of invalid jump error traces
	 * @return invalidJumpCount count of invalid jump error traces
	 */
	public int getInvalidJumpCount() {
		return invalidJumpCount;
	}

	/**
	 * Sets the count of invalid memory pool error traces to a new value
	 * @param invalidMemPoolCount count of invalid memory pool error traces
	 */
	public void setInvalidMemPoolCount(int invalidMemPoolCount) {
		this.invalidMemPoolCount = invalidMemPoolCount;
	}

	/**
	 * Gets the count of invalid memory pool error traces
	 * @return invalidMemPoolCount count of invalid memory pool error traces
	 */
	public int getInvalidMemPoolCount() {
		return invalidMemPoolCount;
	}

	/**
	 * Sets the count of client check error traces to a new value
	 * @param clientCheckCount count of client check error traces
	 */
	public void setClientCheckCount(int clientCheckCount) {
		this.clientCheckCount = clientCheckCount;
	}

	/**
	 * Gets the count of client check error traces
	 * @return clientCheckCount count of client check error traces
	 */
	public int getClientCheckCount() {
		return clientCheckCount;
	}

	/**
	 * Sets the count of syscall parameter error traces to a new value
	 * @param syscallParamCount count of syscall parameter error traces
	 */
	public void setSyscallParamCount(int syscallParamCount) {
		this.syscallParamCount = syscallParamCount;
	}

	/**
	 * Gets the count of syscall parameter error traces
	 * @return syscallParamCount count of syscall parameter error traces
	 */
	public int getSyscallParamCount() {
		return syscallParamCount;
	}

	/**
	 * Sets the count of invalid free error traces to a new value
	 * @param invalidFreeCount count of invalid free error traces
	 */
	public void setInvalidFreeCount(int invalidFreeCount) {
		this.invalidFreeCount = invalidFreeCount;
	}

	/**
	 * Gets the count of invalid free error traces
	 * @return invalidFreeCount count of invalid free error traces
	 */
	public int getInvalidFreeCount() {
		return invalidFreeCount;
	}

	/**
	 * Sets the count of mismatched free error traces to a new value
	 * @param mismatchedFreeCount count of mismatched free error traces
	 */
	public void setMismatchedFreeCount(int mismatchedFreeCount) {
		this.mismatchedFreeCount = mismatchedFreeCount;
	}

	/**
	 * Gets the count of mismatched free error traces
	 * @return mismatchedFreeCount count of mismatched free error traces
	 */
	public int getMismatchedFreeCount() {
		return mismatchedFreeCount;
	}

	/**
	 * Sets the count of overlap error traces to a new value
	 * @param overlapCount count of overlap error traces
	 */
	public void setOverlapCount(int overlapCount) {
		this.overlapCount = overlapCount;
	}

	/**
	 * Gets the count of overlap error traces
	 * @return overlapCount count of overlap error traces
	 */
	public int getOverlapCount() {
		return overlapCount;
	}

	/**
	 * Sets the count of other leak-error traces to a new value
	 * @param otherLeakErrorCount count of other leak-error traces
	 */
	public void setOtherLeakErrorCount(int otherLeakErrorCount) {
		this.otherLeakErrorCount = otherLeakErrorCount;
	}

	/**
	 * Gets the count of other leak-error traces
	 * @return otherLeakErrorCount count of other leak-error traces
	 */
	public int getOtherLeakErrorCount() {
		return otherLeakErrorCount;
	}

	/**
	 * Sets the count of total leak-error traces to a new value
	 * @param totalLeakErrorCount count of total leak-error traces
	 */
	public void setTotalLeakErrorCount(int totalLeakErrorCount) {
		this.totalLeakErrorCount = totalLeakErrorCount;
	}

	/**
	 * Gets the count of total leak-error traces
	 * @return totalLeakErrorCount count of total leak-error traces
	 */
	public int getTotalLeakErrorCount() {
		return totalLeakErrorCount;
	}

	/**
	 * Sets the count of unique definitely lost leak traces to a new value
	 * @param uniqueDefinitelyLostCount count of unique definitely lost leak traces
	 */
	public void setUniqueDefinitelyLostCount(int uniqueDefinitelyLostCount) {
		this.uniqueDefinitelyLostCount = uniqueDefinitelyLostCount;
	}

	/**
	 * Gets the count of unique definitely lost leak traces
	 * @return uniqueDefinitelyLostCount count of unique definitely lost leak traces
	 */
	public int getUniqueDefinitelyLostCount() {
		return uniqueDefinitelyLostCount;
	}

	/**
	 * Sets the count of unique indirectly lost leak traces to a new value
	 * @param uniqueIndirectlyLostCount count of unique indirectly lost leak traces
	 */
	public void setUniqueIndirectlyLostCount(int uniqueIndirectlyLostCount) {
		this.uniqueIndirectlyLostCount = uniqueIndirectlyLostCount;
	}

	/**
	 * Gets the count of unique indirectly lost leak traces
	 * @return uniqueIndirectlyLostCount count of unique indirectly lost leak traces
	 */
	public int getUniqueIndirectlyLostCount() {
		return uniqueIndirectlyLostCount;
	}

	/**
	 * Sets the count of unique possibly lost leak traces to a new value
	 * @param uniquePossiblyLostCount count of unique possibly lost leak traces
	 */
	public void setUniquePossiblyLostCount(int uniquePossiblyLostCount) {
		this.uniquePossiblyLostCount = uniquePossiblyLostCount;
	}

	/**
	 * Gets the count of unique possibly lost leak traces
	 * @return uniquePossiblyLostCount count of unique possibly lost leak traces
	 */
	public int getUniquePossiblyLostCount() {
		return uniquePossiblyLostCount;
	}

	/**
	 * Sets the count of unique still reachable leak traces to a new value
	 * @param uniqueStillReachableCount count of unique still reachable leak traces
	 */
	public void setUniqueStillReachableCount(int uniqueStillReachableCount) {
		this.uniqueStillReachableCount = uniqueStillReachableCount;
	}

	/**
	 * Gets the count of unique still reachable leak traces
	 * @return uniqueStillReachableCount count of unique still reachable leak traces
	 */
	public int getUniqueStillReachableCount() {
		return uniqueStillReachableCount;
	}

	/**
	 * Sets the count of unique uninitialized value error traces to a new value
	 * @param uniqueUninitValueCount count of unique uninitialized value error traces
	 */
	public void setUniqueUninitValueCount(int uniqueUninitValueCount) {
		this.uniqueUninitValueCount = uniqueUninitValueCount;
	}

	/**
	 * Gets the count of unique uninitialized value error traces
	 * @return uniqueUninitValueCount count of unique uninitialized value error traces
	 */
	public int getUniqueUninitValueCount() {
		return uniqueUninitValueCount;
	}

	/**
	 * Sets the count of unique uninitialized conditional jump error traces to a new value
	 * @param uniqueUninitCondCount count of unique uninitialized conditional jump error traces
	 */
	public void setUniqueUninitCondCount(int uniqueUninitCondCount) {
		this.uniqueUninitCondCount = uniqueUninitCondCount;
	}

	/**
	 * Gets the count of unique uninitialized conditional jump error traces
	 * @return uniqueUninitCondCount count of unique uninitialized conditional jump error traces
	 */
	public int getUniqueUninitCondCount() {
		return uniqueUninitCondCount;
	}

	/**
	 * Sets the count of unique invalid write error traces to a new value
	 * @param uniqueInvalidWriteCount count of unique invalid write error traces
	 */
	public void setUniqueInvalidWriteCount(int uniqueInvalidWriteCount) {
		this.uniqueInvalidWriteCount = uniqueInvalidWriteCount;
	}

	/**
	 * Gets the count of unique invalid write error traces
	 * @return uniqueInvalidWriteCount count of unique invalid write error traces
	 */
	public int getUniqueInvalidWriteCount() {
		return uniqueInvalidWriteCount;
	}

	/**
	 * Sets the count of unique invalid read error traces to a new value
	 * @param uniqueInvalidReadCount count of unique invalid read error traces
	 */
	public void setUniqueInvalidReadCount(int uniqueInvalidReadCount) {
		this.uniqueInvalidReadCount = uniqueInvalidReadCount;
	}

	/**
	 * Gets the count of unique invalid read error traces
	 * @return uniqueInvalidReadCount count of unique invalid read error traces
	 */
	public int getUniqueInvalidReadCount() {
		return uniqueInvalidReadCount;
	}

	/**
	 * Sets the count of unique invalid jump error traces to a new value
	 * @param uniqueInvalidJumpCount count of unique invalid jump error traces
	 */
	public void setUniqueInvalidJumpCount(int uniqueInvalidJumpCount) {
		this.uniqueInvalidJumpCount = uniqueInvalidJumpCount;
	}

	/**
	 * Gets the count of unique invalid jump error traces
	 * @return uniqueInvalidJumpCount count of unique invalid jump error traces
	 */
	public int getUniqueInvalidJumpCount() {
		return uniqueInvalidJumpCount;
	}

	/**
	 * Sets the count of unique invalid memory pool error traces to a new value
	 * @param uniqueInvalidMemPoolCount count of unique invalid memory pool error traces
	 */
	public void setUniqueInvalidMemPoolCount(int uniqueInvalidMemPoolCount) {
		this.uniqueInvalidMemPoolCount = uniqueInvalidMemPoolCount;
	}

	/**
	 * Gets the count of unique invalid memory pool error traces
	 * @return uniqueInvalidMemPoolCount count of unique invalid memory pool error traces
	 */
	public int getUniqueInvalidMemPoolCount() {
		return uniqueInvalidMemPoolCount;
	}

	/**
	 * Sets the count of unique client check error traces to a new value
	 * @param uniqueClientCheckCount count of unique client check error traces
	 */
	public void setUniqueClientCheckCount(int uniqueClientCheckCount) {
		this.uniqueClientCheckCount = uniqueClientCheckCount;
	}

	/**
	 * Gets the count of unique client check error traces
	 * @return uniqueClientCheckCount count of unique client check error traces
	 */
	public int getUniqueClientCheckCount() {
		return uniqueClientCheckCount;
	}

	/**
	 * Sets the count of unique syscall parameter error traces to a new value
	 * @param uniqueSyscallParamCount count of unique syscall parameter error traces
	 */
	public void setUniqueSyscallParamCount(int uniqueSyscallParamCount) {
		this.uniqueSyscallParamCount = uniqueSyscallParamCount;
	}

	/**
	 * Gets the count of unique syscall parameter error traces
	 * @return uniqueSyscallParamCount count of unique syscall parameter error traces
	 */
	public int getUniqueSyscallParamCount() {
		return uniqueSyscallParamCount;
	}

	/**
	 * Sets the count of unique invalid free error traces to a new value
	 * @param uniqueInvalidFree count of unique invalid free error traces
	 */
	public void setUniqueInvalidFreeCount(int uniqueInvalidFreeCount) {
		this.uniqueInvalidFreeCount = uniqueInvalidFreeCount;
	}

	/**
	 * Gets the count of unique invalid free error traces
	 * @return uniqueInvalidFree count of unique invalid free error traces
	 */
	public int getUniqueInvalidFreeCount() {
		return uniqueInvalidFreeCount;
	}

	/**
	 * Sets the count of unique mismatched free error traces to a new value
	 * @param uniqueMismatchedFreeCount count of unique mismatched free error traces
	 */
	public void setUniqueMismatchedFreeCount(int uniqueMismatchedFreeCount) {
		this.uniqueMismatchedFreeCount = uniqueMismatchedFreeCount;
	}

	/**
	 * Gets the count of unique mismatched free error traces
	 * @return uniqueMismatchedFreeCount count of unique mismatched free error traces
	 */
	public int getUniqueMismatchedFreeCount() {
		return uniqueMismatchedFreeCount;
	}

	/**
	 * Sets the count of unique overlap error traces to a new value
	 * @param uniqueOverlapCount count of unique overlap error traces
	 */
	public void setUniqueOverlapCount(int uniqueOverlapCount) {
		this.uniqueOverlapCount = uniqueOverlapCount;
	}

	/**
	 * Gets the count of unique overlap error traces
	 * @return uniqueOverlapCount count of unique overlap error traces
	 */
	public int getUniqueOverlapCount() {
		return uniqueOverlapCount;
	}

	/**
	 * Sets the count of unique other leak-error traces to a new value
	 * @param uniqueOtherLeakErrorCount count of unique other leak-error traces
	 */
	public void setUniqueOtherLeakErrorCount(int uniqueOtherLeakErrorCount) {
		this.uniqueOtherLeakErrorCount = uniqueOtherLeakErrorCount;
	}

	/**
	 * Gets the count of unique other leak-error traces
	 * @return uniqueOtherLeakErrorCount count of unique other leak-error traces
	 */
	public int getUniqueOtherLeakErrorCount() {
		return uniqueOtherLeakErrorCount;
	}

	/**
	 * Sets the count of unique total leak-error traces to a new value
	 * @param uniqueTotalLeakErrorCount count of unique total leak-error traces
	 */
	public void setUniqueTotalLeakErrorCount(int uniqueTotalLeakErrorCount) {
		this.uniqueTotalLeakErrorCount = uniqueTotalLeakErrorCount;
	}

	/**
	 * Gets the count of unique total leak-error traces
	 * @return uniqueTotalLeakErrorCount count of unique total leak-error traces
	 */
	public int getUniqueTotalLeakErrorCount() {
		return uniqueTotalLeakErrorCount;
	}

	/**
	 * Gets the definitely lost leak information list
	 * @return definitelyLost definitely lost leak information list
	 */
	public ArrayList<ArrayList<String>> getDefinitelyLostLeakInformationList() {
		return definitelyLost;
	}

	/**
	 * Gets the indirectly lost leak information list
	 * @return indirectlyLost indirectly lost leak information list
	 */
	public ArrayList<ArrayList<String>> getIndirectlyLostLeakInformationList() {
		return indirectlyLost;
	}

	/**
	 * Gets the possibly lost leak information list
	 * @return possiblyLost possibly lost leak information list
	 */
	public ArrayList<ArrayList<String>> getPossiblyLostLeakInformationList() {
		return possiblyLost;
	}

	/**
	 * Gets the still reachable leak information list
	 * @return stillReachable still reachable leak information list
	 */
	public ArrayList<ArrayList<String>> getStillReachableLeakInformationList() {
		return stillReachable;
	}

	/**
	 * Gets the uninitialized value error information list
	 * @return uninitValue uninitialized value error information list
	 */
	public ArrayList<ArrayList<String>> getUninitValueErrorInformationList() {
		return uninitValue;
	}

	/**
	 * Gets the uninitialized conditional jump error information list
	 * @return uninitCond uninitialized conditional jump error information list
	 */
	public ArrayList<ArrayList<String>> getUninitCondErrorInformationList() {
		return uninitCond;
	}

	/**
	 * Gets the invalid write error information list
	 * @return invalidWrite invalid write error information list
	 */
	public ArrayList<ArrayList<String>> getInvalidWriteErrorInformationList() {
		return invalidWrite;
	}

	/**
	 * Gets the invalid read error information list
	 * @return invalidRead invalid read error information list
	 */
	public ArrayList<ArrayList<String>> getInvalidReadErrorInformationList() {
		return invalidRead;
	}

	/**
	 * Gets the invalid jump error information list
	 * @return invalidJump invalid jump error information list
	 */
	public ArrayList<ArrayList<String>> getInvalidJumpErrorInformationList() {
		return invalidJump;
	}

	/**
	 * Gets the invalid memory pool error information list
	 * @return invalidMemPool invalid memory pool error information list
	 */
	public ArrayList<ArrayList<String>> getInvalidMemPoolErrorInformationList() {
		return invalidMemPool;
	}

	/**
	 * Gets the client check error information list
	 * @return clientCheck client check error information list
	 */
	public ArrayList<ArrayList<String>> getClientCheckErrorInformationList() {
		return clientCheck;
	}

	/**
	 * Gets the syscall parameter error information list
	 * @return syscallParam syscall parameter error information list
	 */
	public ArrayList<ArrayList<String>> getSyscallParamErrorInformationList() {
		return syscallParam;
	}

	/**
	 * Gets the invalid free error information list
	 * @return invalidFree invalid free error information list
	 */
	public ArrayList<ArrayList<String>> getInvalidFreeErrorInformationList() {
		return invalidFree;
	}

	/**
	 * Gets the mismatched free error information list
	 * @return mismatchedFree mismatched free error information list
	 */
	public ArrayList<ArrayList<String>> getMismatchedFreeErrorInformationList() {
		return mismatchedFree;
	}

	/**
	 * Gets the overlap error information list
	 * @return overlap overlap error information list
	 */
	public ArrayList<ArrayList<String>> getOverlapErrorInformationList() {
		return overlap;
	}

	/**
	 * Gets the other leak-error information list
	 * @return otherLeakError other leak-error information list
	 */
	public ArrayList<ArrayList<String>> getOtherLeakErrorInformationList() {
		return otherLeakError;
	}

	/**
	 * Gets the list holding the valgrind log file names in which definitely lost leaks were reported
	 * @return filesContainingDefinitelyLost file names list for the definitely lost leak type
	 */
	public ArrayList<ArrayList<String>> getFileNamesListForDefinitelyLostLeakType() {
		return filesContainingDefinitelyLost;
	}

	/**
	 * Gets the list holding the valgrind log file names in which indirectly lost leaks were reported
	 * @return filesContainingIndirectlyLost file names list for the indirectly lost leak type
	 */
	public ArrayList<ArrayList<String>> getFileNamesListForIndirectlyLostLeakType() {
		return filesContainingIndirectlyLost;
	}

	/**
	 * Gets the list holding the valgrind log file names in which possibly lost leaks were reported
	 * @return filesContainingPossiblyLost file names list for the possibly lost leak type
	 */
	public ArrayList<ArrayList<String>> getFileNamesListForPossiblyLostLeakType() {
		return filesContainingPossiblyLost;
	}

	/**
	 * Gets the list holding the valgrind log file names in which still reachable leaks were reported
	 * @return filesContainingStillReachable file names list for the still reachable leak type
	 */
	public ArrayList<ArrayList<String>> getFileNamesListForStillReachableLeakType() {
		return filesContainingStillReachable;
	}

	/**
	 * Gets the list holding the valgrind log file names in which uninitialized value errors were reported
	 * @return filesContainingUninitValue file names list for the uninitialized value error type
	 */
	public ArrayList<ArrayList<String>> getFileNamesListForUninitValueErrorType() {
		return filesContainingUninitValue;
	}

	/**
	 * Gets the list holding the valgrind log file names in which uninitialized conditional jump errors were reported
	 * @return filesContainingUninitCond file names list for the uninitialized conditional jump error type
	 */
	public ArrayList<ArrayList<String>> getFileNamesListForUninitCondErrorType() {
		return filesContainingUninitCond;
	}

	/**
	 * Gets the list holding the valgrind log file names in which invalid write errors were reported
	 * @return filesContainingInvalidWrite file names list for the invalid write error type
	 */
	public ArrayList<ArrayList<String>> getFileNamesListForInvalidWriteErrorType() {
		return filesContainingInvalidWrite;
	}

	/**
	 * Gets the list holding the valgrind log file names in which invalid read errors were reported
	 * @return filesContainingInvalidRead file names list for the invalid read error type
	 */
	public ArrayList<ArrayList<String>> getFileNamesListForInvalidReadErrorType() {
		return filesContainingInvalidRead;
	}

	/**
	 * Gets the list holding the valgrind log file names in which invalid jump errors were reported
	 * @return filesContainingInvalidJump file names list for the invalid jump error type
	 */
	public ArrayList<ArrayList<String>> getFileNamesListForInvalidJumpErrorType() {
		return filesContainingInvalidJump;
	}

	/**
	 * Gets the list holding the valgrind log file names in which invalid memory pool errors were reported
	 * @return filesContainingInvalidMemPool file names list for the invalid memory pool error type
	 */
	public ArrayList<ArrayList<String>> getFileNamesListForInvalidMemPoolErrorType() {
		return filesContainingInvalidMemPool;
	}

	/**
	 * Gets the list holding the valgrind log file names in which client check errors were reported
	 * @return filesContainingClientCheck file names list for the client check error type
	 */
	public ArrayList<ArrayList<String>> getFileNamesListForClientCheckErrorType() {
		return filesContainingClientCheck;
	}

	/**
	 * Gets the list holding the valgrind log file names in which syscall parameter errors were reported
	 * @return filesContainingSyscallParam file names list for the syscall parameter error type
	 */
	public ArrayList<ArrayList<String>> getFileNamesListForSyscallParamErrorType() {
		return filesContainingSyscallParam;
	}

	/**
	 * Gets the list holding the valgrind log file names in which invalid free errors were reported
	 * @return filesContainingInvalidFree file names list for the invalid free error type
	 */
	public ArrayList<ArrayList<String>> getFileNamesListForInvalidFreeErrorType() {
		return filesContainingInvalidFree;
	}

	/**
	 * Gets the list holding the valgrind log file names in which mismatched free errors were reported
	 * @return filesContainingMismatchedFree file names list for the mismatched free error type
	 */
	public ArrayList<ArrayList<String>> getFileNamesListForMismatchedFreeErrorType() {
		return filesContainingMismatchedFree;
	}

	/**
	 * Gets the list holding the valgrind log file names in which overlap errors were reported
	 * @return filesContainingOverlap file names list for the overlap error type
	 */
	public ArrayList<ArrayList<String>> getFileNamesListForOverlapErrorType() {
		return filesContainingOverlap;
	}

	/**
	 * Gets the list holding the valgrind log file names in which other leaks-errors were reported
	 * @return filesContainingOtherLeakError file names list for the other leak-error type
	 */
	public ArrayList<ArrayList<String>> getFileNamesListForOtherLeakErrorType() {
		return filesContainingOtherLeakError;
	}
}

