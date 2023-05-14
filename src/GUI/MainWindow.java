/**
 * Partners:
 * name: Shay Hahiashvili, ID: 206423840
 * name: Maxim Subotin, ID: 207695479
 */
package GUI;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import game.arenas.Arena;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import utilities.EnumContainer;
import factory.RaceBuilder;

public class MainWindow implements ActionListener {
    // Arena Instance, this is the arena that the user is going to build
    private Arena arena = null; 

    // Our Variables & ComboBox Choises:
    private final static String[] ARENAS = { "AerialArena", "NavalArena", "LandArena"};
    private final static String[] RACERS = { "Airplane", "Helicopter", "Bicycle", "Car", "Horse", "RowBoat", "SpeedBoat"};
    private final static String[] COLORS = {"Black", "Blue", "Green", "Red", "Yellow"};

    private static int maxNumOfRacers = 8; // values must be between 1-20
    private int arenaLen = 1000; // values must be between 100-3000
    private Boolean raceActive = false; // we use that to determine if a race had started
    private String arenaType = ""; // this will hold the selected combo box value from the user, needed in some places

    // Constant Values for the Screen Dimentions:
    // ( when we have more that 11 racers on the screen we increase the height by RACER_ICON_SIZE for each aditional racer )
    // ( when the arena length is subject to change with the users input, defaults to leangth 1000 )
    // even though the screen dimentions change these values are final inorder to be able to reset the screen to the default size with every new arena
    private final static int MAIN_WINDOW_WIDTH = 1270;
    private final static int MAIN_WINDOW_HEIGHT = 728; 

    private final static int LEFT_PANEL_WIDTH = 1070;
    private final static int LEFT_PANEL_HEIGHT = 700;

    private final static int RIGHT_PANEL_WIDTH = 183;
    private final static int RIGHT_PANEL_HEIGHT = 700;

    // This variable represents the size of each players icon on the screen
    private final static int RACER_ICON_SIZE = 60; // racer's width = racer's height = 60 pixels 

    // A map that holds pairs of (racer's serial number , racer's icon on the screen)
    private static Map<Integer, JLabel> racersList = new HashMap<>();

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
    private JPanel tablePanel = new JPanel(); 
    // all of these components are used in the main screen and the information screen

    // Default design values for gui:
    private static Border textFieldBorder = BorderFactory.createEmptyBorder(8,0,0,0); // our default border for text fields
    private static Font font = new Font("Arial", Font.BOLD, 13); //our default font for lables
    //

    // Getter functions: (inorder to have direct access to some of the gui components we declared up top)
    public JFrame getFrame(){return mainFrame;}
    public JPanel getLeftPanel(){return leftPanel;}
    public Map<Integer, JLabel> getRacersList() {return racersList;}
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
        JPanel p1 = new JPanel(); // creating a panel that everything will sit in and that will be returned from the function

        p1.setLayout(new GridBagLayout()); // making a grid bag layout inorder to have full control on the position of each element in the grid
        p1.setBorder(BorderFactory.createEmptyBorder(-40,-25,0,0)); // changing the border to look good on the screen
        p1.setPreferredSize(new Dimension(RIGHT_PANEL_WIDTH, RIGHT_PANEL_HEIGHT)); // setting the size of the panel to the default size declared in above final parameters

        // making the grid bag layout manualy
        GridBagConstraints gbc = new GridBagConstraints();        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.ipady = 3;
        gbc.insets = new Insets(2, 0, 0, 0); // top, left, bottom, right
        //

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
        buildArenaButton.addActionListener(this); // adding an action listener for the build arena button, the function comes later in the code

        // adding items to the panel and after each item go to the next row in the grid, that alows us to have one column in the grid
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
        gbc.insets = new Insets(7, 0, 7, 0); // adding some padding to a specific cell to match how the gui looks in the examples
        p1.add(buildArenaButton, gbc);
        gbc.gridy++;
        p1.add(separator1, gbc); // a seperator is just a horizontal line
        gbc.gridy++;
        gbc.insets = new Insets(2, 0, 0, 0); // adding some padding to a specific cell to match how the gui looks in the examples
        // finished adding all of the elements that belong to the top part of the right panel


