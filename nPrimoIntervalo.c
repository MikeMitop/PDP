#include <stdio.h>
#include <stdbool.h>
#include <math.h>

bool comprobacion(int n) {
    if (n < 2) { // Si n es menor a 2, entonces n no es primo
        return false;
    }
    for (int i = 2; i <= sqrt(n); i++) { // Se usa un for para recorrer los numeros desde 2 hasta la raiz cuadrada de n
        if (n % i == 0) { // Si n es divisible por i, entonces n no es primo
            return false;
        }
    }
    return true;
}

int main() {
    int x, y; // Variables para almacenar los numeros ingresados por el usuario

    printf("Ingrese un numero: ");
    scanf("%d", &x);

    printf("Ingrese un numero: ");
    scanf("%d", &y);

    if (x < 0 || y < 0 || x > y) { // Si x o y son menores a 0 o x es mayor a y, entonces se imprime un mensaje de error
        printf("Valor Ingresado no valido\n");
        return 0;
    }

    for (int i = x; i <= y; i++) { // Se recorren los numeros desde x hasta y
        if (comprobacion(i)) { // Se llama a la funcion comprobacion para verificar si i es primo
            printf("%d es un numero primo.\n", i);
        } else {
            printf("%d no es un numero primo.\n", i);
        }
    }

    return 0;
}
