package ru.job4j.chess.firuges.black;

import ru.job4j.chess.FigureNotFoundException;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(this.position(), dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }

        int size = Math.abs(dest.getX() - this.position().getX());
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() - this.position().getX() > 0 ? 1 : -1;
        int deltaY = dest.getY() - this.position().getY() > 0 ? 1 : -1;
        int currX = this.position().getX();
        int currY = this.position().getY();
        for (int i = 0; i < size; i++) {
            currX += deltaX;
            currY += deltaY;
            steps[i] = Cell.findBy(currX, currY);
        }

        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
