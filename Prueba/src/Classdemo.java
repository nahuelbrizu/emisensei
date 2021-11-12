class A
{
    void aa()
    {
        System.out.println ("A en");

    }

}
class B extends A
{
    void aa()
    {
        System.out.println ("B");
    }

}
class C extends A
{
    void aa()
    {
        System.out.println ("C en");

    }

}
public class Classdemo {

    public static void main(String[] args)
    {
        Classdemo t=new Classdemo();
        t.show("C");
    }
    void show(String name)
    {
        try
        {
            A show=(A)Class.forName(name).newInstance();
            show.aa();
        }
        catch(Exception e)
        {
            System.out.println (e);
        }


    }


}
