#include <stdio.h>

int factorial (int n){ // Funcion que calcula el factorial de un numero de manera iterativa

    if (n < 0){
        printf("Error \n"); // Si el numero es negativo se imprime un mensaje de error
        return 0;
    }
    int f = 1; 
    if (n == 0){  // Si el numero es 0 se retorna 1
        return f; 
    }else { 

        for(int i = 1; i <= n; i++){ // Ciclo que calcula el factorial
            f *= i; 
        }
        return f; 
    }
}

int main (){

    int n;

    printf("Ingrese el numero: ");
    scanf("%d",&n);

    printf("El factorial del numero es: ""%d",factorial(n)); // Se imprime el resultado de la funcion factorial

    return 0;
}
