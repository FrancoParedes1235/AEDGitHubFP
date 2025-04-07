import java.awt.*;
import java.awt.geom.Path2D;
import javax.swing.*;

public class PythagorasTree extends JPanel {

    private static final int DEPTH_LIMIT = 9; // Puedes aumentar para más detalle
    private static final float BASE_HUE = 0.15f;

    public PythagorasTree() {
        setPreferredSize(new Dimension(800, 800));
        setBackground(Color.WHITE);
    }

    private void drawTree(Graphics2D g, float x1, float y1, float x2, float y2, int depth) {
        if (depth == DEPTH_LIMIT)
            return;

        final float dx = x2 - x1;
        final float dy = y1 - y2;

        final float x3 = x2 - dy;
        final float y3 = y2 - dx;
        final float x4 = x1 - dy;
        final float y4 = y1 - dx;
        final float x5 = x4 + 0.5f * (dx - dy);
        final float y5 = y4 - 0.5f * (dx + dy);

        // Cuadrado
        var square = new Path2D.Float();
        square.moveTo(x1, y1);
        square.lineTo(x2, y2);
        square.lineTo(x3, y3);
        square.lineTo(x4, y4);
        square.closePath();

        g.setColor(Color.getHSBColor(BASE_HUE + depth * 0.02f, 1, 1));
        g.fill(square);
        g.setColor(Color.LIGHT_GRAY);
        g.draw(square);

        // Triángulo
        var triangle = new Path2D.Float();
        triangle.moveTo(x3, y3);
        triangle.lineTo(x4, y4);
        triangle.lineTo(x5, y5);
        triangle.closePath();

        g.setColor(Color.getHSBColor(BASE_HUE + depth * 0.035f, 1, 1));
        g.fill(triangle);
        g.setColor(Color.LIGHT_GRAY);
        g.draw(triangle);

        drawTree(g, x4, y4, x5, y5, depth + 1); // rama izquierda
        drawTree(g, x5, y5, x3, y3, depth + 1); // rama derecha
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTree((Graphics2D) g, 350, 700, 450, 700, 0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var frame = new JFrame("Árbol de Pitágoras");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.add(new PythagorasTree(), BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
