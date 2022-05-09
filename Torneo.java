import java.util.HashMap;
import java.util.Map;

public class Torneo {
    private String nombre, region;
    private int partidosJugados, partidosPendientes, numeroParticipantes;
    private Map<Integer, Team> teams;

    public Torneo(String nombre, String region, int numeroEquiposParticipantes, int partidosJugados, int partidosPendientes){
        this.teams = new HashMap<>();

        this.setNombre(nombre);
        this.setRegion(region);
        this.setNumeroEquiposParticipantes(numeroEquiposParticipantes);
        this.setPartidosJugados(partidosJugados);
        this.setPartidosPendientes(partidosPendientes);


        this.agregarEquipos();
    }

    private void agregarEquipos(){
        for(int i=0; i<this.getNumeroEquiposParticipantes(); i++){
            System.out.println("Ingreso de informacion sobre Equipo");
            Team equipo = new Team(

                    CapturaDeE.capturarString("Nombre de equipo"),
                    CapturaDeE.capturarString("Division"),
                    CapturaDeE.capturarString("Entrenador"),
                    CapturaDeE.capturarEntero("Torneos participados"),
                    CapturaDeE.capturarEntero("Torneos ganados"),
                    CapturaDeE.capturarEntero("Torneos perdidos"),
                    CapturaDeE.capturarEntero("Cantidad de jugadores en equipo"),
                    i);

            this.teams.put(i, equipo);
        }
    }

    public String getNombre() {
        return nombre;
    }
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegion() {
        return region;
    }
    private void setRegion(String region) {
        this.region = region;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }
    private void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getPartidosPendientes() {
        return partidosPendientes;
    }
    private void setPartidosPendientes(int partidosPendientes) {
        this.partidosPendientes = partidosPendientes;
    }

    public int getNumeroEquiposParticipantes() {
        return numeroParticipantes;
    }
    private void setNumeroEquiposParticipantes(int numeroParticipantes) {
        this.numeroParticipantes = numeroParticipantes;
    }

    public int getNumeroJugadores(int team){
        return this.teams.get(team).getJugadoresRegistrados();
    }

    public String getNombreJugador(int team, int player){
        return this.teams.get(team).getNombreJugador(player);
    }

    public int getNumeroUniforme(int team, int player){
        return this.teams.get(team).getNumeroUniforme(player);
    }

    public String getNombreEquipo(int team){
        return this.teams.get(team).getNombre();
    }

    public int getPuntosAnotados(int team){
        return this.teams.get(team).puntosAnotados();
    }

    public String getDivision(int team){
        return this.teams.get(team).getDivision();
    }

    public int getPuntosEquipos(int team){
        return this.teams.get(team).puntosAnotados();
    }
}