
//Filename Box.java
//Written by Brady Bierman
//Written on 10/8/24

public class Box extends GamePiece {

    public Box(int num, int money){

        super(num,money);

    }
    
    public int Get_Num(){

        return Box_Num;

    }

    public int Get_Money(){

        return Box_Money;

    }

    public boolean Get_Picked(){

        return Box_Picked;

    }

    public boolean Get_Locked(){

        return Box_locked;

    }

    public void Set_Picked(){

        Box_Picked = true;

    }

    public void Set_Locked(){

        Box_locked = true;

    }
    
}



