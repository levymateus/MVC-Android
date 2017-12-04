package ecommerceapp.aps.app.mvc;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by levymateus on 31/10/17.
 *
 *
 */

public abstract class Controller extends AppCompatActivity {

    private ViewInterface mView;

    // construtor
    public Controller(ViewInterface view) {
        this.mView = view;
    }

    // acao da mView
    public abstract void onViewAction(android.view.View view);

    // atualizar mView
    public final void onUpdate(Model model){
        mView.update(model);
    }

    // requisitar para model
    public final void onRequest(Model model){
        model.request(model, this);
    }

    // notificacao do model
    public final void onNotify(Model model){
        onNotifyController(model);
    }

    // chamada ao notificar o controller
    public abstract void onNotifyController(Model model);
}
