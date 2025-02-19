#include <stdio.h>
#include <stdbool.h>

int main()
{
    int number;
    bool esPrimo = true; // Variable que nos ayudara a saber si el numero es primo o no

    printf("Ingrese un valor (numero): ");
    scanf("%d", &number);

    if (number < 0) { // Validamos que el numero sea positivo
        printf("Error: El numero debe ser positivo\n"); 
        return 1;
    }

    for (int i = 2; i <= number / 2; i++) // Iteramos desde 2 hasta la mitad del numero
    {
        if (number % i == 0) // Si el numero es divisible por algun numero diferente a 1 y a si mismo, entonces no es primo
        {
            esPrimo = false;
            break;
        }
    }

    if (esPrimo)
    {
        printf("%d Es un numero primo\n", number);
    }
    else
    {
        printf("%d No es un numero primo\n", number);
    }

    return 0;
}
