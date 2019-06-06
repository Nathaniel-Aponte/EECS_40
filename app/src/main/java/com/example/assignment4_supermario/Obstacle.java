package com.example.assignment4_supermario;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Obstacle extends Object{

    private boolean playing;
    private Bitmap image1;
    public int xX, yY;
    private int screenHeight = 1080;

    public Obstacle(Bitmap bmp, int x, int y){
        image1 = bmp;
        xX = x;
        yY = y + screenHeight/2;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(image1,xX,yY,null);
    }
    public void update(){
        //update anything
        if(playing) {
            xX -= 5;
            if (xX <= 0) {
                xX = GameView.WIDTH;
            }
        }
    }
    public void setPlaying(boolean b){

        playing = b;
    }
    public boolean characterCollide(Character character){

        Rect r1 = getRectangle(character.x, character.y, character.width, character.height);;
        Rect r2 = getRectangle(xX, yY, 91, 91);

        if(r2.contains(r1.left,r1.top) || r2.contains(r1.right,r1.top) || r2.contains(r1.left, r1.bottom) || r2.contains(r1.right, r1.bottom)){
            return true;
        }
//                if(r2.contains(r1.left,r1.top) || r2.contains(r1.right,r1.top)){
//                    return 1;
//                }
//                if(r2.contains(r1.left, r1.bottom) || r2.contains(r1.right, r1.bottom)){
//                    return 2;
//                }
        return false;
    }
}
