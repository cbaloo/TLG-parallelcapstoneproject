package client;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

    public class DigitalWatch implements Runnable{
        JFrame f;
        Thread t=null;
        int hours=0, minutes=0, seconds=0;
        String timeString = "";
        JButton b;

        DigitalWatch(){
            f=new JFrame();

            // To make a class runnable, we can implement java.lang.Runnable interface and provide implementation in public void run() method.
            // To use this class as Thread, we need to create a Thread object by passing object of this runnable class and then call start() method to execute the run() method in a separate thread.

            t = new Thread(this);
            t.start();

            b=new JButton();
            b.setBounds(100,100,100,50);

            f.add(b);
            f.setSize(300,400);
            f.setLayout(null);
            f.setVisible(true);
        }

        public void run() {
            try {
                while (true) {

                    Calendar cal = Calendar.getInstance();
                    hours = cal.get( Calendar.HOUR_OF_DAY );
                    if ( hours > 12 ) hours -= 12;
                    minutes = cal.get( Calendar.MINUTE );
                    seconds = cal.get( Calendar.SECOND );

                    SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
                    Date date = cal.getTime();
                    timeString = formatter.format( date );

                    printTime();

                    t.sleep( 1000 );  // interval given in milliseconds
                }
            }
            catch (Exception e) { }
        }

        public void printTime(){
            b.setText(timeString);
        }

    /*    public static void main(String[] args) {
            new DigitalWatch();

*/
        }


