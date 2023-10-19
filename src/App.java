import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // ScriptEngineManager manager = new ScriptEngineManager();
        // ScriptEngine engine = manager.getEngineByName("js");
        // Object res = engine.eval("2*3");
        // System.out.println(res.toString());
        new UI("Calculator");
    }
}
