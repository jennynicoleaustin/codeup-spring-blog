package com.codeup.codeupspring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String getRollDice () {
        return "roll-dice";
    }
    @GetMapping(path = ("/roll-dice/{guessNum}"))
    public String rollDiceResult (Model model, @PathVariable double guessNum) {
        model.addAttribute("guess", guessNum);
        double diceRoll = (int) (Math.random() * (6 - 1 + 1)) + 1;
        model.addAttribute("diceRoll", diceRoll);
        return "roll-dice-result";
    }
}
