import processing.core.PApplet;

public class Sketch extends PApplet {

  float circleSpeed = 5;
  float[] circleY = new float[25];
  float[] rectHeights = new float[25];
  float rectHeight = 5;

  int num = 25;
  int[] x = new int[num];
  int[] y = new int[num];
  int indexPosition = 0;

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    for (int i = 0; i < circleY.length; i++) {
      circleY[i] = random(height);
    }
  }

  public void draw() {
    background(50);

    //Drawing Rectangles
    for(int j = 0; j < 16; j++){
      rect(j * 25, 395, 25, rectHeights[j] * -2);
    }

    for (int i = 0; i < circleY.length; i++) {
      float circleX = width * i / circleY.length;
      ellipse(circleX, circleY[i], 5, rectHeight);

      circleY[i]+= circleSpeed;

      if (circleY[i] > height) {
        circleY[i] = 0;
        rectHeights[i] += 1;
      }
    }

    noStroke();
    x[indexPosition] = mouseX;
    y[indexPosition] = mouseY;
    indexPosition = (indexPosition + 1) % num;
    for (int i = 0; i < num; i++) {
      
      int pos = (indexPosition + i) % num;
      float radius = (num-i) / 2;
      ellipse(x[pos], y[pos], radius, radius);
    }
  }

  @Override
  public void keyPressed() {
      // TODO Auto-generated method stub
      super.keyPressed();
      if(keyCode == DOWN){
        circleSpeed = 3;
      }
      else if(keyCode == UP){
        circleSpeed = 7;
      }
  }

  @Override
    public void keyReleased() {
        circleSpeed = 5;
    }
}