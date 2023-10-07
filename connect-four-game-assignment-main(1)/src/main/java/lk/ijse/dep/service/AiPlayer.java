package lk.ijse.dep.service;

import java.util.Random;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class AiPlayer extends Player {
    Winner winner;
    int col;

    public AiPlayer(Board newBoard) {
        super(newBoard);
    }

    @Override
    public void movePiece(int indexOf) {
        //col=bestMove();
        col = findBestCol();
        System.out.println("ai thinking  :" + col);
        //try {Thread.sleep(100);} catch (InterruptedException ignored) {}
        board.updateMove(col, Piece.GREEN);
        board.getBoardUI().update(col, false);
        winner = board.findWinner();
        if (board.findWinner().getWinningPiece() != Piece.EMPTY) {
            board.getBoardUI().notifyWinner(winner);
        }
        if (!board.existLegalMoves()) {
            board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
        }
    }

    private int findBestCol() { // my AI method

        Piece[][] tempPiece = board.getPieces();
        int column;

        for (int i = 0; i < 5; i++) {

            if (tempPiece[0][i] == tempPiece[1][i] && tempPiece[1][i] == tempPiece[2][i] && tempPiece[0][i] == Piece.GREEN) {
                if (tempPiece[3][i] == Piece.EMPTY) {
                    return 3;
                }
            } else if (tempPiece[0][i] == tempPiece[1][i] && tempPiece[1][i] == tempPiece[2][i] && tempPiece[0][i] == Piece.BLUE) {
                if (tempPiece[3][i] == Piece.EMPTY) {
                    return 3;
                }
            } else if (tempPiece[1][i] == tempPiece[2][i] && tempPiece[2][i] == tempPiece[3][i] && tempPiece[1][i] == Piece.GREEN) {
                if (tempPiece[4][i] == Piece.EMPTY) {
                    return 4;
                }
            } else if (tempPiece[1][i] == tempPiece[2][i] && tempPiece[2][i] == tempPiece[3][i] && tempPiece[1][i] == Piece.BLUE) {
                if (tempPiece[4][i] == Piece.EMPTY) {
                    return 4;
                }
            } else if (tempPiece[2][i] == tempPiece[3][i] && tempPiece[3][i] == tempPiece[4][i] && tempPiece[2][i] == Piece.GREEN) {
                if (tempPiece[5][i] == Piece.EMPTY) {
                    return 5;
                }
            } else if (tempPiece[2][i] == tempPiece[3][i] && tempPiece[3][i] == tempPiece[4][i] && tempPiece[2][i] == Piece.BLUE) {
                if (tempPiece[5][i] == Piece.EMPTY) {
                    return 5;
                }
            } else if (tempPiece[3][i] == tempPiece[2][i] && tempPiece[2][i] == tempPiece[1][i] && tempPiece[3][i] == Piece.GREEN) {
                System.out.println("come green 0");
                if (tempPiece[0][i] == Piece.EMPTY) {
                    return 0;
                }
            } else if (tempPiece[3][i] == tempPiece[2][i] && tempPiece[2][i] == tempPiece[1][i] && tempPiece[3][i] == Piece.BLUE) {
                System.out.println("come blue 0");
                if (tempPiece[0][i] == Piece.EMPTY) {
                    return 0;
                }
            } else if (tempPiece[4][i] == tempPiece[3][i] && tempPiece[3][i] == tempPiece[2][i] && tempPiece[3][i] == Piece.GREEN) {
                System.out.println("come green 1");
                if (tempPiece[1][i] == Piece.EMPTY) {
                    return 1;
                }
            } else if (tempPiece[4][i] == tempPiece[3][i] && tempPiece[3][i] == tempPiece[2][i] && tempPiece[3][i] == Piece.BLUE) {
                System.out.println("come blue 1");
                if (tempPiece[1][i] == Piece.EMPTY) {
                    return 1;
                }
            } else if (tempPiece[5][i] == tempPiece[4][i] && tempPiece[4][i] == tempPiece[3][i] && tempPiece[5][i] == Piece.GREEN) {
                System.out.println("come green 2");
                if (tempPiece[2][i] == Piece.EMPTY) {
                    return 2;
                }
            } else if (tempPiece[5][i] == tempPiece[4][i] && tempPiece[4][i] == tempPiece[3][i] && tempPiece[5][i] == Piece.BLUE) {
                System.out.println("come blue 2");
                if (tempPiece[2][i] == Piece.EMPTY) {
                    return 2;
                }
            }
        }
        for (int i = 0; i < 6; i++) {

            if (tempPiece[i][0] == tempPiece[i][1] && tempPiece[i][1] == tempPiece[i][2] && tempPiece[i][0] == Piece.GREEN) {
                if (tempPiece[i][3] == Piece.EMPTY)
                    return i;
            } else if (tempPiece[i][0] == tempPiece[i][1] && tempPiece[i][1] == tempPiece[i][2] && tempPiece[i][0] == Piece.BLUE) {
                if (tempPiece[i][3] == Piece.EMPTY)
                    return i;
            } else if (tempPiece[i][1] == tempPiece[i][2] && tempPiece[i][2] == tempPiece[i][3] && tempPiece[i][1] == Piece.GREEN) {
                if (tempPiece[i][4] == Piece.EMPTY)
                    return i;
            } else if (tempPiece[i][1] == tempPiece[i][2] && tempPiece[i][2] == tempPiece[i][3] && tempPiece[i][1] == Piece.BLUE) {
                if (tempPiece[i][4] == Piece.EMPTY)
                    return i;
            }
        }
        do {
            column = (int) ((Math.random() * (6 - 0)) + 0);
        } while (!board.isLegalMove(column));
        return column;
    }
}