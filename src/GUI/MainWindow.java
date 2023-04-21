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

    // Constant Values for the Screen Dimentions
    final static int MAIN_WINDOW_WIDTH = 1200;
    final static int MAIN_WINDOW_HEIGHT = 728;

    final static int LEFT_PANEL_WIDTH = 1000;
    final static int LEFT_PANEL_HEIGHT = 700;

    final static int RIGHT_PANEL_WIDTH = 183;
    final static int RIGHT_PANEL_HEIGHT = 700;

    // Our Components:
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
    JFrame mainFrame = new JFrame("Race Game - Advanced OOP");
    JPanel leftPanel = new JPanel();
    JSeparator separator1 = new JSeparator(SwingConstants.HORIZONTAL);
    JSeparator separator2 = new JSeparator(SwingConstants.HORIZONTAL);
    JLabel backgroundLabel = new JLabel("");
    //

    // defaults
    static Border textFieldBorder = BorderFactory.createEmptyBorder(8,0,0,0);
    static Font font = new Font("Arial", Font.BOLD, 13);
    //

    public JFrame getFrame(){return mainFrame;}
    public JPanel getLeftPanel(){return leftPanel;}

    /**
     * Builds the Right panel of the main screen. 
     * <p>This panel will hold all of the buttons and the text fields and labels for the 
     * controls of the game, it will alow the player to add arena, add racers, start and end the race and more.
     * @return a JPanel object that has all of the buttons and text fields in the correct order
     */
    public JPanel buildRightPanel() {
        JPanel p1 = new JPanel();

        p1.setLayout(new GridBagLayout());   
        p1.setBorder(BorderFactory.createEmptyBorder(-40,-25,0,0)); 
        p1.setPreferredSize(new Dimension(RIGHT_PANEL_WIDTH, RIGHT_PANEL_HEIGHT));

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
        // creating the main window using some variables declared above
        MainWindow window = new MainWindow();
        JFrame mainFrame = window.getFrame();
        JPanel leftPanel = window.getLeftPanel(); // the left panel will hold all of the racers
        JPanel rightPanel = window.buildRightPanel(); // the right panel will hold all of the buttons and text boxes
        
        // setting the correct layout to the frame and the panels
        mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        leftPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));  
        leftPanel.setPreferredSize(new Dimension(LEFT_PANEL_WIDTH, LEFT_PANEL_HEIGHT));
        leftPanel.setBackground(Color.GRAY); // this is temporary
        //leftPanel.setLayout(new BorderLayout()); // this might improve the positioning of the image in the left panel

        // adding the panels to the frame
        mainFrame.add(leftPanel);
        mainFrame.add(rightPanel, BorderLayout.NORTH);

        // setting the frame's size and making it visible
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(MAIN_WINDOW_WIDTH,MAIN_WINDOW_HEIGHT);
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buildBtn) { // if the build arena button was clicked
            leftPanel.remove(backgroundLabel); // removing the existig image from the left panel before adding a new one

            // getting the user's choises from the combo box and text boxes on the screen
            String arenaImagePath = "src/icons/" + (String)this.chooseArena.getSelectedItem() + ".jpg"; // creating the path to the background image of the area useing the choise from the user's input to the combo box
            String arenaLength = this.arenaLength.getText();
            String maxRacers = this.maxRacers.getText();

            // creating the background image of the arena with the path that is made of the user's choise
            ImageIcon icon = new ImageIcon(arenaImagePath);
            Image image = icon.getImage().getScaledInstance(leftPanel.getWidth(), leftPanel.getHeight(), Image.SCALE_SMOOTH); // setting the size of the image to be the size of the panel it will sit in

            // adding the background image to the screen
            backgroundLabel = new JLabel("", new ImageIcon(image), JLabel.CENTER); // adding the background image to a label
            backgroundLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0)); // removing the background from the label that holds the background image of the arena
            leftPanel.add(backgroundLabel, BorderLayout.CENTER); // adding the label with the image to the left panel of the main screen

            mainFrame.setVisible(true); // this line "updates" the main window after we have adding items to it, this way the image is now visible     
        }
    }
}