package ecommerceapp.aps.app.mvc;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by levymateus on 31/10/17.
 *
 *
 */

public class CarregaItems extends Model {

    List<String> items;

    public CarregaItems(){
        super("CarregaItems");
        this.items = new ArrayList<>();
    }

    // chamada
    @Override
    public void onDoRequest() {
        // fazer o que é necessário
        items.add("item 1");
        onNotify();
    }

    @Override
    public ArrayList getArrayList() {
        return (ArrayList) items;
    }

}
