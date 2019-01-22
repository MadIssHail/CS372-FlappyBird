import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;


public class GameObject {

  public void GameOver() {   //GO IN GUI

  }
  public void scoreUp() { //GO IN GUI

  }

  protected JLabel image;
  protected double vx, vy;

  GameObject()
  {
    image = new JLabel();   //very important data field
    vx = 0.0;
    vy = 0.0;
  }
  public JLabel getImage() { return image;}
  public boolean collision(GameObject g) {
    boolean intersects = false;
    if ((g.getImage().getBounds()).intersects((this.getImage().getBounds())) && this.getClass() == TopPipe.class) {     // checks to see if the two labels intersect
      intersects = true;
      GameOver();
    }
    else if ((g.getImage().getBounds()).intersects((this.getImage().getBounds())) && this.getClass() == BottomPipe.class) {     // checks to see if the two labels intersect
      intersects = true;
      GameOver();
    }
    else if ((g.getImage().getBounds()).intersects((this.getImage().getBounds())) && this.getClass() == scoreBox.class) {
      intersects = true;
      scoreUp();
    }
    return intersects;
  }

}
class Bird extends GameObject implements KeyListener {
  private URL bird;
  private Image birdimg;
  private ImageIcon birdIcon;
  private JLabel birdLabel;
  //image = resource to add image to label
   boolean goingDown = true;
  Bird(int difficulty) {

    Toolkit tk = Toolkit.getDefaultToolkit();
    bird = getClass().getResource("/resources/Bird2-1.png.png");
    birdimg = tk.getImage(bird);
    birdimg = birdimg.getScaledInstance(50,50,Image.SCALE_SMOOTH);
    birdIcon = new ImageIcon(birdimg);
    birdLabel = new JLabel(birdIcon);
    image = birdLabel;
    vy = difficulty;
    vx = 1;  // how fast is this
  }
  public void keyPressed(KeyEvent k) {
    if (k.getKeyChar() == 'W' || k.getKeyChar() == 'S' || k.getKeyCode() == 38 || k.getKeyCode() == 40) {
      move();
    }
  }      //need to implement at some point, maybe call move()?
  public void keyReleased(KeyEvent k) { }
  public void keyTyped (KeyEvent k) {}
  public void move() {
    while (true) {
      if (goingDown == true) {
        if (vy <= 0) {
          goingDown = false;
          vy++;
        } else {
          vy--;
        }
      }
      else {
        if (vy >= 50) {
          goingDown = true;
          vy--;
        }
        else {
          vy++;
        }
      }

    }
  } //need to implement later on

}

class scoreBox extends GameObject {
  scoreBox() {
    //image = resource to add image to label
    image.setVisible(false);
  }
}

class TopPipe extends GameObject {
  private URL topPipe;
  private Image topPipeimg;
  private ImageIcon topPipeIcon;
  private JLabel topPipeLabel;

  TopPipe() {

    Toolkit tk = Toolkit.getDefaultToolkit();
    topPipe = getClass().getResource("/resources/pipe_down.png");
    topPipeimg = tk.getImage(topPipe);
    topPipeimg = topPipeimg.getScaledInstance(50,50,Image.SCALE_SMOOTH);
    topPipeIcon = new ImageIcon(topPipeimg);
    topPipeLabel = new JLabel(topPipeIcon);
    image = topPipeLabel;
    //image = resource to add image
  }
}

class BottomPipe extends GameObject {
  private URL bottomPipe;
  private Image bottomPipeimg;
  private ImageIcon bottomPipeIcon;
  private JLabel bottomPipeLabel;

  BottomPipe() {

    Toolkit tk = Toolkit.getDefaultToolkit();
    bottomPipe = getClass().getResource("/resources/pipe_up.png");
    bottomPipeimg = tk.getImage(bottomPipe);
    bottomPipeimg = bottomPipeimg.getScaledInstance(50,50,Image.SCALE_SMOOTH);
    bottomPipeIcon = new ImageIcon(bottomPipeimg);
    bottomPipeLabel = new JLabel(bottomPipeIcon);
    image = bottomPipeLabel;
    //image = resource to add image
  }
}



