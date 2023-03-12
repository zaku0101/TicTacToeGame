import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class TicTacToe implements ActionListener ,TIcTacInter {

    Random random=new Random();
    JFrame frame =new JFrame();
    JPanel titlePanel=new JPanel();
    JPanel buttonPanel=new JPanel();
    JLabel txtField=new JLabel();
    JButton[] buttons=new JButton[9];
    boolean player1Turn;

    TicTacToe()
{
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(600,600);
frame.getContentPane().setBackground(Color.BLACK);
frame.setLayout(new BorderLayout());
frame.setVisible(true);

txtField.setBackground(Color.WHITE);
txtField.setForeground(Color.BLACK);
txtField.setFont(new Font("Monospaced",Font.BOLD,60));
txtField.setHorizontalAlignment(JLabel.CENTER);
txtField.setText("Kółko i Krzyżyk");
txtField.setOpaque(true);

titlePanel.setLayout(new BorderLayout());
titlePanel.setBounds(0,0,800,100);

buttonPanel.setLayout(new GridLayout(3,3));
buttonPanel.setBackground(Color.GREEN);
for(int i =0;i<9;i++)
{
    buttons[i]=new JButton();
    buttonPanel.add(buttons[i]);
    buttons[i].setFont(new Font("Monospaced",Font.BOLD,150));
    buttons[i].setFocusable(false);
    buttons[i].addActionListener(this);

}
titlePanel.add(txtField);
frame.add(titlePanel,BorderLayout.NORTH);
frame.add(buttonPanel);

firstTurn();
}
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i])
            {
                if (player1Turn)
                {
                    if (buttons[i].getText() == "")
                    {
                        buttons[i].setForeground(Color.CYAN);
                        buttons[i].setText("X");
                        player1Turn = false;
                        txtField.setText("ruch O");
                        check();
                    }
                }
             else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.MAGENTA);
                        buttons[i].setText("O");
                        player1Turn = true;
                        txtField.setText("ruch X");
                        check();
                    }
                }
             }
        }

    }

    @Override
    public void firstTurn() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(random.nextInt(2)==0){
        player1Turn = true;
        txtField.setText("ruch X");

    }else
    {
        player1Turn = false;
        txtField.setText("ruch O");
    }

    }

    @Override
    public void check() {
    //check X win
        if((buttons[0].getText()=="X")&&(buttons[1].getText()=="X")&&(buttons[2].getText()=="X"))
        {
        xWins(0,1,2);
        }
        if((buttons[3].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[5].getText()=="X"))
        {
            xWins(3,4,5);
        }
        if((buttons[6].getText()=="X")&&(buttons[7].getText()=="X")&&(buttons[8].getText()=="X"))
        {
            xWins(6,7,8);
        }
        if((buttons[0].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[8].getText()=="X"))
        {
            xWins(0,4,8);
        }
        if((buttons[6].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[2].getText()=="X"))
        {
            xWins(5,4,2);
        }
        if((buttons[0].getText()=="X")&&(buttons[3].getText()=="X")&&(buttons[6].getText()=="X"))
        {
            xWins(0,3,6);
        }
        if((buttons[1].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[7].getText()=="X"))
        {
            xWins(1,4,7);
        }
        if((buttons[2].getText()=="X")&&(buttons[5].getText()=="X")&&(buttons[8].getText()=="X"))
        {
            xWins(2,5,8);
        }
        //O conditions
        if((buttons[0].getText()=="O")&&(buttons[1].getText()=="O")&&(buttons[2].getText()=="O"))
        {
            oWins(0,1,2);
        }
        if((buttons[3].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[5].getText()=="O"))
        {
            oWins(3,4,5);
        }
        if((buttons[6].getText()=="O")&&(buttons[7].getText()=="O")&&(buttons[8].getText()=="O"))
        {
            oWins(6,7,8);
        }
        if((buttons[0].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[8].getText()=="O"))
        {
            oWins(0,4,8);
        }
        if((buttons[6].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[2].getText()=="O"))
        {
            oWins(5,4,2);
        }
        if((buttons[0].getText()=="O")&&(buttons[3].getText()=="O")&&(buttons[6].getText()=="O"))
        {
            oWins(0,3,6);
        }
        if((buttons[1].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[7].getText()=="O"))
        {
            oWins(1,4,7);
        }
        if((buttons[2].getText()=="O")&&(buttons[5].getText()=="O")&&(buttons[8].getText()=="O"))
        {
            oWins(2,5,8);
        }
    }


    @Override
    public void xWins(int a, int b, int c) {
    buttons[a].setBackground(Color.GREEN);
    buttons[b].setBackground(Color.GREEN);
    buttons[c].setBackground(Color.GREEN);
    for(int i =0;i<9;i++)
    {
        buttons[i].setEnabled(false);
    }
    txtField.setText("Wygrał X");

    }

    @Override
    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i =0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }
        txtField.setText("Wygrał O");
    }


}
