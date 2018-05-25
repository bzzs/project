package com.cherkasov.stockcar.entity;
import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name;
    private String email;
    private String URI;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }


    public String getURI() { return URI; }

    public void setURI(String URI) { this.URI = URI; }
}
