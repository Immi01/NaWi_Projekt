package at.htldornbirn.projects.nawi.Team9;

public class Calculations {
    private double watt;
    private double ps = 0.0;
    private String psString = "";
    private double gravitation = 9.81;
    private double height = 1.0;
    private Team9Game team9Game;
    private double kgValueDouble;
    private String kgValueString;


    public Calculations(Team9Game game) {
        this.team9Game = game;
        if (kgValueString != null) {
            kgValueDouble = Double.parseDouble(kgValueString);
            watt = kgValueDouble * gravitation * height;
            ps = watt / 735.5;
            psString = Double.toString(ps);
        }
    }


    public double getWatt() {
        return watt;
    }

    public void setWatt(double watt) {
        this.watt = watt;
    }

    public double getPs() {
        return ps;
    }

    public void setPs(double ps) {
        this.ps = ps;
    }

    public String getPsString() {
        return psString;
    }

    public void setPsString(String psString) {
        this.psString = psString;
    }

    public double getGravitation() {
        return gravitation;
    }

    public void setGravitation(double gravitation) {
        this.gravitation = gravitation;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Team9Game getTeam9Game() {
        return team9Game;
    }

    public void setTeam9Game(Team9Game team9Game) {
        this.team9Game = team9Game;
    }

    public double getKgValueDouble() {
        return kgValueDouble;
    }

    public void setKgValueDouble(double kgValueDouble) {
        this.kgValueDouble = kgValueDouble;
    }

    public String getKgValueString() {
        return kgValueString;
    }

    public void setKgValueString(String kgValueString) {
        this.kgValueString = kgValueString;
    }
}

