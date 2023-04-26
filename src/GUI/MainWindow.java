package GUI;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import game.arenas.Arena;
import game.racers.Racer;
import utilities.EnumContainer;
import factory.RaceBuilder;

public class MainWindow implements ActionListener {
    //arena instance
    private Arena arena = null;
    // Our Variables:
    private final static String[] ARENAS = { "AerialArena", "NavalArena", "LandArena"};
    private final static String[] RACERS = { "Airplane", "Helicopter", "Bicycle", "Car", "Horse", "RowBoat", "SpeedBoat"};
    private final static String[] COLORS = {"Black", "Blue", "Green", "Red", "Yellow"};

    private int maxNumOfRacers = 8; // values must be between 1-20
    private int arenaLen = 1000; // values must be between 100-3000
    private Boolean raceActive = false;// we use that to determine if a race started

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

    // Our GUI Components:
    private JLabel comboLabel = new JLabel("Choose arena:");
    private JLabel lengthLabel = new JLabel("Arena length:");
    private JLabel maxRacersLabel = new JLabel("Max racers number:");
    private JComboBox<String> chooseArena = new JComboBox<String>(ARENAS);
    private JTextField arenaLength = new JTextField();
    private JTextField maxRacers = new JTextField();
    private JButton buildArenaButton = new JButton("Build Arena");
    private JLabel racerComboLabel = new JLabel("Choose racer:");
    private JLabel colorComboLabel = new JLabel("Choose color:");
    private JLabel racerNameLabel = new JLabel("Racer name:");
    private JLabel maxSpeedLabel = new JLabel("Max speed:");
    private JLabel accelerationLabel = new JLabel("Acceleration:");
    private JComboBox<String> chooseRacer = new JComboBox<String>(RACERS);
    private JComboBox<String> chooseColor = new JComboBox<String>(COLORS);
    private JTextField racerName = new JTextField();
    private JTextField maxSpeed = new JTextField();
    private JTextField acceleration = new JTextField();
    private JButton addRacerButton = new JButton("Add racer");
    private JButton startRace = new JButton("Start race");
    private JButton showInfo = new JButton("Show info");
    private JFrame mainFrame = new JFrame("Race Game - Advanced OOP");
    private JPanel leftPanel = new JPanel(null);
    private JSeparator separator1 = new JSeparator(SwingConstants.HORIZONTAL);
    private JSeparator separator2 = new JSeparator(SwingConstants.HORIZONTAL);
    private JLabel backgroundLabel = new JLabel("");
    private JFrame infoWin = new JFrame("Racers information");
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

        // Setting default values
        arenaLength.setText("1000"); 
        maxRacers.setText("8");
        //

        // Top Part of the Right Panel:

        buildArenaButton.addActionListener(this);

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
        p1.add(buildArenaButton, gbc);
        gbc.gridy++;
        p1.add(separator1, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(2, 0, 0, 0);
        //


        // Middle Part of the Right Panel:

        addRacerButton.addActionListener(this);

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
        p1.add(addRacerButton, gbc);
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

    private boolean makeArena() {
        // checking if the user inputed data into all of the fields (if there are no missing values)
        if (this.arenaLength.getText().isEmpty() || this.maxRacers.getText().isEmpty()) { // if there is a missing value, show error message
            showErrorMessage("Invalid input values! Please try again.");
            return false;
        }

        // checking if the user's input contains non-numeric characters
        if (!this.arenaLength.getText().matches("\\d+") || !this.maxRacers.getText().matches("\\d+")) {
            showErrorMessage("Invalid input values! Please try again.");
            return false;
        }

        // getting the values the user has inputed into all of the fields (now the values cant be missing)
        arenaLen = Integer.parseInt(this.arenaLength.getText());
        maxNumOfRacers = Integer.parseInt(this.maxRacers.getText());

        if (arenaLen < 100 || arenaLen > 3000 || maxNumOfRacers < 1 || maxNumOfRacers > 20) {
            showErrorMessage("Invalid input values! Please try again.");
            return false;
        }

        return true;
    }

    private void showErrorMessage(String err) {
            JOptionPane.showMessageDialog(null,
            err, "Message",
            JOptionPane.INFORMATION_MESSAGE // more icons here --> https://stackoverflow.com/questions/6562847/joptionpane-change-the-icon 
             );
    }

    private void printBackgroundImage() {
        // getting the user's choises from the combo box and text boxes on the screen
        String arenaImagePath = "src/icons/" + (String)this.chooseArena.getSelectedItem() + ".jpg"; // creating the path to the background image of the area useing the choise from the user's input to the combo box
                
        // creating the background image of the arena with the path that is made of the user's choise
        ImageIcon icon = new ImageIcon(arenaImagePath);
        Image image = icon.getImage().getScaledInstance(leftPanel.getWidth(), leftPanel.getHeight(), Image.SCALE_SMOOTH); // setting the size of the image to be the size of the panel it will sit in

        // adding the background image to the screen
        backgroundLabel = new JLabel("", new ImageIcon(image), JLabel.CENTER); // adding the background image to a label
        backgroundLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0)); // removing the background from the label that holds the background image of the arena

