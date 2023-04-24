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

    private JLabel comboLabel = new JLabel("Choose arena:");
    private JLabel lengthLabel = new JLabel("Arena length:");
    private JLabel maxRacersLabel = new JLabel("Max racers number:");
    private JComboBox chooseArena = new JComboBox<String>(ARENAS);
    private JTextField arenaLength = new JTextField();
    private JTextField maxRacers = new JTextField();
    private JButton buildBtn = new JButton("Build Arena");
    private JLabel racerComboLabel = new JLabel("Choose racer:");
    private JLabel colorComboLabel = new JLabel("Choose color:");
    private JLabel racerNameLabel = new JLabel("Racer name:");
    private JLabel maxSpeedLabel = new JLabel("Max speed:");
    private JLabel accelerationLabel = new JLabel("Acceleration:");
    private JComboBox chooseRacer = new JComboBox<String>(RACERS);
    private JComboBox chooseColor = new JComboBox<String>(COLORS);
    private JTextField racerName = new JTextField();
    private JTextField maxSpeed = new JTextField();
    private JTextField acceleration = new JTextField();
    private JButton addButton = new JButton("Add racer");
    private JButton startRace = new JButton("Start race");
    private JButton showInfo = new JButton("Show info");
    private JFrame frame = new JFrame("FRAME_TEXT");
    private JSeparator separator1 = new JSeparator(SwingConstants.HORIZONTAL);
    private JSeparator separator2 = new JSeparator(SwingConstants.HORIZONTAL);
    private JPanel leftPanel = new JPanel();
    //

    // defaults
    private static Border textFieldBorder = BorderFactory.createEmptyBorder(8,0,0,0);
    private static Font font = new Font("Arial", Font.BOLD, 13);
    //
     //get methods
    public JFrame getFrame(){return frame;}
    public JPanel getLeftPanel(){return leftPanel;}

    public Component topPanel() { //toppanel method
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
        JFrame frame = window.getFrame();
        JPanel leftPanel = window.getLeftPanel();

        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        leftPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));  
        leftPanel.setPreferredSize(new Dimension(1000, 700));
        leftPanel.setBackground(Color.GRAY);

        frame.add(leftPanel);
        frame.add(rightPanel, BorderLayout.NORTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,728);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buildBtn) {
            String temp = (String)this.chooseArena.getSelectedItem();
            String arenaLength = this.arenaLength.getText();
            String maxRacers = this.maxRacers.getText();
            String currentPath = System.getProperty("user.dir");
            ImageIcon icon = new ImageIcon(currentPath + "\\src\\icons\\" + "LandArena.png");
            //ImageIcon icon = new ImageIcon("C:\\Users\\shayh\\Documents\\Visual Studio Code\\HomeWork1\\src\\icons\\"+ (String)chooseArena.getSelectedItem() +".png");
            JLabel label = new JLabel(icon);
            leftPanel.setSize(icon.getIconWidth(), icon.getIconHeight());
            //leftPanel.setSize(100,100);
            leftPanel.add(label, BorderLayout.CENTER);
            System.out.println("Current path: " + currentPath);
                
        }
    }
}