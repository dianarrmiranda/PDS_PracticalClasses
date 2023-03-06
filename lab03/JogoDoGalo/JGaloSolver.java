package lab03.JogoDoGalo;

public class JGaloSolver implements JGaloInterface {

    private char player;
    private char[][] board = new char[3][3];
    private char winner;

    public JGaloSolver() {
        this.player = 'X';
        this.winner = ' ';

    }

    public JGaloSolver(char player) {
        this.player = player;
        this.winner = ' ';

    }

    @Override
    public char getActualPlayer() {
        return this.player;
    }

    @Override
    public boolean setJogada(int lin, int col) {
        // tem de ser lin-1 e col-1 para não sair fora do indice
        this.board[lin - 1][col - 1] = this.player;
        return true;
    }

    @Override
    public boolean isFinished() {

        if (checkWinners() || checkBoard()) {
            return true;
        }

        if (this.player == 'X') {
            this.player = 'O';
        } else {
            this.player = 'X';
        }

        return false;
    }

    public boolean checkWinners() {

        // verificar horizontais e verticais
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == this.player && board[i][1] == this.player && board[i][2] == this.player) {
                this.winner = this.player;
                return true;
            }
            if (board[0][i] == this.player && board[1][i] == this.player && board[2][i] == this.player) {
                this.winner = this.player;
                return true;
            }
        }

        // verificar diagonais
        if (board[0][0] == this.player && board[1][1] == this.player && board[2][2] == this.player) {
            this.winner = this.player;
            return true;
        }
        if (board[0][2] == this.player && board[1][1] == this.player && board[2][0] == this.player) {
            this.winner = this.player;
            return true;
        }

        return false;

    }

    public boolean checkBoard() {
        for (int lin = 0; lin < this.board.length; lin++) {
            for (int col = 0; col < this.board.length; col++) {
                if (board[lin][col] == 0) {
                    return false;
                }
            }
        }

        this.winner = ' ';
        return true;
    }

    @Override
    public char checkResult() {

        return this.winner;
    }

}
