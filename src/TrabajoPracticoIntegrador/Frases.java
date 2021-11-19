package TrabajoPracticoIntegrador;

import java.time.LocalDate;
import java.util.Random;


public class Frases {


    public String[] amor = new String[]
            {
                    "No temas poner punto final a esa relación que te trae solo dolores de cabeza. ",
                    "Hoy es el día indicado para decir basta.",
                    "Te sorprenderá saber que tu pareja está pensando en la descendencia.",
                    "Nunca podrás alcanzar una vida sin problemas o vicisitudes.",
                    "Lo importante es darle al amor el lugar que merece en ella.",
                    "Harás entender a tu pareja que necesita poner su granito de arena para hacer funcionar la relación.",
                    "Te encontrarás con el cruce del destino.",
                    "No te rindas hay algo bueno al final.",
                    "Hoy todo saldra como tu lo esperas.",
                    "Confia, está bien."
            };

    public String[] dinero = new String[]
            {
                    "Momento de suerte en los negocios. Presta atención",
                    "El lucrativo Júpiter te trae un dinero extra este mes. Disfrútalo",
                    "No es menor saber de dónde proviene porque quizás no quieras tomarlo. Ten cuidado.",
                    "Sufrirás grandes desilusiones en ciertos proyectos en los que habías invertido mucho tiempo. Todo se compondrá pronto!",
                    "Lograrás dejar claro en tu ambiente laboral que no eres el tipo de persona que tolera abusos.",
                    "Entrarás en pánico al ver que se está volviendo imposible cumplir con tus fechas límites. No temas, todo saldrá bien!",
                    "La suerte esta de tu lado.",
                    "Si te caes, ¡levántate!",
                    "Reclamaras lo que te pertenece por tu destino.",
                    "Tienes el favor de Hades."
            };

    public String[] bienestar = new String[]
            {
                    "Cuestiónate hasta dónde te dejarás llevar con tu grupo de trabajo.",
                    "No puedes permanecer con rencor por disputas que vivieras con tus seres queridos hace tiempo.",
                    "Una persona sabia como tú debe saber su cuerpo y su alma.",
                    "Aprende de tus vivencias o estarás condenado a repetirlas.",
                    "Presta atención a cada paso que das y vivirás una vida más plena y libre de escollos.",
                    "La clave del éxito reside en la forma en la cual administras los recursos a tu alcance.",
                    "Piensa antes de actuar.",
                    "Cuidado una tormenta se aproxima.",
                    "La salud es mental y fisica.",
                    "Controla tus emociones, cometeras errores si te dejas llevar."
            };

    public String obtenerFrase(LocalDate fechaNac)
    {

        Random ram = new Random();
        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2021, 1, 1).toEpochDay();
        long randomDay = minDay + ram.nextInt(maxDay - minDay);


        Random ram1 = new Random(randomDay+semana());
        Random ram2 = new Random(randomDay+semana());
        int r = ram1.nextInt(3);
        int r2 = ram2.nextInt(10);

        if (r ==1 )
        {
            return amor[r2];
        }
        else if (r == 2)
        {
            return dinero[r2];
        }
        else
            return bienestar[r2];

    }
    public static int semana()
    {
        int semana = (LocalDate.now().getDayOfMonth()/7);
        return semana;
    }
}
