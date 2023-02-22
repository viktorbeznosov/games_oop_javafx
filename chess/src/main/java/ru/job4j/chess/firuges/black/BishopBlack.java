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
        int deltaX = (dest.getX() - this.position().getX()) / size;
        int deltaY = (dest.getY() - this.position().getY()) / size;
        for (int i = 0; i < size; i++) {
            int currX = this.position().getX() + deltaX * i + deltaX;
            int currY = this.position().getY() + deltaY * i + deltaY;
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
