/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

/**
 *
 * @author Pablo Rocha
 */
public class ValorNegativoException extends Exception {
    private float valor;
    public ValorNegativoException(float valor) {
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }
    
    @Override
    public String getMessage(){
        return "Erro...valor negativo";
    }
    
    
        
}
