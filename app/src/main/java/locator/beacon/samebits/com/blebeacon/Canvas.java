package locator.beacon.samebits.com.blebeacon;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by 70459 on 05/07/2017.
 */

public class Canvas  extends View {

    private ImageView[] imagenes= new ImageView[64];

    //public android.graphics.Canvas lienzo;
    public Canvas(Context context) {
        super(context);
        initComponents();
    }

    private void initComponents()
    {
        for(int i=0;i<imagenes.length;i++)
        {
            imagenes[i]= new ImageView(getContext());
            imagenes[i].setBackgroundColor(Color.BLACK);
        }
    }




/*
    protected void onDraw(android.graphics.Canvas canvas)
    {

        this.lienzo = canvas;
        int ancho=canvas.getWidth();

        final Paint pincel1=new Paint();
        pincel1.setColor(Color.BLUE);

        canvas.drawLine(50, 0,50,canvas.getHeight(),pincel1);
        canvas.drawLine(100,0,100,canvas.getHeight(),pincel1);
        canvas.drawLine(150,0,150,canvas.getHeight(),pincel1);
        canvas.drawLine(200,0,200,canvas.getHeight(),pincel1);
        canvas.drawLine(250,0,250,canvas.getHeight(),pincel1);
        canvas.drawLine(300,0,300,canvas.getHeight(),pincel1);
        canvas.drawLine(350,0,350,canvas.getHeight(),pincel1);
        canvas.drawLine(400,0,400,canvas.getHeight(),pincel1);
        canvas.drawLine(0,50,canvas.getWidth(),50,pincel1);
        canvas.drawLine(0,100,canvas.getWidth(),100,pincel1);
        canvas.drawLine(0,150,canvas.getWidth(),150,pincel1);
        canvas.drawLine(0,200,canvas.getWidth(),200,pincel1);
        canvas.drawLine(0,250,canvas.getWidth(),250,pincel1);
        canvas.drawLine(0,300,canvas.getWidth(),300,pincel1);
        canvas.drawLine(0,350,canvas.getWidth(),350,pincel1);
        canvas.drawLine(0,400,canvas.getWidth(),400,pincel1);
    }
    */
}
