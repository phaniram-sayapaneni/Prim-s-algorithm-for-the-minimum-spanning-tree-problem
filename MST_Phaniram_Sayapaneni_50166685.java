import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MST_Phaniram_Sayapaneni_50166685 {

         private static LinkedList<Integer> Null;
        private int heapsize;
         private int[]  graph;
         private HashMap h = new HashMap();
         private int element_node_i;
         private int indexofnode_i;
         private int lastindex;
    public MST_Phaniram_Sayapaneni_50166685(int capacity) {

        graph = new int[capacity];
         Arrays.fill(graph, -1);
          lastindex=-1;
        // TODO Auto-generated constructor stub
    }
    public void add_elements(int element, int value)
    {
        lastindex = lastindex+1;
        graph[lastindex]= element;//graph.add(element);
        h.put(element, value);
        if(lastindex>=2)
            //{level1sorting();
            {graph = shift_up();
            //level1sorting();
            }}

    public int[] shift_up()
    { int k=  lastindex;
  while( ( ((k-1)/2)>=0) &&  (int)h.get(graph[((k-1)/2)]) >= (int) h.get(graph[(k)])) ////swap things here
  {   int   temp = (int) (graph[((k-1)/2)]); ////int   temp = (int) graph.get((k-1)/2);
      int temp2 = (int) (graph[(k)]);   ////int temp2 = (int) graph.get(k);
      // graph.remove((k-1)/2);
     graph[(k-1)/2]= temp2;  // graph.add( ((k-1)/2),  temp2);
      //graph.remove(k);
      graph[k] = temp;// graph.add(k, temp);
       if((k-1)/2 >0)
       {k= (k-1)/2;
       }
       else
         {break;}
  }
    return graph; }



    public int[] shift_down()
    {   int first = (int) graph[0];
      // int lastindex = graph[graph.length-1];
        int k= 0;////last index
        //System.out.println("lastindex" + lastindex);
        while( ((2*k+2<= lastindex) ||(2*k+1<= lastindex)) && ((int) h.get(graph[k]) > (int) h.get(graph[2*k+1]) || (int) h.get(graph[k]) > (int) h.get(graph[2*k+2]))) ////swap things here
        { if( (int) h.get(graph[2*k+1]) <= (int) h.get(graph[2*k+2]))/// if left node smaller swap stuff
            { int   temp = (int) graph[(2*k +1)];
            //graph.remove(2*k+1);
             graph[(2*k+1)]=  graph[(k)];
             //graph.remove(k);
             graph[(k)]= temp;
             k= 2*k +1;}
           else if( (int) h.get(graph[2*k+2]) < (int) h.get(graph[2*k+1]))/// if left node smaller swap stuff
          { int   temp = (int) graph[(2*k +2)];
          //graph.remove(2*k+2);
            graph[(2*k+2)] =  graph[(k)];
            //graph.remove(k);
            graph[(k)]= temp;   //graph.add(k, temp);
              k= 2*k +2; }      }
          return graph; }

    public int[] extract_min(){
        //System.out.println("into extract min");
        int[] a =new int[2];
        a[0]=graph[0];
        a[1] = (int) h.get(graph[0]);
        /////////////also need to remove the last and put in first

        graph[0]=graph[lastindex];
        lastindex= lastindex-1;
        graph= shift_down();



        return a;
    }


    public int[] key_decrease(int key, int value)
    {
        if(h.containsKey(key))
        {h.remove(key);
            h.put(key, value);}
      graph= decrease_key_shift_up(key);
      for(int i=0; i<=lastindex; i++)
      {
          //System.out.println(graph[i]);
          }

      return graph;
    }
    /////////////////////// seperate shiftup for decrease key
    public int[] decrease_key_shift_up(int key)
    {int index=Integer.MAX_VALUE;
        for(int i=0; i<=lastindex; i++)
    {if(graph[i]==key)
        {index=i;}}
        //System.out.println("index" + index);
        while((index>0) && (index<=lastindex))
        {
            if((int) h.get(graph[index])< (int) h.get(graph[(index-1)/2]))//swap here
            {int temp =graph[(index-1)/2];
            graph[(index-1)/2] = graph[index];
              graph[index]  = temp;
              index=(index-1)/2;


            }
            else{break;}
                //System.out.println("wait, index is here:" + index);
                }
        return graph;

    }




    public static void main(String[] args) throws FileNotFoundException {
        int capacity =20; int a1; int b1; int c1;LinkedList vertices= new LinkedList(); LinkedList set= new LinkedList(); LinkedList f = new LinkedList();
        int[] a = new int[2];int totalweight=0;boolean bool =true;
        Scanner scanner = new Scanner(new File("/Users/phaniram/Downloads/P1_Public_Cases-3/test2"));
        HashMap<Integer, LinkedList<int[]>> hm =    new HashMap<Integer, LinkedList<int[]>>();
        int n  = scanner.nextInt();LinkedList<Integer>[] vtx = new LinkedList[n]; HashMap d = new HashMap(); HashMap weights= new HashMap(); HashMap ss = new HashMap(); HashMap parent = new HashMap(); HashMap hell = new HashMap();
        int  m = scanner.nextInt();
        capacity = n;
        MST_Phaniram_Sayapaneni_50166685 heap = new MST_Phaniram_Sayapaneni_50166685(capacity);
        for(int j=0; j<m; j++)
         {
         a1 = scanner.nextInt();
         if(!vertices.contains(a1))
         {vertices.add(a1);}//mantaining list of vertices
         b1 = scanner.nextInt();



         c1 = scanner.nextInt();////storing weights in a new hashmap

         ////////
         int []b = new int[2];
         int []c = new int[2];
         b[0]=b1; b[1]=c1;
         c[0] = a1; c[1] =c1;
         if(hm.containsKey(a1))
         {LinkedList<int[]> ll=new LinkedList<int[]>();
         ll = hm.get(a1);
         if(!(ll.contains(b)))
             {ll.add(b);
             hm.put(a1, ll);}    }
         else
         {LinkedList<int[]> ll=new LinkedList<int[]>();
          ll.add(b);
             hm.put(a1, ll);}
///////////////////////////////////// for bidirectionality
         if(hm.containsKey(b1))
         {LinkedList<int[]> ll=new LinkedList<int[]>();
         ll = hm.get(b1);
         if(!(ll.contains(c)))
             {ll.add(c);
             hm.put(b1, ll);}    }
         else
         {LinkedList<int[]> ll=new LinkedList<int[]>();
          ll.add(c);
             hm.put(b1, ll);}
         /////////
        }

        //System.out.println(vtx[1].size());



        Set keys = hm.keySet();
        //System.out.println(keys);
        for (Integer key: hm.keySet() )
        {if(bool ==true)
        {d.put(key, 0); bool = false;}

        else
            {d.put(key, Integer.MAX_VALUE);}

         heap.add_elements((int)key, (int)d.get(key));
            }

     ///////////////////////now while loop matters
        while(ss.size()!=n)
        {a=heap.extract_min();
        //////////////////////////////////////////
        //if(parent.get(a[0])!=Null)
        //{p.put((int) a[0], (int) parent.get(a[0]));}
        ///////////////////////////////

        if(!ss.containsKey(a[0]))
        {ss.put(a[0], a[1]); totalweight=totalweight+a[1];  }
        LinkedList ll = new LinkedList();

        ll= hm.get(a[0]);
        for(int i=0; i<ll.size(); i++)
        {   int []x = (int[]) ll.get(i);
            int w = x[1];
            //System.out.println("xxxs are here");
            //System.out.println(x[0]);
            //if(d.get(x[0])==Null)
            //{break;}
            //System.out.println(d.get(x[0]));
            if(!ss.containsKey(x[0]))
            {if(w< (int) d.get(x[0]))
            {d.put(x[0],  w);
            parent.put(x[0], a[0]);
            heap.key_decrease(x[0], (int) d.get(x[0]));
            }}
        }
        f.add(parent.get(a[0])); f.add(a[0]);}

        //System.out.println(totalweight);
        //System.out.println(ss);
        //System.out.println(f);


        /////////////////waiting for bus
        PrintWriter printWriter = new PrintWriter ("output.txt");
        printWriter.println (totalweight);
        for(int i=2; i<f.size()-1; i++)
        {printWriter.println ( f.get(i)+ " "+ f.get(i+1) + " " + ss.get(f.get(i+1))); i=i+1 ;}
        printWriter.close ();
    ////////////////waiting for bus

        ////////////////////////////////////////////////////////////////////////////// succesful with hashmap

    }




}
