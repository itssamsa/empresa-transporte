package co.edu.uniquindio.model;

public class Usuario {
    private int edad;
    private String id;
    public Usuario(){}

    public Usuario(int edad, String id){
        this.edad = edad;
        this.id=id;
    }

    public int getEdad() {
        return edad;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
