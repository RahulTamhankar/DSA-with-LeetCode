class TicTacToe {

    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    public TicTacToe(int n) {
        rows=new int[n];
        cols=new int[n];
        diagonal=0;
        antiDiagonal=0;
    }


    public int move(int row, int col, int player) {
        int toAdd=player==1?1:-1;

        rows[row]+=toAdd;
        cols[col]+=toAdd;       

        if(row==col){
            diagonal+=toAdd;
        } 

        if(row+col==rows.length-1){
            antiDiagonal+=toAdd;
        }

        int n=rows.length;

        if(Math.abs(rows[row])==n ||
            Math.abs(cols[col])==n ||
            Math.abs(diagonal)==n ||
            Math.abs(antiDiagonal)==n){
                return player;
            }
            return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */