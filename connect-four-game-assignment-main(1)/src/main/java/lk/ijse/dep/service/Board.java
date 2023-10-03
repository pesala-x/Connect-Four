package lk.ijse.dep.service;

public interface Board {

    int NUM_OF_ROWS = 5;
    int NUM_OF_COLS = 6;

    lk.ijse.dep.service.BoardUI getBoardUI();

    default int findNextAvailableSpot(int col) {
        return 0;
    }

    default boolean isLegalMove(int col) {
        return false;
    }

    default boolean existLegalMoves() {
        return false;
    }

    default void updateMove(int col, lk.ijse.dep.service.Piece piece) {

    }

    default Winner findWinner() {
        return null;
    }
}
