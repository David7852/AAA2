package AAA2;
import java.util.Random;
public final class Annealing 
{
    double temperture=1, coolingRate = 0.999;
    int cc=0,near=1,c=0;
    Stage best;
    public Annealing() 
    {
        best=new Stage();
        tempering();
    }    
    public static double acceptanceProbability(int energy, int newEnergy, double temperature) //formulacion original Kirkpatrick
    {
        //Si la nueva solucion es mejor, se acepta
        if (newEnergy > energy) 
            return 1.0;
        //Si la nueva solucion es peor o igual, calcular su probabilidad de aceptacion
        double p=(double)(Math.exp((-1)*((energy - newEnergy) / temperature)));
        return p;
    }
    public static double acceptanceProb(int energy, int newEnergy, double temperature) //formulacion propuesta
    {
        //Si la nueva solucion es mejor, se acepta
        if (newEnergy > energy) 
            return 1.0;
        //Si la nueva solucion es peor o igual, calcular su probabilidad de aceptacion
        double p=(double)1.0/(1+(Math.exp((energy - newEnergy) / temperature)));
        return p;
    }
    public Stage neigtbor()
    {
        Random w=new Random();
        Stage s;
        do{
            s=new Stage();
        }while(Math.abs(best.fitness-s.fitness)>near);//se itera hasta obtener un vecino aleatorio con una similtud definida
        return s;
    }
    public void tempering()
    {  
       do
       {       
           Stage newstage=neigtbor();
           if(acceptanceProb(best.fitness, newstage.fitness, temperture)>Math.random())
           {
               best=newstage;
               if(best.fitness>cc)
                   cc=best.fitness;
               c++;
           }
           temperture*=coolingRate;
       }while(temperture>0.0001&&best.fitness<8);
       System.out.println(c);
       System.out.print(best.toString()+"Maximo alcanzado = "+cc+"\r\nMaximo absoluto = 8\r\n");
    }
}
