package ecommerceapp.aps.app.mvc;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewInterface {

    TextView txtView;

    private ViewInterface mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mView = this;

        Button btn = (Button) findViewById(R.id.button);
        txtView = (TextView) findViewById(R.id.textView);
        btn.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View view) {
                        Controller meuController = new MeuController(mView);
                        meuController.onViewAction(view);
                    }
                }
        );

        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View view) {
                        Controller meuController = new MeuController(mView);
                        meuController.onViewAction(view);
                    }
                }
        );

    }


    @Override
    public void update(Model model) {

        if(model.getName().equals("CarregaItems")){
            Log.i("UpdateView", model.getName());
            List list = model.getArrayList();
            String s = (String) list.get(0);
            txtView.setText(s);
        }

        if(model.getName().equals("FazDownload")){
            Log.i("UpdateView", model.getName());
            FazDownload fd = (FazDownload) model;
            Bitmap b = fd.getBitmap();
        }

    }
}
