
//Filename GameSaveFile.java
//Written by Brady Bierman
//Written on 10/12/24

import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;


public class CreateSaveFile {



    public static void main(String[] args) {
        
        String File_Name = ".\\Game_Save";
        final String Player_File_Name_tmplt = "EMPTY_SAVE          ";
        final String Delimiter = ",";
        final String Winnings_tmplt = "0         ";
        String S = Player_File_Name_tmplt + Delimiter + Winnings_tmplt + System.getProperty("line.separator");
        final int Rec_Size = S.length();

        Path Save_File = Paths.get(File_Name);


        Create_Empty_File(Save_File, S);




    }






    public static void Create_Empty_File(Path file, String S){

        final int Numrecs = 30;
        try{

            OutputStream outputStr = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStr));

            for(int count = 0; count < Numrecs; ++count)
                writer.write(S, 0, S.length());

            writer.close();

        }

        catch(Exception e){

            System.out.println("Error message: " + e);

        }

    }




    
}
