import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//import java.util.*;

public class Sudoku implements ActionListener{

    JFrame frame;
    JTextField [] nums = new JTextField[81];
    //NumberFormatter formato;
    JButton submit;
    JLabel correcto;
    JPanel grilla;
    JPanel [] subgrilla = new JPanel[9];
    JPanel respuesta;
    Font nuevaFuente = new Font("Dialog", Font.BOLD, 30);
    int [] numeros;

    Sudoku(){


        //Diseño del frame
        frame = new JFrame("Sudoku");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 650);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.getHSBColor(0, 0, 25));


        //Restringe el formato de los cuadros de texto a solo numeros del 1 al 9
       /* NumberFormat auxFormato = NumberFormat.getIntegerInstance();
        formato = new NumberFormatter(auxFormato);
        formato.setValueClass(Integer.class);
        formato.setAllowsInvalid(false);
        formato.setMinimum(1);
        formato.setMaximum(9);
        formato.setCommitsOnValidEdit(true);
*/


        //Diseño de los cuadros de textos donde posteriormente irán los números de la grilla
        for (int i=0; i<81; i++){
            nums[i] = new JTextField();
            //nums[i].set
            nums[i].setFont(nuevaFuente);
            nums[i].setEditable(true);
            nums[i].setSize(2, 2);
            nums[i].setBorder(BorderFactory.createCompoundBorder());
            nums[i].setHorizontalAlignment(JTextField.CENTER);
            //nums[i].setFocusable(true);
        }



        //Grilla principal que sirve para ordenar el resto de subgrillas
        grilla = new JPanel();
        grilla.setBounds(12, 15, 380, 380);
        grilla.setLayout(new GridLayout(3, 3, 1, 1));
        grilla.setBackground(Color.black);



        
        //Subgrillas
        for (int j=0; j<9; j++){
            subgrilla[j] = new JPanel();
            if (j%2 == 0){
                subgrilla[j].setBackground(Color.black);
            }
            else {
                subgrilla[j].setBackground(Color.gray);
            }
            subgrilla[j].setLayout(new GridLayout(3,3,2,2));
            grilla.add(subgrilla[j]);
        }


        //Agrega los cuadros de texto a las subgrillas
        int j = 0;
        for (int i=0; i<9; i++){
            //subgrilla[i].add(nums[k]);
            int k = 0;
            while (k!=9){
                subgrilla[i].add(nums[j]);
                j++;
                k++;
            }
        }

        correcto = new JLabel("correcto");
        //correcto.setBounds(160, 550, 10, 3);
        correcto.setHorizontalAlignment(JLabel.CENTER);
        correcto.setVerticalAlignment(JLabel.BOTTOM);
        correcto.setBackground(Color.BLACK);
        //correcto.setFont(nuevaFuente);


        //Panel auxiliar para el boton de submit
        respuesta = new JPanel();
        respuesta.setBounds(185, 510, 50, 25);
        respuesta.setLayout(new BorderLayout());
        respuesta.add(correcto);
        respuesta.setBackground(Color.getHSBColor(0, 0, 25));
        correcto.setVisible(false);


        //Boton de submit para el momento de querer corregir
        submit = new JButton("submit");
        submit.setBounds(160, 460, 100, 25);
        submit.addActionListener(this);
        submit.setFocusable(false);
        submit.setBorder(BorderFactory.createEmptyBorder());
        submit.setBackground(new Color(39,218,92));


        frame.add(respuesta);
        frame.add(grilla);
        frame.add(submit);
        frame.setVisible(true);
       
    }


    public static void main(String[] args){
        Sudoku sud = new Sudoku();
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()==submit){
            boolean esCorrecto= true;

            //Verifica si la cantidad de dígitos ingresados por el usuario es menor a 17 o no
            int cantidadD = 0;
            for (int i=0;((i<81)); i++){
                if((nums[i].getText().length()!=0)){
                    cantidadD++;
                }
            }
            if (cantidadD>=17){  
                correcto.setVisible(true);
            }
            else {
                esCorrecto= false;
            }

            //Verifica si los dígitos ingresados cumplen con las reglas básicas del sudoku
            if (esCorrecto){
                
                NodoHash [] mapeoDigitos = new NodoHash[9];
                
                NodoHash nodo;
                String dig;
                int contadorFilas = 1;
                int contadorFilasAux = 1;
                int contadorFilasAuxiliar = 1;
                int contadorColumnas = 1;
                int contadorColumnasAux = 1;
                int contadorColumnasAuxiliar = 1;


                for (int i =0; i<81; i++){
                    
                    dig = nums[i].getText();

                    //Asigna un string a su digito correspondiente
                    switch(dig){

                        case "1":
                            nodo = new NodoHash();
                            nodo.setDigito(1);
                            nodo.setColumna(contadorColumnas);
                            break;

                        case "2":
                            nodo = new NodoHash();
                            nodo.setDigito(2);
                            break;

                        case "3":
                            nodo = new NodoHash();
                            nodo.setDigito(3);
                            break;

                        case "4":
                            nodo = new NodoHash();
                            nodo.setDigito(4);
                            break;

                        case "5":
                            nodo = new NodoHash();
                            nodo.setDigito(5);
                            break;

                        case "6":
                            nodo = new NodoHash();
                            nodo.setDigito(6);
                            break;

                        case "7":
                            nodo = new NodoHash();
                            nodo.setDigito(7);
                            break;

                        case "8":
                            nodo = new NodoHash();
                            nodo.setDigito(8);
                            break;
                        
                        case "9":
                            nodo = new NodoHash();
                            nodo.setDigito(9);
                            break;

                        default:
                            break;
                    }

                    
                }
            }
            //System.out.println(cantidadD);
        }
        //NodoHash [] ArregloPunteros = new NodoHash[9];
    }
}