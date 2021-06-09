import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//import java.util.*;

public class Sudoku implements ActionListener {

    JFrame frame;
    JTextField[][] nums = new JTextField[9][9];
    // NumberFormatter formato;
    JButton submit;
    JLabel correcto;
    JPanel grilla;
    JPanel[][] subgrilla = new JPanel[3][3];
    JPanel respuesta;
    Font nuevaFuente = new Font("Dialog", Font.BOLD, 30);
    int[] numeros;

    Sudoku() {

        // Diseño del frame
        frame = new JFrame("Sudoku");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 650);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.getHSBColor(0, 0, 25));

        // Restringe el formato de los cuadros de texto a solo numeros del 1 al 9
        /*
         * NumberFormat auxFormato = NumberFormat.getIntegerInstance(); formato = new
         * NumberFormatter(auxFormato); formato.setValueClass(Integer.class);
         * formato.setAllowsInvalid(false); formato.setMinimum(1);
         * formato.setMaximum(9); formato.setCommitsOnValidEdit(true);
         */

        // Diseño de los cuadros de textos donde posteriormente irán los números de la
        // grilla
        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                nums[i][j] = new JTextField();
                nums[i][j].setFont(nuevaFuente);
                nums[i][j].setEditable(true);
                nums[i][j].setSize(2, 2);
                nums[i][j].setBorder(BorderFactory.createCompoundBorder());
                nums[i][j].setHorizontalAlignment(JTextField.CENTER);

            }

        }

        // Grilla principal que sirve para ordenar el resto de subgrillas
        grilla = new JPanel();
        grilla.setBounds(12, 15, 380, 380);
        grilla.setLayout(new GridLayout(3, 3, 1, 1));
        grilla.setBackground(Color.black);

        // Subgrillas
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                subgrilla[i][j] = new JPanel();
                if ((i % 2 == 0) && (j % 2 == 0)) {
                    subgrilla[i][j].setBackground(Color.black);
                } else {
                    subgrilla[i][j].setBackground(Color.gray);
                }
                subgrilla[i][j].setLayout(new GridLayout(3, 3, 2, 2));
                grilla.add(subgrilla[i][j]);
            }
        }

        // Agrega los cuadros de texto a las subgrillas
        for (int l = 0; l < 3; l++) {

            for (int k = 0; k < 3; k++) {

                for (int i = 3 * l; i < 3 * l + 3; i++) {

                    for (int j = 3 * k; j < 3 * k + 3; j++) {
                        subgrilla[l][k].add(nums[i][j]);
                    }
                }

            }

        }

        correcto = new JLabel("correcto");
        // correcto.setBounds(160, 550, 10, 3);
        correcto.setHorizontalAlignment(JLabel.CENTER);
        correcto.setVerticalAlignment(JLabel.BOTTOM);
        correcto.setBackground(Color.BLACK);
        // correcto.setFont(nuevaFuente);

        // Panel auxiliar para el boton de submit
        respuesta = new JPanel();
        respuesta.setBounds(185, 510, 50, 25);
        respuesta.setLayout(new BorderLayout());
        respuesta.add(correcto);
        respuesta.setBackground(Color.getHSBColor(0, 0, 25));
        correcto.setVisible(false);

        // Boton de submit para el momento de querer corregir
        submit = new JButton("submit");
        submit.setBounds(160, 460, 100, 25);
        submit.addActionListener(this);
        submit.setFocusable(false);
        submit.setBorder(BorderFactory.createEmptyBorder());
        submit.setBackground(new Color(39, 218, 92));

        frame.add(respuesta);
        frame.add(grilla);
        frame.add(submit);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Sudoku sud = new Sudoku();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            boolean esCorrecto = true;

            // Verifica si la cantidad de dígitos ingresados por el usuario es menor a 17 o
            // no
            int cantidadD = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if ((nums[i][j].getText().length() != 0)) {
                        cantidadD++;
                    }
                }
            }
            if (cantidadD >= 17) {
                correcto.setVisible(true);
            } else {
                // esCorrecto= false;
            }

            // Verifica si los dígitos ingresados cumplen con las reglas básicas del sudoku
            if (esCorrecto) {

                NodoHash[] mapeoDigitos = new NodoHash[9];

                NodoHash nodo;
                String dig;

                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        dig = nums[i][j].getText();

                        // Asigna un string a su digito correspondiente
                        switch (dig) {

                            case "1":
                                nodo = new NodoHash();
                                nodo.setDigito(1);
                                nodo.setColumna(j);
                                nodo.setFila(i);
                                nodo.asignarSub();
                                break;

                            case "2":
                                nodo = new NodoHash();
                                nodo.setDigito(2);
                                nodo.setColumna(j);
                                nodo.setFila(i);
                                nodo.asignarSub();
                                break;

                            case "3":
                                nodo = new NodoHash();
                                nodo.setDigito(3);
                                nodo.setColumna(j);
                                nodo.setFila(i);
                                nodo.asignarSub();
                                break;

                            case "4":
                                nodo = new NodoHash();
                                nodo.setDigito(4);
                                nodo.setColumna(j);
                                nodo.setFila(i);
                                nodo.asignarSub();
                                break;

                            case "5":
                                nodo = new NodoHash();
                                nodo.setDigito(5);
                                nodo.setColumna(j);
                                nodo.setFila(i);
                                nodo.asignarSub();
                                break;

                            case "6":
                                nodo = new NodoHash();
                                nodo.setDigito(6);
                                nodo.setColumna(j);
                                nodo.setFila(i);
                                nodo.asignarSub();
                                break;

                            case "7":
                                nodo = new NodoHash();
                                nodo.setDigito(7);
                                nodo.setColumna(j);
                                nodo.setFila(i);
                                nodo.asignarSub();
                                break;

                            case "8":
                                nodo = new NodoHash();
                                nodo.setDigito(8);
                                nodo.setColumna(j);
                                nodo.setFila(i);
                                nodo.asignarSub();
                                break;

                            case "9":
                                nodo = new NodoHash();
                                nodo.setDigito(9);
                                nodo.setColumna(j);
                                nodo.setFila(i);
                                nodo.asignarSub();
                                break;

                            default:
                                break;
                        }
                    }

                }
            }
        }
    }
}