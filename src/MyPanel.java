import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.Key;

public class MyPanel extends JPanel implements KeyListener {
    private static String[] options =  {"USD", "CAD", "EUR", };
    protected static JComboBox<String>  fromCurrencyBox = new JComboBox<>(options);
    protected static JComboBox<String>  toCurrencyBox = new JComboBox<>(options);
    private static JLabel fromCurrency;
    private static JLabel toCurrency;
    private static JLabel title;
    protected static JTextField textField;
    private static JTextField convertedCurrencyBox;
    private static BufferedImage imageOne;
    private static Image imageOneResized;
    private static BufferedImage imageTwo;
    private static Image imageTwoResized;
    private static JLabel pressEnterHere;
    private static JLabel conversionRateDate;
    MyPanel() {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(800,400));
        this.setBackground(new Color(240,216,180));
        dropDownMenu();
        addLabels();
        addTextFields();
        addImages();

    }
    public void addImages() {
        try {
            imageOne = imageOne = ImageIO.read(getClass().getResource("/res/image_1.png"));
            imageOneResized = imageOne.getScaledInstance(100,80,Image.SCALE_DEFAULT);

            imageTwo = ImageIO.read(getClass().getResource("/res/image_2.png"));
            imageTwoResized = imageTwo.getScaledInstance(100,80,Image.SCALE_DEFAULT);
        }   catch(IOException e)    {
            e.printStackTrace();
        }

    }


    public void dropDownMenu()  {
        fromCurrencyBox.setBounds(90, 200, 100, 20);
        this.add(fromCurrencyBox);

        toCurrencyBox.setBounds(566,200,100,20);
        this.add(toCurrencyBox);
    }
    public void addLabels()  {
        fromCurrency = new JLabel ("Currency to Convert");
        fromCurrency.setBounds(93,150,200,20);
        fromCurrency.setForeground(Color.WHITE);
        fromCurrency.setFont(new Font("Serif", Font.BOLD,16));
        this.add(fromCurrency);

        toCurrency = new JLabel ("Converted Currency");
        toCurrency.setBounds(571,150,200,20);
        toCurrency.setForeground(Color.WHITE);
        toCurrency.setFont(new Font("Serif", Font.BOLD, 16));
        this.add(toCurrency);

        title = new JLabel();
        title.setText("Simple Currency Converter");
        title.setBounds(205 ,-130,400,400);
        title.setFont(new Font("SansSerif",Font.BOLD,30));
        title.setForeground(new Color(235, 134, 127));
        this.add(title);

        pressEnterHere = new JLabel();
        pressEnterHere.setText("Please press \"Enter\" to convert!");
        pressEnterHere.setBounds(93,285,200,20);
        pressEnterHere.setForeground(new Color(250, 164, 79));
        pressEnterHere.setFont(new Font("Serif",Font.ITALIC,12));
        this.add(pressEnterHere);

        conversionRateDate = new JLabel();
        conversionRateDate.setText("June 2022");
        conversionRateDate.setBounds(360,-90,400,400);
        conversionRateDate.setFont(new Font("Serif", Font.ITALIC,16));
        conversionRateDate.setForeground(new Color(250, 164, 79));
        this.add(conversionRateDate);

    }
    public void addTextFields()   {
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,40));
        textField.setBounds(90,240,150,40);
        textField.setFont(new Font("Serif", Font.PLAIN,30));
        textField.setText("0");
        textField.addKeyListener(this);
        this.add(textField);

        convertedCurrencyBox = new JTextField();
        convertedCurrencyBox.setEditable(false);
        convertedCurrencyBox.setPreferredSize(new Dimension(250,40));
        convertedCurrencyBox.setBounds(566,240,150,40);
        convertedCurrencyBox.setFont(new Font("Serif", Font.PLAIN,30));
        this.add(convertedCurrencyBox);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Drawing Rectangle around labels
        g.setColor(new Color(245, 198, 164));
        g.fillRect(89, 143, 150, 35);
        g.fillRect(566, 143, 150, 35);

        // Drawing Border around labels
        g.setColor(new Color(230, 83, 83));
        g.drawRect(89, 143, 150, 35);
        g.drawRect(566, 143, 150, 35);

        // Drawing the Arrow
        g.setColor(new Color(255, 255, 255));
        g.fillRect(280, 255, 200, 10);

        // Draws the tip using a triangle via 3 coordinate points stored in arrays
        // First parameter are x values, 2nd are y values, 3rd is the # of points
        g.fillPolygon(new int[]{480, 480, 525}, new int[]{240, 280, 260}, 3);

        // Drawing our images
        g.drawImage(imageOneResized,50,25,this);
        g.drawImage(imageTwoResized,650,25,this);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)    {
            if (textField.getText().matches("[0-9.]+") && !textField.getText().matches("\\.+")) {
                CurrencyCalculation.currencyCalculation();
                convertedCurrencyBox.setText(CurrencyCalculation.getConvertedAmount());
            }
            else
                convertedCurrencyBox.setText("Invalid input");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
