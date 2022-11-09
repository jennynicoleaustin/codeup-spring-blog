package com.codeup.codeupspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class MathController {
    @RequestMapping(path = "/add/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String addTwoNumbers (@PathVariable int num1, @PathVariable int num2) {
        return num1 + " plus " + num2 + " equals " + (num1 + num2);
    }
    @RequestMapping(path = "/subtract/{num1}/from/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String subtractTwoNumbers (@PathVariable int num1, @PathVariable int num2) {
        return num2 + " minus " + num1 + " equals " + (num2 - num1);
    }
    @RequestMapping(path = "/multiply/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String multiplyTwoNumbers (@PathVariable int num1, @PathVariable int num2) {
        return num2 + " times " + num1 + " equals " + (num1 * num2);
    }
    @RequestMapping(path = "/divide/{num1}/by/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String divideTwoNumbers (@PathVariable int num1, @PathVariable int num2) {
        return num1 + " divided " + num2 + " equals " + (num1 / num2);
    }
}
