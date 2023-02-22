package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;

class BishopBlackTest {

    private static Cell startPositionBishopBlackC8;
    private static Cell startPositionBishopBlackF8;

    @BeforeAll
    static void setup() {
        startPositionBishopBlackC8 = Cell.C8;
        startPositionBishopBlackF8 = Cell.F8;
    }

    @Test
    public void whenPositionIsC8orF8() {
        Cell expectedPosition = Cell.C8;
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);

        assertThat(bishopBlack.position()).isEqualTo(expectedPosition);
    }

    @Test
    public void copyBishopBlackC8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Figure copiedBishopBlack = bishopBlack.copy(Cell.C8);

        assertThat(copiedBishopBlack.position().equals(startPositionBishopBlackC8));
    }

    @Test
    public void copyBishopBlackF8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Figure copiedBishopBlack = bishopBlack.copy(Cell.F8);

        assertThat(copiedBishopBlack.position().equals(startPositionBishopBlackF8));
    }

    @Test
    public void wayBishopBlackFromC1toG5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell dest = Cell.G5;
        Cell[] expected = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};

        assertThat(bishopBlack.way(dest)).isEqualTo(expected);
    }

}