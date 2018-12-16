package CalendarApp;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class csvReader {

	public static void main(String[] args){
		String csvFile = "responses1.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<LA> avail = new ArrayList<LA>();
        HashMap<String, Integer>time = setTimeValues();
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] resources = line.split(cvsSplitBy);

                LA la = new LA(resources[0], Integer.parseInt(resources[1]));
               
                for (int i = 2; i < resources.length; i++){
                	if (time.containsKey(resources[i])){
                		avail.add(time.get(resources[i]), la);
                		System.out.printl);
                		}
                		
                	}
                }
            Arrays.toString(avail.toArray());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }
		
	}
	
	
	public static HashMap<String, Integer> setTimeValues(){
		HashMap<String, Integer> time = new HashMap<String, Integer>();
		String csvFile = "time.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int i = 0;
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
            	String[] set = line.split(cvsSplitBy);
                time.put(set[0], i);
                i++;
               
                }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
	}
        return time;
}
	

}
