
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author alexandrezamberlan
 * @author sylviovieira
 * @author anajulia
 * @author carlosbau
 */
public class Util {

    public static File carregarArquivo() {
        JFileChooser janelaCarregarArquivo = new JFileChooser();
        janelaCarregarArquivo.setMultiSelectionEnabled(false);
        if (janelaCarregarArquivo.showOpenDialog(janelaCarregarArquivo) == JFileChooser.APPROVE_OPTION) {
            return janelaCarregarArquivo.getSelectedFile();
        }
        return null;
    }

    public static void ordenarListaPente(ArrayList lista) {
        boolean houveTroca;
        int i, distancia = lista.size();
        int tmp;

        do {
            houveTroca = false;
            distancia = (int) (distancia / 1.3);

            if (distancia < 1) {
                distancia = 1;
            }
            for (i = 0; i + distancia < lista.size(); i++) {
                if ((int) (lista.get(i)) > (int) (lista.get(i + distancia))) {
                    houveTroca = true;
                    tmp = (int) lista.get(i);
                    lista.set(i, lista.get(i + distancia));
                    lista.set(i + distancia, tmp);
                }
            }
        } while (distancia > 1 || houveTroca == true);
    }

    public static void descobrirFrequencia(ArrayList listaOrigem, ArrayList<Glicemia> listaDestino) {
        int tmp;
        boolean achou;
        
        if (!listaOrigem.isEmpty()) 
            listaDestino.add( new Glicemia((int)listaOrigem.get(0)) );
        
        for (int i = 1; i < listaOrigem.size(); i++) {
            tmp = (int)listaOrigem.get(i);
            achou = false;
            for (int j = 0; j < listaDestino.size(); j++) {
                if (tmp == listaDestino.get(j).valor) {
                    listaDestino.get(j).ocorrencia++;
                    achou = true;
                }
            }
            if (!achou) listaDestino.add( new Glicemia(tmp) );
        }
    }
    
    public static double calcularMedia(ArrayList lista) {
        double soma = 0;
        if (lista.isEmpty()) return 0;
        for (int i = 0; i < lista.size(); i++) {
            soma = soma + (int)lista.get(i);
        }
        return soma / lista.size();
    }
    
    public static String descobrirModa(ArrayList<Glicemia> lista) {
        Glicemia maiorFrequencia;
                
        if (lista.isEmpty()) return "";
        
        maiorFrequencia = lista.get(0);
        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i).ocorrencia > maiorFrequencia.ocorrencia)
                maiorFrequencia = lista.get(i);
        }
        if (maiorFrequencia.ocorrencia == 1) return "Amodal";
        
        StringBuffer moda = new StringBuffer();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).ocorrencia == maiorFrequencia.ocorrencia){
                moda.append(lista.get(i).valor);
                moda.append("  ");
            }
        }
       
        return moda.toString();
    }
    
    public static int calcularMediana(ArrayList lista) {
        if (lista.isEmpty()) return 0;
        
        int meio = lista.size() / 2;
        if (lista.size() % 2 != 0)
            return (int)lista.get(meio);
        
        return (int)((int)lista.get(meio - 1) + (int)lista.get(meio)) / 2;
    }
    
    public static double calcularVariancia(ArrayList lista, double media, boolean ehAmostra) {
        if (lista.isEmpty()) return 0;
        double soma = 0;
        int tamanho;
        
        if (ehAmostra) tamanho = lista.size() - 1;
        else tamanho = lista.size();
        
        for (int i = 0; i < tamanho; i++) {
            soma = soma + Math.pow((int)lista.get(i) - media, 2);
        }
        return (double)soma / tamanho;
    }
    
    public static double calcularDesvioPadrao(double variancia) {
        if (variancia == 0) return 0;
        return Math.sqrt(variancia);
    }
    
    public static double calcularErroPadrao(ArrayList lista, double desvio) {
        if (desvio == 0) return 0;
        return desvio / (Math.sqrt(lista.size()));
    }
    
    public static double calcularCoeficienteVariacao(double media, double desvio) {
        if (desvio == 0) return 0;
        
        return (desvio / media)*100;
    }
}
