package com.contaazul.controller.dto;

import jakarta.validation.constraints.Pattern;

public record Instruction(@Pattern(regexp = "^[LRM]*$", message = "The input must contain only the characters L, R, and M.") String command) {
}
