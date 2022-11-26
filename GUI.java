import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI extends JFrame{
    public JPanel panelMain;
    public JButton startProducerButton;
    public JTextField N_textField;
    public JTextField bufferSize_textField;
    public JTextField outputFile_textField;
    private JTextField getLargestPnum_TF;
    private JTextField getMaxnumGenerated_TF;
    private JTextField getTimeLapse_TF;
    private GUI g;


    public GUI() {
        g=this;
        N_textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bufferSize_textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        outputFile_textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        startProducerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(startProducerButton,N_textField.getText()+"=N");

                buffer buf=new buffer(getBuffer());
                producer Producer=new producer(buf,getN());
                consumer Consumer = new consumer(buf ,getN(),getFile(),g);
                //setLargestPnum(String.valueOf(Consumer.getLargest()));
                //setNumElemGenerated(Consumer.getCount());
                Producer.start();
                Consumer.start();
            }
        });

        getLargestPnum_TF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        getTimeLapse_TF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        getMaxnumGenerated_TF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public void setTimeElapsed(long num)
    {
        getTimeLapse_TF.setText(String.valueOf(num)+" ms");
    }
    public void setLargestPnum(String num)
    {
        getLargestPnum_TF.setText(num);
    }
    public void setNumElemGenerated(int num)
    {
        getMaxnumGenerated_TF.setText(String.valueOf(num));
    }
    public int getN()
    {
        return Integer.parseInt(N_textField.getText());
    }
    public int getBuffer()
    {
        return Integer.parseInt(bufferSize_textField.getText());
    }
    public String getFile()
    {
        return outputFile_textField.getText();
    }


    public static void main(String[] args) {
        GUI g = new GUI();
        g.setContentPane(g.panelMain);
        g.setTitle("calculate prime Numbers");
        g.setSize(580, 300);
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //g.outputFile_textField.setText(g.N_textField.getText());
    }
}
