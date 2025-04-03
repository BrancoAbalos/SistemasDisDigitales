import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void Panel(String[] args) {


        //CreacionSistema
        Sistema sistema = SistemaImpl.getInstancia();


        //Frame
        JFrame frame = new JFrame("DinoCalculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(500, 700);
        frame.setLocationRelativeTo(null);

        //Texto
        JLabel[] label = new JLabel[6];

        label[0] = new JLabel("Valor a transformar:");
        label[0].setForeground(Color.BLACK);
        label[0].setBounds(20, 0, 500, 70);

        label[1] = new JLabel("Base: ");
        label[1].setForeground(Color.BLACK);
        label[1].setBounds(350, 0, 500, 70);

        label[2] = new JLabel("Valor en Binario: ");
        label[2].setForeground(Color.BLACK);
        label[2].setBounds(20, 180, 500, 70);

        label[3] =  new JLabel("Valor en Octal: ");
        label[3].setForeground(Color.BLACK);
        label[3].setBounds(20, 280, 500, 70);

        label[4] =  new JLabel("Valor en Decimal: ");
        label[4].setForeground(Color.BLACK);
        label[4].setBounds(20, 380, 500, 70);

        label[5] =  new JLabel("Valor en Hexadecimal: ");
        label[5].setForeground(Color.BLACK);
        label[5].setBounds(20, 480, 500, 70);

        //DisplaysRespuestas
        JTextField[] tf = new JTextField[4];

        tf[0] = new JTextField();
        tf[0].setBounds(20, 230, 300, 30);
        tf[0].setEditable(false);


        tf[1] = new JTextField();
        tf[1].setBounds(20, 330, 300, 30);
        tf[1].setEditable(false);


        tf[2] = new JTextField();
        tf[2].setBounds(20, 430, 300, 30);
        tf[2].setEditable(false);


        tf[3] = new JTextField();
        tf[3].setBounds(20, 530, 300, 30);
        tf[3].setEditable(false);


        //displayImage
        SwingUtilities.invokeLater(() -> {
            ImagePanel[] imagePanel = new ImagePanel[4];
            imagePanel[0] = new ImagePanel("src/resources/brontosaurus-37797_1920.png", 150, 250);
            imagePanel[0].setBounds(320, 400, 150, 250); // Ajustar las coordenadas según el diseño

            imagePanel[1] = new ImagePanel("src/resources/animal-1295637_1920.png", 80, 80);
            imagePanel[1].setBounds(200, 150, 80, 80); // Ajustar las coordenadas según el diseño

            imagePanel[2] = new ImagePanel("src/resources/dinosaur3.png", 120, 120);
            imagePanel[2].setBounds(200, 335, 120, 120); // Ajustar las coordenadas según el diseño

            imagePanel[3] = new ImagePanel("src/resources/dinosaur4.png", 100, 100);
            imagePanel[3].setBounds(200, 455, 120, 120); // Ajustar las coordenadas según el diseño


            frame.add(imagePanel[0]);
            frame.add(imagePanel[1]);
            frame.add(imagePanel[2]);
            frame.add(imagePanel[3]);
        });




        //CeldasTexto
        JTextField[] textField = new JTextField[6];

        textField[0] = new JTextField(10);
        textField[0].setBounds(20, 50, 300, 30);


        //Button
        JButton button = new JButton("Transformar");
        button.setBounds(80, 100, 300, 30);

        //DisplayButton
        JButton buttonDisplay = new JButton("2");
        buttonDisplay.setBounds(350, 50, 80, 30);
        //
        JPopupMenu popup = new JPopupMenu("Base");
        //
        JMenuItem item2 = new JMenuItem("Base 2");
        JMenuItem item8 = new JMenuItem("Base 8");
        JMenuItem item10 = new JMenuItem("Base 10");
        JMenuItem item16 = new JMenuItem("Base 16");

        popup.add(item2);
        popup.add(item8);
        popup.add(item10);
        popup.add(item16);

        buttonDisplay.addActionListener(e -> popup.show(buttonDisplay, 0, buttonDisplay.getHeight()));
        item2.addActionListener(e -> buttonDisplay.setText("2"));
        item8.addActionListener(e -> buttonDisplay.setText("8"));
        item10.addActionListener(e -> buttonDisplay.setText("10"));
        item16.addActionListener(e -> buttonDisplay.setText("16"));


        frame.add(buttonDisplay);
        frame.add(button);
        for (int i = 0; i < label.length; i++) {
            if (label[i] != null) {
                frame.add(label[i]);
            }
            if (textField[i] != null) {
                frame.add(textField[i]);
            }
        }
        for (int i = 0; i < tf.length; i++) {
            if (tf[i] != null) {
                frame.add(tf[i]);
            }
        }
        //AccionDeTransformar
        button.addActionListener(e -> {
            int base = Integer.parseInt(buttonDisplay.getText());
            tf[0].setText(sistema.calcularBase2(textField[0].getText(), base));
            tf[1].setText(sistema.calcularBase8(textField[0].getText(), base));
            tf[2].setText(sistema.calcularBase10(textField[0].getText(), base));
            tf[3].setText(sistema.calcularBase16(textField[0].getText(), base));
        });


        frame.setVisible(true);


    }
}