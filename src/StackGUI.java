import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class StackGUI extends JFrame implements ActionListener {
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton button1;

    private Stack<Integer> stack;

    public StackGUI() {
        stack = new Stack<>();

        setTitle("Stack GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel=new JPanel();
        panel.setLayout(new BorderLayout());

        textField1 = new JTextField();
        textField1.addActionListener(this);
        panel.add(textField1,BorderLayout.NORTH);

        textArea1 = new JTextArea();
        panel.add(new JScrollPane(textArea1),BorderLayout.CENTER);

        button1.addActionListener(e->pop());
        panel.add(button1,BorderLayout.SOUTH);

        add(panel);
    }

    private void push(int value) {
        stack.push(value);
        updateDisplay();
    }

    private void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            updateDisplay();
        } else {
            JOptionPane.showMessageDialog(this, "Pila Vacia.");
        }
    }

    private void updateDisplay() {

        textArea1.setText(stack.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = textField1.getText();
        try {
            int value = Integer.parseInt(input);
            push(value);
            textField1.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error");
        }
    }
    public static void main (String []args) {
        SwingUtilities.invokeLater(() -> {
            StackGUI gui = new StackGUI();
            gui.setVisible(true);
        });

    }


}