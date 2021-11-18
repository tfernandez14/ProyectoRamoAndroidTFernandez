package Objetos;

import java.util.Arrays;
import java.util.Objects;

public class Insumos
{
    private int id;
    private  String[]insumos= {"Mancuernas", "Barras","Corredoras","Puching Bag"};
    private  int[]precios={35000, 12000, 150000, 45000};
    private  int stock;

    public Insumos()
    {

    }

    public Insumos(int id, String[] insumos, int[] precios, int stock) {
        this.id = id;
        this.insumos = insumos;
        this.precios = precios;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getInsumos() {
        return insumos;
    }

    public void setInsumos(String[] insumos) {
        this.insumos = insumos;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insumos insumos1 = (Insumos) o;
        return id == insumos1.id && stock == insumos1.stock && Arrays.equals(insumos, insumos1.insumos) && Arrays.equals(precios, insumos1.precios);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, stock);
        result = 31 * result + Arrays.hashCode(insumos);
        result = 31 * result + Arrays.hashCode(precios);
        return result;
    }

    public int anadirAdicional(int valor, int adicional)
    {
        return  valor + adicional;
    }
}
