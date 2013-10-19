/**
 * 
 */
/**
 * @author Teja
 *
 */
package com.WebQ.frontEnd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

public class CheatCheck {
    static int interval;
    static Timer timer;

    private static final String TASKLIST = "tasklist";
    private static final String KILL = "taskkill /IM ";

    public static int isProcessRunning(String serviceName) throws Exception {

	int count = 0;
	Process p = Runtime.getRuntime().exec(TASKLIST);
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		p.getInputStream()));
	String line;
	while ((line = reader.readLine()) != null) {

	    // System.out.println(line);
	    if (line.contains(serviceName)) {
		++count;
	    }
	}

	return count;

    }

    public static void killProcess(String serviceName) throws Exception {

	Runtime.getRuntime().exec(KILL + serviceName);

    }

    public static void main(String[] args) {
	int delay = 1000;
	int period = 1000;

	timer = new Timer();
	interval = 60;
	timer.scheduleAtFixedRate(new TimerTask() {

	    @Override
	    public void run() {

		String processName1 = "chrome.exe";
		String processName2 = "iexplore.exe";

		// System.out.print(isProcessRunging(processName));
		try {
		    if (isProcessRunning(processName1) > 4) {
			// killProcess(processName1);
			timer.cancel();
			System.out.println("You tried to cheat");

		    } else if (isProcessRunning(processName2) >= 2
			    && isProcessRunning(processName1) == 4) {
			timer.cancel();
			System.out.println("You tried to cheat");

		    } else if (isProcessRunning(processName2) > 2) {
			timer.cancel();
			System.out.println("You tried to cheat");
		    }
		} catch (Exception e) {

		}
		System.out.println(setInterval());

	    }
	}, delay, period);
    }

    private static final int setInterval() {
	if (interval == 0) {
	    timer.cancel();
	}
	return interval--;
    }
}