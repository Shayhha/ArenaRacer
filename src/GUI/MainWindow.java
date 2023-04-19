package GUI;
//import icons.*; 
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class MainWindow {
    
    final static String[] ARENAS = { "AerialArena", "NavalArena", "AirArena"};

    // *********
    static Border border = BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.GRAY, 1), // black 1px border
        BorderFactory.createEmptyBorder(5, 2, 5, 5) // 5px padding on all sides
    );

    static Border textFieldBorder = BorderFactory.createEmptyBorder(11, 0,4,0);

    static Dimension textFieldSize = new Dimension(100, 30);
    static Dimension buttonSize = new Dimension(100, 45);

    static Font font = new Font("Arial", Font.BOLD, 13);
    // *********

    public static Component topPanel(){
        JPanel p1 = new JPanel();

        p1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));           
        p1.setLayout(new GridLayout(7, 1, 5,5));
        p1.setPreferredSize(new Dimension(150, 200));

        JLabel comboLabel = new JLabel("Choose arena:");
        JLabel lengthLabel = new JLabel("Arena length:");
        JLabel maxRacersLabel = new JLabel("Max racers number:");

        JComboBox chooseArena = new JComboBox<String>(ARENAS);
        JTextField arenaLength = new JTextField(2);
        JTextField maxRacers = new JTextField(2);

        // setting fonts and borders
        comboLabel.setFont(font);
        comboLabel.setBorder(textFieldBorder);

        lengthLabel.setFont(font);
        lengthLabel.setBorder(textFieldBorder);

        maxRacersLabel.setFont(font);
        maxRacersLabel.setBorder(textFieldBorder);

        arenaLength.setBorder(border);
        arenaLength.setSize(textFieldSize);

        maxRacers.setBorder(border);
        maxRacers.setSize(textFieldSize);
        //
        
        JButton buildBtn = new JButton("Build Arena");


        p1.add(comboLabel);
        p1.add(chooseArena);

        p1.add(lengthLabel);
        p1.add(arenaLength);

        p1.add(maxRacersLabel);
        p1.add(maxRacers);
        
        p1.add(buildBtn);

        //p1.add(gbc);
        return p1;
    }



    final static String[] RACERS = { "Airplain", "Helicopter", "Bicycle", "Car", "Horse", "RowBoat", "SpeedBoat"};
    final static String[] COLORS = {"Black", "Blue", "Green", "Red", "Yellow"};

    public static Component midPanel() {
        
        JPanel p1 = new JPanel();

        p1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));           
        p1.setLayout(new GridLayout(0, 1, 5,5));   
        p1.setPreferredSize(new Dimension(150, 500));

        JLabel racerComboLabel = new JLabel("Choose racer:");
        JLabel colorComboLabel = new JLabel("Choose color:");
        JLabel racerNameLabel = new JLabel("Racer name:");
        JLabel maxSpeedLabel = new JLabel("Max speed:");
        JLabel accelerationLabel = new JLabel("Acceleration:");

        JComboBox chooseRacer = new JComboBox<String>(RACERS);
        JComboBox chooseColor = new JComboBox<String>(COLORS);
        JTextField racerName = new JTextField();
        JTextField maxSpeed = new JTextField();
        JTextField acceleration = new JTextField();
        JButton addButton = new JButton("Add racer");

        // setting fonts and borders
        racerComboLabel.setFont(font);
        racerComboLabel.setBorder(textFieldBorder);

        colorComboLabel.setFont(font);
        colorComboLabel.setBorder(textFieldBorder);
        
        racerNameLabel.setFont(font);
        racerNameLabel.setBorder(textFieldBorder);
        
        maxSpeedLabel.setFont(font);
        maxSpeedLabel.setBorder(textFieldBorder);
        
        accelerationLabel.setFont(font);
        accelerationLabel.setBorder(textFieldBorder);

        racerName.setBorder(border);
        racerName.setSize(textFieldSize);

        maxSpeed.setBorder(border);
        maxSpeed.setSize(textFieldSize);

        acceleration.setBorder(border);
        acceleration.setSize(textFieldSize);
        //

        p1.add(racerComboLabel);
        p1.add(chooseRacer);

        p1.add(colorComboLabel);
        p1.add(chooseColor);

        p1.add(racerNameLabel);
        p1.add(racerName);
        
        p1.add(maxSpeedLabel);
        p1.add(maxSpeed);

        p1.add(accelerationLabel);
        p1.add(acceleration);

        p1.add(addButton);

        return p1;
    }

    public static Component buttomPanel() {
        JPanel p1 = new JPanel();

        p1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        p1.setLayout(new GridLayout(0, 1, 10,2));

        JButton startRace = new JButton("Start race");
        JButton showInfo = new JButton("Show info");

        p1.add(startRace);
        p1.add(showInfo);

        return p1;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FRAME_TEXT");
        JPanel pLeft = new JPanel();
        JPanel pRight = new JPanel();

        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        pLeft.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));  
        pRight.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));  

        pLeft.setPreferredSize(new Dimension(1025, 700));
        pRight.setPreferredSize(new Dimension(175, 700));

        pLeft.setBackground(Color.BLUE);
        pRight.setBackground(Color.GREEN);

        pRight.setLayout(new GridLayout(3, 1));


        pRight.add(topPanel());
        pRight.add(midPanel());
        pRight.add(buttomPanel());
        
        frame.add(pLeft);
        frame.add(pRight);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,700);
        frame.setVisible(true);
    }
}