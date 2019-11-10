Aplicación para Android que presenta un formulario con los siguientes datos a ingresar:
- Nombre
- Fecha de nacimiento
- Número de cuenta (10 dígitos)
- Correo electrónico

Una vez ingresados los datos, un botón nos lleva a otra Activity en donde se le presenta al usuario su edad y su signo con respecto al horóscopo chino junto con una imagen de dicho signo.
Si el usuario hace clic en la imágen de su signo, le lleva a otra Activity donde se le da al usuario una descripción de su signo.

Restricciones:
- Cuando el usuario ingresa sus datos, debe llenar todos los campos, o no podrá avanzar a la siguiente Activity.
- El usuario debe ingresar una fecha de nacimiento válida, no puede elegir una fecha futura, ya que no lo dejará avanzar.
- El usuario solo puede ingresar números en el apartado de número de cuenta, y solo podrá ingresar 10. Si ingresa una cantidad menor, el programa no lo dejará avanzar hasta que lo haya llenado completamente.
- Se hace uso de Patterns para verificar que el email tenga el formato correcto, es decir, usuario@empresa.terminación. En caso de no ser así, se le informa al usuario y no se le permite avanzar.
- En el cálculo de la edad, se consideran día, mes y año, de esta forma, evitamos usar solo una resta entre años que derivaría en ocasiones a un error de cálculo.

Extras:
- Se hizo uso de la función DatePickerDialog para que el usuario seleccionara su fecha de nacimiento con un calendario en lugar de hacerlo introduciendo dígitos.
- Se hizo uso de una tercera Activity en la cual se le da al usuario una pequeña descripción de su signo.
- En lugar de usar un color de fondo para la aplicación, se hizo uso de una imagen alusiva a la cultura china.
- Se hizo uso de un botón realizado manualmente con Adobe Illustrator, de esta forma se le da más estética al programa y no se hace uso de un boton genérico.
- Cuando el usuario ingresa una fecha de nacimiento que coincide con la fecha actual, exceptuando el año, se le manda un Toast deseándole un "Feliz cumpleaños".
