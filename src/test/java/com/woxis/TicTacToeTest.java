package com.woxis;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TicTacToeTest {

    private TicTacToe ticTacToe;

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        ticTacToe = new TicTacToe();
    }

    @Test(expected = RuntimeException.class)
    public void whenPutOnXAxisOutsideBoardThenExpectRuntimeException() {
        ticTacToe.put(-1,1);
    }

    @Test
    public void whenPutOnYAxisOutsideBoardThenExpectRuntimeException() {
        expectedException.expect(RuntimeException.class);
        ticTacToe.put(1,3);
    }

    @Test
    public void whenPutOnOccupiedFieldThenExpectRuntimeException() {
        ticTacToe.put(0,0);
        expectedException.expect(RuntimeException.class);
        ticTacToe.put(0,0);
    }

    @Test
    public void givenFirstTurnWhenWhoIsNextThenX() {
        assertEquals(TicTacToe.X, ticTacToe.nextPlayer());
    }

    @Test
    public void givenSecondTurnWhenWhoIsNextThenO() {
        ticTacToe.put(0,0);
        assertEquals(TicTacToe.O, ticTacToe.nextPlayer());
    }

}
