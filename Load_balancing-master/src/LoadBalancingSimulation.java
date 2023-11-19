import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Processor {
    private double load;
    
    public Processor(double load) {
        this.load = load;
    }
    
    public double getLoad() {
        return load;
    }
    
    public void executeTask(double taskLoad) {
        load += taskLoad;
    }
}

class LoadBalancer {
    private static final Random random = new Random();
    private double thresholdP;
    private double thresholdR;
    private double thresholdZ;
    private List<Processor> processors;
    private int totalQueries;
    private int totalMigrations;
    
    public LoadBalancer(double thresholdP, double thresholdR, double thresholdZ, int N) {
        this.thresholdP = thresholdP;
        this.thresholdR = thresholdR;
        this.thresholdZ = thresholdZ;
        this.processors = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            processors.add(new Processor(0.0));
        }
        this.totalQueries = 0;
        this.totalMigrations = 0;
    }
    
    public void simulate(int numTasks) {
        for (int i = 0; i < numTasks; i++) {
            Processor source = getRandomProcessor();
            double taskLoad = generateTaskLoad();
            
            if (source.getLoad() <= thresholdP) {
                Processor target = getRandomProcessor();
                boolean migrated = false;
                
                for (int j = 0; j < processors.size(); j++) {
                    if (target.getLoad() <= thresholdP) {
                        target.executeTask(taskLoad);
                        migrated = true;
                        break;
                    }
                    target = getRandomProcessor();
                }
                
                if (!migrated) {
                    source.executeTask(taskLoad);
                }
            } else if (source.getLoad() > thresholdP && source.getLoad() <= thresholdR) {
                Processor target = getRandomProcessor();
                boolean migrated = false;
                
                for (int j = 0; j < processors.size(); j++) {
                    if (target.getLoad() <= thresholdP) {
                        target.executeTask(taskLoad);
                        migrated = true;
                        totalMigrations++;
                        break;
                    }
                    target = getRandomProcessor();
                }
                
                if (!migrated) {
                    source.executeTask(taskLoad);
                }
            } else if (source.getLoad() > thresholdR && source.getLoad() <= thresholdZ) {
                Processor target = getRandomProcessor();
                boolean migrated = false;
                
                for (int j = 0; j < processors.size(); j++) {
                    if (target.getLoad() > thresholdP) {
                        double transferLoad = (source.getLoad() - thresholdZ) / 2;
                        target.executeTask(transferLoad);
                        source.executeTask(-transferLoad);
                        migrated = true;
                        totalMigrations++;
                        break;
                    }
                    target = getRandomProcessor();
                }
                
                if (!migrated) {
                    source.executeTask(taskLoad);
                }
            } else {
                source.executeTask(taskLoad);
            }
            
            totalQueries++;
        }
    }
    
    public double getAverageLoad() {
        double totalLoad = 0.0;
        for (Processor processor : processors) {
            totalLoad += processor.getLoad();
        }
        return totalLoad / processors.size();
    }
    
    public double getAverageDeviation(double averageLoad) {
        double totalDeviation = 0.0;
        for (Processor processor : processors) {
            totalDeviation += Math.abs(processor.getLoad() - averageLoad);
        }
        return totalDeviation / processors.size();
    }
    
    public int getTotalQueries() {
        return totalQueries;
    }
    
    public int getTotalMigrations() {
        return totalMigrations;
    }
    
    private Processor getRandomProcessor() {
        int index = random.nextInt(processors.size());
        return processors.get(index);
    }
    
    private double generateTaskLoad() {
        // Przykładowa generacja losowego obciążenia zadania
        return random.nextDouble() * 5.0;  // Zakres: [0, 5)
    }
}

public class LoadBalancingSimulation {
    public static void main(String[] args) {
        double thresholdP = 0.5;
        double thresholdR = 0.7;
        double thresholdZ = 0.9;
        int numProcessors = 50;
        int numTasks = 10000;
        
        LoadBalancer loadBalancer = new LoadBalancer(thresholdP, thresholdR, thresholdZ, numProcessors);
        loadBalancer.simulate(numTasks);
        
        double averageLoad = loadBalancer.getAverageLoad();
        double averageDeviation = loadBalancer.getAverageDeviation(averageLoad);
        int totalQueries = loadBalancer.getTotalQueries();
        int totalMigrations = loadBalancer.getTotalMigrations();
        
        System.out.println("Average Load: " + averageLoad);
        System.out.println("Average Deviation: " + averageDeviation);
        System.out.println("Total Queries: " + totalQueries);
        System.out.println("Total Migrations: " + totalMigrations);
    }
}
