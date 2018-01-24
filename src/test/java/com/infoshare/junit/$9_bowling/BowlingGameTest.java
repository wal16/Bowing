package com.infoshare.junit.$9_bowling;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.fail;

/*

Punktacja w kręglach:

1. gra ma dziesięć rund (frame)
2. w każdej rundzie gracz ma dwie rzuty (roll), żeby strącić dziesięć kręgli
3. gracz zdobywa tyle punktów ile strącił kręgli, plus bonusy za “strike” i “spare”
4. “strike” jest wtedy, gdy gracza strąci dziesięć kręgli w jednym rzucie, dostanie wtedy dodatkowo tyle punktów ile strąci kręgli w dwóch następnych rzutach
5. “spare” to sytuacja, gdy gracz strąci dziesięć kręgli w dwóch rzutach, dodatkowo dostaje wtedy tyle punktów ile strąci kręgli w następnym rzucie
6. jeżeli gracz zdobędzie “strike” albo “spare” w dziesiątej rundzie to ma dwa (jeden w przypadku “spare”) dodatkowe rzuty na zdobycie dodatkowych punktów
7. punkty zdobyte po ostatniej rundzie naliczane są tylko raz

@see http://www.bowlinggenius.com

*/
public class BowlingGameTest {

    @Test
    public void test1() {
        Game game = new Game();
        for (int i=0;i<20;i++) {
            game.roll(0);
        }
        int finalScore = game.score();
        fail();
    }

}
