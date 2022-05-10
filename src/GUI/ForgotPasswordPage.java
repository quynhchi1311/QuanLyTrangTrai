package GUI;

import JavaMail.JavaMailUtil;
import JavaMail.RandomStringGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotPasswordPage {
    private JPanel forgotPasswordPanel;
    private JTextField txtFEmail;
    private JButton btnCode;
    private JTextField txtFCode;
    private JButton btnContinue;
    private JTextField textFUserName;
    private JTextField textFNewPassword;
    private JPasswordField txtFRetype;
    private JPanel getCodePanel;
    private JPanel setNewPasswordPanel;
    private JButton btnUpdate;


    private static JFrame frame = new JFrame("ForgotPasswordPage");
    private static String code;


    public ForgotPasswordPage() {
        int counter = 1;
        btnContinue.setEnabled(false);

        btnCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mail = txtFEmail.getText();
                RandomStringGenerator rand = new RandomStringGenerator();
                code = rand.randomAlphaNumeric(8);

                JavaMailUtil.sendMail(mail, code);
                JOptionPane.showMessageDialog(null, "Email sent");
                btnContinue.setEnabled(true);
            }
        });


        btnContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (code.equals(txtFCode.getText())) {
                    forgotPasswordPanel.removeAll();
                    forgotPasswordPanel.add(setNewPasswordPanel);
                    forgotPasswordPanel.repaint();
                    forgotPasswordPanel.revalidate();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Code nhap sai, vui long chon gui ma lai");
                }
            }
        });
    }


    public void display() {
        frame.setContentPane((new ForgotPasswordPage().forgotPasswordPanel));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
