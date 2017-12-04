package ecommerceapp.aps.app.mvc;

import android.graphics.Bitmap;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by levymateus on 31/10/17.
 *
 *
 */

public class FazDownload extends Model {

    private Bitmap bitmap = null;

    public FazDownload(){
        super("FazDownload");
    }

    @Override
    public void onDoRequest() {
        Log.i("FAZENDO DOWNLOAD", "...");
        onNotify();
    }

    @Override
    public ArrayList getArrayList() {
        return null;
    }

    // exemplo de um método que captura um atributo desta classe para ser usado na view por exemplo
    public Bitmap getBitmap(){
        return this.bitmap;
    }
}
