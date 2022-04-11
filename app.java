import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.FontMetrics;
class app
{
    //Variables
    public static int RedVal = 0;
    public static int GreenVal = 0;
    public static int BlueVal = 0;
    
    //Window Setup
    public static void mainWindowSetup(JFrame window)
    {
        window.setTitle("Live Output RGB"); //Setting Title
        window.setSize(800, 600); //Setting Size Of Window
        window.setVisible(true); //Setting Window Visible
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //It should exit everything when you click on close: X button
        window.setLocationRelativeTo(null); //This centers the window
        titleAlign(window); //This aligns the word to center
        window.addComponentListener(new ComponentAdapter() { //Listens to the window actions
            @Override
            public void componentResized(ComponentEvent e) { //checks if Window has resized
                titleAlign(window);
            }

        });
    }
    //Here is where we get the output int terminal
    public static void GetOutput(JLabel input) //Input basically means the label
    {
        System.out.println(input.getText() + " - Output!"); //Here is where it print's!
    }
    //Setups the Rgb window which let's you to choose your rgb code using sliders
    public static void rgbColorSetupWindow(JFrame mainWindow)
    {
        //Window Setup Basically the same window setup as the main one :)
        JFrame window = new JFrame("Set RGB Values here");
        window.setVisible(true);
        window.setSize(400, 320);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //But you are not supposed to close the app from this window :(
        window.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                titleAlign(window);
            }

        });
        //Container
        //JPANEL!
        JPanel panel = new JPanel(); //This will contain all of the slider and stuff
        window.add(panel);
        //Sliders and Labels!
        //Red
        JLabel rLabel = new JLabel("R: 0");
        panel.add(rLabel);
        JSlider rSlider = new JSlider(JSlider.VERTICAL);
        panel.add(rSlider);
        rSlider.setMaximum(255);
        rSlider.setValue(0);
        //Green
        JLabel gLabel = new JLabel("G: 0");
        panel.add(gLabel);
        JSlider gSlider = new JSlider(JSlider.VERTICAL);
        panel.add(gSlider);
        gSlider.setMaximum(255);
        gSlider.setValue(0);
        //Blue
        JLabel bLabel = new JLabel("B: 0");
        panel.add(bLabel);
        JSlider bSlider = new JSlider(JSlider.VERTICAL);
        panel.add(bSlider);
        bSlider.setMaximum(255);
        bSlider.setValue(0);
        //Final Value
        JLabel finalLabel = new JLabel("R: 0, G: 0, B: 0");
        panel.add(finalLabel);
        //Get Output from func(Get Output()), so for that we need a BUTTON
        JButton GetOutputBN = new JButton("Get output in terminal!");
        GetOutputBN.addActionListener(e -> GetOutput(finalLabel)); //This is where Get Output comes which gives the output in TERMINAL!
        panel.add(GetOutputBN);
        //This loop set's the labels
        while(true)
        {
            GetSliderOutput(rSlider, gSlider, bSlider); // here is where GetSliderOutput comes into play ;)
            mainWindow.getContentPane().setBackground(new Color(RedVal, GreenVal, BlueVal)); //We set the mainWindow's background color :)
            //Conversion of the slider value int value to string value
            String redString = Integer.toString(RedVal);
            String greenString = Integer.toString(GreenVal);
            String blueString = Integer.toString(BlueVal);
            //And we set the labels :)
            rLabel.setText("R: " + redString);
            gLabel.setText("G: " + greenString);
            bLabel.setText("B: " + blueString);
            finalLabel.setText("R: "+redString+", "+"G: "+greenString+", "+"B: "+blueString);
        }
    }
    //This function sets the title to center, found how to do it on https://stackoverflow.com/questions/9662393/how-to-center-align-the-title-in-a-jframe
    public static void titleAlign(JFrame frame) {
        Font font = frame.getFont();
        String currentTitle = frame.getTitle().trim();
        FontMetrics fm = frame.getFontMetrics(font);
        int frameWidth = frame.getWidth();
        int titleWidth = fm.stringWidth(currentTitle);
        int spaceWidth = fm.stringWidth(" ");
        int centerPos = (frameWidth / 2) - (titleWidth / 2);
        int spaceCount = centerPos / spaceWidth;
        String pad = "";
        pad = String.format("%" + (spaceCount - 14) + "s", pad);
        frame.setTitle(pad + currentTitle);

    }
    //This is where we get the slider output
    public static void GetSliderOutput(JSlider redSlider, JSlider greenSlider, JSlider blueSlider)
    {
        RedVal = redSlider.getValue();
        GreenVal = greenSlider.getValue();
        BlueVal = blueSlider.getValue();
    }
    //Here is where we run all of this func();
    public static void main(String args[])
    {
        //Print's You Will Get Output Here
        System.out.println("You will get output here in terminal!");
        JFrame window = new JFrame();
        //Window Setup :)
        mainWindowSetup(window);
        rgbColorSetupWindow(window);
    }
}
