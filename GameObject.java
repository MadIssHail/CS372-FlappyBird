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
    if ((g.getImage().getBounds()).intersects((this.getImage().getBounds())) && this.getClass() == Pipe.class) {     // checks to see if the two labels intersect
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
  Toolkit tk = Toolkit.getDefaultToolkit();
  bird = getClass().getResource("/resources/die_face_1_T.png");
  Dice1img = tk.getImage(Dice1);
  Dice1img = Dice1img.getScaledInstance(50,50,Image.SCALE_SMOOTH);
  Dice1icon = new ImageIcon(Dice1img);
  //image = resource to add image to label
   boolean goingDown = true;
  Bird( int difficulty) {
   // image = bird;
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

class Pipe extends GameObject {
  Pipe() {
    //image = resource to add image
  }
}



