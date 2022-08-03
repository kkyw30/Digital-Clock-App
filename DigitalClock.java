import javax.swing.*;  
import java.awt.*;  
import java.text.*;  
import java.util.*;  
public class DigitalClock implements Runnable{  

JFrame frame; 
Thread t = null; 
int hours = 0;
int minutes = 0; 
int seconds = 0; 
int year = 0; 
int month = 0; 
int day = 0; 
int dayOfWeek = 0; 
String time = "";
JButton button; 
  
DigitalClock(){  
    frame = new JFrame();  
      
    t = new Thread(this);  
        t.start();  
      
    button = new JButton();  
        button.setBounds(100,100,300,100);  
      
    frame.add(button);  
    frame.setSize(500,500);  
    frame.setLayout(null);  
    frame.setVisible(true);  
}  
  
 public void run() {  
      try {  
         while (true) {  
  
            Calendar cal = Calendar.getInstance();  
            hours = cal.get( Calendar.HOUR_OF_DAY );  
            if (hours > 24) hours -= 24;  
            minutes = cal.get(Calendar.MINUTE );  
            seconds = cal.get(Calendar.SECOND );  
            year = cal.get(Calendar.YEAR);
            month = cal.get(Calendar.MONTH);
            day = cal.get(Calendar.DAY_OF_YEAR);
            dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
  
            SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss zzzz");  
            Date date = cal.getTime();  
            time = formatter.format( date );  
            String leapYear = isLeapyear(year);
  
            printTime();  
            System.out.println(leapYear);
         }  
      }  
      catch (Exception e) { }  
 }  
  
public void printTime() {  
    button.setText(time);  
} 

public String isLeapyear(int year) {
    return "" + (year % 4 == 0);
}
  
public static void main(String[] args) {  
    new DigitalClock();  
}  
}  