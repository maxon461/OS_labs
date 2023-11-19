import java.util.Vector;
import java.util.Collections;

public class App {
    static int size = 8;
    static int disk_size = 200;

    static void FCFS(int arr[], int head)
{
    int seek_count = 0;
    int distance, cur_track;
 
    for (int i = 0; i < size; i++)
    {
        cur_track = arr[i];
 
        
        distance = Math.abs(cur_track - head);
 
        
        seek_count += distance;
 
        
        head = cur_track;
    }
 
    System.out.println("Total number of " +
                       "seek operations = " +
                        seek_count);
 
    
    System.out.println("Seek Sequence is");
 
    for (int i = 0; i < size; i++)
    {
        System.out.println(arr[i]);
    }
}


    static void SCAN(int arr[], int head, String direction)
{
    int seek_count = 0;
    int distance, cur_track;
    Vector<Integer> left = new Vector<Integer>(),
                    right = new Vector<Integer>();
    Vector<Integer> seek_sequence = new Vector<Integer>();
 
    
    if (direction == "left")
        left.add(0);
    else if (direction == "right")
        right.add(disk_size - 1);
 
    for (int i = 0; i < size; i++)
    {
        if (arr[i] < head)
            left.add(arr[i]);
        if (arr[i] > head)
            right.add(arr[i]);
    }
 
    
    Collections.sort(left);
    Collections.sort(right);
 
   
    int run = 2;
    while (run-- >0)
    {
        if (direction == "left")
        {
            for (int i = left.size() - 1; i >= 0; i--)
            {
                cur_track = left.get(i);
 
                
                seek_sequence.add(cur_track);
 
               
                distance = Math.abs(cur_track - head);
 
                
                seek_count += distance;
 
                
                head = cur_track;
            }
            direction = "right";
        }
        else if (direction == "right")
        {
            for (int i = 0; i < right.size(); i++)
            {
                cur_track = right.get(i);
                 
                
                seek_sequence.add(cur_track);
 
                
                distance = Math.abs(cur_track - head);
 
                
                seek_count += distance;
                
                head = cur_track;
            }
            direction = "left";
        }
    }
 
    System.out.print("Total number of seek operations = "
                        + seek_count + "\n");
 
    System.out.print("Seek Sequence is" + "\n");
 
    for (int i = 0; i < seek_sequence.size(); i++)
    {
        System.out.print(seek_sequence.get(i) + "\n");
    }
}

public static void CSCAN(int arr[], int head)
    {
        int seek_count = 0;
        int distance, cur_track;
  
        Vector<Integer> left = new Vector<Integer>();
        Vector<Integer> right = new Vector<Integer>();
        Vector<Integer> seek_sequence
            = new Vector<Integer>();
  
        
        left.add(0);
        right.add(disk_size - 1);
  
        
        for (int i = 0; i < size; i++) {
            if (arr[i] < head)
                left.add(arr[i]);
            if (arr[i] > head)
                right.add(arr[i]);
        }
  
        
        Collections.sort(left);
        Collections.sort(right);
  
        
        for (int i = 0; i < right.size(); i++) {
            cur_track = right.get(i);
  
            
            seek_sequence.add(cur_track);
  
            
            distance = Math.abs(cur_track - head);
  
            
            seek_count += distance;
  
            
            head = cur_track;
        }
  
        
        head = 0;
  
        
        // seek_count += (disk_size - 1);
  
        
        for (int i = 0; i < left.size(); i++) {
            cur_track = left.get(i);
  
           
            seek_sequence.add(cur_track);
  
            
            distance = Math.abs(cur_track - head);

          
            seek_count += distance;
  
            
            head = cur_track;
        }
  
        System.out.println("Total number of seek "
                           + "operations = " + seek_count);
  
        System.out.println("Seek Sequence is");
  
        for (int i = 0; i < seek_sequence.size(); i++) {
            System.out.println(seek_sequence.get(i));
        }
    }


    public static void main(String[] args) throws Exception {
        int[] arr = {98,183,37,122,14,124,65,67};
        int head = 53;
        String direction = "left";
        FCFS(arr, head);
        SSTF sstf = new SSTF();
        sstf.shortestSeekTimeFirst(arr, head);
        SCAN(arr, head , direction);
        CSCAN(arr, head);

    }
}
