
//Filename GameBase.java
//Written by Brady Bierman
//Written on 10/12/24


import java.nio.file.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;
import java.text.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DealOrNoDeal extends JFrame implements ActionListener {
    
    final static int Money_Values[] = {1, 10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000, 500000, 1000000};
    static String Player_Name = "";
    static int Locked_Box = 0 ;
    static boolean Corectly_Chosen = false;
    static boolean Box_Filled[] = {false, false, false, false, false, false, false, false, false, false, false, false};
    static boolean Accept_Offer = false;
    static int offer = 0;
    static ArrayList<Box> Boxes = new ArrayList<Box>();
    static boolean Play_Game = true;
    static boolean Player_Selected = false;
    static String Message = "";
    static int Round_Num = 0;
    static String spaces = "                                                                                                      ";
    static String Locked = "Locked";
    static String Removed = "Removed";
    static int Cases_Removed = 0;
    static StringBuffer Out_String = new StringBuffer();
    static boolean Yes_No = false;
    static int Num_Of_Saves = 0;
    static ArrayList<String> Button_Name = new ArrayList<String>();
    static ArrayList<String> Player_Name_Array = new ArrayList<String>();
    static ArrayList<Integer> Player_Money_Array = new ArrayList<Integer>();
    static int Player_Save_ID = 0;
    static boolean Final_round = false;
    static boolean Player_Has_Save = false;
    static int Rec_Size = 0;
    static String Player_File_Name_tmplt = "EMPTY_SAVE          ";
    static String Delimiter = ",";
    static String Winnings_tmplt = "          ";
    static int PLayer_Winnings = 0;
    static int Next_Empty_save = 0;
    static boolean Empty_Save_found = false;

    static String File_Name = ".\\Game_Save";
    static Path Save_File = Paths.get(File_Name);


    JButton Case_1Button = new JButton("Case 1");
    JButton Case_2Button = new JButton("Case 2");
    JButton Case_3Button = new JButton("Case 3");
    JButton Case_4Button = new JButton("Case 4");
    JButton Case_5Button = new JButton("Case 5");
    JButton Case_6Button = new JButton("Case 6");
    JButton Case_7Button = new JButton("Case 7");
    JButton Case_8Button = new JButton("Case 8");
    JButton Case_9Button = new JButton("Case 9");
    JButton Case_10Button = new JButton("Case 10");
    JButton Case_11Button = new JButton("Case 11");
    JButton Case_12Button = new JButton("Case 12");
    JButton Confirm = new JButton("Confirm");
    JButton New_Player = new JButton("New Player");
    JButton Returning_Player = new JButton("Returning Player");
    JButton Yes = new JButton("Yes");
    JButton No = new JButton("No");
    JButton Player_Save_1 = new JButton("");
    JButton Player_Save_2 = new JButton("");
    JButton Player_Save_3 = new JButton("");
    JButton Player_Save_4 = new JButton("");
    JButton Player_Save_5 = new JButton("");
    JButton Player_Save_6 = new JButton("");
    JButton Player_Save_7 = new JButton("");
    JButton Player_Save_8 = new JButton("");
    JButton Player_Save_9 = new JButton("");
    JButton Player_Save_10 = new JButton("");
    JButton Player_Save_11 = new JButton("");
    JButton Player_Save_12 = new JButton("");
    JButton Player_Save_13 = new JButton("");
    JButton Player_Save_14 = new JButton("");
    JButton Player_Save_15 = new JButton("");
    JButton Player_Save_16 = new JButton("");
    JButton Player_Save_17 = new JButton("");
    JButton Player_Save_18 = new JButton("");
    JButton Player_Save_19 = new JButton("");
    JButton Player_Save_20 = new JButton("");
    JButton Player_Save_21 = new JButton("");
    JButton Player_Save_22 = new JButton("");
    JButton Player_Save_23 = new JButton("");
    JButton Player_Save_24 = new JButton("");
    JButton Player_Save_25 = new JButton("");
    JButton Player_Save_26 = new JButton("");
    JButton Player_Save_27 = new JButton("");
    JButton Player_Save_28 = new JButton("");
    JButton Player_Save_29 = new JButton("");
    JButton Player_Save_30 = new JButton("");
    JButton Keep = new JButton("Keep");
    JButton Switch = new JButton("Switch");


    JLabel Game_Title_Label = new JLabel("");
    JTextField Player_name_entry = new JTextField(15);
    JLabel Message_to_Player_1 = new JLabel("");
    JLabel Message_to_Player_2 = new JLabel("");
    JLabel Message_to_Player_3 = new JLabel("");
    JLabel Message_to_Player_4 = new JLabel("");
    JLabel Spacer = new JLabel(spaces);
    JLabel Spacer2 = new JLabel(spaces);
    JLabel Spacer3 = new JLabel(spaces);
    JLabel Spacer4 = new JLabel(spaces);
    JLabel Spacer5 = new JLabel(spaces);
    JLabel Spacer6 = new JLabel(spaces);
    JLabel Spacer7 = new JLabel(spaces);
    JLabel Spacer8 = new JLabel(spaces);
    JLabel Spacer9 = new JLabel(spaces);
    JLabel Values_Removed = new JLabel("");
    JPanel Pannel_0 = new JPanel();
    JPanel Pannel_1 = new JPanel();
    JPanel Pannel_2 = new JPanel();
    JPanel Pannel_3 = new JPanel();
    JPanel Pannel_4 = new JPanel();
    JPanel Pannel_5 = new JPanel();
    JPanel Pannel_6 = new JPanel();
    JPanel Pannel_7 = new JPanel();
    JPanel Pannel_8 = new JPanel();
    JPanel Pannel_9 = new JPanel();
    JPanel Pannel_10 = new JPanel();
    JPanel Pannel_11 = new JPanel();
    JPanel Pannel_12 = new JPanel();
    JPanel Pannel_13 = new JPanel();
    JPanel Pannel_14 = new JPanel();


    



    public static void main(String[] args) {
        
        
        Out_String.append(" ");

        

        
        for (int i= 0; i < 12; ++i) {

            Boxes.add(null);
            
        }
        
        
        
        String S = Player_File_Name_tmplt + Delimiter + Winnings_tmplt + System.getProperty("line.separator");
        Rec_Size = S.length();
        

        


        String[] array = new String[2];


      //read Game_Save file
        try{

                InputStream iStream = new BufferedInputStream(Files.newInputStream(Save_File));
                BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
                System.out.println("\nAll non-default records:\n");
                S = reader.readLine();

                while (S != null) {

                    array = S.split(Delimiter);

                    String Temp = array[0];
                    StringBuilder Temp2 = new StringBuilder();
                    for (int i = 0; i < Temp.length(); i++) {
                        if (Temp.charAt(i) != ' ') {
                            Temp2.append(Temp.charAt(i));
                        }
                    }
                    Player_Name_Array.add(Temp2.toString());

                    Temp = array[1];
                    StringBuilder Temp3 = new StringBuilder();
                    for (int i = 0; i < Temp.length(); i++) {
                        if (Temp.charAt(i) != ' ') {
                            Temp3.append(Temp.charAt(i));
                        }
                    }
                    Player_Money_Array.add(Integer.parseInt(Temp3.toString()));
                    Button_Name.add(Temp2 + " Lifetime Winnings $" + Temp3);
                    
                    if (array[0] == Player_File_Name_tmplt && !Empty_Save_found) {
                        Next_Empty_save++;
                        Empty_Save_found = true;
                        
                    }
                    S = reader.readLine();
                }
            }

            catch(Exception e){

                System.out.println("Message: " + e);

            }




        DealOrNoDeal aFrame = new DealOrNoDeal();
        final int WIDTH = 1080;
        final int Height = 1080;
        aFrame.setSize(WIDTH, Height);
        aFrame.setVisible(true);
        

    }


    
    

    //generate the boxes
    public static void Randomize_Boxes(){

        boolean While_bool = false;
        Random rand = new Random();

        for(int x = 0; x < Boxes.size(); ++x){

            While_bool = false;
            while(!While_bool){

                int Rand_Box = rand.nextInt(12);
                if(Box_Filled[Rand_Box] == false){

                    Boxes.set(x, new Box(x + 1, Money_Values[Rand_Box]));
                    While_bool = true;
                    Box_Filled[Rand_Box] = true;

                }
               

            }
            

        }


    }

   


    //generate offer
    public static void Give_Offer(){

        double Offer_addition = 0;
        int Num_Of_Money = 0;

        //parse boxes to get what money values remain and add them
        for(int x = 0; x < Boxes.size(); ++x ){

            if(!Boxes.get(x).Get_Picked()){
                Offer_addition += Boxes.get(x).Get_Money();
                Num_Of_Money++;
            }

        }

        //divide the number of enrties from the total
        Offer_addition += Boxes.get(Locked_Box).Get_Money();
        Offer_addition = Offer_addition / Num_Of_Money;
        offer = (int)Offer_addition;


    }



    public static void Save_Game(Path File_Name){

        try {

            FileChannel Save_The_File = (FileChannel)Files.newByteChannel(File_Name, CREATE, WRITE);

            if (Player_Has_Save) {
                Save_The_File.position(Player_Save_ID * Rec_Size);

                int Entry_Length = Player_File_Name_tmplt.length();
                String Name_L= Player_Name_Array.get(Player_Save_ID);
                int Name_Length = Name_L.length();
                int Missing_Spaces = (Name_Length - Entry_Length);
                StringBuilder SB = new StringBuilder(Player_Name);
                //if the string is longer than name length, truncate it

                if (Entry_Length > Name_Length) {

                    SB.setLength(Name_Length);
                        
                }

                else{

                    SB.append(" ".repeat(Missing_Spaces));

                }

                Entry_Length = Winnings_tmplt.length();
                int Money_Length = Player_Money_Array.get(Player_Save_ID);
                Missing_Spaces = (Money_Length - Entry_Length);
                StringBuilder MoneyST = new StringBuilder(PLayer_Winnings);
                //if the string is longer than name length, truncate it

                if (Entry_Length > Name_Length) {

                    MoneyST.setLength(Name_Length);
                        
                }

                else{

                    MoneyST.append(" ".repeat(Missing_Spaces));

                }

                String S = SB.toString() + Delimiter + MoneyST.toString() + System.getProperty("line.separator");
                byte data[] = S.getBytes();
                ByteBuffer buffer = ByteBuffer.wrap(data);

                Save_The_File.write(buffer);

            }
            else{

                Save_The_File.position((Next_Empty_save - 1) * Rec_Size);

                int Entry_Length = Player_File_Name_tmplt.length();
                String Name_L= Player_Name_Array.get(Player_Save_ID);
                int Name_Length = Name_L.length();
                int Missing_Spaces = (Name_Length - Entry_Length);
                StringBuilder SB = new StringBuilder(Player_Name);
                //if the string is longer than name length, truncate it

                if (Entry_Length > Name_Length) {

                    SB.setLength(Name_Length);
                        
                }

                else{

                    SB.append(" ".repeat(Missing_Spaces));

                }

                Entry_Length = Winnings_tmplt.length();
                int Money_Length = Player_Money_Array.get(Player_Save_ID);
                Missing_Spaces = (Money_Length - Entry_Length);
                StringBuilder MoneyST = new StringBuilder(PLayer_Winnings);
                //if the string is longer than name length, truncate it

                if (Entry_Length > Name_Length) {

                    MoneyST.setLength(Name_Length);
                        
                }

                else{

                    MoneyST.append(" ".repeat(Missing_Spaces));

                }

                String S = SB.toString() + Delimiter + MoneyST.toString() + System.getProperty("line.separator");
                byte data[] = S.getBytes();
                ByteBuffer buffer = ByteBuffer.wrap(data);

                Save_The_File.write(buffer);

            }
            
            Save_The_File.close();
            
        } 
        
        catch (Exception e) {
            System.out.println("Error message: " + e);
        }

    }


    
    public DealOrNoDeal(){

        super("Deal or No Deal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        add(Pannel_0);
        Pannel_0.add(Spacer);
        Pannel_0.add(Spacer2);

        add(Pannel_8);

        add(Pannel_9);
        Pannel_9.add(Spacer6);

        add(Pannel_1);

        add(Pannel_2);
        Pannel_2.add(Spacer3);

        add(Pannel_3);

        add(Pannel_4);
        Pannel_4.add(Spacer4);

        add(Pannel_5);

        add(Pannel_6);
        Pannel_6.add(Spacer5);

        add(Pannel_7);

        add(Pannel_10);

        add(Pannel_11);

        add(Pannel_12);

        add(Pannel_13);

        add(Pannel_14);
        
        
        Message = "Hello, are you a returning player?";
        Message_to_Player_1.setText(Message);

        Pannel_1.add(Message_to_Player_1);
        Pannel_1.add(New_Player);
        Pannel_1.add(Returning_Player);


        Case_1Button.addActionListener(this);
        Case_2Button.addActionListener(this);
        Case_3Button.addActionListener(this);
        Case_4Button.addActionListener(this);
        Case_5Button.addActionListener(this);
        Case_6Button.addActionListener(this);
        Case_7Button.addActionListener(this);
        Case_8Button.addActionListener(this);
        Case_9Button.addActionListener(this);
        Case_10Button.addActionListener(this);
        Case_11Button.addActionListener(this);
        Case_12Button.addActionListener(this);
        Confirm.addActionListener(this);
        New_Player.addActionListener(this);
        Returning_Player.addActionListener(this);
        Player_Save_1.addActionListener(this);
        Player_Save_2.addActionListener(this);
        Player_Save_3.addActionListener(this);
        Player_Save_4.addActionListener(this);
        Player_Save_5.addActionListener(this);
        Player_Save_6.addActionListener(this);
        Player_Save_7.addActionListener(this);
        Player_Save_8.addActionListener(this);
        Player_Save_9.addActionListener(this);
        Player_Save_10.addActionListener(this);
        Player_Save_11.addActionListener(this);
        Player_Save_12.addActionListener(this);
        Player_Save_13.addActionListener(this);
        Player_Save_14.addActionListener(this);
        Player_Save_15.addActionListener(this);
        Player_Save_16.addActionListener(this);
        Player_Save_17.addActionListener(this);
        Player_Save_18.addActionListener(this);
        Player_Save_19.addActionListener(this);
        Player_Save_20.addActionListener(this);
        Player_Save_21.addActionListener(this);
        Player_Save_22.addActionListener(this);
        Player_Save_23.addActionListener(this);
        Player_Save_24.addActionListener(this);
        Player_Save_25.addActionListener(this);
        Player_Save_26.addActionListener(this);
        Player_Save_27.addActionListener(this);
        Player_Save_28.addActionListener(this);
        Player_Save_29.addActionListener(this);
        Player_Save_30.addActionListener(this);
        Keep.addActionListener(this);
        Switch.addActionListener(this);
        Yes.addActionListener(this);
        No.addActionListener(this);


        Player_Save_1.setText(Button_Name.get(0));
        Player_Save_2.setText(Button_Name.get(1));
        Player_Save_3.setText(Button_Name.get(2));
        Player_Save_4.setText(Button_Name.get(3));
        Player_Save_5.setText(Button_Name.get(4));
        Player_Save_6.setText(Button_Name.get(5));
        Player_Save_7.setText(Button_Name.get(6));
        Player_Save_8.setText(Button_Name.get(7));
        Player_Save_9.setText(Button_Name.get(8));
        Player_Save_10.setText(Button_Name.get(9));
        Player_Save_11.setText(Button_Name.get(10));
        Player_Save_12.setText(Button_Name.get(11));
        Player_Save_13.setText(Button_Name.get(12));
        Player_Save_14.setText(Button_Name.get(13));
        Player_Save_15.setText(Button_Name.get(14));
        Player_Save_16.setText(Button_Name.get(15));
        Player_Save_17.setText(Button_Name.get(16));
        Player_Save_18.setText(Button_Name.get(17));
        Player_Save_19.setText(Button_Name.get(18));
        Player_Save_20.setText(Button_Name.get(19));
        Player_Save_21.setText(Button_Name.get(20));
        Player_Save_22.setText(Button_Name.get(21));
        Player_Save_23.setText(Button_Name.get(22));
        Player_Save_24.setText(Button_Name.get(23));
        Player_Save_25.setText(Button_Name.get(24));
        Player_Save_26.setText(Button_Name.get(25));
        Player_Save_27.setText(Button_Name.get(26));
        Player_Save_28.setText(Button_Name.get(27));
        Player_Save_29.setText(Button_Name.get(28));
        Player_Save_30.setText(Button_Name.get(29));
        



    }


    @Override
    public void actionPerformed(ActionEvent e){

        Object source = e.getSource();
        
        

        if (source == New_Player) {

            Pannel_1.add(Player_name_entry);

            Message = "Enter your desired player name(no spaces allowed, they will be removed): ";
            Message_to_Player_1.setText(Message);
            Pannel_1.add(Confirm);

            Pannel_1.remove(New_Player);
            Pannel_1.remove(Returning_Player);
            Pannel_1.revalidate();
            Pannel_1.repaint();
            

            
            
        }

        if (source == Returning_Player) {
            
            Message_to_Player_1.setText("Please select your save file");
            Player_Has_Save = true;

            //add save file select
            Pannel_3.add(Player_Save_1);
            Pannel_3.add(Player_Save_2);
            Pannel_3.add(Player_Save_3);
            Pannel_4.add(Player_Save_4);
            Pannel_4.add(Player_Save_5);
            Pannel_4.add(Player_Save_6);
            Pannel_5.add(Player_Save_7);
            Pannel_5.add(Player_Save_8);
            Pannel_5.add(Player_Save_9);
            Pannel_6.add(Player_Save_10);
            Pannel_6.add(Player_Save_11);
            Pannel_6.add(Player_Save_12);
            Pannel_7.add(Player_Save_13);
            Pannel_7.add(Player_Save_14);
            Pannel_7.add(Player_Save_15);
            Pannel_10.add(Player_Save_16);
            Pannel_10.add(Player_Save_17);
            Pannel_10.add(Player_Save_18);
            Pannel_11.add(Player_Save_19);
            Pannel_11.add(Player_Save_20);
            Pannel_11.add(Player_Save_21);
            Pannel_12.add(Player_Save_22);
            Pannel_12.add(Player_Save_23);
            Pannel_12.add(Player_Save_24);
            Pannel_13.add(Player_Save_25);
            Pannel_13.add(Player_Save_26);
            Pannel_13.add(Player_Save_27);
            Pannel_14.add(Player_Save_28);
            Pannel_14.add(Player_Save_29);
            Pannel_14.add(Player_Save_30);


            Pannel_4.remove(Spacer4);
            Pannel_6.remove(Spacer5);

            //update everything
            Pannel_1.remove(New_Player);
            Pannel_1.remove(Returning_Player);
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
            

        }

        if (source == Confirm) {

            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            Player_Name = Player_name_entry.getText();
            Message = "Select a Case from the group of cases to lock";
            Message_to_Player_1.setText(Message);
            Message = Player_Name + " Lifetime Winnings $0";
            Message_to_Player_4.setText(Message);
            

            Pannel_1.remove(Confirm);
            Pannel_1.remove(Player_name_entry);
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            
        }   
            //cases buttons/logic
        if (source == Case_1Button) {

            if (!Yes_No) { 
                if (Round_Num == 0) {
                    
                    Message = "You have selected Case 1 as your locked case";
                    Message_to_Player_2.setText(Message);
                    Pannel_7.add(Message_to_Player_2);
                    Round_Num = 1;
                    Case_1Button.setText(Locked);
                    Boxes.get(0).Set_Picked();
                    Boxes.get(0).Set_Locked();
                    Message_to_Player_1.setText("Select 2 cases to be removed");

                    Pannel_1.revalidate();
                    Pannel_1.repaint();
                    Pannel_3.revalidate();
                    Pannel_3.repaint();
                    Pannel_7.revalidate();
                    Pannel_7.repaint();
                }           
                if (Round_Num == 1 && !Boxes.get(0).Get_Picked()) {

                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("Select another case to be removed");
                        Case_1Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(0).Set_Picked();
                        Out_String.append(Boxes.get(0).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_1Button.setText(Removed);
                        Boxes.get(0).Set_Picked();
                        Out_String.append(Boxes.get(0).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                        
                }
                if (Round_Num == 2 && !Boxes.get(0).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("Select another case to be removed");
                        Case_1Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(0).Set_Picked();
                        Out_String.append(Boxes.get(0).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("Select another case to be removed");
                        Case_1Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(0).Set_Picked();
                        Out_String.append(Boxes.get(0).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_1Button.setText(Removed);
                        Boxes.get(0).Set_Picked();
                        Out_String.append(Boxes.get(0).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 3 && !Boxes.get(0).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("Select another case to be removed");
                        Case_1Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(0).Set_Picked();
                        Out_String.append(Boxes.get(0).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("Select another case to be removed");
                        Case_1Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(0).Set_Picked();
                        Out_String.append(Boxes.get(0).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_1Button.setText(Removed);
                        Boxes.get(0).Set_Picked();
                        Out_String.append(Boxes.get(0).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 4 && !Boxes.get(0).Get_Picked()) {
    
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("Select another case to be removed");
                        Case_1Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(0).Set_Picked();
                        Out_String.append(Boxes.get(0).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                            Yes_No = true;
                        Case_1Button.setText(Removed);
                        Boxes.get(0).Set_Picked();
                        Out_String.append(Boxes.get(0).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        Final_round = true;

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
            }
        }

        if (source == Case_2Button) {
            if (!Yes_No) {
                if (Round_Num == 0) {
                    
                    Message = "You have selected Case 2 as your locked case";
                    Message_to_Player_2.setText(Message);
                    Pannel_7.add(Message_to_Player_2);
                    Round_Num = 1;
                    Case_2Button.setText(Locked);
                    Boxes.get(1).Set_Picked();
                    Boxes.get(1).Set_Locked();
                    Message_to_Player_1.setText("Select 2 cases to be removed");

                    Pannel_1.revalidate();
                    Pannel_1.repaint();
                    Pannel_3.revalidate();
                    Pannel_3.repaint();
                    Pannel_7.revalidate();
                    Pannel_7.repaint();
                }           
                if (Round_Num == 1 && !Boxes.get(1).Get_Picked()) {

                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 2, select another case to be removed");
                        Case_2Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(1).Set_Picked();
                        Out_String.append(Boxes.get(1).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_2Button.setText(Removed);
                        Boxes.get(1).Set_Picked();
                        Out_String.append(Boxes.get(1).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                        
                }
                if (Round_Num == 2 && !Boxes.get(1).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 2, select another case to be removed");
                        Case_2Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(1).Set_Picked();
                        Out_String.append(Boxes.get(1).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 2, select another case to be removed");
                        Case_2Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(1).Set_Picked();
                        Out_String.append(Boxes.get(1).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_2Button.setText(Removed);
                        Boxes.get(1).Set_Picked();
                        Out_String.append(Boxes.get(1).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 3 && !Boxes.get(1).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 2, select another case to be removed");
                        Case_2Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(1).Set_Picked();
                        Out_String.append(Boxes.get(1).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 2, select another case to be removed");
                        Case_2Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(1).Set_Picked();
                        Out_String.append(Boxes.get(1).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_2Button.setText(Removed);
                        Boxes.get(1).Set_Picked();
                        Out_String.append(Boxes.get(1).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 4 && !Boxes.get(1).Get_Picked()) {
    
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 2, select another case to be removed");
                        Case_2Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(1).Set_Picked();
                        Out_String.append(Boxes.get(1).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                            Yes_No = true;
                        Case_2Button.setText(Removed);
                        Boxes.get(1).Set_Picked();
                        Out_String.append(Boxes.get(1).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        Final_round = true;

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
            }
        }

        if (source == Case_3Button) {
            if (!Yes_No) {
                if (Round_Num == 0) {
                    
                    Message = "You have selected Case 3 as your locked case";
                    Message_to_Player_2.setText(Message);
                    Pannel_7.add(Message_to_Player_2);
                    Round_Num = 1;
                    Case_3Button.setText(Locked);
                    Boxes.get(2).Set_Picked();
                    Boxes.get(2).Set_Locked();
                    Message_to_Player_1.setText("Select 2 cases to be removed");

                    Pannel_1.revalidate();
                    Pannel_1.repaint();
                    Pannel_3.revalidate();
                    Pannel_3.repaint();
                    Pannel_7.revalidate();
                    Pannel_7.repaint();
                }           
                if (Round_Num == 1 && !Boxes.get(2).Get_Picked()) {

                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 3, select another case to be removed");
                        Case_3Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(2).Set_Picked();
                        Out_String.append(Boxes.get(2).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_3Button.setText(Removed);
                        Boxes.get(2).Set_Picked();
                        Out_String.append(Boxes.get(2).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                        
                }
                if (Round_Num == 2 && !Boxes.get(2).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 3, select another case to be removed");
                        Case_3Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(2).Set_Picked();
                        Out_String.append(Boxes.get(2).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 3, select another case to be removed");
                        Case_3Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(2).Set_Picked();
                        Out_String.append(Boxes.get(2).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_3Button.setText(Removed);
                        Boxes.get(2).Set_Picked();
                        Out_String.append(Boxes.get(2).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 3 && !Boxes.get(2).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 3, select another case to be removed");
                        Case_3Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(2).Set_Picked();
                        Out_String.append(Boxes.get(2).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 3, select another case to be removed");
                        Case_3Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(2).Set_Picked();
                        Out_String.append(Boxes.get(2).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_3Button.setText(Removed);
                        Boxes.get(2).Set_Picked();
                        Out_String.append(Boxes.get(2).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 4 && !Boxes.get(2).Get_Picked()) {
    
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 3, select another case to be removed");
                        Case_3Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(2).Set_Picked();
                        Out_String.append(Boxes.get(2).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                            Yes_No = true;
                        Case_3Button.setText(Removed);
                        Boxes.get(2).Set_Picked();
                        Out_String.append(Boxes.get(2).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        Final_round = true;

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
            }
        }

        if (source == Case_4Button) {
            if (!Yes_No) {
                if (Round_Num == 0) {
                    
                    Message = "You have selected Case 4 as your locked case";
                    Message_to_Player_2.setText(Message);
                    Pannel_7.add(Message_to_Player_2);
                    Round_Num = 1;
                    Case_4Button.setText(Locked);
                    Boxes.get(3).Set_Picked();
                    Boxes.get(3).Set_Locked();
                    Message_to_Player_1.setText("Select 2 cases to be removed");

                    Pannel_1.revalidate();
                    Pannel_1.repaint();
                    Pannel_3.revalidate();
                    Pannel_3.repaint();
                    Pannel_7.revalidate();
                    Pannel_7.repaint();
                }           
                if (Round_Num == 1 && !Boxes.get(3).Get_Picked()) {

                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 4, select another case to be removed");
                        Case_4Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(3).Set_Picked();
                        Out_String.append(Boxes.get(3).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_4Button.setText(Removed);
                        Boxes.get(3).Set_Picked();
                        Out_String.append(Boxes.get(3).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                        
                }
                if (Round_Num == 2 && !Boxes.get(3).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 4, select another case to be removed");
                        Case_4Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(3).Set_Picked();
                        Out_String.append(Boxes.get(3).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 4, select another case to be removed");
                        Case_4Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(3).Set_Picked();
                        Out_String.append(Boxes.get(3).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_4Button.setText(Removed);
                        Boxes.get(3).Set_Picked();
                        Out_String.append(Boxes.get(3).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 3 && !Boxes.get(3).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 4, select another case to be removed");
                        Case_4Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(3).Set_Picked();
                        Out_String.append(Boxes.get(3).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 4, select another case to be removed");
                        Case_4Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(3).Set_Picked();
                        Out_String.append(Boxes.get(3).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_4Button.setText(Removed);
                        Boxes.get(3).Set_Picked();
                        Out_String.append(Boxes.get(3).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 4 && !Boxes.get(3).Get_Picked()) {
    
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 4, select another case to be removed");
                        Case_4Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(3).Set_Picked();
                        Out_String.append(Boxes.get(3).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                            Yes_No = true;
                        Case_4Button.setText(Removed);
                        Boxes.get(3).Set_Picked();
                        Out_String.append(Boxes.get(3).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        Final_round = true;

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
            }
        }

        if (source == Case_5Button) {
            if (!Yes_No) {
                if (Round_Num == 0) {
                    
                    Message = "You have selected Case 5 as your locked case";
                    Message_to_Player_2.setText(Message);
                    Pannel_7.add(Message_to_Player_2);
                    Round_Num = 1;
                    Case_5Button.setText(Locked);
                    Boxes.get(4).Set_Picked();
                    Boxes.get(4).Set_Locked();
                    Message_to_Player_1.setText("Select 2 cases to be removed");

                    Pannel_1.revalidate();
                    Pannel_1.repaint();
                    Pannel_3.revalidate();
                    Pannel_3.repaint();
                    Pannel_7.revalidate();
                    Pannel_7.repaint();
                }           
                if (Round_Num == 1 && !Boxes.get(4).Get_Picked()) {

                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 5, select another case to be removed");
                        Case_5Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(4).Set_Picked();
                        Out_String.append(Boxes.get(4).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_5Button.setText(Removed);
                        Boxes.get(4).Set_Picked();
                        Out_String.append(Boxes.get(4).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                        
                }
                if (Round_Num == 2 && !Boxes.get(4).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 5, select another case to be removed");
                        Case_5Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(4).Set_Picked();
                        Out_String.append(Boxes.get(4).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 5, select another case to be removed");
                        Case_5Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(4).Set_Picked();
                        Out_String.append(Boxes.get(4).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_5Button.setText(Removed);
                        Boxes.get(4).Set_Picked();
                        Out_String.append(Boxes.get(4).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 3 && !Boxes.get(4).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 5, select another case to be removed");
                        Case_5Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(4).Set_Picked();
                        Out_String.append(Boxes.get(4).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 5, select another case to be removed");
                        Case_5Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(4).Set_Picked();
                        Out_String.append(Boxes.get(4).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_5Button.setText(Removed);
                        Boxes.get(4).Set_Picked();
                        Out_String.append(Boxes.get(4).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 4 && !Boxes.get(4).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 5, select another case to be removed");
                        Case_5Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(4).Set_Picked();
                        Out_String.append(Boxes.get(4).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_5Button.setText(Removed);
                        Boxes.get(4).Set_Picked();
                        Out_String.append(Boxes.get(4).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        Final_round = true;

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
            }
        }

        if (source == Case_6Button) {
            if (!Yes_No) {
                if (Round_Num == 0) {
                    
                    Message = "You have selected Case 6 as your locked case";
                    Message_to_Player_2.setText(Message);
                    Pannel_7.add(Message_to_Player_2);
                    Round_Num = 1;
                    Case_6Button.setText(Locked);
                    Boxes.get(5).Set_Picked();
                    Boxes.get(5).Set_Locked();
                    Message_to_Player_1.setText("Select 2 cases to be removed");

                    Pannel_1.revalidate();
                    Pannel_1.repaint();
                    Pannel_3.revalidate();
                    Pannel_3.repaint();
                    Pannel_7.revalidate();
                    Pannel_7.repaint();
                }           
                if (Round_Num == 1 && !Boxes.get(5).Get_Picked()) {

                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 6, select another case to be removed");
                        Case_6Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(5).Set_Picked();
                        Out_String.append(Boxes.get(5).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_6Button.setText(Removed);
                        Boxes.get(5).Set_Picked();
                        Out_String.append(Boxes.get(5).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                        
                }
                if (Round_Num == 2 && !Boxes.get(5).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 6, select another case to be removed");
                        Case_6Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(5).Set_Picked();
                        Out_String.append(Boxes.get(5).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 6, select another case to be removed");
                        Case_6Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(5).Set_Picked();
                        Out_String.append(Boxes.get(5).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_6Button.setText(Removed);
                        Boxes.get(5).Set_Picked();
                        Out_String.append(Boxes.get(5).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 3 && !Boxes.get(5).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 6, select another case to be removed");
                        Case_6Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(5).Set_Picked();
                        Out_String.append(Boxes.get(5).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 6, select another case to be removed");
                        Case_6Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(5).Set_Picked();
                        Out_String.append(Boxes.get(5).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_6Button.setText(Removed);
                        Boxes.get(5).Set_Picked();
                        Out_String.append(Boxes.get(5).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 4 && !Boxes.get(5).Get_Picked()) {
    
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 6, select another case to be removed");
                        Case_6Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(5).Set_Picked();
                        Out_String.append(Boxes.get(5).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                            Yes_No = true;
                        Case_6Button.setText(Removed);
                        Boxes.get(5).Set_Picked();
                        Out_String.append(Boxes.get(5).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        Final_round = true;

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
            }
        }

        if (source == Case_7Button) {
            if (!Yes_No) {
                if (Round_Num == 0) {
                    
                    Message = "You have selected Case 7 as your locked case";
                    Message_to_Player_2.setText(Message);
                    Pannel_7.add(Message_to_Player_2);
                    Round_Num = 1;
                    Case_7Button.setText(Locked);
                    Boxes.get(6).Set_Picked();
                    Boxes.get(6).Set_Locked();
                    Message_to_Player_1.setText("Select 2 cases to be removed");

                    Pannel_1.revalidate();
                    Pannel_1.repaint();
                    Pannel_3.revalidate();
                    Pannel_3.repaint();
                    Pannel_7.revalidate();
                    Pannel_7.repaint();
                }           
                if (Round_Num == 1 && !Boxes.get(6).Get_Picked()) {

                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 7, select another case to be removed");
                        Case_7Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(6).Set_Picked();
                        Out_String.append(Boxes.get(6).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_7Button.setText(Removed);
                        Boxes.get(6).Set_Picked();
                        Out_String.append(Boxes.get(6).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                        
                }
                if (Round_Num == 2 && !Boxes.get(6).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 7, select another case to be removed");
                        Case_7Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(6).Set_Picked();
                        Out_String.append(Boxes.get(6).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 7, select another case to be removed");
                        Case_7Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(6).Set_Picked();
                        Out_String.append(Boxes.get(6).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_7Button.setText(Removed);
                        Boxes.get(6).Set_Picked();
                        Out_String.append(Boxes.get(6).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 3 && !Boxes.get(6).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 7, select another case to be removed");
                        Case_7Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(6).Set_Picked();
                        Out_String.append(Boxes.get(6).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 7, select another case to be removed");
                        Case_7Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(6).Set_Picked();
                        Out_String.append(Boxes.get(6).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_7Button.setText(Removed);
                        Boxes.get(6).Set_Picked();
                        Out_String.append(Boxes.get(6).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 4 && !Boxes.get(6).Get_Picked()) {
    
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 7, select another case to be removed");
                        Case_7Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(6).Set_Picked();
                        Out_String.append(Boxes.get(6).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                            Yes_No = true;
                        Case_7Button.setText(Removed);
                        Boxes.get(6).Set_Picked();
                        Out_String.append(Boxes.get(6).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        Final_round = true;

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
            }
        }

        if (source == Case_8Button) {
            if (!Yes_No) {
                if (Round_Num == 0) {
                    
                    Message = "You have selected Case 8 as your locked case";
                    Message_to_Player_2.setText(Message);
                    Pannel_7.add(Message_to_Player_2);
                    Round_Num = 1;
                    Case_8Button.setText(Locked);
                    Boxes.get(7).Set_Picked();
                    Boxes.get(7).Set_Locked();
                    Message_to_Player_1.setText("Select 2 cases to be removed");

                    Pannel_1.revalidate();
                    Pannel_1.repaint();
                    Pannel_3.revalidate();
                    Pannel_3.repaint();
                    Pannel_7.revalidate();
                    Pannel_7.repaint();
                }           
                if (Round_Num == 1 && !Boxes.get(7).Get_Picked()) {

                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 8, select another case to be removed");
                        Case_8Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(7).Set_Picked();
                        Out_String.append(Boxes.get(7).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_8Button.setText(Removed);
                        Boxes.get(7).Set_Picked();
                        Out_String.append(Boxes.get(7).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                        
                }
                if (Round_Num == 2 && !Boxes.get(7).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 8, select another case to be removed");
                        Case_8Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(7).Set_Picked();
                        Out_String.append(Boxes.get(7).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 8, select another case to be removed");
                        Case_8Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(7).Set_Picked();
                        Out_String.append(Boxes.get(7).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_8Button.setText(Removed);
                        Boxes.get(7).Set_Picked();
                        Out_String.append(Boxes.get(7).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 3 && !Boxes.get(7).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 8, select another case to be removed");
                        Case_8Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(7).Set_Picked();
                        Out_String.append(Boxes.get(7).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 8, select another case to be removed");
                        Case_8Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(7).Set_Picked();
                        Out_String.append(Boxes.get(7).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_8Button.setText(Removed);
                        Boxes.get(7).Set_Picked();
                        Out_String.append(Boxes.get(7).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 4 && !Boxes.get(7).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 8, select another case to be removed");
                        Case_8Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(7).Set_Picked();
                        Out_String.append(Boxes.get(7).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_8Button.setText(Removed);
                        Boxes.get(7).Set_Picked();
                        Out_String.append(Boxes.get(7).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        Final_round = true;

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
            }
        }

        if (source == Case_9Button) {
            if (!Yes_No) {
                if (Round_Num == 0) {
                    
                    Message = "You have selected Case 9 as your locked case";
                    Message_to_Player_2.setText(Message);
                    Pannel_7.add(Message_to_Player_2);
                    Round_Num = 1;
                    Case_9Button.setText(Locked);
                    Boxes.get(8).Set_Picked();
                    Boxes.get(8).Set_Locked();
                    Message_to_Player_1.setText("Select 2 cases to be removed");

                    Pannel_1.revalidate();
                    Pannel_1.repaint();
                    Pannel_3.revalidate();
                    Pannel_3.repaint();
                    Pannel_7.revalidate();
                    Pannel_7.repaint();
                }           
                if (Round_Num == 1 && !Boxes.get(8).Get_Picked()) {

                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 9, select another case to be removed");
                        Case_9Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(8).Set_Picked();
                        Out_String.append(Boxes.get(8).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_9Button.setText(Removed);
                        Boxes.get(8).Set_Picked();
                        Out_String.append(Boxes.get(8).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                        
                }
                if (Round_Num == 2 && !Boxes.get(8).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 9, select another case to be removed");
                        Case_9Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(8).Set_Picked();
                        Out_String.append(Boxes.get(8).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 9, select another case to be removed");
                        Case_9Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(8).Set_Picked();
                        Out_String.append(Boxes.get(8).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_9Button.setText(Removed);
                        Boxes.get(8).Set_Picked();
                        Out_String.append(Boxes.get(8).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 3 && !Boxes.get(8).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 9, select another case to be removed");
                        Case_9Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(8).Set_Picked();
                        Out_String.append(Boxes.get(8).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 9, select another case to be removed");
                        Case_9Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(8).Set_Picked();
                        Out_String.append(Boxes.get(8).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_9Button.setText(Removed);
                        Boxes.get(8).Set_Picked();
                        Out_String.append(Boxes.get(8).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 4 && !Boxes.get(8).Get_Picked()) {
    
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 9, select another case to be removed");
                        Case_9Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(8).Set_Picked();
                        Out_String.append(Boxes.get(8).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                            Yes_No = true;
                        Case_9Button.setText(Removed);
                        Boxes.get(8).Set_Picked();
                        Out_String.append(Boxes.get(8).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        Final_round = true;

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
            }
        }

        if (source == Case_10Button) {
            if (!Yes_No) {
                if (Round_Num == 0) {
                    
                    Message = "You have selected Case 10 as your locked case";
                    Message_to_Player_2.setText(Message);
                    Pannel_7.add(Message_to_Player_2);
                    Round_Num = 1;
                    Case_10Button.setText(Locked);
                    Boxes.get(9).Set_Picked();
                    Boxes.get(9).Set_Locked();
                    Message_to_Player_1.setText("Select 2 cases to be removed");

                    Pannel_1.revalidate();
                    Pannel_1.repaint();
                    Pannel_3.revalidate();
                    Pannel_3.repaint();
                    Pannel_7.revalidate();
                    Pannel_7.repaint();
                }           
                if (Round_Num == 1 && !Boxes.get(9).Get_Picked()) {

                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 10, select another case to be removed");
                        Case_10Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(9).Set_Picked();
                        Out_String.append(Boxes.get(9).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_10Button.setText(Removed);
                        Boxes.get(9).Set_Picked();
                        Out_String.append(Boxes.get(9).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                        
                }
                if (Round_Num == 2 && !Boxes.get(9).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 10, select another case to be removed");
                        Case_10Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(9).Set_Picked();
                        Out_String.append(Boxes.get(9).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 10, select another case to be removed");
                        Case_10Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(9).Set_Picked();
                        Out_String.append(Boxes.get(9).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_10Button.setText(Removed);
                        Boxes.get(9).Set_Picked();
                        Out_String.append(Boxes.get(9).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 3 && !Boxes.get(9).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 10, select another case to be removed");
                        Case_10Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(9).Set_Picked();
                        Out_String.append(Boxes.get(9).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 10, select another case to be removed");
                        Case_10Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(9).Set_Picked();
                        Out_String.append(Boxes.get(9).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_10Button.setText(Removed);
                        Boxes.get(9).Set_Picked();
                        Out_String.append(Boxes.get(9).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 4 && !Boxes.get(9).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 10, select another case to be removed");
                        Case_10Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(9).Set_Picked();
                        Out_String.append(Boxes.get(9).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_10Button.setText(Removed);
                        Boxes.get(9).Set_Picked();
                        Out_String.append(Boxes.get(9).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        Final_round = true;

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
            }
        }

        if (source == Case_11Button) {
            if (!Yes_No) {
                if (Round_Num == 0) {
                    
                    Message = "You have selected Case 11 as your locked case";
                    Message_to_Player_2.setText(Message);
                    Pannel_7.add(Message_to_Player_2);
                    Round_Num = 1;
                    Case_11Button.setText(Locked);
                    Boxes.get(10).Set_Picked();
                    Boxes.get(10).Set_Locked();
                    Message_to_Player_1.setText("Select 2 cases to be removed");

                    Pannel_1.revalidate();
                    Pannel_1.repaint();
                    Pannel_3.revalidate();
                    Pannel_3.repaint();
                    Pannel_7.revalidate();
                    Pannel_7.repaint();
                }           
                if (Round_Num == 1 && !Boxes.get(10).Get_Picked()) {

                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 11, select another case to be removed");
                        Case_11Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(10).Set_Picked();
                        Out_String.append(Boxes.get(10).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_11Button.setText(Removed);
                        Boxes.get(10).Set_Picked();
                        Out_String.append(Boxes.get(10).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                        
                }
                if (Round_Num == 2 && !Boxes.get(10).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 11, select another case to be removed");
                        Case_11Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(10).Set_Picked();
                        Out_String.append(Boxes.get(10).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 11, select another case to be removed");
                        Case_11Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(10).Set_Picked();
                        Out_String.append(Boxes.get(10).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_11Button.setText(Removed);
                        Boxes.get(10).Set_Picked();
                        Out_String.append(Boxes.get(10).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 3 && !Boxes.get(10).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 11, select another case to be removed");
                        Case_11Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(10).Set_Picked();
                        Out_String.append(Boxes.get(10).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 11, select another case to be removed");
                        Case_11Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(10).Set_Picked();
                        Out_String.append(Boxes.get(10).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_11Button.setText(Removed);
                        Boxes.get(10).Set_Picked();
                        Out_String.append(Boxes.get(10).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 4 && !Boxes.get(10).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 11, select another case to be removed");
                        Case_11Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(10).Set_Picked();
                        Out_String.append(Boxes.get(10).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_11Button.setText(Removed);
                        Boxes.get(10).Set_Picked();
                        Out_String.append(Boxes.get(10).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        Final_round = true;
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
            }
        }

        if (source == Case_12Button) {
            if (!Yes_No) {
                if (Round_Num == 0) {
                    
                    Message = "You have selected Case 12 as your locked case";
                    Message_to_Player_2.setText(Message);
                    Pannel_7.add(Message_to_Player_2);
                    Round_Num = 1;
                    Case_12Button.setText(Locked);
                    Boxes.get(11).Set_Picked();
                    Boxes.get(11).Set_Locked();
                    Message_to_Player_1.setText("Select 2 cases to be removed");

                    Pannel_1.revalidate();
                    Pannel_1.repaint();
                    Pannel_3.revalidate();
                    Pannel_3.repaint();
                    Pannel_7.revalidate();
                    Pannel_7.repaint();
                }           
                if (Round_Num == 1 && !Boxes.get(11).Get_Picked()) {

                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 12, select another case to be removed");
                        Case_12Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(11).Set_Picked();
                        Out_String.append(Boxes.get(11).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_12Button.setText(Removed);
                        Boxes.get(11).Set_Picked();
                        Out_String.append(Boxes.get(11).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                        
                }
                if (Round_Num == 2 && !Boxes.get(11).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 12, select another case to be removed");
                        Case_12Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(11).Set_Picked();
                        Out_String.append(Boxes.get(11).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 12, select another case to be removed");
                        Case_12Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(11).Set_Picked();
                        Out_String.append(Boxes.get(11).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_12Button.setText(Removed);
                        Boxes.get(11).Set_Picked();
                        Out_String.append(Boxes.get(11).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 3 && !Boxes.get(11).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 12, select another case to be removed");
                        Case_12Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(11).Set_Picked();
                        Out_String.append(Boxes.get(11).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {

                        Message_to_Player_1.setText("You have removed Case 12, select another case to be removed");
                        Case_12Button.setText(Removed);
                        Cases_Removed = 2;
                        Boxes.get(11).Set_Picked();
                        Out_String.append(Boxes.get(11).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 2) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_12Button.setText(Removed);
                        Boxes.get(11).Set_Picked();
                        Out_String.append(Boxes.get(11).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
                if (Round_Num == 4 && !Boxes.get(11).Get_Picked()) {
        
                    if (Cases_Removed == 0) {

                        Message_to_Player_1.setText("You have removed Case 12, select another case to be removed");
                        Case_12Button.setText(Removed);
                        Cases_Removed = 1;
                        Boxes.get(11).Set_Picked();
                        Out_String.append(Boxes.get(11).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    else if (Cases_Removed == 1) {
                        
                        Give_Offer();
                        Message_to_Player_1.setText("We offer you $" + offer + " to quit now, do you accept?");
                        Pannel_1.add(Yes);
                        Pannel_1.add(No);
                        Yes_No = true;
                        Case_12Button.setText(Removed);
                        Boxes.get(11).Set_Picked();
                        Out_String.append(Boxes.get(11).Get_Money() + " | ");
                        Message = "Money values removed:" + Out_String.toString();
                        Message_to_Player_3.setText(Message);
                        Final_round = true;
                        

                        Pannel_1.revalidate();
                        Pannel_1.repaint();
                        Pannel_3.revalidate();
                        Pannel_3.repaint();
                    }
                    
                }
            }
        }

        if (source == No) {
            Pannel_1.remove(Yes);
            Pannel_1.remove(No);
            if (Final_round == true) {
                Message_to_Player_1.setText("Its the final round, will you keep your chossen case or will you switch?");
                Pannel_1.add(Keep);
                Pannel_1.add(Switch);
            }
            else{
                Message_to_Player_1.setText("OK, then select a case to be removed");
                Cases_Removed = 0;
                Round_Num++;
                Yes_No = false;

            }
            
            Pannel_1.revalidate();
            Pannel_1.repaint();
        }

        if (source == Yes) {

            Pannel_1.remove(Yes);
            Pannel_1.remove(No);
            Message_to_Player_1.setText("Congradulations, you win $" + offer + " Goodbye (Please close the window and restart)");
            if (Player_Has_Save) {
                PLayer_Winnings = Player_Money_Array.get(Player_Save_ID) + offer;
            }
            else{
                PLayer_Winnings = offer;
            }
            Pannel_3.remove(Case_1Button);
            Pannel_3.remove(Case_2Button);
            Pannel_3.remove(Case_3Button);
            Pannel_3.remove(Case_4Button);
            Pannel_3.remove(Case_5Button);
            Pannel_3.remove(Case_6Button);
            Pannel_3.remove(Case_7Button);
            Pannel_3.remove(Case_8Button);
            Pannel_3.remove(Case_9Button);
            Pannel_3.remove(Case_10Button);
            Pannel_3.remove(Case_11Button);
            Pannel_3.remove(Case_12Button);
            Save_Game(Save_File);


            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            
        }

        if (source == Keep) {
            Message_to_Player_1.setText("Congradulations, you win $" + Boxes.get(Locked_Box).Get_Money() + " Goodbye (Please close the window and restart)");
            if (Player_Has_Save) {
                PLayer_Winnings = Player_Money_Array.get(Player_Save_ID) + Boxes.get(Locked_Box).Get_Money();
            }
            else{
                PLayer_Winnings = Boxes.get(Locked_Box).Get_Money();
            }
            Pannel_3.remove(Case_1Button);
            Pannel_3.remove(Case_2Button);
            Pannel_3.remove(Case_3Button);
            Pannel_3.remove(Case_4Button);
            Pannel_3.remove(Case_5Button);
            Pannel_3.remove(Case_6Button);
            Pannel_3.remove(Case_7Button);
            Pannel_3.remove(Case_8Button);
            Pannel_3.remove(Case_9Button);
            Pannel_3.remove(Case_10Button);
            Pannel_3.remove(Case_11Button);
            Pannel_3.remove(Case_12Button);
            Save_Game(Save_File);


            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
        }

        if (source == Switch) {

            for (int i = 0; i < Boxes.size(); i++) {
                if (!Boxes.get(i).Box_Picked) {
                    Message_to_Player_1.setText("Congradulations, you win $" + Boxes.get(i).Get_Money() + " Goodbye (Please close the window and restart)");
                    Locked_Box = Boxes.get(i).Get_Num();
                    if (Player_Has_Save) {
                        PLayer_Winnings = Player_Money_Array.get(Player_Save_ID) + Boxes.get(Locked_Box).Get_Money();
                    }
                    else{
                        PLayer_Winnings = Boxes.get(Locked_Box).Get_Money();
                    }
                    Pannel_3.remove(Case_1Button);
                    Pannel_3.remove(Case_2Button);
                    Pannel_3.remove(Case_3Button);
                    Pannel_3.remove(Case_4Button);
                    Pannel_3.remove(Case_5Button);
                    Pannel_3.remove(Case_6Button);
                    Pannel_3.remove(Case_7Button);
                    Pannel_3.remove(Case_8Button);
                    Pannel_3.remove(Case_9Button);
                    Pannel_3.remove(Case_10Button);
                    Pannel_3.remove(Case_11Button);
                    Pannel_3.remove(Case_12Button);
                    Save_Game(Save_File);


                    Pannel_1.revalidate();
                    Pannel_1.repaint();
                    Pannel_3.revalidate();
                    Pannel_3.repaint();
                }
            }
            
        }
            //chose from saves
        if (source == Player_Save_1) {

            Player_Save_ID = 1;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_1.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_2) {

            Player_Save_ID = 2;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_2.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_3) {

            Player_Save_ID = 3;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_3.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_4) {

            Player_Save_ID = 4;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_4.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_5) {

            Player_Save_ID = 5;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_5.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_6) {

            Player_Save_ID = 6;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_6.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_7) {

            Player_Save_ID = 7;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_7.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_8) {

            Player_Save_ID = 8;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_8.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_9) {

            Player_Save_ID = 9;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_9.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_10) {

            Player_Save_ID = 10;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_10.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_11) {

            Player_Save_ID = 11;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_11.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_12) {

            Player_Save_ID = 12;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_12.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_13) {

            Player_Save_ID = 13;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_13.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_14) {

            Player_Save_ID = 14;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_14.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_15) {

            Player_Save_ID = 15;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_15.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_16) {

            Player_Save_ID = 16;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_16.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_17) {

            Player_Save_ID = 17;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_17.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_18) {

            Player_Save_ID = 18;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_18.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_19) {

            Player_Save_ID = 19;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_19.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_20) {

            Player_Save_ID = 20;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_20.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_21) {

            Player_Save_ID = 21;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_21.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_22) {

            Player_Save_ID = 22;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_22.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_23) {

            Player_Save_ID = 23;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_23.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_24) {

            Player_Save_ID = 24;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_24.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_25) {

            Player_Save_ID = 25;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_25.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_26) {

            Player_Save_ID = 26;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_26.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_27) {

            Player_Save_ID = 27;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_27.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_28) {

            Player_Save_ID = 28;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_28.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_29) {

            Player_Save_ID = 29;
	PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_29.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }

        if (source == Player_Save_30) {

            Player_Save_ID = 30;
            PLayer_Winnings = Player_Money_Array.get(Player_Save_ID);
            Randomize_Boxes();

            //add cases
            Pannel_3.add(Case_1Button);
            Pannel_3.add(Case_2Button);
            Pannel_3.add(Case_3Button);
            Pannel_3.add(Case_4Button);
            Pannel_3.add(Case_5Button);
            Pannel_3.add(Case_6Button);
            Pannel_3.add(Case_7Button);
            Pannel_3.add(Case_8Button);
            Pannel_3.add(Case_9Button);
            Pannel_3.add(Case_10Button);
            Pannel_3.add(Case_11Button);
            Pannel_3.add(Case_12Button);

            //re-add spacers
            Pannel_4.add(Spacer4);
            Pannel_6.add(Spacer5);


            //remove the save file select
            Pannel_3.remove(Player_Save_1);
            Pannel_3.remove(Player_Save_2);
            Pannel_3.remove(Player_Save_3);
            Pannel_4.remove(Player_Save_4);
            Pannel_4.remove(Player_Save_5);
            Pannel_4.remove(Player_Save_6);
            Pannel_5.remove(Player_Save_7);
            Pannel_5.remove(Player_Save_8);
            Pannel_5.remove(Player_Save_9);
            Pannel_6.remove(Player_Save_10);
            Pannel_6.remove(Player_Save_11);
            Pannel_6.remove(Player_Save_12);
            Pannel_7.remove(Player_Save_13);
            Pannel_7.remove(Player_Save_14);
            Pannel_7.remove(Player_Save_15);
            Pannel_10.remove(Player_Save_16);
            Pannel_10.remove(Player_Save_17);
            Pannel_10.remove(Player_Save_18);
            Pannel_11.remove(Player_Save_19);
            Pannel_11.remove(Player_Save_20);
            Pannel_11.remove(Player_Save_21);
            Pannel_12.remove(Player_Save_22);
            Pannel_12.remove(Player_Save_23);
            Pannel_12.remove(Player_Save_24);
            Pannel_13.remove(Player_Save_25);
            Pannel_13.remove(Player_Save_26);
            Pannel_13.remove(Player_Save_27);
            Pannel_14.remove(Player_Save_28);
            Pannel_14.remove(Player_Save_29);
            Pannel_14.remove(Player_Save_30);

            
            Message = "Welcome back, select a Case from the group of cases to lock";
            Player_Name = Player_Save_30.getText();
            Message_to_Player_1.setText(Message);
            Message_to_Player_4.setText(Player_Name);
            

            //update everything
            Pannel_1.revalidate();
            Pannel_1.repaint();
            Pannel_3.revalidate();
            Pannel_3.repaint();
            Pannel_8.add(Message_to_Player_4);
            Pannel_8.revalidate();
            Pannel_8.repaint();
            Pannel_4.revalidate();
            Pannel_4.repaint();
            Pannel_5.revalidate();
            Pannel_5.repaint();
            Pannel_6.revalidate();
            Pannel_6.repaint();
            Pannel_7.revalidate();
            Pannel_7.repaint();
            Pannel_10.revalidate();
            Pannel_10.repaint();
            Pannel_11.revalidate();
            Pannel_11.repaint();
            Pannel_12.revalidate();
            Pannel_12.repaint();
            Pannel_13.revalidate();
            Pannel_13.repaint();
            Pannel_14.revalidate();
            Pannel_14.repaint();
        }
 





    }








}
