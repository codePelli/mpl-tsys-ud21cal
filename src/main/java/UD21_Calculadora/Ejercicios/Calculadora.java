package UD21_Calculadora.Ejercicios;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Calculadora extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    
    private JLabel lblResultado;
    JButton[] operadores = new JButton[7];
    JButton[] numeros = new JButton[10];
    double resultado = 0.0;
    public String operadorActual = "";
    boolean nuevaEntrada = true;
    public double numeroActual = 0;

    public Calculadora() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 337, 355);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btn7 = new JButton("7");
        btn7.setBackground(Color.BLUE);
        btn7.setForeground(Color.WHITE);
        btn7.setBounds(10, 82, 53, 47);
        contentPane.add(btn7);
        
        JButton btn8 = new JButton("8");
        btn8.setBackground(Color.BLUE);
        btn8.setForeground(Color.WHITE);
        btn8.setBounds(73, 82, 53, 47);
        contentPane.add(btn8);
        
        JButton btn9 = new JButton("9");
        btn9.setBackground(Color.BLUE);
        btn9.setForeground(Color.WHITE);
        btn9.setBounds(136, 82, 53, 47);
        contentPane.add(btn9);
        
        JButton btn4 = new JButton("4");
        btn4.setBackground(Color.BLUE);
        btn4.setForeground(Color.WHITE);
        btn4.setBounds(10, 140, 53, 47);
        contentPane.add(btn4);
        
        JButton btn5 = new JButton("5");
        btn5.setBackground(Color.BLUE);
        btn5.setForeground(Color.WHITE);
        btn5.setBounds(73, 140, 53, 47);
        contentPane.add(btn5);
        
        JButton btn6 = new JButton("6");
        btn6.setBackground(Color.BLUE);
        btn6.setForeground(Color.WHITE);
        btn6.setBounds(136, 140, 53, 47);
        contentPane.add(btn6);
        
        JButton btn1 = new JButton("1");
        btn1.setBackground(Color.BLUE);
        btn1.setForeground(Color.WHITE);
        btn1.setBounds(10, 198, 53, 47);
        contentPane.add(btn1);
        
        JButton btn2 = new JButton("2");
        btn2.setBackground(Color.BLUE);
        btn2.setForeground(Color.WHITE);
        btn2.setBounds(73, 198, 53, 47);
        contentPane.add(btn2);
        
        JButton btn3 = new JButton("3");
        btn3.setBackground(Color.BLUE);
        btn3.setForeground(Color.WHITE);
        btn3.setBounds(136, 198, 53, 47);
        contentPane.add(btn3);
        
        JButton btnMenos = new JButton("-");
        btnMenos.setBackground(Color.ORANGE);
        btnMenos.setBounds(258, 198, 53, 47);
        contentPane.add(btnMenos);
        
        JButton btnDel = new JButton("<-");
        btnDel.setBackground(Color.RED);
        btnDel.setBounds(258, 82, 53, 47);
        contentPane.add(btnDel);
        
        JButton btnPosNeg = new JButton("-/+");
        btnPosNeg.setBackground(Color.MAGENTA);
        btnPosNeg.setBounds(10, 256, 53, 47);
        contentPane.add(btnPosNeg);
        
        JButton btn0 = new JButton("0");
        btn0.setBackground(Color.BLUE);
        btn0.setForeground(Color.WHITE);
        btn0.setBounds(73, 256, 53, 47);
        contentPane.add(btn0);
        
        JButton btnComa = new JButton(",");
        btnComa.setBackground(Color.MAGENTA);
        btnComa.setBounds(136, 256, 53, 47);
        contentPane.add(btnComa);
        
        JButton btnMas = new JButton("+");
        btnMas.setBackground(Color.ORANGE);
        btnMas.setBounds(258, 140, 53, 47);
        contentPane.add(btnMas);
        
        JButton btnMult = new JButton("*");
        btnMult.setBackground(Color.ORANGE);
        btnMult.setBounds(199, 140, 53, 47);
        contentPane.add(btnMult);
        
        JButton btnDiv = new JButton("/");
        btnDiv.setBackground(Color.ORANGE);
        btnDiv.setBounds(199, 198, 53, 47);
        contentPane.add(btnDiv);
        setTitle("Calculadora");
        
        JButton btnResult = new JButton("=");
        btnResult.setBackground(Color.ORANGE);
        btnResult.setBounds(199, 256, 112, 47);
        contentPane.add(btnResult);
        
        JButton btnC = new JButton("c");
        btnC.setBackground(Color.RED);
        btnC.setBounds(199, 82, 53, 47);
        contentPane.add(btnC);
        
        lblResultado = new JLabel("0");
        lblResultado.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        lblResultado.setForeground(Color.RED);
        lblResultado.setBounds(10, 11, 301, 60);
        contentPane.add(lblResultado);
        
        operadores[0] = btnMas;
        operadores[1] = btnMult;
        operadores[2] = btnDiv;
        operadores[3] = btnMenos;
        operadores[4] = btnDel;
        operadores[5] = btnPosNeg;
        operadores[6] = btnResult;
        
        numeros[0] = btn0;
        numeros[1] = btn1;
        numeros[2] = btn2;
        numeros[3] = btn3;
        numeros[4] = btn4;
        numeros[5] = btn5;
        numeros[6] = btn6;
        numeros[7] = btn7;
        numeros[8] = btn8;
        numeros[9] = btn9;
        
        for (int x = 0; x < 7; x++) {
        	
            operadores[x].addActionListener(new ActionListener() {
            	
                public void actionPerformed(ActionEvent e) {
                	
                    JButton pulsado = (JButton) e.getSource();
                    String operador = pulsado.getText();
                    
                    if (operador != ",") {

                    	if (!operadorActual.isEmpty() && !nuevaEntrada && operador != ",") {
                    	
                    		calcular();
                    		actualizarLabel();
                        
                    	} else {
                    	
                    		numeroActual = Double.parseDouble(lblResultado.getText());
                    	}
                               
                    	operadorActual = operador;
                    	nuevaEntrada = true;
                    }
                }
            });
        }
        
        for (int x = 0; x < 10; x++) {
        	
            numeros[x].addActionListener(new ActionListener() {
            	
                public void actionPerformed(ActionEvent e) {
                	
                    JButton pulsadon = (JButton) e.getSource();
                    String numero = pulsadon.getText();
                    
                    if (nuevaEntrada) {
                    	
                        lblResultado.setText(numero);
                        nuevaEntrada = false;
                        
                    } else {
                    	
                        lblResultado.setText(lblResultado.getText() + numero);
                    }
                }
            });
        }
        
        btnResult.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
            	
                calcular();
                operadorActual = "";
                nuevaEntrada = true;
                actualizarLabel();
            }
        });
        
        btnC.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
            	
                resultado = 0.0;
                operadorActual = "";
                nuevaEntrada = true;
                actualizarLabel();
            }
        });
        
        btnPosNeg.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
            	
                if (!lblResultado.getText().equals("0")) {
                	
                    double numero = Double.parseDouble(lblResultado.getText());
                    
                    numero = -numero;
                    
                    lblResultado.setText(Double.toString(numero));
                }
            }
        });
        
        btnComa.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
            	
                if (!lblResultado.getText().contains(".")) {
                    lblResultado.setText(lblResultado.getText() + ".");
                }
            }
        });
        
        btnDel.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
            	
                String actual = lblResultado.getText();
                
                if (actual.length() > 1) {
                	
                    actual = actual.substring(0, actual.length() - 1);
                } else {

                    actual = "0";
                    nuevaEntrada = true;
                }
                lblResultado.setText(actual);
            }
        });



    }
    
    void calcular() {
    	
        double numero = Double.parseDouble(lblResultado.getText());
        
        if (operadorActual.equals("+")) {
        	
            resultado = numeroActual + numero;
            
        } else if (operadorActual.equals("-")) {
        	
            resultado = numeroActual - numero;
            
        } else if (operadorActual.equals("*")) {
        	
            resultado = numeroActual * numero;
            
        } else if (operadorActual.equals("/")) {
        	
            if (numero != 0) {
            	
                resultado = numeroActual / numero;
                
            } else {
            	
                resultado = 0;
            }
        }
        

    }
    
    void actualizarLabel() {
    	
        lblResultado.setText(resultado + "");
    }
    
    void setOperador(String operador) {
    	
    	operadorActual = operador;
    }
    
    double getResultado() {
    	
    	return resultado;
    }
    
    

}
