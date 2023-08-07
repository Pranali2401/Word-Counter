import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class WordCountGUI extends JFrame {
    private JTextArea inputTextArea;

    public WordCountGUI() {
        setTitle("Word Count Tool");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        inputTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(inputTextArea);

        JButton countButton = new JButton("Count Words");
        countButton.addActionListener(new CountButtonListener());

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(countButton, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private class CountButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = inputTextArea.getText();

            // Split the input text into an array of words
            String[] words = input.split("[\\s\\p{Punct}]+");

            // Initialize a counter to keep track of the number of words
            int wordCount = words.length;

            // Display the word count with frequency in the terminal
            System.out.println("Total word count: " + wordCount);

            // Additional feature: Count the frequency of each word
            Map<String, Integer> wordFrequency = new HashMap<>();
            for (String word : words) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }

            // Additional feature: Display word frequency in the terminal
            System.out.println("Word Frequency:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WordCountGUI wordCountGUI = new WordCountGUI();
            wordCountGUI.setVisible(true);
        });
    }
}