package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LogicTest {

    @Test
    public void whenMoveTrue()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.F1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test
    public void whenCellOccupied()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.D2));
        assertThatThrownBy(() -> logic.move(Cell.C1, Cell.H6))
                .hasMessage("Could not way - cell D2 is occupied");

    }

    @Test
    public void whenFigureNotFound()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        assertThatThrownBy(() -> logic.move(Cell.D2, Cell.H6))
                .isExactlyInstanceOf(FigureNotFoundException.class);

    }
}