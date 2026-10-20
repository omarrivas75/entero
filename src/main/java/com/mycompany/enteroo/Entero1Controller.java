
package com.mycompany.enteroo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Entero1Controller implements Initializable {

    @FXML
    private TextField txtnumero;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtImpares;

    @FXML
    private TextField txtPares;

    @FXML
    private TextField txtSuma;

    @FXML
    private TextField txtMayor;

    @FXML
    private TextField txtMenor;

    @FXML
    private TextArea txtDivisores;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void Analizar() {

        try {
            int numero = Integer.parseInt(txtnumero.getText().trim());
            String cifras = String.valueOf(numero).replace("-", "");

            int cantidad = cifras.length();
            int sumaImpares = 0;
            int sumaPares = 0;
            int sumaTotal = 0;
            int mayor = 0;
            int menor = 9;

            // Analizar cada cifra
            for (int i = 0; i < cifras.length(); i++) {

                int cifra = Character.getNumericValue(cifras.charAt(i));

                sumaTotal += cifra;

                if (cifra % 2 == 0) {
                    sumaPares += cifra;
                } else {
                    sumaImpares += cifra;
                }

                if (cifra > mayor) {
                    mayor = cifra;
                }

                if (cifra < menor) {
                    menor = cifra;
                }
            }

         
            txtCantidad.setText(String.valueOf(cantidad));
            txtImpares.setText(String.valueOf(sumaImpares));
            txtPares.setText(String.valueOf(sumaPares));
            txtSuma.setText(String.valueOf(sumaTotal));
            txtMayor.setText(String.valueOf(mayor));
            txtMenor.setText(String.valueOf(menor));

           
            txtDivisores.clear();

            if (numero == 0) {
                txtDivisores.setText(
                    "El cero tiene infinitos divisores enteros no nulos."
                );
            } else {
                long valor = Math.abs((long) numero);
                StringBuilder divisores = new StringBuilder();

                for (long i = 1; i <= valor / i; i++) {
                    if (valor % i == 0) {
                        divisores.append(i).append("\n");

                        long otroDivisor = valor / i;

                        if (otroDivisor != i) {
                            divisores.append(otroDivisor).append("\n");
                        }
                    }
                }

                txtDivisores.setText(divisores.toString());
            }

        } catch (NumberFormatException e) {
            txtDivisores.setText(
                "Error: ingresa un numero entero valido."
            );
        }
    }

    @FXML
    private void Limpiar() {

        txtnumero.clear();
        txtCantidad.clear();
        txtImpares.clear();
        txtPares.clear();
        txtSuma.clear();
        txtMayor.clear();
        txtMenor.clear();
        txtDivisores.clear();

        txtnumero.requestFocus();
    }
}
