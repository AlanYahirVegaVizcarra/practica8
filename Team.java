import java.util.HashMap;
import java.util.Map;

public class Team {
//
    private String nombre, division, entrenador;
    private int torneosParticipantes, torneosGanados, torneosPerdidos, cantidadDeJugadores, numeroEquipo;
    public Map<Integer, Player> players;

    public Team(String nombre, String division, String entrenador, int torneosParticipantes, int torneosGanados, int torneosPerdidos, int cantidadDeJugadores, int numeroEquipo){
        this.players = new HashMap<>();
        this.setNombre(nombre);
        this.setDivision(division);
        this.setEntrenador(entrenador);
        this.setTorneosParticipantes(torneosParticipantes);
        this.setTorneosGanados(torneosGanados);
        this.setTorneosPerdidos(torneosPerdidos);
        this.setCantidadDeJugadores(cantidadDeJugadores);
        this.setNumeroEquipo(numeroEquipo);

        this.agregarJugador();
    }

    private void agregarJugador(){
        System.out.println("Captura de informacion sobre jugadores");
        for(int i=0; i<this.getNumeroJugadores(); i++){
            System.out.printf("\nJugador #%d", i+1);
            Player player = new Player(this.validarNumeroUniforme(i,
                    CapturaDeE.capturarEntero("Ingresa numero de uniforme")),
                    CapturaDeE.capturarString("Ingresa nombre"),
                    CapturaDeE.capturarEntero("Sus Puntos anotados"),
                    CapturaDeE.capturarString("Su Posicion"),
                    CapturaDeE.capturarFloat("Su Estatura"));
            this.players.put(i, player);
        }
    }

    public int validarNumeroUniforme(int player, int numeroDeUniforme){
        if(this.players.isEmpty()){
            return numeroDeUniforme;
        }
        else{
            for(int i=0; i<this.getJugadoresRegistrados();i++){
                if(numeroDeUniforme==this.players.get(i).getNumeroUniforme()){
                    numeroDeUniforme=CapturaDeE.capturarEntero("no es valido. Ingresar otro numero");
                }
            }
        }
        return numeroDeUniforme;
    }

    public int puntosAnotados(){
        int puntosTotales=0, jugReg;
        jugReg = this.getJugadoresRegistrados();

        for (int i=0; i<jugReg; i++){
            puntosTotales += this.players.get(i).getPuntosAnotados();
        }
        return puntosTotales;
    }

    public String getNombre(){
        return nombre;
    }
    private void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getDivision(){
        return division;
    }
    private void setDivision(String division){
        this.division = division;
    }

    public String getEntrenador(){
        return entrenador;
    }
    private void setEntrenador(String entrenador){
        this.entrenador = entrenador;
    }

    public int getTorneosParticipantes(){
        return torneosParticipantes;
    }
    private void setTorneosParticipantes(int torneosParticipantes){
        this.torneosParticipantes = torneosParticipantes;
    }

    public int getTorneosGanados(){
        return torneosGanados;
    }
    private void setTorneosGanados(int torneosGanados){
        this.torneosGanados = torneosGanados;
    }

    public int getTorneosPerdidos(){
        return torneosPerdidos;
    }
    private void setTorneosPerdidos(int torneosPerdidos){
        this.torneosPerdidos = torneosPerdidos;
    }

    public int getNumeroJugadores(){
        return cantidadDeJugadores;
    }
    private void setCantidadDeJugadores(int cantidadDeJugadores){
        this.cantidadDeJugadores = cantidadDeJugadores;
    }

    public int getNumeroEquipo(){
        return numeroEquipo;
    }
    private void setNumeroEquipo(int numeroEquipo){
        this.numeroEquipo = numeroEquipo;
    }

    public int getJugadoresRegistrados(){
        return players.size();
    }

    public String getNombreJugador(int jugador){
        return players.get(jugador).getNombre();
    }
    public int getNumeroUniforme(int jugador){
        return players.get(jugador).getNumeroUniforme();
    }

}