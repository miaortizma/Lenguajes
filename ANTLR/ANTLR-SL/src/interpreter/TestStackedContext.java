package interpreter;

public class TestStackedContext {


    public static void main(String args[]) throws IllegalAccessException {
        StackedContextMap table  = new StackedContextMap();
        table.put("var1", 1);
        table.put("var2", 2);
        Double a = Double.parseDouble("1e-5");
        System.out.println(a);
        table.push();
        a = (Double) table.get("var1");
        System.out.println(table.get("var1"));
        table.put("var3", 3);
        System.out.println(table.get("var3"));

        table.push();
        try {
            System.out.println(table.get("var3"));
        } catch(IllegalArgumentException e) {
            System.out.println("catched");
        }
        table.putRef("var3");
        System.out.println(table.get("var3"));
        try {
            table.putRef("var4");
        } catch(IllegalArgumentException e) {
            System.out.println("catched");
        }

        table.pop();

        table.pop();

        System.out.println(table.get("var1"));
        System.out.println(table.get("var2"));
        try {
            System.out.println(table.get("var3"));
        } catch(IllegalArgumentException e) {
            System.out.println("catched");
        }

    }
}
