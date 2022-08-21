package ru.job4j.chess.firuges.black;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest {

    @Test
    public void whenBbPosition() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        Cell rsl = Cell.C8;
        assertThat(rsl).isEqualTo(bishopBlack.position());
    }

    @Test
    public void whenBbCopyToF8() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        Figure bbCopy = bishopBlack.copy(Cell.F8);
        Cell rsl = Cell.F8;
        assertThat(rsl).isEqualTo(bbCopy.position());
    }

    @Test
    public void whenBbC1goG5wayTrue() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] steps = bishopBlack.way(Cell.G5);
        Cell[] rsl = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(rsl).isEqualTo(steps);
    }

    @Test
    public void whenBbC1goG7wayFalse() {
        Figure bishopBlack = new BishopBlack(Cell.C1);

        assertThatThrownBy(() -> {
            Cell[] way = bishopBlack.way(Cell.G7);
        })
                .hasMessage("Could not way by diagonal from C1 to G7");
    }
}