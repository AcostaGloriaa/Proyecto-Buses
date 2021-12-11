
package buses;

import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Buses {
      
    public static int contador = 0;
    public static int contador_autobuses = 0;    
    public static String Identificador_Pasajero_Nombre = "Pasajero";
    public static int Identificador_Pasajero_Numero = 0;
    public static int Identificador_autobus_Numero = 3;
        
    public static LinkedList<Personas> pila = new LinkedList();
    
    public static LinkedList<Personas> pila_especial = new LinkedList();
    
    public static LinkedList<Bus> parada1 = new LinkedList();
    public static LinkedList<Bus> parada2 = new LinkedList();
    public static LinkedList<Bus> parada3 = new LinkedList();
    
    public static LinkedList<Bus> Buses_Fuera = new LinkedList();
    public static LinkedList<Integer> Maximo_Vuelto = new LinkedList();
    public static LinkedList<Integer> Mayor_tiempo_salida_bus = new LinkedList();
    public static LinkedList<Integer> Mayor_tiempo_Pasajero_vuelto = new LinkedList();
    
        
    public static void main(String[] args) {
        
        
        parada1.add(new Bus("A","1"));
        parada2.add(new Bus("B","2"));
        parada3.add(new Bus("C","3"));
        System.out.println("#INICIO");
        Buses_Parada();
                
        Segundero();
        LLegada_autobus();
        LLegada_autobus();
        LLegada_autobus();
        Asignación_Paradas();
        Pasajeros();  
        Acabar();
        
    }
  
    //CONTADOR DE SEGUNDOS DE LA SIMULACIÓN
    public static void Segundero(){    
    Timer timer = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                if(contador == 60){
                    timer.cancel();
                }
                contador = contador + 1;
            }
        };
        timer.schedule(tarea, 5000,5000);
    }
    
