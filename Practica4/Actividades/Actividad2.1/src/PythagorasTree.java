import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;

public class PythagorasTree extends JPanel {
    private int profundidad;

    public PythagorasTree(int profundidad) {
        this.profundidad = profundidad;
        setPreferredSize(new Dimension(800, 800));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // no neceesarios
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);// Suavizado de bordes
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);// Calidad de
                                                                                                // renderizado
        // color de fondo
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setColor(Color.GREEN);
        // Llamada inicial para la recursión
        trazaArbol(g2d, 350, 600, 100, -90, profundidad);
    }

    private void trazaArbol(Graphics2D g, int x, int y, int lado, double angulo, int nivel) {
        if (nivel == 0 || lado < 2)
            return;

        int x2 = x - (int) (lado * Math.cos(Math.toRadians(angulo)));// direccion arbol planos
        int y2 = y + (int) (lado * Math.sin(Math.toRadians(angulo)));

        g.drawLine(x, y, x2, y2);

        int nuevoLado = (int) (lado * 0.7);
        trazaArbol(g, x2, y2, nuevoLado, angulo - 45, nivel - 1);
        trazaArbol(g, x2, y2, nuevoLado, angulo + 45, nivel - 1);
    }
}
