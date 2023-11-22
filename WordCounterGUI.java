import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class WordCounterGUI extends JFrame {
    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCounterGUI() {
        setTitle("Word Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });
        add(countButton, BorderLayout.SOUTH);

        resultLabel = new JLabel();
        add(resultLabel, BorderLayout.NORTH);

        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void countWords() {
        String text = textArea.getText().trim();


        String[] words = text.split("[\\s\\p{Punct}]+");
        Map<String, Integer> wordCount = new HashMap<>();
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "and", "is", "in", "on", "it")); // Add more stop words as needed

        int totalCount = 0;
        for (String word : words) {
            word = word.toLowerCase();
            if (!stopWords.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                totalCount++;
            }
        }

        resultLabel.setText("Total Words: " + totalCount + " | Unique Words: " + wordCount.size());

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WordCounterGUI();
            }
        });
    }
}
