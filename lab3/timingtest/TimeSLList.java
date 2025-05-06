package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        int M = 10000;
        SLList<Integer> testList = new SLList<Integer>();

        AList<Integer> Ns = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        AList<Integer> opCounts = new AList<Integer>();

        for(int i=0;i<8;i++){

            int num= (int) ((Math.pow(2,i))*1000);
            Ns.addLast(num);
            double timesSlap=measureTime(testList,num,M);
            times.addLast(timesSlap);
            opCounts.addLast(M);

        }
        printTimingTable(Ns,times, opCounts);

    }

    public static double measureTime(SLList<Integer> test,int t,int m){

        for(int j=0;j<t;j++){
            test.addLast(1);
        }

        Stopwatch sw = new Stopwatch();
        for(int q=0;q<m;q++){
            test.getLast();
        }
        //test.getLast();
        double timeInSeconds = sw.elapsedTime();
        return timeInSeconds;
    }

}
