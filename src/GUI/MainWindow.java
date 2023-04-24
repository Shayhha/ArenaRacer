package GUI;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainWindow implements ActionListener {

    // Our Variables:
    private final static String[] ARENAS = { "AerialArena", "NavalArena", "LandArena"};
    private final static String[] RACERS = { "Airplain", "Helicopter", "Bicycle", "Car", "Horse", "RowBoat", "SpeedBoat"};
    private final static String[] COLORS = {"Black", "Blue", "Green", "Red", "Yellow"};

    private int maxNumOfRacers = 8; // values must be between 1-20
    private int arenaLen = 1000; // values must be between 100-3000

    // Constant Values for the Screen Dimentions:
    private final static int MAIN_WINDOW_WIDTH = 1200;
    private final static int MAIN_WINDOW_HEIGHT = 728; // when we have more that 11 racers on the screen we need to increase the height by RACER_ICON_SIZE

    private final static int LEFT_PANEL_WIDTH = 1000;
    private final static int LEFT_PANEL_HEIGHT = 700;

    private final static int RIGHT_PANEL_WIDTH = 183;
    private final static int RIGHT_PANEL_HEIGHT = 700;

    private final static int RACER_ICON_SIZE = 60; // width = height = 60

    // A temporary array of racers (array of icons)
    private ArrayList<JLabel> racersList = new ArrayList<JLabel>(maxNumOfRacers);

    // Our Components:
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
    private JFrame mainFrame = new JFrame("Race Game - Advanced OOP");
    private JPanel leftPanel = new JPanel(null);
    private JSeparator separator1 = new JSeparator(SwingConstants.HORIZONTAL);
    private JSeparator separator2 = new JSeparator(SwingConstants.HORIZONTAL);
    private JLabel backgroundLabel = new JLabel("");
    //

    // Default values for gui:
    private static Border textFieldBorder = BorderFactory.createEmptyBorder(8,0,0,0);
    private static Font font = new Font("Arial", Font.BOLD, 13);

    //

    // Getter functions:
    public JFrame getFrame(){return mainFrame;}
    public JPanel getLeftPanel(){return leftPanel;}
    //

    // ======================================================================== //

    // Helper functions:

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

    /**
     * Building the Main Window for the game
     */
    private static void createMainWindow() {
        // creating the main window using some variables declared above
        MainWindow window = new MainWindow();
        JFrame mainFrame = window.getFrame();
        JPanel leftPanel = window.getLeftPanel(); // the left panel will hold all of the racers
        JPanel rightPanel = window.buildRightPanel(); // the right panel will hold all of the buttons and text boxes
        
        // setting the correct layout to the frame and the panels
        mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        mainFrame.setSize(MAIN_WINDOW_WIDTH,MAIN_WINDOW_HEIGHT);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // get the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // calculate the new location of the frame
        int x = (int) ((screenSize.getWidth() - mainFrame.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - mainFrame.getHeight()) / 2);

        // set the location of the frame
        mainFrame.setLocation(x, y);

        leftPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));  
        leftPanel.setPreferredSize(new Dimension(LEFT_PANEL_WIDTH, LEFT_PANEL_HEIGHT));
        leftPanel.setBackground(Color.GRAY); // this is temporary
        leftPanel.setLayout(new BorderLayout()); // this might improve the positioning of the image in the left panel

        // adding the panels to the frame
        mainFrame.add(leftPanel);
        mainFrame.add(rightPanel, BorderLayout.NORTH);

        // setting the frame's size and making it visible
        mainFrame.setVisible(true);
    }

    /**
     * creating a single racer buy getting the icon from the given path and makeing a label that will hold that icon
     * @param path the path to the icon we want to give the racer
     * @return a JLabel object (an icon) that represents a racer in our race
     */
    private JLabel createRacer(String path) {
        Image image = new ImageIcon(path).getImage().getScaledInstance(RACER_ICON_SIZE, RACER_ICON_SIZE, Image.SCALE_SMOOTH);
        JLabel racer = new JLabel("", new ImageIcon(image), JLabel.CENTER);
        racer.setBounds(5, 5, RACER_ICON_SIZE, RACER_ICON_SIZE);
        return racer;
    }

    /**
     * moves the given racer by adding to his X and Y coordinates
     * @param racer the racer you want to move
     * @param x how much to move on the X axies, 0 is dont move.
     * @param y how much to move on the Y axies, 0 is dont move.
     */
    private void moveRacer(JLabel racer, int x, int y) {
        racer.setLocation(racer.getX() + x, racer.getY() + y);
    }

    // ======================================================================== //

    // Input Checking Functions:

    private boolean checkArenaLength(int len) {
        if (len < 100 || len > 3000) {
            JOptionPane.showMessageDialog(null,
             "The length of the arena must be between 100 and 3000 units, try again.", "Arena Length Input Error",
             JOptionPane.INFORMATION_MESSAGE //check is this is a good icon ( https://stackoverflow.com/questions/6562847/joptionpane-change-the-icon )
             );
            return false;
        }
        return true;
    }

    private boolean checkMaxRacers(int num) {
        if (num < 1 || num > 20) {
            JOptionPane.showMessageDialog(null,
             "An arena can have between 1 and 20 racers, try setting a different maximum number or racers.", "Maximum Racers Input Error",
             JOptionPane.INFORMATION_MESSAGE //check is this is a good icon ( https://stackoverflow.com/questions/6562847/joptionpane-change-the-icon )
             );
            return false;
        }
        return true;
    }

    // ======================================================================== //


    public static void main(String[] args) {
        createMainWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buildBtn) { // if the build arena button was clicked
            leftPanel.remove(backgroundLabel); // removing the existig image from the left panel before adding a new one
            
            // getting the user's choises from the combo box and text boxes on the screen
            String arenaImagePath = "src/icons/" + (String)this.chooseArena.getSelectedItem() + ".jpg"; // creating the path to the background image of the area useing the choise from the user's input to the combo box
            
            // checking the input to of the user for arena
            if (!this.arenaLength.getText().isEmpty()) {
                arenaLen = Integer.parseInt(this.arenaLength.getText()); // need to add checks for this value
                if (!checkArenaLength(arenaLen)) {
                    return;
                }
                
            } else { // this error message is not like the Word document, fix it.
                JOptionPane.showMessageDialog(null,
                 "Please fill in the \"Arena Length\" and \"Max racers Number\" fields before creating the arena.", "Missing Values Error",
                 JOptionPane.INFORMATION_MESSAGE //check is this is a good icon ( https://stackoverflow.com/questions/6562847/joptionpane-change-the-icon )
                );
                return;
            }
            
            if (!this.maxRacers.getText().isEmpty()) {
                maxNumOfRacers = Integer.parseInt(this.maxRacers.getText()); // need to add checks for this value

                if (!checkMaxRacers(maxNumOfRacers)) {
                    return;
                }
            }
            // creating the background image of the arena with the path that is made of the user's choise
            ImageIcon icon = new ImageIcon(arenaImagePath);
            Image image = icon.getImage().getScaledInstance(leftPanel.getWidth(), leftPanel.getHeight(), Image.SCALE_SMOOTH); // setting the size of the image to be the size of the panel it will sit in

            // adding the background image to the screen
            backgroundLabel = new JLabel("", new ImageIcon(image), JLabel.CENTER); // adding the background image to a label
            backgroundLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0)); // removing the background from the label that holds the background image of the arena


            // Initialize each JLabel object in the racers array, JUST A TEST!!!
            for (int i = 0; i < maxNumOfRacers; i++) {
                racersList.add(i, createRacer("src/icons/HelicopterBlack.png"));

                // racersArray[i] = createRacer("src/icons/HelicopterBlack.png");
                moveRacer(racersList.get(i),0,i*RACER_ICON_SIZE);
                leftPanel.add(racersList.get(i), BorderLayout.CENTER);
            }
            //

            
            // this line must be in the end for some reason... this might be a problem when adding racers, we will have to write this line after every racer that we add..
            leftPanel.add(backgroundLabel, BorderLayout.CENTER); // adding the label with the image to the left panel of the main screen

            mainFrame.setVisible(true); // this line "updates" the main window after we have adding items to it, this way the image is now visible     
        }
    }
}