//    public static void Cobrando(){    
//    Timer timer = new Timer();
//        TimerTask tarea = new TimerTask() {
//            @Override
//            public void run() {
//                if(contador == 60){
//                    timer.cancel();
//                }
//                
//                if(!parada1.isEmpty() && parada1.getFirst().getPasajeros().size()>=25){
//                    Cobrador(parada1.getFirst(), "1");
//                } else if (!parada2.isEmpty() && parada2.getFirst().getPasajeros().size()>=25) {
//                    Cobrador(parada2.getFirst(), "2");
//                } else if (!parada3.isEmpty() && parada3.getFirst().getPasajeros().size()>=25) {
//                    Cobrador(parada3.getFirst(), "3");
//                }
//                
//            }
//        };
//        timer.schedule(tarea, 10,10);
//    }

    public static void Cobrador(Bus b, String Parada, LinkedList<Bus> ParadaNum) {
        System.out.println("#COBRANDO PARADA " + Parada + " RUTA " + b.getPlaza());

        LinkedList<Personas> PorCobrar = new LinkedList();
        for (int x = 0; x < b.getPasajeros().size() - 1; x++) {

            if (!PorCobrar.isEmpty()) {
                
                for ( int i = PorCobrar.size()-1 ; i >= 0; i--) {

                    if (b.getDinero().getFirst() + b.getDinero().getLast() == PorCobrar.getLast().getVuelto()) {
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollFirst());
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollLast());
                        tiempo(b, i);
                        PorCobrar.remove(i);

                    } else if (b.getDinero().getFirst() + b.getDinero().get(1) + b.getDinero().getLast() == PorCobrar.getLast().getVuelto()) {
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollFirst());
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollLast());
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollFirst());
                        tiempo(b, i);
                        PorCobrar.remove(i);

                    } else if (b.getDinero().getFirst() + b.getDinero().get(b.getDinero().size() - 2) + b.getDinero().getLast() == PorCobrar.getLast().getVuelto()) {
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollFirst());
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollLast());
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollLast());
                        tiempo(b, i);
                        PorCobrar.remove(i);

                    } else if (b.getDinero().getFirst() + b.getDinero().get(b.getDinero().size() - 2) + b.getDinero().get(1) + b.getDinero().getLast() == PorCobrar.getLast().getVuelto()) {
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollFirst());
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollLast());
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollFirst());
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollLast());
                        tiempo(b, i);
                        PorCobrar.remove(i);

                    } else if (b.getDinero().get(b.getDinero().size() - 2) + b.getDinero().getLast() == PorCobrar.getLast().getVuelto()) {
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollLast());
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollLast());
                        tiempo(b, i);
                        PorCobrar.remove(i);

                    } else if (b.getDinero().get(b.getDinero().size() - 2) + b.getDinero().get(b.getDinero().size() - 3) + b.getDinero().getLast() == PorCobrar.getLast().getVuelto()) {
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollLast());
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollLast());
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollLast());
                        tiempo(b, i);
                        PorCobrar.remove(i);

                    } else if (b.getDinero().getFirst() + b.getDinero().get(1) == PorCobrar.getLast().getVuelto()) {
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollFirst());
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollFirst());
                        tiempo(b, i);
                        PorCobrar.remove(i);

                    } else if (b.getDinero().getFirst() + b.getDinero().get(1) + b.getDinero().get(2) == PorCobrar.getLast().getVuelto()) {
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollFirst());
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollFirst());
                        PorCobrar.getLast().DINEROS().add(b.getDinero().pollFirst());
                        tiempo(b, i);
                        PorCobrar.remove(i);

                    } else {
                        break;
                    }
                }

            }

            if (b.getPasajeros().get(x).getVuelto() == 0) {

                
                for (int a = 0; a<= b.getPasajeros().get(x).DINEROS().size()-1 ; a++ ){
                    b.getDinero().add(b.getPasajeros().get(x).DINEROS().get(a));
                }


            } else if (b.getPasajeros().get(x).getVuelto() != 0 &&  b.getDinero().size()>0) {

                if (b.getDinero().getFirst() + b.getDinero().getLast() == b.getPasajeros().get(x).getVuelto()) {
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollFirst());
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollLast());

                    } else if (b.getDinero().getFirst() + b.getDinero().get(1) + b.getDinero().getLast() == b.getPasajeros().get(x).getVuelto()) {
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollFirst());
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollLast());
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollFirst());

                    } else if (b.getDinero().getFirst() + b.getDinero().get(b.getDinero().size() - 2) + b.getDinero().getLast() == b.getPasajeros().get(x).getVuelto()) {
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollFirst());
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollLast());
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollLast());

                    } else if (b.getDinero().getFirst() + b.getDinero().get(b.getDinero().size() - 2) + b.getDinero().get(1) + b.getDinero().getLast() == b.getPasajeros().get(x).getVuelto()) {
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollFirst());
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollLast());
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollFirst());
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollLast());

                    } else if (b.getDinero().get(b.getDinero().size() - 2) + b.getDinero().getLast() == b.getPasajeros().get(x).getVuelto()) {
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollLast());
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollLast());

                    } else if (b.getDinero().get(b.getDinero().size() - 2) + b.getDinero().get(b.getDinero().size() - 3) + b.getDinero().getLast() == b.getPasajeros().get(x).getVuelto()) {
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollLast());
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollLast());
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollLast());

                    } else if (b.getDinero().getFirst() + b.getDinero().get(1) == b.getPasajeros().get(x).getVuelto()) {
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollFirst());
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollFirst());

                    } else if (b.getDinero().getFirst() + b.getDinero().get(1) + b.getDinero().get(2) == b.getPasajeros().get(x).getVuelto()) {
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollFirst());
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollFirst());
                        b.getPasajeros().get(x).DINEROS().add(b.getDinero().pollFirst());

                    } else {
                    b.getPasajeros().get(x).setTiempoinicial(contador);                    
                    PorCobrar.add(b.getPasajeros().get(x));
                    b.setMayor_Deuda(b.getMayor_Deuda() + b.getPasajeros().get(x).getVuelto());
                }
                
                Maximo_Vuelto.add(b.getPasajeros().get(x).getVuelto());

            } 
        }
        
        if (!PorCobrar.isEmpty()) {
            SegundoCobro(b, PorCobrar);
        }
        System.out.println("MAYOR DE DEUDA TOTAL: "+b.getMayor_Deuda()+ " bs");
        System.out.println("CANTIDAD DE MONEDAS DE 1 ENTREGADAS: "+b.getCambio_un_bs()+" bs");
        int guardar;
        int mayor=0;
        for(int i = 0; i<Mayor_tiempo_Pasajero_vuelto.size(); i++){
            guardar = Mayor_tiempo_Pasajero_vuelto.get(i);                        
            if(guardar>mayor){
               mayor = guardar; 
            }
        }
        System.out.println("Tiempo máximo que espera un pasajero para recibir dinero: "+mayor+" min "+random_seg()+" seg");
        System.out.println("Tamaño máximo de la pila de vueltos: "+Maximo_Vuelto.size());
        System.out.println("#SALIDA DE AUTOBUS ");
        System.out.println("");        
        b.setTimeend(contador);
        
        int diferencia = ((b.getTimeend() - b.getTimefirst()/5));        
        Mayor_tiempo_salida_bus.add(diferencia);
        
        
        
        
        
        //Mayor_tiempo_salida_bus.add();
        
        ParadaNum.removeFirst();                
    }
    
    public static void SegundoCobro(Bus b, LinkedList<Personas> PorCobrar) {
        
        for ( int i = 0 ; i <= PorCobrar.size()-1; i++) {
        int sum = 0;
            for( int j =0  ; j <= b.getDinero().size()-1; j++){
                sum=sum+b.getDinero().get(j);
                if (!PorCobrar.isEmpty() && sum==PorCobrar.get(i).getVuelto()){
                    PorCobrar.remove(i);
                    break;
                } else if (sum>PorCobrar.get(i).getVuelto()){
                    break;
                }
            }
        }

        do {
            int sum = 0;

            do {
                if (!PorCobrar.isEmpty() && sum == PorCobrar.getFirst().getVuelto()) {
                    PorCobrar.removeLast();
                    
                    break;
                }
                sum = sum + 1;
                b.setCambio_un_bs(b.getCambio_un_bs()+1);
            } while (true);
        } while (!PorCobrar.isEmpty());


    }

    public static void Buses_Parada() {
        System.out.println("#AUTOBUSES EN PARADA");
        System.out.println(parada1.getFirst().getPlaza() + ", " + parada2.getFirst().getPlaza() + ", " + parada3.getFirst().getPlaza() + "\n");
        
    }

    public static void Autobus_Lleno(String num) {

        System.out.println("#SE LLENO UN AUTOBUS EN PARADA " + num);
        if (!parada1.isEmpty()) {
            System.out.println("PARADA 1: " + parada1.getFirst().getPasajeros().size() + " personas RUTA " + parada1.getFirst().getPlaza());
        } else {
            System.out.println("PARADA 1: Esperando Bus...");
        }

        if (!parada2.isEmpty()) {
            System.out.println("PARADA 2: " + parada2.getFirst().getPasajeros().size() + " personas RUTA " + parada2.getFirst().getPlaza());
        } else {
            System.out.println("PARADA 2: Esperando Bus...");
        }

        if (!parada3.isEmpty()) {
            System.out.println("PARADA 3: " + parada3.getFirst().getPasajeros().size() + " personas RUTA " + parada3.getFirst().getPlaza());
        } else {
            System.out.println("PARADA 3: Esperando Bus...");
        }
        System.out.println("COLA: " + pila.size());
        System.out.println("COLA ESPECIAL: " + pila_especial.size());
     
    }

    //CREACIÓN DE PASAJEROS
    public static void Pasajeros(){    
    Timer timer = new Timer();   
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                if(contador == 60){
                    timer.cancel();
                }
                
                Personas p = new Personas();
                Identificador_Pasajero_Numero++;
                p.setIdentificador(Identificador_Pasajero_Nombre +" " +Identificador_Pasajero_Numero);
                Random r = new Random();
                int valorDado = r.nextInt(3) + 1;
                switch (valorDado) {
                    case 1:
                        p.setBus("A");                        
                        break;
                    case 2:
                        p.setBus("B");                        
                        break;
                    case 3:
                        p.setBus("C");                        
                        break;
                    default:
                        break;
                }
                
                try {
                    if (parada1.isEmpty() && parada2.isEmpty() && parada3.isEmpty()) {
                        pila.push(p);
                        //System.out.println("El " + Identificador_Pasajero_Nombre + " " + Identificador_Pasajero_Numero + " está en la fila - " + p.getBus());
                    } else if (!parada1.isEmpty() && parada1.peek().getPlaza().equals(p.getBus())) {
                        pila.push(p);
                        //System.out.println("El " + Identificador_Pasajero_Nombre + " " + Identificador_Pasajero_Numero + " está en la fila - " + p.getBus());
                    } else if (!parada2.isEmpty() && parada2.peek().getPlaza().equals(p.getBus())) {
                        pila.push(p);
                        //System.out.println("El " + Identificador_Pasajero_Nombre + " " + Identificador_Pasajero_Numero + " está en la fila - " + p.getBus());
                    } else if (!parada3.isEmpty() && parada3.peek().getPlaza().equals(p.getBus())) {
                        pila.push(p);
                        //System.out.println("El " + Identificador_Pasajero_Nombre + " " + Identificador_Pasajero_Numero + " está en la fila - " + p.getBus());
                    } else {
                        pila_especial.push(p);
                        //System.out.println("El " + Identificador_Pasajero_Nombre + " " + Identificador_Pasajero_Numero + " está en la fila especial - " + p.getBus());
                    }
                } catch (Exception e) {
                }
                
            }
        };

        timer.schedule(tarea, 1000, 1000);
    }

    //MOSTRAR TAMAÑO DE PASAJEROS EN TOTAL
    public static void Cantidad_Personas() {
        Timer timer = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                System.out.println(pila.size());
            }
        };
        timer.schedule(tarea, 12000, 12000);
    }

    public static int randomm() {
        Random r = new Random();
        int valorDado = r.nextInt(25000)+50000;
        return valorDado;
    }

