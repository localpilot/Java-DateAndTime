import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DigitalClock extends JFrame  {

    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    String time;
    String day;
    String date;



    DigitalClock(){


        this.setSize(400,150);
        this.setTitle("My Clock");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);


        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");


        timeLabel = new JLabel();
        timeLabel.setFont(new Font("MV Boli",Font.BOLD,40));
        timeLabel.setBackground(Color.black);
        timeLabel.setForeground(Color.yellow);
        timeLabel.setOpaque(true);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("MV Boli",Font.BOLD,30));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("MV Boli",Font.BOLD,20));



        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);



        this.setVisible(true);
        setTime();
    }
    public void setTime(){
        while(true){
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
