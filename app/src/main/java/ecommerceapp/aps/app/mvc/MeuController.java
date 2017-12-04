package ecommerceapp.aps.app.mvc;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by levymateus on 31/10/17.
 *
 */

public class MeuController extends Controller {

    public MeuController(ViewInterface view){
        super(view);
    }

    @Override
    public void onViewAction(android.view.View view) {
        if(view.getId() == R.id.button){
            CarregaItems meuModel = (CarregaItems) new CarregaItems();
            onRequest(meuModel);
        }

        if(view.getId() == R.id.button2){
            FazDownload meuDownload = (FazDownload) new FazDownload();
            onRequest(meuDownload);
        }

    }

    @Override
    public void onNotifyController(Model model) {
        onUpdate(model);
    }
}
