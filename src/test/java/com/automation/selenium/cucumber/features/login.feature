
Feature: Login
  Debe de redireccionar a la pagina de login

  Scenario: Ingresar al home cloud systems
    Given el usuario se encuentra en home cloud systems
    When Ingresa credenciales click boton aceptar
    Then Redireccionar a pagina de bienvenida
