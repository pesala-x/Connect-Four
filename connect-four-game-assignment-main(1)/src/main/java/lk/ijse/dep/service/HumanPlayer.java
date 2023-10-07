package lk.ijse.dep.service;

public class HumanPlayer extends Player {
    Winner winner;
    public HumanPlayer(Board newBoard) {super(newBoard);}
    @Override
    public void movePiece(int indexOf) {
        boolean human=board.isLegalMove(indexOf);
        if(human){
            board.updateMove(indexOf,Piece.BLUE);
            board.getBoardUI().update(indexOf, true);
            winner = board.findWinner();
            if (board.findWinner().getWinningPiece()!=Piece.EMPTY){
                board.getBoardUI().notifyWinner(winner);
            }
            if(!board.existLegalMoves()) {
                board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
            }
        }
    }
}