package cn.tedu.shoot;
import java.util.Random;
public class FlyingObject {
    Random rand=new Random();
    int width;
    int height;
    int x;
    int y;
    FlyingObject(int height,int width){
        this.height=height;
        this.width=width;
        x=rand.nextInt(World.WIDTH-width);
        y=-height;
    }
    FlyingObject(int height,int width,int x,int y){
        this.height=height;
        this.width=width;
        this.x=x;
        this.y=y;
    }









}
