import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This application accepts one string and
 *  depends of length of word do ascending order
 * @author Mahmut under
 *
 *
 * */
public class Main extends JFrame implements ActionListener , MouseListener {

    private JTextField words;
    private JButton checkWord;
    private JPanel  panel;
    private JLabel showResult;
    private JPanel  panelShow;
    private WordsCheck checkWords;

    public Main(){


        buildPanel();
        buildPanelShow();

        checkWords = new WordsCheck();
        add(panel, BorderLayout.NORTH);
        add(panelShow,BorderLayout.CENTER);

        setTitle("Check Word");
        setDefaultCloseOperation(3);
        setSize(600,300);
        setLocationRelativeTo(null);
        setVisible(true);




    }

    private void buildPanelShow() {
        showResult= new JLabel();

        showResult.setFont(new Font(Font.MONOSPACED,Font.BOLD,25));
        panelShow= new JPanel();

        panelShow.add(showResult);
    }

    private void buildPanel() {

        panel=new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(25,20,25,15));
        words= new JTextField(25);
        words.setFont(new Font(Font.SANS_SERIF,Font.TRUETYPE_FONT,15));
        words.setBorder(BorderFactory.createTitledBorder("Enter words"));


        checkWord= new JButton("Check it");
        checkWord.setPreferredSize(new Dimension(150,50));
        checkWord.setBorder(BorderFactory.createEtchedBorder());
        checkWord.addMouseListener(this);
        checkWord.setFocusable(false);
        checkWord.setBackground(Color.red);
        checkWord.setForeground(Color.white);

        checkWord.addActionListener(this);
        panel.add(words);
        panel.add(checkWord);
    }

    // ----------------- button -----------------

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==checkWord){

            checkWords.setWords(words.getText());
            showResult.setText(checkWords.checkWords());

        }


    }

    //----------- mouse----------------

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        checkWord.setBackground(Color.gray);
        checkWord.setForeground(Color.black);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        checkWord.setBackground(Color.red);
        checkWord.setForeground(Color.WHITE);
    }

    public static void main(String[] args) {
        new Main();
    }
}