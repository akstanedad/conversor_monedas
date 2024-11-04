import java.util.Scanner;

public class Calculos {

    private String monedaBase;
    private String monedaObjetivo;
    private double cantidad;

    Scanner lectura = new Scanner(System.in);
    ConsultaConversion conversion;



    public Calculos(ConsultaConversion conversion){
        this.conversion = conversion;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public String getMonedaObjetivo() {
        return monedaObjetivo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void almacenarValores(String monedaBase, String monedaObjetivo){
        this.monedaBase = monedaBase;
        this.monedaObjetivo = monedaObjetivo;

        System.out.println("Ingresa al valor que deseas convertir:");

        this.cantidad = Double.parseDouble(lectura.nextLine());
    }

    public void almacenarValoresPersonalizados(){
        String menuOtrasOpciones = " ----";

        System.out.println(menuOtrasOpciones);

        System.out.println("Ingrese la moneda base con 3 letras");

        this.monedaBase = lectura.next();

        System.out.println("Ingrese la moneda objetivo con 3 letras");

        this.monedaObjetivo = lectura.next();

        boolean entradaValida = false;
        do {
            System.out.println("Ingrese el valor que desea convertir");

            if (lectura.hasNextDouble()){
                this.cantidad = lectura.nextDouble();
                entradaValida = true;
            }else {
                System.out.println("Error, ingrese un valor númerico");
                lectura.next();
            }
        } while (!entradaValida);
    }

    public  String obtenerMensajeRespuesta() {
        String mensaje = getMonedaBase(). toUpperCase() + " " + getCantidad() + " equivale a: " + getMonedaObjetivo().toUpperCase()+ " " + conversion.buscaConversion(getMonedaBase(), getMonedaObjetivo(), getCantidad());
        System.out.println(mensaje);
        return mensaje;
    }
}
