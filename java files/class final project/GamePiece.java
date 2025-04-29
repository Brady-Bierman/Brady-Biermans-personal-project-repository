
//Filename GamePiece.java
//Written by Brady Bierman
//Written on 10/8/24

public abstract class GamePiece {

    protected int Box_Num;
    protected int Box_Money;
    protected boolean Box_Picked;
    protected boolean Box_locked;

    public GamePiece(int num, int money){

        this.Box_Num = num;
        this.Box_Money = money;
        this.Box_Picked = false;
        this.Box_locked = false;

    }
    
}
