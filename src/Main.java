//-----------------------  Estudo calculadora usando apenas código -----------------------

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener { // cria instancia de uma janela (frame)

	JFrame frame;
	JTextField textfield; // janela de texto
	JButton[] numberButtons = new JButton[10]; // os números
	JButton addB, subB, multB, divB;
	JButton decB, equB, delB, clrB;
	JButton blank, percent;
	JPanel panel;
	

	Font fonte = new Font("Arial", Font.BOLD, 25);
	double num1 = 0, num2 = 0, resultado = 0;
	char operador;

	Main() {

		// ----------------------- Frame -----------------------

		frame = new JFrame("Calculadora"); // Titulo
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // botão de fechar, sem isso só esconde a janela
		frame.setSize(330, 430); // tamanho do frame
		frame.setResizable(false); // como o nome diz, impede de alterar o tamanho da janela
		frame.getContentPane().setLayout(null);

		// ----------------------- Icone -----------------------

		ImageIcon iconcalc = new ImageIcon("190708.png"); // cria um icon
		frame.setIconImage(iconcalc.getImage()); // muda o icon
		// frame.getContentPane().setBackground(new Color(77,192,231)); // muda cor do fundo, aqui no caso valores RGB
		
		
		// ----------------------- Label ----------------------
		
		JLabel label1 = new JLabel();
		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		label1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		label1.setBounds(21, 0, 283, 30);
		
		

		// ----------------------- Campo de texto -----------------------

		textfield = new JTextField();
		textfield.setBackground(Color.WHITE);
		textfield.setHorizontalAlignment(SwingConstants.RIGHT);
		textfield.setBounds(10, 29, 294, 30);
		textfield.setEditable(false);
		textfield.setFont(fonte);
		

		// ----------------------- Botões -----------------------
		
		
		
		// -------- Adição

		addB = new JButton("+");
		addB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				num1 = Double.parseDouble(textfield.getText());
				label1.setText(num1 + " +");
				operador = '+';
				textfield.setText("");
			}
		});
		
		// -------- Subtração
		
		subB = new JButton("-");
		subB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				num1 = Double.parseDouble(textfield.getText());
				label1.setText(num1 + " -");
				operador = '-';
				textfield.setText("");
			}
		});
		
		// -------- Multiplicação
		
		multB = new JButton("*");
		multB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				num1 = Double.parseDouble(textfield.getText());
				label1.setText(num1 + " *");
				operador = '*';
				textfield.setText("");
			}
		});
		
		// -------- Divisão
		
		divB = new JButton("/");
		divB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				num1 = Double.parseDouble(textfield.getText());
				label1.setText(num1 + " /");
				operador = '/';
				textfield.setText("");
			}
		});
		
		// -------- Decimal
		
		decB = new JButton(".");
		decB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				textfield.setText(textfield.getText().concat("."));
			}
		});
		
		// -------- Igual
		
		equB = new JButton("=");
		equB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				num2 = Double.parseDouble(textfield.getText());

				switch (operador) {
				
				case '+':
					label1.setText(num1 + " + " + num2 + " =");
					resultado = num1 + num2;
					break;
				case '-':
					label1.setText(num1 + " - " + num2 +  "=");
					resultado = num1 - num2;
					break;
				case '*':
					label1.setText(num1 + " * " + num2 + " =");
					resultado = num1 * num2;
					break;
				case '/':
					label1.setText(num1 + " / " + num2 + " =");
					resultado = num1 / num2;
					break;
				}
				
				
				num1 = resultado;
				textfield.setText(String.valueOf(resultado));

			}
		});
		
		// -------- Delete
		
		delB = new JButton("←");
		delB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String text = textfield.getText();
				textfield.setText("");
				for (int i = 0; i < text.length() - 1; i++) {
					textfield.setText(textfield.getText() + text.charAt(i));
				}
			}
		});
		
		// -------- Clear
		
		clrB = new JButton("C");
		clrB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				label1.setText("");
				textfield.setText("");
			}
		});
		
		// -------- Botão em branco para implementação futura
		
		blank = new JButton("");
		
		// -------- Porcentagem
		
		percent = new JButton("%");
		percent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				num1 = Double.parseDouble(textfield.getText());
				resultado = num1 / 100;
				textfield.setText(String.valueOf(resultado));
			}
		});


		for (int i = 0; i < 10; i++) {

			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(fonte);
		}
		
		

		// ----------------------- Panel -----------------------
		panel = new JPanel();
		panel.setBounds(10, 70, 300, 300);
		panel.setLayout(new GridLayout(5, 4, 10, 10));

		// ----------------------- Botões dentro do Panel -----------------------

		panel.add(clrB);
		panel.add(delB);
		panel.add(percent);
		panel.add(divB);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(multB);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subB);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addB);
		panel.add(blank);
		panel.add(numberButtons[0]);
		panel.add(decB);
		panel.add(equB);

		frame.getContentPane().add(panel); // chamando o panel
		frame.getContentPane().add(textfield); // chamando o campo de texto
		frame.getContentPane().add(label1);
		frame.setVisible(true); // tem que colocar a visibilidade como true, se não o frame não aparece

	}

	public static void main(String[] args) {

		Main calc = new Main();
	}

	@Override
	public void actionPerformed(ActionEvent evento) { // isso é uma função que "performa" sempre que um botão é clicado


		for (int i = 0; i < 10; i++) {
			if (evento.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}


	}

}