        // Middle Part of the Right Panel:
        addRacerButton.addActionListener(this); // adding an action listener for the add racer button, the function comes later in the code

        // adding items to the panel and after each item go to the next row in the grid, that alows us to have one column in the grid
        gbc.insets = new Insets(-2, 0, 0, 0); // adding some padding to a specific cell to match how the gui looks in the examples
        p1.add(racerComboLabel, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(2, 0, 0, 0); // adding some padding to a specific cell to match how the gui looks in the examples
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
        gbc.insets = new Insets(7, 0, 7, 0); // adding some padding to a specific cell to match how the gui looks in the examples
        p1.add(addRacerButton, gbc);
        gbc.gridy++;
        p1.add(separator2, gbc); // a seperator is just a horizontal line
        gbc.gridy++;
        // finished adding all of the elements that belong to the middle part of the right panel

        // Bottom Part of the Right Panel:
        startRace.addActionListener(this); // adding an action listener for the start race button, the function comes later in the code
        showInfo.addActionListener(this); // adding an action listener for the show info button, the function comes later in the code
        
        // adding items to the panel and after each item go to the next row in the grid, that alows us to have one column in the grid
        gbc.insets = new Insets(4, 0, 7, 0); // adding some padding to a specific cell to match how the gui looks in the examples
        p1.add(startRace, gbc);
        gbc.gridy++;
        p1.add(showInfo, gbc);
        // finished adding all of the elements that belong to the bottom part of the right panel
        
        return p1; // returning the finished panel (it will then be added to the right side of the main window)
    }