//    Asignación de autobuses a cada parada de manera aleatoria
    public static void Revision_Paradas(LinkedList<Bus> parada) {
        if (!parada.isEmpty()) {
            if (!pila_especial.isEmpty() && parada.peek().getPlaza().equals(pila_especial.getFirst().getBus())) {
                parada.peek().addPasajeros(pila_especial.pollFirst());
            }
        }
    }

    public static void Asignación_Paradas() {
        Timer timer = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                if (contador == 60) {
                    timer.cancel();
                }

                boolean ver = true;
                do {
                    ver = false;

                    if (!parada1.isEmpty() && !pila_especial.isEmpty()) {
                        if (parada1.getFirst().getPlaza().equals(pila_especial.peekFirst().getBus())) {
                            //System.out.println("Un pasajero subio al bus PARADA 1");
                            parada1.getFirst().addPasajeros(pila_especial.pollFirst());
                            ver = true;

                            if (parada1.getFirst().getPasajeros().size() >= 25) {
                                Autobus_Lleno("1");
                                Cobrador(parada1.getFirst(), "1", parada1);
                                
                            }

                        }

                    }
                    if (!parada2.isEmpty() && !pila_especial.isEmpty()) {
                        if (parada2.getFirst().getPlaza().equals(pila_especial.peekFirst().getBus())) {
                            //System.out.println("Un pasajero subio al bus PARADA 2");
                            parada2.getFirst().addPasajeros(pila_especial.pollFirst());
                            ver = true;
                            
                            if (parada2.getFirst().getPasajeros().size() >= 25) {
                                Autobus_Lleno("2");
                                Cobrador(parada2.getFirst(), "2", parada2);
                            }
                            
                        }

                    }
                    if (!parada3.isEmpty() && !pila_especial.isEmpty()) {
                        if (parada3.getFirst().getPlaza().equals(pila_especial.peekFirst().getBus())) {
                            //System.out.println("Un pasajero subio al bus PARADA 3");
                            parada3.getFirst().addPasajeros(pila_especial.pollFirst());
                            ver = true;
                            
                            if (parada3.getFirst().getPasajeros().size() >= 25) {
                                Autobus_Lleno("3");
                                Cobrador(parada3.getFirst(), "3", parada3);
                            }
                        }

                    }
                } while (ver);

                do {
                    ver = false;

                    if (!parada1.isEmpty() && !pila.isEmpty()) {
                        if (parada1.getFirst().getPlaza().equals(pila.peekFirst().getBus())) {
                            //System.out.println("Un pasajero subio al bus PARADA 1");
                            parada1.getFirst().addPasajeros(pila.pollFirst());
                            ver = true;
                            
                            if (parada1.getFirst().getPasajeros().size() >= 25) {
                                Autobus_Lleno("1");
                                Cobrador(parada1.getFirst(), "1", parada1);
                            }
                        }

                    }
                    if (!parada2.isEmpty() && !pila.isEmpty()) {
                        if (parada2.getFirst().getPlaza().equals(pila.peekFirst().getBus())) {
                            //System.out.println("Un pasajero subio al bus PARADA 2");
                            parada2.getFirst().addPasajeros(pila.pollFirst());
                            ver = true;
                            
                            if (parada2.getFirst().getPasajeros().size() >= 25) {
                                Autobus_Lleno("2");
                                Cobrador(parada2.getFirst(), "2", parada2);
                            }
                        }

                    }
                    if (!parada3.isEmpty() && !pila.isEmpty()) {
                        if (parada3.getFirst().getPlaza().equals(pila.peekFirst().getBus())) {
                            //System.out.println("Un pasajero subio al bus PARADA 3");
                            parada3.getFirst().addPasajeros(pila.pollFirst());
                            ver = true;
                            
                            if (parada3.getFirst().getPasajeros().size() >= 25) {
                                Autobus_Lleno("3");
                                Cobrador(parada3.getFirst(), "3", parada3);
                            }
                        }

                    }
                } while (ver);

            }

        };
        timer.schedule(tarea, 0, 10);
    }
                            
    
    //Número para buses llegando de manera aleatoria
    public static void LLegada_autobus(){    
    Timer timer = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                if(contador == 60){
                    timer.cancel();
                }
                
                Bus transporte = new Bus();
                               
                Random r = new Random();
                int valorDado = r.nextInt(3) + 1;
                
                switch (valorDado) {
                    case 1:
                        transporte.setPlaza("A");                        
                        parada_aleatoria(transporte);                        
                        break;
                    case 2:
                        transporte.setPlaza("B");
                        parada_aleatoria(transporte);
                        break;
                    case 3:
                        transporte.setPlaza("C");
                        parada_aleatoria(transporte);
                        break;
                    default:
                        break;
                }
                
            }
        };
        timer.schedule(tarea, 0,randomm());
    }
    
    public static void parada_aleatoria(Bus t){
        Random r = new Random();
        int valorDado = r.nextInt(3) + 1;
        
        switch (valorDado) {
            case 1:
                if (parada1.isEmpty()) {
                    Identificador_autobus_Numero++;
                    t.setIdentificador("Autobus "+Identificador_autobus_Numero); 
                    t.setTimefirst(contador);
                    contador_autobuses++;
                    parada1.add(t);
                    
                    //System.out.println(t.getPlaza() + "  " + t.getIdentificador());
                    
                }
                break;
            case 2:
                if (parada2.isEmpty()) {
                    Identificador_autobus_Numero++;
                    t.setIdentificador("Autobus "+Identificador_autobus_Numero); 
                    t.setTimefirst(contador);
                    contador_autobuses++;
                    parada2.add(t);
                    //System.out.println(t.getPlaza() + "  " + t.getIdentificador());
                }
                break;
            case 3:
                if (parada3.isEmpty()) {
                    Identificador_autobus_Numero++;
                    t.setIdentificador("Autobus "+Identificador_autobus_Numero); 
                    t.setTimefirst(contador);
                    contador_autobuses++;
                    parada3.add(t);
                    //System.out.println(t.getPlaza() + "  " + t.getIdentificador());
                }
                break;
            default:
                break;
        }
        
    }
    
    public static void Acabar(){
        Timer timer = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                int guardar;
                int mayor=0;
                if (contador == 60) {
                    System.out.println("");
                    System.out.println("#ESTADISTICAS FINALES");
                    System.out.println("TAMANO MAXIMO DE COLA ESPECIAL: "+ pila_especial.size());
                    System.out.println("CANTIDAD DE AUTOBUSES QUE SALIERON: "+ contador_autobuses);                    
                    for(int i = 0; i<Mayor_tiempo_salida_bus.size(); i++){
                        guardar = Mayor_tiempo_salida_bus.get(i);                        
                        if(guardar>mayor){
                           mayor = guardar; 
                        }
                    }
                    System.out.println("MAYOR TIEMPO DE ESPERA PARA QUE UN AUTOBUS SALGA: "+mayor+" minutos");
                    System.exit(0);
                }                
            }
        };
        timer.schedule(tarea, 0,1000);
    }
    
    public static void tiempo(Bus b,int c){
        b.getPasajeros().get(c).setTiempofinal(contador);        
        int time = (b.getPasajeros().get(c).getTiempofinal() - b.getPasajeros().get(c).getTiempoinicial())/5;
        Mayor_tiempo_Pasajero_vuelto.add(time);                
    }
 
    public static int random_seg() {
        Random r = new Random();
        int valorDado = r.nextInt(60);
        return valorDado;
    }
}

