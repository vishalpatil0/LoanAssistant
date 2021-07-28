import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class LoanAssistant extends JFrame {

        //Declarations

        JLabel balanceLabel = new JLabel();
        JTextField balanceTextField = new JTextField();
        JLabel interestLabel = new JLabel();
        JTextField interestTextField = new JTextField();
        JLabel monthsLabel = new JLabel();
        JTextField monthsTextField = new JTextField();
        JLabel paymentLabel = new JLabel();
        JTextField paymentTextField = new JTextField();
        Font myFont = new Font("Arial", Font.PLAIN, 16);
    
        //butons 
        JButton computeButton = new JButton();
        JButton newLoanButton = new JButton();
        JButton monthsButton = new JButton();
        JButton paymentButton = new JButton();
        JLabel analysisLabel = new JLabel();
        JTextArea analysisTextArea = new JTextArea();
        JButton exitButton = new JButton();

        
        Color lightYellow = new Color(255, 255, 128);
        boolean computePayment;
    public static void main(String[] args) {
        //creating frame
       new LoanAssistant().setVisible(true);
    }
     
    private void computeButtonActionPerformed(ActionEvent e)
    {
        double balance, interest, payment;
        int months;
        double monthlyInterest, multiplier;
        balance = Double.valueOf(balanceTextField.getText()).doubleValue();
        interest = Double.valueOf(interestTextField.getText()).doubleValue();
        monthlyInterest = interest / 1200;
        if(computePayment)
        {
        // Compute loan payment
        months = Integer.valueOf(monthsTextField.getText()).intValue();
        multiplier = Math.pow(1 + monthlyInterest, months);
        payment = balance * monthlyInterest * multiplier / (multiplier - 1);
        paymentTextField.setText(new DecimalFormat("0.00").format(payment));
        }
        else
        {
            // Compute number of payments
        payment = Double.valueOf(paymentTextField.getText()).doubleValue();
        months = (int)((Math.log(payment) - Math.log(payment - balance * monthlyInterest))
        / Math.log(1 + monthlyInterest));
        monthsTextField.setText(String.valueOf(months));
        }
    }

    private void newLoanButtonActionPerformed(ActionEvent e)
    {
    }

    private void monthsButtonActionPerformed(ActionEvent e)
    {
        // will compute months
        computePayment = false;
        paymentButton.setVisible(true);
        monthsButton.setVisible(false);
        monthsTextField.setText("");
        monthsTextField.setEditable(false);
        monthsTextField.setEditable(false);
        monthsTextField.setBackground(lightYellow);
        paymentTextField.setEditable(true);
        paymentTextField.setBackground(Color.WHITE);
        paymentTextField.setFocusable(true);
        computeButton.setText("Compute Number of Payments");
        balanceTextField.requestFocus();
    }

    private void paymentButtonActionPerformed(ActionEvent e)
    {
        // will compute payment
        computePayment = true;
        paymentButton.setVisible(false);
        monthsButton.setVisible(true);
        monthsTextField.setEditable(true);
        monthsTextField.setBackground(Color.WHITE);
        monthsTextField.setFocusable(true);
        paymentTextField.setText("");
        paymentTextField.setEditable(false);
        paymentTextField.setBackground(lightYellow);
        paymentTextField.setFocusable(false);
        computeButton.setText("Compute Monthly Payment");
        balanceTextField.requestFocus();
    }
    
    private void exitButtonActionPerformed(ActionEvent e)
    {
        System.exit(0);
    }
    public LoanAssistant(){
        //frame constructor
        setTitle("Loan Assistant");
        setResizable(false);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                exitForm(evt);
            }
        });
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints;

        balanceLabel.setText("Loan Balance");
        balanceLabel.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(10, 10, 0, 0);
        getContentPane().add(balanceLabel, gridConstraints);

        balanceTextField.setPreferredSize(new Dimension(100, 25));
        balanceTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        balanceTextField.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        getContentPane().add(balanceTextField, gridConstraints);

        interestLabel.setText("Interest Rate");
        interestLabel.setFont(myFont);
        gridConstraints=new GridBagConstraints();
        gridConstraints.gridx=0;
        gridConstraints.gridy=1;
        gridConstraints.anchor= GridBagConstraints.WEST;
        gridConstraints.insets =new Insets(10,10,0,0);
        getContentPane().add(interestLabel,gridConstraints);

        interestTextField.setPreferredSize(new Dimension(100,25));
        interestTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        interestTextField.setFont(myFont);
        gridConstraints =new GridBagConstraints();
        gridConstraints.gridx=1;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(10,10,0,10);
        getContentPane().add(interestTextField,gridConstraints);

        monthsLabel.setText("Number of Payments");
        monthsLabel.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(10, 10, 0, 0);
        getContentPane().add(monthsLabel,gridConstraints);

        monthsTextField.setPreferredSize(new Dimension(100, 25));
        monthsTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        monthsTextField.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        getContentPane().add(monthsTextField, gridConstraints);
    
        paymentLabel.setText("Monthly Payment");
        paymentLabel.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(10, 10, 0, 0);
        getContentPane().add(paymentLabel, gridConstraints);
    
        paymentTextField.setPreferredSize(new Dimension(100, 25));
        paymentTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        paymentTextField.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 3;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        getContentPane().add(paymentTextField, gridConstraints);

        computeButton.setText("Compute Monthly Payment");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 4;
        gridConstraints.gridwidth = 2;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        getContentPane().add(computeButton, gridConstraints);
        computeButton.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e)
        {
        computeButtonActionPerformed(e);
        }
        });
        newLoanButton.setText("New Loan Analysis");
        newLoanButton.setEnabled(false);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 5;
        gridConstraints.gridwidth = 2;
        gridConstraints.insets = new Insets(10, 0, 10, 0);
        getContentPane().add(newLoanButton, gridConstraints);
        newLoanButton.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e)
        {
        newLoanButtonActionPerformed(e);
        }
        });   

        monthsButton.setText("X");
        monthsButton.setFocusable(false);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 2;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        getContentPane().add(monthsButton, gridConstraints);
        monthsButton.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e)
        {
        monthsButtonActionPerformed(e);
        }
        });
        paymentButton.setText("X");
        paymentButton.setFocusable(false);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 3;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        getContentPane().add(paymentButton, gridConstraints);
        paymentButton.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e)
        {
        paymentButtonActionPerformed(e);
        }
        });

        analysisLabel.setText("Loan Analysis:");
        analysisLabel.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 0;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(0, 10, 0, 0);
        getContentPane().add(analysisLabel, gridConstraints);
        analysisTextArea.setPreferredSize(new Dimension(250, 150));
        analysisTextArea.setFocusable(false);
        analysisTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        analysisTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        analysisTextArea.setEditable(false);
        analysisTextArea.setBackground(Color.WHITE);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 1;
        gridConstraints.gridheight = 4;
        gridConstraints.insets = new Insets(0, 10, 0, 10);
        getContentPane().add(analysisTextArea, gridConstraints);

        exitButton.setText("Exit");
        exitButton.setFocusable(false);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 5;
        getContentPane().add(exitButton, gridConstraints);
        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            exitButtonActionPerformed(e);
            }
            });
        pack();

        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int)(0.5 * (screenSize.width - getWidth())),(int)(0.5*(screenSize.height-getHeight())),getWidth(),getHeight());
        
       
        paymentButton.doClick();
        
    }
    private void exitForm(WindowEvent evt)
    {
        System.exit(0);
    }
}