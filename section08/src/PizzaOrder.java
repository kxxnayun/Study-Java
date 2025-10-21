import javax.swing.*;

public class PizzaOrder extends JFrame {

    public PizzaOrder() {
        setSize(600, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Pizza Order");

        JPanel panel = new JPanel();
        JPanel panelA = new JPanel();
        JPanel panelB = new JPanel();

        JLabel label1 = new JLabel("자바 피자에 오신 것을 환영합니다. 피자의 종류를 선택하시오.");
        panelA.add(label1);

        JButton button1 = new JButton("콤보 피자");
        JButton button2 = new JButton("포테이토 피자");
        JButton button3 = new JButton("불고기 피자");
        panelB.add(button1);
        panelB.add(button2);
        panelB.add(button3);

        JLabel label2 = new JLabel("개수: ");
        panelB.add(label2);

        JTextField field1 = new JTextField(10); // 폭 지정
        panelB.add(field1);

        panel.add(panelA);
        panel.add(panelB);
        add(panel);
        setVisible(true);
    }
}