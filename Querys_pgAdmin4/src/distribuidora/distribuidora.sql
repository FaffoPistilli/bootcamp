SELECT cedula, apellidos, nombres
	FROM public.empleados
	--WHERE apellidos = 'MESSI'
	WHERE apellidos != 'GONZALEZ'