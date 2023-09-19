import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void getImctest(){
        double[][] datosIngresados = generarDatosIngresados();
        double[] datosEsperados = {35.5,23.5,30.6,24.3};
        for (int i = 0; i <datosEsperados.length ; i++) {
            Assertions.assertEquals((int)(Main.getImc(datosIngresados[i][0],datosIngresados[i][1])*10),(datosEsperados[i]*10));
        }
    }
    private double[][] generarDatosIngresados() {
        double[][] datos = new double[4][2];
        datos[0]= new double[]{80,1.5};
        datos[1]= new double[]{60.3,1.6};
        datos[2]= new double[]{55,1.34};
        datos[3]= new double[]{46.4,1.38};
        return datos;
    }
}
