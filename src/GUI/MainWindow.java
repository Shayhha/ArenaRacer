package GUI;
//import icons.*; 
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class MainWindow implements ActionListener {

    // Our Variables:
    final static String[] ARENAS = { "AerialArena", "NavalArena", "LandArena"};
    final static String[] RACERS = { "Airplain", "Helicopter", "Bicycle", "Car", "Horse", "RowBoat", "SpeedBoat"};
    final static String[] COLORS = {"Black", "Blue", "Green", "Red", "Yellow"};

    JLabel comboLabel = new JLabel("Choose arena:");
    JLabel lengthLabel = new JLabel("Arena length:");
    JLabel maxRacersLabel = new JLabel("Max racers number:");
    JComboBox chooseArena = new JComboBox<String>(ARENAS);
    JTextField arenaLength = new JTextField();
    JTextField maxRacers = new JTextField();
    JButton buildBtn = new JButton("Build Arena");
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
    JButton startRace = new JButton("Start race");
    JButton showInfo = new JButton("Show info");
    JFrame frame = new JFrame("FRAME_TEXT");
    JSeparator separator1 = new JSeparator(SwingConstants.HORIZONTAL);
    JSeparator separator2 = new JSeparator(SwingConstants.HORIZONTAL);
    //

    // defaults
    static Border textFieldBorder = BorderFactory.createEmptyBorder(8,0,0,0);
    static Font font = new Font("Arial", Font.BOLD, 13);
    //

    public JFrame getFrame(){return frame;}

    public Component topPanel() {
        JPanel p1 = new JPanel();

        p1.setLayout(new GridBagLayout());   
        p1.setBorder(BorderFactory.createEmptyBorder(-40,-25,0,0)); 
        p1.setPreferredSize(new Dimension(183, 700));

        GridBagConstraints gbc = new GridBagConstraints();        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.ipady = 3;
        gbc.insets = new Insets(2, 0, 0, 0); // top, left, bottom, right

        // setting fonts and borders
        comboLabel.setFont(font);
        comboLabel.setBorder(textFieldBorder);

        lengthLabel.setFont(font);
        lengthLabel.setBorder(textFieldBorder);

        maxRacersLabel.setFont(font);
        maxRacersLabel.setBorder(textFieldBorder);

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
        //


        // Top Part of the Right Panel:

        buildBtn.addActionListener(this);

        p1.add(comboLabel, gbc);
        gbc.gridy++;
        p1.add(chooseArena, gbc);
        gbc.gridy++;
        p1.add(lengthLabel, gbc);
        gbc.gridy++;
        p1.add(arenaLength, gbc);
        gbc.gridy++;
        p1.add(maxRacersLabel, gbc);
        gbc.gridy++;
        p1.add(maxRacers, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(7, 0, 7, 0);
        p1.add(buildBtn, gbc);
        gbc.gridy++;
        p1.add(separator1, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(2, 0, 0, 0);
        //


        // Middle Part of the Right Panel:

        addButton.addActionListener(this);

        gbc.insets = new Insets(-2, 0, 0, 0);
        p1.add(racerComboLabel, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(2, 0, 0, 0);
        p1.add(chooseRacer, gbc);
        gbc.gridy++;
        p1.add(colorComboLabel, gbc);
        gbc.gridy++;
        p1.add(chooseColor, gbc);
        gbc.gridy++;
        p1.add(racerNameLabel, gbc);
        gbc.gridy++;
        p1.add(racerName, gbc);
        gbc.gridy++;
        p1.add(maxSpeedLabel, gbc);
        gbc.gridy++;
        p1.add(maxSpeed, gbc);
        gbc.gridy++;
        p1.add(accelerationLabel, gbc);
        gbc.gridy++;
        p1.add(acceleration, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(7, 0, 7, 0);
        p1.add(addButton, gbc);
        gbc.gridy++;
        p1.add(separator2, gbc);
        gbc.gridy++;
        //

        // Bottom Part of the Right Panel:

        startRace.addActionListener(this);
        showInfo.addActionListener(this);

        gbc.insets = new Insets(4, 0, 7, 0);
        p1.add(startRace, gbc);
        gbc.gridy++;
        p1.add(showInfo, gbc);
        //
        
        return p1;
    }

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        Component rightPanel = window.topPanel();
        JPanel leftPanel = new JPanel();
        JFrame frame = window.getFrame();
        
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        leftPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));  
        leftPanel.setPreferredSize(new Dimension(1000, 700));
        leftPanel.setBackground(Color.GRAY);

        frame.add(leftPanel);
        frame.add(rightPanel, BorderLayout.NORTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,728);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buildBtn) {
            String temp = (String)this.chooseArena.getSelectedItem();
            String arenaLength = this.arenaLength.getText();
            String maxRacers = this.maxRacers.getText();
            ImageIcon icon = new ImageIcon("C:\\Users\\shayh\\Documents\\Visual Studio Code\\HomeWork1\\src\\icons\\LandArena.png");
            JLabel label = new JLabel(icon);
            frame.setSize(icon.getIconWidth(), icon.getIconHeight());
            frame.add(label, BorderLayout.CENTER);
            frame.setSize(icon.getIconWidth(), icon.getIconHeight());
                
        }
    }
}