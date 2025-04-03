import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class ImagePanel extends JPanel {
    private BufferedImage image;
    private int width;
    private int height;



    public ImagePanel(String imagePath, int width, int height) {
        this.width = width;
        this.height = height;

        try {
            image = ImageIO.read(new File(imagePath));
            System.out.println("Imagen Cargada");
        } catch (IOException e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            // Dibujar
            g.drawImage(image, 0, 0, width, height, this);

        }
    }
}
