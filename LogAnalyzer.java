/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
/*
 * 1) 18, 14, 10 
 * 2) private Person[] people;
 * 3) private boolean[] vacant;
 * 5) private int[] counts;
 *    private boolean[] occupied;
 * 6) - readings = new double[60];
 *    - urls = new String[90];
 *    - machines = new TicketMachines[5];
 * 7) 20
 * 8) prices = new double[50];
 * 9) index 24 out of bounds for length
 *
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String filename) //Ex 12
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader(filename);
    }
    
    public void printGreater(double mean) { //Ex 11
    double[] marks = {1.3, 5.5, 7.8};    
    int index=0;
    for(index = 0; index < marks.length; index++) {
    if(marks[index] > mean) {
    System.out.println(marks[index]);
    } } }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
      public void printHourlyCounts()
    {
        System.out.println("Hr: Count"); //Ex 10
        int hour = 0;
        while( hour < hourCounts.length){
        System.out.println(hour + ": " + hourCounts[hour]);
        hour++;
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