        // adding the label with the choosen image to the left panel of the main screen
        leftPanel.add(backgroundLabel, BorderLayout.CENTER); 
    }

    // ======================================================================== //


    public static void main(String[] args) {
        createMainWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RaceBuilder buildInstance = RaceBuilder.getInstance();  //instance of RaceBuilder

        if (e.getSource() == this.buildArenaButton) { // if the build arena button was clicked
            // reseting the arena and the racer icons array (also removes the background image but we add it back later)
            arena = null;
            leftPanel.removeAll();
            
            // reseting the arena & racerActive
            this.arena = null;
            this.raceActive  = false;
            // look at the user's inputed data and checking that it is valid
            if (!makeArena()) 
                return;
                
            String arenaType = chooseArena.getSelectedItem().toString(); // can be: "AerialArena", "NavalArena", "LandArena"

            // trying to build the arena object based on the user's selection, if failed, show an error and stop the funtion
            try {
                if (arenaType.contains("Aerial"))
                    this.arena = buildInstance.buildArena("game.arenas.air." + arenaType, arenaLen, maxNumOfRacers);
                else if (arenaType.contains("Naval"))
                    this.arena = buildInstance.buildArena("game.arenas.naval." + arenaType, arenaLen, maxNumOfRacers);
                else if (arenaType.contains("Land"))
                    this.arena = buildInstance.buildArena("game.arenas.land." + arenaType, arenaLen, maxNumOfRacers);
            } catch (Exception e1) {
                showErrorMessage("Invalid input values! Please try again.");
                return;
            }
            
            // resizing the window and the left panel acording to the max racers count 
            if (this.maxNumOfRacers > 11) {
                mainFrame.setSize(MAIN_WINDOW_WIDTH, MAIN_WINDOW_HEIGHT + (this.maxNumOfRacers-11)*60); // adding 60 pixels to the height for each max racer after 11 racers
                leftPanel.setSize(LEFT_PANEL_WIDTH, LEFT_PANEL_HEIGHT + (this.maxNumOfRacers-11)*60);
                leftPanel.setPreferredSize(new Dimension(LEFT_PANEL_WIDTH, LEFT_PANEL_HEIGHT + (this.maxNumOfRacers-11)*60));
            } else {
                mainFrame.setSize(MAIN_WINDOW_WIDTH, MAIN_WINDOW_HEIGHT); // if less than 11 max racers keep original default size
                leftPanel.setSize(new Dimension(LEFT_PANEL_WIDTH, LEFT_PANEL_HEIGHT));
                leftPanel.setPreferredSize(new Dimension(LEFT_PANEL_WIDTH, LEFT_PANEL_HEIGHT));
            }

            // generating the background image when all of the inputs are acounted for
            printBackgroundImage();

            this.mainFrame.setVisible(true); // this line "updates" the main window after we have adding items to it, this way the image is now visible     
        }

        if (e.getSource() == this.addRacerButton) { //add racer button clicked
            if(this.raceActive){
                JOptionPane.showMessageDialog(null,
                    "Error, cannot add another racer beacuse race already started/ended.", "Error", JOptionPane.ERROR_MESSAGE);
                     return;
            }
            if(this.arena != null){
                if (!this.maxSpeed.getText().matches("\\d+") || !this.acceleration.getText().matches("\\d+") || this.maxSpeed.getText().equals("") || this.acceleration.getText().equals("")
                     || this.racerName.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,
                    "Invalid input values! Please try again.", "Missing Values Error", JOptionPane.ERROR_MESSAGE);
                     return;
                } 

                String racerNameValue = this.racerName.getText();
                double maxSpeedValue = Integer.parseInt(this.maxSpeed.getText());
                double accelerationValue = Integer.parseInt(this.acceleration.getText());
                String racerChoiceCombo = (String)this.chooseRacer.getSelectedItem();
                EnumContainer.Color colorValue = EnumContainer.Color.valueOf(this.chooseColor.getSelectedItem().toString().toUpperCase());
                String racerTypeValue =  "game.racers." +arena.getClass().toString().split("\\.")[2]  +"."+ racerChoiceCombo;

                Racer Instance=null;
                try{
                    // trying to build the racer based on the correct type of the racer
                    if(racerChoiceCombo == "Airplane")
                        Instance = buildInstance.buildWheeledRacer(racerTypeValue, racerNameValue, maxSpeedValue, accelerationValue, colorValue,3); //create instance
                    else if(racerChoiceCombo == "Bicycle")
                        Instance = buildInstance.buildWheeledRacer(racerTypeValue, racerNameValue, maxSpeedValue, accelerationValue, colorValue,2); //create instance
                    else if(racerChoiceCombo == "Car")
                        Instance = buildInstance.buildWheeledRacer(racerTypeValue, racerNameValue, maxSpeedValue, accelerationValue, colorValue,4); //create instance
                    else
                        Instance = buildInstance.buildRacer(racerTypeValue, racerNameValue, maxSpeedValue, accelerationValue, colorValue); //create instance
                    
                    this.arena.addRacer(Instance); //calls add racer of arena (might throw an exaption!)

                    Instance.introduce(); // printing the currect racer to the comand line

                    this.leftPanel.remove(backgroundLabel);

                    int i = this.arena.getActiveRacers().size();

                    // creating a racer icon based on the user's information and adding the icon to the array of icons and positioning the icon in the correct location
                    JLabel r1 = createRacer("src/icons/" + (String)Instance.getClass().getSimpleName() + this.chooseColor.getSelectedItem().toString() + ".png");
                    racersList.add(r1);
                    moveRacer(r1, 0, (i-1)*RACER_ICON_SIZE + (int)arena.getMIN_Y_GAP());
                    
                    // adding the racer to the screen
                    leftPanel.add(r1, BorderLayout.CENTER);

                    // re-generating the background image after the racer was added 
                    printBackgroundImage();

                    mainFrame.setVisible(true); // this line "updates" the main window after we have adding items to it, this way the image is now visible     

                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,
                    "Racer doesn't match arena.", "Racer Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println(ex);
                    return;
                }
            }
            else{
                JOptionPane.showMessageDialog(null,
                    "You have to build an arena first!", "Error", JOptionPane.ERROR_MESSAGE);
                     return;
            }
        }
        if(e.getSource() == this.startRace){ //start racer buttom clicked
            if(this.raceActive){
                JOptionPane.showMessageDialog(null,
                    "Race already started/ended!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(this.arena == null){
                JOptionPane.showMessageDialog(null,
                    "Arena isn't initialized!", "Arena Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(this.racersList.isEmpty()){
                JOptionPane.showMessageDialog(null,
                    "You haven't added racers to arena!", "Racer Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else{
                this.raceActive = true; //states that a race has been started
                this.arena.initRace(); //initializes the racers as well
                for (Racer r : this.arena.getActiveRacers()) {
                   //TODO
                }
            }
        }
    
        if (e.getSource() == this.showInfo) {
            if (arena != null) {
                Dimension infoWinSize = new Dimension(555,175); // saveing the dimentions of the info window
                JPanel panel = new JPanel(); // creating a panel that will sit in the window
                JTable table; // creating a reference to a tabel for later use
                Object[][] data = null;

                // setting the window size and the panels layout and border
                infoWin.setSize(infoWinSize);
                panel.setLayout(new BorderLayout());
                panel.setBorder(new EmptyBorder(10, 10, 10, 10));

                // column header values for creating the table
                String[] columnHeaders = {"Racer name", "Current speed", "Max speed", "Current X location", "Finished"};
                
                // data2 is just temporary information, need to change it to the actual racers information from the active racers
                Object[][] data2 = {{"Data 1", "Data 2", "Data 3", "Data 4", "Data 5"}, {"Data 6", "Data 7", "Data 8", "Data 9", "Data 10"}};
                data = data2;
                // Object[][] data = getRacersInfoFromArena(); //! we need to implement this function to get the racers info, the function has to return null if there are no racers in the arena
                //? here we might have an issue with active racers, this info window needs to show all racers, 
                //? even onces that have finished the racer, we wont find them in active racers so we might need to use compleated racers as well...

                // this block will check if the function getRacersInfoFromArena will return actual data of null in the case that there are no racers in the arena yet
                // if (data == null) { //! remove the comment from this if block when getRacersInfoFromArena() is implemented
                //     data = new Object[0][5]; // create empty data array
                // }

                table = new JTable(data, columnHeaders); // creating a tabel with the column headers and the racers data

                // adding the completed tabel to a scroll panel and then setting its size to the size of the info window
                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setPreferredSize(infoWinSize);
                
                panel.add(scrollPane, BorderLayout.CENTER); // adding the scroll panel to the main panel of the frame
        
                // **** setting the location of the info window to open in the center of the screen **** //
                    // get the screen size
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

                    // calculate the new location of the frame
                    int x = (int) ((screenSize.getWidth() - infoWin.getWidth()) / 2);
                    int y = (int) ((screenSize.getHeight() - infoWin.getHeight()) / 2);

                    // set the location of the frame
                    infoWin.setLocation(x, y);
                // **** **** //

                // adding the panel to the frame and setting the frame visible
                infoWin.add(panel);
                infoWin.pack();
                infoWin.setVisible(true);
            }
            else {
                showErrorMessage("You have to build an arena first!");
            }
        }
    }
}