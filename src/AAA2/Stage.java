package AAA2;

import java.util.Random;

public final class Stage 
{
    boolean DNA[];
    short fitness;
    public Stage()       
    {
        DNA=new boolean[16];
        Random r=new Random();
        for(int i=0;i<16;i++)
            DNA[i]=r.nextBoolean();  
        selfsteem();
    }
    public Stage(boolean code[])
    {
        DNA=code.clone();
        selfsteem();
    }
    public void selfsteem()
    {
        fitness=0;
        for(int i=0;i<16;i++)
        {
            if(i<15&&DNA[i]==true&&DNA[i+1]==false)
                fitness++;
        }
    }
    @Override
    public String toString()
    {
        String s="Estado = ";
        for(int i=0;i<16;i++)
        {
            if(DNA[i])
                s=s+"1";
            else
                s=s+"0";
        }
        s+="\r\nEnergia del estado = "+fitness+"\r\n";
        return s;
    }
}
