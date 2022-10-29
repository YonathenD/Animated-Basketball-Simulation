/************************

  Name: Yonathen Desisa
  Date: 6/3/21
  Period: 3
  Lab: Motion
  
  Purpose:
    This program is a fun physics
project that can animate or graph
the trajectory of a basketball being
launched into a basketball hoop.
  
*************************/

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Motion extends JPanel {
   final int WIDTH = 800;
   final int HEIGHT = 400;
   ArrayList<Integer> coords;
   int scale = 5;
   private static int DELAY = 10;
   int animatedPoints = 0; 
   char path;
   
   public Motion(ArrayList<Integer> coords, char path) {
      this.coords = coords;
      this.path = path;
      setPreferredSize(new Dimension(WIDTH,HEIGHT));
   }

   public void paintComponent (Graphics page) {
      
      //Background
      page.setColor(Color.white);
      page.fillRect(0,0,getWidth(),getHeight());
      Color naturalGreen = new Color(0, 200, 100);
      page.setColor(naturalGreen);
      page.fillRect(0,0,getWidth(),getHeight());
      
      //Sky
      Color naturalBlue = new Color(0, 100, 200);
      page.setColor(naturalBlue);
      page.fillRect(0, 0, WIDTH, 200);
      
      //Clouds
      page.setColor(Color.white);
      page.fillOval(10, 100, 200, 10);
      page.fillOval(20, 90, 200, 15);
      page.fillOval(400, 50, 200, 10);
      page.fillOval(300, 55, 200, 10);
      page.fillOval(600, 100, 200, 10);
      
      //Basketball hoop
      page.setColor(Color.white);
      page.fillRect(600, 100, 10, 100);
      page.setColor(Color.black);
      page.fillRect(610, 125, 50, 10);
      page.fillRect(610, 175, 50, 10);
      page.fillRect(650, 125, 10, 200);
      page.setColor(Color.orange);
      page.fillRect(540, 175, 60, 10);
      
      //Net
      page.setColor(Color.white);
      page.drawArc(535, 185, 20, 50, 90, -100);
      page.drawArc(585, 185, 20, 50, 90, 100);
      page.drawLine(550, 185, 580, 215);
      page.drawLine(560, 185, 585, 210);
      page.drawLine(570, 185, 587, 200);
      
      page.drawLine(590, 185, 560, 215);
      page.drawLine(580, 185, 555, 210);
      page.drawLine(570, 185, 553, 205);
      
      //Basketball Court
      page.setColor(Color.darkGray);
      page.fillRect(0, 250, 600, HEIGHT);
      page.setColor(Color.white);
      page.drawRect(0, 250, 600, HEIGHT);
      page.drawLine(325, 300, 600, 300);
      page.drawLine(325, 350, 600, 350);
      page.drawLine(325, 300, 325, 350);
      page.drawArc(300, 300, 50, 50, 90, 180);
      page.drawArc(175, 275, 100, 100, 90, 180);
      page.drawLine(225, 275, 600, 275);
      page.drawLine(225, 375, 600, 375);
      
      //Basketball
      try {
         page.setColor(Color.orange);
         page.fillOval((coords.get(animatedPoints) * scale) + 155, (HEIGHT - (coords.get(animatedPoints+1) * scale)) - 85, 20, 20);
         page.setColor(Color.black);
         page.drawLine((coords.get(animatedPoints) * scale) + 165, (HEIGHT - (coords.get(animatedPoints+1) * scale)) - 85, (coords.get(animatedPoints) * scale) + 165, (HEIGHT - (coords.get(animatedPoints+1) * scale)) - 65);
         page.drawLine((coords.get(animatedPoints) * scale) + 155, (HEIGHT - (coords.get(animatedPoints+1) * scale)) - 75, (coords.get(animatedPoints) * scale) + 175, (HEIGHT - (coords.get(animatedPoints+1) * scale)) - 75);
         page.drawArc((coords.get(animatedPoints) * scale) + 150, (HEIGHT - (coords.get(animatedPoints+1) * scale)) - 80, 10, 10, 90, -180);
         page.drawArc((coords.get(animatedPoints) * scale) + 170, (HEIGHT - (coords.get(animatedPoints+1) * scale)) - 80, 10, 10, 90, 180);
      }
      catch (Exception e) {
         System.exit(0);
      }
      
      //Graph
      if (path == 'g') {
         page.setColor(Color.red);
         for (int i = 0; i < coords.size(); i += 8) {
            if ((coords.get(i) * scale) + 175 <= WIDTH && (HEIGHT - (coords.get(i+1) * scale)) - 75 >= 0) {
               page.fillOval((coords.get(i) * scale) + 175, (HEIGHT - (coords.get(i+1) * scale)) - 75, 5, 5);
            }
         }
      }
      else {
         go(page);
      }
   }
   
   //Animation
   public void go(Graphics page) {
      TimerTask task = 
         new TimerTask() {
            public void run() {
               if (animatedPoints+1 < coords.size() && (coords.get(animatedPoints) * scale) + 175 <= WIDTH && (HEIGHT - (coords.get(animatedPoints+1) * scale)) - 75 >= 0) {
                  synchronized (coords) {
                     try {
                        page.setColor(Color.orange);
                        page.fillOval((coords.get(animatedPoints) * scale) + 155, (HEIGHT - (coords.get(animatedPoints+1) * scale)) - 85, 20, 20);
                        page.setColor(Color.black);
                        page.drawLine((coords.get(animatedPoints) * scale) + 165, (HEIGHT - (coords.get(animatedPoints+1) * scale)) - 85, (coords.get(animatedPoints) * scale) + 165, (HEIGHT - (coords.get(animatedPoints+1) * scale)) - 65);
                        page.drawLine((coords.get(animatedPoints) * scale) + 155, (HEIGHT - (coords.get(animatedPoints+1) * scale)) - 75, (coords.get(animatedPoints) * scale) + 175, (HEIGHT - (coords.get(animatedPoints+1) * scale)) - 75);
                        page.drawArc((coords.get(animatedPoints) * scale) + 150, (HEIGHT - (coords.get(animatedPoints+1) * scale)) - 80, 10, 10, 90, -180);
                        page.drawArc((coords.get(animatedPoints) * scale) + 170, (HEIGHT - (coords.get(animatedPoints+1) * scale)) - 80, 10, 10, 90, 180);
                     }
                     catch (Exception e) {
                        System.exit(0);
                     }
                  }
                  repaint();
               }
               animatedPoints += 2;
            }
         };
      Timer timer = new Timer();
      timer.schedule(task, 0, DELAY);
   }

   public static void main (String[] args) {
   
      Scanner input = new Scanner(System.in);
      
      System.out.println("\n/\\/\\/\\ Three-Pointer Simulation /\\/\\/\\");
      
      /*User input with conversions from centimeters to meters and grams to kilograms*/
      System.out.println("\nBasketball Diameter: 24cm");
      double diam = 24.0;
      diam /= 100;
      System.out.println("Basketball Mass: 624g");
      double mass = 624.0;
      mass /= 1000;
      System.out.println("Basketball Drag Coefficient: 0.54");
      double dragCoef = 0.54;
      System.out.println("Basketball Launch Height: 170cm");
      double height = 170.0;
      height /= 100;
      
      System.out.println("\nChoose your launch angle and speed!");
      
      System.out.print("\nEnter Launch Angle (degrees): ");
      double angle = input.nextDouble();
      System.out.print("Enter Launch Speed (m/s): ");
      double velocity = input.nextDouble();
      velocity *= 8;
   
      double vx = velocity * Math.cos(Math.toRadians(angle));
      double vy = velocity * Math.sin(Math.toRadians(angle));
      
      double area = Math.PI * diam/2 * diam/2;
      
      double airDensity = 1.162, gravAccel = 9.800;
      
      double deltaT = 0.0001, ax = 0.0, ay = 0.0, x = 0.0, y = height, apogee = 0.0, apogeeTime = 0.0, flightDist = 0.0, flightTime = 0.0;
      
      //ArrayList to hold coordinates
      ArrayList<Integer> coords = new ArrayList<>();
      
      for (double time = deltaT; y > 0; time += deltaT) {
      
         double dragX = 0.5 * dragCoef * airDensity * area * vx * vx;
         double dragY = 0.5 * dragCoef * airDensity * area * vy * vy;
         
         ax = (-1 * dragX)/mass;
         ay = (vy > 0) ? (-1*dragY/mass) - gravAccel : (dragY/mass) - gravAccel;
         
         vx += (ax * deltaT);
         vy += (ay * deltaT);
         
         if (y > apogee) {
            apogee = y;
            apogeeTime = time;
         }
         
         x += (vx * deltaT);
         y += (vy * deltaT);
         
         
         if (y >= 0) {
            coords.add((int)x);
            coords.add((int)y);
            
            //Comment out these points if you want a faster animation
            //coords.add((int)x);
            //coords.add((int)y);
            //coords.add((int)x);
            //coords.add((int)y);
            //coords.add((int)x);
            //coords.add((int)y);
            
         }
         
         flightDist = x;
         flightTime = time;
         
      }
      
      System.out.print("\nAnimation or Graph(a/g)? ");
      char path = input.next().toLowerCase().charAt(0);
      
      System.out.println("\n3-2-1 ... Launch!");
      
      JFrame frame = new JFrame("Launch!!!");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new Motion(coords, path));
      frame.pack();
      frame.setVisible(true);
      
   } 
}