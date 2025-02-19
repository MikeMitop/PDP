#include <stdio.h>

int mcd(int dividendo, int divisor) { // Algoritmo de Euclides
    while (divisor != 0) {  // Mientras el divisor sea distinto de 0
        int temp = divisor;       // Guardamos el divisor en una variable temporal
        divisor = dividendo % divisor; // El divisor ahora es el resto de dividendo dividido por divisor
        dividendo = temp;         // El dividendo ahora es el divisor anterior
    }
    return dividendo; // Retornamos el dividendo que es el MCD



    /* Es decir que el Algoritmo de Euclides se basa en la propiedad de que el MCD de dos numeros
     es igual al MCD del divisor y el resto de dividir el dividendo por el divisor */
    
}

int main() {
    int a, b;

    printf("Ingrese el primer numero: ");
    scanf("%d", &a);

    printf("Ingrese el segundo numero: ");
    scanf("%d", &b);

    printf("El maximo comun divisor es: %d\n", mcd(a, b));

    return 0;
}
/* Ejemplo de ejecucion:
Ingrese el primer numero: 12
Ingrese el segundo numero: 18
El maximo comun divisor es: 6
*/
