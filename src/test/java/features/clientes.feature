Feature: Modulo de clientes
  Debe redireccionar al modulo de clientes

  #Background: Ingresar al modulo de clientes
  #  Given el usuario se encuentra en modulo de clientes

  Scenario: Ingresar al modulo de clientes
    Given el usuario se encuentra en modulo de clientes
    When click en el modulo de ventas y redirige a clintes
    Then muestra pantalla de clientes

  @Test
  Scenario Outline: Filtrar y actualizar los datos de un cliente
    Given Estando en la pagina de clientes filtramos por identificacion <cedula>
    When Registramos los datos a modificar
    And Damos click en el boton guardar
    Then Se muestra el mensaje de registros actualizado
    Examples:
      | cedula     |
      | 1311901001 |

  Scenario: Registrar un cliente nuevo
    Given Estando en la pagina de clientes
    When Registramos los datos del nuevo cliente
    And Damos click en el boton guardar nuevo cliente
    Then Se muestra el mensaje de registros creado