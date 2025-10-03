import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void action(JTextArea output) {
        output.append(name + " eats some food 🍽\n");
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    @Override
    void action(JTextArea output) {
        output.append(name + " runs and fetches the ball 🎾\n");
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    @Override
    void action(JTextArea output) {
        output.append(name + " climbs up the tree 🌳\n");
    }
}

public class oopsconcept extends JFrame implements ActionListener {
    private JTextArea output;
    private JButton btnAnimal, btnDog, btnCat;

    public oopsconcept() {
        setTitle("OOP Demo with Actions");
        setSize(420, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(25, 20, 40));

        output = new JTextArea();
        output.setFont(new Font("Consolas", Font.BOLD, 16));
        output.setEditable(false);
        output.setBackground(new Color(40, 35, 65));
        output.setForeground(Color.WHITE);
        output.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(new JScrollPane(output), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3, 12, 12));
        panel.setBackground(new Color(25, 20, 40));

        btnAnimal = new JButton("Animal");
        btnDog = new JButton("Dog");
        btnCat = new JButton("Cat");

        styleButton(btnAnimal, new Color(138, 43, 226)); 
        styleButton(btnDog, new Color(50, 205, 50));     
        styleButton(btnCat, new Color(255, 99, 71));     

        btnAnimal.addActionListener(this);
        btnDog.addActionListener(this);
        btnCat.addActionListener(this);

        panel.add(btnAnimal);
        panel.add(btnDog);
        panel.add(btnCat);

        add(panel, BorderLayout.SOUTH);
    }

    private void styleButton(JButton btn, Color color) {
        btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btn.setFocusPainted(false);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAnimal) {
            Animal a = new Animal("Generic Animal");
            a.action(output);
        } else if (e.getSource() == btnDog) {
            Dog d = new Dog("Tommy");
            d.action(output);
        } else if (e.getSource() == btnCat) {
            Cat c = new Cat("Kitty");
            c.action(output);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            oopsconcept frame = new oopsconcept();
            frame.setVisible(true);
        });
    }
}
