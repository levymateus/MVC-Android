package ecommerceapp.aps.app.mvc;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by levymateus on 31/10/17.
 *
 */

abstract class Model {

    /**
     * Nome da classe.
     * Serve como identificador de qual serviço do model é.
     */
    private String name;

    /**
     * Referencia para o controller que chamou o model
     */
    private Controller controller;

    // construtor
    Model(String name){
        this.name = name;

    }

    public String getName(){
        return name;
    }

    final void onNotify(){
        controller.onNotify(this);
    }

    final void request(Model model, Controller ctrl){
        this.controller = ctrl;
        onDoRequest();
    }

    public abstract void onDoRequest();

    public abstract ArrayList getArrayList();

    // Retorna um atributo pelo nome
    final Field getField(String name){

        try {
            Class cls = Class.forName(this.getClass().getName());
            Field fieldList[] = cls.getDeclaredFields();

            for (int i = 0 ; i < fieldList.length; i++){
                if(fieldList[i].getName().equals(name)){
                    return fieldList[i];
                }
            }
        }catch (Throwable e){

        }

        return null;
    }

    // é possivel capturar qualquer atributo com o método getField
    public String getString(String name){
        Field f = getField(name);
        if(f != null && f.getType().equals(String.class)){
            return String.valueOf(f);
        }

        return null;
    }

}
