package com.siderbit.ephemeris.services.validation;

import javax.validation.Payload;

public @interface UsuarioInsert {
	String message() default "Erro de validação";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
