package example.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private float width, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView image = (ImageView) findViewById(R.id.imageView);

        CurvedBitmapDrawer drawer = new CurvedBitmapDrawer(getApplicationContext());

        Paint paint = new Paint();

        //圖形寬(取代原圖的縮放比率)
        paint.setStrokeWidth(48);

        drawer.setPaint(paint);
        drawer.setResourceId(R.mipmap.ic_launcher);
        drawer.setNumber(10);

        Path path = drawer.getPath();

        path.moveTo(50, 50);

//        path.cubicTo(300, 50, 300, 800, 50, 800);
        path.cubicTo(50, 900, 800, 900, 800, 800);



        //記憶體控管
        Bitmap finalBitmap = Bitmap.createBitmap(800, 1000, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(finalBitmap);

        drawer.draw(canvas);

        image.setImageBitmap(finalBitmap);



        //取每一個底的x,y
        for (int i = 0; i < MYData.xArrayList.size(); i++) {
            Log.d("", String.valueOf(i) + "x  = " + MYData.xArrayList.get(i));
            Log.d("", String.valueOf(i) + "y = " + MYData.yArrayList.get(i));
        }

    }


}
