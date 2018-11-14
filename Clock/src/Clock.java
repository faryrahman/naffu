import java.lang.Math;
import java.util.Scanner; 
import java.io.*;
public class Clock {

	int hour;
	int min;
	
	public Clock() {
		hour = 0;
		min = 0;
	}
	
	public Clock(int h) {
		hour=h;
	}
	
	public Clock(int h, int m) {
		hour=h;
		min=m;
	}
	
	public int getHour() {
		return hour;
	}
	
	public int getMinute() {
		return min;
	}
	
	public void incrementTimer() {
		if (min==59) {
			hour++;
			min=0;
		}
		else
			min++;
	}
	
	public void incrementTimer(int x) {
		//System.out.println("Minutes to be incremented...."+x);
		for(int i=0; i<x; i++) {
			incrementTimer();
		}
	}
	
	public void setTime(int h, int m) {
		if((h>23) || (m>59)) {
			System.out.println("Invalid Input");
		}
		else {
			hour = h;
			min = m;	
		}	
	}
	
	public String toString() {
		//check conditions again 
		String outputTime="";
		//System.out.println("hour is.." + hour);
		//System.out.println("minute is.." + min);
		if((this.hour==0) && (this.min==0)) {
			outputTime = ("12:00 AM");
		}
		if((hour<10) && (min<10)) {
			outputTime = new String ("0"+hour+":"+"0"+min+" AM");
		}
		if(((hour==10) || (hour ==11)) && (min<10)) {
			outputTime = new String (hour+":"+"0"+ min+" AM");
		}
		if((hour==0) && (min<10)) {
			outputTime = new String ("12:"+"0"+min+" AM");
		}
		if((hour<10) && (min>=10)) {
			outputTime = new String ("0"+hour+":"+min+" AM");
		}
		if(((hour==10) || (hour ==11)) && (min>=10)) {
			outputTime = new String (hour+":"+min+" AM");
		}
		if((hour==0) && (min>=10)) {
			outputTime = new String ("12:"+min+" AM");
		}
		int t = hour-12;
		if(((hour>12) && (hour <24)) && (min<10)) {
			//System.out.println("Here....");	
			if (t<10)
				outputTime = new String ("0"+(hour-12) +":"+"0"+min+" PM");
			else
				outputTime = new String ((hour-12) +":"+"0"+min+" PM");
		}
		if(((hour>12) && (hour <24)) && (min>=10)) {
			if (t<10)
				outputTime = new String ("0"+(hour-12) +":"+min+" PM");
			else
				outputTime = new String ((hour-12) +":"+min+" PM");
		}
		
		//outputTime = new String ("Still have to code this hold up ");
		//fix this below; its bc there is no default condition so gotta figure out what that default condition is
		 return outputTime;
	}
	
}
