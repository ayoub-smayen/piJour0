package com.project0.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.entity.DiceRoll;
import com.project0.esprit.entity.Rollable;

@RestController
@RequestMapping("api")
public class DiceController {


@Autowired(required = true)
private Rollable greenDice;

@Autowired(required = true)
private Rollable yellowDice;

@Autowired(required = true)
private Rollable brownDice;

@Autowired(required = true)
private Rollable blueDice;

@Autowired(required = true)
private Rollable greyDice;

@Autowired(required = true)
private Rollable redDice;

@Autowired(required = true)
private Rollable blackDice;


//http://localhost:8091/api/dice/yellow/roll
@GetMapping("/dice/yellow/roll")
public @ResponseBody DiceRoll yellowDiceRoll() {
    return DiceRoll.invoke("Yellow", yellowDice.roll());
}

//http://localhost:8091/api/dice/green/roll
@GetMapping("/dice/green/roll")
public @ResponseBody DiceRoll greenDiceRoll() {
    return DiceRoll.invoke("Green", greenDice.roll());
}

//http://localhost:8091/api/dice/brown/roll
@GetMapping("/dice/brown/roll")
public @ResponseBody DiceRoll brownDiceRoll() {
    return DiceRoll.invoke("Brown", brownDice.roll());
}


//http://localhost:8091/api/dice/blue/roll
@GetMapping("/dice/blue/roll")
public @ResponseBody DiceRoll blueDiceRoll() {
    return DiceRoll.invoke("Blue", blueDice.roll());
}

//http://localhost:8091/api/dice/grey/roll
@GetMapping("/dice/grey/roll")
public @ResponseBody DiceRoll greyDiceRoll() {
    return DiceRoll.invoke("Grey", greyDice.roll());
}

//http://localhost:8091/api/dice/red/roll
@GetMapping("/dice/red/roll")
public @ResponseBody DiceRoll redDiceRoll() {
    return DiceRoll.invoke("Red", redDice.roll());
}

//http://localhost:8091/api/dice/black/roll
@GetMapping("/dice/black/roll")
public @ResponseBody DiceRoll blackDiceRoll() {
    return DiceRoll.invoke("Black", blackDice.roll());
}
}
