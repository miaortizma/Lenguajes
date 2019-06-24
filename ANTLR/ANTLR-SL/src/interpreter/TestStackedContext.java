package interpreter;

import interpreter.assignables.*;
import interpreter.factories.AbstractFactory;
import interpreter.factories.DefaultFactory;
import interpreter.factories.RecordFactory;
import interpreter.factories.TensorFactory;
import interpreter.assignables.Cadena; // don't know why direct import is needed

import java.util.HashMap;
import java.util.Vector;

public class TestStackedContext {


    public static void main(String args[]) throws IllegalAccessException {


        // Cadena

        Cadena aCadena = new Cadena();


        //Pruebas de El StackedContextMap (push, pop, put, get, putReference)
        StackedContextMap table  = new StackedContextMap();
        Numeric aNumeric;
        table.put("var1", new Numeric(1));
        table.put("var2", new Numeric(2));

        table.push();

        aNumeric = (Numeric) table.get("var1");
        System.out.println(aNumeric.get());

        table.put("var3", new Numeric(3));
        aNumeric = (Numeric) table.get("var3");
        System.out.println(aNumeric.get());

        table.push();

        try {
            System.out.println(table.get("var3"));
            throw new RuntimeException();
        } catch(IllegalArgumentException e) {
            System.out.println("Catched variable shouldn't exists test");
        }

        table.putRef("var3", "var3");
        aNumeric = (Numeric) table.get("var3");
        System.out.println(aNumeric.get());

        table.put("var3", new Numeric("1e5"));

        try {
            table.putRef("var4", "var4");
            throw new RuntimeException();
        } catch(IllegalArgumentException e) {
            System.out.println("Catched variable doesn't exists in last context");
        }

        table.pop();

        aNumeric = (Numeric) table.get("var3");
        if(aNumeric.get() != (new Numeric("1e5")).get())
            throw new RuntimeException("ContextMap didn't update referenced variable");

        System.out.println(aNumeric.get());

        table.pop();

        aNumeric = (Numeric) table.get("var1");
        System.out.println(aNumeric.get());
        aNumeric = (Numeric) table.get("var2");
        System.out.println(aNumeric.get());

        try {
            System.out.println(table.get("var3"));
        } catch(IllegalArgumentException e) {
            System.out.println("Catched variable shouldn't exist");
        }

        table.putConst("hola", new Numeric());
        try {
            table.get("hola");
            table.put("hola", new Numeric());
        } catch(UnsupportedOperationException e) {
            System.out.println("Catched const test");
        }

        /**
         * Las abstract factory son para usar TIPOS  y no tener que inicializar variables.
         */

        //Ejemplo de crear un tipo de Tensor con dimensiones 2, 2, 2 y subtipo numerico
        int [] dim = {2, 2};
        TensorFactory<Numeric> tf = new TensorFactory<>(dim, Numeric.class);

        // Inicializar un tensor de tipo numerico
        Tensor<Numeric> t = tf.build();

        for(int d : t.getDim()) {
            System.out.print(d + " ");
        }
        System.out.println();
        // Tensores son 1-indexed
        int[] pos = {1, 2};
        aNumeric = t.get(pos);
        System.out.println(aNumeric.get());
        t.put(pos, new Numeric(1));
        System.out.println(t.get(pos).get());

        // Tensores abiertos
        System.out.println("Open tensors");
        int[] dim2 = {0, 0};
        TensorFactory<Numeric> tf2 = new TensorFactory<>(dim2, Numeric.class);

        Tensor<Numeric> t2 = tf2.build();
        try{
            t2.get(pos);
            throw new RuntimeException();
        } catch(UnsupportedOperationException e) {
            System.out.println("Catched open tensor get test 1");
        }

        t2.AssignIfPossible(t);

        System.out.println(t2.get(pos).get());
        t2.clear();

        try{
            t2.get(pos);
            throw new RuntimeException();
        } catch(UnsupportedOperationException e) {
            System.out.println("Catched open tensor get test 2");
        }

        try {
            TensorFactory tf3 = new TensorFactory<>(dim, Tensor.class);
            throw new RuntimeException();
        } catch(UnsupportedOperationException e) {
            System.out.println("Catched");
        }



        // Records
        // Se usa Order para poder luego usar literales estructurados (requiere tener una nocion de orden entre los atributos)

        // Simple Record
        HashMap<String, AbstractFactory> fMap = new HashMap<>();
        fMap.put("myNumeric", new DefaultFactory(Numeric.class));
        fMap.put("myTensor1", tf);
        fMap.put("myTensor2",  tf2);
        Vector<String> order = new Vector<>();
        order.add("myNumeric");
        order.add("myTensor1");
        order.add("myTensor2");
        Record aRecord = new Record(fMap, order);


        System.out.println("Basic Record");
        System.out.println(aRecord.get("myNumeric"));
        Tensor<Numeric> aTensor = (Tensor) aRecord.get("myTensor1");
        System.out.println(aTensor.get(pos).get());
        System.out.println(aRecord.get("myTensor2"));
        System.out.println();

        // From ClassMap

        HashMap<String, Class> cMap = new HashMap<>();
        cMap.put("myNumeric", Numeric.class);
        cMap.put("myCadena", Cadena.class);
        cMap.put("myLogic", Logic.class);
        order = new Vector<>();
        order.add("myNumeric");
        order.add("myCadena");
        order.add("myLogic");
        aRecord = Record.FromClasses(cMap, order);

        System.out.println("Record From Class Map");
        for(String key : aRecord.keys())
            System.out.println(aRecord.get(key));
        System.out.println();

        // if you use Record Factory you can pass plain Classes and Factories combined

        HashMap<String, Object> oMap = new HashMap<>();
        oMap.put("myNumeric", Numeric.class);
        oMap.put("myCadena", Cadena.class);
        oMap.put("myLogic", Logic.class);
        oMap.put("myTensor", tf);
        order.add("myTensor");

        RecordFactory rf = new RecordFactory(oMap, order);


        aRecord = rf.build();


        System.out.println("Record Factory");
        for(String key : aRecord.keys())
            System.out.println(aRecord.get(key));
        System.out.println();


        // Record with Record inside

        oMap.put("myRecord", rf);
        rf.build();
        order.add("myRecord");
        rf.build();
        rf.build();
        rf = new RecordFactory(oMap, order);

        aRecord = rf.build();

        System.out.println("Record Recursion");
        for(String key : aRecord.keys())
            System.out.println(aRecord.get(key));
        System.out.println();

    }
}