    /**
     * Building the Main Window for the game, this will be called in the main. Creating the frames and panels, setting the size and layout 
     * setting the location on the screen for the windows to open, adding the panels and showing the main window to the user.
     */
    private static void createMainWindow() {
        // creating the main window using some variables declared above
        MainWindow window = new MainWindow();
        JFrame mainFrame = window.getFrame();
        JPanel leftPanel = window.getLeftPanel(); // the left panel will hold all of the racers
        JPanel rightPanel = window.buildRightPanel(); // the right panel will hold all of the buttons and text boxes
        
        // setting the correct layout to the main window frame 
        mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        mainFrame.setSize(MAIN_WINDOW_WIDTH,MAIN_WINDOW_HEIGHT); // setting the size of the frame to the default size
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // making sure the program stops when we close the window

        // making the main window open in the exact center of the screen:
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // get the screen size

        int x = (int) ((screenSize.getWidth() - mainFrame.getWidth()) / 2); // calculate the new location of the frame
        int y = (int) ((screenSize.getHeight() - mainFrame.getHeight()) / 2); // calculate the new location of the frame

        mainFrame.setLocation(x, y); // set the location of the frame
        //

        // setting the default look of the left panel, setting border, size, background color and layout
        leftPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));  
        leftPanel.setPreferredSize(new Dimension(LEFT_PANEL_WIDTH, LEFT_PANEL_HEIGHT));
        leftPanel.setLayout(new BorderLayout()); // this improves the positioning of the image in the left panel

        // adding the panels to the frame
        mainFrame.add(leftPanel);
        mainFrame.add(rightPanel, BorderLayout.NORTH);

        // making the frame visible
        mainFrame.setVisible(true);
    }

    /**
     * creating a single racer buy getting the icon from the given path and makeing a label that will hold that icon
     * @param path the path to the icon we want to give the racer
     * @return a JLabel object (an icon) that represents a racer in our race
     */
    private JLabel createRacer(String path) {
        // making an image obj using the image located in the given path, setting the size of the image to the default size declaed at the top
        Image image = new ImageIcon(path).getImage().getScaledInstance(RACER_ICON_SIZE, RACER_ICON_SIZE, Image.SCALE_SMOOTH);
        JLabel racer = new JLabel("", new ImageIcon(image), JLabel.CENTER); // adding the image to a label to be visible on screen
        racer.setBounds(5, 5, RACER_ICON_SIZE, RACER_ICON_SIZE); // adding some border to each racer's icon and setting the default size
        return racer; // returning the lable with the image
    }

    /**
     * moves the given racer by adding to his X and Y coordinates
     * @param index the index of the racer you want to move
     * @param x how much to move on the X axies, 0 is dont move.
     * @param y how much to move on the Y axies, 0 is dont move.
     */
    public static void moveRacer(int serialNum, int x, int y) {
        JLabel racer = racersList.get(serialNum);
        racer.setLocation(racer.getX() + x, racer.getY() + y);
    }

    /**
     * This function checks the users inputs, arena's length and max racers fields, checking that they are filled
     * and dont contain letters. also checkign that they contain valid arguments, for example the arena's length
     * must be between 100 and 3000.
     * @return true if the input is all right and false otherwise (also pops an error message to the user about the bad input)
     */
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
        this.arenaLen = Integer.parseInt(this.arenaLength.getText());
        maxNumOfRacers = Integer.parseInt(this.maxRacers.getText());

        if (arenaLen < 100 || arenaLen > 3000 || maxNumOfRacers < 1 || maxNumOfRacers > 20) {
            showErrorMessage("Invalid input values! Please try again.");
            return false;
        }

        return true;
    }

    /**
     * Shows an error message with information message icon
     * @param err is the exact message we want to print on to the screen
     */
    private void showErrorMessage(String err) {
            JOptionPane.showMessageDialog(null,
            err, "Message",
            JOptionPane.INFORMATION_MESSAGE // more icons here --> https://stackoverflow.com/questions/6562847/joptionpane-change-the-icon 
             );
    }

    /**
     * This function makes the background icon, sets its width and height, makes a label that will hold the image
     * and adds the image to the left panel on the main frame
     */
    private void printBackgroundImage() {
        // getting the user's choises from the combo box and text boxes on the screen
        String arenaImagePath = "icons/" + arenaType + ".jpg"; // creating the path to the background image of the area useing the choise from the user's input to the combo box
                
        // creating the background image of the arena with the path that is made of the user's choise
        ImageIcon icon = new ImageIcon(arenaImagePath);
        Image image = icon.getImage().getScaledInstance(leftPanel.getWidth(), leftPanel.getHeight(), Image.SCALE_SMOOTH); // setting the size of the image to be the size of the panel it will sit in

        // adding the background image to the screen
        this.backgroundLabel = new JLabel("", new ImageIcon(image), JLabel.CENTER); // adding the background image to a label
        this.backgroundLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0)); // removing the background from the label that holds the background image of the arena

        // adding the label with the choosen image to the left panel of the main screen
        this.leftPanel.add(backgroundLabel, BorderLayout.CENTER); 
    }

    /**
     * This functions builds the table that is visible in the show info window when pressing the show info button.
     * The table has the information regarding all of the active and completed racers in the current race, also shows an
     * empty table when there are no racers.
     * @return a JTable object (a complete table with all the info) that we then place into the show info window, into a scroll panel. 
     */
    private JTable getRacersInfoFromArena() {
        // declaring some variables
        Object[][] data = new Object[arena.getActiveRacers().size() + arena.getCompletedRacers().size()][5]; // data will enter the table as the information
        Object[] temp = null; // temp will one row at a time and add it to the table
        String[] columnHeaders = {"Racer name", "Current speed", "Max speed", "Current X location", "Finished"}; // column header values for creating the table
        int i = 0;

        // going over all of the completed racers in the arena, adding them into the table
        for (Racer racer : arena.getCompletedRacers()) {
            temp = new String[5];
            temp[0] = racer.getName();
            temp[1] = Double.toString(racer.getCurrentSpeed());
            temp[2] = Double.toString(racer.getMaxSpeed());
            if (raceActive)
                temp[3] = Double.toString(racer.getCurrentLocation().getX());
            else 
                temp[3] = "0";
            temp[4] = "Yes";
            data[i++] = temp;
        }

        // going over all of the active racers in the arena, adding them into the table
        for (Racer racer : arena.getActiveRacers()) {
            temp = new String[5];
            temp[0] = racer.getName();
            temp[1] = Double.toString(racer.getCurrentSpeed());
            temp[2] = Double.toString(racer.getMaxSpeed());
            if (raceActive)
                temp[3] = Double.toString(racer.getCurrentLocation().getX());
            else 
                temp[3] = "0";
            temp[4] = "No";
            data[i++] = temp;
        }

        // creating the table it self and adding the headers and the data to it and then returning the table
        TableModel model = new DefaultTableModel(data, columnHeaders);
        JTable table = new JTable(model);
        return table;
    }

    // ===================================actionPerformed=================================== //

    @Override
    public void actionPerformed(ActionEvent e) {
        RaceBuilder buildInstance = RaceBuilder.getInstance();  // instance of RaceBuilder

        if (e.getSource() == this.buildArenaButton) { // if the BUILD ARENA button was clicked
            // Checking if there is an ongoing race, if there is an active race then we dont allow the user to create a new arena
            if (raceActive && this.arena != null && this.arena.getActiveRacers().size() != 0) {
                showErrorMessage("Please wait for the current race to finish.");
                return;
            }

            // reseting the arena and the racer icons array (also removes the background image but we add it back later)
            this.leftPanel.removeAll();
            MainWindow.racersList = new HashMap<>();
            
            // reseting the arena & racerActive
            this.arena = null;
            this.raceActive  = false;

            // look at the user's inputed data and checking that it is valid
            if (!makeArena()) 
                return;
                
            arenaType = chooseArena.getSelectedItem().toString(); // can be: "AerialArena", "NavalArena", "LandArena"

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
            if (maxNumOfRacers > 11) {
                this.mainFrame.setSize(arenaLen + 270, MAIN_WINDOW_HEIGHT + (maxNumOfRacers-11)*60); // adding 60 pixels to the height for each max racer after 11 racers. arenaLen + 270 is because we need to account for the size of the right panel as well
                this.leftPanel.setSize(arenaLen + 70, LEFT_PANEL_HEIGHT + (maxNumOfRacers-11)*60);// adding 60 pixels to the height for each max racer after 11 racers. arenaLen + 70 is because we need to account for the size of the right panel as well
                this.leftPanel.setPreferredSize(new Dimension(arenaLen + 70, LEFT_PANEL_HEIGHT + (maxNumOfRacers-11)*60)); // this line is needed to make sure that the size will be exactly what we need
            } else {
                this.mainFrame.setSize(arenaLen + 270, MAIN_WINDOW_HEIGHT); // if less than 11 max racers keep original default size, arenaLen + 270 is because we need to account for the size of the right panel as well
                this.leftPanel.setSize(new Dimension(arenaLen + 70, LEFT_PANEL_HEIGHT)); // same as above
                this.leftPanel.setPreferredSize(new Dimension(arenaLen + 70, LEFT_PANEL_HEIGHT)); // same as above
            }

            // generating the background image when all of the inputs are accounted for
            printBackgroundImage();

            this.mainFrame.setVisible(true); // this line "updates" the main window after we have adding items to it, this way the image is now visible     
        }

        if (e.getSource() == this.addRacerButton) { // if the ADD RACER button was clicked
            if(this.raceActive){ //checks if there's an active race, if true then shows error message
                JOptionPane.showMessageDialog(null,
                    "Error, cannot add another racer beacuse race already started/ended.", "Error", JOptionPane.ERROR_MESSAGE);
                     return;
            }
            if(this.arena != null){ //checks user input, if one field isn't correct we show error message
                if (!this.maxSpeed.getText().matches("\\d+") || !this.acceleration.getText().matches("\\d+") || this.maxSpeed.getText().equals("") || this.acceleration.getText().equals("")
                     || this.racerName.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,
                    "Invalid input values! Please try again.", "Missing Values Error", JOptionPane.ERROR_MESSAGE);
                     return;
                } 
                //get user's input from text boxes and combo box
                String racerNameValue = this.racerName.getText();
                double maxSpeedValue = Integer.parseInt(this.maxSpeed.getText());
                double accelerationValue = Integer.parseInt(this.acceleration.getText());
                String racerChoiceCombo = (String)this.chooseRacer.getSelectedItem();
                EnumContainer.Color colorValue = EnumContainer.Color.valueOf(this.chooseColor.getSelectedItem().toString().toUpperCase()); //gets color option from combobox
                String racerTypeValue; //we use racertypeValue to store the package path for RaceBuilder
                //here we check each option and give racertypeValue the correct path
                if(racerChoiceCombo.equals("Airplane") || racerChoiceCombo.equals("Helicopter")){
                    racerTypeValue =  "game.racers.air."+ racerChoiceCombo;
                }
                else if(racerChoiceCombo.equals("Car") || racerChoiceCombo.equals("Horse") || racerChoiceCombo.equals("Bicycle")){
                    racerTypeValue =  "game.racers.land."+ racerChoiceCombo;
                }
                else{
                    racerTypeValue =  "game.racers.naval."+ racerChoiceCombo;
                }

                Racer Instance = null; //we use Instance to initialize the racer
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

                    this.leftPanel.remove(backgroundLabel); // removing the background image from the left panel

                    int i = this.arena.getActiveRacers().size(); //we use arena's activeRacer size method for our icon movements

                    // creating a racer icon based on the user's information and adding the icon to the array of icons and positioning the icon in the correct location
                    JLabel r1 = createRacer("icons/" + (String)Instance.getClass().getSimpleName() + this.chooseColor.getSelectedItem().toString() + ".png");
                    racersList.put(Instance.getSerialNumber(),r1);
                    moveRacer(Instance.getSerialNumber(), 0, (i-1)*RACER_ICON_SIZE + (int)this.arena.getMIN_Y_GAP());
                    
                    // adding the racer to the screen
                    this.leftPanel.add(r1, BorderLayout.CENTER);

                    // re-generating the background image after the racer was added 
                    printBackgroundImage();

                    this.mainFrame.setVisible(true); // this line "updates" the main window after we have adding items to it, this way the image is now visible     

                }
                //here we handle excaption that addRacer method might throw (custom excaptions)
                catch(RacerTypeException ex){
                    JOptionPane.showMessageDialog(null,
                    "Racer doesn't match arena.", "Racer Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println(ex);
                    return;
                }
                catch(RacerLimitException ex){
                    JOptionPane.showMessageDialog(null,
                    "Racers are at max capacity!", "Racer Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println(ex);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,
                    "Error eccourd tring to add racer.", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println(ex);
                }
            }
            else{ //else we didnt build an arean before adding racer so we show an error message
                JOptionPane.showMessageDialog(null,
                    "You have to build an arena first!", "Error", JOptionPane.ERROR_MESSAGE);
                     return;
            }
        }

        if(e.getSource() == this.startRace){ //if the START RACE button was clicked
            if(this.raceActive){ //if racerActive is true it means we cant start a race again (yet)
                JOptionPane.showMessageDialog(null,
                    "Race already started/ended!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(this.arena == null){ //if arena isn't initialized we show error message
                JOptionPane.showMessageDialog(null,
                    "Arena isn't initialized!", "Arena Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(racersList.isEmpty()){ //if now racers have been added we show error message
                JOptionPane.showMessageDialog(null,
                    "You haven't added racers to arena!", "Racer Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else{ //else everything is good so we start the race
                this.raceActive = true; //states that a race has been started
                this.arena.initRace(); //initializes the racers as well
                ExecutorService executor = Executors.newFixedThreadPool(racersList.size()); //new executor for threads //maxNumOfRacers
                for (Racer r : this.arena.getActiveRacers()) { //initialize the threads of racers with executor
                   executor.execute(r);
                }
                executor.shutdown(); //call shoutdown method
            }
        }
    
        if (e.getSource() == this.showInfo) { // if the SHOW INFO button was clicked
            if (arena != null) {
                tablePanel.removeAll(); 

                Dimension infoWinSize = new Dimension(555,175); // saveing the dimentions of the info window

                // setting the window size and the panels layout and border
                infoWin.setSize(infoWinSize);
                tablePanel.setLayout(new BorderLayout());
                tablePanel.setBorder(new EmptyBorder(10, 10, 10, 10));

                // adding the completed tabel to a scroll panel and then setting its size to the size of the info window
                JScrollPane scrollPane = new JScrollPane(getRacersInfoFromArena());
                scrollPane.setPreferredSize(infoWinSize);
                
                tablePanel.add(scrollPane, BorderLayout.CENTER); // adding the scroll panel to the main panel of the frame
        
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
                infoWin.add(tablePanel);
                infoWin.pack();
                infoWin.setVisible(true);
            }
            else {
                showErrorMessage("You have to build an arena first!");
            }
        }
    }
    // =================================Main================================= //
    public static void main(String[] args) {
        createMainWindow(); // creating and showing the main frame
    }
}