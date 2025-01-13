# Conversor de Monedas

Esta es una aplicación de conversión de monedas basada en Java que utiliza la ExchangeRate-API para convertir entre diferentes monedas.

## Características

- Convertir entre pares de monedas predefinidos (USD a COP, COP a USD, etc.)
- Convertir entre cualquier par de monedas ingresando sus códigos
- Maneja códigos de moneda no soportados de manera adecuada

## Requisitos

- Java 11 o superior
- Una API key de [ExchangeRate-API](https://www.exchangerate-api.com/)

## Configuración

1. Clona el repositorio:
    ```sh
    git clone https://github.com/joen-ao/conversor-de-monedas.git
    cd conversor-de-monedas
    ```

2. Configura tu API key:
    - Añade tu API key en el archivo `utils.java`:
        ```java
        public class utils {
            public static final String APIKEY = "tu_api_key_aqui";
        }
        ```

3. Compila y ejecuta la aplicación:
    ```sh
    javac -d bin src/*.java
    java -cp bin main
    ```

## Uso

1. Ejecuta la aplicación:
    ```sh
    java -cp bin main
    ```

2. Sigue las instrucciones en pantalla para convertir monedas.

## Manejo de Errores

- Si se ingresa un código de moneda no soportado, la aplicación mostrará un mensaje de error adecuado.

