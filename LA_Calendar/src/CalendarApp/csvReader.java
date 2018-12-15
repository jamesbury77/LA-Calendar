package CalendarApp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class csvReader {

	public static void main(String[] args){
		String csvFile = "/Users/katherinegriffin/Downloads/responses1.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        HashMap<Integer, LA[]> avail = new HashMap<Integer, LA[]>();
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] resources = line.split(cvsSplitBy);

                LA la = new LA(resources[0], Integer.parseInt(resources[1]));
                
                for (int i = 2; i < resources.length; i++)
                	System.out.println(resources[i] + '\n');

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

		
	}
}
