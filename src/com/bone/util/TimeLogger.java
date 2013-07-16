package com.bone.util;

public class TimeLogger {
	private final long[] timeStamps = new long[2];
	private int index = 0;
	public TimeLogger(){
		timeStamps[(index++)%2]=System.currentTimeMillis();
	}
	public long getTimeDiff(){
		timeStamps[(index++)%2]=System.currentTimeMillis();
		return Math.abs(timeStamps[0]-timeStamps[1]);
	}
}
