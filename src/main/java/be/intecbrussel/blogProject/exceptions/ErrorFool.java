package be.intecbrussel.blogProject.exceptions;

public class ErrorFool {
    private String erreur = "erreur dans Ta GUEULE";

    public ErrorFool() {
    }

    public ErrorFool(String erreur) {
        this.erreur = erreur;
    }

    public String getErreur() {
        return erreur;
    }
}
