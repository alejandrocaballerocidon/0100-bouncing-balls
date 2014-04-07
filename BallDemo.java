import java.awt.Color;
import java.util.HashSet;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        //BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        //ball.draw();
        //BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        //ball2.draw();
        HashSet<BouncingBall> balls = new HashSet<BouncingBall>();

        for(int i=0; i <numBolas; i++)

        {
            BouncingBall ball = new BouncingBall(50+32*i,50, 16, Color.blue, ground, myCanvas);

            balls.add(ball);
            ball.draw();
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay

            for(BouncingBall ball : balls){
                ball.move();
                
                // stop once ball has travelled a certain distance on x axis
                if(ball.getXPosition() >= 550 + 32 * numBolas) {
                    finished = true;
                }
            }
        }
        
        for(BouncingBall ball : balls){
            ball.erase();
        }
    }
}
