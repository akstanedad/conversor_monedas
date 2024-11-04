import com.google.gson.JsonSyntaxException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcionElegida = 0;


        ConsultaConversion consulta = new ConsultaConversion();


        Calculos calculos = new Calculos(consulta);



        List<String> respuestas = new ArrayList<>();

        String menu = """
                Conversor de monedas
                1) Peso mexicano --> Dolar estadounidense
                2) Peso mexicano --> Euro
                3) Peso mexicano --> Real brazileño
                4) Dolar estadounidense --> Peso mexicano
                5) Euro --> Peso mexicano
                6) Real brazileño --> Peso mexicano
                7) Otra opcion de conversion
                8) Salir
                """;



        while (opcionElegida != 8) {

            try {
                System.out.println(menu);
                opcionElegida = Integer.parseInt(lectura.nextLine());

                LocalDateTime myDateObj = LocalDateTime.now();

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                String formattedDate = myDateObj.format(myFormatObj);


                switch  (opcionElegida) {
                    case 1:
                        calculos.almacenarValores("MXN","USD");
                        respuestas.add(formattedDate + "-" + calculos.obtenerMensajeRespuesta());
                        break;

                    case 2:
                        calculos.almacenarValores("MXN","EUR");
                        respuestas.add(formattedDate + "-" + calculos.obtenerMensajeRespuesta());
                        break;

                    case 3:
                        calculos.almacenarValores("MXN","BRL");
                        respuestas.add(formattedDate + "-" + calculos.obtenerMensajeRespuesta());
                        break;

                    case 4:
                        calculos.almacenarValores("USD","MXN");
                        respuestas.add(formattedDate + "-" + calculos.obtenerMensajeRespuesta());
                        break;

                    case 5:
                        calculos.almacenarValores("EUR","MXN");
                        respuestas.add(formattedDate + "-" + calculos.obtenerMensajeRespuesta());
                        break;

                    case 6:
                        calculos.almacenarValores("BRL","MXN");
                        respuestas.add(formattedDate + "-" + calculos.obtenerMensajeRespuesta());
                        break;

                    case 7:
                        calculos.almacenarValoresPersonalizados();
                        respuestas.add(formattedDate + "-" + calculos.obtenerMensajeRespuesta());
                        break;

                    case 8:
                        break;

                    default:
                        System.out.println("Ingrese una opción valida");


                }

            } catch (JsonSyntaxException | NullPointerException e ) {
                System.out.println("Error, ingrese solo codigos de modena validos");
            }catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Error, ingrese un valor numerico valido");
            }
        }



        System.out.println("Finalizando el programa");



    }
}
