
Feature: Modulo de clientes
  Administracion del modulo de clientes

  #Background: Ingresar al modulo de clientes
    #Given el usuario se encuentra en modulo de clientes

  #Rule: El cliente puede filtrar actualizar y crear nuevo cliente


    Scenario Outline: Filtrar y actualizar los datos de un cliente
      Given el usuario se encuentra en modulo de clientes
      When filtramos por identificacion <cedula>
      And Registramos los datos a modificar
      And Damos click en el boton guardar
      Then Se muestra el mensaje de registros actualizado
      Examples:
        | cedula     |
        | 1311901001 |
  @Test
    Scenario: Registrar un cliente nuevo
      Given el usuario se encuentra en modulo de clientes
      When Registramos los datos del nuevo cliente
      And Damos click en el boton guardar nuevo cliente
      Then Se muestra el mensaje de registros creado