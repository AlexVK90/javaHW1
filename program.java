import java.io.*;


public class program {

   

    public static void main(String[] args) { 
        int [] data = readData();
        int a = data[0];
        int b = data[1];
        Integer result = getResult(a, b);
        writeResult(result); 
          
       
    }

    public static int[] readData() {
        int[] data = new int[2];
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                int number = Integer.parseInt(line.substring(2, line.length()));
                if (line.startsWith("a")) {
                    data[0] = number;
                } else {
                    data[1] = number;
                }
            }
            br.close();
            
        } 
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }
    
    public static Integer getResult(int a, int b) {
        int result =1;
        if (a==0 && b==0) return null;
        while (b!=0){
            result*=a;
            b--;
        }
        return result;
    }

    public static void writeResult(Integer result) {
        try (FileWriter fw = new FileWriter("output.txt", false)) {
            if (result==null) fw.write("не определен");
            else fw.write(String.valueOf(result));
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }



}