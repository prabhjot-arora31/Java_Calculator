import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame {
    UI(String s) {
        // JTextField textField = new JTextField();
        setVisible(true);
        setLayout(new GridLayout(5, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setResizable(false);
        JTextField textField = new JTextField(20);
        textField.setFont(getFont().deriveFont(55.5f));
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        String[] buttonNames = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };
        for (String btnText : buttonNames) {
            JButton button = new JButton(btnText);
            button.setFont(getFont().deriveFont(55.5f));
            System.out.println(button.getText().toString());
            if (button.getText().toString().equals("7") || button.getText().toString().equals("8")
                    || button.getText().toString().equals("9") || button.getText().toString().equals("/")) {
                System.out.println("Added");
                panel1.add(button);
            } else if (button.getText().toString().equals("4") || button.getText().toString().equals("5")
                    || button.getText().toString().equals("6") || button.getText().toString().equals("*")) {
                panel2.add(button);
            } else if (button.getText().toString().equals("1") || button.getText().toString().equals("2")
                    || button.getText().toString().equals("3") || button.getText().toString().equals("-")) {
                panel3.add(button);
            } else if (button.getText().toString().equals(".") || button.getText().toString().equals("0")
                    || button.getText().toString().equals("=") || button.getText().toString().equals("+")) {
                panel4.add(button);
            }
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    if (!button.getText().toString().equals("="))
                        textField.setText(textField.getText() + btnText);
                    if (button.getText().toString().equals("=")) {
                        ScriptEngineManager manager = new ScriptEngineManager();
                        ScriptEngine engine = manager.getEngineByName("js");
                        try {
                            Object res = engine.eval(textField.getText().toString());
                            System.out.println(res.toString());
                            textField.setText(res.toString());
                        } catch (Exception e) {
                            // TODO: handle exception
                            System.out.println("Exception: " + e.getMessage());
                        }
                    }
                }
            });
        }
        System.out.println(textField.toString());
        // JButton btn1 = new JButton("1");
        // JButton btn2 = new JButton("2");
        // JButton btn3 = new JButton("3");
        // JButton btn4 = new JButton("4");
        // JButton btn5 = new JButton("5");
        // JButton btn6 = new JButton("6");
        // JButton btn7 = new JButton("7");
        // JButton btn8 = new JButton("8");
        // JButton btn9 = new JButton("9");
        // JButton btn0 = new JButton("0");

        panel1.setLayout(new GridLayout(1, 4));
        panel2.setLayout(new GridLayout(1, 4));
        panel3.setLayout(new GridLayout(1, 4));
        panel4.setLayout(new GridLayout(1, 4));
        // panel1.add(btn1);
        // panel1.add(btn2);
        // panel1.add(btn3);
        // panel2.add(btn4);
        // panel2.add(btn5);
        // panel2.add(btn6);
        // panel3.add(btn7);
        // panel3.add(btn8);
        // panel3.add(btn9);
        add(textField);
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
    }
}
