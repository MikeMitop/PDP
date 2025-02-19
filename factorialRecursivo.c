#include <stdio.h>

int factorial(int n){ // Funcion recursiva para calcular el factorial de un numero

    if (n < 0){
        printf("Error \n"); // Si el numero es negativo, se imprime un mensaje de error
        return 0;
    }

    if(n == 0){
        return 1;
    }else{
        return n * factorial(n - 1); // Se llama a la funcion recursivamente
    }
}

int main(){


    int n;

    printf("Ingrese el numero: ");
    scanf("%d",&n);

    printf("El factorial del numero es: ""%d",factorial(n)); // Se imprime el resultado de la funcion factorial
 
    return 0;
}
