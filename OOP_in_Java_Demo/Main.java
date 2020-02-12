package Lab1teht4;

abstract class Abstrakti
{
    public abstract void printMoikka();
    public void printHeippa()
    {
        System.out.println("Heippa");
    }
}

interface Interfeissi
{
    public void printTerve();
}

class A extends Abstrakti
{
    public int numero = 42;
    private int numero2 = 2;
    
    private void privatePrintHei()
    {
        System.out.println("Hei");
    }
    
    protected void printHei()
    {
        privatePrintHei();
    }
    
    public void printMoi()
    {
        System.out.println("Moi t. A");
    }
    
    public void printMoikka()
    {
        System.out.println("Moikka");
    }
}

class B extends A
{
    @Override
    public void printMoi()
    {
        System.out.println("Moi t. B");
    }
}

class C implements Interfeissi
{
    public void printTerve()
    {
        System.out.println("Terve");
    }
}

public class Main {

    public static void main(String[] args) {
        A objectA = new A();
        B objectB = new B();
        A objectA2 = new B();
        objectA.printHei();
        objectB.printHei();
        System.out.println(objectA.numero);
        objectA.printMoi();
        objectB.printMoi();
        objectA2.printMoi();
        objectB.printMoikka();
        objectB.printHeippa();
    }
    
}
