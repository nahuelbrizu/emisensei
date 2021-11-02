let num = 0;
let count = 0;
let suma = 1;
let j = 2;
let i;
let primo = [];
let lista = [];
let pares = [];
let impares = [];

while ( num < 100 ){
    num = num + suma;
    count = count + 1;
    lista.push(num);
}
for (i = 0; i < lista.length; i++) {
    let numero = lista[i];
    if (numero % 2 != 1) {
       pares.push(numero);
    } else {
        impares.push(numero);
    }
    for (j = 2; j <= numero - 1; j++) {
        let resto = numero % j;
        if (resto == 0){
            break;
        }
        if (j == numero - 1){
            primo.push(numero);
        }
    }
}

console.log(lista);
console.log(impares);
console.log(pares);
console.log(primo);
// crear array de resultado
// recorrer la lista
// por cada numero N:
//     recorrer desde J: 2 hasta N - 1
//         sacar el resto del numero N / J
//         si ese resto es 0 -> break
//         si ese resto no es 0 -> continue
//         si J == N -1 push al array de resultado
//
// imprimir array de resultado
