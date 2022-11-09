package com.codeup.codeupspring;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class MathController {
    @RequestMapping(path = "/add/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String addTwoNumbers (@PathVariable int num1, @PathVariable String num2) {
        return num1 + " plus " + num2 + " equals " + num1 + num2;
    }
}
