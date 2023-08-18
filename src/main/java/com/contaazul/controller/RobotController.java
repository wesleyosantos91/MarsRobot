package com.contaazul.controller;

import com.contaazul.controller.dto.Instruction;
import com.contaazul.exception.ValidationException;
import com.contaazul.service.RobotService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/robots")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RobotController {

    private final RobotService service;

    @PostMapping
    public ResponseEntity<String> instruction(@RequestBody(required = true) @Valid Instruction instruction) throws ValidationException {
        return ResponseEntity.ok(service.executeInstructions(instruction.command()));
    }
}
