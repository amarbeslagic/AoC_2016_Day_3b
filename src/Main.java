import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("inputs//input_AoC_3b.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        List<String> listOfStrings = new ArrayList<>();

        String s;
        //put Strings in array
        while ((s = br.readLine()) != null) {
            if (s.isBlank()) continue;

            listOfStrings.add(s);
        }

        int impossibleTriangle = 0;

        List<String>lista = new ArrayList<>();

        List<String> removeCollection = new ArrayList<>();
        removeCollection.add("");

        for(String str : listOfStrings){
            String [] listOfThreeNumber = str.split(" ");
            
            for(String strin : listOfThreeNumber)
                lista.add(strin);

            lista.removeAll(removeCollection);
        }

        for(int i=0; i<lista.size()-8; i+=9){

            int aa = Integer.parseInt(lista.get(i));
            int ab = Integer.parseInt(lista.get(i+3));
            int ac = Integer.parseInt(lista.get(i+6));

            if(aa + ab <= ac || ab + ac <= aa || aa + ac <= ab) impossibleTriangle++;

            int ba = Integer.parseInt(lista.get(i+1));
            int bb = Integer.parseInt(lista.get(i+4));
            int bc = Integer.parseInt(lista.get(i+7));

            if(ba + bb <= bc || bb + bc <= ba || ba + bc <= bb) impossibleTriangle++;


            int ca = Integer.parseInt(lista.get(i+2));
            int cb = Integer.parseInt(lista.get(i+5));
            int cc = Integer.parseInt(lista.get(i+8));

            if(ca + cb <= cc || cb + cc <= ca || ca + cc <= cb) impossibleTriangle++;
        }

        int sizeOfListString = listOfStrings.size();
        System.out.println("Number of possible triangles: " + (sizeOfListString - impossibleTriangle));
    }
}